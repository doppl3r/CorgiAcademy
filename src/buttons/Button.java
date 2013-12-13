package buttons;
import java.awt.*;

import audio.AudioHandler;
import textures.SpriteSheet;

public class Button {
	private boolean pressed;
	private boolean hide;
	private boolean center;
    private boolean showHint;
    private String hint;
	private SpriteSheet sprite;
    private Font font;
	private double x;
	private double y;
	private double xSize;
	private double ySize;
	private double padding;
    private int currentFrame;

	public Button(Image newImage, int x, int y, int hFrames, int vFrames,
            boolean center, int currentFrame){
		SpriteSheet newSprite = new SpriteSheet(newImage, hFrames, vFrames, 0.0);
		this.x=x;
		this.y=y;
		this.center=center;
        this.currentFrame=currentFrame;
        font = new Font("Arial", Font.PLAIN, 10);
		sprite = new SpriteSheet(newSprite.getImage(), 
				newSprite.getHFrames(), newSprite.getVFrames(), newSprite.getRate());
		xSize = sprite.getSpriteWidth();
		ySize = sprite.getSpriteHeight();
		if (center) sprite.center();
		sprite.update(x, y);
        sprite.animate(currentFrame);
		padding=0;
        hint = "";
	}
	public void draw(Graphics2D g){
		if (!hide) sprite.draw(g);
        if (showHint){
            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString(hint, 4,40);
        }
	}
	public void resize(int newWidth, int newHeight){
		xSize=newWidth;
		ySize=newHeight;
		sprite.resize(newWidth, newHeight);
		sprite.update(x, y);
	}
	public void resize(double ratio){
		xSize *= ratio;
		ySize *= ratio;
		sprite.resize((int)xSize, (int)ySize);
		sprite.update(x, y);
	}
	public boolean down(int x1, int y1){
		if (!hide){
			if (center){
				if (Math.abs(x1-x) < ((xSize/2)+padding) && Math.abs(y1-y) < ((ySize/2)+padding)){
					pressed = true;
					sprite.animate(1+currentFrame, 0+currentFrame);
				} else { pressed = false; sprite.animate(0+currentFrame, 0+currentFrame); }
			}
			else{
				if (Math.abs(x1-x-(xSize/2)) < ((xSize/2)+padding) && Math.abs(y1-y-(ySize/2)) < ((ySize/2)+padding)){
					pressed = true;
					sprite.animate(1+currentFrame, 0+currentFrame);
				} else { pressed = false; sprite.animate(0+currentFrame, 0+currentFrame); }
			}
		}
		return pressed;
	}
	public boolean move(int x1, int y1){
		if (!hide) down(x1, y1);
		return pressed;
	}
	public boolean up(int x1, int y1){
		if (pressed && !hide){
			sprite.animate(0+currentFrame, 0+currentFrame);
			pressed = false;
			return true;
		}
		else return false; 
	}
    public boolean hover(int x1, int y1){
        if (!hide){
            if (move(x1, y1)){
                showHint = true;
            }
            else showHint = false;
        }
        return pressed;
    }
    public void setHint(String hint){
        this.hint=hint;
    }
	public void setPadding(int padding){ this.padding=padding; }
	public void hide(){ hide = true; }
	public void reveal(){ hide = false; }
	public void update(double x, double y){ 
		this.x=x;
		this.y=y;
		sprite.update(x, y); 
	}
    public void setImage(Image img){ sprite.setImage(img); }
    public Image getImage(){ return sprite.getImage(); }
	public boolean isPressed(){ return pressed; }
	public double getX(){ return x; }
	public double getY(){ return y; }
    public boolean isHidden(){ return hide; }
}
