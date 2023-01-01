package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaMundo implements ActionListener{
    private JFrame VentanaMundo = new JFrame();
    private JButton volver;
    private JLabel tituloMundo;
    private JPanel panelPokemons;
    private JPanel panelEntrenadores;
    private JPanel panelListaEntrenadores;
    private ArrayList<JButton> botonesP = new ArrayList<>();
    private JButton anadirEntrenador;
    private ArrayList<JButton> botonesE = new ArrayList<>();
    private VentanaMundo ventanaMundo;

    public VentanaMundo(){
        ventanaMundo = this;

        // VOLVER ///////////////////////////////////////////////////////////////////////////////////
        volver = new JButton("VOLVER");
        volver.setBounds(15,790,130,60);
        volver.setHorizontalAlignment(JButton.CENTER);
        volver.setIcon(new ImageIcon("./src/GUI/Imagenes/volver.png"));
        volver.setFont(new Font("Courier New", Font.PLAIN, 18));
        volver.setFocusable(false);
        volver.setForeground(new Color (240, 245, 249));
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
        tituloMundo.setForeground(new Color (240, 245, 249));
        tituloMundo.setIconTextGap(10);


        // PANEL POKEMONS ///////////////////////////////////////////////////////////////////////////
        panelPokemons = new JPanel();
        panelPokemons.setBounds(300,170,300,500);
        panelPokemons.setBackground(new Color (82, 97, 107));
        panelPokemons.setBorder(BorderFactory.createEtchedBorder());
        panelPokemons.setLayout(new BorderLayout());
            
            // TITULO (PANEL POKEMONS) //////////////////////////////////////////////////////////////
            JLabel tituloPokemons = new JLabel("POKEMONS");
            tituloPokemons.setHorizontalAlignment(JLabel.CENTER);
            tituloPokemons.setPreferredSize(new Dimension(0,80));
            tituloPokemons.setFont(new Font("Courier New", Font.BOLD, 24));
            tituloPokemons.setForeground(new Color (201, 214, 223));
            
            // LISTA POKEMONS (PANEL POKEMONS) /////////////////////////////////////////////////////
            JPanel panelListaPokemons = new JPanel();
            panelListaPokemons.setLayout(new GridLayout(0,1,0,5));
            // JButton boton1 = new JButton("Pookemon 1");
            // botonesP.add(boton1);
            // JButton boton2 = new JButton("Pookemon 2");
            // botonesP.add(boton2);
            // JButton boton3 = new JButton("Pookemon 3");
            // botonesP.add(boton3);
            // JButton boton4 = new JButton("Pookemon 4");
            // botonesP.add(boton4);
            // JButton boton5 = new JButton("Pookemon 5");
            // botonesP.add(boton5);
            // JButton boton6 = new JButton("Pookemon 6");
            // botonesP.add(boton6);
            // JButton boton7 = new JButton("Pookemon 7");
            // botonesP.add(boton7);
            // JButton boton8 = new JButton("Pookemon 8");
            // botonesP.add(boton8);

            for (int i=0; i<botonesP.size();i++){
                panelListaPokemons.add(botonesP.get(i));
                botonesP.get(i).setPreferredSize(new Dimension(0,70));
                botonesP.get(i).setBackground(new Color (238,238,238));
                botonesP.get(i).setFocusable(false);
                botonesP.get(i).setFont(new Font("Courier New", Font.BOLD, 16));
                botonesP.get(i).setIcon(new ImageIcon("./src/GUI/Imagenes/pikachu.png"));
                botonesP.get(i).setHorizontalAlignment(JButton.LEFT);
                botonesP.get(i).setOpaque(true);
            }
            
            // LISTA POKEMONS + SCROLL (PANEL POKEMONS) ///////////////////////////////////////////
            JScrollPane panelScrollPokemons = new JScrollPane(panelListaPokemons, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            // ANADIR POKEMON (PANEL POKEMONS) /////////////////////////////////////////////////////
            JButton anadirPokemon = new JButton("Añadir Pokemon");
            anadirPokemon.setPreferredSize(new Dimension(0,40));
            anadirPokemon.setHorizontalAlignment(JLabel.CENTER);
            anadirPokemon.setFont(new Font("Courier New", Font.BOLD, 12));
            anadirPokemon.setFocusable(false);
            anadirPokemon.setForeground(new Color (82, 97, 107));
            anadirPokemon.setBackground(new Color (201,214,223));

        // COMPONENTES - PANEL POKEMONS /////////////////////////////////////////////////////////////
        panelPokemons.add(tituloPokemons, BorderLayout.NORTH);
        panelPokemons.add(panelScrollPokemons, BorderLayout.CENTER);
        panelPokemons.add(anadirPokemon, BorderLayout.SOUTH);
        
        // PANEL ENTRENADORES ///////////////////////////////////////////////////////////////////////
        panelEntrenadores = new JPanel();
        panelEntrenadores.setBounds(1000,170,300,500);
        panelEntrenadores.setBackground(new Color (82, 97, 107));
        panelEntrenadores.setBorder(BorderFactory.createEtchedBorder());
        panelEntrenadores.setLayout(new BorderLayout());
        
            // TITULO (PANEL ENTRENADORES) /////////////////////////////////////////////////////////
            JLabel tituloEntrenadores = new JLabel("ENTRENADORES");
            tituloEntrenadores.setHorizontalAlignment(JLabel.CENTER);
            tituloEntrenadores.setPreferredSize(new Dimension(0,80));
            tituloEntrenadores.setFont(new Font("Courier New", Font.BOLD, 25));
            tituloEntrenadores.setForeground(new Color (201, 214, 223));
            
            // LISTA ENTRENADORES (PANEL ENTRENADORES) ////////////////////////////////////////////
            panelListaEntrenadores = new JPanel();
            panelListaEntrenadores.setLayout(new GridLayout(0,1,0,5));
            
            anadirEntrenadorPanel ();

            // LISTA ENTRENADORES + SCROLL (PANEL ENTRENADORES) ///////////////////////////////////
            JScrollPane panelScrollEntrenadores = new JScrollPane(panelListaEntrenadores, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            // ANADIR ENTRENADOR (PANEL ENTRENADORES) /////////////////////////////////////////////
            anadirEntrenador = new JButton("Añadir Entrenador");
            anadirEntrenador.setPreferredSize(new Dimension(0,40));
            anadirEntrenador.setHorizontalAlignment(JLabel.CENTER);
            anadirEntrenador.setFont(new Font("Courier New", Font.BOLD, 12));
            anadirEntrenador.setFocusable(false);
            anadirEntrenador.setForeground(new Color (82, 97, 107));
            anadirEntrenador.setBackground(new Color (201,214,223));
            anadirEntrenador.addActionListener(this);

            // COMPONENTES - PANEL ENTRENADORES ///////////////////////////////////////////////////
            panelEntrenadores.add(tituloEntrenadores, BorderLayout.NORTH);
            panelEntrenadores.add(panelScrollEntrenadores, BorderLayout.CENTER);
            panelEntrenadores.add(anadirEntrenador, BorderLayout.SOUTH);


        // WORLD WINDOW ///////////////////////////////////////////////////////////////////////////
        ImageIcon imageWindow = new ImageIcon("./src/GUI/Imagenes/logo.png");
        VentanaMundo.setIconImage(imageWindow.getImage());
        VentanaMundo.setTitle("POOkemon");
        VentanaMundo.setResizable(false);
        VentanaMundo.setSize(1600,900);
        VentanaMundo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        VentanaMundo.getContentPane().setBackground(new Color (48,56,65));
        // VentanaMundo.setUndecorated(true);
        VentanaMundo.setLayout(null);
        VentanaMundo.add(volver);
        VentanaMundo.add(tituloMundo);
        VentanaMundo.add(panelPokemons);
        VentanaMundo.add(panelEntrenadores);
        VentanaMundo.setLocationRelativeTo(null);
        VentanaMundo.setVisible(true);
    }

    public void anadirEntrenadorPanel (){
        for (int i=0; i<botonesE.size();i++){
            botonesE.get(i).setPreferredSize(new Dimension(0,50));
            botonesE.get(i).setBackground(new Color (238,238,238));
            botonesE.get(i).setFocusable(false);
            botonesE.get(i).setFont(new Font("Courier New", Font.BOLD, 16));
            botonesE.get(i).setIcon(new ImageIcon("./src/GUI/Imagenes/pikachu.png"));
            botonesE.get(i).setHorizontalAlignment(JButton.LEFT);
            panelListaEntrenadores.add(botonesE.get(i));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==volver){
            VentanaMundo.dispose();
            new VentanaInicio();
        }
        if (e.getSource()==anadirEntrenador){
            new AnadirEntrenador();
            anadirEntrenadorPanel();
        }
    }

    public void actualizarPanel (JButton boton){
        panelListaEntrenadores.add(boton);
    }

}
