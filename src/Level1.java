import buttons.DropDownButton;

public class Level1 extends Level {

    public Level1(){
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
        options.add(new DropDownButton(Window.tt,50,250));
    }
}
