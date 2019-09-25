package teste;

import javax.swing.JFrame;

import view.UsuarioView;

public class TesteCreateUsuario {
    
    public static void main(String[] args) {
        UsuarioView ViewUsuario = new UsuarioView();
        
        ViewUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ViewUsuario.setSize(1024, 500);
        ViewUsuario.setVisible(true);
        ViewUsuario.setLocationRelativeTo(null);
    }

}