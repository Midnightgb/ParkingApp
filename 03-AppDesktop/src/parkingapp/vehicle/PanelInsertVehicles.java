package parkingapp.vehicle;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import parkingapp.Config;
import parkingapp.MainFrame;
import parkingapp.user.User;
import parkingapp.util.Herramientas;

public class PanelInsertVehicles extends javax.swing.JPanel {
    MainFrame frame;
    private Config dataConfig;

    public PanelInsertVehicles(User dataUser, MainFrame frame) {
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
        selectTypeVehi = new javax.swing.JComboBox<>();
        field_seller = new javax.swing.JTextField();
        field_placa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        panelAlert1 = new javax.swing.JPanel();
        messageAlert1 = new javax.swing.JLabel();
        imgAlert1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(43, 43, 43));

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));

        jPanel3.setBackground(new java.awt.Color(43, 43, 43));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

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
                .addComponent(jBDeleteVehi, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jBDeleteVehi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(43, 43, 43));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        selectTypeVehi.setBackground(new java.awt.Color(43, 43, 43));
        selectTypeVehi.setForeground(new java.awt.Color(255, 255, 255));
        selectTypeVehi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectTypeVehi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTypeVehiActionPerformed(evt);
            }
        });

        field_seller.setBackground(new java.awt.Color(43, 43, 43));
        field_seller.setForeground(new java.awt.Color(255, 255, 255));
        field_seller.setCaretColor(new java.awt.Color(255, 255, 255));
        field_seller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_sellerActionPerformed(evt);
            }
        });

        field_placa.setBackground(new java.awt.Color(43, 43, 43));
        field_placa.setForeground(new java.awt.Color(255, 255, 255));
        field_placa.setCaretColor(new java.awt.Color(255, 255, 255));
        field_placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_placaActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingresar la placa:");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingresar el nombre del propietario:");

        jLabel3.setBackground(new java.awt.Color(43, 43, 43));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Selecciona el tipo del vehículo:");

        jButton1.setBackground(new java.awt.Color(33, 150, 243));
        jButton1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Enviar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(43, 43, 43));
        jLabel4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CREAR VEHÍCULO");

        panelAlert1.setBackground(java.awt.SystemColor.activeCaption);
        panelAlert1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEtchedBorder()));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectTypeVehi, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(field_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(field_seller, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(panelAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(field_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field_seller, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addComponent(jLabel3))
                    .addComponent(panelAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(selectTypeVehi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
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

    private void jBDeleteVehiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteVehiActionPerformed
        this.frame.contentVehicle();
    }//GEN-LAST:event_jBDeleteVehiActionPerformed

    private void selectTypeVehiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTypeVehiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectTypeVehiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Map<String, String> insertData = new HashMap<>();
        String plate = field_placa.getText();
        String name_seller = field_seller.getText();
        String category =  selectTypeVehi.getSelectedItem().toString();
        insertData.put("plate", plate);
        insertData.put("owner", name_seller);
        insertData.put("category", category);
        String endpoint = "/vehicle/insertVehicle.php";
        endpoint = dataConfig.getEndPoint(endpoint);
        String respuesta = Herramientas.consumoPOST(endpoint, insertData);
        System.out.println(respuesta);
        if(respuesta!=null){
            JsonObject jsonObject = JsonParser.parseString(respuesta).getAsJsonObject();
            boolean status = jsonObject.get("status").getAsBoolean();
            System.out.println(status);


            if(status){
                alerta("Se inserto correctamente", "/parkingapp/resources/gifs/midPriority.gif");
                field_placa.setText("");
                field_seller.setText("");

            }else{
                 alerta("No se pudo registrar el vehiculo", "/parkingapp/resources/gifs/midPriority.gif");
            }

        }else{
            alerta("No se pudo registrar el vehiculo", "/parkingapp/resources/gifs/midPriority.gif");

        }

        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void alerta(String text, String url){
       messageAlert1.setFont(new java.awt.Font("Segoe UI", 1, 15));
       panelAlert1.setBackground(java.awt.SystemColor.activeCaption);
       messageAlert1.setText(text);
       imgAlert1.setIcon(new javax.swing.ImageIcon(getClass().getResource(url)));
       panelAlert1.setVisible(true);
    }
    
    private void field_sellerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_sellerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_sellerActionPerformed

    private void field_placaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_placaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_placaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField field_placa;
    private javax.swing.JTextField field_seller;
    private javax.swing.JLabel imgAlert1;
    private javax.swing.JButton jBDeleteVehi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel messageAlert1;
    private javax.swing.JPanel panelAlert1;
    private javax.swing.JComboBox<String> selectTypeVehi;
    // End of variables declaration//GEN-END:variables

    private void alterInitCoponenst() {
        
                // Usar un KeyAdapter para validar la entrada en tiempo real
        field_placa.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetterOrDigit(c) || field_placa.getText().length() >= 6) {
                    e.consume();  // Ignorar caracteres no válidos o si la placa tiene más de 6 caracteres.
                }
            }
        });
        panelAlert1.setVisible(false);
        selectTypeVehi.removeAllItems();
        selectTypeVehi.addItem("moto");
        selectTypeVehi.addItem("camioneta");
        selectTypeVehi.addItem("camion");
        selectTypeVehi.addItem("carro");
    }
}
