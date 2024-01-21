package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputWindow extends JFrame implements ActionListener {
  private boolean simulationReady = false;
  private JTextField starveField;
  private JTextField widthField;
  private JTextField heightField;

  public InputWindow() {
    super("Settings");
    this.setSize(150, 140);
    this.setLocationRelativeTo(null);
    
    Container contentPane = getContentPane();
    contentPane.setBackground(new Color(0xDAC8B3));
    contentPane.setPreferredSize(this.getSize());
    this.setLayout(new GridBagLayout());
    
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.FIRST_LINE_START;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(5, 5, 5, 5);  // Optional: Add some spacing between components
    
    JLabel labelWidth = new JLabel("Width: ");
    widthField = new JTextField();
    widthField.setPreferredSize(new Dimension(50, 20)); 
    contentPane.add(labelWidth, gbc);
    gbc.gridx++;
    contentPane.add(widthField, gbc);
    gbc.gridy++;
    gbc.gridx--;

    JLabel labelHeight = new JLabel("Height: ");
    heightField = new JTextField(); 
    heightField.setPreferredSize(new Dimension(50, 20));

    contentPane.add(labelHeight, gbc);
    gbc.gridx++;
    contentPane.add(heightField, gbc);
    gbc.gridy++;
    gbc.gridx--;

    JLabel labelstarveTime = new JLabel("StarveTime: ");
    starveField = new JTextField();
    starveField.setPreferredSize(new Dimension(50, 20));

    contentPane.add(labelstarveTime, gbc);
    gbc.gridx++;
    contentPane.add(starveField, gbc);
    gbc.gridy++;
    gbc.gridx--;

    JButton button = new JButton("Start");
    contentPane.add(button, gbc);

    // Add to input.
    widthField.addActionListener(this);
    heightField.addActionListener(this);
    starveField.addActionListener(this);
    button.addActionListener(this);

    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    if (event.getSource() instanceof JButton) {
      this.simulationReady = true;
    }
  }

  public boolean isSimulationReady() {
    return this.simulationReady;
  }

  public int getGrasslandWidth() {
    return Integer.parseInt(this.widthField.getText());
  }

  public int getGrasslandHeight() {
    return Integer.parseInt(this.heightField.getText());
  }

  public int getGrasslandStarveTime() {
    return Integer.parseInt(this.starveField.getText());
  }
}
