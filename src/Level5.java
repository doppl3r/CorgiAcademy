import buttons.DropDownButton;
import textures.SpriteSheet;

public class Level5 extends Level {

    public Level5(){
        //java version
        int[][] map=
                {{1,1,1,1,1,1,1,1,1,1},
                {1,2,2,2,2,3,1,1,1,1},
                {1,2,1,1,1,1,1,1,1,1},
                {1,2,1,2,2,2,1,1,1,1},
                {1,2,1,2,1,2,1,1,1,1},
                {1,2,1,1,1,2,1,1,1,1},
                {1,2,2,2,2,2,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1}};
        setLevel(map);
        //change these
        text.add(new specialText(590,133,"up"));
        options.add(new DropDownButton(Window.tt,529,139,4,false));
        text.add(new specialText(590,169,"up"));
        options.add(new DropDownButton(Window.tt,529,176,4,false));
        text.add(new specialText(590,206,"up"));
        options.add(new DropDownButton(Window.tt,529,212,4,false));
        text.add(new specialText(590,242,"up"));
        options.add(new DropDownButton(Window.tt,529,248,4,false));
        text.add(new specialText(590,133,"up"));
        options.add(new DropDownButton(Window.tt,529,139,4,false));
        text.add(new specialText(590,169,"up"));
        options.add(new DropDownButton(Window.tt,529,176,4,false));
        text.add(new specialText(590,206,"up"));
        options.add(new DropDownButton(Window.tt,529,212,4,false));
        text.add(new specialText(590,242,"up"));
        options.add(new DropDownButton(Window.tt,529,248,4,false));
        corgi.setPosition(3,4);
        //don't change these
        gui = new SpriteSheet(Window.tt.img_level5,1,1,0);
        gui.update(400,100);
    }
}
