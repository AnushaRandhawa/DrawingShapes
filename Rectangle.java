import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Rectangle extends Shape
{
    Random random = new Random();
    Color c;

    public Rectangle() {
        super(); }

    public Rectangle(int x1, int y1, int x2, int y2, Color c) {
        super(x1, y1, x2, y2, c);
        this.c = c;
    }

    @Override
    public void draw( Graphics g ) {
        g.setColor( getColor() );
      if (getHeight()!=getWidth())
            g.fillRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
    }

}