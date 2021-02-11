package drawapp.views;

import javax.swing.JPanel;

import drawapp.models.Circle;
import drawapp.models.Line;
import drawapp.models.Point;
import drawapp.models.Rectangle;
import drawapp.models.Triangle;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Panel extends JPanel {

    private int typeController = 0;

    private Point point = new Point(-10, -10);
    private Line line = new Line(point, point);
    private Circle circ = new Circle(point, point);
    private Rectangle rect = new Rectangle(point, point);
    private Triangle triang = new Triangle(point, point, point, point);

    public void selectType(int type) {
        this.typeController = type;
    }

    /// create panel
    public Panel() {

        /// mouse event listener - click
        addMouseListener(new MouseAdapter() {

            /// mouse clicked
            @Override
            public void mouseClicked(MouseEvent e) {
                if (typeController == 0) {
                    point = new Point(e.getX(), e.getY());
                }
                repaint();
            }

            /// mouse pressed
            @Override
            public void mousePressed(MouseEvent e) {
                if (typeController == 1) {
                    line.a = new Point(e.getX(), e.getY());
                    line.b = new Point(e.getX(), e.getY());
                } else if (typeController == 2) {
                    circ.a = new Point(e.getX(), e.getY());
                    circ.b = new Point(e.getX(), e.getY());
                } else if (typeController == 3) {
                    rect.a = new Point(e.getX(), e.getY());
                    rect.b = new Point(e.getX(), e.getY());
                } else if (typeController == 4) {
                    triang.a = new Point(e.getX(), e.getY());
                    triang.b = new Point(e.getX(), e.getY());
                    triang.c = new Point(e.getX(), e.getY());
                    triang.d = new Point(e.getX(), e.getY());
                }
                repaint();
            }

            /// mouse released
            @Override
            public void mouseReleased(MouseEvent e) {
                if (typeController == 1) {
                    line.b = new Point(e.getX(), e.getY());
                } else if (typeController == 2) {
                    circ.b = new Point(e.getX(), e.getY());
                } else if (typeController == 3) {
                    rect.b = new Point(e.getX(), e.getY());
                } else if (typeController == 4) {
                    triang.b = new Point(e.getX(), e.getY());
                    triang.c.x = triang.a.x;
                    triang.c.y = triang.b.y;
                    triang.d.x = (triang.b.x + triang.a.x) / 2;
                    triang.d.y = triang.a.y;
                }
                repaint();
            }
        });

        /// mouse event listener - motion
        addMouseMotionListener(new MouseMotionAdapter() {

            /// mouse dragged
            @Override
            public void mouseDragged(MouseEvent e) {
                if (typeController == 1) {
                    line.b = new Point(e.getX(), e.getY());
                } else if (typeController == 2) {
                    circ.b = new Point(e.getX(), e.getY());
                } else if (typeController == 3) {
                    rect.b = new Point(e.getX(), e.getY());
                } else if (typeController == 4) {
                    triang.b = new Point(e.getX(), e.getY());
                    triang.c.x = triang.a.x;
                    triang.c.y = triang.b.y;
                    triang.d.x = (triang.b.x + triang.a.x) / 2;
                    triang.d.y = triang.a.y;
                }
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(point.x - 1, point.y - 1, 3, 3);
        g.drawLine(line.a.x, line.a.y, line.b.x, line.b.y);
        g.drawOval(circ.a.x, circ.a.y, circ.b.x - circ.a.x, circ.b.y - circ.a.y);
        g.drawRect(rect.a.x, rect.a.y, rect.b.x - rect.a.x, rect.b.y - rect.a.y);
        g.drawPolygon(new int[] { triang.b.x, triang.c.x, triang.d.x },
                new int[] { triang.b.y, triang.c.y, triang.d.y }, 3);
    }
}
