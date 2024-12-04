/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAOs.BoletoDAO;
import DAOs.SorteoDAO;
import Entidades.Boleto;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class ApartarNumeros extends javax.swing.JFrame {

    /**
     * Creates new form ApartarNumeros
     */
    public ApartarNumeros() {
        initComponents();
        cargarNumerosDisponibles();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // Método para cargar los números disponibles en la tabla
    private void cargarNumerosDisponibles() {
         try {
            BoletoDAO boletoDAO = new BoletoDAO();
            List<Object[]> boletosDisponibles = boletoDAO.obtenerBoletosDisponibles();

            String[] columnas = {"Numero Boleto", "Precio"};
            Object[][] data = new Object[boletosDisponibles.size()][2];

            for (int i = 0; i < boletosDisponibles.size(); i++) {
                Object[] boleto = boletosDisponibles.get(i);
                data[i][0] = boleto[0]; // Numero del boleto
                data[i][1] = boleto[1]; // Precio del sorteo
            }

            jTable1.setModel(new javax.swing.table.DefaultTableModel(data, columnas) {
                boolean[] canEdit = new boolean[]{false, false};

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los números disponibles: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        btnApartar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Numero", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnApartar.setText("Apartar");
        btnApartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApartarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Black Ops One", 2, 36)); // NOI18N
        jLabel1.setText("Apartar Numeros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnVolver)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnApartar)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnApartar)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVolver)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
          MenuCliente a = new MenuCliente();
    a.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnApartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApartarActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un número para apartar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String numeroBoleto = (String) jTable1.getValueAt(selectedRow, 0);

        try {
            BoletoDAO boletoDAO = new BoletoDAO();
            boletoDAO.apartarBoleto(numeroBoleto);
            JOptionPane.showMessageDialog(this, "Número apartado correctamente.");
            cargarNumerosDisponibles();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al apartar el número: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnApartarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApartar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
