import gui.*;
public class MyProg {
    public static void main(String[] args) {
        MyGUI gui = new MyGUI();
        gui.setSize(400,400);
        gui.setVisible(true);

        RecorderGUI recorderGUI = new RecorderGUI(gui);
        recorderGUI.setVisible(true);
    }
}
