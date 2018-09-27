
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class Gameboard extends JPanel{

    private int size;
    private int x, y;
    JLabel[] labels;
    boolean isShuffling;
    File imageSrc;
    public Gameboard(int size, File imageSrc) {
        this.size = size;
        this.setLayout(new GridLayout(0, size));
        this.imageSrc = imageSrc;
        this.setVisible(true);
        this.setSize(300, 300);
        start();
    }
    public void start()
    {
        reset();
        GridLayout gridLayout = (GridLayout)this.getLayout();
        gridLayout.setColumns(size);
        addComponents();
        shuffle();
    }
    public void reset()
    {
        this.removeAll();
        this.requestFocusInWindow();
        labels = new JLabel[size*size];
        x = size -1;
        y = size - 1;
    }
    public void setGameSize(int size)
    {
        this.size = size;
    }
    public void setImageSrc(File src)
    {
        this.imageSrc = src;
    }
    
    public void shuffle()
    {
        //move the blank square around randomly 10 times
        //its original position is top left (0,0)
        final String[] ARROWS = {"up","down","up","left","right","up","left"};
        isShuffling = true;
        for(int i = 0; i < 20; i++)
        {
            int random = (int) (Math.random()*6);
            update(ARROWS[random]);
        }
        isShuffling = false;
    }

    public void update(String arrow) {
        int currentPosition = y * size + x;
        switch (arrow) {
            case "up":
                if (y > 0) {
                    y--;
                }
                break;
            case "down":
                if (y < size - 1) {
                    y++;
                }
                break;
            case "left":
                if (x > 0) {
                    x--;
                }
                break;
            case "right":
                if (x < size - 1) {
                    x++;
                }
                break;
        }
        int nextPosition = y * size + x;
        
        changeIconAndText(labels[currentPosition], labels[nextPosition]);
        if ( !isShuffling && checkWin()) 
        {
            JOptionPane.showMessageDialog(null, "You won");
        }
    }
    private void changeIconAndText(JLabel isEmptyLabel, JLabel toBeEmptyLabel)
    {
        isEmptyLabel.setIcon(toBeEmptyLabel.getIcon());
        isEmptyLabel.setText(toBeEmptyLabel.getText());
        toBeEmptyLabel.setIcon(null);
        toBeEmptyLabel.setText(" ");
    }
    private boolean checkWin() {
        for (int i = 0; i < size*size -1; i++) {
            //check if each button text is equal its postion
            JLabel label = labels[i];
            if (!label.getText().equals(i + "")) {
                return false;
            }
        }
        
        return true;
    }
    private void addComponents()
    {
        ArrayList<Icon> icons = Util.getImages(size, imageSrc);
        JLabel label = null;
        for(int i = 0; i < size*size; i++)
        {
            label = new JLabel(i + "" ,icons.get(i),0);
            label.setForeground(label.getBackground());
            label.setFont(new Font("Arial", 0, 0));

            this.add(label);
            labels[i] = label;
        }
        label.setIcon(null);
        label.setText(" ");
    }

}
