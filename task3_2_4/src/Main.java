import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        int width = 400;
        int height = 400;
        Color[][] canvas = new Color[width][height];

        EllipseFiller ellipseFiller = new EllipseFiller(200, 200, 100, 200, Color.RED, Color.BLUE);
        ellipseFiller.fillEllipse(canvas);

        JFrame frame = new JFrame("Ellipse Fill");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);

        frame.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        if (canvas[x][y] != null) {
                            g.setColor(canvas[x][y]);
                            g.fillRect(x, y, 1, 1);
                        }
                    }
                }
            }
        });

        frame.setVisible(true);
    }
}