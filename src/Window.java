import textures.Textures;
import javax.swing.*;
import java.awt.*;
import audio.*;

public class Window {
    static JFrame jf;
    static Textures tt;
    static Panel panel;
    static int originalWidth;
    static int originalHeight;
    static String title;
    static String version;

    public Window(){
        //change ui for jFileChooser + other UI settings
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (ClassNotFoundException e) { e.printStackTrace(); }
        catch (InstantiationException e) { e.printStackTrace(); }
        catch (IllegalAccessException e) { e.printStackTrace(); }
        catch (UnsupportedLookAndFeelException e) { e.printStackTrace(); }
        //construct frame and panel
        tt = new Textures();
        jf = new JFrame();
        originalWidth = 640;
        originalHeight = 480;
        panel = new Panel();
        title = "Corgi Academy - Rachel Pang";
        version = "v0.1";
        //build window
        panel.setPreferredSize(new Dimension(originalWidth,originalHeight));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setIconImage(tt.icon);
        jf.setTitle(title+" ["+version+"]");
        jf.getContentPane().add(panel);
        jf.setResizable(false);
        jf.pack();
        jf.setMinimumSize(new Dimension(jf.getWidth(),jf.getHeight()));
        jf.setLocationRelativeTo(null);
        jf.requestFocusInWindow();
        jf.setVisible(true);
        setCursor(3);
    }
    public static int getWindowWidth(){ return jf.getWidth(); }
    public static int getWindowHeight(){ return jf.getHeight(); }
    public static int getPanelWidth(){ return panel != null ? panel.getWidth() : originalWidth; }
    public static int getPanelHeight(){ return panel != null ? panel.getHeight() : originalHeight; }
    public static int getOriginalWidth(){ return originalWidth; }
    public static int getOriginalHeight(){ return originalHeight; }

    public static void setCursor(int type){
        switch(type){
            case(0): jf.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR)); break;
            case(1): jf.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR)); break;
            case(2): jf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); break;
            case(3): jf.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)); break;
        }
    }
}
