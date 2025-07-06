/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import CLASES.GestionExpediente;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Gianfranco
 */
public class Remitente extends JFrame {
    private GestionExpediente gestionExp;
    private LoginPanel loginPanel;

    public Remitente(GestionExpediente gestionExp, LoginPanel loginPanel) {
        this.gestionExp = gestionExp;
        this.loginPanel = loginPanel;
        initComponents();
    }

    private void initComponents() {
        setTitle("Remitente - Enviar Expediente");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JButton btEnviar = new JButton("Agregar Nuevo Expediente");
        JButton btVolver = new JButton("Volver al Login");

        btEnviar.addActionListener(e -> new AgregarExpediente(gestionExp).setVisible(true));
        btVolver.addActionListener(e -> {
            this.dispose(); // Cerramos la ventana del remitente
            loginPanel.setVisible(true); // Volvemos a mostrar el login
        });

        setLayout(new GridLayout(2, 1, 10, 10));
        add(btEnviar);
        add(btVolver);
    }
}
