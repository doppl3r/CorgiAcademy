import audio.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements KeyListener,
        MouseListener, MouseMotionListener, Runnable {
	private static final long serialVersionUID = 1L;
    private boolean paused; //pause option
    private int panelState; //displays menus individually
    private double now;
    private double then;
    private double mod;
    private double delta;
    private double pixelsPerSecond;
    private double mLastTime;
    private int frameSamplesCollected = 0;
    private int frameSampleTime = 0;
    private int fps = 0;
    private int hoverX;
    private int hoverY;
    private Font font;
    BufferedImage buffered;
    public MainMenu menu;
    public Game game;
	private Timer t;
	
	public Panel(){
        panelState = 0; //start at editor
        pixelsPerSecond = 100; //very important for computer speed vs. graphic speed
        font = new Font ("Arial", Font.BOLD, 18);
        menu = new MainMenu();
        game = new Game();

        //start music
        //AudioHandler.SELECT.clip.loop(-1);

		//set listeners and thread
		addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
		setFocusable(true);
		run();
	}
	public void run(){
		t = new Timer(1000/60, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                updateMod(true);
                //update components
				update(mod);
				repaint();
                //final update of mod value
                updateMod(false);
			}
		});
		t.start();
	}
	public void paintComponent(Graphics g1){ //alt for paint
        //convert to Graphics2D
        Graphics2D g = (Graphics2D)g1;
        super.paintComponent(g);
        setBackground(new Color(43,43,43));
        //draw components
        //g.drawString("fps: "+fps,4,16);
        //draw components
        if (!paused){
            switch(panelState){
                case(0): menu.draw(g); break;
                case(1): game.draw(g); break;
            }
        }
        //updateFPS(); //updatesfps after drawn completely
        //g.drawString("x: "+hoverX+", y: "+hoverY,4,16);
	}
	public void update(double mod){
		//update the components
        if (!paused){
            switch(panelState){
                case(0): menu.update(mod); break;
                case(1): game.update(mod); break;
            }
        }
	}
	//key bindings
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
        switch(panelState){
            case(0): break;
            case(1): //editor keybindings
                if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) { game.keyUpPressed(); }
                if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) { game.keyRightPressed(); }
                if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) { game.keyDownPressed(); }
                if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) { game.keyLeftPressed(); }
                if (key == KeyEvent.VK_ESCAPE){  }
                if (key == KeyEvent.VK_F12){  }
           break;
        }
	}
	public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch(panelState){
            case(0): break;
            case(1): //editor keybindings
                if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) { game.keyUpReleased(); }
                if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) { game.keyRightReleased(); }
                if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) { game.keyDownReleased(); }
                if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) { game.keyLeftReleased(); }
            break;
        }
    }
	public void keyTyped(KeyEvent arg0) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { //down
        int x = e.getX();
        int y = e.getY();
        switch(panelState){
            case(0): menu.down(x,y); break;
            case(1): game.down(x,y); break;
        }
    }
    public void mouseDragged(MouseEvent e) { //move
        int x = e.getX();
        int y = e.getY();
        switch(panelState){
            case(0): menu.move(x,y); break;
            case(1): game.move(x,y); break;
        }

    }
    public void mouseReleased(MouseEvent e) { //up
        int x = e.getX();
        int y = e.getY();
        switch(panelState){
            case(0): menu.up(x,y); break;
            case(1): game.up(x,y); break;
        }
    }
    public void mouseMoved(MouseEvent e) { //hover
        //update cursor
        int x = e.getX();
        int y = e.getY();
        hoverX=x;
        hoverY=y;
        switch(panelState){
            case(0): menu.hover(x,y); break;
            case(1): game.hover(x,y); break;
        }
    }
    //update FPS
    public void updateFPS() {
        long tempNow = System.currentTimeMillis();
        if (mLastTime != 0) {
            int time = (int) (tempNow - mLastTime);
            frameSampleTime += time;
            frameSamplesCollected++;
            if (frameSamplesCollected == 10) {
                if (frameSampleTime != 0)
                    fps = (10000 / frameSampleTime);
                frameSampleTime = 0;
                frameSamplesCollected = 0;
            }
        }
        mLastTime = tempNow;
    }
    public void updateMod(boolean start){
        if (start){
            //first update module value
            now = System.currentTimeMillis();
            delta = (now - then)/1000;
            mod = delta*pixelsPerSecond;
        } else then = now;
    }
    public void setPanelState(int i){ panelState = i; }
}
