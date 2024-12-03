/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author jorge
 */
public class MenuOrganizador extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public MenuOrganizador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrearSorteo = new javax.swing.JButton();
        btnVerSorteos = new javax.swing.JButton();
        btnModificarS = new javax.swing.JButton();
        btnEliminarS = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLiberarNumero = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCrearSorteo.setText("Crear Sorteo");
        btnCrearSorteo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearSorteoActionPerformed(evt);
            }
        });

        btnVerSorteos.setText("Ver Sorteos");
        btnVerSorteos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerSorteosActionPerformed(evt);
            }
        });

        btnModificarS.setText("Modificar Sorteo");
        btnModificarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarSActionPerformed(evt);
            }
        });

        btnEliminarS.setText("Eliminar Sorteo");
        btnEliminarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSActionPerformed(evt);
            }
        });

        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Black Ops One", 2, 36)); // NOI18N
        jLabel1.setText("Menu");

        btnLiberarNumero.setText("Liberar Numero");
        btnLiberarNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiberarNumeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnCerrarSesion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnModificarS, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnCrearSorteo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVerSorteos, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEliminarS, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLiberarNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnLiberarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCrearSorteo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVerSorteos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificarS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnCerrarSesion)
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearSorteoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearSorteoActionPerformed
        dispose(); // Cierra el MenuOrganizador
        CrearSorteo ventanaCrearSorteo = new CrearSorteo();
    ventanaCrearSorteo.setVisible(true);
    }//GEN-LAST:event_btnCrearSorteoActionPerformed
// Este método cierra la sesión cuando se presiona el botón "Cerrar Sesión"
    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
          dispose(); // Cierra el MenuOrganizador
    // Aquí podrías redirigir al usuario a la pantalla de inicio de sesión, si existe.
    Inicio login = new Inicio();
    login.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnVerSorteosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerSorteosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerSorteosActionPerformed

    private void btnModificarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarSActionPerformed
       dispose(); // Cierra el MenuOrganizador
    // Aquí podrías redirigir al usuario a la pantalla de inicio de sesión, si existe.
    ModificarSorteo a = new ModificarSorteo();
    a.setVisible(true);
    }//GEN-LAST:event_btnModificarSActionPerformed

    private void btnEliminarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarSActionPerformed

    private void btnLiberarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiberarNumeroActionPerformed
         dispose(); // Cierra el MenuOrganizador
    // Aquí podrías redirigir al usuario a la pantalla de inicio de sesión, si existe.
    LiberarNumerosApartados a = new LiberarNumerosApartados();
    a.setVisible(true);
    }//GEN-LAST:event_btnLiberarNumeroActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCrearSorteo;
    private javax.swing.JButton btnEliminarS;
    private javax.swing.JButton btnLiberarNumero;
    private javax.swing.JButton btnModificarS;
    private javax.swing.JButton btnVerSorteos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
