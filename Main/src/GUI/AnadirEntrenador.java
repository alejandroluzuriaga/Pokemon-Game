package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AnadirEntrenador implements ActionListener{
    private JFrame VentanaNuevoEntrenador = new JFrame();
    private JToggleButton botonLoreto;
    private JToggleButton botonSilvia;
    private JToggleButton botonOleksandr;
    private JToggleButton botonAlejandro;
    private JButton botonLimpiar;
    private ButtonGroup grupoEntrenadores;
    private JLabel imagenPersonaje;
    private JButton botonGuardar;
    private JButton boton;
    

    private Color cLetra = new Color (240, 245, 249);
    private Color cBotonesClaro = new Color (201,214,223);
    private Color cBotonesOscuro = new Color (58,71,80);
    private Color cFondo = new Color (48,56,65);
    
    AnadirEntrenador(){
        botonLoreto = new JToggleButton("LORETO");
            botonLoreto.setBounds(100,45,170,40);
            modificarBotonSeleccionEntrenador(botonLoreto);
            botonLoreto.addActionListener(this);

        botonSilvia = new JToggleButton("SILVIA");
            botonSilvia.setBounds(100,95,170,40);
            modificarBotonSeleccionEntrenador(botonSilvia);
            botonSilvia.addActionListener(this);

        botonOleksandr = new JToggleButton("OLEKSANDR");
            botonOleksandr.setBounds(100,145,170,40);
            modificarBotonSeleccionEntrenador(botonOleksandr);
            botonOleksandr.addActionListener(this);

        botonAlejandro = new JToggleButton("ALEJANDRO");
            botonAlejandro.setBounds(100,195,170,40);
            modificarBotonSeleccionEntrenador(botonAlejandro);
            botonAlejandro.addActionListener(this);

        botonLimpiar = new JButton("Quitar Selección");
            botonLimpiar.setBounds(100,285,170,40);
            botonLimpiar.setFont(new Font("Courier New", Font.ITALIC, 12));
            botonLimpiar.setFocusable(false);
            botonLimpiar.setForeground(cLetra);
            botonLimpiar.setBackground(null);
            botonLimpiar.setBorder(null);
            botonLimpiar.addActionListener(this);

        grupoEntrenadores = new ButtonGroup();
            grupoEntrenadores.add(botonLoreto);
            grupoEntrenadores.add(botonSilvia);
            grupoEntrenadores.add(botonOleksandr);
            grupoEntrenadores.add(botonAlejandro);
            grupoEntrenadores.add(botonLimpiar);

        JPanel elegirPersonaje = new JPanel();
            elegirPersonaje.setLayout(null);
            elegirPersonaje.setBackground(cFondo);
            elegirPersonaje.add(botonLoreto);
            elegirPersonaje.add(botonSilvia);
            elegirPersonaje.add(botonOleksandr);
            elegirPersonaje.add(botonAlejandro);
            elegirPersonaje.add(botonLimpiar);

        imagenPersonaje = new JLabel();
            imagenPersonaje.setVerticalAlignment(JLabel.CENTER);
            imagenPersonaje.setHorizontalAlignment(JLabel.CENTER);

        JPanel panelPersonajes = new JPanel();
            panelPersonajes.setLayout(new GridLayout(1,2,0,0));
            panelPersonajes.setBackground(cFondo);
            panelPersonajes.add(elegirPersonaje);
            panelPersonajes.add(imagenPersonaje);

        botonGuardar = new JButton("GUARDAR");
            botonGuardar.setBounds(20,0,645,80);
            botonGuardar.setHorizontalAlignment(JButton.CENTER);
            botonGuardar.setIcon(new ImageIcon("lib/botonGuardar.png"));
            botonGuardar.setFont(new Font("Courier New", Font.BOLD, 25));
            botonGuardar.setFocusable(false);
            botonGuardar.setForeground(cBotonesOscuro);
            botonGuardar.setBackground(cBotonesClaro);
            botonGuardar.setBorder(BorderFactory.createEtchedBorder());
            botonGuardar.addActionListener(this);

        JPanel panelGuardar = new JPanel();
        panelGuardar.setLayout(null);
        panelGuardar.setPreferredSize(new Dimension(0,100));
        panelGuardar.setBackground(cFondo);
        panelGuardar.add(botonGuardar);

    
        VentanaNuevoEntrenador.setIconImage(new ImageIcon("./src/GUI/Imagenes/logo.png").getImage());
        VentanaNuevoEntrenador.setTitle("POOkemon");
        VentanaNuevoEntrenador.setResizable(false);
        VentanaNuevoEntrenador.setSize(700,500);
        VentanaNuevoEntrenador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        VentanaNuevoEntrenador.getContentPane().setBackground(cFondo);
        VentanaNuevoEntrenador.setLayout(new BorderLayout());
        VentanaNuevoEntrenador.setLocationRelativeTo(null);
        VentanaNuevoEntrenador.add(panelPersonajes, BorderLayout.CENTER);
        VentanaNuevoEntrenador.add(panelGuardar, BorderLayout.SOUTH);
        VentanaNuevoEntrenador.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonLoreto){
            imagenPersonaje.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Loreto_G.png"));
        }
        if(e.getSource()==botonSilvia){
            imagenPersonaje.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Silvia_G.png"));
        }
        if(e.getSource()==botonOleksandr){
            imagenPersonaje.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Oleksandr_G.png"));
        }
        if(e.getSource()==botonAlejandro){
            imagenPersonaje.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Alejandro_G.png"));
        }
        if(e.getSource()==botonLimpiar){
            grupoEntrenadores.clearSelection();
            imagenPersonaje.setIcon(null);
        }
        if(e.getSource()==botonGuardar){
            if(botonLoreto.isSelected()){
                if (!(VentanaMundo.iVentanaMundo.contieneEntrenador("LORETO"))){
                    crearCasilla("LORETO");
                    VentanaNuevoEntrenador.dispose();
                    actualizarVentana();
                }else{
                    VentanaNuevoEntrenador.dispose();
                }
            } else if(botonSilvia.isSelected()){
                if (!(VentanaMundo.iVentanaMundo.contieneEntrenador("SILVIA"))){
                    crearCasilla("SILVIA");
                    VentanaNuevoEntrenador.dispose();
                    actualizarVentana();
                }else{
                    VentanaNuevoEntrenador.dispose();
                }
            } else if(botonOleksandr.isSelected()){
                if (!(VentanaMundo.iVentanaMundo.contieneEntrenador("OLEKSANDR"))){
                    crearCasilla("OLEKSANDR");
                    VentanaNuevoEntrenador.dispose();
                    actualizarVentana();
                }else{
                    VentanaNuevoEntrenador.dispose();
                }
            } else if(botonAlejandro.isSelected()){
                if (!(VentanaMundo.iVentanaMundo.contieneEntrenador("ALEJANDRO"))){
                    crearCasilla("ALEJANDRO");
                    VentanaNuevoEntrenador.dispose();
                    actualizarVentana();
                }else{
                    VentanaNuevoEntrenador.dispose();
                }
            } else {System.out.println("Error");}
        }
    }

    public void modificarBotonSeleccionEntrenador (JToggleButton boton){
        boton.setFont(new Font("Courier New", Font.BOLD, 15));
        boton.setFocusable(false);
        boton.setForeground(cLetra);
        boton.setBackground(cBotonesOscuro);
        boton.setBorder(BorderFactory.createEtchedBorder());
    }

    public void crearCasilla (String nombre){
        boton = new JButton(nombre);
        boton.setPreferredSize(new Dimension(0,70));
        boton.setBackground(new Color (238,238,238));
        boton.setFocusable(false);
        boton.setFont(new Font("Courier New", Font.BOLD, 16));
        if (nombre=="LORETO"){
            boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Loreto_60.png"));
        } else if (nombre == "SILVIA"){
            boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Silvia_60.png"));
        } else if (nombre == "OLEKSANDR"){
            boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Oleksandr_60.png"));
        } else if (nombre == "ALEJANDRO"){
            boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Alejandro_60.png"));
        }

        boton.setHorizontalAlignment(JButton.CENTER);
        boton.setHorizontalTextPosition(JButton.LEFT);
        boton.setIconTextGap(20);
        VentanaMundo.iVentanaMundo.getBotonesE().add(boton);
        VentanaMundo.iVentanaMundo.getPanelListaEntrenadores().add(boton);
        VentanaMundo.iVentanaMundo.getPanelListaEntrenadores().getComponents();
    }



    public void actualizarVentana(){
        VentanaMundo.iVentanaMundo.getVentanaNuevoMundo().invalidate();
        VentanaMundo.iVentanaMundo.getVentanaNuevoMundo().validate();
        VentanaMundo.iVentanaMundo.getVentanaNuevoMundo().repaint();
    }
}


