package Vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.FieldView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private File f;

    public ImagePanel(File f){
        super(new GridBagLayout());
        this.f=f;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            BufferedImage image = ImageIO.read(f);
            ImageIcon image_background = new ImageIcon(image);
            g.drawImage(image_background.getImage(), 0, 0, getWidth(), getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
