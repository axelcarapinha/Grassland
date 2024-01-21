package main;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputWindow extends JFrame {
  public InputWindow() {
    super("Window");
    this.setSize(800, 600);
    this.setLocationRelativeTo(null);

    Container contentPane = getContentPane();
    contentPane.setBackground(Color.BLUE);

    JLabel labelWidth = new JLabel("Width: ");
    labelWidth.setLocation(10, 20);
    JTextField widthField = new JTextField();
    widthField.setLocation(20, 20);
    widthField.setSize(10, 10);

    JLabel labelHeight = new JLabel("Height: ");
    labelHeight.setLocation(10, 30);
    JTextField heightField = new JTextField();
    heightField.setLocation(20, 30);
    heightField.setSize(10, 10);

    JLabel labelstarveTime = new JLabel("StaveTime: ");
    labelstarveTime.setLocation(10, 40);
    JTextField starveField = new JTextField();
    starveField.setLocation(20, 40);
    starveField.setSize(10, 10);

    contentPane.add(labelWidth);
    contentPane.add(widthField);
    contentPane.add(labelHeight);
    contentPane.add(heightField);
    contentPane.add(labelstarveTime);
    contentPane.add(starveField);

    this.setVisible(true);
  }


}
