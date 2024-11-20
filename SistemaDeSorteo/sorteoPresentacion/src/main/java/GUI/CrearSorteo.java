/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAOs.SorteoDAO;
import DTOs.SorteoDTO;
import Entidades.*;
import java.time.ZoneId;



/**
 *
 * @author jorge
 */
public class CrearSorteo extends javax.swing.JFrame {

    /**
     * Creates new form Sorteo
     */
    public CrearSorteo() {
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

        fechaInicioDate = new com.toedter.calendar.JDateChooser();
        fechaFinDate = new com.toedter.calendar.JDateChooser();
        txtNumeroInicial = new javax.swing.JTextField();
        txtNumerofinal = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnConfirmacion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNumerofinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumerofinalActionPerformed(evt);
            }
        });

        btnConfirmacion.setText("Confirmacion");
        btnConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmacionActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero Inicial:");

        jLabel2.setText("Numero Final:");

        jLabel3.setText("Precio:");

        jLabel4.setText("Fecha Inicio:");

        jLabel5.setText("Fecha Fin:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmacion)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fechaFinDate, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(fechaInicioDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumerofinal)
                    .addComponent(txtNumeroInicial)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumerofinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(fechaInicioDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(fechaFinDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnConfirmacion)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumerofinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumerofinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumerofinalActionPerformed

    private void btnConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmacionActionPerformed
     try {
        // Crear un DTO desde la interfaz gráfica
        SorteoDTO sorteoDTO = new SorteoDTO();
        sorteoDTO.setRangoNumeros(txtNumeroInicial.getText() + "-" + txtNumerofinal.getText());
        sorteoDTO.setPrecioNumero(Float.parseFloat(txtPrecio.getText()));
        
        // Asignar la fecha de inicio
        sorteoDTO.setFechaSorteo(fechaInicioDate.getDate()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime());

        // Asignar la fecha de fin
        sorteoDTO.setFechaFin(fechaFinDate.getDate()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime());

        // Registrar el sorteo
        SorteoDAO sorteo = new SorteoDAO();
        sorteo.registrarSorteo(sorteoDTO);

        // Mensaje de éxito
        javax.swing.JOptionPane.showMessageDialog(this, "Sorteo registrado correctamente.");
    } catch (IllegalArgumentException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error de validación", javax.swing.JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al registrar el sorteo: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnConfirmacionActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmacion;
    private com.toedter.calendar.JDateChooser fechaFinDate;
    private com.toedter.calendar.JDateChooser fechaInicioDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtNumeroInicial;
    private javax.swing.JTextField txtNumerofinal;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
