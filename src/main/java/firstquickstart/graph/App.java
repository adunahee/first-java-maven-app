package firstquickstart.graph;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class App {
    public static void main(String args[]) {
        final SimpleDraw content = new SimpleDraw(new DrawGraphics());
        JFrame frame = new JFrame("Graphics!");
        Color bgColor = Color.white;
        frame.setBackground(bgColor);
        content.setBackground(bgColor);
        // content.setSize(WIDTH, HEIGHT);
        // content.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        content.setPreferredSize(new Dimension(SimpleDraw.WIDTH, SimpleDraw.HEIGHT));
        // frame.setSize(WIDTH, HEIGHT);
        frame.setContentPane(content);
        frame.setResizable(false);
        frame.pack();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            public void windowDeiconified(WindowEvent e) {
                content.start();
            }

            public void windowIconified(WindowEvent e) {
                content.stop();
            }
        });
        new Thread(content).start();
        frame.setVisible(true);
    }
}