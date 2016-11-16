package test;

import java.awt.*;

import javax.swing.*;

import src.DrawableSquare;

public class DrawableTest {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        Component panel = (Component) new DrawableSquare(true, true, true, true, 0, 1);
        window.add(panel);
        window.setVisible(true);
    }
}
