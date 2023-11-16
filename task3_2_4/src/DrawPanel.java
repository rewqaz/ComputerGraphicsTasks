import Objects.DrawableElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements ActionListener {

    protected final int PANEL_WIDTH;
    protected final int PANEL_HEIGHT;
    private final int TIMER_DELAY;
    private Timer timer;
    public int ticksFromStart = 0;
    private ArrayList<DrawableElement> elements = new ArrayList<DrawableElement>();

    public DrawPanel(final int width, final int height, final int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.TIMER_DELAY = timerDelay;
        timer = new Timer(timerDelay, this);
        timer.start();
    }

    @Override
    public void paint(final Graphics gr) {
        super.paint(gr);
        for (DrawableElement element : elements) {
            element.draw((Graphics2D) gr);
        }
    }
    public void addElement(DrawableElement drawableElement) {
        elements.add(drawableElement);
    }
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            ++ticksFromStart;
        }
    }
}