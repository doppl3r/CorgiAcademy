import buttons.DropDownButton;
import textures.SpriteSheet;

public class Level1 extends Level {

    public Level1(){
        //java version
        int[][] map=
            {{1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,2,1,1,1,1},
            {1,1,1,1,1,2,1,1,1,1},
            {1,1,1,1,1,2,1,1,1,1},
            {1,2,2,2,2,3,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}};
        setLevel(map);
        options.add(new DropDownButton(Window.tt,532,121,4,true));
        options.add(new DropDownButton(Window.tt,532,221,3,true));
        corgi.setPosition(1,4);
        gui = new SpriteSheet(Window.tt.img_level1,1,1,0);
        gui.update(420,100);
    }
    public void update(double mod){
        double xDir = 0;
        double yDir = 0;
        double speed = 2;


        if (playLevel()){
            //option 1
            System.out.println(tileBuffer.getMap().getTile((int)(corgi.getY()/blockSize),
                (int)(corgi.getX()/blockSize)).getID());
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
                    //limit--;
                    //System.out.println(limit);
                    if (limit >= 0){
                        corgi.x += xDir;
                        corgi.y += yDir;
                        corgi.sprite.update(corgi.x,corgi.y);
                    }
                    else{
                        //setPlayLevel(false);
                        if (currentOption < 1) currentOption++;
                        else{ setPlayLevel(false); currentOption = 0; }
                        corgi.x = ((corgi.x+(blockSize/2))/blockSize)*blockSize;
                        corgi.y = ((corgi.y+(blockSize/2))/blockSize)*blockSize;
                    }
            }
            else{
                //setPlayLevel(false);
                if (currentOption < 1) currentOption++;
                else{ setPlayLevel(false); currentOption = 0; }
                corgi.x = ((corgi.x+(blockSize/2))/blockSize)*blockSize;
                corgi.y = ((corgi.y+(blockSize/2))/blockSize)*blockSize;
            }
            //option 2

        }
    }
}
