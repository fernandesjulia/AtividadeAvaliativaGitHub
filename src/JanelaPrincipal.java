import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*

 */
/**
 * @author juhfe
 */
public class JanelaPrincipal extends javax.swing.JFrame {
// criado para representar a barra de rolagem

    private static JScrollPane barraRolagem;
// criado para auxiliar na transição dos paineis existentes
    private static JPanel trocaInformacao;
// criado para gerenciar qual painel vai ficar visível
    private static CardLayout paineisLayout;

    /**
     * //// * Creates new form Interface
     */
    public JanelaPrincipal() {
        initComponents();
        meuInitComponents();

    }

    private void meuInitComponents() {
        //ocupar toda a area do nosso frame com a barra de rolagem
        barraRolagem = new JScrollPane();
        //barra de rolagem ocupará todo o espaço do frame
        this.setLayout(new BorderLayout());
        this.add(barraRolagem);
        //configuração dos painel que receberá os paineis apresentados para o usuário
        paineisLayout = new CardLayout();
        trocaInformacao = new JPanel(paineisLayout);
        /*definindo que na area reservada a apresentação de informação ao usuário iremos mostrar as 
         informações do painel troca de informaçao*/
        barraRolagem.setViewportView(trocaInformacao);
        //qual primeiro painel eu desejo mostrar para o usuario
        trocaInformacao.add(new CompraGUI(), "compra");
        paineisLayout.show(trocaInformacao, "compra");

    }

    public static void efetuaTransicao(JPanel novoPainel, String nome) {
        trocaInformacao.add(novoPainel, nome);
        paineisLayout.show(trocaInformacao, nome);
        //correcao do tamanho das barras de rolagem
        trocaInformacao.setPreferredSize(novoPainel.getPreferredSize());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 743, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fakeBancoDados.atualizaArquivo();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
