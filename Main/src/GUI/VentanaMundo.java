package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Enumeration;

public class VentanaMundo implements ActionListener{
    public static VentanaMundo iVentanaMundo;

    private JFrame ventanaNuevoMundo = new JFrame();
    private JButton volver;
    private JLabel tituloMundo;
    
    private JPanel panelPokemons;
    private JPanel panelListaPokemons;
    private ArrayList<BotonPokemon> botonesP = new ArrayList<>();
    private JButton anadirPokemon;
    private JTextField nombrePokemonSeleccionado;
    private JTextField tipoPokemonSeleccionado;
    private JPanel panelDetalles;
    private JButton botonModificar;
    private JButton botonEliminar;
    private JButton botonGuardarDetalles;
    private JPanel panelBotonesModDel;
    private JPanel panelControl;
    private ButtonGroup grupoBotonesPokemon = new ButtonGroup();
    
    private JPanel panelEntrenadores;
    private JPanel panelListaEntrenadores;
    private ArrayList<BotonPokemon> botonesE = new ArrayList<>();
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

            
            // TITULO (PANEL POKEMONS) //////////////////////////////////////////////////////////////
            JLabel tituloPokemons = new JLabel("POKEMONS");
            tituloPokemons.setHorizontalAlignment(JLabel.CENTER);
            tituloPokemons.setPreferredSize(new Dimension(0,80));
            tituloPokemons.setFont(new Font("Courier New", Font.BOLD, 24));
            tituloPokemons.setForeground(cBotonesClaro);
            
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
            tituloEntrenadores.setForeground(cBotonesClaro);
            
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

