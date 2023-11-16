package Objects;

import java.awt.*;

public abstract class DrawableElement {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color;
    protected Color startColor;
    protected Color endColor;

    public DrawableElement(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public DrawableElement(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public DrawableElement(int x, int y, int width, int height, Color startColor, Color endColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.startColor = startColor;
        this.endColor = endColor;
    }
    public abstract void draw(Graphics2D g);
}