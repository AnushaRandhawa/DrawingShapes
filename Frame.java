import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Frame extends JFrame implements KeyListener
{
    public static DrawerPanel panel;
    public Frame()
    {
        super("Drawing Space");
        this.addKeyListener(this);
        panel = new DrawerPanel();
        add( panel, BorderLayout.CENTER);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize( 500, 500 );
        setVisible( true );
    }

    @Override
    public void keyTyped(KeyEvent e) {
        panel.keyTyped(e);
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    public static void main( String args[] ) {
        Frame frame = new Frame();
       write();
    }

   public static void write() {
        try {
            FileOutputStream f;
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Shapes.txt"));
            while (!panel.shapename.isEmpty()) {
                o.writeObject(panel.ShapesStack.peek());
                panel.ShapesStack.removehead();
            }
        }
        catch(Exception e) {
            System.out.println("File not found");
        }

    }

    public static void read() {
        File file = new File("Shapes.txt");
        try {
            Scanner sc = new Scanner((file));
            while (sc.hasNext()) {

            }
        }
        catch(Exception e) {
            System.out.println("File not found");
        }

    }

    }