
package parkingapp.user;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.Border;
import parkingapp.MainFrame;
import parkingapp.util.Herramientas;


public class PanelCrearUser extends javax.swing.JPanel {

    
    MainFrame frame;
    String idUser;
    public PanelCrearUser(String idUser,MainFrame frame) {
        
        this.idUser=idUser;
        this.frame=frame;
        initComponents();
        initaltercomponets();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoEmail = new javax.swing.JTextField();
        titulo = new javax.swing.JLabel();
        btn_crear = new javax.swing.JButton();
        labelCedula = new javax.swing.JLabel();
        campoCedula = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        labelEmaill = new javax.swing.JLabel();
        LabelPass = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        LabelRol = new javax.swing.JLabel();
        Rol = new javax.swing.JComboBox<>();
        btn_cancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(43, 43, 43));
        setPreferredSize(new java.awt.Dimension(808, 509));

        campoEmail.setForeground(new java.awt.Color(255, 255, 255));
        campoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("CREAR USUARIO");

        btn_crear.setBackground(new java.awt.Color(76, 175, 80));
        btn_crear.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_crear.setForeground(new java.awt.Color(255, 255, 255));
        btn_crear.setText("CREAR");
        btn_crear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_crear.setFocusable(false);
        btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearActionPerformed(evt);
            }
        });

        labelCedula.setBackground(new java.awt.Color(210, 210, 210));
        labelCedula.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelCedula.setForeground(new java.awt.Color(255, 255, 255));
        labelCedula.setText("CEDULA:");

        campoCedula.setForeground(new java.awt.Color(255, 255, 255));
        campoCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCedulaKeyTyped(evt);
            }
        });

        labelNombre.setBackground(new java.awt.Color(210, 210, 210));
        labelNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setText("NOMBRE:");

        campoNombre.setForeground(new java.awt.Color(255, 255, 255));

        labelEmaill.setBackground(new java.awt.Color(210, 210, 210));
        labelEmaill.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelEmaill.setForeground(new java.awt.Color(255, 255, 255));
        labelEmaill.setText("EMAIL:");

        LabelPass.setBackground(new java.awt.Color(210, 210, 210));
        LabelPass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabelPass.setForeground(new java.awt.Color(255, 255, 255));
        LabelPass.setText("PASSWORD:");

        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));

        LabelRol.setBackground(new java.awt.Color(210, 210, 210));
        LabelRol.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabelRol.setForeground(new java.awt.Color(255, 255, 255));
        LabelRol.setText("ROL:");

        Rol.setForeground(new java.awt.Color(255, 255, 255));
        Rol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(120, 120, 120)
                                .addComponent(campoNombre))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelEmaill, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelPass, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPasswordField1)
                                    .addComponent(campoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(Rol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_cancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(61, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LabelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEmailActionPerformed
    public void initaltercomponets(){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("seller");
        model.addElement("admin");
        
        
        Rol.setModel(model);
    }
    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearActionPerformed
        String cedula = campoCedula.getText();
        
        String nombres = campoNombre.getText();
        char[] password = jPasswordField1.getPassword();
        String passwordString = new String(password);
        String email = campoEmail.getText();
        String rol = Rol.getSelectedItem().toString();
        
        if(!campoCedula.getText().equals("") && !campoEmail.getText().equals("") && !campoNombre.getText().equals("") && !passwordString.equals("") ){
            Map<String, String> insertData = new HashMap<>();
            insertData.put("iduser", cedula);
            insertData.put("name", nombres);
            insertData.put("email", email);
            insertData.put("password", passwordString);
            insertData.put("rol", rol);

            String insertar=Herramientas.insert("http://localhost/parkingAPI/users/Insert.php", insertData);
            if(insertar!=null){
                JsonObject jsonObject = JsonParser.parseString(insertar).getAsJsonObject();
                boolean status = jsonObject.get("status").getAsBoolean();
                System.out.println(status);
                
                String message = jsonObject.get("mesagge").getAsString();
                System.out.println(message);
                
                if(status){
                    String mensaje="para iniciar sesion ingrese con su cedula:"+cedula+" y la contraseña: "+passwordString;
                    String asunto="HA SIDO REGISTRADO EN PARKING ADSO";
                    try {
                        Herramientas.enviarCorreo(email, asunto, mensaje);
                    } catch (IOException ex) {
                        Logger.getLogger(PanelCrearUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Herramientas.alerta(message, true);
                    System.out.println(insertar);
                    campoCedula.setText("");
                    campoNombre.setText("");
                    jPasswordField1.setText("");
                    campoEmail.setText("");
                    campoCedula.setBorder(null);
                    PanelUsers temporaryPanel = new PanelUsers(idUser,frame);
                    this.frame.replacePanel(temporaryPanel);

                }else{
                    
                    Herramientas.alerta(message, false);
                    Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
                    campoCedula.setBorder(bordeRojo);
                }
                
            }else{
                Herramientas.alerta("No se pudo agregar el usuario", false);
            }
        }else{
            Herramientas.alerta("Complete todos los datos", false);
        }
        
    }//GEN-LAST:event_btn_crearActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        PanelUsers temporaryPanel = new PanelUsers(idUser,frame);
        this.frame.replacePanel(temporaryPanel);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void campoCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCedulaKeyTyped
        char caracter=evt.getKeyChar();
        if(!Character.isDigit(caracter)){
            evt.consume();
        }
    }//GEN-LAST:event_campoCedulaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelPass;
    private javax.swing.JLabel LabelRol;
    private javax.swing.JComboBox<String> Rol;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_crear;
    private javax.swing.JTextField campoCedula;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelEmaill;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
