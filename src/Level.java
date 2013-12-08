import buttons.DropDownButton;
import buttons.Button;
import mapping.TileBuffer;
import textures.SpriteSheet;


import java.awt.*;
import java.util.LinkedList;

public class Level {
    SpriteSheet gui;
    LinkedList<DropDownButton> options;
    Button play;
    Corgi corgi;
    TileBuffer tileBuffer;
    int blockSize = 64;
    int currentOption = 0;
    int limit = 0;
    private SpriteSheet terrain;
    private SpriteSheet overlay;
    private boolean playLevel;

    public Level(){
        //java version
        options = new LinkedList<DropDownButton>();
        play = new Button(Window.tt.play,520,382,1,2,false,0);
        tileBuffer = new TileBuffer(blockSize);
        corgi = new Corgi(blockSize);
        terrain = new SpriteSheet(Window.tt.textures,2,2,0.0);
        overlay = new SpriteSheet(Window.tt.overlay,1,1,0);
        //overlay.update(0,0,640,640);
    }
    public void draw(Graphics2D g){
        tileBuffer.draw(g,terrain);
        overlay.draw(g);
        corgi.draw(g);
        gui.draw(g);
        for (int i = options.size()-1; i >= 0 ; i--){
            options.get(i).draw(g);
        }
        play.draw(g);
    }
    public void update(double mod){
        tileBuffer.update(0,0,blockSize,0,mod);
        corgi.update(mod);
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
        for (int i=0; i < options.size(); i++){
            options.get(i).up(x, y);
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
}
