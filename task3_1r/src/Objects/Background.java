package Objects;

import java.awt.*;

public class Background extends DrawableElement {
    public Background(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }
    public void draw(Graphics2D g) {
        //sky
        g.setPaint(new GradientPaint((float) this.width /2, 0,new Color(253, 95, 95), (float) this.width /2, this.height/2,new Color(87, 13, 38)));
        g.fillRect(0, 0, this.width, (int) (this.height * 0.5));

        //sun
        g.setColor(new Color(248, 72, 57));
        g.fillOval((int) (this.width*0.35), (int) (this.height*0.15), (int) (this.width * 0.3), (int) (this.width * 0.3));

        //sea&land
        g.setPaint(new GradientPaint((float) this.width /2, (float) this.height /2,new Color(2, 26, 75), (float) this.width /2, this.height,new Color(81, 168, 199)));
        g.fillRect(0, (int) (this.height * 0.5), this.width, (int) (this.height*0.3));
        g.setColor(new Color(44, 44, 44));
        g.fillRect(0, (int) (this.height*0.8), this.width, (int) (this.height * 0.15));
    }
}
