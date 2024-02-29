package parkingapp.vehicle;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import parkingapp.Config;
import parkingapp.MainFrame;
import parkingapp.ticket.PanelTicketView;
import parkingapp.ticket.PanelTickets;
import parkingapp.user.User;
import parkingapp.util.Herramientas;

public class PanelVehicles extends javax.swing.JPanel {
    DefaultTableModel modelo;
    MainFrame frame;
    User dataUser;
    private Config dataConfig;
    
    public PanelVehicles(User dataUser, MainFrame frame) {
        this.dataUser = dataUser;
        this.frame = frame; 
        this.dataConfig = new Config();
        initComponents();
        alterInitComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jBCreateVehi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableVehi = new javax.swing.JTable();

        setBackground(new java.awt.Color(43, 43, 43));

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));

        jPanel3.setBackground(new java.awt.Color(43, 43, 43));

        jBCreateVehi.setBackground(new java.awt.Color(33, 150, 243));
        jBCreateVehi.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jBCreateVehi.setForeground(new java.awt.Color(0, 0, 0));
        jBCreateVehi.setText("CREAR VEHÍCULO");
        jBCreateVehi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBCreateVehi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCreateVehiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBCreateVehi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jBCreateVehi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(43, 43, 43));

        TableVehi.setBackground(new java.awt.Color(102, 102, 102));
        TableVehi.setForeground(new java.awt.Color(0, 0, 0));
        TableVehi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Nombre vendedor", "Categoría", "ACTUALIZAR"
            }
        ));
        jScrollPane1.setViewportView(TableVehi);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBCreateVehiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCreateVehiActionPerformed
        PanelInsertVehicles temporal = new PanelInsertVehicles(dataUser, frame);
        frame.replacePanel(temporal);
    }//GEN-LAST:event_jBCreateVehiActionPerformed
    
    
        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableVehi;
    private javax.swing.JButton jBCreateVehi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void alterInitComponents() {
       
        DefaultTableModel modelo = (DefaultTableModel) TableVehi.getModel();
        Object[] columnNames = {"Placa", "Nombre vendedor", "Categoría", "Actualizar"};
        modelo = new DefaultTableModel(columnNames, 0) {
            public boolean isCellEditable(int row, int column) {
                // Hacer que las celdas de la columna "ACTUALIZAR" sean editables y las demás no
                return column == columnNames.length - 1; // La última columna (ACTUALIZAR) es la única editable
            }
        };
        TableVehi.setModel(modelo);

        // Configura las columnas para que no sean redimensionables
        TableColumnModel columnModel = TableVehi.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setResizable(false); // No se puede cambiar el tamaño
        }

        TableVehi.getTableHeader().setReorderingAllowed(false);
        TableVehi.getTableHeader().setBackground(Color.decode("#2196F3"));
        TableVehi.getTableHeader().setForeground(Color.BLACK);
        this.TableVehi.getColumn("Actualizar").setCellRenderer(new parkingapp.util.ButtonRenderer());
        this.TableVehi.getColumn("Actualizar").setCellEditor(new parkingapp.util.ButtonEditor(new JCheckBox()));
        String endpoint = "/vehicle/getVehicles.php";
        endpoint = dataConfig.getEndPoint(endpoint);
        String result = Herramientas.consumoGET(endpoint);

        System.out.println(result);

        JsonObject jsonObject = JsonParser.parseString(result).getAsJsonObject();
        JsonArray ticketArray = jsonObject.getAsJsonArray("vehicles");

        for (JsonElement element : ticketArray){
            JsonObject userObject = element.getAsJsonObject();
            String plate = userObject.get("plate").getAsString();
            String name_owner = userObject.get("name_owner").getAsString();
            String category = userObject.get("category").getAsString();
            JButton btnAccionUpdate = new JButton("Actualizar");

            btnAccionUpdate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = TableVehi.getSelectedRow(); // Obtén la fila seleccionada en la vista
                    System.out.println(selectedRow);
                    if (selectedRow >= 0) {
                        String idString = (String) TableVehi.getModel().getValueAt(selectedRow, 0).toString(); // Obtén el valor como String y conviértelo a String si es necesario
                        try {
                             PanelUpdateVehicles temporaryPanel = new PanelUpdateVehicles(dataUser,frame,idString);
                            frame.replacePanel(temporaryPanel);
                        } catch (NumberFormatException ex) {
                            System.out.println("Error al convertir ID a entero: " + ex.getMessage());
                        }
                    }
                }
            });

            Object[] nuevaFila = {plate,name_owner,category, btnAccionUpdate};
            modelo.addRow(nuevaFila);
        }

        revalidate();
        repaint();

    }
}
