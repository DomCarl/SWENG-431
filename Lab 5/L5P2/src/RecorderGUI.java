import gui.MyGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class RecorderGUI extends JFrame {
    private JButton recordButton;
    private JButton stopButton;
    private JButton playButton;
    private MyGUI gui;
    public RecorderGUI(MyGUI gui){ this.initComponents(); this.gui = gui;}
    private void initComponents(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.recordButton = new JButton("Record");

        this.recordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecorderGUI.this.record();
            }
        });
        this.stopButton = new JButton("Stop");
        this.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecorderGUI.this.stop();
            }
        });
        this.playButton = new JButton("Play");
        this.playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecorderGUI.this.play();
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(recordButton)
                        .addComponent(stopButton)
                        .addComponent(playButton)
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(recordButton)
                                .addComponent(stopButton)
                                .addComponent(playButton)
                        )
        );
        this.pack();
    }

    private void record(){
        System.out.println("Recording!");
        RecorderThread recorderThread = new RecorderThread(this.gui);
        recorderThread.start();

    }
    private void stop(){
        System.out.println("Stopping!");
        // Code to stop
    }
    private void play(){
        System.out.println("Playing!");
        // Code to play
    }

}
