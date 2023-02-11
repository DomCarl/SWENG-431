import gui.MyGUI;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecorderThread extends Thread{
    private MyGUI gui;
    private ArrayList<AWTEvent> events = new ArrayList<>();
    private ArrayList<Long> deltas = new ArrayList<>();
    private boolean recording = false;
    public RecorderThread(MyGUI gui){this.gui = gui;}
    @Override
    public void run() {

        gui.getToolkit().addAWTEventListener(new AWTEventListener() {
            @Override
            public void eventDispatched(AWTEvent event) {
                if(recording){
                    events.add(event);
                    deltas.add(System.currentTimeMillis());
                }
            }
        }, AWTEvent.MOUSE_MOTION_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK | AWTEvent.KEY_EVENT_MASK);

        super.run();
    }

    public void setRecording(boolean recording) {
        this.recording = recording;
    }

    public ArrayList<AWTEvent> getEvents()
    {
        return this.events;
    }

    public ArrayList<Long> getDeltas() {
        return deltas;
    }
}