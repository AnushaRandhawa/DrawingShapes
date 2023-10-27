import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Random;

public class DrawerPanel extends JPanel {
   public ShapeStack<Shape> ShapesStack;
   public ShapeStack<Shape> clearedShapesQueue;

    private int currShape;
    private Shape currShapeobj;
    Random random = new Random();
    private Color currShapecolor;
  String shapename;
    public DrawerPanel() {

        ShapesStack = new ShapeStack<Shape>();
        clearedShapesQueue = new ShapeStack<Shape>();
        currShape = 0;
        currShapeobj = null;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        JLabel info = new JLabel("Press 1 for Rectangle, 2 for Circle, 3 for Triangle, u for Undo, r for Redo, c for Clear");
        info.setFont(new Font("Arial", Font.BOLD, 20));
        add(info, BorderLayout.NORTH);
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

      ArrayList<Shape> shapeArr = ShapesStack.toArray();

        for (int counter = shapeArr.size() - 1; counter >= 0; counter--)
            shapeArr.get(counter).draw(g);
        if (currShapeobj != null)
            currShapeobj.draw(g);

      if (shapename != null) {
          g.setColor(Color.BLACK);
          g.setFont(new Font("Arial", Font.PLAIN, 25));
          g.drawString(shapename, 10, 680);
      }
    }
    public void setCurrShape(int type) {
        currShape = type;
    }
    public void setCurrShapecolor(Color color) {
        currShapecolor = color;
    }

    public void Undo() {
        if (! ShapesStack.isEmpty())
        {
            clearedShapesQueue.addHead(ShapesStack.removehead());
            repaint();
        }
    }
    public void Redo() {
       if (! clearedShapesQueue.isEmpty())
        {
            ShapesStack.addHead(clearedShapesQueue.removehead());
            repaint();
        }
    }
    public void clearDrawing() {
        ShapesStack.removeAll();
       clearedShapesQueue.removeAll();
        repaint();
    }
    private class MouseHandler extends MouseAdapter
    {
        int count =0;
        int x1,x2,x3,y1,y2,y3;
        public void mousePressed( MouseEvent event )

        {
           currShapecolor =new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            switch (currShape)
            {
                case 1:
                    currShapeobj = new Rectangle( event.getX(), event.getY(),
                            event.getX(), event.getY(), currShapecolor);
                    break;
                case 2:
                    currShapeobj= new Circle( event.getX(), event.getY(), event.getX(), event.getY(), currShapecolor);
                    break;

                case 3:
                    if (count == 0) {
                        x1 = event.getX();
                        y1 = event.getY();
                        currShapeobj = new Line(event.getX(), event.getY(),event.getX(), event.getY(),Color.BLACK);
                        count++;
                    }
                    else if (count == 1) {
                        x2 = event.getX();
                        y2 = event.getY();
                        currShapeobj = new Line(event.getX(), event.getY(),event.getX(), event.getY(), Color.BLACK);

                        count++;
                    }
                    else if (count == 2) {
                        x3 = event.getX();
                        y3 = event.getY();
                       currShapeobj = new Line(event.getX(), event.getY(),event.getX(), event.getY(), Color.BLACK);
                      //  currShapeobj = new Line(x1, y1,x2, y2, currShapecolor);

                        int[] xcoord = new int[3];
                        int[] ycoord = new int[3];
                        xcoord[0] = x1;
                        xcoord[1] = x2;
                        xcoord[2] = x3;
                        ycoord[0] = y1;
                        ycoord[1] = y2;
                        ycoord[2] = y3;

                        currShapeobj = new Triangle(xcoord, ycoord, currShapecolor);
                        count = 0;
                    }
                   break;
            }
        }
        public void mouseReleased( MouseEvent event )
        {
            currShapeobj.setX2(event.getX());
            currShapeobj.setY2(event.getY());

          ShapesStack.addHead(currShapeobj);
          currShapeobj =null;
            clearedShapesQueue.removeAll();
            repaint();
        }

        public void mouseDragged( MouseEvent event ) {
            currShapeobj.setX2(event.getX());
            currShapeobj.setY2(event.getY());
            repaint();
        }
    }
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case '1':
                System.out.println("Rectangle");
                shapename = "Rectangle";
                setCurrShape(1);
                break;

            case '2':
                System.out.println("Circle");
                shapename = "Circle";
                setCurrShape(2);
                break;

            case '3':
                System.out.println("Triangle");
                shapename = "Triangle";
                setCurrShape(3);
                break;

            //I dont have a middle key on my laptop so I am using X for Undo Operation
            case 'u':
                System.out.println("Operation: Undo");
                Undo();
                break;

            case 'r':
                System.out.println("Operation: Redo");
                Redo();
                break;

            case 'c':
                System.out.println("Operation: Clear Screen");
                clearDrawing();
                break;
        }


    }

}
