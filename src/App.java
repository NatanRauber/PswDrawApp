// package drawapp;

import gui.Frame;

public class App {
    public static void main(String[] args) {
        try {
            Frame frame = new Frame();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
