import java.awt.*;
public class EllipseFiller {
    private int centerX;
    private int centerY;
    private int semiAxisA;
    private int semiAxisB;
    private Color startColor;
    private Color endColor;

    public EllipseFiller(int centerX, int centerY, int semiAxisA, int semiAxisB, Color startColor, Color endColor) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.semiAxisA = semiAxisA;
        this.semiAxisB = semiAxisB;
        this.startColor = startColor;
        this.endColor = endColor;
    }

    public void fillEllipse(Color[][] canvas) {
        int width = semiAxisA * 2;
        int height = semiAxisB * 2;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixelX = centerX - semiAxisA + x;
                int pixelY = centerY - semiAxisB + y;

                if (isInsideEllipse(pixelX, pixelY)) {
                    double distance = distanceToCenter(pixelX, pixelY);

                    // Интерполируем цвет в зависимости от удаленности от центра
                    double ratio = distance / semiAxisA;
                    if (ratio > 1.0) {
                        ratio = 1.0;
                    }
                    Color interpolatedColor = interpolateColor(startColor, endColor, ratio);
                    canvas[pixelX][pixelY] = interpolatedColor;
                }
            }
        }
    }

    private boolean isInsideEllipse(int x, int y) {
        double normalizedX = (x - centerX) / (double) semiAxisA;
        double normalizedY = (y - centerY) / (double) semiAxisB;
        return (normalizedX * normalizedX + normalizedY * normalizedY) <= 1.0;
    }

    private double distanceToCenter(int x, int y) {
        double dx = x - centerX;
        double dy = y - centerY;
        return Math.sqrt(dx * dx + dy * dy);
    }

    private Color interpolateColor(Color startColor, Color endColor, double ratio) {
        int red = (int) (startColor.getRed() + (endColor.getRed() - startColor.getRed()) * ratio);
        int green = (int) (startColor.getGreen() + (endColor.getGreen() - startColor.getGreen()) * ratio);
        int blue = (int) (startColor.getBlue() + (endColor.getBlue() - startColor.getBlue()) * ratio);
        return new Color(red, green, blue);
    }
}
