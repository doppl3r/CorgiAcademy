import buttons.DropDownButton;
import textures.SpriteSheet;

public class Level2 extends Level {
    public Level2(){
        //java version
        int[][] map=
                {{1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1},
                {1,2,2,2,2,2,1,1,1,1},
                {1,1,1,1,1,2,1,1,1,1},
                {1,1,1,1,1,2,1,1,1,1},
                {1,1,1,1,1,3,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1}};
        setLevel(map);
        //change these
        text.add(new specialText(560,115,"up"));
        options.add(new DropDownButton(Window.tt,495,122,2,false));
        text.add(new specialText(560,170,"up"));
        options.add(new DropDownButton(Window.tt,495,175,2,false));
//        options.add(new DropDownButton(Window.tt,532,221,2,true));
        corgi.setPosition(1,2);
        //don't change these
        gui = new SpriteSheet(Window.tt.img_level2,1,1,0);
        gui.update(400,100);
    }

}
