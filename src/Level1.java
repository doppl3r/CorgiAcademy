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
        options.add(new DropDownButton(Window.tt,532,121));
        corgi.setPosition(1,4);
        gui = new SpriteSheet(Window.tt.img_level1,1,1,0);
        gui.update(420,100);
    }
    public void update(double mod){
        /*if (playLevel()) {
            setPlayLevel(false);
            System.out.println("hey");
        }*/
    }
}
