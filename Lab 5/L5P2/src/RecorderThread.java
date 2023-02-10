import gui.MyGUI;
import javafx.util.Pair;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecorderThread extends Thread{
    private MyGUI gui;
    private ArrayList<AWTEvent> events = new ArrayList<>();
    public RecorderThread(MyGUI gui){this.gui = gui;}
    @Override
    public void run() {

        gui.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("Mouse Moved");
                events.add(e);
            }
        });

        gui.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                events.add(e);
                System.out.println("Mouse Clicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        gui.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Key Pressed!");
                events.add(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        gui.getRootPane().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Test");
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        super.run();
    }

}
