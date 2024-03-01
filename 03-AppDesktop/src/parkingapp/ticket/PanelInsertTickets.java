package parkingapp.ticket;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import parkingapp.Config;
import parkingapp.MainFrame;
import parkingapp.user.User;
import parkingapp.util.Herramientas;


public class PanelInsertTickets extends javax.swing.JPanel {
    User dataUser;
    MainFrame frame;
    private Config dataConfig;
     
    public PanelInsertTickets(User dataUser, MainFrame frame) {
        this.dataUser = dataUser;
        this.frame = frame;
        this.dataConfig = new Config();
        initComponents();
        alternInitComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        buttonInsert = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        panelAlert1 = new javax.swing.JPanel();
        messageAlert1 = new javax.swing.JLabel();
        imgAlert1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));

        jPanel2.setBackground(new java.awt.Color(43, 43, 43));

        buttonInsert.setBackground(new java.awt.Color(33, 150, 243));
        buttonInsert.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        buttonInsert.setForeground(new java.awt.Color(0, 0, 0));
        buttonInsert.setText("VOLVER");
        buttonInsert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertActionPerformed(evt);
            }
        });

        panelPrincipal.setBackground(new java.awt.Color(43, 43, 43));
        panelPrincipal.setForeground(new java.awt.Color(255, 255, 255));

        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Placa Vehiculo:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Parqueadero y vendedor:");

        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setBackground(new java.awt.Color(33, 150, 243));
        jButton1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("CREAR TIKET");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Insert Ticket");

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
                .addGap(32, 32, 32)
                .addComponent(messageAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(415, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addGap(46, 46, 46)
                .addComponent(panelAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
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

    private void buttonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertActionPerformed
        frame.mainTickets();
    }//GEN-LAST:event_buttonInsertActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Map<String, String> insertData = new HashMap<>();
        String selectedOption = jComboBox2.getSelectedItem().toString();
        String selectedOption_2 = jComboBox1.getSelectedItem().toString();
        String[] parts = selectedOption.split(" - ");
        String id = parts[0];
        String valor = parts[1];
        insertData.put("parking_id", id);
        insertData.put("plate", selectedOption_2);
        String endpoint = "/ticket/insertTicket.php";
        endpoint = dataConfig.getEndPoint(endpoint);
        String respuesta = Herramientas.consumoPOST(endpoint, insertData);
        System.out.println(respuesta);
        if(respuesta!=null){
            JsonObject jsonObject = JsonParser.parseString(respuesta).getAsJsonObject();
            boolean status = jsonObject.get("status").getAsBoolean();
            System.out.println(status);


            if(status){
                alerta("Se inserto correctamente", "/parkingapp/resources/gifs/midPriority.gif");


            }else{
                 alerta("No se pudo registrar el vehiculo", "/parkingapp/resources/gifs/midPriority.gif");
            }

        }else{
            alerta("No se pudo registrar el vehiculo", "/parkingapp/resources/gifs/midPriority.gif");

        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void cargarComBox(){
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        String endpoint = "/vehicle/getVehicles.php";
        endpoint = dataConfig.getEndPoint(endpoint);
        System.out.println(endpoint);
        
         
        String jsonResponse = Herramientas.consumoGET(endpoint); // Obtener la respuesta JSON de la URL
        System.out.println(jsonResponse); // Verifica que la respuesta sea la que esperas

        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject(); // Parsear la respuesta JSON
        JsonArray ticketArray = jsonObject.getAsJsonArray("vehicles");
    
        
        for (JsonElement element : ticketArray){
            JsonObject userObject = element.getAsJsonObject();
            String parking_id = userObject.get("plate").getAsString();
            System.out.println("°°°°°°°°");
            String entry_date = userObject.get("name_owner").getAsString();
            String status = userObject.get("category").getAsString();
            
            jComboBox1.addItem(parking_id);
        }
        String endpointGet = "/ticket/getUserParking.php";
        endpointGet = dataConfig.getEndPoint(endpointGet);
        String data = Herramientas.consumoGET(endpointGet);
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
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonInsert;
    private javax.swing.JLabel imgAlert1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel messageAlert1;
    private javax.swing.JPanel panelAlert1;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
    
    public void alerta(String text, String url){
       messageAlert1.setFont(new java.awt.Font("Segoe UI", 1, 15));
       panelAlert1.setBackground(java.awt.SystemColor.activeCaption);
       messageAlert1.setText(text);
       imgAlert1.setIcon(new javax.swing.ImageIcon(getClass().getResource(url)));
       panelAlert1.setVisible(true);
    }
    
    private void alternInitComponents() {
        panelAlert1.setVisible(false);
        jLabel1.setForeground(Color.white);
        jLabel2.setForeground(Color.white);
        jLabel3.setForeground(Color.white);
        jPanel1.setForeground(Color.white);
        jPanel2.setForeground(Color.white);
        cargarComBox();
    }
}
