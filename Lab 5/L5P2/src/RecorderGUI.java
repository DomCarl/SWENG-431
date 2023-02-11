import gui.MyGUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecorderGUI extends JFrame {
    private JButton recordButton;
    private JButton stopButton;
    private JButton playButton;
    private MyGUI gui;
    private RecorderThread recorderThread;
    public RecorderGUI(MyGUI gui){ this.initComponents(); this.gui = gui; this.recorderThread = new RecorderThread(gui);}
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
        recorderThread = new RecorderThread(this.gui);
        recorderThread.setRecording(true);
        recorderThread.start();
    }
    private void stop(){
        System.out.println("Stopping!");
        recorderThread.setRecording(false);


        // Code to stop
    }
    private void play(){
        System.out.println("Playing!");
        PlayThread playThread = new PlayThread(recorderThread.getEvents(), recorderThread.getDeltas());
        playThread.start();
        // Code to play
    }

}
