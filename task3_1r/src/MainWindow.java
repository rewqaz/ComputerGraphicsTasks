import Objects.Background;
import Objects.LighthouseBody;
import Objects.LighthouseHat;
import Objects.LighthouseLamp;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final DrawPanel panel;

    public MainWindow() throws HeadlessException {
        panel = new DrawPanel(this.getWidth(), this.getHeight(), 100);

        Background background  = new Background(0, 0, 700, 900);
        panel.addElement(background);

        LighthouseBody lighthouseBody  = new LighthouseBody(0, 0, 700, 900, new Color(34, 34, 191));
        panel.addElement(lighthouseBody);

        LighthouseHat lighthouseHat  = new LighthouseHat(0, 0, 700, 900, new Color(34, 34, 191));
        panel.addElement(lighthouseHat);

        LighthouseLamp lighthouseLamp  = new LighthouseLamp(0, 0, 700, 900, new Color(34, 34, 191));
        panel.addElement(lighthouseLamp);

        this.add(panel);
    }
}