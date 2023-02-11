import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PlayThread extends Thread{

    private ArrayList<AWTEvent> events;
    private ArrayList<Long> deltas;
    public PlayThread(ArrayList<AWTEvent> events, ArrayList<Long> deltas){this.events = events; this.deltas = deltas;}
    @Override
    public void run() {
        try {
            Robot robot = new Robot();
            robot.setAutoWaitForIdle(true);
            for (int i = 0; i < events.size() - 1; i++) {
                Long nextEventTime = deltas.get(i + 1);
                Long currentEventTime = deltas.get(i);
                if (events.get(i).getID() == MouseEvent.MOUSE_MOVED) {
                    MouseEvent me = (MouseEvent) events.get(i);
                    robot.mouseMove(me.getXOnScreen(), me.getYOnScreen());
                }
                if (events.get(i).getID() == MouseEvent.MOUSE_PRESSED) {
                    MouseEvent me = (MouseEvent) events.get(i);
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                }
                if(events.get(i).getID() == MouseEvent.MOUSE_RELEASED){
                    MouseEvent me = (MouseEvent) events.get(i);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                }
                if (events.get(i).getID() == KeyEvent.KEY_PRESSED) {
                    KeyEvent ke = (KeyEvent) events.get(i);
                    robot.keyPress(ke.getKeyCode());
                }
                if (events.get(i).getID() == KeyEvent.KEY_RELEASED) {
                    KeyEvent ke = (KeyEvent) events.get(i);
                    robot.keyRelease(ke.getKeyCode());
                }
                try {
                    Thread.sleep(nextEventTime - currentEventTime);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (AWTException e) {
            System.out.println(e);
        }
    }
}