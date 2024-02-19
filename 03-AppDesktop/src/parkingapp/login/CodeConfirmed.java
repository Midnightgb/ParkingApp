package parkingapp.login;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Map;

import parkingapp.user.User;
import parkingapp.util.Herramientas;

public class CodeConfirmed extends javax.swing.JFrame {
    private User user;
    public CodeConfirmed(User userData) {
        initComponents();
        this.user = userData;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCodigoConfirmado = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        newPassText = new javax.swing.JLabel();
        newPassInput = new javax.swing.JPasswordField();
        separadorNewPass = new javax.swing.JSeparator();
        confirmarPassText = new javax.swing.JLabel();
        separadorConfirmarPass = new javax.swing.JSeparator();
        confirmarPassInput = new javax.swing.JPasswordField();
        confirmar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelCodigoConfirmado.setBackground(new java.awt.Color(43, 43, 43));

        newPassText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        newPassText.setForeground(new java.awt.Color(255, 255, 255));
        newPassText.setText("Nueva Contraseña:");

        newPassInput.setBackground(new java.awt.Color(43, 43, 43));
        newPassInput.setForeground(new java.awt.Color(255, 255, 255));
        newPassInput.setBorder(null);
        newPassInput.setCaretColor(new java.awt.Color(255, 255, 255));
        newPassInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newPassInputKeyTyped(evt);
            }
        });

        confirmarPassText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        confirmarPassText.setForeground(new java.awt.Color(255, 255, 255));
        confirmarPassText.setText("Confirmar Contraseña:");

        confirmarPassInput.setBackground(new java.awt.Color(43, 43, 43));
        confirmarPassInput.setForeground(new java.awt.Color(255, 255, 255));
        confirmarPassInput.setBorder(null);
        confirmarPassInput.setCaretColor(new java.awt.Color(255, 255, 255));
        confirmarPassInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                confirmarPassInputKeyTyped(evt);
            }
        });

        confirmar.setBackground(new java.awt.Color(48, 119, 62));
        confirmar.setFont(new java.awt.Font("Source Code Pro", 1, 14)); // NOI18N
        confirmar.setForeground(new java.awt.Color(255, 255, 255));
        confirmar.setText("Confirmar");
        confirmar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        confirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmarMouseClicked(evt);
            }
        });

        cancelar.setBackground(new java.awt.Color(255, 107, 107));
        cancelar.setFont(new java.awt.Font("Source Code Pro", 1, 14)); // NOI18N
        cancelar.setForeground(new java.awt.Color(255, 255, 255));
        cancelar.setText("Cancelar");
        cancelar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCodigoConfirmadoLayout = new javax.swing.GroupLayout(panelCodigoConfirmado);
        panelCodigoConfirmado.setLayout(panelCodigoConfirmadoLayout);
        panelCodigoConfirmadoLayout.setHorizontalGroup(
            panelCodigoConfirmadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodigoConfirmadoLayout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(img)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCodigoConfirmadoLayout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addGroup(panelCodigoConfirmadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCodigoConfirmadoLayout.createSequentialGroup()
                        .addGroup(panelCodigoConfirmadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmarPassText)
                            .addGroup(panelCodigoConfirmadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(confirmarPassInput)
                                .addComponent(separadorConfirmarPass, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(newPassText)
                            .addGroup(panelCodigoConfirmadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(newPassInput, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(separadorNewPass)))
                        .addGap(194, 194, 194))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCodigoConfirmadoLayout.createSequentialGroup()
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))))
        );
        panelCodigoConfirmadoLayout.setVerticalGroup(
            panelCodigoConfirmadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodigoConfirmadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img)
                .addGap(36, 36, 36)
                .addComponent(newPassText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPassInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmarPassText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmarPassInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorConfirmarPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelCodigoConfirmadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCodigoConfirmado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCodigoConfirmado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //Botón confirmar nueva contraseña
    private void confirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmarMouseClicked
        
        System.out.println("confirmar nueva contra");
        String pass1 = new String(newPassInput.getPassword());
        String pass2 = new String(confirmarPassInput.getPassword());
        
        boolean confirmacion = validarPass(pass1, pass2);
        
        if (!confirmacion){
            Herramientas.alerta("Las contraseñas no coinciden.",false);
            
        } else if (pass1.isEmpty() || pass2.isEmpty()) {
            Herramientas.alerta("Diligencia todos los campos.",false);
            
        } else {
            String iduser = String.valueOf(user.getId());
            String password = new String(confirmarPassInput.getPassword());
            Map<String, String> postData = new HashMap<>();
            postData.put("iduser", iduser);
            postData.put("password", password);
            postData.put("action", "updatePassword");
            String UpdateUser = Herramientas.consumoPOST("http://localhost/parkingAPI/users/Update.php", postData);
            System.out.println("User: " + UpdateUser);
            
            JsonObject jsonObject = JsonParser.parseString(UpdateUser).getAsJsonObject();
            boolean status = jsonObject.get("status").getAsBoolean();
            String message = jsonObject.get("message").getAsString();

            if (status){
                LoginFrame login = new LoginFrame();
                setVisible(false);
                login.setVisible(true);
                Herramientas.alerta(message,true);
            } else {
                Herramientas.alerta(message,false);
            }

        }
    }//GEN-LAST:event_confirmarMouseClicked

    //Función validar contraseñas
    private boolean validarPass(String pass1, String pass2){
        boolean validacion = false;
        
        if (pass1.equals(pass2)){
            validacion = true;
        }
        return validacion;
    }
    
    private void cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseClicked
        System.out.println("cancelar nueva contra");
        LoginFrame login = new LoginFrame();
        setVisible(false);
    }//GEN-LAST:event_cancelarMouseClicked
    //Input nueva contraseña
    private boolean borrado = false;
    private void newPassInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newPassInputKeyTyped
        char c = evt.getKeyChar();
        if (c == '\n') {
            confirmarMouseClicked(null);
        }
        if(!borrado){
             
            newPassInput.setText("");
            borrado = true;
        }
         
    }//GEN-LAST:event_newPassInputKeyTyped
    //Input confirmar contraseña
    private boolean borrado2 = false;
    private void confirmarPassInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmarPassInputKeyTyped
        char c = evt.getKeyChar();
        if (c == '\n') {
            confirmarMouseClicked(null);
        }
        if(!borrado2){
             
            confirmarPassInput.setText("");
            borrado2 = true;
        }
    }//GEN-LAST:event_confirmarPassInputKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton confirmar;
    private javax.swing.JPasswordField confirmarPassInput;
    private javax.swing.JLabel confirmarPassText;
    private javax.swing.JLabel img;
    private javax.swing.JPasswordField newPassInput;
    private javax.swing.JLabel newPassText;
    private javax.swing.JPanel panelCodigoConfirmado;
    private javax.swing.JSeparator separadorConfirmarPass;
    private javax.swing.JSeparator separadorNewPass;
    // End of variables declaration//GEN-END:variables
}
