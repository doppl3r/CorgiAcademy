package textures;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Textures {
    public Image overlay;
    public Image corgi;
    public Image textures;
    public Image icon;
    public Image img_level1;
    public Image img_level2;
    public Image img_level3;
    public Image img_level4;
    public Image img_level5;

    public Image buttonUP;
    public Image buttonRIGHT;
    public Image buttonDOWN;
    public Image buttonLEFT;
    public Image play;
    public Image next;
    public Image reset;

    public Textures(){
		addResources();
	}
	public void addResources(){
        overlay = new ImageIcon(this.getClass().getResource("/graphics/overlay.png")).getImage();
        textures = new ImageIcon(this.getClass().getResource("/graphics/textures.png")).getImage();
        corgi = new ImageIcon(this.getClass().getResource("/graphics/corgi.png")).getImage();
        icon = new ImageIcon(this.getClass().getResource("/gui/icon.png")).getImage();
        img_level1 = new ImageIcon(this.getClass().getResource("/gui/img_level1.png")).getImage();
        img_level2 = new ImageIcon(this.getClass().getResource("/gui/img_level2.png")).getImage();
        img_level3 = new ImageIcon(this.getClass().getResource("/gui/img_level3.png")).getImage();
        img_level4 = new ImageIcon(this.getClass().getResource("/gui/img_level4.png")).getImage();
        img_level5 = new ImageIcon(this.getClass().getResource("/gui/img_level5.png")).getImage();

        buttonUP = new ImageIcon(this.getClass().getResource("/gui/buttonUP.png")).getImage();
        buttonRIGHT = new ImageIcon(this.getClass().getResource("/gui/buttonRIGHT.png")).getImage();
        buttonDOWN = new ImageIcon(this.getClass().getResource("/gui/buttonDOWN.png")).getImage();
        buttonLEFT = new ImageIcon(this.getClass().getResource("/gui/buttonLEFT.png")).getImage();
        play = new ImageIcon(this.getClass().getResource("/gui/play.png")).getImage();
        next = new ImageIcon(this.getClass().getResource("/gui/next.png")).getImage();
        reset = new ImageIcon(this.getClass().getResource("/gui/reset.png")).getImage();
    }
}
