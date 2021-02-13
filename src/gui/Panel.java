package gui;

import javax.swing.JPanel;

import models.Circle;
import models.Line;
import models.Point;
import models.Quadrilateral;
import models.Rectangle;
import models.Triangle;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Panel extends JPanel {

    private int typeController = 0;
    public int stateController = 0;

    private Point point = new Point(-10, -10);
    private Line line = new Line(point, point);
    private Circle circ = new Circle(point, point);
    private Rectangle rect = new Rectangle(point, point);
    private Triangle triang = new Triangle(point, point, point);
    private Quadrilateral quadri = new Quadrilateral(point, point, point, point);

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
                } else if (typeController == 1) {
                    if (stateController == 0) {
                        line.a = new Point(e.getX(), e.getY());
                        line.b = new Point(e.getX(), e.getY());
                        stateController++;
                    } else {
                        line.b = new Point(e.getX(), e.getY());
                        stateController++;
                    }
                } else if (typeController == 3) {
                    if (stateController == 0) {
                        rect.a = new Point(e.getX(), e.getY());
                        rect.b = new Point(e.getX(), e.getY());
                        stateController++;
                    } else {
                        rect.b = new Point(e.getX(), e.getY());
                        stateController++;
                    }
                } else if (typeController == 4) {
                    if (stateController == 0) {
                        triang.a = new Point(e.getX(), e.getY());
                        triang.b = new Point(e.getX(), e.getY());
                        triang.c = new Point(e.getX(), e.getY());
                        stateController++;
                    } else if (stateController == 1) {
                        triang.b = new Point(e.getX(), e.getY());
                        stateController++;

                    } else if (stateController == 2) {
                        triang.c = new Point(e.getX(), e.getY());
                        stateController++;
                    }
                } else if (typeController == 5) {
                    if (stateController == 0) {
                        quadri.a = new Point(e.getX(), e.getY());
                        quadri.b = new Point(e.getX(), e.getY());
                        quadri.c = new Point(e.getX(), e.getY());
                        quadri.d = new Point(e.getX(), e.getY());
                        stateController++;
                    } else if (stateController == 1) {
                        quadri.b = new Point(e.getX(), e.getY());
                        stateController++;
                    } else if (stateController == 2) {
                        quadri.c = new Point(e.getX(), e.getY());
                        stateController++;
                    } else {
                        quadri.d = new Point(e.getX(), e.getY());
                        stateController++;
                    }
                }
                repaint();
            }

            /// mouse pressed
            @Override
            public void mousePressed(MouseEvent e) {
                if (typeController == 2) {
                    circ.a = new Point(e.getX(), e.getY());
                    circ.radius = 0;
                }
                repaint();
            }

            /// mouse released
            @Override
            public void mouseReleased(MouseEvent e) {
                if (typeController == 2) {
                    circ.radius = circ.a.distance(e.getX(), e.getY());
                }
                repaint();
            }
        });

        /// mouse event listener - motion
        addMouseMotionListener(new MouseMotionAdapter() {
            /// mouse dragged
            @Override
            public void mouseDragged(MouseEvent e) {
                if (typeController == 2) {
                    circ.radius = circ.a.distance(e.getX(), e.getY());
                }
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (typeController == 1 && stateController == 1) {
                    line.b = new Point(e.getX(), e.getY());
                } else if (typeController == 3) {
                    if (stateController == 1) {
                        rect.b = new Point(e.getX(), e.getY());
                    }
                } else if (typeController == 4) {
                    if (stateController == 1) {
                        triang.b = new Point(e.getX(), e.getY());
                    } else if (stateController == 2) {
                        triang.c = new Point(e.getX(), e.getY());
                    }
                } else if (typeController == 5) {
                    if (stateController == 1) {
                        quadri.b = new Point(e.getX(), e.getY());
                    } else if (stateController == 2) {
                        quadri.c = new Point(e.getX(), e.getY());
                    } else if (stateController == 3) {
                        quadri.d = new Point(e.getX(), e.getY());
                    }
                }
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        /// paint point
        g.fillOval((int) point.x - 1, (int) point.y - 1, 3, 3);

        /// paint line
        g.drawLine((int) line.a.x, (int) line.a.y, (int) line.b.x, (int) line.b.y);

        /// paint circle
        g.drawOval((int) (circ.a.x - circ.radius), (int) (circ.a.y - circ.radius), (int) (circ.radius * 2),
                (int) (circ.radius * 2));

        /// paint rectangle
        g.drawRect((int) rect.a.x, (int) rect.a.y, (int) (rect.b.x - rect.a.x), (int) (rect.b.y - rect.a.y));

        /// paint triangle
        g.drawPolygon(new int[] { (int) triang.a.x, (int) triang.b.x, (int) triang.c.x },
                new int[] { (int) triang.a.y, (int) triang.b.y, (int) triang.c.y }, 3);

        /// paint quadrilateral
        g.drawPolygon(new int[] { (int) quadri.a.x, (int) quadri.b.x, (int) quadri.c.x, (int) quadri.d.x },
                new int[] { (int) quadri.a.y, (int) quadri.b.y, (int) quadri.c.y, (int) quadri.d.y }, 4);

        /// reset line controller
        if (typeController == 1 && stateController == 2) {
            stateController = 0;
        }

        /// reset rectangle controller
        if (typeController == 3 && stateController == 2) {
            stateController = 0;
        }

        /// reset triangle controller
        if (typeController == 4 && stateController == 3) {
            stateController = 0;
        }

        /// reset quadrilateral controller
        if (typeController == 5 && stateController == 4) {
            stateController = 0;
        }
    }
}
