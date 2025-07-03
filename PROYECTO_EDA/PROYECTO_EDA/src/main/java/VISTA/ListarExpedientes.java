/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;
import java.time.format.DateTimeFormatter;
import CLASES.Expediente;
import CLASES.GestionExpediente;
import CLASES.Nodo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListarExpedientes extends JFrame {
    private JTable tabla;
    private JButton btnCerrar;
    private GestionExpediente gestionExp;
    

    public ListarExpedientes(GestionExpediente gestionExp) {
        this.gestionExp = gestionExp;
        setTitle("Listado de Expedientes");
        setSize(900, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        tabla = new JTable();
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());

        cargarTabla();

        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);
        add(btnCerrar, BorderLayout.SOUTH);
    }

    private void cargarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IDENTIFICADOR");
        modelo.addColumn("PRIORIDAD");
        modelo.addColumn("ASUNTO");
        modelo.addColumn("DOCUMENTO");
        modelo.addColumn("DNI");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("EMAIL");
        modelo.addColumn("ESTADO");
        modelo.addColumn("FECHA CREACIÓN");
        modelo.addColumn("FECHA FINALIZACIÓN");
        //Modificar el formato de la fecha
        java.time.format.DateTimeFormatter formato = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        

        Expediente aux;
        Nodo actual = gestionExp.getPrimero();
        int contador = 0;

        while (actual != null) {
            aux = (Expediente) actual.getElemento();
            modelo.insertRow(contador++, new Object[]{
                    aux.getIdentificador(),
                    aux.getPrioridad(),
                    aux.getAsunto(),
                    aux.getDocumento(),
                    aux.getDNI(),
                    aux.getNombre(),
                    aux.getTelefono(),
                    aux.getEmail(),
                    aux.estaFinalizado() ? "Finalizado" : "Pendiente",
                    aux.getFechaInicio().toString(),
                    aux.getFechaFin() != null ? aux.getFechaFin().toString() : "En proceso"
            });
            actual = actual.getSiguiente();
        }

        tabla.setModel(modelo);

        // Pintar filas por estado
        tabla.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                String estado = table.getValueAt(row, 8).toString();
                if (estado.equalsIgnoreCase("Finalizado")) {
                    c.setBackground(new Color(144, 238, 144)); // Verde claro
                } else {
                    c.setBackground(new Color(255, 182, 193)); // Rojo claro
                }

                if (isSelected) {
                    c.setBackground(new Color(100, 149, 237)); // Azul al seleccionar
                }

                return c;
            }
        });
    }
}
