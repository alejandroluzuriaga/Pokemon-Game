package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Pookemon.*;


public class AnadirPokemon implements ActionListener{
    public static AnadirPokemon iAnadirPokemon;
    
    private JFrame VentanaNuevoPokemon = new JFrame();
    private JToggleButton botonBulbasaur;
    private JToggleButton botonCharmander;
    private JToggleButton botonRattata;
    private JToggleButton botonSquirtle;
    private JToggleButton botonCharmeleon;
    private JToggleButton botonBlastoise;
    private JToggleButton botonAleatorio;
    private JButton botonLimpiar;
    private ButtonGroup grupoPokemons;
    private JTextField nombrePokemon;
    private JPanel espacioNombre;
    private JLabel imagenPokemon;
    private JButton botonGuardarPokemon;

    private Color cLetra = new Color (240, 245, 249);
    private Color cBotonesClaro = new Color (201,214,223);
    private Color cBotonesOscuro = new Color (58,71,80);
    private Color cFondo = new Color (48,56,65);
    
    AnadirPokemon(){
        iAnadirPokemon=this;

        botonBulbasaur = new JToggleButton("BULBASAUR");
            botonBulbasaur.setBounds(200,45,170,40);
            modificarBotonSeleccionPokemon(botonBulbasaur);
            botonBulbasaur.addActionListener(this);

        botonCharmander = new JToggleButton("CHARMANDER");
            botonCharmander.setBounds(200,95,170,40);
            modificarBotonSeleccionPokemon(botonCharmander);
            botonCharmander.addActionListener(this);

        botonRattata = new JToggleButton("RATTATA");
            botonRattata.setBounds(200,145,170,40);
            modificarBotonSeleccionPokemon(botonRattata);
            botonRattata.addActionListener(this);

        botonSquirtle = new JToggleButton("SQUIRTLE");
            botonSquirtle.setBounds(200,195,170,40);
            modificarBotonSeleccionPokemon(botonSquirtle);
            botonSquirtle.addActionListener(this);

        botonCharmeleon = new JToggleButton("CHARMALEON");
            botonCharmeleon.setBounds(200,270,170,40);
            modificarBotonSeleccionPokemon(botonCharmeleon);
            botonCharmeleon.addActionListener(this);

        botonBlastoise = new JToggleButton("BLASTOISE");
            botonBlastoise.setBounds(200,320,170,40);
            modificarBotonSeleccionPokemon(botonBlastoise);
            botonBlastoise.addActionListener(this);

        botonAleatorio = new JToggleButton("ALEATORIO");
            botonAleatorio.setBounds(50,175,100,60);
            botonAleatorio.setIcon(new ImageIcon("./src/GUI/Imagenes/dado_30_oscuro.png"));
            botonAleatorio.setRolloverIcon(new ImageIcon("./src/GUI/Imagenes/dado_30.png"));
            botonAleatorio.setVerticalTextPosition(JToggleButton.BOTTOM);
            botonAleatorio.setHorizontalTextPosition(JToggleButton.CENTER);
            botonAleatorio.setFont(new Font("Courier New", Font.ITALIC, 12));
            botonAleatorio.setFocusable(false);
            botonAleatorio.setForeground(cLetra);
            botonAleatorio.setBackground(null);
            botonAleatorio.setBorder(null);
            botonAleatorio.addActionListener(this);

        botonLimpiar = new JButton("Quitar Selección");
            botonLimpiar.setBounds(100,390,170,40);
            botonLimpiar.setFont(new Font("Courier New", Font.ITALIC, 12));
            botonLimpiar.setFocusable(false);
            botonLimpiar.setForeground(cLetra);
            botonLimpiar.setBackground(null);
            botonLimpiar.setBorder(null);
            botonLimpiar.addActionListener(this);

        grupoPokemons = new ButtonGroup();
            grupoPokemons.add(botonBulbasaur);
            grupoPokemons.add(botonCharmander);
            grupoPokemons.add(botonRattata);
            grupoPokemons.add(botonSquirtle);
            grupoPokemons.add(botonCharmeleon);
            grupoPokemons.add(botonBlastoise);
            grupoPokemons.add(botonAleatorio);
            grupoPokemons.add(botonLimpiar);

        JPanel elegirPokemon = new JPanel();
            elegirPokemon.setLayout(null);
            elegirPokemon.setBackground(cFondo);
            elegirPokemon.add(botonBulbasaur);
            elegirPokemon.add(botonCharmander);
            elegirPokemon.add(botonRattata);
            elegirPokemon.add(botonSquirtle);
            elegirPokemon.add(botonCharmeleon);
            elegirPokemon.add(botonBlastoise);
            elegirPokemon.add(botonAleatorio);
            elegirPokemon.add(botonLimpiar);

        imagenPokemon = new JLabel();
            imagenPokemon.setVerticalAlignment(JLabel.CENTER);
            imagenPokemon.setHorizontalAlignment(JLabel.CENTER);

        JLabel mensajeNombre = new JLabel("PONLE UN NOMBRE:");
            mensajeNombre.setBounds(0,0,100,50);
            mensajeNombre.setFont(new Font("Courier New", Font.BOLD, 14));
            mensajeNombre.setForeground(cLetra);
        
        nombrePokemon = new JTextField();
            nombrePokemon.setPreferredSize(new Dimension(200,30));
            nombrePokemon.setFont(new Font("Courier New", Font.PLAIN, 14));
            nombrePokemon.setBackground(cBotonesClaro);
            nombrePokemon.setCaretColor(cBotonesOscuro);
            nombrePokemon.setHorizontalAlignment(JTextField.CENTER);

        espacioNombre = new JPanel();
            espacioNombre.setPreferredSize(new Dimension(0,50));
            espacioNombre.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
            espacioNombre.setBackground(cFondo);
            espacioNombre.add(mensajeNombre);
            espacioNombre.add(nombrePokemon);
            espacioNombre.setVisible(false);

        JLabel panelImagenNombre = new JLabel();
            panelImagenNombre.setLayout(new BorderLayout());
            panelImagenNombre.setBackground(cFondo);
            panelImagenNombre.add(imagenPokemon, BorderLayout.CENTER);
            panelImagenNombre.add(espacioNombre, BorderLayout.SOUTH);

        JPanel panelPokemons = new JPanel();
            panelPokemons.setLayout(new GridLayout(1,2,0,0));
            panelPokemons.setBackground(cFondo);
            panelPokemons.add(elegirPokemon);
            panelPokemons.add(panelImagenNombre);

        botonGuardarPokemon = new JButton("GUARDAR");
            botonGuardarPokemon.setBounds(20,0,845,80);
            botonGuardarPokemon.setHorizontalAlignment(JButton.CENTER);
            botonGuardarPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/guardar_40.png"));
            botonGuardarPokemon.setIconTextGap(15);
            botonGuardarPokemon.setFont(new Font("Courier New", Font.BOLD, 25));
            botonGuardarPokemon.setFocusable(false);
            botonGuardarPokemon.setForeground(cBotonesOscuro);
            botonGuardarPokemon.setBackground(cBotonesClaro);
            botonGuardarPokemon.setBorder(BorderFactory.createEtchedBorder());
            botonGuardarPokemon.addActionListener(this);

        JPanel panelGuardar = new JPanel();
            panelGuardar.setLayout(null);
            panelGuardar.setPreferredSize(new Dimension(0,100));
            panelGuardar.setBackground(cFondo);
            panelGuardar.add(botonGuardarPokemon);

    
        VentanaNuevoPokemon.setIconImage(new ImageIcon("./src/GUI/Imagenes/logo.png").getImage());
        VentanaNuevoPokemon.setTitle("POOkemon");
        VentanaNuevoPokemon.setResizable(false);
        VentanaNuevoPokemon.setSize(900,600);
        VentanaNuevoPokemon.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        VentanaNuevoPokemon.getContentPane().setBackground(cFondo);
        VentanaNuevoPokemon.setLayout(new BorderLayout());
        VentanaNuevoPokemon.setLocationRelativeTo(null);
        VentanaNuevoPokemon.add(panelPokemons, BorderLayout.CENTER);
        VentanaNuevoPokemon.add(panelGuardar, BorderLayout.SOUTH);
        VentanaNuevoPokemon.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonBulbasaur){
            imagenPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Bulbasaur.png"));
            espacioNombre.setVisible(true);
        }
        if(e.getSource()==botonCharmander){
            imagenPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Charmander.png"));
            espacioNombre.setVisible(true);
        }
        if(e.getSource()==botonRattata){
            imagenPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Rattata.png"));
            espacioNombre.setVisible(true);
        }
        if(e.getSource()==botonSquirtle){
            imagenPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Squirtle.png"));
            espacioNombre.setVisible(true);
        }
        if(e.getSource()==botonCharmeleon){
            imagenPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Charmeleon.png"));
            espacioNombre.setVisible(true);
        }
        if(e.getSource()==botonBlastoise){
            imagenPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Blastoise.png"));
            espacioNombre.setVisible(true);
        }
        if(e.getSource()==botonAleatorio){
            imagenPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/pregunta.png"));
            espacioNombre.setVisible(true);
        }
        if(e.getSource()==botonLimpiar){
            grupoPokemons.clearSelection();
            imagenPokemon.setIcon(null);
            espacioNombre.setVisible(false);
        }
        if(e.getSource()==botonGuardarPokemon){
            if(botonBulbasaur.isSelected()){
                crearCasilla("BULBASAUR",nombrePokemon.getText());
                VentanaMundo.iVentanaMundo.actualizarVentana();
            } else if(botonCharmander.isSelected()){
                crearCasilla("CHARMANDER",nombrePokemon.getText());
                VentanaMundo.iVentanaMundo.actualizarVentana();
            } else if(botonRattata.isSelected()){
                crearCasilla("RATTATA",nombrePokemon.getText());
                VentanaMundo.iVentanaMundo.actualizarVentana();
            } else if(botonSquirtle.isSelected()){
                crearCasilla("SQUIRTLE",nombrePokemon.getText());
                VentanaMundo.iVentanaMundo.actualizarVentana();
            } else if(botonCharmeleon.isSelected()){
                crearCasilla("CHARMALEON",nombrePokemon.getText());
                VentanaMundo.iVentanaMundo.actualizarVentana();
            } else if(botonBlastoise.isSelected()){
                crearCasilla("BLASTOISE",nombrePokemon.getText());
                VentanaMundo.iVentanaMundo.actualizarVentana();
            } else if(botonAleatorio.isSelected()){
                String tipo;
                int i = (int) Math.floor(Math.random()*(6-1+1)+1);
                switch (i){
                    case 1:
                        tipo="BULBASAUR";
                        break;
                    case 2:
                        tipo="CHARMANDER";
                        break;
                    case 3: 
                        tipo="RATTATA";
                        break;
                    case 4: 
                        tipo="SQUIRTLE";
                        break;
                    case 5: 
                        tipo="CHARMALEON";
                        break;
                    case 6: 
                        tipo="BLASTOISE";
                        break;
                    default: 
                        tipo="";
                        break;
                }
                crearCasilla(tipo, nombrePokemon.getText());
                VentanaNuevoPokemon.dispose();
                VentanaMundo.iVentanaMundo.actualizarVentana();
            }
        }
    }

    public void modificarBotonSeleccionPokemon (JToggleButton boton){
        boton.setFont(new Font("Courier New", Font.BOLD, 15));
        boton.setFocusable(false);
        boton.setForeground(cLetra);
        boton.setBackground(cBotonesOscuro);
        boton.setBorder(BorderFactory.createEtchedBorder());
    }

    public void crearCasilla (String tipo, String nombre){
        if (nombre.length()!=0 && !(VentanaMundo.iVentanaMundo.existeNombre(nombre))){
            ToggleBotonPokemonEntrenador boton = new ToggleBotonPokemonEntrenador();
            boton.setText(nombre);
            boton.setPreferredSize(new Dimension(0,70));
            boton.setBackground(cLetra);
            boton.setForeground(cBotonesOscuro);
            boton.setFocusable(false);
            boton.setFont(new Font("Courier New", Font.BOLD, 16));
            boton.setHorizontalAlignment(JButton.CENTER);
            boton.setHorizontalTextPosition(JButton.LEFT);
            boton.setIconTextGap(20);
            boton.addActionListener(VentanaMundo.iVentanaMundo);
            if (tipo=="BULBASAUR"){
                boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Bulbasaur_60.png"));
                boton.setPokemon(new Bulbasur(1, nombre));
            } else if (tipo == "CHARMANDER"){
                boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Charmander_60.png"));
                boton.setPokemon(new Charmander(1, nombre));
            } else if (tipo == "RATTATA"){
                boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Rattata_60.png"));
                boton.setPokemon(new Rattata(1, nombre));
            } else if (tipo == "SQUIRTLE"){
                boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Squirtle_60.png"));
                boton.setPokemon(new Squirtle(1, nombre));
            } else if (tipo == "CHARMALEON"){
                boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Charmeleon_60.png"));
                boton.setPokemon(new Charmeleon(1, nombre));
            } else if (tipo == "BLASTOISE"){
                boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Blastoise_60.png"));
                boton.setPokemon(new Blastoise(1, nombre));
            }

            VentanaMundo.iVentanaMundo.getBotonesPokemon().add(boton);
            VentanaMundo.iVentanaMundo.getPanelListaPokemons().add(boton);
            VentanaMundo.iVentanaMundo.getGrupoBotones1().add(boton);
            VentanaNuevoPokemon.dispose();

        } else if (VentanaMundo.iVentanaMundo.existeNombre(nombre)){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error. No pueden haber dos nombres iguales", "Error", JOptionPane.ERROR_MESSAGE);
            nombrePokemon.setText("");
        } else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Tienes que especificar un nombre.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JButton getBotonGuardarPokemon() {
        return botonGuardarPokemon;
    }
}


