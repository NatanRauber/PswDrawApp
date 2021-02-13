package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {

    public Frame() {
        /// configure frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

        /// create panel
        Panel panel = new Panel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(new BorderLayout(0, 0));
        setContentPane(panel);

        /// create menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        /// create menu geometry type
        JMenu menuGeometryType = new JMenu("Geometria");
        menuBar.add(menuGeometryType);

        /// create and add menu item Point
        JMenuItem menuItemPoint = new JMenuItem("Ponto");
        menuItemPoint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panel.selectType(0);
                panel.stateController = 0;
            }
        });
        menuGeometryType.add(menuItemPoint);

        /// create and add menu item Line
        JMenuItem menuItemLine = new JMenuItem("Linha");
        menuItemLine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panel.selectType(1);
                panel.stateController = 0;
            }
        });
        menuGeometryType.add(menuItemLine);

        /// create and add menu item Circle
        JMenuItem menuItemCircle = new JMenuItem("Círculo");
        menuItemCircle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panel.selectType(2);
                panel.stateController = 0;
            }
        });
        menuGeometryType.add(menuItemCircle);

        /// create and add menu item Rectangle
        JMenuItem menuItemRectangle = new JMenuItem("Retângulo");
        menuItemRectangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panel.selectType(3);
                panel.stateController = 0;
            }
        });
        menuGeometryType.add(menuItemRectangle);

        /// create and add menu item Triangle
        JMenuItem menuItemTriangle = new JMenuItem("Triângulo");
        menuItemTriangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panel.selectType(4);
                panel.stateController = 0;
            }
        });
        menuGeometryType.add(menuItemTriangle);

        /// create and add menu item Quadrilateral
        JMenuItem menuItemQuadrilateral = new JMenuItem("Quadrilateral");
        menuItemQuadrilateral.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panel.selectType(5);
                panel.stateController = 0;
            }
        });
        menuGeometryType.add(menuItemQuadrilateral);
    }
}