import buttons.DropDownButton;
import textures.SpriteSheet;

public class Level3 extends Level {

    public Level3(){
        //java version
        int[][] map=
                {{1,1,1,1,1,1,1,1,1,1},
                {1,2,2,1,1,1,1,1,1,1},
                {1,1,2,1,1,1,1,1,1,1},
                {1,1,2,1,1,1,1,1,1,1},
                {1,1,2,2,2,1,1,1,1,1},
                {1,1,1,1,2,1,1,1,1,1},
                {1,1,1,1,2,3,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1}};
        setLevel(map);
        //change these
        text.add(new specialText(590,134,"up"));
        options.add(new DropDownButton(Window.tt,528,140,2,false));
        text.add(new specialText(590,171,"up"));
        options.add(new DropDownButton(Window.tt,528,176,2,false));
        corgi.setPosition(1,1);
        //don't change these
        gui = new SpriteSheet(Window.tt.img_level3,1,1,0);
        gui.update(400,100);
    }
}
