import buttons.DropDownButton;
import textures.SpriteSheet;

public class Level1 extends Level {

    public Level1(){
        //java version
        int[][] map=
            {{1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,2,2,2,2,3,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}};
        setLevel(map);
        //change these
        options.add(new DropDownButton(Window.tt,512,121,4,true));
        corgi.setPosition(1,4);
        //don't change these
        gui = new SpriteSheet(Window.tt.img_level1,1,1,0);
        gui.update(400,100);
    }
}
