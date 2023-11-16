import Objects.Ellipse;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final DrawPanel panel;

    public MainWindow() throws HeadlessException {
        panel = new DrawPanel(this.getWidth(), this.getHeight(), 100);
        Ellipse ellipse = new Ellipse(300,450, 700, 900, Color.RED, Color.GREEN);
        panel.addElement(ellipse);
        this.add(panel);
    }
}