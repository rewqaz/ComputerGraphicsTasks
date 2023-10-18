package Objects;

import java.awt.*;

public class LighthouseLamp extends DrawableElement{
    public LighthouseLamp(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setPaint(new GradientPaint((float) this.width / 2, (float) this.height /3,new Color(245, 222, 34), (float) this.width /2, (float) this.height/6,new Color(204, 48, 0, 255)));
        g.fillRect((int) (this.width * 0.43), (int) (this.height * 0.23), (int) (this.width * 0.153), (int) (this.height*0.07));
        g.setColor(Color.BLACK);
        g.drawRect((int) (this.width * 0.43), (int) (this.height * 0.23), (int) (this.width * 0.153), (int) (this.height*0.07));
        g.setColor(this.color);
        g.fillRect((int) (this.width * 0.41), (int) (this.height * 0.3), (int) (this.width * 0.19), (int) (this.height*0.03));
        g.setColor(Color.BLACK);
        g.drawRect((int) (this.width * 0.41), (int) (this.height * 0.3), (int) (this.width * 0.19), (int) (this.height*0.03));
    }
}
