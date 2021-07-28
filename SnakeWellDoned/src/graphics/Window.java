package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class Window extends JFrame {
   
    public JFrame window;
   
    public Window(int width, int height, String title){
        window = new JFrame(title);
        window.setSize(width,height);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setVisible(true);
        //window.setLayout(null);
    }

    public void addPanel(JPanel panel){
        window.add(panel);
        System.out.println(panel.getBounds());
        
    }

    public void setTittle(String tittle){
        System.out.println(tittle);
        window.setTitle(tittle);
    }

}
