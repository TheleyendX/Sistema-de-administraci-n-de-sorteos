/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAOs.BoletoDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class LiberarNumerosApartados extends javax.swing.JFrame {

    /**
     * Creates new form LiberarNumerosApartados
     */
    public LiberarNumerosApartados() {
        initComponents();
          cargarNumerosApartados(); // Carga los datos al abrir la ventana
    }

    
       // Método para cargar los datos en la tabla
    private void cargarNumerosApartados() {
        try {
            List<Object[]> numerosApartados = new BoletoDAO().obtenerNumerosApartados();

            String[] columnas = {"ID Boleto", "ID Cliente", "Nombre Cliente"};
            Object[][] data = new Object[numerosApartados.size()][3];

            for (int i = 0; i < numerosApartados.size(); i++) {
                data[i][0] = numerosApartados.get(i)[0]; // ID del boleto
                data[i][1] = numerosApartados.get(i)[1]; // ID del cliente
                data[i][2] = numerosApartados.get(i)[2]; // Nombre del cliente
            }

            NumerosApartados.setModel(new javax.swing.table.DefaultTableModel(data, columnas) {
                Class[] types = new Class[]{Integer.class, Integer.class, String.class};
                boolean[] canEdit = new boolean[]{false, false, false};

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los números apartados: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        NumerosApartados = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        btnLiberar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NumerosApartados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID boleto", "ID cliente", "Nombre Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(NumerosApartados);
        if (NumerosApartados.getColumnModel().getColumnCount() > 0) {
            NumerosApartados.getColumnModel().getColumn(0).setResizable(false);
        }

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnLiberar.setText("Liberar Numero");
        btnLiberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiberarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 80, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnLiberar)
                                .addGap(36, 36, 36))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLiberar)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
    MenuOrganizador a = new MenuOrganizador();
    a.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnLiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiberarActionPerformed
        int selectedRow = NumerosApartados.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un número para liberar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int idBoleto = (int) NumerosApartados.getValueAt(selectedRow, 0);

    try {
        // Liberar el boleto seleccionado
        new BoletoDAO().liberarBoleto(idBoleto);
        JOptionPane.showMessageDialog(this, "Número liberado correctamente.");
        cargarNumerosApartados(); // Refrescar la tabla
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al liberar el número: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnLiberarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable NumerosApartados;
    private javax.swing.JButton btnLiberar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
