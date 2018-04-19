package mastermind;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;

public class Ventana extends JFrame {

    ArrayList<String> color = new ArrayList<>();

    String[] tirada = new String[4];
    int contTirada = 0;
    int intentos = 0;

    public Ventana() {

        super("Mastermind");
        getContentPane().setLayout(new GridBagLayout());
        setSize(280, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
//        setResizable(false);
        GridBagConstraints c = new GridBagConstraints();

        JPanel sup = new JPanel();
        sup.setBackground(Color.GRAY);
//        JTextArea solucion = new JTextArea("solucion");
        sup.setMinimumSize(new Dimension(280, 30));
        sup.setPreferredSize(sup.getMinimumSize());
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.fill = 1;
        c.weightx = 1;
//        sup.add(solucion);
        getContentPane().add(sup, c);
        c.weightx = 0;

        JPanel izq = new JPanel();
        izq.setBackground(Color.GRAY);
//        JTextArea tirIzq = new JTextArea("12345");
        izq.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 14));
        izq.setMinimumSize(new Dimension(70, 300));
        izq.setPreferredSize(izq.getMinimumSize());
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
//        izq.add(tirIzq);
//        c.weightx = 1;
//        c.weighty = 1;
        getContentPane().add(izq, c);
//        c.weighty = 0;
//        c.weightx = 0;

        JPanel cen = new JPanel();
        cen.setBackground(Color.GRAY);
        cen.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 14));
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1;
        c.weighty = 1;
        getContentPane().add(cen, c);
        c.weighty = 0;
        c.weightx = 0;

        JPanel der = new JPanel();
        der.setBackground(Color.GRAY);
//        JTextArea tirDer = new JTextArea("12345");
        der.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 14));
        der.setMinimumSize(new Dimension(70, 300));
        der.setPreferredSize(izq.getMinimumSize());
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
//        der.add(tirDer);
//        c.weightx = 1;
//        c.weighty = 1;
        getContentPane().add(der, c);
//        c.weighty = 0;
//        c.weightx = 0;

        JPanel sel = new JPanel();
        sel.setBackground(Color.GRAY);
        add(sel);

        URL urlAma = getClass().getResource("../Recursos/Amarillo.png");
        JButton bAma = new JButton(new ImageIcon(urlAma));
        bAma.setBackground(new Color(0, 0, 0, 0));
        bAma.setBorder(null);
        bAma.setOpaque(false);
        sel.add(bAma);
        bAma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color.add("Amarillo");
                contTirada++;
                URL urlAma = getClass().getResource("../recursos/amarillo.png");
                JLabel lblAma = new JLabel(new ImageIcon(urlAma));
                cen.add(lblAma);
                cen.validate();
                cen.repaint();

            }
        });

        URL urlVer = getClass().getResource("../Recursos/Verde.png");
        JButton bVer = new JButton(new ImageIcon(urlVer));
        bVer.setBackground(new Color(0, 0, 0, 0));
        bVer.setBorder(null);
        bVer.setOpaque(false);
        sel.add(bVer);
        bVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color.add("Verde");
                contTirada++;
                URL urlVer = getClass().getResource("../recursos/verde.png");
                JLabel lblVer = new JLabel(new ImageIcon(urlVer));
                cen.add(lblVer);
                cen.validate();
                cen.repaint();

            }
        });

        URL urlAzu = getClass().getResource("../Recursos/Azul.png");
        JButton bAzu = new JButton(new ImageIcon(urlAzu));
        bAzu.setBackground(new Color(0, 0, 0, 0));
        bAzu.setBorder(null);
        bAzu.setOpaque(false);
        sel.add(bAzu);
        bAzu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color.add("Azul");
                contTirada++;
                URL urlAzu = getClass().getResource("../recursos/azul.png");
                JLabel lblAzu = new JLabel(new ImageIcon(urlAzu));
                cen.add(lblAzu);
                cen.validate();
                cen.repaint();
            }
        });

        URL urlRoj = getClass().getResource("../Recursos/Rojo.png");
        JButton bRoj = new JButton(new ImageIcon(urlRoj));
        bRoj.setBackground(new Color(0, 0, 0, 0));
        bRoj.setBorder(null);
        bRoj.setOpaque(false);
        sel.add(bRoj);
        bRoj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color.add("Rojo");
                contTirada++;
                URL urlRoj = getClass().getResource("../recursos/rojo.png");
                JLabel lblRoj = new JLabel(new ImageIcon(urlRoj));
                cen.add(lblRoj);
                cen.validate();
                cen.repaint();

            }
        });

        URL urlVio = getClass().getResource("../Recursos/Violeta.png");
        JButton bVio = new JButton(new ImageIcon(urlVio));
        bVio.setBackground(new Color(0, 0, 0, 0));
        bVio.setBorder(null);
        bVio.setOpaque(false);
        sel.add(bVio);
        bVio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color.add("Violeta");
                contTirada++;
                URL urlVio1 = Ventana.this.getClass().getResource("../recursos/violeta.png");
                JLabel lblVio = new JLabel(new ImageIcon(urlVio1));
                cen.add(lblVio);
                cen.validate();
                cen.repaint();
            }
        });

        URL urlNar = getClass().getResource("../Recursos/Naranja.png");
        JButton bNar = new JButton(new ImageIcon(urlNar));
        bNar.setBackground(new Color(0, 0, 0, 0));
        bNar.setBorder(null);
        bNar.setOpaque(false);
        sel.add(bNar);
        bNar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color.add("Naranja");
                contTirada++;
                URL urlNar = getClass().getResource("../recursos/naranja.png");
                JLabel lblNar = new JLabel(new ImageIcon(urlNar));
                cen.add(lblNar);
                cen.validate();
                cen.repaint();

            }
        });

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.weightx = 1;
        getContentPane().add(sel, c);
        c.weightx = 0;

        if (contTirada == 4) {
            color.clear();
            contTirada = 0;
            comprobar();
        }
        if (contTirada == 59) {
            perder();
        }
    }

    public void comprobar() {
        intentos++;
        if(intentos==15)
            perder();
        System.out.println("hola");
    }

    public void perder() {
        JOptionPane.showMessageDialog(null, "Has perdido");
    }

    public static void main(String[] args) {
        new Ventana().setVisible(true);
    }

}
