package parkingapp.ticket;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import parkingapp.MainFrame;
import parkingapp.user.User;

import parkingapp.util.*;


public class PanelTickets extends javax.swing.JPanel {
    JTabbedPane tabbed;
    User dataUser;
    DefaultTableModel modelo;
    MainFrame frame;
    public PanelTickets(User dataUser, MainFrame frame) {
        this.dataUser = dataUser;
        this.tabbed = tabbed;
        this.frame = frame;
        initComponents();
        alternInitComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        buttonInsert = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        panelTabla = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));

        jPanel2.setBackground(new java.awt.Color(43, 43, 43));

        buttonInsert.setBackground(new java.awt.Color(33, 150, 243));
        buttonInsert.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        buttonInsert.setForeground(new java.awt.Color(0, 0, 0));
        buttonInsert.setText("AÑADIR");
        buttonInsert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(33, 150, 243));
        jButton1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("TODOS");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(33, 150, 243));
        jButton2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("ACTIVOS");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(33, 150, 243));
        jButton3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("INACTIVOS");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonInsert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonInsert)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPrincipal.setBackground(new java.awt.Color(43, 43, 43));
        panelPrincipal.setForeground(new java.awt.Color(43, 43, 43));

        panelTabla.setBackground(new java.awt.Color(43, 43, 43));
        panelTabla.setForeground(new java.awt.Color(43, 43, 43));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PARQUEADERO", "PLACA", "ESTADO", "VER", "ACTUALIZAR", "CAMBIAR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panelTabla.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTabla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertActionPerformed
       PanelInsertTickets temporaryPanel = new PanelInsertTickets(dataUser, frame);
        this.frame.replacePanel(temporaryPanel);
    }//GEN-LAST:event_buttonInsertActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modelo.setRowCount(0);
        chargeByRole("todos");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        modelo.setRowCount(0);
        chargeByRole("activos");   
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        modelo.setRowCount(0);
        chargeByRole("inactivos"); 
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonInsert;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane panelTabla;
    // End of variables declaration//GEN-END:variables

    private void alternInitComponents() {
        modelo = (DefaultTableModel) jTable1.getModel();
    
        // Configura las columnas "VER", "ACTUALIZAR" y "CAMBIAR" para que tengan botones
      

        Object[] columnNames = {"ID","PARQUEADERO","PLACA","ESTADO", "VER","ACTUALIZAR","CAMBIAR"};

        modelo = new DefaultTableModel(columnNames, 0) {
            public boolean isCellEditable(int row, int column) {
                if (column == jTable1.getColumn("VER").getModelIndex() || 
                    column == jTable1.getColumn("ACTUALIZAR").getModelIndex() ||
                    column == jTable1.getColumn("CAMBIAR").getModelIndex()) {
                    // Hacer que las celdas de las columnas con botones sean editables
                    return true;
                } else {
                    // Hacer que las demás celdas no sean editables
                    return false;
                }
            }
        };
        jTable1.setModel(modelo);

        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setResizingAllowed(false);
          jTable1.getColumn("VER").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("VER").setCellEditor(new ButtonEditor(new JCheckBox()));

        jTable1.getColumn("ACTUALIZAR").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("ACTUALIZAR").setCellEditor(new ButtonEditor(new JCheckBox()));

        jTable1.getColumn("CAMBIAR").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("CAMBIAR").setCellEditor(new ButtonEditor(new JCheckBox()));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setBackground(Color.decode("#2196F3"));
        jTable1.getTableHeader().setForeground(Color.BLACK);
        chargeByRole("todos");  
    }
    
    
    public void chargeByRole(String tipo){
         if("admin".equals(dataUser.getRol())){
            fillTable("http://localhost/parkingAPI/ticket/getTickets.php", -100, tipo);
        }else{
            fillTable("http://localhost/parkingAPI/ticket/getTicketRol.php", dataUser.getId(), tipo);
        }
    }
    
    public void fillTable(String url, int id_user, String tipo){
        try {
            String result = null;
        if(id_user != -100){
            Map<String, String> selectData = new HashMap<>();
            selectData.put("id", ""+id_user);
            result = Herramientas.consumoGET(url,selectData);
        }else{
            result = Herramientas.consumoGET(url);
        }

        
        
        System.out.println(result);
        
        JsonObject jsonObject = JsonParser.parseString(result).getAsJsonObject();
        JsonArray ticketArray = jsonObject.getAsJsonArray(id_user != -100 ? "datos" : "tickets");
        
        for (JsonElement element : ticketArray){
            JsonObject userObject = element.getAsJsonObject();
            int id = userObject.get("id").getAsInt();
            String parking_name = userObject.get("parking_name").getAsString();
            String plate = userObject.get("plate").getAsString();
            String status = userObject.get("status").getAsString();
            JButton btnAccion = new JButton("Actualizar");
            JButton btnAccionUpdate = new JButton("VER");
            JButton btnAccionCambiar = new JButton("CAMBIAR");
            
            btnAccion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = jTable1.getSelectedRow(); // Obtén la fila seleccionada en la vista
                    System.out.println(selectedRow);
                    if (selectedRow >= 0) {
                        String idString = (String) jTable1.getModel().getValueAt(selectedRow, 0).toString(); // Obtén el valor como String y conviértelo a String si es necesario
                        try {  
                            PanelTicketUpdate temporaryPanel = new PanelTicketUpdate(dataUser,frame, idString);
                            frame.replacePanel(temporaryPanel);
                        } catch (NumberFormatException ex) {
                            System.out.println("Error al convertir ID a entero: " + ex.getMessage());
                        }
                    }
                }
            });






            btnAccionUpdate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = jTable1.getSelectedRow(); // Obtén la fila seleccionada en la vista
                    System.out.println(selectedRow);
                    if (selectedRow >= 0) {
                        String idString = (String) jTable1.getModel().getValueAt(selectedRow, 0).toString(); // Obtén el valor como String y conviértelo a String si es necesario
                        try {  
                            PanelTicketView temporaryPanel = new PanelTicketView(dataUser,frame, idString);
                            frame.replacePanel(temporaryPanel);
                        } catch (NumberFormatException ex) {
                            System.out.println("Error al convertir ID a entero: " + ex.getMessage());
                        }
                    }
                }
            });
            
            btnAccionCambiar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = jTable1.getSelectedRow(); // Obtén la fila seleccionada en la vista
                    System.out.println(selectedRow);
                    if (selectedRow >= 0) {
                        String idString = (String) jTable1.getModel().getValueAt(selectedRow, 0).toString(); 
                        String estado = (String) jTable1.getModel().getValueAt(selectedRow, 3).toString(); // Obtén el valor como String y conviértelo a String si es necesario

                        try {  
                            Map<String, String> insertData = new HashMap<>();
                            insertData.put("id", idString);
                            insertData.put("status", estado);
                            String respuesta = Herramientas.consumoPOST("http://localhost/parkingAPI/ticket/changeStatus.php", insertData);
                            System.out.println(respuesta);
                        } catch (NumberFormatException ex) {
                            System.out.println("Error al convertir ID a entero: " + ex.getMessage());
                        }
                    }
                    PanelTickets temporal = new PanelTickets(dataUser, frame);
                    frame.replacePanel(temporal);
                }
            });
            if(tipo.equals("todos")){
                Object[] nuevaFila = {id,parking_name,plate, status,btnAccion,btnAccionUpdate,btnAccionCambiar};
                modelo.addRow(nuevaFila);
            }else if(tipo.equals("activos") && status.equals("activo")){
                Object[] nuevaFila = {id,parking_name,plate, status,btnAccion,btnAccionUpdate,btnAccionCambiar};
                modelo.addRow(nuevaFila);
            }else if(tipo.equals("inactivos") && status.equals("inactivo")){
                Object[] nuevaFila = {id,parking_name,plate, status,btnAccion,btnAccionUpdate,btnAccionCambiar};
                modelo.addRow(nuevaFila);
            }
            
        }
        } catch (Exception e) {
            System.out.println("No hay datos para cargar");
        }
        
        revalidate();
        repaint();
    }
}


