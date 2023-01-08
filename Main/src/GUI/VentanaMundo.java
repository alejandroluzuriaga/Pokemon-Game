package GUI;

import javax.swing.*;
import Entrenador.*;
import Movimiento.Movimiento;
import Pookemon.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;

public class VentanaMundo extends JFrame implements ActionListener{
    public static VentanaMundo iVentanaMundo;

    private JButton volver;
    private JLabel tituloMundo;
    private int random = (int) Math.floor(Math.random()*1000+1);
    private File ruta = new File("./src/Mundos/Mundo_" + random + ".txt");

    private JPanel panelPokemons;
    private JPanel panelListaPokemons;
    private JButton anadirPokemon;
    private JTextField nombrePokemonSeleccionado;
    private JTextField tipoPokemonSeleccionado;
    private JTextField nivelPokemonSeleccionado;
    private JTextField saludoPokemonSeleccionado;
    private JTextField entrenadorPokemonSeleccionado;
    private JTextField poderPokemonSeleccionado;
    private JTextField poderEspecialPokemonSeleccionado;
    private JTextField defensaPokemonSeleccionado;
    private JTextField defensaEspecialPokemonSeleccionado;
    private JTextField velocidadPokemonSeleccionado;
    private JTextField saludMaxPokemonSeleccionado;
    private JTextField mopvimientosPokemonSeleccionado;
    private JPanel panelEtiquetas;
    private JPanel panelDetalles;
    private JButton botonModificar;
    private JButton botonEliminarPokemon;
    private JButton botonGuardarDetalles;
    private JPanel panelBotonesModDel;
    private JPanel panelControl;
    private ButtonGroup grupoBotonesSeleccionar = new ButtonGroup();
    
    private JPanel panelEntrenadores;
    private JPanel panelListaEntrenadores;
    private JButton anadirEntrenador;
    private ArrayList<BotonPokemon> botonesPokemonsDisponibles = new ArrayList<>();
    private JButton asignarPokemon;
    private JScrollPane panelScrollPokemonsDisponibles;
    private JPanel panelPokemonsDisponibles = new JPanel();
    private JButton boton1Eliminar;
    private JButton boton2Eliminar;
    private JButton boton3Eliminar;
    private JButton botonCombatir;
    private JButton botonEliminarEntrenador;
    private JPanel panelEntrenadoresCombate;

    private JButton botonGuardarMundo;

    private Color cLetra = new Color (240, 245, 249);
    private Color cBotonesClaro = new Color (201,214,223);
    private Color cBotonesOscuro = new Color (58,71,80);
    private Color cFondo = new Color (48,56,65);
    

