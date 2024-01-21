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
    private JTextField maxTimeField;

    public InputWindow() {
        super("Settings");
        this.setSize(200, 160);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        Container contentPane = getContentPane();
        contentPane.setBackground(new Color(0xDAC8B3));
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Optional: Add some spacing between components

        Dimension defaultDim = new Dimension(50, 20);

        JLabel labelWidth = new JLabel("Width: ");
        widthField = new JTextField("100");
        widthField.setPreferredSize(defaultDim);
        contentPane.add(labelWidth, gbc);
        gbc.gridx++;
        contentPane.add(widthField, gbc);
        gbc.gridy++;
        gbc.gridx--;

        JLabel labelHeight = new JLabel("Height: ");
        heightField = new JTextField("100");
        heightField.setPreferredSize(defaultDim);

        contentPane.add(labelHeight, gbc);
        gbc.gridx++;
        contentPane.add(heightField, gbc);
        gbc.gridy++;
        gbc.gridx--;

        JLabel labelstarveTime = new JLabel("Starve Time: ");
        starveField = new JTextField("5");
        starveField.setPreferredSize(defaultDim);

        contentPane.add(labelstarveTime, gbc);
        gbc.gridx++;
        contentPane.add(starveField, gbc);
        gbc.gridy++;
        gbc.gridx--;

        JLabel labelMaxTime = new JLabel("Nº Generations: ");
        maxTimeField = new JTextField("23");
        maxTimeField.setPreferredSize(defaultDim);

        contentPane.add(labelMaxTime, gbc);
        gbc.gridx++;
        contentPane.add(maxTimeField, gbc);
        gbc.gridx--;
        gbc.gridy++;

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
            this.setVisible(false);
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

    public int getGrasslandMaxTimeField() {
        return Integer.parseInt(this.maxTimeField.getText());
    }
}
