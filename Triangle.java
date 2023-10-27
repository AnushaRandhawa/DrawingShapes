import java.awt.Color;
import java.awt.Graphics;


public class Triangle extends Line
{
    private int[] xps;
    private int[] yps;
    private int n;
    private Color color;

    public Triangle(int [] xps , int [] yps, Color color) {
        this.xps = xps;
        this.yps = yps;
        this.n = 3;
        this.color = color;
    }

    @Override
    public void draw( Graphics g )
    {
       g.setColor(color);
        g.fillPolygon(xps,yps,n);
    }
}
