package parkingapp.ticket;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import parkingapp.MainFrame;
import parkingapp.user.User;
import parkingapp.util.Herramientas;


public class PanelTicketUpdate extends javax.swing.JPanel {
    User dataUser;
    String idTicket;
    MainFrame frame;
    public PanelTicketUpdate(User dataUser, MainFrame frame, String idTicket) {
        this.frame = frame;
        
        this.idTicket = idTicket;
        this.dataUser = dataUser;
        initComponents();
        alternInitComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        label_7 = new javax.swing.JLabel();
        label_9 = new javax.swing.JLabel();
        label_10 = new javax.swing.JLabel();
        label_11 = new javax.swing.JLabel();
        label_12 = new javax.swing.JLabel();
        label_13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        total_label = new javax.swing.JTextField();
        id_label = new javax.swing.JTextField();
        entry_date_label = new javax.swing.JTextField();
        exit_date_label = new javax.swing.JTextField();
        status_label = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        panelAlert1 = new javax.swing.JPanel();
        messageAlert1 = new javax.swing.JLabel();
        imgAlert1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));

        jPanel2.setBackground(new java.awt.Color(43, 43, 43));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jButton4.setBackground(new java.awt.Color(33, 150, 243));
        jButton4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("VOLVER");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        panelPrincipal.setBackground(new java.awt.Color(43, 43, 43));
        panelPrincipal.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("VER TICKET");

        label_7.setForeground(new java.awt.Color(255, 255, 255));
        label_7.setText("plate:");

        label_9.setForeground(new java.awt.Color(255, 255, 255));
        label_9.setText("ID:");

        label_10.setForeground(new java.awt.Color(255, 255, 255));
        label_10.setText("parking_id:");

        label_11.setForeground(new java.awt.Color(255, 255, 255));
        label_11.setText("entry_date:");

        label_12.setForeground(new java.awt.Color(255, 255, 255));
        label_12.setText("exit_date:");

        label_13.setForeground(new java.awt.Color(255, 255, 255));
        label_13.setText("status:");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("total:");

        total_label.setForeground(new java.awt.Color(255, 255, 255));
        total_label.setText("jTextField1");

        id_label.setForeground(new java.awt.Color(255, 255, 255));
        id_label.setText("jTextField1");

        entry_date_label.setForeground(new java.awt.Color(255, 255, 255));
        entry_date_label.setText("jTextField1");

        exit_date_label.setForeground(new java.awt.Color(255, 255, 255));
        exit_date_label.setText("jTextField1");

        status_label.setForeground(new java.awt.Color(255, 255, 255));
        status_label.setText("jTextField1");

        jButton1.setBackground(new java.awt.Color(33, 150, 243));
        jButton1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Actualizar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        panelAlert1.setBackground(java.awt.SystemColor.activeCaption);
        panelAlert1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEtchedBorder()));
        panelAlert1.setForeground(new java.awt.Color(255, 255, 255));

        messageAlert1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        messageAlert1.setForeground(new java.awt.Color(255, 255, 255));
        messageAlert1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        imgAlert1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgAlert1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkingapp/resources/gifs/midPriority.gif"))); // NOI18N
        imgAlert1.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);

        javax.swing.GroupLayout panelAlert1Layout = new javax.swing.GroupLayout(panelAlert1);
        panelAlert1.setLayout(panelAlert1Layout);
        panelAlert1Layout.setHorizontalGroup(
            panelAlert1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlert1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelAlert1Layout.setVerticalGroup(
            panelAlert1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgAlert1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
            .addComponent(messageAlert1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(total_label, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(id_label)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_11, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(label_13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(exit_date_label)
                                        .addComponent(entry_date_label, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(status_label, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(253, 253, 253))))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(panelAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(entry_date_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exit_date_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(status_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(label_11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(label_13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(total_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(panelAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jLabel1))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(label_9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(id_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        frame.mainTickets();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Map<String, String> insertData = new HashMap<>();
        String id =  id_label.getText();
        String selectedOption = jComboBox2.getSelectedItem().toString();
        String selectedOption_2 = jComboBox1.getSelectedItem().toString();
        String exit_date =  exit_date_label.getText();
        String total =  total_label.getText();
        String status =  status_label.getText();
        String[] parts = selectedOption.split(" - ");
        String id_parking_seller = parts[0];
        String valor = parts[1];
        
        insertData.put("id", id);
        insertData.put("parking_id", id_parking_seller);
        insertData.put("plate", selectedOption_2);
        insertData.put("exit_date", exit_date);
        insertData.put("total", total);
        insertData.put("status", status);
        
        String respuesta = Herramientas.consumoPOST("http://localhost/parkingAPI/ticket/updateTicket.php", insertData);
        System.out.println(respuesta);
        if(respuesta != null){
            alerta("Se Actualizo correctamente", "/parkingapp/resources/gifs/midPriority.gif");

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField entry_date_label;
    private javax.swing.JTextField exit_date_label;
    private javax.swing.JTextField id_label;
    private javax.swing.JLabel imgAlert1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_10;
    private javax.swing.JLabel label_11;
    private javax.swing.JLabel label_12;
    private javax.swing.JLabel label_13;
    private javax.swing.JLabel label_7;
    private javax.swing.JLabel label_9;
    private javax.swing.JLabel messageAlert1;
    private javax.swing.JPanel panelAlert1;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField status_label;
    private javax.swing.JTextField total_label;
    // End of variables declaration//GEN-END:variables

    private void alternInitComponents() {
        total_label.setEditable(false);
        status_label.setEditable(false);
        entry_date_label.setEditable(false);
        exit_date_label.setEditable(false); 
        id_label.setEditable(false); 
        panelAlert1.setVisible(false);



        cargarComBox();
        this.setBackground(java.awt.Color.WHITE);
        Map<String, String> viewData = new HashMap<>();
        viewData.put("id", idTicket);
        String result = Herramientas.consumoGET("http://localhost/parkingAPI/ticket/getTicket.php", viewData);
        System.out.println(result);
        
         
        JsonObject jsonObject = JsonParser.parseString(result).getAsJsonObject();
        JsonArray ticketArray = jsonObject.getAsJsonArray("datos");
        
        for (JsonElement element : ticketArray){
            JsonObject userObject = element.getAsJsonObject();
            String id = userObject.get("id").getAsString();
            String parking_id = userObject.get("parking_id").getAsString();
            String plate = userObject.get("plate").getAsString();
            String entry_date = userObject.get("entry_date").getAsString();
            String status = userObject.get("status").getAsString();

            label_7.setForeground(Color.white);
            label_9.setForeground(Color.white);
            label_10.setForeground(Color.white);
            label_11.setForeground(Color.white);
            label_12.setForeground(Color.white);
            label_13.setForeground(Color.white);
            jLabel10.setForeground(Color.white);
            jLabel1.setForeground(Color.white);
            id_label.setText(id);
            entry_date_label.setText(entry_date);

            status_label.setText(status);
            String exit_date = "";
            try {
                exit_date = userObject.get("exit_date").getAsString();
                exit_date_label.setText(exit_date );
            } catch (Exception e) {
                exit_date_label.setText("sin llenar" );
            }
            String total = "";
            try {
                total = userObject.get("total").getAsString();
                total_label.setText(total);
            } catch (Exception e) {
                total_label.setText("sin llenar");
            }
  
            this.revalidate();
           this.repaint();
           
            
        }
    }
    
    public void alerta(String text, String url){
       messageAlert1.setFont(new java.awt.Font("Segoe UI", 1, 15));
       panelAlert1.setBackground(java.awt.SystemColor.activeCaption);
       messageAlert1.setText(text);
       imgAlert1.setIcon(new javax.swing.ImageIcon(getClass().getResource(url)));
       panelAlert1.setVisible(true);
    }
    
    public void cargarComBox(){
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        String result = Herramientas.consumoGET("http://localhost/parkingAPI/vehicle/getVehicles.php");
        System.out.println(result);
        
         
        JsonObject jsonObject = JsonParser.parseString(result).getAsJsonObject();
        JsonArray ticketArray = jsonObject.getAsJsonArray("vehicles");
        
        for (JsonElement element : ticketArray){
            JsonObject userObject = element.getAsJsonObject();
            String parking_id = userObject.get("plate").getAsString();
            String entry_date = userObject.get("name_owner").getAsString();
            String status = userObject.get("category").getAsString();
            
            jComboBox1.addItem(parking_id);
        }
        
        String data = Herramientas.consumoGET("http://localhost/parkingAPI/ticket/getUserParking.php");
        System.out.println(data);
        
         
        JsonObject jsonObject_getUserParking = JsonParser.parseString(data).getAsJsonObject();
        JsonArray ticketArray_getUserParking = jsonObject_getUserParking.getAsJsonArray("userParking");
        
        for (JsonElement element : ticketArray_getUserParking){
            JsonObject userObject = element.getAsJsonObject();
            String id_parking_seller = userObject.get("id_parking_seller").getAsString();
            String name_user = userObject.get("name").getAsString();
            String name = userObject.get("name").getAsString();
            
            System.out.println(id_parking_seller);
            System.out.println(name_user);
            System.out.println(name);
            
            jComboBox2.addItem(id_parking_seller+" - "+name_user+" "+name);
        }
    }
    
}
