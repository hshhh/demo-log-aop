package com.example.demologaop.designpattern.factory_method.example.buttons;

import javax.swing.*;
import java.awt.*;

/**
 * @author huangshihao
 */
public class WindowsButton implements Button{
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JButton button;


    @Override
    public void render() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jlabel = new JLabel("Hello World!");
        jlabel.setOpaque(true);
        jlabel.setBackground(new Color(235,233,126));
        jlabel.setFont(new Font("Dialog", Font.BOLD, 44));
        jlabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(panel);
        panel.add(jlabel);
        onClick();
        panel.add(button);

        frame.setSize(320, 200);
        frame.setVisible(true);
        onClick();
    }

    @Override
    public void onClick() {
        button = new JButton("Exit");
        button.addActionListener(e -> {
            frame.setVisible(false);
            System.exit(0);
        });
    }
}
