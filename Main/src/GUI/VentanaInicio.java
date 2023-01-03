package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaInicio implements ActionListener {
    private JButton crearMundoNuevo;
    private JButton cargarMundo;
    private JButton salir;
    private JLabel tituloPrincipal;
    private JFrame VentanaInicio = new JFrame();

    public VentanaInicio (){
        tituloPrincipal = new JLabel("POOkemon");
        tituloPrincipal.setBounds(0,0,1600,400);
        tituloPrincipal.setIcon(new ImageIcon("./src/GUI/Imagenes/logo_200x200.png"));
        tituloPrincipal.setVerticalTextPosition(JLabel.BOTTOM);
        tituloPrincipal.setHorizontalTextPosition(JLabel.CENTER);
        tituloPrincipal.setHorizontalAlignment(JLabel.CENTER);
        tituloPrincipal.setFont(new Font("Courier New", Font.BOLD, 100));
        tituloPrincipal.setForeground(new Color (240, 245, 249));
        tituloPrincipal.setIconTextGap(20);

        crearMundoNuevo = new JButton("CREAR MUNDO NUEVO");
        crearMundoNuevo.setBounds(660,450,280,60);
        crearMundoNuevo.setHorizontalAlignment(JButton.CENTER);
        crearMundoNuevo.setFont(new Font("Courier New", Font.PLAIN, 20));
        crearMundoNuevo.setFocusable(false);
        crearMundoNuevo.setForeground(new Color (240, 245, 249));
        crearMundoNuevo.setBackground(new Color (58,71,80));
        crearMundoNuevo.setBorder(BorderFactory.createEtchedBorder());
        crearMundoNuevo.setIconTextGap(15);
        crearMundoNuevo.addActionListener(this);
        
        cargarMundo = new JButton("CARGAR MUNDO");
        cargarMundo.setBounds(660,520,280,60);
        cargarMundo.setHorizontalAlignment(JButton.CENTER);
        cargarMundo.setFont(new Font("Courier New", Font.PLAIN, 20));
        cargarMundo.setFocusable(false);
        cargarMundo.setForeground(new Color (240, 245, 249));
        cargarMundo.setBackground(new Color (58,71,80));
        cargarMundo.setIconTextGap(15);
        cargarMundo.setBorder(BorderFactory.createEtchedBorder());
        
        salir = new JButton("SALIR");
        salir.setBounds(750,790,100,60);
        salir.setHorizontalAlignment(JButton.CENTER);
        salir.setIcon(new ImageIcon("./src/GUI/Imagenes/exit.png"));
        salir.setFont(new Font("Courier New", Font.PLAIN, 18));
        salir.setFocusable(false);
        salir.setForeground(new Color (238,238,238));
        salir.setBackground(null);
        salir.setBorder(null);
        salir.setIconTextGap(10);
        salir.addActionListener(this);

        VentanaInicio.setIconImage(new ImageIcon("./src/GUI/Imagenes/logo.png").getImage());
        VentanaInicio.setTitle("POOkemon");
        VentanaInicio.setResizable(false);
        VentanaInicio.setSize(1600,900);
        VentanaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        VentanaInicio.getContentPane().setBackground(new Color (48,56,65));
        // VentanaInicio.setUndecorated(true);  
        VentanaInicio.setLayout(null);
        VentanaInicio.add(tituloPrincipal);
        VentanaInicio.add(crearMundoNuevo);
        VentanaInicio.add(cargarMundo);
        VentanaInicio.add(salir);
        VentanaInicio.setLocationRelativeTo(null);
        VentanaInicio.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==crearMundoNuevo){
            new VentanaMundo();
            VentanaInicio.dispose();
        }
        if (e.getSource()==cargarMundo){
            VentanaInicio.dispose();
        }
        if (e.getSource()==salir){
            VentanaInicio.dispose();
        }
    }


}
