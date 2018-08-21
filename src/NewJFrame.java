
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class NewJFrame extends javax.swing.JFrame {
    int size = 3;
    int row,col;
    
    GridLayout layout;
    //Array of JButton
    Component[] arr;
    
    //flag variable indicates whether programe is shuffling
    //if true, checkWin() shouldn't work
    boolean shuffling;
    final String[] ARROWS = {"left", "up", "right", "down"};
    
    public NewJFrame() {
        initComponents();
        layout = (GridLayout) panel.getLayout();   
        start();                
    }
    private void start()
    {
        panel.removeAll();
        panel.setFocusable(true);//to get event key pressed
        //reset position of blank square
        col = size-1; row = size-1;
        
        //set up layout 
        layout.setColumns(size);
        layout.setRows(0);        
        
        //add components        
        for(int i = 1; i < size*size; i++)
        {
            panel.add(new JButton(i+""));
        }
        panel.add(new JButton(" "));
        
        //update UI and shuffle
        arr = panel.getComponents();
        panel.updateUI();       
        shuffle();
    }
    private void shuffle()
    {
        //move the blank square around randomly 10 times
        //its original position is top left (0,0)
        shuffling = true;
        for(int i = 0; i < 20; i++)
        {
            int random = (int) (Math.random()*4);
            move(ARROWS[random]);
        }
        shuffling = false;
    }
    private boolean checkWin()
    {              
        for(int i =0; i < arr.length-1; i++)
        {
            //check if each button text is equal its postion + 1
            JButton btn = (JButton) arr[i];            
            if(!btn.getText().equals( (i+1) + ""))
            {                
                return false;                 
            }
               
        }        
        return true;        
    }
    //move blank square
    private void move(String arrow)
    {
        {
            int pos = row*size + col;
            switch(arrow)
            {
                case "up":
                    if(row > 0)row--;
                    break;
                case "down":
                    if(row < size -1)row++;
                    break;
                case "left":
                    if(col > 0 )col--;
                    break;
                case "right":
                    if(col < size -1) col++;
                    break;
            }
            int nextPos = row*size + col;
            JButton nextBtn = (JButton) arr[nextPos];
            JButton btn = (JButton) arr[pos];
            btn.setText(nextBtn.getText());
            nextBtn.setText(" ");
        }

        if(checkWin() && !shuffling)
            JOptionPane.showMessageDialog(this, "You won");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        cbSize = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelKeyPressed(evt);
            }
        });
        panel.setLayout(new java.awt.GridLayout(1, 0));

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        cbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3x3", "4x4" }));
        cbSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSizeActionPerformed(evt);
            }
        });

        jLabel1.setText("Size");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStart)
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart)
                    .addComponent(cbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSizeActionPerformed
        // TODO add your handling code here:
        int index = cbSize.getSelectedIndex();
        if(index == 0) 
            size = 3;
        else 
            size = 4;
    }//GEN-LAST:event_cbSizeActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        start();
        
    }//GEN-LAST:event_btnStartActionPerformed

    private void panelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelKeyPressed
        // TODO add your handling code here:
        int cc = evt.getKeyCode();
        if(cc >= 37 && cc <= 40)
            move(ARROWS[cc-37]);
    }//GEN-LAST:event_panelKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewJFrame frame = new NewJFrame();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JComboBox<String> cbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
