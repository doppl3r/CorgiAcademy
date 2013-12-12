import textures.SpriteSheet;
import buttons.Button;

import java.awt.*;

public class MainMenu {
    private double alpha;
    private double fadeRate;
    private int minFade;
    private int maxFade;
    private int alphaType;
    private int currentMenu = 0; //0=start, 1=end
    private boolean fadeOut;

    private SpriteSheet start_img;
    private Button start_button;
    private Button back_button;
    private SpriteSheet gameOver;

    public MainMenu(){
        fadeRate = 0.015;
        minFade = 0;
        maxFade = 1;
        alphaType = AlphaComposite.SRC_OVER;

        start_button = new Button(Window.tt.start_button,50,50,1,2,false,0);
        back_button  = new Button(Window.tt.back_button,256,360,1,2,false,0);
        start_img = new SpriteSheet(Window.tt.start_img,1,1,0);
        gameOver = new SpriteSheet(Window.tt.gameOver,1,1,0);
        gameOver.update(192,64); //center game over
    }
    public void draw(Graphics2D g){
        //g.drawImage(Window.tt.title, (int)(Math.random()*5),(int)(Math.random()*5),null);
        g.setComposite(AlphaComposite.getInstance(alphaType, (float)alpha));
        //g.drawImage(Window.tt.zombieLarge, 230+(int)(Math.random()*10),5+(int)(Math.random()*10),null);
        switch (currentMenu){
            case(0): //start menu
                start_img.draw(g);
                start_button.draw(g);
            break;
            case(1): //game over menu
                gameOver.draw(g);
                back_button.draw(g);
            break;
        }

        g.setComposite(AlphaComposite.getInstance(alphaType, 1.0f));
    }
    public void update(double mod){
        //fade the zombie
        if (fadeOut){
            //if (alpha - fadeRate > minFade) alpha-=fadeRate;
            //else{ alpha = minFade; fadeOut = false; }
        }
        else {
            if (alpha + fadeRate < maxFade) alpha+=fadeRate;
            else{ alpha = maxFade; fadeOut = true; }
        }
    }
    public void loadGame(){
        Window.panel.setPanelState(1);
    }
    public void down(int x, int y){
        switch(currentMenu){
            case(0): start_button.down(x,y); break;
            case(1): back_button.down(x,y); break;
        }
    }
    public void move(int x, int y){
        switch(currentMenu){
            case(0): start_button.move(x,y); break;
            case(1): back_button.move(x,y); break;
        }
    }
    public void up(int x, int y){
        switch(currentMenu){
            case(0):
                if (start_button.up(x,y)) {
                    //do something
                    currentMenu = 1;
                    Window.panel.setPanelState(1); //play game
                }
            break;
            case(1):
                if (back_button.up(x,y)) {
                    //do something
                    currentMenu = 0;
                    Window.panel.setPanelState(0); //go back to main menu
                }
            break;
        }
    }
    public void hover(int x, int y){
        switch(currentMenu){
            case(0): start_button.hover(x,y); break;
            case(1): back_button.hover(x,y); break;
        }
    }
    public void setCurrentMenu(int i){
        currentMenu = i; //0 = start, 1 = game over
    }
}
