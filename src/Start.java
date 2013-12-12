import buttons.DropDownButton;
import textures.SpriteSheet;

public class Start extends Level {

    public Start(){
        int[][] map=
                {{1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1}};
        setLevel(map);
        //change these
        options.add(new DropDownButton(Window.tt,532,164,3,false));

        corgi.setPosition(1,5);
        //don't change these
        gui = new SpriteSheet(Window.tt.img_level4,1,1,0);
        gui.update(400,100);

    }
}
