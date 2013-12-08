import textures.SpriteSheet;
import java.awt.*;

public class Corgi {
    private int x;
    private int y;
    private int blockSize;
    private SpriteSheet sprite;

    public Corgi(int blockSize){
        this.blockSize=blockSize;
        sprite = new SpriteSheet(Window.tt.corgi,1,1,0);
        sprite.update(0,0,Window.tt.corgi.getWidth(null),
            Window.tt.corgi.getHeight(null));
    }
    public void draw(Graphics2D g){
        sprite.draw(g);
    }
    public void update(double mod){

    }
    public void play(){

    }
    public void setXY(int x, int y){
        this.x=x;
        this.y=y;
        sprite.update(x,y);
    }
    public void setPosition(int col, int row){
        x=(col*blockSize);
        y=(row*blockSize);
        sprite.update(x,y);
    }
    public void setX(int x){ this.x=x; }
    public void setY(int y){ this.y=y; }

    public int getX(){ return x; }
    public int getY(){ return y; }
}
