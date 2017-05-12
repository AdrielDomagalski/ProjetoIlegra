package apresentacao;

/**
 * Created by Adriel on 10/05/2017.
 */
import database.ConectaBanco;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import negocio.Medico;
import persistencia.MedicoDAO;
import persistencia.ModeloTabela;

public class PesquisaMedico extends javax.swing.JFrame {
    ConectaBanco con = new ConectaBanco();
    Medico med = new Medico();
    MedicoDAO dao = new MedicoDAO();

    public PesquisaMedico() {
        initComponents();
        PreencheTabela("select * from medico order by id");

    }


    public void PreencheTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String [] {"id", "nome","crm", "especialidade"};
        con.Conexão();
        con.ExecutaSql(sql);

        try{
            con.rs.first();
            do{
                dados.add(new Object[]{
                        con.rs.getInt("id"), con.rs.getString("nome"), con.rs.getString("crm"), con.rs.getString("Especialidade"), con.rs.getString("cpf"),  con.rs.getString("telefone"), con.rs.getString("email"),  con.rs.getString("dataNascimento"),  con.rs.getString("sexo"), con.rs.getString("endereco"),});
            }while(con.rs.next());
        }catch(Exception exc){
            System.out.print(exc);
            JOptionPane.showMessageDialog(this, "Erro ao preencher o Array Medico!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        ModeloTabela tab = new ModeloTabela(dados, colunas);
        tabMedico.setModel(tab);
        tabMedico.getColumnModel().getColumn(0).setPreferredWidth(35);
        tabMedico.getColumnModel().getColumn(0).setResizable(false);
        tabMedico.getColumnModel().getColumn(1).setPreferredWidth(180);
        tabMedico.getColumnModel().getColumn(1).setResizable(false);
        tabMedico.getColumnModel().getColumn(2).setPreferredWidth(130);
        tabMedico.getColumnModel().getColumn(2).setResizable(false);
        tabMedico.getColumnModel().getColumn(3).setPreferredWidth(130);
        tabMedico.getColumnModel().getColumn(3).setResizable(false);
        tabMedico.getTableHeader().setReorderingAllowed(false);
        tabMedico.setAutoResizeMode(tabMedico.AUTO_RESIZE_OFF);
        tabMedico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabMedico = new javax.swing.JTable();
        jbNovo = new javax.swing.JToggleButton();
        jbEditar = new javax.swing.JToggleButton();
        jbDeletar = new javax.swing.JToggleButton();
        jbPesquisaMedico = new javax.swing.JToggleButton();
        tfPesquisa = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        tfCrm = new javax.swing.JTextField();
        tfEspecialidade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabMedico.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {},
                        {},
                        {},
                        {}
                },
                new String [] {

                }
        ));
        jScrollPane1.setViewportView(tabMedico);

        jbNovo.setText("Novo Médico");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbEditar.setText("Editar Médico");

        jbDeletar.setText("Excluir Médico");

        jbPesquisaMedico.setText("Pesquisar");
        jbPesquisaMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisaMedicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jbNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jbDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(66, 66, 66)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(tfCrm, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                                                .addComponent(tfNome))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(47, 47, 47)
                                                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jbPesquisaMedico))
                                                .addComponent(tfEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbPesquisaMedico)
                                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfCrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jbNovo)
                                                .addGap(18, 18, 18)
                                                .addComponent(jbEditar)
                                                .addGap(18, 18, 18)
                                                .addComponent(jbDeletar)))
                                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(773, 507));
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {
        FormInclusaoMedico janelaInclusao = new FormInclusaoMedico(this, true);
        janelaInclusao.setVisible(true);

    }

    private void jbPesquisaMedicoActionPerformed(java.awt.event.ActionEvent evt) {
        PreencheTabela("SELECT * FROM medico WHERE nome LIKE'%" + tfPesquisa.getText()+"%'" );
    }

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
            java.util.logging.Logger.getLogger(PesquisaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jbDeletar;
    private javax.swing.JToggleButton jbEditar;
    private javax.swing.JToggleButton jbNovo;
    private javax.swing.JToggleButton jbPesquisaMedico;
    private javax.swing.JTable tabMedico;
    private javax.swing.JTextField tfCrm;
    private javax.swing.JTextField tfEspecialidade;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration
}
