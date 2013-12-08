import java.awt.*;

public class Game {
    private boolean gameOver;
    private LevelHandler levels;
    public GUI gui;
    //public EnemyHandler enemies;

    public Game(){
        levels = new LevelHandler();
        gui = new GUI();
    }
    public void draw(Graphics2D g){
        levels.draw(g);
        gui.draw(g);
    }
    public void update(double mod){
        levels.update(mod);
        gui.update(mod);
    }
    //mouse input
    public void down(int x, int y){
        levels.down(x,y);
        gui.down(x,y);
    }
    public void move(int x, int y){
        levels.move(x,y);
        gui.move(x,y);
    }
    public void up(int x, int y){
        levels.up(x,y);
        gui.up(x,y);
    }
    public void hover(int x, int y){
        levels.hover(x,y);
        gui.hover(x,y);
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
