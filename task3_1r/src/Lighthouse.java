import java.awt.*;
import java.util.ArrayList;

import Objects.Background;
import Objects.DrawableElement;
import Objects.LighthouseBody;
import Objects.LighthouseLamp;
import Objects.LighthouseHat;

public class Lighthouse {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    public Lighthouse(final int x, final int y, final int width, final int height, final Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    private ArrayList<DrawableElement> elements = new ArrayList<DrawableElement>();
    public void addElements() {
        Background background  = new Background(x,y,width,height,color);
        LighthouseBody lighthouseBody  = new LighthouseBody(x,y,width,height,color);
        LighthouseHat lighthouseHat  = new LighthouseHat(x,y,width,height,color);
        LighthouseLamp lighthouseLamp  = new LighthouseLamp(x,y,width,height,color);

        elements.add(background);
        elements.add(lighthouseBody);
        elements.add(lighthouseHat);
        elements.add(lighthouseLamp);
    }
    public void draw(Graphics2D g) {
        for (DrawableElement element : elements) {
            element.draw(g);
        }
    }
}
