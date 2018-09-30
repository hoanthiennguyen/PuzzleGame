
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class ImageUtil {
    
    public static ArrayList<Icon> getImages(int gameSzie, File open) {
        ArrayList<Icon> result = new ArrayList<>();
        int iconSize = 300/gameSzie;
        try {
            BufferedImage source  = ImageIO.read(open);

            int width = source.getWidth();
            int height = source.getHeight();
            int Wsize = width / gameSzie;
            int Hsize = height / gameSzie;

            for (int i = 0; i < gameSzie; i++) {
                for (int j = 0; j < gameSzie; j++) {
                    BufferedImage img = source.getSubimage(j * Wsize, i * Hsize, Wsize, Hsize);
                    result.add(new ImageIcon(img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH)));
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(ImageUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public static Icon getIcon(File f, int size)
    {
        try {
            BufferedImage img = ImageIO.read(f);
            return new ImageIcon(img.getScaledInstance(size, size, Image.SCALE_SMOOTH));
        } catch (IOException ex) {
            Logger.getLogger(ImageUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
