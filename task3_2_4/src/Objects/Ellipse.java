package Objects;

import java.awt.*;

public class Ellipse extends DrawableElement{
    public Ellipse(int centerX, int centerY, int width, int height, Color startColor, Color endColor){
        super(centerX, centerY, width, height, startColor, endColor);
    };
    int semiAxisA = width / 2;
    public void draw(Graphics2D g) {
        Color[][] canvas = new Color[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (isInsideEllipse(x, y)) {
                    double distance = distanceToCenter(x, y);

                    // Интерполируем цвет в зависимости от удаленности от центра
                    double ratio = distance / semiAxisA;
                    if (ratio > 1.0) {
                        ratio = 1.0;
                    }
                    Color interpolatedColor = interpolateColor(ratio);
                    canvas[x][y] = interpolatedColor;
                    if (canvas[x][y] != null) {
                        g.setColor(canvas[x][y]);
                        g.fillRect(x, y, 1, 1);
                    }
                }
            }
        }
    }
    protected boolean isInsideEllipse(int x, int y) {
        int semiAxisX = width / 2;
        int semiAxisY = height / 2;
        double normalizedX = (x - this.x) / (double) semiAxisX;
        double normalizedY = (y - this.y) / (double) semiAxisY;
        return (normalizedX * normalizedX + normalizedY * normalizedY) <= 1.0;
    }

    protected double distanceToCenter(int x, int y) {
        double dx = x - this.x;
        double dy = y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    protected Color interpolateColor(double ratio) {
        int red = (int) (startColor.getRed() + (endColor.getRed() - startColor.getRed()) * ratio);
        int green = (int) (startColor.getGreen() + (endColor.getGreen() - startColor.getGreen()) * ratio);
        int blue = (int) (startColor.getBlue() + (endColor.getBlue() - startColor.getBlue()) * ratio);
        return new Color(red, green, blue);
    }
}
