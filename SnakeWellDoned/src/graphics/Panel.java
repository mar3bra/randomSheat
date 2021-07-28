package graphics;

import java.awt.Color;

import javax.swing.JPanel;

public class Panel extends JPanel {
    public static JPanel createPanel(int x, int y, int width, int height){
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);
        panel.setBackground(new Color(250,12,250));
        
        return panel;
    }
}
