/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import javax.swing.*;

public class ClubWalls extends JFrame {

    private JTextField tfCodigo;
    private JButton btnVerificar;
    private JLabel lblResultado;

    public ClubWalls() {
        setTitle("Acceso al Club");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblInstruccion = new JLabel("Ingresa el código secreto:");
        lblInstruccion.setBounds(30, 30, 200, 25);
        add(lblInstruccion);

        tfCodigo = new JTextField();
        tfCodigo.setBounds(30, 60, 200, 25);
        add(tfCodigo);

        btnVerificar = new JButton("Verificar");
        btnVerificar.setBounds(240, 60, 100, 25);
        add(btnVerificar);

        lblResultado = new JLabel("");
        lblResultado.setBounds(30, 100, 350, 25);
        add(lblResultado);

        btnVerificar.addActionListener(e -> verificarCodigo());
    }

    private void verificarCodigo() {
        String codigoIngresado = tfCodigo.getText().trim();
        if (codigoIngresado.equals("Walls")) {
            lblResultado.setText("¡Felicidades! Eres miembro del club Los Ladrillos de Walls 😎");
        } else {
            lblResultado.setText("Buen intento. Acceso denegado.");
            tfCodigo.setEnabled(false);
            btnVerificar.setEnabled(false);
        }
    }
}
