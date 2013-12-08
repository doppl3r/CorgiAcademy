import buttons.DropDownButton;
import mapping.TileBuffer;
import textures.SpriteSheet;

import java.awt.*;
import java.util.LinkedList;

public class Level {
    SpriteSheet gui;
    LinkedList<DropDownButton> options;
    private TileBuffer tileBuffer;
    private SpriteSheet terrain;
    private SpriteSheet overlay;

    public Level(){
        //java version
        options = new LinkedList<DropDownButton>();
        tileBuffer = new TileBuffer();
        terrain = new SpriteSheet(Window.tt.textures,2,2,0.0);
        overlay = new SpriteSheet(Window.tt.overlay,1,1,0);
        overlay.update(0,0,640,640);
    }
    public void draw(Graphics2D g){
        tileBuffer.draw(g,terrain);
        overlay.draw(g);
        gui.draw(g);
        for (int i = 0; i < options.size(); i++){
            options.get(i).draw(g);
        }
    }
    public void update(double mod){
        tileBuffer.update(0,0,terrain.getSpriteWidth(),0,mod);
    }
    public void setLevel(int[][] map){ tileBuffer.setMap(map); }
    public void down(int x, int y){
        for (int i=0; i < options.size(); i++){
            options.get(i).down(x, y);
        }
    }
    public void move(int x, int y){
        for (int i=0; i < options.size(); i++){
            options.get(i).move(x, y);
        }
    }
    public void up(int x, int y){
        for (int i=0; i < options.size(); i++){
            options.get(i).up(x, y);
        }
    }
    public void hover(int x, int y){
        for (int i=0; i < options.size(); i++){
            options.get(i).hover(x, y);
        }
    }
}
