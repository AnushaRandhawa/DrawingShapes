import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape
{
    public Circle()
    {
        super();
    }

    public Circle(int x1, int y1, int x2, int y2, Color color )
    {
        super(x1, y1, x2, y2, color);
    }

    @Override
    public void draw( Graphics g )
    {
        g.setColor( getColor() );
        g.fillOval( getUpperLeftX(), getUpperLeftY(), getWidth(), getWidth() );

    }

}
