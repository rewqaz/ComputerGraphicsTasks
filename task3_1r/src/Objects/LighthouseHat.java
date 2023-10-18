package Objects;


import java.awt.*;

public class LighthouseHat extends DrawableElement {
    public LighthouseHat(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }
    public void draw(Graphics2D g) {
        //sky
        g.setColor(this.color);
        g.fillOval((int) (this.width * 0.44), (int) (this.height * 0.17), (int) (this.width * 0.13), (int) (this.width * 0.13));
        g.setColor(Color.BLACK);
        g.drawOval((int) (this.width * 0.44), (int) (this.height * 0.17), (int) (this.width * 0.13), (int) (this.width * 0.13));
        g.setColor(this.color);
        g.fillRect((int) (this.width * 0.41), (int) (this.height * 0.2), (int) (this.width * 0.19), (int) (this.height*0.03));
        g.setColor(Color.BLACK);
        g.drawRect((int) (this.width * 0.41), (int) (this.height * 0.2), (int) (this.width * 0.19), (int) (this.height*0.03));
    }
}
