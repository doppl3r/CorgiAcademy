import buttons.DropDownButton;
import buttons.Button;
import mapping.TileBuffer;
import textures.SpriteSheet;


import java.awt.*;
import java.util.LinkedList;

public class Level {
    SpriteSheet gui;
    LinkedList<DropDownButton> options;
    LinkedList<specialText> text;
    Button play;
    Button next;
    Button reset;
    Corgi corgi;
    TileBuffer tileBuffer;
    int blockSize = 64;
    int currentOption = 0;
    int newOption = 0;
    int limit = 0;
    private SpriteSheet terrain;
    private SpriteSheet overlay;
    private boolean playLevel;

    public Level(){
        //java version
        options = new LinkedList<DropDownButton>();
        text = new LinkedList<specialText>();
        play = new Button(Window.tt.play,520,382,1,2,false,0);
        next = new Button(Window.tt.next,520,382,1,2,false,0);
        reset = new Button(Window.tt.reset,520,382,1,2,false,0);
        tileBuffer = new TileBuffer(blockSize);
        corgi = new Corgi(blockSize);
        terrain = new SpriteSheet(Window.tt.textures,2,2,0.0);
        overlay = new SpriteSheet(Window.tt.overlay,1,1,0);
    }
    public void draw(Graphics2D g){
        tileBuffer.draw(g,terrain);
        overlay.draw(g);
        corgi.draw(g);
        gui.draw(g);
        if(!text.isEmpty()){
            for (int j = text.size()-1; j >= 0; j--){
                text.get(j).draw(g);
            }
        }
        for (int i = options.size()-1; i >= 0 ; i--){
            options.get(i).draw(g);
        }
        play.draw(g);
    }
    public void update(double mod){
        double xDir = 0;
        double yDir = 0;
        double speed = 2;

        if (playLevel()){
            //option 1
            switch (options.get(currentOption).getCurrentIndex()){
                case(1): xDir = 0; yDir = -speed; break; //up
                case(2): xDir =  speed; yDir = 0; break; //right
                case(3): xDir = 0; yDir =  speed; break; //down
                case(4): xDir = -speed; yDir = 0; break; //left
            }
            //while loop
            if (tileBuffer.getMap().getTile(((corgi.getY())/blockSize),
                    ((corgi.getX())/blockSize)).getID() != 1 &&
                    tileBuffer.getMap().getTile(((corgi.getY()+63)/blockSize),
                            ((corgi.getX()+63)/blockSize)).getID() != 1){

                if (options.get(currentOption).isForLoop()){
                    limit--;
                    if (limit <= 0){
                        if (currentOption == newOption){  //set limit
                            limit=(int)((options.get(currentOption)
                                    .getAmount()*blockSize)/speed);
                            newOption = currentOption + 1;
                        }
                        else { //if the limit is reached
                            corgi.x = ((corgi.x+(blockSize/2))/blockSize)*blockSize;
                            corgi.y = ((corgi.y+(blockSize/2))/blockSize)*blockSize;
                            if (currentOption < options.size()-1) currentOption++;
                            else{
                                if (tileBuffer.getMap().getTile(((corgi.getY())/blockSize),
                                        ((corgi.getX())/blockSize)).getID() == 3 &&
                                        tileBuffer.getMap().getTile(((corgi.getY()+63)/blockSize),
                                                ((corgi.getX()+63)/blockSize)).getID() == 3){
                                    if (currentOption == options.size()-1){
                                        Window.panel.game.levels.nextLevel();
                                    }
                                }
                                else{
                                    corgi.reset();
                                }
                                setPlayLevel(false);
                                currentOption = newOption = 0;
                            }
                        }
                    }
                    else { //keep moving if the limit is greater than zero
                        corgi.x += xDir;
                        corgi.y += yDir;
                        corgi.sprite.update(corgi.x,corgi.y);
                    }
                }
                else {
                    corgi.x += xDir;
                    corgi.y += yDir;
                    corgi.sprite.update(corgi.x,corgi.y);
                }
            }
            else{
                //setPlayLevel(false);
                corgi.x = ((corgi.x+(blockSize/2))/blockSize)*blockSize;
                corgi.y = ((corgi.y+(blockSize/2))/blockSize)*blockSize;
                limit = 0;
                if (currentOption < options.size()-1){
                    currentOption++;
                    newOption = currentOption;
                }
                else{
                    if (tileBuffer.getMap().getTile(((corgi.getY())/blockSize),
                            ((corgi.getX())/blockSize)).getID() == 3 &&
                            tileBuffer.getMap().getTile(((corgi.getY()+63)/blockSize),
                                    ((corgi.getX()+63)/blockSize)).getID() == 3){
                        if (currentOption == options.size()-1){
                            Window.panel.game.levels.nextLevel();
                        }
                    }
                    else{
                        corgi.reset();
                    }
                    setPlayLevel(false); currentOption = newOption = 0;
                }
            }
        }
    }
    public void setLevel(int[][] map){ tileBuffer.setMap(map); }
    public void down(int x, int y){
        for (int i=0; i < options.size(); i++){
            options.get(i).down(x, y);
        }
        play.down(x,y);
    }
    public void move(int x, int y){
        for (int i=0; i < options.size(); i++){
            options.get(i).move(x, y);
        }
        play.move(x,y);
    }
    public void up(int x, int y){
        int tempIndex = 0;
        for (int i=0; i < options.size(); i++){
            options.get(i).up(x, y);
            tempIndex = options.get(i).getCurrentIndex()-1;
            if(!text.isEmpty()){
                switch (tempIndex){
                    case (0): text.get(i).setString("up"); break;
                    case (1): text.get(i).setString("right"); break;
                    case (2): text.get(i).setString("down"); break;
                    case (3): text.get(i).setString("left"); break;
                }
            }
        }
        if (play.up(x,y)){
            playLevel = true;
        }
    }
    public void hover(int x, int y){
        for (int i=0; i < options.size(); i++){
            options.get(i).hover(x, y);
        }
        play.hover(x,y);
    }
    public boolean playLevel(){ return playLevel; }
    public void setPlayLevel(boolean playLevel){ this.playLevel=playLevel; }

    public class specialText{
        int x;
        int y;
        String name;
        Font font;

        public specialText(int x, int y, String name){
            this.x = x;
            this.y = y;
            this.name = name;
            font = new Font("Monospace", Font.PLAIN, 12);
        }

        public void draw(Graphics2D g){
            g.setColor(Color.white);
            g.setFont(font);
            g.drawString(name, x, y);
        }

        public void setString(String name){
            this.name = name;
        }
    }
}
