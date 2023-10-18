import java.awt.*;

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
    void draw(final Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;

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

        //head
        //hat
        g.setColor(this.color);
        g.fillOval((int) (this.width * 0.44), (int) (this.height * 0.17), (int) (this.width * 0.13), (int) (this.width * 0.13));
        g.setColor(Color.BLACK);
        g.drawOval((int) (this.width * 0.44), (int) (this.height * 0.17), (int) (this.width * 0.13), (int) (this.width * 0.13));
        g.setColor(this.color);
        g.fillRect((int) (this.width * 0.41), (int) (this.height * 0.2), (int) (this.width * 0.19), (int) (this.height*0.03));
        g.setColor(Color.BLACK);
        g.drawRect((int) (this.width * 0.41), (int) (this.height * 0.2), (int) (this.width * 0.19), (int) (this.height*0.03));
        //light
        g.setPaint(new GradientPaint((float) this.width / 2, (float) this.height /3,new Color(245, 222, 34), (float) this.width /2, (float) this.height/6,new Color(204, 48, 0, 255)));
        g.fillRect((int) (this.width * 0.43), (int) (this.height * 0.23), (int) (this.width * 0.153), (int) (this.height*0.07));
        g.setColor(Color.BLACK);
        g.drawRect((int) (this.width * 0.43), (int) (this.height * 0.23), (int) (this.width * 0.153), (int) (this.height*0.07));
        //separator
        g.setColor(this.color);
        g.fillRect((int) (this.width * 0.41), (int) (this.height * 0.3), (int) (this.width * 0.19), (int) (this.height*0.03));
        g.setColor(Color.BLACK);
        g.drawRect((int) (this.width * 0.41), (int) (this.height * 0.3), (int) (this.width * 0.19), (int) (this.height*0.03));

        //structure
        double blockHeight = 0.085;
        double blockWidth = 0.17;
        double localX = 0.42;
        double localY = 0.331;
        Color localColor;

        for(int i = 0; i <= 6; i++){
            if(i % 2 != 0) {
                localColor = this.color;
            } else {
                localColor = Color.WHITE;
            }
            blockDraw(g, localColor, localX - i * 0.02, localY + i * 0.08, blockWidth + i * 0.04, blockHeight);
            //windows
            if(i == 2 || i == 4) {
                blockDraw(g, Color.BLACK, 0.48, localY + i * 0.0845, blockWidth * 0.3, blockHeight * 0.6);
            }
            //door
            if(i == 6) {
                blockDraw(g, new Color(94, 40, 15), 0.47, localY + i * 0.082, blockWidth * 0.4, blockHeight * 0.83);
            }
        };
    }
    void blockDraw(Graphics2D g, Color color, double localX, double localY, double blockWidth, double blockHeight) {

        g.setColor(color);
        g.fillRect((int) (localX * this.width), (int) (localY * this.height), (int) (blockWidth * this.width), (int) (blockHeight * this.height));
        g.setColor(Color.BLACK);
        g.drawRect((int) (localX * this.width), (int) (localY * this.height), (int) (blockWidth * this.width), (int) (blockHeight * this.height));

    }


}
