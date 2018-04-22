package mastermind;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class Ventana extends JFrame {

    //variables usadas
    ArrayList<String> tirada = new ArrayList<>();
    ArrayList<String> solucion = new ArrayList<>();
    int contTirada = 0;
    int intentos = 0;
    JPanel sup, izq, cen, der, sel;

    String[] so = {"rojo", "amarillo", "verde", "azul"};

    public Ventana() {

        //creacion del tablero
        super("Mastermind");
        getContentPane().setLayout(new GridBagLayout());
        setSize(280, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
        setResizable(false);
        GridBagConstraints c = new GridBagConstraints();

        solucion.addAll(Arrays.asList(so));

        //panel superior
        sup = new JPanel();
        sup.setBackground(Color.GRAY);
        sup.setMinimumSize(new Dimension(280, 30));
        sup.setPreferredSize(sup.getMinimumSize());
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.fill = 1;
        c.weightx = 1;
        getContentPane().add(sup, c);
        c.weightx = 0;

        //panel izquierdo
        izq = new JPanel();
        izq.setBackground(Color.GRAY);
        izq.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 14));
        izq.setMinimumSize(new Dimension(70, 300));
        izq.setPreferredSize(izq.getMinimumSize());
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        getContentPane().add(izq, c);

        //panel central (panel de juego)
        cen = new JPanel();
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

        //panel derecho
        der = new JPanel();
        der.setBackground(Color.GRAY);
        der.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 14));
        der.setMinimumSize(new Dimension(70, 300));
        der.setPreferredSize(izq.getMinimumSize());
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        getContentPane().add(der, c);

        //panel inferior (selector de colores)
        sel = new JPanel();
        sel.setBackground(Color.GRAY);
        add(sel);

        //boton amarillo
        URL urlAma = getClass().getResource("../Recursos/Amarillo.png");
        JButton bAma = new JButton(new ImageIcon(urlAma));
        bAma.setBackground(new Color(0, 0, 0, 0));
        bAma.setBorder(null);
        bAma.setOpaque(false);
        bAma.setToolTipText("Amarillo");
        sel.add(bAma);
        bAma.addActionListener(new ActionListener() { //al pulsar 
            @Override
            public void actionPerformed(ActionEvent e) {
                tirada.add("amarillo");
                contTirada++;
                URL urlAma = getClass().getResource("../recursos/amarillo.png");
                JLabel lblAma = new JLabel(new ImageIcon(urlAma));
                cen.add(lblAma);
                cen.validate();
                cen.repaint();
                if (contTirada == 4) {
                    comprobar(tirada);
                }
                if (contTirada == 59) {
                    perder();
                }
            }
        });

        //boton verde
        URL urlVer = getClass().getResource("../Recursos/Verde.png");
        JButton bVer = new JButton(new ImageIcon(urlVer));
        bVer.setBackground(new Color(0, 0, 0, 0));
        bVer.setBorder(null);
        bVer.setOpaque(false);
        bVer.setToolTipText("Verde");
        sel.add(bVer);
        bVer.addActionListener(new ActionListener() { //al pulsar
            @Override
            public void actionPerformed(ActionEvent e) {
                tirada.add("verde");
                contTirada++;
                URL urlVer = getClass().getResource("../recursos/verde.png");
                JLabel lblVer = new JLabel(new ImageIcon(urlVer));
                cen.add(lblVer);
                cen.validate();
                cen.repaint();
                if (contTirada == 4) {
                    comprobar(tirada);

                }
                if (contTirada == 59) {
                    perder();
                }
            }
        });

        //boton azul
        URL urlAzu = getClass().getResource("../Recursos/Azul.png");
        JButton bAzu = new JButton(new ImageIcon(urlAzu));
        bAzu.setBackground(new Color(0, 0, 0, 0));
        bAzu.setBorder(null);
        bAzu.setOpaque(false);
        bVer.setToolTipText("Azul");
        sel.add(bAzu);
        bAzu.addActionListener(new ActionListener() { //al pulsar
            @Override
            public void actionPerformed(ActionEvent e) {
                tirada.add("azul");
                contTirada++;
                URL urlAzu = getClass().getResource("../recursos/azul.png");
                JLabel lblAzu = new JLabel(new ImageIcon(urlAzu));
                cen.add(lblAzu);
                cen.validate();
                cen.repaint();
                if (contTirada == 4) {
                    comprobar(tirada);

                }
                if (contTirada == 59) {
                    perder();
                }
            }
        });

        //boton rojo
        URL urlRoj = getClass().getResource("../Recursos/Rojo.png");
        JButton bRoj = new JButton(new ImageIcon(urlRoj));
        bRoj.setBackground(new Color(0, 0, 0, 0));
        bRoj.setBorder(null);
        bRoj.setOpaque(false);
        bVer.setToolTipText("Rojo");
        sel.add(bRoj);
        bRoj.addActionListener(new ActionListener() { //al pulsar
            @Override
            public void actionPerformed(ActionEvent e) {
                tirada.add("rojo");
                contTirada++;
                URL urlRoj = getClass().getResource("../recursos/rojo.png");
                JLabel lblRoj = new JLabel(new ImageIcon(urlRoj));
                cen.add(lblRoj);
                cen.validate();
                cen.repaint();
                if (contTirada == 4) {
                    comprobar(tirada);

                }
                if (contTirada == 59) {
                    perder();
                }
            }
        });

        //boton violeta
        URL urlVio = getClass().getResource("../Recursos/Violeta.png");
        JButton bVio = new JButton(new ImageIcon(urlVio));
        bVio.setBackground(new Color(0, 0, 0, 0));
        bVio.setBorder(null);
        bVio.setOpaque(false);
        bVer.setToolTipText("Violeta");
        sel.add(bVio);
        bVio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tirada.add("violeta");
                contTirada++;
                URL urlVio = getClass().getResource("../recursos/violeta.png");
                JLabel lblVio = new JLabel(new ImageIcon(urlVio));
                cen.add(lblVio);
                cen.validate();
                cen.repaint();
                if (contTirada == 4) {
                    comprobar(tirada);

                }
                if (contTirada == 59) {
                    perder();
                }
            }
        });

        //boton naranja
        URL urlNar = getClass().getResource("../Recursos/Naranja.png");
        JButton bNar = new JButton(new ImageIcon(urlNar));
        bNar.setBackground(new Color(0, 0, 0, 0));
        bNar.setBorder(null);
        bNar.setOpaque(false);
        bVer.setToolTipText("Naranja");
        sel.add(bNar);
        bNar.addActionListener(new ActionListener() { //al pulsar
            @Override
            public void actionPerformed(ActionEvent e) {
                tirada.add("naranja");
                contTirada++;
                URL urlNar = getClass().getResource("../recursos/naranja.png");
                JLabel lblNar = new JLabel(new ImageIcon(urlNar));
                cen.add(lblNar);
                cen.validate();
                cen.repaint();
                if (contTirada == 4) {
                    comprobar(tirada);
                }
                if (contTirada == 59) {
                    perder();
                }
            }
        });

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.weightx = 1;
        getContentPane().add(sel, c);
        c.weightx = 0;

    }

    public boolean comprobar(ArrayList<String> tir) { //comprueba la solucion con la tirada que hayamos hecho
        intentos++;
        if (intentos == 15) {
            if (comprobar(tir)) {
                ganar();
            } else {
                perder();
            }
        }
        if (!tir.equals(solucion)) {
            for (int i = 0; i < solucion.size(); i++) {
                if (solucion.contains(tir.get(i))) { //mira si esta en la solucion
                    if (solucion.get(i).equals(tir.get(i))) {  //si esta en la misma posicion
                        URL urlBla = getClass().getResource("../recursos/blanco.png");
                        JLabel lblBla = new JLabel(new ImageIcon(urlBla));
                        if (i == 0 || i == 1) { //mira si esta en el panel izq
                            izq.add(lblBla);
                            izq.validate();
                            izq.repaint();
                        } else if (i == 2 || i == 3) { //mira si esta en el panel der
                            der.add(lblBla);
                            der.validate();
                            der.repaint();
                        }
                    } else { // si no esta en la misma posicion
                        URL urlNeg = getClass().getResource("../recursos/negro.png");
                        JLabel lblNeg = new JLabel(new ImageIcon(urlNeg));
                        if (i == 0 || i == 1) { //mira si esta en el panel izq
                            izq.add(lblNeg);
                            izq.validate();
                            izq.repaint();
                        } else if (i == 2 || i == 3) { //mira si esta en el panel der
                            der.add(lblNeg);
                            der.validate();
                            der.repaint();
                        }
                    }
                } else { //si no esta en la solucion
                    URL urlVacio = getClass().getResource("../recursos/vacio.png");
                    JLabel lblVacio = new JLabel(new ImageIcon(urlVacio));
                    if (i == 0 || i == 1) { //mira si esta en el panel izq
                        izq.add(lblVacio);
                        izq.validate();
                        izq.repaint();
                    } else if (i == 2 || i == 3) { //mira si esta en el panel der
                        der.add(lblVacio);
                        der.validate();
                        der.repaint();
                    }
                }
            }
            tirada.clear();
            contTirada = 0;
            System.out.println("Intentos" + intentos);
            return false;
        } else { //solucion correcta
            ganar();
            return true;
        }
    }

    public void perder() { //este metodo crea una ventana de confirmacion que cierra el juego o crea uno nuevo
        int res = JOptionPane.showConfirmDialog(null, "Has perdido, ¿Quieres jugar otra vez?", "¡Qué pena!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (res == 0) {
            dispose();
            new Ventana().setVisible(true);
        } else {
            dispose();
        }
    }

    public void ganar() { //este metodo crea una ventana de confirmacion que cierra el juego o crea uno nuevo
        int res = JOptionPane.showConfirmDialog(null, "Has ganado, ¿Quieres jugar otra vez?", "¡Felicidades!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (res == 0) {
            dispose();
            new Ventana().setVisible(true);
        } else {
            dispose();
        }
    }

    public static void main(String[] args) {
        new Ventana().setVisible(true);
    }

}
