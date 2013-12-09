import buttons.DropDownButton;
import textures.SpriteSheet;

public class Level4 extends Level {

    public Level4(){
        //java version
        int[][] map=
                {{1,1,1,1,1,1,1,1,1,1},
                {1,2,2,2,2,2,1,1,1,1},
                {1,2,3,2,2,2,1,1,1,1},
                {1,2,2,2,2,2,1,1,1,1},
                {1,2,2,2,2,2,1,1,1,1},
                {1,2,2,2,2,2,1,1,1,1},
                {1,2,2,2,2,2,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1}};
        setLevel(map);
        //change these
        options.add(new DropDownButton(Window.tt,532,121,4,true));
        corgi.setPosition(1,4);
        //don't change these
        gui = new SpriteSheet(Window.tt.img_level1,1,1,0);
        gui.update(400,100);
    }
    public void update(double mod){
        double xDir = 0;
        double yDir = 0;
        double speed = 2;

        if (playLevel()){
            //option 1
            switch (options.get(currentOption).getCurrentIndex()){
                case(1): xDir = 0; yDir = -speed; break; //up
                case(2): xDir =  speed; yDir = 0; break; //right
                case(3): xDir = 0; yDir =  speed; break; //down
                case(4): xDir = -speed; yDir = 0; break; //left
            }
            //while loop
            if (tileBuffer.getMap().getTile((int)((corgi.getY())/blockSize),
                    (int)((corgi.getX())/blockSize)).getID() != 1 &&
                    tileBuffer.getMap().getTile((int)((corgi.getY()+63)/blockSize),
                            (int)((corgi.getX()+63)/blockSize)).getID() != 1){

                if (options.get(currentOption).isForLoop()){
                    limit--;
                    if (limit <= 0){
                        if (currentOption == newOption){  //set limit
                            limit=(int)((options.get(currentOption)
                                    .getAmount()*blockSize)/speed);
                            newOption = currentOption + 1;
                        }
                        else { //if the limit is reached
                            corgi.x = ((corgi.x+(blockSize/2))/blockSize)*blockSize;
                            corgi.y = ((corgi.y+(blockSize/2))/blockSize)*blockSize;
                            if (currentOption < options.size()-1) currentOption++;
                            else{
                                if (tileBuffer.getMap().getTile((int)((corgi.getY())/blockSize),
                                        (int)((corgi.getX())/blockSize)).getID() == 3 &&
                                        tileBuffer.getMap().getTile((int)((corgi.getY()+63)/blockSize),
                                                (int)((corgi.getX()+63)/blockSize)).getID() == 3){
                                    if (currentOption == options.size()-1){
                                        System.out.println("ChangeLevel");
                                    }
                                }
                                setPlayLevel(false);
                                currentOption = newOption = 0;
                            }
                        }
                    }
                    else { //keep moving if the limit is greater than zero
                        corgi.x += xDir;
                        corgi.y += yDir;
                        corgi.sprite.update(corgi.x,corgi.y);
                    }
                }
                else {
                    corgi.x += xDir;
                    corgi.y += yDir;
                    corgi.sprite.update(corgi.x,corgi.y);
                }
            }
            else{
                //setPlayLevel(false);
                corgi.x = ((corgi.x+(blockSize/2))/blockSize)*blockSize;
                corgi.y = ((corgi.y+(blockSize/2))/blockSize)*blockSize;
                limit = 0;
                if (currentOption < options.size()-1){
                    currentOption++;
                    newOption = currentOption;
                }
                else{
                    if (tileBuffer.getMap().getTile((int)((corgi.getY())/blockSize),
                            (int)((corgi.getX())/blockSize)).getID() == 3 &&
                            tileBuffer.getMap().getTile((int)((corgi.getY()+63)/blockSize),
                                    (int)((corgi.getX()+63)/blockSize)).getID() == 3){
                        if (currentOption == options.size()-1){
                            System.out.println("ChangeLevel");
                        }
                    }
                    setPlayLevel(false); currentOption = newOption = 0;
                }
            }
        }
    }
}
