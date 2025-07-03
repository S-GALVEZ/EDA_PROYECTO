/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import javax.swing.*;

public class LoginPanel extends JFrame {

    private JTextField usuarioField;
    private JPasswordField claveField;
    private JButton botonIngresar;

    public LoginPanel() {
        setTitle("Inicio de Sesión");
        setSize(300, 200);
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
    }

    private void verificarCredenciales() {
        String usuario = usuarioField.getText().trim();
        String clave = new String(claveField.getPassword());

        if (usuario.equalsIgnoreCase("admin") && clave.equals("12345")) {
            JOptionPane.showMessageDialog(this, "Bienvenido, administrador.");
            this.dispose(); 
            // Aquí abre tu ventana principal:
            new MenuPrincipal().setVisible(true); 
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}