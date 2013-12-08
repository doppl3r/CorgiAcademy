package buttons;

import textures.Textures;

import java.awt.*;
import java.util.LinkedList;

public class DropDownButton {
    private int x;
    private int y;
    private boolean active;
    LinkedList<Button> options;
    private int currIndex;

    public DropDownButton(Textures tt, int x, int y){
        options = new LinkedList<Button>();
        options.add(new Button(tt.buttonUP,x,y,1,4,false,0));
        options.add(new Button(tt.buttonUP,x,y+19,1,4,false,2));
        options.add(new Button(tt.buttonRIGHT,x,y+38,1,4,false,2));
        options.add(new Button(tt.buttonDOWN,x,y+57,1,4,false,2));
        options.add(new Button(tt.buttonLEFT,x,y+76,1,4,false,2));
        for (int i = 1; i < options.size(); i++) options.get(i).hide();
        this.x=x;
        this.y=y;
    }
    public void draw(Graphics2D g){
        for (int i = 0; i < options.size(); i++){
            options.get(i).draw(g);
        }
    }
    public void down(int x, int y){

    }
    public void move(int x, int y){

    }
    public boolean up(int x, int y){
        if (options.get(0).up(x,y)){
            for (int i = 1; i < options.size(); i++) options.get(i).reveal();
            active = true;
        }
        else {
            //check button actions here
            active = false;
            if (options.get(1).up(x,y)) currIndex = 1;
            if (options.get(2).up(x,y)) currIndex = 2;
            if (options.get(3).up(x,y)) currIndex = 3;
            if (options.get(4).up(x,y)) currIndex = 4;
            options.getFirst().setImage(options.get(currIndex).getImage());
            for (int i = 1; i < options.size(); i++) options.get(i).hide();

        }
        return active;
    }
    public void hover(int x, int y){
        for (int i=0; i < options.size(); i++){
            options.get(i).hover(x,y);
        }
    }
}
