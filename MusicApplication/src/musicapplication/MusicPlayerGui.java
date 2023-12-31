package musicapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;

public class MusicPlayerGui extends JFrame {

    private String[] filePath;// = new String[10];//{"C:\\Users\\Piyush Singh\\Downloads\\Marham (Pehle Bhi Main) [128 Kbps]-(SongsPk.com.se).wav"};
    private File[] selectedFiles;
    private File audioFile;
    private Clip clip;
    private AudioInputStream audioStream;
    private String text;
    private boolean isPlaying = false;
    private long audioLength;
    private long audioPosition;
    private int progress = 0;
    private JFileChooser fileChooser;
    private int result;
    private int i = 0;
    private ProgressBar progressBar1;

    public MusicPlayerGui() {
        super("Music Application");
        progressBar1 = new ProgressBar();
        setVisible(true);
        setResizable(false);
        initComponents();
        setLocation(600, 200);
    }

    public class ProgressBar extends Thread {

        public void run() {
            while (clip.isRunning()) {
                try {
                    audioPosition = clip.getMicrosecondPosition();
                    progress = (int) ((audioPosition * 100) / audioLength);
                    progressBar.setValue(progress);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void loadMusic() {
        try {
            audioFile = new File(filePath[i]);
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            audioLength = clip.getMicrosecondLength();
        } catch (Exception e) {
            System.out.println(e);
            progressBar.setValue(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playPause = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        restart = new javax.swing.JButton();
        next = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        chooseFile = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        playPause.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        playPause.setText("Play ");
        playPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPauseActionPerformed(evt);
            }
        });

        previous.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        previous.setText("Previous");

        restart.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        restart.setText("Restart");
        restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartActionPerformed(evt);
            }
        });

        next.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        chooseFile.setText("Choose file");
        chooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileActionPerformed(evt);
            }
        });

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playPause, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(restart, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chooseFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playPause, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restart, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPauseActionPerformed
        if (!clip.isRunning()) {
            clip.start();
            progressBar1.start();
            playPause.setText("Pause");

        } else if (clip.isRunning()) {
            clip.stop();
            playPause.setText("Play");
        }
    }//GEN-LAST:event_playPauseActionPerformed

    private void restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartActionPerformed
        clip.setMicrosecondPosition(0);
        progressBar1.start();
    }//GEN-LAST:event_restartActionPerformed

    private void chooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileActionPerformed
        fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a music file");
        fileChooser.setMultiSelectionEnabled(true);
        result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFiles = fileChooser.getSelectedFiles();
            filePath = new String[selectedFiles.length];
            for (int j = 0; j < selectedFiles.length; j++) {
                filePath[j] = selectedFiles[j].getAbsolutePath();
            }
            loadMusic();
        }
    }//GEN-LAST:event_chooseFileActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        playPause.setText("Pause");
        if (!clip.isRunning()) {
            if (i >= filePath.length) {
                i = 0;
            }
            clip.stop();
            clip.close();
            loadMusic();
            clip.start();
            i++;
            progressBar1.start();

        } else if (clip.isRunning()) {
            if (i >= filePath.length) {
                i = 0;
            } else if (i == 0) {
                i++;
            }
            clip.stop();
            clip.close();
            loadMusic();
            clip.start();
            i++;
            progressBar1.start();
        }

    }//GEN-LAST:event_nextActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MusicPlayerGui();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseFile;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JButton next;
    private javax.swing.JButton playPause;
    private javax.swing.JButton previous;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton restart;
    // End of variables declaration//GEN-END:variables
}
