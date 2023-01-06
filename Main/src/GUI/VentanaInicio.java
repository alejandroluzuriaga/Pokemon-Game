package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class VentanaInicio implements ActionListener {
    private JButton crearMundoNuevo;
    private JButton cargarMundo;
    private JButton salir;
    private JLabel tituloPrincipal;
    private JFrame VentanaInicio = new JFrame();

    private Color cLetra = new Color (240, 245, 249);
    private Color cBotonesOscuro = new Color (58,71,80);
    private Color cFondo = new Color (48,56,65);

    public VentanaInicio (){
        tituloPrincipal = new JLabel("POOkemon");
        tituloPrincipal.setBounds(0,0,1600,400);
        tituloPrincipal.setIcon(new ImageIcon("./src/GUI/Imagenes/logo_200x200.png"));
        tituloPrincipal.setVerticalTextPosition(JLabel.BOTTOM);
        tituloPrincipal.setHorizontalTextPosition(JLabel.CENTER);
        tituloPrincipal.setHorizontalAlignment(JLabel.CENTER);
        tituloPrincipal.setFont(new Font("Courier New", Font.BOLD, 100));
        tituloPrincipal.setForeground(cLetra);
        tituloPrincipal.setIconTextGap(20);

        crearMundoNuevo = new JButton("CREAR MUNDO NUEVO");
        crearMundoNuevo.setBounds(660,450,280,60);
        crearMundoNuevo.setHorizontalAlignment(JButton.CENTER);
        crearMundoNuevo.setFont(new Font("Courier New", Font.PLAIN, 20));
        crearMundoNuevo.setFocusable(false);
        crearMundoNuevo.setForeground(cLetra);
        crearMundoNuevo.setBackground(cBotonesOscuro);
        crearMundoNuevo.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        crearMundoNuevo.addActionListener(this);
        
        cargarMundo = new JButton("CARGAR MUNDO");
        cargarMundo.setBounds(660,520,280,60);
        cargarMundo.setHorizontalAlignment(JButton.CENTER);
        cargarMundo.setFont(new Font("Courier New", Font.PLAIN, 20));
        cargarMundo.setFocusable(false);
        cargarMundo.setForeground(cLetra);
        cargarMundo.setBackground(cBotonesOscuro);
        cargarMundo.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        cargarMundo.addActionListener(this);
        
        salir = new JButton("SALIR");
        salir.setBounds(750,790,100,60);
        salir.setHorizontalAlignment(JButton.CENTER);
        salir.setIcon(new ImageIcon("./src/GUI/Imagenes/exit.png"));
        salir.setFont(new Font("Courier New", Font.PLAIN, 18));
        salir.setFocusable(false);
        salir.setForeground(cLetra);
        salir.setBackground(null);
        salir.setBorder(null);
        salir.setIconTextGap(10);
        salir.addActionListener(this);

        VentanaInicio.setIconImage(new ImageIcon("./src/GUI/Imagenes/logo.png").getImage());
        VentanaInicio.setTitle("POOkemon");
        VentanaInicio.setResizable(false);
        VentanaInicio.setSize(1600,900);
        VentanaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VentanaInicio.getContentPane().setBackground(cFondo); 
        VentanaInicio.setLayout(null);
        VentanaInicio.setUndecorated(true);
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
            JFileChooser seleccionadorArchivo = new JFileChooser();
            seleccionadorArchivo.setCurrentDirectory(new File("."));
            int respuesta = seleccionadorArchivo.showOpenDialog(null);
            if (respuesta == seleccionadorArchivo.APPROVE_OPTION){
                File archivo = new File(seleccionadorArchivo.getSelectedFile().getAbsolutePath());
            }
            VentanaMundo mundo = new VentanaMundo();
            // mundo.cargarfichero(archivo);
            VentanaInicio.dispose();
        }
        if (e.getSource()==salir){
            VentanaInicio.dispose();
        }
    }


}
