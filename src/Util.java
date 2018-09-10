
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
public class Util {
    
    public static ArrayList<Icon> getImages(int size, File open)
    {
        ArrayList<Icon> result = new ArrayList<>();
        try {
            BufferedImage source;
            File file = open;
            if(file == null)
                source = ImageIO.read(new File("img/thien.jpg"));
            else
                source = ImageIO.read(open);
            
            
            int width = source.getWidth();
            int height = source.getHeight();
            int Wsize = width/3;
            int Hsize = height/3;
            
            for(int i = 0; i < 3; i++)
            {
                for(int j = 0; j <3; j++)
                {
                    BufferedImage img = source.getSubimage(j*Wsize, i*Hsize, Wsize, Hsize);
                    result.add(new ImageIcon(img.getScaledInstance(size, size, Image.SCALE_SMOOTH)));
                }

            }
            
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
