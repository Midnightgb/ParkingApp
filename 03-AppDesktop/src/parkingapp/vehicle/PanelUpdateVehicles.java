package parkingapp.vehicle;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import parkingapp.Config;
import parkingapp.MainFrame;
import parkingapp.user.User;
import parkingapp.util.Herramientas;

public class PanelUpdateVehicles extends javax.swing.JPanel {
    User dataUser;
    MainFrame frame;
    String plate;
    private Config dataConfig;
    public PanelUpdateVehicles(User dataUser,MainFrame frame, String plate) {
        this.dataUser = dataUser;
        this.plate =  plate;
        this.frame = frame;
        this.dataConfig = new Config();
        initComponents();
        alterInitCoponenst();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jBDeleteVehi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        selectUpType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        panelAlert1 = new javax.swing.JPanel();
        messageAlert1 = new javax.swing.JLabel();
        imgAlert1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(43, 43, 43));

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));

        jPanel3.setBackground(new java.awt.Color(43, 43, 43));

        jBDeleteVehi.setBackground(new java.awt.Color(33, 150, 243));
        jBDeleteVehi.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jBDeleteVehi.setForeground(new java.awt.Color(0, 0, 0));
        jBDeleteVehi.setText("VOLVER");
        jBDeleteVehi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBDeleteVehi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteVehiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBDeleteVehi, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBDeleteVehi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
        );

        jPanel2.setBackground(new java.awt.Color(43, 43, 43));

        selectUpType.setBackground(new java.awt.Color(43, 43, 43));
        selectUpType.setForeground(new java.awt.Color(255, 255, 255));
        selectUpType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectUpType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectUpType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectUpTypeActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(43, 43, 43));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Placa:");

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(43, 43, 43));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(43, 43, 43));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingresar el nombre del vendedor:");

        jTextField5.setBackground(new java.awt.Color(43, 43, 43));
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(43, 43, 43));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Selecciona el tipo del vehículo:");

        jButton2.setBackground(new java.awt.Color(33, 150, 243));
        jButton2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("EDITAR");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(43, 43, 43));
        jLabel4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("EDITAR VEHÍCULO");

        panelAlert1.setBackground(java.awt.SystemColor.activeCaption);
        panelAlert1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEtchedBorder()));

        messageAlert1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        messageAlert1.setForeground(new java.awt.Color(0, 0, 0));
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
                .addComponent(messageAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAlert1Layout.setVerticalGroup(
            panelAlert1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgAlert1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
            .addComponent(messageAlert1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField4)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(224, 224, 224)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(selectUpType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(287, 287, 287))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(panelAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(panelAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(selectUpType, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        Map<String, String> insertData = new HashMap<>();
        String plate =  jTextField4.getText();
        String owner =  jTextField5.getText();
        String category =  selectUpType.getSelectedItem().toString();
        insertData.put("plate", plate);
        insertData.put("owner", owner); 
        insertData.put("category", category); 
       String endpoint = "/vehicle/updateVehicle.php";
        endpoint = dataConfig.getEndPoint(endpoint);
        String respuesta = Herramientas.consumoPOST(endpoint, insertData);
        System.out.println(respuesta);
        
        if(respuesta!=null){
            JsonObject jsonObject = JsonParser.parseString(respuesta).getAsJsonObject();
            boolean status = jsonObject.get("status").getAsBoolean();
            System.out.println(status);


            if(status){
                alerta("Se Edito correctamente", "/parkingapp/resources/gifs/midPriority.gif");
                jTextField4.setText("");
                jTextField5.setText("");

            }else{
                 alerta("No se pudo Editar el vehiculo", "/parkingapp/resources/gifs/midPriority.gif");
            }

        }else{
            alerta("No se pudo Editar el vehiculo", "/parkingapp/resources/gifs/midPriority.gif");

        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public void alerta(String text, String url){
       messageAlert1.setFont(new java.awt.Font("Segoe UI", 1, 15));
       panelAlert1.setBackground(java.awt.SystemColor.activeCaption);
       messageAlert1.setText(text);
       imgAlert1.setIcon(new javax.swing.ImageIcon(getClass().getResource(url)));
       panelAlert1.setVisible(true);
    }
    
    
    private void jBDeleteVehiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteVehiActionPerformed
         this.frame.contentVehicle();
    }//GEN-LAST:event_jBDeleteVehiActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void selectUpTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectUpTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectUpTypeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgAlert1;
    private javax.swing.JButton jBDeleteVehi;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel messageAlert1;
    private javax.swing.JPanel panelAlert1;
    private javax.swing.JComboBox<String> selectUpType;
    // End of variables declaration//GEN-END:variables

    private void alterInitCoponenst() {
         panelAlert1.setVisible(false);
        selectUpType.removeAllItems();
        selectUpType.addItem("moto");
        selectUpType.addItem("camioneta");
        selectUpType.addItem("camion");
        selectUpType.addItem("carro");
        
        Map<String, String> viewData = new HashMap<>();
        viewData.put("plate", plate);
        String endpoint = "/vehicle/getVehicle.php";
        endpoint = dataConfig.getEndPoint(endpoint);
        String result = Herramientas.consumoGET(endpoint, viewData);
        JsonObject jsonObject = JsonParser.parseString(result).getAsJsonObject();
        JsonArray ticketArray = jsonObject.getAsJsonArray("datos");
        
        for (JsonElement element : ticketArray){
            JsonObject userObject = element.getAsJsonObject();
            String plate = userObject.get("plate").getAsString();
            String name_owner = userObject.get("name_owner").getAsString();
            String category = userObject.get("category").getAsString();

           jTextField4.setText(plate);
           jTextField5.setText(name_owner);

        } 
        this.revalidate();
        this.repaint();
        
    }
}
