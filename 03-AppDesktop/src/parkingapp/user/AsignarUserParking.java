/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package parkingapp.user;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.Border;
import parkingapp.MainFrame;
import parkingapp.util.Herramientas;

/**
 *
 * @author INSTRUCTOR
 */
public class AsignarUserParking extends javax.swing.JPanel {

    User user;
    MainFrame frame;
    int idParkingSeleccionado;
    private Map<String, Integer> model = new HashMap<>();
    public AsignarUserParking(User user,MainFrame frame) {
        this.user=user;
        this.frame=frame;
        
        initComponents();
        initaltercomponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelRol = new javax.swing.JLabel();
        empresas = new javax.swing.JComboBox<>();
        titulo = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_vincular = new javax.swing.JButton();
        labelCedula = new javax.swing.JLabel();
        campoCedula = new javax.swing.JTextField();

        setBackground(new java.awt.Color(43, 43, 43));

        LabelRol.setBackground(new java.awt.Color(210, 210, 210));
        LabelRol.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabelRol.setForeground(new java.awt.Color(255, 255, 255));
        LabelRol.setText("PARQUEADEROS:");

        empresas.setForeground(new java.awt.Color(255, 255, 255));
        empresas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        empresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empresasActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("CREAR USUARIO");

        btn_cancelar.setBackground(new java.awt.Color(255, 107, 107));
        btn_cancelar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.setFocusable(false);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_vincular.setBackground(new java.awt.Color(76, 175, 80));
        btn_vincular.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_vincular.setForeground(new java.awt.Color(255, 255, 255));
        btn_vincular.setText("VINCULAR");
        btn_vincular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_vincular.setFocusable(false);
        btn_vincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vincularActionPerformed(evt);
            }
        });

        labelCedula.setBackground(new java.awt.Color(210, 210, 210));
        labelCedula.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelCedula.setForeground(new java.awt.Color(255, 255, 255));
        labelCedula.setText("CEDULA VENDEDOR:");

        campoCedula.setForeground(new java.awt.Color(255, 255, 255));
        campoCedula.setEnabled(false);
        campoCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCedulaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_cancelar)
                                .addGap(50, 50, 50)
                                .addComponent(btn_vincular, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(labelCedula)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(LabelRol)
                                    .addGap(66, 66, 66)
                                    .addComponent(empresas, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empresas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_vincular, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        

        PanelUsers temporaryPanel = new PanelUsers(null,frame);
        this.frame.replacePanel(temporaryPanel);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_vincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vincularActionPerformed
        String cedula = campoCedula.getText();
        String parqueadero = empresas.getSelectedItem().toString();

        if (!campoCedula.getText().isEmpty() && model.containsKey(parqueadero)) {
            int idUsuario = Integer.parseInt(cedula);
            int idParqueadero = model.get(parqueadero);

            Map<String, String> insertData = new HashMap<>();
            insertData.put("user_id", String.valueOf(idUsuario));
            insertData.put("parking_id", String.valueOf(idParqueadero));

            String actualizar = Herramientas.insert("http://localhost/parkingAPI/parking_seller/insertParkingSeller.php", insertData);
            if (actualizar != null) {
                JsonObject jsonObject = JsonParser.parseString(actualizar).getAsJsonObject();
                boolean status = jsonObject.get("status").getAsBoolean();
                String message = jsonObject.get("mesagge").getAsString();

                if (status) {
                    Herramientas.alerta(message, true);
                    PanelUsers temporaryPanel = new PanelUsers(null,frame);
                    this.frame.replacePanel(temporaryPanel);
                    
                    // Realiza acciones adicionales si es necesario
                } else {
                    Herramientas.alerta(message, false);
                    Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
                    campoCedula.setBorder(bordeRojo);
                }
            } else {
                Herramientas.alerta("No se pudo vincular el usuario al parqueadero", false);
            }
        } else {
            Herramientas.alerta("Complete todos los datos", false);
        }

    }//GEN-LAST:event_btn_vincularActionPerformed

    private void campoCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCedulaKeyTyped
        char caracter=evt.getKeyChar();
        if(!Character.isDigit(caracter)){
            evt.consume();
        }
    }//GEN-LAST:event_campoCedulaKeyTyped

    private void empresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empresasActionPerformed
        String parkingSeleccionado = (String) empresas.getSelectedItem();
        if (model.containsKey(parkingSeleccionado)) {
            idParkingSeleccionado = model.get(parkingSeleccionado);
            // Ahora tienes el id_proveedor en la variable idProveedorSeleccionado
            System.out.println("ID del parqueadero seleccionado: " + idParkingSeleccionado);
        }
    }//GEN-LAST:event_empresasActionPerformed
    
    public void initaltercomponents(){
        
        parkings();
        int id=user.getId();
        String idString = String.valueOf(id);
        campoCedula.setText(idString);
    }
    
    public void parkings(){
        
        String consult = Herramientas.consumoGET("http://localhost/parkingAPI/parking/getParkings.php");
       
        if (consult != null) { 
            
            Gson gson = new Gson();
            JsonObject jsonObject = JsonParser.parseString(consult).getAsJsonObject();
            JsonArray parkingArray = jsonObject.getAsJsonArray("parkings");

            for (JsonElement element : parkingArray) {
                JsonObject parkingObject = element.getAsJsonObject();
                int id = parkingObject.get("id").getAsInt();
                String nombre = parkingObject.get("name").getAsString();
                
                String estado = parkingObject.get("status").getAsString();
                if(estado.contentEquals("activo")){
                    model.put(nombre, id); // Guardar en el Map
                    empresas.addItem(nombre);
                }
                
            }
            
            if(parkingArray.size() == 0){
                
                Herramientas.alerta("No hay empresas, registre una y vuelva", false);
                btn_vincular.setEnabled(false);
       
            }
            
        } else {
            
            Herramientas.alerta("Error en la api", false);
            btn_vincular.setEnabled(false);

        }
        

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelRol;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_vincular;
    private javax.swing.JTextField campoCedula;
    private javax.swing.JComboBox<String> empresas;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
