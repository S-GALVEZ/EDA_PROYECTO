/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import CLASES.GestionExpediente;
import javax.swing.*;

public class LoginPanel extends JFrame {

    private JTextField usuarioField;
    private JPasswordField claveField;
    private JButton botonIngresar;
    private GestionExpediente gestionExp;


    public LoginPanel() {
        setTitle("Inicio de Sesión");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }
    
    public LoginPanel(GestionExpediente gestionExp) {
    this.gestionExp = gestionExp;
    setTitle("Inicio de Sesión");
    setSize(300, 250);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    initComponents();
}


    private void initComponents() {
        JLabel usuarioLabel = new JLabel("Usuario:");
        JLabel claveLabel = new JLabel("Contraseña:");

        usuarioField = new JTextField();
        claveField = new JPasswordField();
        botonIngresar = new JButton("Ingresar");

        botonIngresar.addActionListener(e -> verificarCredenciales());

        JPanel panel = new JPanel();
        panel.setLayout(null);

        usuarioLabel.setBounds(30, 30, 80, 25);
        usuarioField.setBounds(120, 30, 130, 25);

        claveLabel.setBounds(30, 70, 80, 25);
        claveField.setBounds(120, 70, 130, 25);

        botonIngresar.setBounds(90, 120, 100, 30);

        panel.add(usuarioLabel);
        panel.add(usuarioField);
        panel.add(claveLabel);
        panel.add(claveField);
        panel.add(botonIngresar);

        add(panel);
        
        JButton botonRemitente = new JButton("Nuevo Expediente");
        botonRemitente.setBounds(60, 160, 160, 25);
        panel.add(botonRemitente);
            
        botonRemitente.addActionListener(e -> {
        this.setVisible(true);
        new Remitente(gestionExp, this).setVisible(true);
        
});

    }

    private void verificarCredenciales() {
        String usuario = usuarioField.getText().trim();
        String clave = new String(claveField.getPassword());
        if (usuario.equalsIgnoreCase("admin") && clave.equals("12345")) {
        this.dispose();
        new MenuPrincipal(gestionExp).setVisible(true); 
}

    }
}
