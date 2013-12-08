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
        levels.add(new Level1());
    }



    public void down(int x, int y){
        levels.get(currentLevel).down(x,y);
    }
    public void move(int x, int y){
        levels.get(currentLevel).move(x,y);
    }
    public void up(int x, int y){
        levels.get(currentLevel).up(x,y);
    }
    public void hover(int x, int y){
        levels.get(currentLevel).hover(x,y);
    }
}
