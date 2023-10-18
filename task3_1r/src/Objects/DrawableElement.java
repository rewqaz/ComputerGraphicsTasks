package Objects;

import java.awt.*;

public abstract class DrawableElement {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color;

    public DrawableElement(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public abstract void draw(Graphics2D g);
}