package com.ordems.usuario.gui;

import javax.swing.JFrame;

public class CreateUsuario {
    
    public static void main(String[] args) {
        ViewUsuario ViewUsuario = new ViewUsuario();
        
        ViewUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ViewUsuario.setSize(1024, 500);
        ViewUsuario.setVisible(true);
        ViewUsuario.setLocationRelativeTo(null);
    }

}