        // WORLD WINDOW ///////////////////////////////////////////////////////////////////////////
        ImageIcon imageWindow = new ImageIcon("./src/GUI/Imagenes/logo.png");
        ventanaNuevoMundo.setIconImage(imageWindow.getImage());
        ventanaNuevoMundo.setTitle("POOkemon");
        ventanaNuevoMundo.setResizable(false);
        ventanaNuevoMundo.setSize(1600,900);
        ventanaNuevoMundo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaNuevoMundo.getContentPane().setBackground(cFondo);
        ventanaNuevoMundo.setLayout(null);
        ventanaNuevoMundo.add(volver);
        ventanaNuevoMundo.add(tituloMundo);
        ventanaNuevoMundo.add(panelPokemons);
        ventanaNuevoMundo.add(panelEntrenadores);
        ventanaNuevoMundo.add(panelControl);
        ventanaNuevoMundo.setLocationRelativeTo(null);
        ventanaNuevoMundo.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==volver){
            int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas salir del mundo?", "Atención", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION){
                ventanaNuevoMundo.dispose();
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
                    
                    panelControl.removeAll();
                    
                    JLabel etiquetaNombre = new JLabel("Nombre:");
                        etiquetaNombre.setHorizontalAlignment(JLabel.RIGHT);
                    JLabel etiquetaTipo = new JLabel("Tipo:");
                        etiquetaTipo.setHorizontalAlignment(JLabel.RIGHT);
                    JLabel etiquetaNivel = new JLabel("Nivel:");
                        etiquetaNivel.setHorizontalAlignment(JLabel.RIGHT);
                    JLabel etiquetaEntrenador = new JLabel("Entrenador:");
                        etiquetaEntrenador.setHorizontalAlignment(JLabel.RIGHT);
                    JLabel etiquetaPoder = new JLabel("Poder:");
                        etiquetaPoder.setHorizontalAlignment(JLabel.RIGHT);
                    JLabel etiquetaPoderEspecial = new JLabel("Poder especial:");
                        etiquetaPoderEspecial.setHorizontalAlignment(JLabel.RIGHT);
                    JLabel etiquetaDefensa = new JLabel("Defensa:");
                        etiquetaDefensa.setHorizontalAlignment(JLabel.RIGHT);
                    JLabel etiquetaDefensaEspecial = new JLabel("Defensa especial:");
                        etiquetaDefensaEspecial.setHorizontalAlignment(JLabel.RIGHT);
                    JLabel etiquetaVelocidad = new JLabel("Velocidad:");
                        etiquetaVelocidad.setHorizontalAlignment(JLabel.RIGHT);
                    JLabel etiquetaSaludMax = new JLabel("Salud máxima:");
                        etiquetaSaludMax.setHorizontalAlignment(JLabel.RIGHT);

                    nombrePokemonSeleccionado = new JTextField();
                        nombrePokemonSeleccionado.setText(botonesP.get(i).getPokemon().getNombre());
                        nombrePokemonSeleccionado.setEditable(false);
                        nombrePokemonSeleccionado.setPreferredSize(new Dimension(100,20));
                        nombrePokemonSeleccionado.setBorder(null);
                        nombrePokemonSeleccionado.setBackground(null);
                    tipoPokemonSeleccionado = new JTextField();
                        tipoPokemonSeleccionado.setText(botonesP.get(i).getPokemon().getTipo());
                        tipoPokemonSeleccionado.setEditable(false);
                        tipoPokemonSeleccionado.setBorder(null);
                        tipoPokemonSeleccionado.setBackground(null);
                    JTextField nivelPokemonSeleccionado = new JTextField();
                        nivelPokemonSeleccionado.setText(String.valueOf(botonesP.get(i).getPokemon().getNivel()));
                        nivelPokemonSeleccionado.setEditable(false);
                        nivelPokemonSeleccionado.setBorder(null);
                        nivelPokemonSeleccionado.setBackground(null);
                    JTextField entrenadorPokemonSeleccionado = new JTextField();
                        entrenadorPokemonSeleccionado.setText(botonesP.get(i).getPokemon().condicionExistenciaEntrenador());
                        entrenadorPokemonSeleccionado.setEditable(false);
                        entrenadorPokemonSeleccionado.setBorder(null);
                        entrenadorPokemonSeleccionado.setBackground(null);
                    JTextField poderPokemonSeleccionado = new JTextField();
                        poderPokemonSeleccionado.setText(String.valueOf(botonesP.get(i).getPokemon().getPoder()));
                        poderPokemonSeleccionado.setEditable(false);
                        poderPokemonSeleccionado.setBorder(null);
                        poderPokemonSeleccionado.setBackground(null);
                    JTextField poderEspecialPokemonSeleccionado = new JTextField();
                        poderEspecialPokemonSeleccionado.setText(String.valueOf(botonesP.get(i).getPokemon().getPoderEspecial()));
                        poderEspecialPokemonSeleccionado.setEditable(false);
                        poderEspecialPokemonSeleccionado.setBorder(null);
                        poderEspecialPokemonSeleccionado.setBackground(null);
                    JTextField defensaPokemonSeleccionado = new JTextField();
                        defensaPokemonSeleccionado.setText(String.valueOf(botonesP.get(i).getPokemon().getDefensa()));
                        defensaPokemonSeleccionado.setEditable(false);
                        defensaPokemonSeleccionado.setBorder(null);
                        defensaPokemonSeleccionado.setBackground(null);
                    JTextField defensaEspecialPokemonSeleccionado = new JTextField();
                        defensaEspecialPokemonSeleccionado.setText(String.valueOf(botonesP.get(i).getPokemon().getDefensaEspecial()));
                        defensaEspecialPokemonSeleccionado.setEditable(false);
                        defensaEspecialPokemonSeleccionado.setBorder(null);
                        defensaEspecialPokemonSeleccionado.setBackground(null);
                    JTextField velocidadPokemonSeleccionado = new JTextField();
                        velocidadPokemonSeleccionado.setText(String.valueOf(botonesP.get(i).getPokemon().getVelocidad()));
                        velocidadPokemonSeleccionado.setEditable(false);
                        velocidadPokemonSeleccionado.setBorder(null);
                        velocidadPokemonSeleccionado.setBackground(null);
                    JTextField saludMaxPokemonSeleccionado = new JTextField();
                        saludMaxPokemonSeleccionado.setText(String.valueOf(botonesP.get(i).getPokemon().getSaludMax()));
                        saludMaxPokemonSeleccionado.setEditable(false);
                        saludMaxPokemonSeleccionado.setBorder(null);
                        saludMaxPokemonSeleccionado.setBackground(null);
                    
                    panelDetalles = new JPanel();
                        panelDetalles.setLayout(new GridLayout(0,2,10,0));
                        panelDetalles.setBackground(cBotonesOscuro);
                        panelDetalles.add(etiquetaNombre);
                        panelDetalles.add(nombrePokemonSeleccionado);
                        panelDetalles.add(etiquetaTipo);
                        panelDetalles.add(tipoPokemonSeleccionado);
                        panelDetalles.add(etiquetaNivel);
                        panelDetalles.add(nivelPokemonSeleccionado);
                        panelDetalles.add(etiquetaEntrenador);
                        panelDetalles.add(entrenadorPokemonSeleccionado);
                        panelDetalles.add(etiquetaPoder);
                        panelDetalles.add(poderPokemonSeleccionado);
                        panelDetalles.add(etiquetaPoderEspecial);
                        panelDetalles.add(poderEspecialPokemonSeleccionado);
                        panelDetalles.add(etiquetaDefensa);
                        panelDetalles.add(defensaPokemonSeleccionado);
                        panelDetalles.add(etiquetaDefensaEspecial);
                        panelDetalles.add(defensaEspecialPokemonSeleccionado);
                        panelDetalles.add(etiquetaVelocidad);
                        panelDetalles.add(velocidadPokemonSeleccionado);
                        panelDetalles.add(etiquetaSaludMax);
                        panelDetalles.add(saludMaxPokemonSeleccionado);

                    for (int j=0; j<20; j++){
                        panelDetalles.getComponent(j).setForeground(cLetra);
                        if((j%2)==0){
                            panelDetalles.getComponent(j).setFont(new Font("Courier New", Font.PLAIN, 13));
                        }else {
                            panelDetalles.getComponent(j).setFont(new Font("Courier New", Font.BOLD, 15));
                        }
                    }

                    botonModificar = new JButton("Modificar");
                        botonModificar.setBounds(10, 10, 100, 30);
                        botonModificar.setHorizontalAlignment(JButton.CENTER);
                        botonModificar.setFont(new Font("Courier New", Font.BOLD, 12));
                        botonModificar.setFocusable(false);
                        botonModificar.setForeground(cBotonesOscuro);
                        botonModificar.setBackground(cBotonesClaro);
                        botonModificar.setBorder(BorderFactory.createEtchedBorder());
                        botonModificar.addActionListener(iVentanaMundo);

                    botonEliminar = new JButton("Eliminar");
                        botonEliminar.setBounds(470, 10, 120, 30);
                        botonEliminar.setIcon(new ImageIcon("./src/GUI/Imagenes/papelera.png"));
                        botonEliminar.setIconTextGap(5);
                        botonEliminar.setHorizontalAlignment(JButton.CENTER);
                        botonEliminar.setFont(new Font("Courier New", Font.BOLD, 12));
                        botonEliminar.setFocusable(false);
                        botonEliminar.setForeground(cBotonesClaro);
                        botonEliminar.setBackground(new Color (221,83,83));
                        botonEliminar.setBorder(BorderFactory.createEtchedBorder());
                        botonEliminar.addActionListener(iVentanaMundo);

                    botonGuardarDetalles = new JButton("Guardar");
                        botonGuardarDetalles.setBounds(10,10,580,30);
                        botonGuardarDetalles.setFont(new Font("Courier New", Font.BOLD, 12));
                        botonGuardarDetalles.setFocusable(false);
                        botonGuardarDetalles.setForeground(cBotonesOscuro);
                        botonGuardarDetalles.setBackground(cBotonesClaro);
                        botonGuardarDetalles.setVisible(false);
                        botonGuardarDetalles.addActionListener(iVentanaMundo);
                        
                    panelBotonesModDel = new JPanel();
                        panelBotonesModDel.setLayout(null);
                        panelBotonesModDel.setBackground(cBotonesOscuro);
                        panelBotonesModDel.setPreferredSize(new Dimension(0,50));
                        panelBotonesModDel.add(botonModificar);
                        panelBotonesModDel.add(botonEliminar);
                        panelBotonesModDel.add(botonGuardarDetalles);

                    panelControl.add(panelDetalles, BorderLayout.CENTER);
                    panelControl.add(panelBotonesModDel, BorderLayout.SOUTH);
                    panelControl.setVisible(true);
                    actualizarVentana();
                }
            }
            if(e.getSource()==botonEliminar){
                Enumeration<AbstractButton> botones = grupoBotonesPokemon.getElements();
                while (botones.hasMoreElements()) {
                    AbstractButton button = (AbstractButton)botones.nextElement();
                    if (button.isSelected()){
                        panelListaPokemons.remove(button);
                        grupoBotonesPokemon.remove(button);
                        botonesP.remove(button);
                        panelControl.setVisible(false);
                        actualizarVentana();
                    }
                }
            }
            if(e.getSource()==botonModificar){
                nombrePokemonSeleccionado.setEditable(true);
                nombrePokemonSeleccionado.setBackground(cBotonesClaro);
                nombrePokemonSeleccionado.setForeground(cBotonesOscuro);
                // tipoPokemonSeleccionado.setEditable(true);
                // tipoPokemonSeleccionado.setBackground(cBotonesClaro);
                // tipoPokemonSeleccionado.setForeground(cBotonesOscuro);

                botonEliminar.setVisible(false);
                botonModificar.setVisible(false);
                botonGuardarDetalles.setVisible(true);
            }

            if(e.getSource()==botonGuardarDetalles){
                nombrePokemonSeleccionado.setEditable(false);
                nombrePokemonSeleccionado.setBackground(cBotonesOscuro);
                nombrePokemonSeleccionado.setForeground(cBotonesClaro);
                // tipoPokemonSeleccionado.setEditable(false);
                // tipoPokemonSeleccionado.setBackground(cBotonesOscuro);
                // tipoPokemonSeleccionado.setForeground(cBotonesClaro);

                botonEliminar.setVisible(true);
                botonModificar.setVisible(true);
                botonGuardarDetalles.setVisible(false);

                Enumeration<AbstractButton> botones = grupoBotonesPokemon.getElements();
                while (botones.hasMoreElements()) {
                    AbstractButton button = (AbstractButton)botones.nextElement();
                    if (button.isSelected()){
                        for(int i=0; i<botonesP.size();i++){
                            if(botonesP.get(i)==button){
                                botonesP.get(i).getPokemon().setNombre(nombrePokemonSeleccionado.getText());
                                button.setText(nombrePokemonSeleccionado.getText());
                                // botonesP.get(i).getPokemon().setTipo(tipoPokemonSeleccionado.getText());
                                
                                
                                
                                
                                actualizarVentana();
                                panelListaPokemons.repaint();
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
                    panelControl.setVisible(false);
                    actualizarVentana();
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

    public void actualizarVentana(){
        ventanaNuevoMundo.invalidate();
        ventanaNuevoMundo.validate();
        ventanaNuevoMundo.repaint();
    }

    // Getters

    public JPanel getPanelListaEntrenadores() {
        return panelListaEntrenadores;
    }

    public JFrame getventanaNuevoMundo() {
        return ventanaNuevoMundo;
    }

    public ArrayList<BotonPokemon> getBotonesE() {
        return botonesE;
    }

    public ArrayList<BotonPokemon> getBotonesP() {
        return botonesP;
    }

    public JPanel getPanelListaPokemons() {
        return panelListaPokemons;
    }

    public ButtonGroup getGrupoBotonesPokemon() {
        return grupoBotonesPokemon;
    }

}
