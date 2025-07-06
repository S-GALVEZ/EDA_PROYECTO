/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_eda1;
import VISTA.LoginPanel;
import CLASES.GestionExpediente;
import javax.swing.SwingUtilities;

/**
 *
 * @author Gianfranco
 */
public class PROYECTO_EDA1 {

    public static void main(String[] args){
          SwingUtilities.invokeLater(() -> {
          GestionExpediente gestionExp = new GestionExpediente();
          new LoginPanel(gestionExp).setVisible(true); 
        });
    }
}
