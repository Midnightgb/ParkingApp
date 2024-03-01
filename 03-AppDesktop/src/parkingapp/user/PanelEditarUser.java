/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package parkingapp.user;

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
import parkingapp.Config;

/**
 *
 * @author INSTRUCTOR
 */
public class PanelEditarUser extends javax.swing.JPanel {

    User user;
    MainFrame frame;
    private Config dataConfig;
    
    public PanelEditarUser(User user,MainFrame frame) {
        this.user=user;
        this.frame=frame;
        dataConfig = new Config();
        initComponents();
        initaltercomponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelRol = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        estado = new javax.swing.JComboBox<>();
        titulo = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        labelCedula = new javax.swing.JLabel();
        campoCedula = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        labelEmaill = new javax.swing.JLabel();

        setBackground(new java.awt.Color(43, 43, 43));

        LabelRol.setBackground(new java.awt.Color(210, 210, 210));
        LabelRol.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabelRol.setForeground(new java.awt.Color(255, 255, 255));
        LabelRol.setText("Estado:");

        campoEmail.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        campoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailActionPerformed(evt);
            }
        });

        estado.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        estado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        btn_actualizar.setBackground(new java.awt.Color(76, 175, 80));
        btn_actualizar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_actualizar.setText("ACTUALIZAR");
        btn_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_actualizar.setFocusable(false);
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        labelCedula.setBackground(new java.awt.Color(210, 210, 210));
        labelCedula.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelCedula.setForeground(new java.awt.Color(255, 255, 255));
        labelCedula.setText("CEDULA:");

        campoCedula.setEnabled(false);
        campoCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCedulaKeyTyped(evt);
            }
        });

        labelNombre.setBackground(new java.awt.Color(210, 210, 210));
        labelNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setText("NOMBRE:");

        campoNombre.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        labelEmaill.setBackground(new java.awt.Color(210, 210, 210));
        labelEmaill.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelEmaill.setForeground(new java.awt.Color(255, 255, 255));
        labelEmaill.setText("EMAIL:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEmaill, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btn_cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
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
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmaill, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEmailActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        

        PanelUsers temporaryPanel = new PanelUsers(null,frame);
        this.frame.replacePanel(temporaryPanel);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        String cedula = campoCedula.getText();

        String nombres = campoNombre.getText();
 
        String email = campoEmail.getText();
        String estadoo = estado.getSelectedItem().toString();

        if(!campoCedula.getText().equals("") && !campoEmail.getText().equals("") && !campoNombre.getText().equals("") ){
            Map<String, String> insertData = new HashMap<>();
            insertData.put("iduser", cedula);
            insertData.put("name", nombres);
            insertData.put("email", email);
            insertData.put("status", estadoo);
            insertData.put("rol", user.getRol());
            
            String endpoint = "/users/Update.php";
            endpoint = dataConfig.getEndPoint(endpoint);
            String actualizar=Herramientas.insert(endpoint, insertData);
            if(actualizar!=null){
                System.out.println(actualizar);
                JsonObject jsonObject = JsonParser.parseString(actualizar).getAsJsonObject();
                boolean status = jsonObject.get("status").getAsBoolean();
                System.out.println(status);

                String message = jsonObject.get("message").getAsString();
                System.out.println(message);

                if(status){
                    Herramientas.alerta(message, true);
                    System.out.println(actualizar);
                    PanelUsers temporaryPanel = new PanelUsers(null,frame);
                    this.frame.replacePanel(temporaryPanel);
                    

                }else{

                    Herramientas.alerta(message, false);
                    Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
                    campoCedula.setBorder(bordeRojo);
                }

            }else{
                Herramientas.alerta("No se pudo editar el usuario", false);
            }
        }else{
            Herramientas.alerta("Complete todos los datos", false);
        }

    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void campoCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCedulaKeyTyped
        char caracter=evt.getKeyChar();
        if(!Character.isDigit(caracter)){
            evt.consume();
        }
    }//GEN-LAST:event_campoCedulaKeyTyped
    
    public void initaltercomponents(){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        
        if(!user.getEstado().equals("activo")){
            
            model.addElement("inactivo");
            model.addElement("activo");
        }else if(!user.getEstado().equals("inactivo")){
           
            model.addElement("activo");
            model.addElement("inactivo");
        }
        
        estado.setModel(model);
        
        int id=user.getId();
        String idString = String.valueOf(id);
        campoCedula.setText(idString);
        campoNombre.setText(user.getNombre());
        campoEmail.setText(user.getCorreo());
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelRol;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JTextField campoCedula;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelEmaill;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
