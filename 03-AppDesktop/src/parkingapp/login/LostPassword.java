package parkingapp.login;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;

import parkingapp.user.User;
import parkingapp.util.Herramientas;

public class LostPassword extends javax.swing.JFrame {
    
    public LostPassword() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contraOlvidada = new javax.swing.JPanel();
        imgContraOlvidada = new javax.swing.JLabel();
        cedulaBuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        buscarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        textoAyuda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(43, 43, 43));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contraOlvidada.setBackground(new java.awt.Color(43, 43, 43));
        contraOlvidada.setForeground(new java.awt.Color(210, 210, 210));

        cedulaBuscar.setBackground(new java.awt.Color(43, 43, 43));
        cedulaBuscar.setFont(new java.awt.Font("Source Code Pro", 0, 14)); // NOI18N
        cedulaBuscar.setForeground(new java.awt.Color(210, 210, 210));
        cedulaBuscar.setText("Ingresa tu cedula");
        cedulaBuscar.setBorder(null);
        cedulaBuscar.setCaretColor(new java.awt.Color(255, 255, 255));
        cedulaBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedulaBuscarKeyTyped(evt);
            }
        });

        buscarButton.setBackground(new java.awt.Color(48, 119, 62));
        buscarButton.setFont(new java.awt.Font("Source Code Pro", 1, 14)); // NOI18N
        buscarButton.setForeground(new java.awt.Color(255, 255, 255));
        buscarButton.setText("Buscar");
        buscarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buscarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarButtonMouseClicked(evt);
            }
        });
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setBackground(new java.awt.Color(255, 107, 107));
        cancelarButton.setFont(new java.awt.Font("Source Code Pro", 1, 14)); // NOI18N
        cancelarButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelarButton.setText("Cancelar");
        cancelarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cancelarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarButtonMouseClicked(evt);
            }
        });

        textoAyuda.setFont(new java.awt.Font("Source Code Pro", 0, 12)); // NOI18N
        textoAyuda.setForeground(new java.awt.Color(255, 255, 255));
        textoAyuda.setText("Porfavor ingresa tu cedula para encontrar tu cuenta.");

        javax.swing.GroupLayout contraOlvidadaLayout = new javax.swing.GroupLayout(contraOlvidada);
        contraOlvidada.setLayout(contraOlvidadaLayout);
        contraOlvidadaLayout.setHorizontalGroup(
            contraOlvidadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contraOlvidadaLayout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addGroup(contraOlvidadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contraOlvidadaLayout.createSequentialGroup()
                        .addComponent(imgContraOlvidada)
                        .addGap(234, 234, 234))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contraOlvidadaLayout.createSequentialGroup()
                        .addGroup(contraOlvidadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cedulaBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(180, 180, 180))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contraOlvidadaLayout.createSequentialGroup()
                        .addGroup(contraOlvidadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textoAyuda)
                            .addGroup(contraOlvidadaLayout.createSequentialGroup()
                                .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101)
                                .addComponent(buscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(141, 141, 141))))
        );
        contraOlvidadaLayout.setVerticalGroup(
            contraOlvidadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contraOlvidadaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(imgContraOlvidada, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(textoAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cedulaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(contraOlvidadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        getContentPane().add(contraOlvidada, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarButtonMouseClicked
        LoginFrame login = new LoginFrame();
        setVisible(false);
    }//GEN-LAST:event_cancelarButtonMouseClicked
    private boolean borrado = false;
    private void cedulaBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaBuscarKeyTyped
        char c = evt.getKeyChar();
        if (c == '\n') {
            buscarButtonMouseClicked(null);
        }
        if (!borrado)
            cedulaBuscar.setText("");
            borrado = true;
    }//GEN-LAST:event_cedulaBuscarKeyTyped
    //buscar usuario 
    private void buscarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarButtonMouseClicked
        System.out.println("Buscar cuenta");
        String cedula = cedulaBuscar.getText();
        
        if (!cedula.isEmpty() && cedula.matches("\\d+")) {
            int cedulaInt = Integer.parseInt(cedula);
            try{
                Map<String, String> getData = new HashMap<>();
                getData.put("iduser", cedula);
                String getUser = Herramientas.consumoGET("http://localhost/parkingAPI/users/getUser.php", getData);
                System.out.println(getUser);
                JsonObject jsonObject = JsonParser.parseString(getUser).getAsJsonObject();
                boolean status = jsonObject.get("status").getAsBoolean();
                

                boolean usuarioExiste = status;
                
                if (!usuarioExiste) {
                    Herramientas.alerta("Usuario ingresado no registrado.",false);
                } else {
                    JsonObject datosObject = jsonObject.getAsJsonObject("datos");
                    String codigo = generarCodigo();
                    String correo = datosObject.get("email").getAsString();
                    String nombre = datosObject.get("name").getAsString();
                    String rol = datosObject.get("rol").getAsString();
                    String statusUser = datosObject.get("status").getAsString();
                    String parking = datosObject.get("parking_id").getAsString();

                    User user = new User(cedulaInt, nombre, correo, rol, statusUser, parking);

                    String mensaje = "Su codigo de autenticacion es : <b style='font-size:16px;'>"+codigo+"</b>"
                            + "<br><br><br>Atentamente<br>"
                            + "Equipo de <b>Parking ADSO</b>";
                    boolean envio = false;
                    try {
                        envio = Herramientas.enviarCorreo(correo, "Codigo de verificacion ", mensaje);
                        System.out.println(envio);
                    } catch (IOException ex) {
                        Logger.getLogger(LostPassword.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (envio) {
                        CheckCodeAuth confirmacion = new CheckCodeAuth(codigo, user);
                        confirmacion.setVisible(true);
                        setVisible(false);   
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }
        } else {
            Herramientas.alerta("Por favor, ingrese una cédula válida.",false);
        }
    }//GEN-LAST:event_buscarButtonMouseClicked

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarButtonActionPerformed
    
    private String generarCodigo() {
        Random numero = new Random();
        int codigo = numero.nextInt(9000) + 1000;
        return Integer.toString(codigo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField cedulaBuscar;
    private javax.swing.JPanel contraOlvidada;
    private javax.swing.JLabel imgContraOlvidada;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel textoAyuda;
    // End of variables declaration//GEN-END:variables
}
