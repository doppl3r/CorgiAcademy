import mapping.TileBuffer;
import textures.SpriteSheet;

import java.awt.*;

public class Level {
    TileBuffer tileBuffer;
    SpriteSheet terrain;

    public Level(){
        //java version
        tileBuffer = new TileBuffer();
        terrain = new SpriteSheet(Window.tt.textures,2,2,0.0);
    }
    public void draw(Graphics2D g){
        tileBuffer.draw(g,terrain);
    }
    public void update(double mod){
        tileBuffer.update(0,0,terrain.getSpriteWidth(),0,mod);
    }
    public void setLevel(int[][] map){ tileBuffer.setMap(map); }
}
