/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAOs.SorteoDAO;
import DTOs.SorteoDTO;
import Entidades.*;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import services.SorteoService;

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
        btnVolver = new javax.swing.JButton();

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

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumerofinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumerofinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumerofinalActionPerformed

    private void btnConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmacionActionPerformed
        try {
            // Validar que los campos no estén vacíos
            if (txtNumeroInicial.getText().isEmpty() || txtNumerofinal.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
                throw new IllegalArgumentException("Todos los campos deben estar llenos.");
            }
            if (fechaInicioDate.getDate() == null) {
                throw new IllegalArgumentException("La fecha de inicio no puede ser nula.");
            }
            if (fechaFinDate.getDate() == null) {
                throw new IllegalArgumentException("La fecha de fin no puede ser nula.");
            }

            // Validar que los números inicial y final sean válidos
            int numeroInicial;
            int numeroFinal;
            try {
                numeroInicial = Integer.parseInt(txtNumeroInicial.getText());
                numeroFinal = Integer.parseInt(txtNumerofinal.getText());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Los números inicial y final deben ser enteros.");
            }

            if (numeroInicial >= numeroFinal) {
                throw new IllegalArgumentException("El número inicial debe ser menor que el número final.");
            }

            // Validar que el precio sea un número positivo
            float precio;
            try {
                precio = Float.parseFloat(txtPrecio.getText());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("El precio debe ser un número.");
            }

            if (precio <= 0) {
                throw new IllegalArgumentException("El precio debe ser mayor a 0.");
            }

            // Validar que las fechas sean coherentes
            if (fechaInicioDate.getDate().after(fechaFinDate.getDate())) {
                throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha de fin.");
            }

            if (fechaInicioDate.getDate().before(new java.util.Date())) {
                throw new IllegalArgumentException("La fecha de inicio no puede ser anterior a la fecha actual.");
            }

            // Crear un DTO desde la interfaz gráfica
            SorteoDTO sorteoDTO = new SorteoDTO();
            sorteoDTO.setNumeroInicial(numeroInicial);
            sorteoDTO.setNumeroFinal(numeroFinal);
            sorteoDTO.setPrecioNumero(precio);
            sorteoDTO.setFechaInicio(fechaInicioDate.getDate());
            sorteoDTO.setFechaFin(fechaFinDate.getDate());
            sorteoDTO.setEstadoSorteo(EstadoSorteo.ACTIVO);

            // Validar el DTO
            sorteoDTO.validar();

            // Registrar el sorteo
            SorteoService sorteoService = new SorteoService(new SorteoDAO());
            sorteoService.registrarSorteo(sorteoDTO);

            // Mensaje de éxito
            JOptionPane.showMessageDialog(this, "Sorteo registrado correctamente.");

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el sorteo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmacionActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose(); // Cierra la pantalla
    // Aquí podrías redirigir al usuario a la nueva pantalla.
    MenuOrganizador a = new MenuOrganizador();
    a.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmacion;
    private javax.swing.JButton btnVolver;
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
