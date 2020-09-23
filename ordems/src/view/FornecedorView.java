/*
 * To change this template, choose Tools | Templates


 * and open the template in the editor.
 */

/*
 * CepView.java
 *
 * Created on 03/10/2016, 14:47:58
 * Fonte e cr�ditos.
 * https://www.republicavirtual.com.br/cep/index.php
 */
package view;

import dao.APIConsultaCEP;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author ADM
 */
public class CepViewModelo extends javax.swing.JFrame {

    /** Creates new form CEP */
    public CepViewModelo() {
    	setTitle("Consulta Logradouro");
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enderecoPanel = new javax.swing.JPanel();
        logradouroLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        ruaField = new javax.swing.JTextField();
        bairroLabel = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        bairroField = new javax.swing.JTextField();
        cidadeLabel = new javax.swing.JLabel();
        cidadeField = new javax.swing.JTextField();
        ufLabel = new javax.swing.JLabel();
        estadoComboBox = new javax.swing.JComboBox();
        cepLabel = new javax.swing.JLabel();
        cepField = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        

        try {
            cepField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cepField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TCEPKeyReleased(evt);
            }
        });


        cepLabel.setText("CEP");
        
        logradouroLabel.setText("Logradouro");

        jTextField1.setText("jTextField1");

        bairroLabel.setText("Bairro");

        jTextField2.setText("jTextField2");

        cidadeLabel.setText("Cidade");

        ufLabel.setText("UF");

        estadoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));


        javax.swing.GroupLayout gl_enderecoPanel = new javax.swing.GroupLayout(enderecoPanel);
        gl_enderecoPanel.setHorizontalGroup(
        	gl_enderecoPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_enderecoPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_enderecoPanel.createParallelGroup(Alignment.TRAILING)
        				.addComponent(cidadeLabel)
        				.addComponent(bairroLabel)
        				.addComponent(logradouroLabel)
        				.addComponent(cepLabel)
        				.addComponent(ufLabel))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_enderecoPanel.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(cidadeField)
        				.addComponent(bairroField, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        				.addComponent(ruaField, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        				.addComponent(cepField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
        				.addComponent(estadoComboBox, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(244, Short.MAX_VALUE))
        );
        gl_enderecoPanel.setVerticalGroup(
        	gl_enderecoPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_enderecoPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_enderecoPanel.createParallelGroup(Alignment.TRAILING)
        				.addComponent(cepLabel)
        				.addComponent(cepField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_enderecoPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(logradouroLabel)
        				.addComponent(ruaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_enderecoPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(bairroField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(bairroLabel))
        			.addGap(18)
        			.addGroup(gl_enderecoPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(cidadeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cidadeLabel))
        			.addGap(18)
        			.addGroup(gl_enderecoPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(estadoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(ufLabel))
        			.addContainerGap(213, Short.MAX_VALUE))
        );
        enderecoPanel.setLayout(gl_enderecoPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(enderecoPanel, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(enderecoPanel, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-693)/2, (screenSize.height-338)/2, 540, 300);
    }// </editor-fold>//GEN-END:initComponents

private void TCEPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCEPKeyReleased
    String cp = cepField.getText();
    cp = cp.replaceAll("\\D*", ""); //ignora qualquer coisa que não seja numero.  
    int cont = cp.length();
    
    if(cont == 8){
     try{
     correio();
     }
     catch(Error e){
     JOptionPane.showMessageDialog(null, e); 
     }
    }// TODO add your handling code here:
}//GEN-LAST:event_TCEPKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CepViewModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CepViewModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CepViewModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CepViewModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CepViewModelo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox estadoComboBox;
    private javax.swing.JTextField bairroField;
    private javax.swing.JFormattedTextField cepField;
    private javax.swing.JTextField cidadeField;
    private javax.swing.JTextField ruaField;
    private javax.swing.JLabel logradouroLabel;
    private javax.swing.JLabel bairroLabel;
    private javax.swing.JLabel cidadeLabel;
    private javax.swing.JLabel ufLabel;
    private javax.swing.JLabel cepLabel;
    private javax.swing.JPanel enderecoPanel;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
public  void correio() {
    
                String cep =  cepField.getText();
		
                APIConsultaCEP webServiceCep = APIConsultaCEP.searchCep(cep);

		if (webServiceCep.wasSuccessful()) {
                       
                        ruaField.setText(webServiceCep.getLogradouroFull()); 
                        bairroField.setText(webServiceCep.getBairro());                        
                        cidadeField.setText(webServiceCep.getCidade());
                        estadoComboBox.setSelectedItem( webServiceCep.getUf());

		} else {
                         JOptionPane.showMessageDialog(null, webServiceCep.getResultText());
                        
		}
			
	}



}
