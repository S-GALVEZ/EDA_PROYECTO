/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyecto_eda;

import VISTA.LoginPanel;

public class PROYECTO_EDA {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new LoginPanel().setVisible(true); // Inicia primero con el login
        });
    }
}