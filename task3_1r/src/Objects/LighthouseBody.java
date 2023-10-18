package Objects;

import java.awt.*;

public class LighthouseBody extends DrawableElement {
    double blockHeight = 0.085;
    double blockWidth = 0.17;
    double localX = 0.42;
    double localY = 0.331;
    Color localColor;

    public LighthouseBody(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i <= 6; i++) {
            if (i % 2 != 0) {
                localColor = this.color;
            } else {
                localColor = Color.WHITE;
            }
            blockDraw(g, localColor, localX - i * 0.02, localY + i * 0.08, blockWidth + i * 0.04, blockHeight);
            //windows
            if (i == 2 || i == 4) {
                blockDraw(g, Color.BLACK, 0.48, localY + i * 0.0845, blockWidth * 0.3, blockHeight * 0.6);
            }
            //door
            if (i == 6) {
                blockDraw(g, new Color(94, 40, 15), 0.47, localY + i * 0.082, blockWidth * 0.4, blockHeight * 0.83);
            }
        }
    }
    void blockDraw(Graphics2D g, Color color, double localX, double localY, double blockWidth, double blockHeight) {

        g.setColor(color);
        g.fillRect((int) (localX * this.width), (int) (localY * this.height), (int) (blockWidth * this.width), (int) (blockHeight * this.height));
        g.setColor(Color.BLACK);
        g.drawRect((int) (localX * this.width), (int) (localY * this.height), (int) (blockWidth * this.width), (int) (blockHeight * this.height));
    }
}
