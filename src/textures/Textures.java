package textures;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Textures {
    public Image textures;
    public Image icon;

    public Textures(){
		addResources();
	}
	public void addResources(){
        textures = new ImageIcon(this.getClass().getResource("/graphics/textures.png")).getImage();
        icon = new ImageIcon(this.getClass().getResource("/gui/icon.png")).getImage();
    }
}
