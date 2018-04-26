package mastermind;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Juego extends JFrame {

    //variables usadas
    ArrayList<String> tirada = new ArrayList<>();
    ArrayList<String> solucion = new ArrayList<>();
    int contTirada = 0;
    int intentos = 0;
    JPanel sup, izq, cen, der, sel;
    int ver = 0, roj = 0, azu = 0, ama = 0, nar = 0, vio = 0, ros = 0, mar = 0, cel = 0;
    int correcto;
    Sonido sonido = new Sonido();
    PantallaCarga pantalla = new PantallaCarga();
    fondoThread fondoT = new fondoThread();
    
    public Juego() {

        //creacion del tablero
        super("Mastermind");
        pantalla.PantallaCarga();
        getContentPane().setLayout(new GridBagLayout());
        setSize(300, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
        setResizable(false);
        GridBagConstraints c = new GridBagConstraints();
        
        generarSolucion();

        //cambiar el icono del programa
        URL urlIcon = getClass().getResource("/recursos/icono.png");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image icon = kit.createImage(urlIcon);
        setIconImage(icon);

        //panel superior
        sup = new JPanel();
        sup.setBackground(new Color(179, 89, 0));
        sup.setMinimumSize(new Dimension(280, 40));
        sup.setPreferredSize(sup.getMinimumSize());
        sup.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 8));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.fill = 1;
        c.weightx = 1;
        getContentPane().add(sup, c);
        c.weightx = 0;

        //panel izquierdo
        izq = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Image imagenIzq = Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/recursos/izq.png"));
                g.drawImage(imagenIzq, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        izq.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 13));
        izq.setMinimumSize(new Dimension(70, 630));
        izq.setPreferredSize(izq.getMinimumSize());
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        getContentPane().add(izq, c);

        //panel central (panel de juego)
        cen = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Image imagenCen = Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/recursos/cen.png"));
                g.drawImage(imagenCen, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
//        cen.setPreferredSize(new Dimension(140, 640));
        cen.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 13));
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
        der = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Image imagenDer = Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/recursos/der.png"));
                g.drawImage(imagenDer, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        der.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 13));
        der.setMinimumSize(new Dimension(70, 630));
        der.setPreferredSize(der.getMinimumSize());
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        getContentPane().add(der, c);

        //panel inferior (selector de colores)
        sel = new JPanel();
        sel.setBackground(new Color(179, 89, 0));
        sel.setLayout(new FlowLayout());
        sel.setPreferredSize(new Dimension(280, 30));
        add(sel);

        //boton amarillo
        URL urlAma = getClass().getResource("/Recursos/Amarillo.png");
        JButton bAma = new JButton(new ImageIcon(urlAma));
        bAma.setBackground(new Color(0, 0, 0, 0));
        bAma.setBorder(null);
        bAma.setOpaque(false);
        bAma.setToolTipText("Amarillo");
        bAma.addActionListener(new ActionListener() { //al pulsar 
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tirada.contains("amarillo")) {
                    sonido.mov();
                    tirada.add("amarillo");
                    contTirada++;
                    URL urlAma = getClass().getResource("/recursos/amarillo.png");
                    JLabel lblAma = new JLabel(new ImageIcon(urlAma));
                    cen.add(lblAma);
                    cen.validate();
                    cen.repaint();
                    if (contTirada == 4) {
                        comprobar(tirada);
                    }
                }
            }
        });

        //boton verde
        URL urlVer = getClass().getResource("/Recursos/Verde.png");
        JButton bVer = new JButton(new ImageIcon(urlVer));
        bVer.setBackground(new Color(0, 0, 0, 0));
        bVer.setBorder(null);
        bVer.setOpaque(false);
        bVer.setToolTipText("Verde");
        bVer.addActionListener(new ActionListener() { //al pulsar
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tirada.contains("verde")) {
                    sonido.mov();
                    tirada.add("verde");
                    contTirada++;
                    URL urlVer = getClass().getResource("/recursos/verde.png");
                    JLabel lblVer = new JLabel(new ImageIcon(urlVer));
                    cen.add(lblVer);
                    cen.validate();
                    cen.repaint();
                    if (contTirada == 4) {
                        comprobar(tirada);
                        
                    }
                }
            }
        });

        //boton azul
        URL urlAzu = getClass().getResource("/Recursos/Azul.png");
        JButton bAzu = new JButton(new ImageIcon(urlAzu));
        bAzu.setBackground(new Color(0, 0, 0, 0));
        bAzu.setBorder(null);
        bAzu.setOpaque(false);
        bAzu.setToolTipText("Azul");
        bAzu.addActionListener(new ActionListener() { //al pulsar
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tirada.contains("azul")) {
                    sonido.mov();
                    tirada.add("azul");
                    contTirada++;
                    URL urlAzu = getClass().getResource("/recursos/azul.png");
                    JLabel lblAzu = new JLabel(new ImageIcon(urlAzu));
                    cen.add(lblAzu);
                    cen.validate();
                    cen.repaint();
                    if (contTirada == 4) {
                        comprobar(tirada);
                        
                    }
                }
            }
        });

        //boton rojo
        URL urlRoj = getClass().getResource("/Recursos/Rojo.png");
        JButton bRoj = new JButton(new ImageIcon(urlRoj));
        bRoj.setBackground(new Color(0, 0, 0, 0));
        bRoj.setBorder(null);
        bRoj.setOpaque(false);
        bRoj.setToolTipText("Rojo");
        bRoj.addActionListener(new ActionListener() { //al pulsar
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tirada.contains("rojo")) {
                    sonido.mov();
                    tirada.add("rojo");
                    contTirada++;
                    URL urlRoj = getClass().getResource("/recursos/rojo.png");
                    JLabel lblRoj = new JLabel(new ImageIcon(urlRoj));
                    cen.add(lblRoj);
                    cen.validate();
                    cen.repaint();
                    if (contTirada == 4) {
                        comprobar(tirada);
                        
                    }
                }
            }
        });

        //boton violeta
        URL urlVio = getClass().getResource("/Recursos/Violeta.png");
        JButton bVio = new JButton(new ImageIcon(urlVio));
        bVio.setBackground(new Color(0, 0, 0, 0));
        bVio.setBorder(null);
        bVio.setOpaque(false);
        bVio.setToolTipText("Violeta");
        bVio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tirada.contains("violeta")) {
                    sonido.mov();
                    tirada.add("violeta");
                    contTirada++;
                    URL urlVio = getClass().getResource("/recursos/violeta.png");
                    JLabel lblVio = new JLabel(new ImageIcon(urlVio));
                    cen.add(lblVio);
                    cen.validate();
                    cen.repaint();
                    if (contTirada == 4) {
                        comprobar(tirada);
                        
                    }
                }
            }
        });

        //boton naranja
        URL urlNar = getClass().getResource("/Recursos/Naranja.png");
        JButton bNar = new JButton(new ImageIcon(urlNar));
        bNar.setBackground(new Color(0, 0, 0, 0));
        bNar.setBorder(null);
        bNar.setOpaque(false);
        bNar.setToolTipText("Naranja");
        bNar.addActionListener(new ActionListener() { //al pulsar
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tirada.contains("naranja")) {
                    sonido.mov();
                    tirada.add("naranja");
                    contTirada++;
                    URL urlNar = getClass().getResource("/recursos/naranja.png");
                    JLabel lblNar = new JLabel(new ImageIcon(urlNar));
                    cen.add(lblNar);
                    cen.validate();
                    cen.repaint();
                    if (contTirada == 4) {
                        comprobar(tirada);
                    }
                }
            }
        });

        //boton rosa
        URL urlRos = getClass().getResource("/Recursos/rosa.png");
        JButton bRos = new JButton(new ImageIcon(urlRos));
        bRos.setBackground(new Color(0, 0, 0, 0));
        bRos.setBorder(null);
        bRos.setOpaque(false);
        bRos.setToolTipText("Rosa");
        bRos.addActionListener(new ActionListener() { //al pulsar
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tirada.contains("rosa")) {
                    sonido.mov();
                    tirada.add("rosa");
                    contTirada++;
                    URL urlRos = getClass().getResource("/recursos/rosa.png");
                    JLabel lblRos = new JLabel(new ImageIcon(urlRos));
                    cen.add(lblRos);
                    cen.validate();
                    cen.repaint();
                    if (contTirada == 4) {
                        comprobar(tirada);
                    }
                }
            }
        });

        //boton marron
        URL urlMar = getClass().getResource("/Recursos/marron.png");
        JButton bMar = new JButton(new ImageIcon(urlMar));
        bMar.setBackground(new Color(0, 0, 0, 0));
        bMar.setBorder(null);
        bMar.setOpaque(false);
        bMar.setToolTipText("Marron");
        bMar.addActionListener(new ActionListener() { //al pulsar
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tirada.contains("marron")) {
                    sonido.mov();
                    tirada.add("marron");
                    contTirada++;
                    URL urlMar = getClass().getResource("/recursos/marron.png");
                    JLabel lblMar = new JLabel(new ImageIcon(urlMar));
                    cen.add(lblMar);
                    cen.validate();
                    cen.repaint();
                    if (contTirada == 4) {
                        comprobar(tirada);
                    }
                }
            }
        });

        //boton celeste
        URL urlCel = getClass().getResource("/Recursos/celeste.png");
        JButton bCel = new JButton(new ImageIcon(urlCel));
        bCel.setBackground(new Color(0, 0, 0, 0));
        bCel.setBorder(null);
        bCel.setOpaque(false);
        bCel.setToolTipText("Celeste");
        bCel.addActionListener(new ActionListener() { //al pulsar
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tirada.contains("celeste")) {
                    sonido.mov();
                    tirada.add("celeste");
                    contTirada++;
                    URL urlCel = getClass().getResource("/recursos/celeste.png");
                    JLabel lblCel = new JLabel(new ImageIcon(urlCel));
                    cen.add(lblCel);
                    cen.validate();
                    cen.repaint();
                    if (contTirada == 4) {
                        comprobar(tirada);
                    }
                }
            }
        });

        //añado los botones
        sel.add(bRoj);
        sel.add(bRos);
        sel.add(bVio);
        sel.add(bAzu);
        sel.add(bCel);
        sel.add(bVer);
        sel.add(bAma);
        sel.add(bNar);
        sel.add(bMar);

        //propiedades del selector
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.weightx = 1;
        getContentPane().add(sel, c);
        c.weightx = 0;
        
        fondoT.start();
        
    }
    
    public static void reglas() { //muestra un mensaje con las reglas
        JOptionPane.showMessageDialog(null,
                "Selecciona una combinacion de colores y el programa "
                + "la comparará con la solución generada.\n"
                + "Las bolas blancas indican que la posicion es correcta.\n"
                + "Las bolas negras indican que la posicion no es correcta.",
                "Reglas", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void generarSolucion() { //genera una solucion de forma aleatoria
        while (solucion.size() < 4) {
            int aleatorio = (int) Math.floor(Math.random() * 9 + 1);
            switch (aleatorio) {
                case 1:
                    if (ver <= 0) {
                        ver++;
                        solucion.add("verde");
                        break;
                    }
                case 2:
                    if (roj <= 0) {
                        roj++;
                        solucion.add("rojo");
                        break;
                    }
                case 3:
                    if (azu <= 0) {
                        azu++;
                        solucion.add("azul");
                        break;
                    }
                case 4:
                    if (ama <= 0) {
                        ama++;
                        solucion.add("amarillo");
                        break;
                    }
                case 5:
                    if (nar <= 0) {
                        nar++;
                        solucion.add("naranja");
                        break;
                    }
                case 6:
                    if (vio <= 0) {
                        vio++;
                        solucion.add("violeta");
                        break;
                    }
                case 7:
                    if (ros <= 0) {
                        ros++;
                        solucion.add("rosa");
                        break;
                    }
                case 8:
                    if (mar <= 0) {
                        mar++;
                        solucion.add("marron");
                        break;
                    }
                case 9:
                    if (cel <= 0) {
                        cel++;
                        solucion.add("celeste");
                        break;
                    }
            }
        }       
    }
    
    public void comprobar(ArrayList<String> tir) { //comprueba la solucion con la tirada que hayamos hecho
        int hoa[] = new int[4]; //Contador huecos ocupados array
        int ho = 0; //Contador huecos ocupados
        if (!tir.equals(solucion)) { //solucion incorrecta
            for(int i = 0 ; i < solucion.size(); i++){ //Rellena las bolas blancas
                if(solucion.get(i).equals(tir.get(i))){ 
                    URL urlBla = getClass().getResource("/recursos/blanco.png");
                    JLabel lblBla = new JLabel(new ImageIcon(urlBla));
                    if(hoa[i] == 0 && (ho == 0 || ho == 1)){
                        izq.add(lblBla);
                        izq.validate();
                        izq.repaint();
                        hoa[i]=1;
                        ho++;
                    }
                    else if(hoa[i] == 0 && (ho == 2 || ho ==3)){
                        der.add(lblBla);
                        der.validate();
                        der.repaint();                       
                        hoa[i]=1;
                        ho++;
                    }                       
                }   
            }
            for(int i = 0; i < solucion.size(); i++){ //Rellena las bolas negras
                if(solucion.contains(tir.get(i))){
                    URL urlNeg = getClass().getResource("/recursos/negro.png");
                    JLabel lblNeg = new JLabel(new ImageIcon(urlNeg));
                    if(hoa[i] == 0 && (ho == 0 || ho == 1)){
                        izq.add(lblNeg);
                        izq.validate();
                        izq.repaint();
                        hoa[i]=1;
                        ho++;
                    }
                    else if(hoa[i] == 0 && (ho == 2 || ho ==3)){
                        der.add(lblNeg);
                        der.validate();
                        der.repaint();                       
                        hoa[i]=1;
                        ho++;
                    }
                }
            }
            for(int i = 0; i < solucion.size(); i++){ //"Rellena" los espacios vacios
                URL urlVacio = getClass().getResource("/recursos/rojo.png");
                JLabel lblVacio = new JLabel(new ImageIcon(urlVacio));
                if(hoa[i] == 0 && (ho == 0 || ho == 1)){
                    izq.add(lblVacio);
                    izq.validate();
                    izq.repaint();
                    hoa[i]=1;
                    ho++;
                }
                else if(hoa[i] == 0 && (ho == 2 || ho ==3)){
                    der.add(lblVacio);
                    der.validate();
                    der.repaint();                       
                    hoa[i]=1;
                    ho++;
                } 
            }                      
        }else { //solucion correcta
                    intentos = 0;
                    correcto = 1;
                    ganar();
                }
        tirada.clear();
        contTirada = 0;
        correcto = 0;
        intentos++;
        for(int i=0; i <= 3; i++){
                hoa[i]=0;
            }
        ho=0;
        if (intentos == 15) {
            if (correcto == 1) {
                ganar();
                intentos = 0;
            }
            if (correcto == 0) {
                perder();
                intentos = 0;
            }
        }
    }   
    public void perder() { //este metodo crea una ventana de confirmacion que cierra el juego o crea uno nuevo
        mostrarSolucion();
        derrotaThread derrT = new derrotaThread();
        fondoT.interrupt();
        derrT.start();
        int res = JOptionPane.showConfirmDialog(null, "Has perdido, ¿Quieres jugar otra vez?", "¡Qué pena!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        while (res == -1) {
            res = JOptionPane.showConfirmDialog(null, "Has perdido, ¿Quieres jugar otra vez?", "¡Qué pena!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        }
        if (res == 0) {
            derrT.interrupt();
            dispose();
            new Juego().setVisible(true);
        } else if (res == 1) {
            derrT.interrupt();
            dispose();
        }
    }
    
    public void ganar() { //este metodo crea una ventana de confirmacion que cierra el juego o crea uno nuevo
        mostrarSolucion();
        victoriaThread vicT = new victoriaThread();
        fondoT.interrupt();
        vicT.start();
        int res = JOptionPane.showConfirmDialog(null, "Has ganado, ¿Quieres jugar otra vez?", "¡Felicidades!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (res == 0) {
            vicT.interrupt();
            dispose();
            new Juego().setVisible(true);
        } else if (res == 1) {
            vicT.interrupt();
            dispose();
        }
    }
    
    public void mostrarSolucion() { //este metodo muestra la solucion correcta
        for (int i = 0; i < solucion.size(); i++) {
            switch (solucion.get(i)) {
                case "amarillo":
                    URL urlAma = getClass().getResource("/recursos/amarillo.png");
                    JLabel lblAma = new JLabel(new ImageIcon(urlAma));
                    sup.add(lblAma);
                    sup.validate();
                    sup.repaint();
                    break;
                case "verde":
                    URL urlVer = getClass().getResource("/recursos/verde.png");
                    JLabel lblVer = new JLabel(new ImageIcon(urlVer));
                    sup.add(lblVer);
                    sup.validate();
                    sup.repaint();
                    break;
                case "azul":
                    URL urlAzu = getClass().getResource("/recursos/azul.png");
                    JLabel lblAzu = new JLabel(new ImageIcon(urlAzu));
                    sup.add(lblAzu);
                    sup.validate();
                    sup.repaint();
                    break;
                case "rojo":
                    URL urlRoj = getClass().getResource("/recursos/rojo.png");
                    JLabel lblRoj = new JLabel(new ImageIcon(urlRoj));
                    sup.add(lblRoj);
                    sup.validate();
                    sup.repaint();
                    break;
                case "violeta":
                    URL urlVio = getClass().getResource("/recursos/violeta.png");
                    JLabel lblVio = new JLabel(new ImageIcon(urlVio));
                    sup.add(lblVio);
                    sup.validate();
                    sup.repaint();
                    break;
                case "naranja":
                    URL urlNar = getClass().getResource("/recursos/naranja.png");
                    JLabel lblNar = new JLabel(new ImageIcon(urlNar));
                    sup.add(lblNar);
                    sup.validate();
                    sup.repaint();
                    break;
                case "rosa":
                    URL urlRos = getClass().getResource("/recursos/rosa.png");
                    JLabel lblRos = new JLabel(new ImageIcon(urlRos));
                    sup.add(lblRos);
                    sup.validate();
                    sup.repaint();
                    break;
                case "marron":
                    URL urlMar = getClass().getResource("/recursos/marron.png");
                    JLabel lblMar = new JLabel(new ImageIcon(urlMar));
                    sup.add(lblMar);
                    sup.validate();
                    sup.repaint();
                    break;
                case "celeste":
                    URL urlCel = getClass().getResource("/recursos/celeste.png");
                    JLabel lblCel = new JLabel(new ImageIcon(urlCel));
                    sup.add(lblCel);
                    sup.validate();
                    sup.repaint();
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        new Juego().setVisible(true);
        reglas();
    }
    
}