    public VentanaMundo(){
        iVentanaMundo = this;
        
        // VOLVER ///////////////////////////////////////////////////////////////////////////////////
        volver = new JButton("VOLVER");
            volver.setBounds(15,15,135,40);
            volver.setHorizontalAlignment(JButton.CENTER);
            volver.setIcon(new ImageIcon("./src/GUI/Imagenes/volver.png"));
            volver.setRolloverIcon(new ImageIcon("./src/GUI/Imagenes/volver_claro.png"));
            volver.setFont(new Font("Courier New", Font.PLAIN, 18));
            volver.setFocusable(false);
            volver.setForeground(cLetra);
            volver.setIconTextGap(10);
            volver.setBackground(null);
            volver.setBorder(null);       
            volver.addActionListener(this);
        

        // TIUTLO MUNDO /////////////////////////////////////////////////////////////////////////////
        tituloMundo = new JLabel("MUNDO");
            tituloMundo.setBounds(0,0,1600,100);
            tituloMundo.setIcon(new ImageIcon("./src/GUI/Imagenes/createWorld.png"));
            tituloMundo.setHorizontalAlignment(JLabel.CENTER);
            tituloMundo.setFont(new Font("Courier New", Font.BOLD, 50));
            tituloMundo.setForeground(cLetra);
            tituloMundo.setIconTextGap(10);

            
            // TITULO (PANEL POKEMONS) //////////////////////////////////////////////////////////////
            JLabel tituloPokemons = new JLabel("POKEMONS");
                tituloPokemons.setHorizontalAlignment(JLabel.CENTER);
                tituloPokemons.setPreferredSize(new Dimension(0,80));
                tituloPokemons.setFont(new Font("Courier New", Font.BOLD, 24));
                tituloPokemons.setForeground(cLetra);
            
            // LISTA POKEMONS (PANEL POKEMONS) /////////////////////////////////////////////////////
            panelListaPokemons = new JPanel();
                panelListaPokemons.setLayout(new GridLayout(0,1,0,5));
                panelListaPokemons.setBackground(cLetra);
            
            // LISTA POKEMONS + SCROLL (PANEL POKEMONS) ///////////////////////////////////////////
            JScrollPane panelScrollPokemons = new JScrollPane(panelListaPokemons, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            // ANADIR POKEMON (PANEL POKEMONS) /////////////////////////////////////////////////////
            anadirPokemon = new JButton("Añadir Pokemon");
                anadirPokemon.setPreferredSize(new Dimension(0,40));
                anadirPokemon.setHorizontalAlignment(JLabel.CENTER);
                anadirPokemon.setFont(new Font("Courier New", Font.BOLD, 12));
                anadirPokemon.setFocusable(false);
                anadirPokemon.setForeground(cBotonesOscuro);
                anadirPokemon.setBackground(cBotonesClaro);
                anadirPokemon.addActionListener(this);

        // PANEL POKEMONS ///////////////////////////////////////////////////////////////////////////
        panelPokemons = new JPanel();
            panelPokemons.setBounds(150,170,300,500);
            panelPokemons.setBackground(cBotonesOscuro);
            panelPokemons.setBorder(BorderFactory.createEtchedBorder());
            panelPokemons.setLayout(new BorderLayout());
            panelPokemons.add(tituloPokemons, BorderLayout.NORTH);
            panelPokemons.add(panelScrollPokemons, BorderLayout.CENTER);
            panelPokemons.add(anadirPokemon, BorderLayout.SOUTH);
        
        
            // TITULO (PANEL ENTRENADORES) /////////////////////////////////////////////////////////
            JLabel tituloEntrenadores = new JLabel("ENTRENADORES");
                tituloEntrenadores.setHorizontalAlignment(JLabel.CENTER);
                tituloEntrenadores.setPreferredSize(new Dimension(0,80));
                tituloEntrenadores.setFont(new Font("Courier New", Font.BOLD, 25));
                tituloEntrenadores.setForeground(cLetra);
            
            // LISTA ENTRENADORES (PANEL ENTRENADORES) ////////////////////////////////////////////
            panelListaEntrenadores = new JPanel();
                panelListaEntrenadores.setLayout(new GridLayout(0,1,0,5));
                panelListaEntrenadores.setBackground(cLetra);

            // LISTA ENTRENADORES + SCROLL (PANEL ENTRENADORES) ///////////////////////////////////
            JScrollPane panelScrollEntrenadores = new JScrollPane(panelListaEntrenadores, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            // ANADIR ENTRENADOR (PANEL ENTRENADORES) /////////////////////////////////////////////
            anadirEntrenador = new JButton("Añadir Entrenador");
                anadirEntrenador.setPreferredSize(new Dimension(0,40));
                anadirEntrenador.setHorizontalAlignment(JLabel.CENTER);
                anadirEntrenador.setFont(new Font("Courier New", Font.BOLD, 12));
                anadirEntrenador.setFocusable(false);
                anadirEntrenador.setForeground(cBotonesOscuro);
                anadirEntrenador.setBackground(cBotonesClaro);
                anadirEntrenador.addActionListener(this);

        // PANEL ENTRENADORES ///////////////////////////////////////////////////////////////////////
        panelEntrenadores = new JPanel();
            panelEntrenadores.setBounds(1150,170,300,500);
            panelEntrenadores.setBackground(cBotonesOscuro);
            panelEntrenadores.setBorder(BorderFactory.createEtchedBorder());
            panelEntrenadores.setLayout(new BorderLayout());
            panelEntrenadores.add(tituloEntrenadores, BorderLayout.NORTH);
            panelEntrenadores.add(panelScrollEntrenadores, BorderLayout.CENTER);
            panelEntrenadores.add(anadirEntrenador, BorderLayout.SOUTH);


        // PANEL DETALLES ///////////////////////////////////////////////////////////////////////
        panelControl = new JPanel();
            panelControl.setBounds(500, 250, 600, 380);
            panelControl.setBackground(cBotonesOscuro);
            panelControl.setBorder(BorderFactory.createEtchedBorder());
            panelControl.setLayout(new BorderLayout());
            panelControl.setVisible(false);

        panelEntrenadoresCombate = new JPanel();
            panelEntrenadoresCombate.setBounds(500,670,600,190);
            panelEntrenadoresCombate.setLayout(new GridLayout(1,0,15,0));
            panelEntrenadoresCombate.setBackground(cFondo);
            panelEntrenadoresCombate.setBorder(null);
            panelEntrenadoresCombate.setVisible(false);

        botonGuardarMundo = new JButton("GUARDAR");
            botonGuardarMundo.setBounds(1455,15,130,40);
            botonGuardarMundo.setHorizontalAlignment(JButton.CENTER);
            botonGuardarMundo.setIcon(new ImageIcon("./src/GUI/Imagenes/guardar.png"));
            botonGuardarMundo.setRolloverIcon(new ImageIcon("./src/GUI/Imagenes/guardar_claro.png"));
            botonGuardarMundo.setFont(new Font("Courier New", Font.PLAIN, 18));
            botonGuardarMundo.setFocusable(false);
            botonGuardarMundo.setForeground(cLetra);
            botonGuardarMundo.setIconTextGap(10);
            botonGuardarMundo.setBackground(null);
            botonGuardarMundo.setBorder(null);     
            botonGuardarMundo.addActionListener(this);

        // WORLD WINDOW ///////////////////////////////////////////////////////////////////////////
        ImageIcon imageWindow = new ImageIcon("./src/GUI/Imagenes/logo.png");
        this.setIconImage(imageWindow.getImage());
        this.setTitle("POOkemon");
        this.setResizable(false);
        this.setSize(1600,900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(cFondo);
        this.setLayout(null);
        this.add(volver);
        this.setUndecorated(true);
        this.add(tituloMundo);
        this.add(panelPokemons);
        this.add(panelEntrenadores);
        this.add(panelControl);
        this.add(panelEntrenadoresCombate);
        this.add(botonGuardarMundo);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==volver){
            if(panelListaPokemons.getComponentCount()!=0 || panelListaEntrenadores.getComponentCount()!=0){
                int confirm = JOptionPane.showConfirmDialog(null, "¿Deseas guardar este mundo?", "Atención", JOptionPane.YES_NO_CANCEL_OPTION);
                if (confirm == JOptionPane.YES_OPTION){
                    botonGuardarMundo.doClick();
                    this.dispose();
                    new VentanaInicio();
                } else if (confirm == JOptionPane.NO_OPTION){
                    this.dispose();
                    new VentanaInicio();
                }
            } else {
                this.dispose();
                    new VentanaInicio();
            }
        }

        if (e.getSource()==anadirEntrenador){
            new AnadirEntrenador();
        }

        if (e.getSource()==anadirPokemon){
            new AnadirPokemon();
        }

        if(panelListaPokemons.getComponentCount()!=0){
            for(int i=0;i<panelListaPokemons.getComponentCount();i++){
                if (e.getSource()==panelListaPokemons.getComponent(i)){
                    panelControl.removeAll();
                    panelEntrenadoresCombate.setVisible(false);
                    panelControl.setLayout(new BorderLayout());

                    
                    panelDetalles = new JPanel();
                        panelDetalles.setLayout(new GridLayout(0,1,10,0));
                        panelDetalles.setBackground(cBotonesOscuro);

                    JLabel etiquetaClase = new JLabel("["+((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon().getClass().getSimpleName()+"]");
                        etiquetaClase.setHorizontalAlignment(JLabel.CENTER);
                        etiquetaClase.setFont(new Font("Courier New", Font.ITALIC, 13));
                        etiquetaClase.setForeground(cBotonesClaro);
                        etiquetaClase.setPreferredSize(new Dimension(0,30));
                        etiquetaClase.setVerticalAlignment(JLabel.CENTER);

                    JLabel etiquetaNombre = new JLabel("Nombre: ");
                    JLabel etiquetaTipo = new JLabel("Tipo: ");
                    JLabel etiquetaNivel = new JLabel("Nivel: ");
                    JLabel etiquetaSaludo = new JLabel("Saludo: ");
                    JLabel etiquetaEntrenador = new JLabel("Entrenador: ");
                    JLabel etiquetaPoder = new JLabel("Poder: ");
                    JLabel etiquetaPoderEspecial = new JLabel("Poder especial: ");
                    JLabel etiquetaDefensa = new JLabel("Defensa: ");
                    JLabel etiquetaDefensaEspecial = new JLabel("Defensa especial: ");
                    JLabel etiquetaVelocidad = new JLabel("Velocidad: ");
                    JLabel etiquetaSaludMax = new JLabel("Salud máxima: ");
                    JLabel etiquetaMovimientos = new JLabel("Movimientos: ");
                    
                    Pokemon pokemon = ((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon();
                    nombrePokemonSeleccionado = new JTextField();
                        nombrePokemonSeleccionado.setText(pokemon.getNombre());
                        nombrePokemonSeleccionado.setEditable(false);
                        nombrePokemonSeleccionado.setPreferredSize(new Dimension(100,20));
                        nombrePokemonSeleccionado.setBorder(null);
                        nombrePokemonSeleccionado.setBackground(null);
                    tipoPokemonSeleccionado = new JTextField();
                        tipoPokemonSeleccionado.setText(pokemon.getTipo());
                        tipoPokemonSeleccionado.setEditable(false);
                        tipoPokemonSeleccionado.setBorder(null);
                        tipoPokemonSeleccionado.setBackground(null);
                    nivelPokemonSeleccionado = new JTextField();
                        nivelPokemonSeleccionado.setText(String.valueOf(pokemon.getNivel()));
                        nivelPokemonSeleccionado.setEditable(false);
                        nivelPokemonSeleccionado.setBorder(null);
                        nivelPokemonSeleccionado.setBackground(null);
                    saludoPokemonSeleccionado = new JTextField();
                        saludoPokemonSeleccionado.setText(String.valueOf(pokemon.getSaludo()));
                        saludoPokemonSeleccionado.setEditable(false);
                        saludoPokemonSeleccionado.setBorder(null);
                        saludoPokemonSeleccionado.setBackground(null);
                    entrenadorPokemonSeleccionado = new JTextField();
                        entrenadorPokemonSeleccionado.setText(pokemon.condicionExistenciaEntrenador());
                        entrenadorPokemonSeleccionado.setEditable(false);
                        entrenadorPokemonSeleccionado.setBorder(null);
                        entrenadorPokemonSeleccionado.setBackground(null);
                    poderPokemonSeleccionado = new JTextField();
                        poderPokemonSeleccionado.setText(String.valueOf(pokemon.getPoder()));
                        poderPokemonSeleccionado.setEditable(false);
                        poderPokemonSeleccionado.setBorder(null);
                        poderPokemonSeleccionado.setBackground(null);
                    poderEspecialPokemonSeleccionado = new JTextField();
                        poderEspecialPokemonSeleccionado.setText(String.valueOf(pokemon.getPoderEspecial()));
                        poderEspecialPokemonSeleccionado.setEditable(false);
                        poderEspecialPokemonSeleccionado.setBorder(null);
                        poderEspecialPokemonSeleccionado.setBackground(null);
                    defensaPokemonSeleccionado = new JTextField();
                        defensaPokemonSeleccionado.setText(String.valueOf(pokemon.getDefensa()));
                        defensaPokemonSeleccionado.setEditable(false);
                        defensaPokemonSeleccionado.setBorder(null);
                        defensaPokemonSeleccionado.setBackground(null);
                    defensaEspecialPokemonSeleccionado = new JTextField();
                        defensaEspecialPokemonSeleccionado.setText(String.valueOf(pokemon.getDefensaEspecial()));
                        defensaEspecialPokemonSeleccionado.setEditable(false);
                        defensaEspecialPokemonSeleccionado.setBorder(null);
                        defensaEspecialPokemonSeleccionado.setBackground(null);
                    velocidadPokemonSeleccionado = new JTextField();
                        velocidadPokemonSeleccionado.setText(String.valueOf(pokemon.getVelocidad()));
                        velocidadPokemonSeleccionado.setEditable(false);
                        velocidadPokemonSeleccionado.setBorder(null);
                        velocidadPokemonSeleccionado.setBackground(null);
                    saludMaxPokemonSeleccionado = new JTextField();
                        saludMaxPokemonSeleccionado.setText(String.valueOf(pokemon.getSaludMax()));
                        saludMaxPokemonSeleccionado.setEditable(false);
                        saludMaxPokemonSeleccionado.setBorder(null);
                        saludMaxPokemonSeleccionado.setBackground(null);
                    mopvimientosPokemonSeleccionado = new JTextField();
                        String movimientos = "";
                        for (Movimiento movimiento : pokemon.getMovimientos()) {
                            movimientos += movimiento.getNombre() + " | ";
                        }
                        mopvimientosPokemonSeleccionado.setText(movimientos);
                        mopvimientosPokemonSeleccionado.setEditable(false);
                        mopvimientosPokemonSeleccionado.setBorder(null);
                        mopvimientosPokemonSeleccionado.setBackground(null);
                    
                    panelDetalles.add(nombrePokemonSeleccionado);
                    panelDetalles.add(tipoPokemonSeleccionado);
                    panelDetalles.add(nivelPokemonSeleccionado);
                    panelDetalles.add(saludoPokemonSeleccionado);
                    panelDetalles.add(entrenadorPokemonSeleccionado);
                    panelDetalles.add(poderPokemonSeleccionado);
                    panelDetalles.add(poderEspecialPokemonSeleccionado);
                    panelDetalles.add(defensaPokemonSeleccionado);
                    panelDetalles.add(defensaEspecialPokemonSeleccionado);
                    panelDetalles.add(velocidadPokemonSeleccionado);
                    panelDetalles.add(saludMaxPokemonSeleccionado);
                    panelDetalles.add(mopvimientosPokemonSeleccionado);

                    for (int j=0; j<panelDetalles.getComponentCount(); j++){
                        panelDetalles.getComponent(j).setForeground(cLetra);
                        panelDetalles.getComponent(j).setFont(new Font("Courier New", Font.BOLD, 13));
                    }

                    panelEtiquetas = new JPanel();
                        panelEtiquetas.setLayout(new GridLayout(0,1,0,0));
                        panelEtiquetas.setPreferredSize(new Dimension(200,0));
                        panelEtiquetas.setBackground(cBotonesOscuro);
                            panelEtiquetas.add(etiquetaNombre);
                            panelEtiquetas.add(etiquetaTipo);
                            panelEtiquetas.add(etiquetaNivel);
                            panelEtiquetas.add(etiquetaSaludo);
                            panelEtiquetas.add(etiquetaEntrenador);
                            panelEtiquetas.add(etiquetaPoder);
                            panelEtiquetas.add(etiquetaPoderEspecial);
                            panelEtiquetas.add(etiquetaDefensa);
                            panelEtiquetas.add(etiquetaDefensaEspecial);
                            panelEtiquetas.add(etiquetaVelocidad);
                            panelEtiquetas.add(etiquetaSaludMax);
                            panelEtiquetas.add(etiquetaMovimientos);
    
                    for (int j=0; j<panelEtiquetas.getComponentCount(); j++){
                        panelEtiquetas.getComponent(j).setForeground(cLetra);
                        ((JLabel)panelEtiquetas.getComponent(j)).setHorizontalAlignment(JLabel.RIGHT);
                        panelEtiquetas.getComponent(j).setFont(new Font("Courier New", Font.ITALIC, 13));
                    }

                    botonModificar = new JButton("Modificar");
                        botonModificar.setBounds(225, 5, 150, 30);
                        botonModificar.setHorizontalAlignment(JButton.CENTER);
                        botonModificar.setFont(new Font("Courier New", Font.BOLD, 12));
                        botonModificar.setIconTextGap(10);
                        botonModificar.setFocusable(false);
                        botonModificar.setForeground(cBotonesOscuro);
                        botonModificar.setBackground(cBotonesClaro);
                        botonModificar.setBorder(BorderFactory.createRaisedSoftBevelBorder());
                        botonModificar.addActionListener(iVentanaMundo);

                    botonEliminarPokemon = new JButton();
                        botonEliminarPokemon.setBounds(555, 5, 30, 30);
                        botonEliminarPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/papelera.png"));
                        botonEliminarPokemon.setHorizontalAlignment(JButton.CENTER);
                        botonEliminarPokemon.setFont(new Font("Courier New", Font.BOLD, 12));
                        botonEliminarPokemon.setFocusable(false);
                        botonEliminarPokemon.setForeground(cBotonesClaro);
                        botonEliminarPokemon.setBackground(new Color (221,83,83));
                        botonEliminarPokemon.setBorder(BorderFactory.createRaisedSoftBevelBorder());
                        botonEliminarPokemon.addActionListener(iVentanaMundo);

                    botonGuardarDetalles = new JButton("Guardar");
                        botonGuardarDetalles.setBounds(15,5,570,30);
                        botonGuardarDetalles.setFont(new Font("Courier New", Font.BOLD, 12));
                        botonGuardarDetalles.setFocusable(false);
                        botonGuardarDetalles.setForeground(cBotonesOscuro);
                        botonGuardarDetalles.setBackground(cBotonesClaro);
                        botonGuardarDetalles.setVisible(false);
                        botonGuardarDetalles.setBorder(BorderFactory.createEtchedBorder());
                        botonGuardarDetalles.addActionListener(iVentanaMundo);
                        
                    panelBotonesModDel = new JPanel();
                        panelBotonesModDel.setLayout(null);
                        panelBotonesModDel.setBorder(null);
                        panelBotonesModDel.setBackground(cBotonesOscuro);
                        panelBotonesModDel.setPreferredSize(new Dimension(600,50));
                        panelBotonesModDel.add(botonModificar);
                        panelBotonesModDel.add(botonEliminarPokemon);
                        panelBotonesModDel.add(botonGuardarDetalles);

                    panelControl.add(etiquetaClase, BorderLayout.NORTH);
                    panelControl.add(panelEtiquetas, BorderLayout.WEST);
                    panelControl.add(panelDetalles, BorderLayout.CENTER);
                    panelControl.add(panelBotonesModDel, BorderLayout.SOUTH);
                    panelControl.setVisible(true);
                    actualizarVentana();
                }
            }

            if(e.getSource()==botonEliminarPokemon){
                Enumeration<AbstractButton> botones = grupoBotonesSeleccionar.getElements();
                while (botones.hasMoreElements()) {
                    AbstractButton button = (AbstractButton)botones.nextElement();
                    if (button.isSelected()){
                        int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar este pokemon?", "Atención", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION){
                            panelListaPokemons.remove(button);
                            grupoBotonesSeleccionar.remove(button);
                            panelControl.setVisible(false);
                            
                            for (int j=0; j<panelListaEntrenadores.getComponentCount(); j++){

                                for(int k=0; k<((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(j)).getEntrenador().getPokemons().size(); k++){
                                    ArrayList<Pokemon> pokemons = ((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(j)).getEntrenador().getPokemons();
                                    
                                    if (pokemons.get(k).getNombre().equals(((ToggleBotonPokemonEntrenador)button).getPokemon().getNombre())){
                                        pokemons.remove(k);
                                    }
                                }
                            }
                            actualizarVentana();
                        }
                    }
                }
            }

            if(e.getSource()==botonModificar){
                for (int j=0; j<panelDetalles.getComponentCount(); j++){
                    if(j!=1 && j!=4 && j!=11){
                        ((JTextField)panelDetalles.getComponent(j)).setEditable(true);
                        ((JTextField)panelDetalles.getComponent(j)).setBackground(cBotonesClaro);
                        ((JTextField)panelDetalles.getComponent(j)).setForeground(cBotonesOscuro);  
                    }
                }

                botonEliminarPokemon.setVisible(false);
                botonModificar.setVisible(false);
                botonGuardarDetalles.setVisible(true);
            }

            if(e.getSource()==botonGuardarDetalles){
                for (int j=0; j<panelDetalles.getComponentCount(); j++){
                    if(j!=1 && j!=4 && j!=11){
                        ((JTextField)panelDetalles.getComponent(j)).setEditable(false);
                        ((JTextField)panelDetalles.getComponent(j)).setBackground(cBotonesOscuro);
                        ((JTextField)panelDetalles.getComponent(j)).setForeground(cBotonesClaro);  
                    }
                }

                botonEliminarPokemon.setVisible(true);
                botonModificar.setVisible(true);
                botonGuardarDetalles.setVisible(false);

                Enumeration<AbstractButton> botones = grupoBotonesSeleccionar.getElements();
                while (botones.hasMoreElements()) {
                    AbstractButton button = (AbstractButton)botones.nextElement();
                    if (button.isSelected()){
                        for(int i=0; i<panelListaPokemons.getComponentCount(); i++){
                           ToggleBotonPokemonEntrenador botonPokemon =((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i));
                            if(botonPokemon==button){
                                botonPokemon.getPokemon().setNombre(nombrePokemonSeleccionado.getText());
                                button.setText(nombrePokemonSeleccionado.getText());
                                botonPokemon.getPokemon().setNivel(Integer.parseInt(nivelPokemonSeleccionado.getText()));
                                botonPokemon.getPokemon().setSaludo(saludoPokemonSeleccionado.getText());
                                botonPokemon.getPokemon().setPoder(Integer.parseInt(poderPokemonSeleccionado.getText()));
                                botonPokemon.getPokemon().setPoderEspecial(Integer.parseInt(poderEspecialPokemonSeleccionado.getText()));
                                botonPokemon.getPokemon().setDefensa(Integer.parseInt(defensaEspecialPokemonSeleccionado.getText()));
                                botonPokemon.getPokemon().setDefensaEspecial((Integer.parseInt(defensaEspecialPokemonSeleccionado.getText())));
                                botonPokemon.getPokemon().setVelocidad(Integer.parseInt(velocidadPokemonSeleccionado.getText()));
                                botonPokemon.getPokemon().setSaludMax(Integer.parseInt(saludMaxPokemonSeleccionado.getText())); 
                                actualizarVentana();
                            }
                        }
                    }
                }
            }
        }

        if(panelListaEntrenadores.getComponentCount()!=0){
            for(int i=0;i<panelListaEntrenadores.getComponentCount();i++){
                if (e.getSource()==panelListaEntrenadores.getComponent(i)){
                    panelControl.removeAll();
                    panelEntrenadoresCombate.setVisible(false);

                    asignarPokemon = new JButton("Asignar Pokemon");
                        asignarPokemon.setBounds(210,200,180,40);
                        asignarPokemon.setBackground(cBotonesOscuro);
                        asignarPokemon.setForeground(cBotonesClaro);
                        asignarPokemon.setFont(new Font("Courier New", Font.PLAIN, 15));
                        asignarPokemon.setHorizontalTextPosition(JButton.CENTER);
                        asignarPokemon.setVerticalTextPosition(JButton.BOTTOM);
                        asignarPokemon.setFocusable(false);
                        asignarPokemon.setBorder(BorderFactory.createRaisedSoftBevelBorder());
                        asignarPokemon.addActionListener(iVentanaMundo);
                    
                    if(((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(i)).getEntrenador().getPokemons().size()==0){
                        crearSlotPokemonDisponible(15,15,180,120);
                        crearSlotPokemonDisponible(210,15,180,120);
                        crearSlotPokemonDisponible(405,15,180,120);
                        
                        asignarPokemon.setVisible(true);
                    }
                    if (((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(i)).getEntrenador().getPokemons().size()==1){
                        boton1Eliminar = new JButton(((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(i)).getEntrenador().getPokemons().get(0).getNombre());
                            boton1Eliminar.setBounds(15,15,180,120);
                            mostrarIcono (boton1Eliminar,i,0);
                            boton1Eliminar.addActionListener(iVentanaMundo);
                            panelControl.add(boton1Eliminar);
                        
                        crearSlotPokemonDisponible(210,15,180,120);
                        crearSlotPokemonDisponible(405,15,180,120);
                        
                        asignarPokemon.setVisible(true);
                    }
                    if (((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(i)).getEntrenador().getPokemons().size()==2){
                        boton1Eliminar = new JButton(((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(i)).getEntrenador().getPokemons().get(0).getNombre());
                            boton1Eliminar.setBounds(15,15,180,120);
                            mostrarIcono (boton1Eliminar,i,0);
                            boton1Eliminar.addActionListener(iVentanaMundo);
                            panelControl.add(boton1Eliminar);
                        
                        boton2Eliminar = new JButton(((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(i)).getEntrenador().getPokemons().get(1).getNombre());
                            boton2Eliminar.setBounds(210,15,180,120);
                            mostrarIcono (boton2Eliminar,i,1);
                            boton2Eliminar.addActionListener(iVentanaMundo);
                            panelControl.add(boton2Eliminar);
                        
                            crearSlotPokemonDisponible(405,15,180,120);
                        asignarPokemon.setVisible(true);
                    }
                    if (((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(i)).getEntrenador().getPokemons().size()==3){
                        boton1Eliminar = new JButton(((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(i)).getEntrenador().getPokemons().get(0).getNombre());
                            boton1Eliminar.setBounds(15,15,180,120);
                            mostrarIcono (boton1Eliminar,i,0);
                            boton1Eliminar.addActionListener(iVentanaMundo);
                            panelControl.add(boton1Eliminar);
                        
                        boton2Eliminar = new JButton(((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(i)).getEntrenador().getPokemons().get(1).getNombre());
                            boton2Eliminar.setBounds(210,15,180,120);
                            mostrarIcono (boton2Eliminar,i,1);
                            boton2Eliminar.addActionListener(iVentanaMundo);
                            panelControl.add(boton2Eliminar);
                        
                        boton3Eliminar = new JButton(((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(i)).getEntrenador().getPokemons().get(2).getNombre());
                            boton3Eliminar.setBounds(405,15,180,120);
                            mostrarIcono (boton3Eliminar,i,2);
                            boton3Eliminar.addActionListener(iVentanaMundo);
                            panelControl.add(boton3Eliminar);
                       
                        asignarPokemon.setVisible(false);
                    }


                    panelScrollPokemonsDisponibles = new JScrollPane(panelPokemonsDisponibles,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                        panelScrollPokemonsDisponibles.setVisible(false);

                    botonCombatir = new JButton("COMBATIR");
                        botonCombatir.setBounds(15,300,525,65);
                        botonCombatir.setHorizontalAlignment(JButton.CENTER);
                        botonCombatir.setFont(new Font("Courier New", Font.BOLD, 20));
                        botonCombatir.setFocusable(false);
                        botonCombatir.setForeground(cBotonesOscuro);
                        botonCombatir.setBackground(cBotonesClaro);
                        botonCombatir.setBorder(BorderFactory.createEtchedBorder());
                        botonCombatir.addActionListener(iVentanaMundo);

                    botonEliminarEntrenador = new JButton();
                        botonEliminarEntrenador.setBounds(555, 335, 30, 30);
                        botonEliminarEntrenador.setIcon(new ImageIcon("./src/GUI/Imagenes/papelera.png"));
                        botonEliminarEntrenador.setHorizontalAlignment(JButton.CENTER);
                        botonEliminarEntrenador.setFocusable(false);
                        botonEliminarEntrenador.setBackground(new Color (221,83,83));
                        botonEliminarEntrenador.setBorder(BorderFactory.createRaisedSoftBevelBorder());
                        botonEliminarEntrenador.addActionListener(iVentanaMundo);
                    
                    panelControl.setLayout(null);
                    panelControl.add(asignarPokemon);
                    panelControl.add(botonCombatir);
                    panelControl.add(botonEliminarEntrenador);
                    panelControl.setVisible(true);
                    actualizarVentana();
                }
            }

            if(e.getSource()==botonEliminarEntrenador){
                Enumeration<AbstractButton> botones = grupoBotonesSeleccionar.getElements();
                while (botones.hasMoreElements()) {
                    AbstractButton button = (AbstractButton)botones.nextElement();
                    if (button.isSelected()){
                        int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar este entrenador?", "Atención", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION){
                            panelListaEntrenadores.remove(button);
                            grupoBotonesSeleccionar.remove(button);
                            panelControl.setVisible(false);
                            for (int i=0;i<((ToggleBotonPokemonEntrenador)button).getEntrenador().getPokemons().size();i++){
                                ((ToggleBotonPokemonEntrenador)button).getEntrenador().getPokemons().get(i).setEntrenador(new Entrenador("-", 0));
                            }
                            actualizarVentana();
                        }
                    }
                }
            }

            if(e.getSource()==asignarPokemon){
                panelPokemonsDisponibles.removeAll();
                panelPokemonsDisponibles.setLayout(new GridLayout(1,0,15,0));
                panelPokemonsDisponibles.setBackground(cBotonesOscuro);
                
                for (int i=0; i<panelListaPokemons.getComponentCount(); i++){
                    if(((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon().condicionExistenciaEntrenador()=="-"){
                        BotonPokemon botonPokemonDisponible = new BotonPokemon();
                            botonPokemonDisponible.setPokemon(((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon());
                            botonPokemonDisponible.setText(((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon().getNombre());
                            botonPokemonDisponible.setPreferredSize(new Dimension(180,0));
                            botonPokemonDisponible.setVerticalAlignment(JButton.CENTER);
                            botonPokemonDisponible.setIcon(((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getIcon());
                            botonPokemonDisponible.setVerticalTextPosition(JButton.BOTTOM);
                            botonPokemonDisponible.setHorizontalTextPosition(JButton.CENTER);
                            botonPokemonDisponible.setBackground(cBotonesClaro);
                            botonPokemonDisponible.setForeground(cBotonesOscuro);
                            botonPokemonDisponible.setFocusable(false);
                            botonPokemonDisponible.setFont(new Font("Courier New", Font.BOLD, 15));
                            botonPokemonDisponible.setIconTextGap(10);
                            botonPokemonDisponible.addActionListener(iVentanaMundo);
                            botonesPokemonsDisponibles.add(botonPokemonDisponible);
                        panelPokemonsDisponibles.add(botonPokemonDisponible);
                    }
                }
                
                if(!(panelPokemonsDisponibles.getComponentCount()==0)){
                    asignarPokemon.setVisible(false);
                    panelScrollPokemonsDisponibles.setBounds(15, 150, 570, 135);
                    panelScrollPokemonsDisponibles.setBorder(BorderFactory.createEtchedBorder());
                    panelScrollPokemonsDisponibles.setBackground(cBotonesOscuro);
                    panelScrollPokemonsDisponibles.getHorizontalScrollBar().setBackground(cBotonesOscuro);
                    panelScrollPokemonsDisponibles.setVisible(true);
                    panelControl.add(panelScrollPokemonsDisponibles);
                } else{
                    JOptionPane.showMessageDialog(null, "No hay pokemons disponibles", "Error", JOptionPane.ERROR_MESSAGE);
                    Enumeration<AbstractButton> botones = grupoBotonesSeleccionar.getElements();
                    while (botones.hasMoreElements()) {
                        AbstractButton botonEntrenadorSeleccionado = (AbstractButton)botones.nextElement();
                        if (botonEntrenadorSeleccionado.isSelected()){
                            botonEntrenadorSeleccionado.doClick();
                        }
                    }
                }
            }

            if(panelPokemonsDisponibles.getComponentCount()!=0){
                for(int i=0;i<panelPokemonsDisponibles.getComponentCount();i++){
                    if (e.getSource()==panelPokemonsDisponibles.getComponent(i)){
                        Enumeration<AbstractButton> botones = grupoBotonesSeleccionar.getElements();
                        while (botones.hasMoreElements()) {
                            AbstractButton botonEntrenadorSeleccionado = (AbstractButton)botones.nextElement();
                            if (botonEntrenadorSeleccionado.isSelected()){
                                ((ToggleBotonPokemonEntrenador)botonEntrenadorSeleccionado).getEntrenador().anadirPokemon(botonesPokemonsDisponibles.get(i).getPokemon());
                                botonesPokemonsDisponibles.clear();
                                botonEntrenadorSeleccionado.doClick();
                            }
                        }
                    }
                }
            }

            if(e.getSource()==boton1Eliminar){
                Enumeration<AbstractButton> botones = grupoBotonesSeleccionar.getElements();
                while (botones.hasMoreElements()) {
                    AbstractButton botonEntrenadorSeleccionado = (AbstractButton)botones.nextElement();
                    if (botonEntrenadorSeleccionado.isSelected()){
                        int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas devolver este Pokemon?", "Atención", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION){
                            ((ToggleBotonPokemonEntrenador)botonEntrenadorSeleccionado).getEntrenador().getPokemons().get(0).setEntrenador(new Entrenador("-", 0));
                            ((ToggleBotonPokemonEntrenador)botonEntrenadorSeleccionado).getEntrenador().getPokemons().remove(0);
                            botonEntrenadorSeleccionado.doClick();
                        }
                    }
                }
            }

            if(e.getSource()==boton2Eliminar){
                Enumeration<AbstractButton> botones = grupoBotonesSeleccionar.getElements();
                while (botones.hasMoreElements()) {
                    AbstractButton botonEntrenadorSeleccionado = (AbstractButton)botones.nextElement();
                    if (botonEntrenadorSeleccionado.isSelected()){
                        int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas devolver este Pokemon?", "Atención", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION){
                            ((ToggleBotonPokemonEntrenador)botonEntrenadorSeleccionado).getEntrenador().getPokemons().get(1).setEntrenador(new Entrenador("-", 0));
                            ((ToggleBotonPokemonEntrenador)botonEntrenadorSeleccionado).getEntrenador().getPokemons().remove(1);
                            botonEntrenadorSeleccionado.doClick();
                        }
                    }
                }
            }

            if(e.getSource()==boton3Eliminar){
                Enumeration<AbstractButton> botones = grupoBotonesSeleccionar.getElements();
                while (botones.hasMoreElements()) {
                    AbstractButton botonEntrenadorSeleccionado = (AbstractButton)botones.nextElement();
                    if (botonEntrenadorSeleccionado.isSelected()){
                        int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas devolver este Pokemon?", "Atención", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION){
                            ((ToggleBotonPokemonEntrenador)botonEntrenadorSeleccionado).getEntrenador().getPokemons().get(2).setEntrenador(new Entrenador("-", 0));
                            ((ToggleBotonPokemonEntrenador)botonEntrenadorSeleccionado).getEntrenador().getPokemons().remove(2);
                            botonEntrenadorSeleccionado.doClick();
                        }
                    }
                }
            }

            if(e.getSource()==botonCombatir){
                if(panelEntrenadoresCombate.isVisible()){
                    panelEntrenadoresCombate.setVisible(false);
                }else{
                    panelEntrenadoresCombate.removeAll();
                    Enumeration<AbstractButton> botones = grupoBotonesSeleccionar.getElements();
                    while (botones.hasMoreElements()) {
                        AbstractButton botonEntrenadorSeleccionado = (AbstractButton)botones.nextElement();
                        if (botonEntrenadorSeleccionado.isSelected()){
                            for (int j=0; j<panelListaEntrenadores.getComponentCount(); j++){
                                ToggleBotonPokemonEntrenador botonEntrenador = ((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(j));
                                if(botonEntrenador!=botonEntrenadorSeleccionado){
                                    JButton boton = new JButton(botonEntrenador.getEntrenador().getNombre());
                                        boton.setBackground(cBotonesOscuro);
                                        boton.setForeground(cLetra);
                                        boton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
                                        boton.setFocusable(false);
                                        boton.setFont(new Font("Courier New", Font.BOLD, 15));
                                        if (botonEntrenador.getEntrenador().getNombre().equals("LORETO")){
                                            boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Loreto_120.png"));
                                        } else if (botonEntrenador.getEntrenador().getNombre().equals("SILVIA")){
                                            boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Silvia_120.png"));
                                        } else if (botonEntrenador.getEntrenador().getNombre().equals("OLEKSANDR")){
                                            boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Oleksandr_120.png"));
                                        } else if (botonEntrenador.getEntrenador().getNombre().equals("ALEJANDRO")){
                                            boton.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Alejandro_120.png"));
                                        }

                                        boton.setIconTextGap(10);
                                        boton.setHorizontalTextPosition(JButton.CENTER);
                                        boton.setVerticalTextPosition(JButton.BOTTOM);
                                        boton.addActionListener(iVentanaMundo);

                                    panelEntrenadoresCombate.add(boton);
                                    panelEntrenadoresCombate.setVisible(true);
                                    actualizarVentana();
                                }
                            }
                        }
                    }
                }
            }

            if(panelEntrenadoresCombate.getComponentCount()!=0){
                for(int i=0;i<panelEntrenadoresCombate.getComponentCount();i++){
                    if (e.getSource()==panelEntrenadoresCombate.getComponent(i)){
                        Enumeration<AbstractButton> botones = grupoBotonesSeleccionar.getElements();
                        while (botones.hasMoreElements()) {
                            AbstractButton botonEntrenadorSeleccionado = (AbstractButton)botones.nextElement();
                            if (botonEntrenadorSeleccionado.isSelected()){
                                Entrenador entrenadorDesafiante = ((ToggleBotonPokemonEntrenador)botonEntrenadorSeleccionado).getEntrenador();
                                Entrenador entrenadorDesafiado = new Entrenador("", 0);

                                String nombredesafiado = ((JButton)panelEntrenadoresCombate.getComponent(i)).getText();
                                for (int j=0;j<panelListaEntrenadores.getComponentCount();j++){
                                    String nombreDesafiante = ((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(j)).getEntrenador().getNombre();
                                    
                                    if (nombredesafiado.equals(nombreDesafiante)){
                                        entrenadorDesafiado = ((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(j)).getEntrenador();
                                    }
                                }

                                if((entrenadorDesafiante.getPokemons().size()>0) && (entrenadorDesafiado.getPokemons().size()>0)){
                                    panelEntrenadoresCombate.setVisible(false);
                                    entrenadorDesafiante.combatir(entrenadorDesafiado);
                                    comprobarEvolucion();
                                } else{
                                    panelEntrenadoresCombate.setVisible(false);
                                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Ambos entrenadores tienen que tener al menos un pokemon asignado para poder combatir", "Error", JOptionPane.ERROR_MESSAGE);
                                }     
                            }
                        }
                    }
                }
            }
        }
        
        if(e.getSource()==botonGuardarMundo){
            if(panelListaPokemons.getComponentCount()>0  || panelListaEntrenadores.getComponentCount()>0){
                try {
                    BufferedWriter mundo = new BufferedWriter(new FileWriter(ruta));
                    if(panelListaPokemons.getComponentCount()>0){
                        for (int i=0; i<panelListaPokemons.getComponentCount(); i++){
                            Pokemon pokemon = ((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon();
                            mundo.write(pokemon.toString());
                            mundo.newLine();
                        }
                    }
                
                    if(panelListaEntrenadores.getComponentCount()>0){
                        mundo.write("---");
                        mundo.newLine();

                        for (int i=0; i<panelListaEntrenadores.getComponentCount(); i++){
                            Entrenador entrenador = ((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(i)).getEntrenador();
                            mundo.write(entrenador.toString());
                            mundo.newLine();
                        }
                    }
                    mundo.close();
                } catch (IOException n) {
                    n.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "El mundo " + '"' + ruta.getName() + '"' + " ha sido guardado", "Atención", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public void actualizarVentana(){
        this.invalidate();
        this.validate();
        this.repaint();
    }

    public void crearSlotPokemonDisponible (int x, int y, int ancho, int alto){
        JLabel etiquetaAsignarPokemon = new JLabel();
        etiquetaAsignarPokemon.setBounds(x,y,ancho,alto);
        etiquetaAsignarPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/pokebola.png"));

        etiquetaAsignarPokemon.setHorizontalAlignment(JLabel.CENTER);
        etiquetaAsignarPokemon.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        etiquetaAsignarPokemon.setBackground(cBotonesOscuro);
        panelControl.add(etiquetaAsignarPokemon);
    }
    
    public void mostrarIcono (JButton botonEliminar, int n, int posPok){
        if(((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(n)).getEntrenador().getPokemons().get(posPok).getClass().getSimpleName().equals("Bulbasur")){
            botonEliminar.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Bulbasaur_60.png"));
        } else if (((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(n)).getEntrenador().getPokemons().get(posPok).getClass().getSimpleName().equals("Charmander")){
            botonEliminar.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Charmander_60.png"));
        } else if (((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(n)).getEntrenador().getPokemons().get(posPok).getClass().getSimpleName().equals("Rattata")){
            botonEliminar.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Rattata_60.png"));
        } else if (((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(n)).getEntrenador().getPokemons().get(posPok).getClass().getSimpleName().equals("Squirtle")){
            botonEliminar.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Squirtle_60.png"));
        } else if (((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(n)).getEntrenador().getPokemons().get(posPok).getClass().getSimpleName().equals("Charmeleon")){
            botonEliminar.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Charmeleon_60.png"));
        } else if (((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(n)).getEntrenador().getPokemons().get(posPok).getClass().getSimpleName().equals("Blastoise")){
            botonEliminar.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Blastoise_60.png"));
        }

        botonEliminar.setBackground(cBotonesOscuro);
        botonEliminar.setForeground(cBotonesClaro);
        botonEliminar.setFont(new Font("Courier New", Font.BOLD, 15));
        botonEliminar.setHorizontalTextPosition(JButton.CENTER);
        botonEliminar.setVerticalTextPosition(JButton.BOTTOM);
        botonEliminar.setFocusable(false);
        botonEliminar.setIconTextGap(10);
        botonEliminar.setBorder(BorderFactory.createRaisedSoftBevelBorder());
    }

    public boolean existeNombrePokemon (String nombreBuscado){
        boolean existe=false;
        for (int i=0; i<panelListaPokemons.getComponentCount(); i++){
            String nombrePokemon = ((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon().getNombre();
            if (nombrePokemon.equals(nombreBuscado)){
                existe=true;
            }
        }
        return existe;
    }

    public boolean existeNombreEntrenador (String nombreBuscado) {
        boolean existe = false;
        
        for (int i=0; i<panelListaEntrenadores.getComponentCount(); i++){
            String nombreEntrenador = ((ToggleBotonPokemonEntrenador)panelListaEntrenadores.getComponent(i)).getEntrenador().getNombre();
            if (nombreEntrenador.equals(nombreBuscado)){
                existe=true;
            }
        }
        return existe;
    }

    public void cargarDatos (String archivo) throws FileNotFoundException{
        File file = new File(archivo);
        ruta = file;
        BufferedReader lector = new BufferedReader(new FileReader(file));
        try {
            //Pokemon
            String linea;
            
            while (((linea = lector.readLine()) != null) && !(linea.equals("---"))) {
                String[] campos = linea.split("\t");
                String clase = campos[0];
                int nivel = Integer.parseInt(campos[2]);
                Pokemon pokemon;
                ToggleBotonPokemonEntrenador botonPokemon = new ToggleBotonPokemonEntrenador();

                //---------------------Carga Pokemon-----------------------
                switch(clase){
                    case "Bulbasur":
                        pokemon = new Bulbasur(nivel, campos[1]);
                        botonPokemon.setPokemon(pokemon);
                    break;

                    case "Rattata":
                        pokemon = new Rattata(nivel, campos[1]);
                        botonPokemon.setPokemon(pokemon);
                    break;
                    
                    case "Charmander":
                        pokemon = new Charmander(nivel, campos[1]);
                        botonPokemon.setPokemon(pokemon);
                    break;
                    
                    case "Charmeleon":
                        pokemon = new Charmeleon(nivel, campos[1]); 
                        botonPokemon.setPokemon(pokemon);
                    break;
                    
                    case "Squirtle":
                        pokemon = new Squirtle(nivel, campos[1]);
                        botonPokemon.setPokemon(pokemon);
                    break;

                    case "Blastoise":
                        pokemon = new Blastoise(nivel, campos[1]);
                        botonPokemon.setPokemon(pokemon);
                    break;
                    default:
                        pokemon = new Pokemon();
                    break;
                }

                botonPokemon.getPokemon().setPoder(Integer.parseInt(campos[6]));
                botonPokemon.getPokemon().setPoderEspecial(Integer.parseInt(campos[7]));
                botonPokemon.getPokemon().setDefensa(Integer.parseInt(campos[8]));
                botonPokemon.getPokemon().setDefensaEspecial(Integer.parseInt(campos[9]));
                botonPokemon.getPokemon().setSaludActual(Integer.parseInt(campos[10]));
                botonPokemon.getPokemon().setSaludMax(Integer.parseInt(campos[11]));
                
                crearCasillaCargaPokemon(botonPokemon);

                panelListaPokemons.add(botonPokemon);
                grupoBotonesSeleccionar.add(botonPokemon);

            }
            
            // cargaEntrenadores (lector);
            if (linea!=null){

                while (((linea = lector.readLine() ) != null)) {
                    String[] campos = linea.split("\t");
                    String nombreEntrenador = campos[0];
                    int identificador = Integer.parseInt(campos[1]);
                    ToggleBotonPokemonEntrenador botonEntrenador = new ToggleBotonPokemonEntrenador();
                    Entrenador entrenador;
    
                    switch(nombreEntrenador){
                        case "LORETO":
                            entrenador = new Entrenador(nombreEntrenador, identificador);
                            botonEntrenador.setEntrenador(entrenador);
                            break;
    
                        case "SILVIA":
                            entrenador = new Entrenador(nombreEntrenador, identificador);
                            botonEntrenador.setEntrenador(entrenador);
                            break;
    
                        case "OLEKSANDR":
                            entrenador = new Entrenador(nombreEntrenador, identificador);
                            botonEntrenador.setEntrenador(entrenador);
                            break;
    
                        case "ALEJANDRO":
                            entrenador = new Entrenador(nombreEntrenador, identificador);
                            botonEntrenador.setEntrenador(entrenador);
                            break;
    
                        default:
                            break;
                        }
                    
                    switch (campos.length){
                        case 3:
                            for (int i=0; i<panelListaPokemons.getComponentCount(); i++){
                                Pokemon pokemon = ((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon();
                                if(campos[2].equals(pokemon.getNombre())){
                                    botonEntrenador.getEntrenador().anadirPokemon(pokemon);
                                }
                            }
                        break;
                        case 4:
                            for (int i=0; i<panelListaPokemons.getComponentCount(); i++){
                                Pokemon pokemon = ((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon();
                                if(campos[2].equals(pokemon.getNombre())){
                                    botonEntrenador.getEntrenador().anadirPokemon(pokemon);
                                }
                                if(campos[3].equals(pokemon.getNombre())){
                                    botonEntrenador.getEntrenador().anadirPokemon(pokemon);
                                }
                            }
                        break;
                        case 5:
                            for (int i=0; i<panelListaPokemons.getComponentCount(); i++){
                                Pokemon pokemon = ((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon();
                                if(campos[2].equals(pokemon.getNombre())){
                                    botonEntrenador.getEntrenador().anadirPokemon(pokemon);
                                }
                                if(campos[3].equals(pokemon.getNombre())){
                                    botonEntrenador.getEntrenador().anadirPokemon(pokemon);
                                }
                                if(campos[4].equals(pokemon.getNombre())){
                                    botonEntrenador.getEntrenador().anadirPokemon(pokemon);
                                }
                            }
                        break;
                    }
                    crearCasillaCargaEntrenador(botonEntrenador);

                    panelListaEntrenadores.add(botonEntrenador);
                    grupoBotonesSeleccionar.add(botonEntrenador);
                }
                lector.close();
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
    }

    private void crearCasillaCargaPokemon(ToggleBotonPokemonEntrenador botonPokemon){
        botonPokemon.setText(botonPokemon.getPokemon().getNombre());
        botonPokemon.setPreferredSize(new Dimension(0,90));
        botonPokemon.setBackground(cLetra);
        botonPokemon.setForeground(cBotonesOscuro);
        botonPokemon.setFocusable(false);
        botonPokemon.setFont(new Font("Courier New", Font.BOLD, 16));
        botonPokemon.setHorizontalAlignment(JButton.CENTER);
        botonPokemon.setHorizontalTextPosition(JButton.RIGHT);
        botonPokemon.setIconTextGap(20);
        botonPokemon.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        botonPokemon.addActionListener(VentanaMundo.iVentanaMundo);
        
        if (botonPokemon.getPokemon().getClass().getSimpleName().equals("Bulbasur")){
            botonPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Bulbasaur_60.png"));
        } else if (botonPokemon.getPokemon().getClass().getSimpleName().equals("Charmander")){
            botonPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Charmander_60.png"));
        } else if (botonPokemon.getPokemon().getClass().getSimpleName().equals("Rattata")){
            botonPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Rattata_60.png"));
        } else if (botonPokemon.getPokemon().getClass().getSimpleName().equals("Squirtle")){
            botonPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Squirtle_60.png"));
        } else if (botonPokemon.getPokemon().getClass().getSimpleName().equals("Charmeleon")){
            botonPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Charmeleon_60.png")); 
        } else if (botonPokemon.getPokemon().getClass().getSimpleName().equals("Blastoise")){
            botonPokemon.setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Blastoise_60.png"));
        }
    }

    private void crearCasillaCargaEntrenador(ToggleBotonPokemonEntrenador botonEntrenador) {
        String nombre = botonEntrenador.getEntrenador().getNombre();
        botonEntrenador.setText(nombre);
        botonEntrenador.setPreferredSize(new Dimension(0,70));
        botonEntrenador.setBackground(cLetra);
        botonEntrenador.setFocusable(false);
        botonEntrenador.setFont(new Font("Courier New", Font.BOLD, 16));
        botonEntrenador.setHorizontalAlignment(JButton.CENTER);
        botonEntrenador.setHorizontalTextPosition(JButton.LEFT);
        botonEntrenador.setIconTextGap(20);
        botonEntrenador.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        botonEntrenador.addActionListener(VentanaMundo.iVentanaMundo);
        if (nombre.equals("LORETO")){
            botonEntrenador.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Loreto_60.png"));
        } else if (nombre.equals("SILVIA")){
            botonEntrenador.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Silvia_60.png"));
        } else if (nombre.equals("OLEKSANDR")){
            botonEntrenador.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Oleksandr_60.png"));
        } else if (nombre.equals("ALEJANDRO")){
            botonEntrenador.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Alejandro_60.png"));
        }
    }

    public void comprobarEvolucion (){
        for (int i=0;i<panelListaPokemons.getComponentCount();i++){
            Pokemon pokemonEvolucion = ((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon();
            
            if(pokemonEvolucion.getClass().getSimpleName().equals("Charmander") || pokemonEvolucion.getClass().getSimpleName().equals("Squirtle")){
                ((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).setPokemon(pokemonEvolucion.evolucionar());
                pokemonEvolucion = ((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon();

                if(((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon().getClass().getSimpleName().equals("Bulbasur")){
                    ((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Bulbasaur_60.png"));
                } else if (((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon().getClass().getSimpleName().equals("Charmander")){
                    ((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Charmander_60.png"));
                } else if (((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon().getClass().getSimpleName().equals("Rattata")){
                    ((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Rattata_60.png"));
                } else if (((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon().getClass().getSimpleName().equals("Squirtle")){
                    ((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Squirtle_60.png"));
                } else if (((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon().getClass().getSimpleName().equals("Charmeleon")){
                    ((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Charmeleon_60.png"));
                } else if (((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).getPokemon().getClass().getSimpleName().equals("Blastoise")){
                    ((ToggleBotonPokemonEntrenador)panelListaPokemons.getComponent(i)).setIcon(new ImageIcon("./src/GUI/Imagenes/Pokemons/Blastoise_60.png"));
                }
            }
        }
    }

    // Getters & Setters

    public JPanel getPanelListaEntrenadores() {
        return panelListaEntrenadores;
    }

    public JPanel getPanelListaPokemons() {
        return panelListaPokemons;
    }

    public ButtonGroup getGrupoBotonesSeleccionar() {
        return grupoBotonesSeleccionar;
    }

}