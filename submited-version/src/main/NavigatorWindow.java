package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class NavigatorWindow extends JFrame {
    private JTextField currentGen;
    private boolean paused = false;

    public NavigatorWindow() {
        super("Captain");
        this.setSize(200, 180);
        this.setResizable(false);
        
        Container contentPane = getContentPane();
        contentPane.setBackground(new Color(0xDAC8B3));
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);  // Optional: Add some spacing between components

        Dimension defaultDim = new Dimension(45, 20);
        
        JButton buttonPrevious = new JButton("←");
        buttonPrevious.setPreferredSize(defaultDim);
        gbc.gridy = 1;
        contentPane.add(buttonPrevious, gbc);
        
        this.currentGen = new JTextField(0);
        this.currentGen.setPreferredSize(new Dimension(50, 20));
        gbc.gridy = 1;
        gbc.gridx = 1;
        contentPane.add(this.currentGen, gbc);

        JButton buttonNext = new JButton("→");
        buttonNext.setPreferredSize(defaultDim);
        gbc.gridx = 2;
        contentPane.add(buttonNext, gbc);

        JButton playButton = new JButton("⏵︎");
        playButton.setPreferredSize(defaultDim);
        gbc.gridx = 1;
        gbc.gridy = 2;
        contentPane.add(playButton, gbc);

        JButton pauseButton = new JButton("⏸︎");
        pauseButton.setPreferredSize(defaultDim);
        gbc.gridx = 1;
        gbc.gridy = 0;
        contentPane.add(pauseButton, gbc);

        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }

    public boolean isPaused() {
      return paused;
    }

    public void setCurrentGenerationIndex(int currentGenerationIndex) {
        String curGen = String.valueOf(currentGenerationIndex) + " / " + String.valueOf(Simulation.MAX_TIME);

        // int offset = (7 - curGen.length()) / 2;
        // this.currentGen.setText(String.format("%1s", curGen));
        this.currentGen.setText(curGen);
    }
}
