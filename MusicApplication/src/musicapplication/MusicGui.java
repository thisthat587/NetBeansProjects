package musicapplication;

import javax.swing.*;
import java.awt.*;
public class MusicGui extends JFrame {

    public MusicGui() {
        setVisible(true);
        setLocation(600, 400);
        setPreferredSize(new Dimension(580,200));
        setResizable(false);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playPause = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        next = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        playPause.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        playPause.setText("Play / Pause");
        playPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPauseActionPerformed(evt);
            }
        });
        getContentPane().add(playPause, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, 42));

        previous.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        previous.setText("Previous");
        getContentPane().add(previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 110, 42));

        stop.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        stop.setText("Stop");
        getContentPane().add(stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 101, 42));

        next.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        next.setText("Next");
        getContentPane().add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 85, 42));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPauseActionPerformed
    }//GEN-LAST:event_playPauseActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MusicGui();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton next;
    private javax.swing.JButton playPause;
    private javax.swing.JButton previous;
    private javax.swing.JButton stop;
    // End of variables declaration//GEN-END:variables
}
