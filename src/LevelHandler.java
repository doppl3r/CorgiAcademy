import java.util.LinkedList;
import java.awt.*;

public class LevelHandler {
    private LinkedList<Level> levels;
    private int currentLevel;
    public LevelHandler(){
        levels = new LinkedList<Level>();
        initLevels();
    }
    public void draw(Graphics2D g){
        levels.get(currentLevel).draw(g);
    }
    public void update(double mod){
        levels.get(currentLevel).update(mod);
    }
    public void initLevels(){
        //level 1
        int[][] map=
                {{1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1},
                        {1,1,2,2,2,2,2,1,1,1},
                        {1,1,1,1,1,1,2,1,1,1},
                        {1,1,1,1,1,1,2,1,1,1},
                        {1,1,1,1,1,1,3,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1}};
        levels.add(new Level());
        levels.get(levels.size()-1).setLevel(map);
        //level 2
    }
}
