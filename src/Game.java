import java.awt.*;

public class Game {
    private boolean gameOver;
    private LevelHandler world;
    //public EnemyHandler enemies;

    public Game(){
        world = new LevelHandler();
    }
    public void draw(Graphics2D g){
        world.draw(g);
    }
    public void update(double mod){
        world.update(mod);
    }

    //key pressed
    public void keyUpPressed(){  }
    public void keyDownPressed(){  }
    public void keyLeftPressed(){  }
    public void keyRightPressed(){  }

    //key released
    public void keyUpReleased(){  }
    public void keyDownReleased(){  }
    public void keyLeftReleased(){  }
    public void keyRightReleased(){  }

    //setGameOver
    public void setGameOver(boolean gameOver){ this.gameOver=gameOver; }
    public boolean isGameOver(){ return gameOver; }
}
