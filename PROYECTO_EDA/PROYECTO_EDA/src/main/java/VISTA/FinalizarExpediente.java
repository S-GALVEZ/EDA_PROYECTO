/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import CLASES.Expediente;
import CLASES.GestionExpediente;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class FinalizarExpediente extends javax.swing.JFrame {

    private GestionExpediente gestionExp;

    public FinalizarExpediente(GestionExpediente gestionExp) {
        this.gestionExp = gestionExp;
        initComponents();
    }

    private void initComponents() {
        setTitle("Finalizar Expediente");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        jLabel1 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        btFinalizar = new javax.swing.JButton();

        jLabel1.setText("Ingrese el ID del expediente:");

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(e -> buscarExpediente());

        btFinalizar.setText("Finalizar");
        btFinalizar.setEnabled(false);
        btFinalizar.addActionListener(e -> finalizarExpediente());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btBuscar)
                        .addComponent(btFinalizar))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18)
                .addComponent(btBuscar)
                .addGap(18)
                .addComponent(btFinalizar)
                .addContainerGap(30, Short.MAX_VALUE)
        );

        pack();
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField tfID;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btFinalizar;

    private Expediente expedienteEncontrado;

    private void buscarExpediente() {
        String id = tfID.getText().trim();
        expedienteEncontrado = gestionExp.buscarPorID(id);

        if (expedienteEncontrado != null) {
            if (expedienteEncontrado.estaFinalizado()) {
                JOptionPane.showMessageDialog(this, "Este expediente ya está finalizado.", "Aviso", JOptionPane.WARNING_MESSAGE);
                btFinalizar.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Expediente encontrado:\n" + expedienteEncontrado.toString(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
                btFinalizar.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún expediente con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
            btFinalizar.setEnabled(false);
        }
    }

    private void finalizarExpediente() {
        if (expedienteEncontrado != null && !expedienteEncontrado.estaFinalizado()) {
            expedienteEncontrado.setFechaFin(LocalDateTime.now());
            JOptionPane.showMessageDialog(this, "El expediente ha sido finalizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }
}
