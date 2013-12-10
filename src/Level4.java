import buttons.DropDownButton;
import textures.SpriteSheet;

public class Level4 extends Level {

    public Level4(){
        //java version
        int[][] map=
                {{1,1,1,1,1,1,1,1,1,1},
                {1,2,1,1,2,2,1,1,1,1},
                {1,1,3,2,2,2,1,1,1,1},
                {1,2,2,2,1,2,1,1,1,1},
                {1,2,2,2,2,2,1,1,1,1},
                {1,2,2,2,2,1,1,1,1,1},
                {1,2,1,1,2,2,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1}};
        setLevel(map);
        //change these
        text.add(new specialText(560,117,"up"));
        options.add(new DropDownButton(Window.tt,512,139,3,true));
        text.add(new specialText(560,170,"up"));
        options.add(new DropDownButton(Window.tt,512,192,4,true));
        text.add(new specialText(560,224,"up"));
        options.add(new DropDownButton(Window.tt,512,247,2,true));
        text.add(new specialText(560,278,"up"));
        options.add(new DropDownButton(Window.tt,512,302,1,true));
        corgi.setPosition(1,5);
        //don't change these
        gui = new SpriteSheet(Window.tt.img_level4,1,1,0);
        gui.update(400,100);
    }
}
