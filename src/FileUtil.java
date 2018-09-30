
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class FileUtil {
    static final String fileName = "dir";
    public static String getCurrentDirectory()
    {
        String result = null;
        FileReader reader;
        try {
            reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);
            result = br.readLine();
            
        } catch (Exception ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public static void writeCurrentDirectory(String currentDirectory)
    {
        if(currentDirectory != null)
        {
            try (PrintWriter pw = new PrintWriter(fileName)) {
                pw.write(currentDirectory);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
