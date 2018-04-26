package mastermind;

import java.awt.Color;
import java.awt.FlowLayout;
import java.net.URL;
import javax.swing.*;

public class PantallaCarga {
    JWindow w = new JWindow();
    JProgressBar pb = new JProgressBar();
    JPanel p = new JPanel();

    public void PantallaCarga(){
        URL url = getClass().getResource("/recursos/carga.png");
        JLabel fondo = new JLabel(new ImageIcon(url));
        
        pb.setMinimum(0);
        pb.setMaximum(100);
        pb.setStringPainted(true);
        
        
        w.setLayout(new FlowLayout());
        w.getContentPane().add(pb);
        w.getContentPane().add(fondo);
        w.getContentPane().setBackground(Color.black);
        
        w.setSize(484,340);
        w.setLocationRelativeTo(null);
        w.setVisible(true);

        for(int i=0;i<=100;i++){
            int j = i;
            try {
                pb.setValue(j);
                Thread.sleep(20);
            } catch (InterruptedException e) {}
        }
        w.setVisible(false);
        w.dispose();
    }
}