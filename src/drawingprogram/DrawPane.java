package drawingprogram;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.TimerTask;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Timer;
import javax.swing.SwingUtilities;

/**
 *
 * @author Andrew
 */
public class DrawPane extends JPanel implements MouseListener, MouseMotionListener {

    JPanel drawpane = this;
    CircleObject c;
    Graphics gobject;
    //boolean drawing = false;
    ArrayList<CircleObject> listofobjects = new ArrayList<>();
    Color paintcolor = Color.red;

    public void paintComponent(Graphics g) {
        int counter = 0;
        this.gobject = g;
        drawpane.setBackground(Color.white);
        g.setColor(paintcolor);
        g.fillOval((int) c.getX(), (int) c.getY(), c.getRadius(), c.getRadius());
        while (counter < listofobjects.size()) {
            CircleObject currentobject = listofobjects.get(counter);
            g.setColor(currentobject.getColor());
            g.fillOval((int) currentobject.getX(), (int) currentobject.getY(), currentobject.getRadius(), currentobject.getRadius());
            counter++;
        }
        //System.out.println(c.getX());
    }

    public DrawPane(CircleObject c) {
        this.c = c;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.setFocusable(true);
    }

    //Timer timer = new Timer();
    //TimerTask task = new MyTimerTask();
    MouseEvent e;

    public MouseEvent getE() {
        return e;
    }

    public void setE(MouseEvent e) {
        this.e = e;
    }

    /*private class MyTimerTask extends TimerTask {

        public void run() {
            double ym = (e.getLocationOnScreen().getY() - c.getY());
            double xm = (e.getLocationOnScreen().getX() - c.getX());

            
            drawpane.repaint();
        }
    }*/
    @Override
    public void mouseClicked(MouseEvent e) {
        double currentX = e.getLocationOnScreen().getX();
        double currentY = e.getLocationOnScreen().getY();
        if (SwingUtilities.isRightMouseButton(e)) {
            paintcolor = Color.white;
        }
        if (SwingUtilities.isLeftMouseButton(e)) {
            paintcolor = Color.red;
        }
        listofobjects.add(new CircleObject((currentX + (e.getLocationOnScreen().getX() / 50.0) - c.getRadius() / 2),
                                          (currentY + (e.getLocationOnScreen().getY() / 50.0) - c.getRadius() * 1.5),50,paintcolor));

    }

    @Override
    public void mousePressed(MouseEvent e) {

        // Time is in milliseconds
        // The second parameter is delay before the first run
        // The third is how often to run it
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        task.cancel();
        // Will not stop execution of task.run() if it is midway
        // But will guarantee that after this call it runs no more than one more time
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /*@Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //System.out.println("It worked!");
            int newX = c.getX();
            newX++;
            c.setX(newX);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //System.out.println("It worked!");
            int newX = c.getX();
            newX--;
            c.setX(newX);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            //System.out.println("It worked!");
            int newY = c.getY();
            newY--;
            c.setY(newY);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            //System.out.println("It worked!");
            int newY = c.getY();
            newY++;
            c.setY(newY);
        }
        
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }*/
    @Override
    public void mouseDragged(MouseEvent e) {
        double currentX = e.getLocationOnScreen().getX();
        double currentY = e.getLocationOnScreen().getY();
        if (SwingUtilities.isRightMouseButton(e)) {
            paintcolor = Color.white;
        }
        if (SwingUtilities.isLeftMouseButton(e)) {
            paintcolor = Color.red;
        }
        listofobjects.add(new CircleObject((currentX + (e.getLocationOnScreen().getX() / 50.0) - c.getRadius() / 2),
                                          (currentY + (e.getLocationOnScreen().getY() / 50.0) - c.getRadius() * 1.5),50,paintcolor));
        followMouse(e);
        //drawpane.repaint();
        //drawing = true;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //drawing = false;
        followMouse(e);
    }

    public void followMouse(MouseEvent e) {
        double currentX = e.getLocationOnScreen().getX();
        double currentY = e.getLocationOnScreen().getY();

        for (int i = 0; i < 51; i++) {
            c.setX(currentX + (e.getLocationOnScreen().getX() / 50.0) - c.getRadius() / 2);
            c.setY(currentY + (e.getLocationOnScreen().getY() / 50.0) - c.getRadius() * 1.5);
            paintcolor = Color.red;
            
            //System.out.println("YAHOO");
            drawpane.repaint();
        }
    }
}
