import javax.swing.*;
import java.awt.*;

public class Planets extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private static final int SUN_SIZE = 30;
    private static final int MARS_SIZE = 10;
    private static final int EARTH_SIZE = 13;
    private static final int VENUS_SIZE = 11;

    private int x_sun = WIDTH/2;
    private int y_sun = HEIGHT/2;

    private static final int MARS_ORBIT = 70;
    private static final int EARTH_ORBIT = 100;
    private static final int VENUS_ORBIT = 50;

    private static final int MARS_ANGLE = 0;
    private static final int EARTH_ANGLE = 120;
    private static final int VENUS_ANGLE = 240;

    private double angle_mars = MARS_ANGLE;
    private double angle_earth = EARTH_ANGLE;
    private double angle_venus = VENUS_ANGLE;

    public Planets() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.YELLOW);
        g.fillOval(x_sun - SUN_SIZE / 2, y_sun - SUN_SIZE / 2, SUN_SIZE, SUN_SIZE);

        int x_mars = x_sun + (int) (MARS_ORBIT * Math.cos(Math.toRadians(angle_mars)));
        int y_mars = y_sun + (int) (MARS_ORBIT * Math.sin(Math.toRadians(angle_mars)));
        g.setColor(Color.RED);
        g.fillOval(x_mars - MARS_SIZE / 2, y_mars - MARS_SIZE / 2, MARS_SIZE, MARS_SIZE);

        int x_earth = x_sun + (int) (EARTH_ORBIT * Math.cos(Math.toRadians(angle_earth)));
        int y_earth = y_sun + (int) (EARTH_ORBIT * Math.sin(Math.toRadians(angle_earth)));
        g.setColor(Color.BLUE);
        g.fillOval(x_earth - EARTH_SIZE / 2, y_earth - EARTH_SIZE / 2, EARTH_SIZE, EARTH_SIZE);

        int x_venus = x_sun + (int) (VENUS_ORBIT * Math.cos(Math.toRadians(angle_venus)));
        int y_venus = y_sun + (int) (VENUS_ORBIT * Math.sin(Math.toRadians(angle_venus)));
        g.setColor(Color.GREEN);
        g.fillOval(x_venus - VENUS_SIZE / 2, y_venus - VENUS_SIZE / 2, VENUS_SIZE, VENUS_SIZE);

        angle_mars += 0.1;
        angle_earth += 0.05;
        angle_venus += 0.03;

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Planets");
        Planets planets = new Planets();

        frame.add(planets);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}