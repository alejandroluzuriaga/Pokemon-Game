package GUI;

import javax.swing.*;

import Entrenador.Entrenador;

import java.awt.*;
import java.awt.event.*;


public class AnadirEntrenador implements ActionListener{
    public static AnadirEntrenador iAnadirEntrenador;

    private JFrame VentanaNuevoEntrenador = new JFrame();
    private JToggleButton botonLoreto;
    private JToggleButton botonSilvia;
    private JToggleButton botonOleksandr;
    private JToggleButton botonAlejandro;
    private JButton botonLimpiar;
    private ButtonGroup grupoEntrenadores;
    private JLabel imagenPersonaje;
    private JButton botonGuardarEntrenador;
    

    private Color cLetra = new Color (240, 245, 249);
    private Color cBotonesClaro = new Color (201,214,223);
    private Color cBotonesOscuro = new Color (58,71,80);
    private Color cFondo = new Color (48,56,65);
    
    AnadirEntrenador(){
        iAnadirEntrenador=this;

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
            botonLimpiar.setBounds(100,290,170,40);
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

        botonGuardarEntrenador = new JButton("GUARDAR");
            botonGuardarEntrenador.setBounds(20,0,645,80);
            botonGuardarEntrenador.setHorizontalAlignment(JButton.CENTER);
            botonGuardarEntrenador.setIcon(new ImageIcon("./src/GUI/Imagenes/guardar_40.png"));
            botonGuardarEntrenador.setIconTextGap(15);
            botonGuardarEntrenador.setFont(new Font("Courier New", Font.BOLD, 25));
            botonGuardarEntrenador.setFocusable(false);
            botonGuardarEntrenador.setForeground(cBotonesOscuro);
            botonGuardarEntrenador.setBackground(cBotonesClaro);
            botonGuardarEntrenador.setBorder(BorderFactory.createEtchedBorder());
            botonGuardarEntrenador.addActionListener(this);

        JPanel panelGuardar = new JPanel();
        panelGuardar.setLayout(null);
        panelGuardar.setPreferredSize(new Dimension(0,100));
        panelGuardar.setBackground(cFondo);
        panelGuardar.add(botonGuardarEntrenador);

    
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
        if(e.getSource()==botonGuardarEntrenador){
            if(botonLoreto.isSelected()){
                if (!(VentanaMundo.iVentanaMundo.contieneEntrenador("LORETO"))){
                    crearCasilla("LORETO");
                    VentanaMundo.iVentanaMundo.actualizarVentana();
                }else{
                    JOptionPane.showMessageDialog(null, "El entrenador selecionado ya existe", "Atención", JOptionPane.ERROR_MESSAGE);
                }
            } else if(botonSilvia.isSelected()){
                if (!(VentanaMundo.iVentanaMundo.contieneEntrenador("SILVIA"))){
                    crearCasilla("SILVIA");
                    VentanaMundo.iVentanaMundo.actualizarVentana();
                }else{
                    JOptionPane.showMessageDialog(null, "El entrenador selecionado ya existe", "Atención", JOptionPane.ERROR_MESSAGE);
                }
            } else if(botonOleksandr.isSelected()){
                if (!(VentanaMundo.iVentanaMundo.contieneEntrenador("OLEKSANDR"))){
                    crearCasilla("OLEKSANDR");
                    VentanaMundo.iVentanaMundo.actualizarVentana();
                }else{
                    JOptionPane.showMessageDialog(null, "El entrenador selecionado ya existe", "Atención", JOptionPane.ERROR_MESSAGE);
                }
            } else if(botonAlejandro.isSelected()){
                if (!(VentanaMundo.iVentanaMundo.contieneEntrenador("ALEJANDRO"))){
                    crearCasilla("ALEJANDRO");
                    VentanaMundo.iVentanaMundo.actualizarVentana();
                }else{
                    JOptionPane.showMessageDialog(null, "El entrenador selecionado ya existe", "Atención", JOptionPane.ERROR_MESSAGE);
                }
            }
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
        ToggleBotonPokemonEntrenador boton = new ToggleBotonPokemonEntrenador();
        boton.setText(nombre);
        boton.setPreferredSize(new Dimension(0,70));
        boton.setBackground(cLetra);
        boton.setFocusable(false);
        boton.setFont(new Font("Courier New", Font.BOLD, 16));
        boton.setHorizontalAlignment(JButton.CENTER);
        boton.setHorizontalTextPosition(JButton.LEFT);
        boton.setIconTextGap(20);
        boton.addActionListener(VentanaMundo.iVentanaMundo);
        if (nombre=="LORETO"){
            boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Loreto_60.png"));
            boton.setEntrenador(new Entrenador(nombre, 0));
        } else if (nombre == "SILVIA"){
            boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Silvia_60.png"));
            boton.setEntrenador(new Entrenador(nombre, 1));
        } else if (nombre == "OLEKSANDR"){
            boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Oleksandr_60.png"));
            boton.setEntrenador(new Entrenador(nombre, 2));
        } else if (nombre == "ALEJANDRO"){
            boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Alejandro_60.png"));
            boton.setEntrenador(new Entrenador(nombre, 3));
        }

        VentanaMundo.iVentanaMundo.getBotonesE().add(boton);
        VentanaMundo.iVentanaMundo.getPanelListaEntrenadores().add(boton);
        VentanaMundo.iVentanaMundo.getGrupoBotones1().add(boton);
        VentanaNuevoEntrenador.dispose();
    }

}


