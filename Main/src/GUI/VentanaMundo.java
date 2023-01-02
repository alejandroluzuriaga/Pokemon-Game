package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaMundo implements ActionListener{
    public static VentanaMundo iVentanaMundo;

    private JFrame VentanaNuevoMundo = new JFrame();
    private JButton volver;
    private JLabel tituloMundo;
    private JPanel panelPokemons;
    private JPanel panelEntrenadores;
    private JPanel panelListaPokemons;
    private JPanel panelListaEntrenadores;
    private ArrayList<BotonPokemon> botonesP = new ArrayList<>();
    private JButton anadirPokemon;
    private ArrayList<JButton> botonesE = new ArrayList<>();
    private JButton anadirEntrenador;

    private Color cLetra = new Color (240, 245, 249);
    private Color cBotonesClaro = new Color (201,214,223);
    private Color cBotonesOscuro = new Color (58,71,80);
    private Color cFondo = new Color (48,56,65);

    public VentanaMundo(){
        iVentanaMundo = this;
        
        // VOLVER ///////////////////////////////////////////////////////////////////////////////////
        volver = new JButton("VOLVER");
        volver.setBounds(15,790,130,60);
        volver.setHorizontalAlignment(JButton.CENTER);
        volver.setIcon(new ImageIcon("./src/GUI/Imagenes/volver.png"));
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


        // PANEL POKEMONS ///////////////////////////////////////////////////////////////////////////
        panelPokemons = new JPanel();
        panelPokemons.setBounds(300,170,300,500);
        panelPokemons.setBackground(cBotonesOscuro);
        panelPokemons.setBorder(BorderFactory.createEtchedBorder());
        panelPokemons.setLayout(new BorderLayout());
            
            // TITULO (PANEL POKEMONS) //////////////////////////////////////////////////////////////
            JLabel tituloPokemons = new JLabel("POKEMONS");
            tituloPokemons.setHorizontalAlignment(JLabel.CENTER);
            tituloPokemons.setPreferredSize(new Dimension(0,80));
            tituloPokemons.setFont(new Font("Courier New", Font.BOLD, 24));
            tituloPokemons.setForeground(cBotonesClaro);
            
            // LISTA POKEMONS (PANEL POKEMONS) /////////////////////////////////////////////////////
            panelListaPokemons = new JPanel();
            panelListaPokemons.setLayout(new GridLayout(0,1,0,5));
            
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

            // COMPONENTES - PANEL POKEMONS /////////////////////////////////////////////////////////////
            panelPokemons.add(tituloPokemons, BorderLayout.NORTH);
            panelPokemons.add(panelScrollPokemons, BorderLayout.CENTER);
            panelPokemons.add(anadirPokemon, BorderLayout.SOUTH);
        
        // PANEL ENTRENADORES ///////////////////////////////////////////////////////////////////////
        panelEntrenadores = new JPanel();
        panelEntrenadores.setBounds(1000,170,300,500);
        panelEntrenadores.setBackground(cBotonesOscuro);
        panelEntrenadores.setBorder(BorderFactory.createEtchedBorder());
        panelEntrenadores.setLayout(new BorderLayout());
        
            // TITULO (PANEL ENTRENADORES) /////////////////////////////////////////////////////////
            JLabel tituloEntrenadores = new JLabel("ENTRENADORES");
            tituloEntrenadores.setHorizontalAlignment(JLabel.CENTER);
            tituloEntrenadores.setPreferredSize(new Dimension(0,80));
            tituloEntrenadores.setFont(new Font("Courier New", Font.BOLD, 25));
            tituloEntrenadores.setForeground(cBotonesClaro);
            
            // LISTA ENTRENADORES (PANEL ENTRENADORES) ////////////////////////////////////////////
            panelListaEntrenadores = new JPanel();
            panelListaEntrenadores.setLayout(new GridLayout(0,1,0,5));

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

            // COMPONENTES - PANEL ENTRENADORES ///////////////////////////////////////////////////
            panelEntrenadores.add(tituloEntrenadores, BorderLayout.NORTH);
            panelEntrenadores.add(panelScrollEntrenadores, BorderLayout.CENTER);
            panelEntrenadores.add(anadirEntrenador, BorderLayout.SOUTH);


        // WORLD WINDOW ///////////////////////////////////////////////////////////////////////////
        ImageIcon imageWindow = new ImageIcon("./src/GUI/Imagenes/logo.png");
        VentanaNuevoMundo.setIconImage(imageWindow.getImage());
        VentanaNuevoMundo.setTitle("POOkemon");
        VentanaNuevoMundo.setResizable(false);
        VentanaNuevoMundo.setSize(1600,900);
        VentanaNuevoMundo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VentanaNuevoMundo.getContentPane().setBackground(cFondo);
        // VentanaNuevoMundo.setUndecorated(true);
        VentanaNuevoMundo.setLayout(null);
        VentanaNuevoMundo.add(volver);
        VentanaNuevoMundo.add(tituloMundo);
        VentanaNuevoMundo.add(panelPokemons);
        VentanaNuevoMundo.add(panelEntrenadores);
        VentanaNuevoMundo.setLocationRelativeTo(null);
        VentanaNuevoMundo.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==volver){
            int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas salir del mundo?", "Atención", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION){
                VentanaNuevoMundo.dispose();
                new VentanaInicio();
            } else{
                
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
                    System.out.println(botonesP.get(i).getPokemon().toString());
                }
            }
        }
    }

    public boolean contieneEntrenador (String nombre) {
        boolean existe = false;
        for (int i=0; i<botonesE.size(); i++){
            if(botonesE.get(i).getText()==nombre){
                existe = true;
            }
        }
        return existe;
    }



    // Getters

    public JPanel getPanelListaEntrenadores() {
        return panelListaEntrenadores;
    }

    public JFrame getVentanaNuevoMundo() {
        return VentanaNuevoMundo;
    }

    public ArrayList<JButton> getBotonesE() {
        return botonesE;
    }

    public ArrayList<BotonPokemon> getBotonesP() {
        return botonesP;
    }

    public JPanel getPanelListaPokemons() {
        return panelListaPokemons;
    }
}
