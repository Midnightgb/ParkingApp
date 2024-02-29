package parkingapp.login;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import parkingapp.Config;
import parkingapp.MainFrame;
import parkingapp.user.User;
import parkingapp.util.Herramientas;
import javax.swing.ImageIcon;
import java.awt.Image;

public class LoginFrame extends javax.swing.JFrame {
    private String getUser;
    private Config dataConfig;

    public LoginFrame() {
        initComponents();
        panelAlert.setVisible(false);
        loginButton.requestFocus();
        dataConfig = new Config();
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/parkingapp/resources/images/icons8-estacionamiento-64.png"));
        Image img = imgIcon.getImage();
        this.setIconImage(img);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        contraseniaInput = new javax.swing.JPasswordField();
        cedulaInput = new javax.swing.JTextField();
        imgLogo = new javax.swing.JLabel();
        contraseniaOlvidada = new javax.swing.JLabel();
        separadorContra1 = new javax.swing.JSeparator();
        loginButton = new javax.swing.JButton();
        separadorContra = new javax.swing.JSeparator();
        separadorCedula = new javax.swing.JSeparator();
        contraText = new javax.swing.JLabel();
        panelAlert = new javax.swing.JPanel();
        messageAlert = new javax.swing.JLabel();
        imgAlert = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLogin.setBackground(new java.awt.Color(43, 43, 43));

        setTitle("Login");
        setResizable(false);
        login.setBackground(new java.awt.Color(43, 43, 43));

        contraseniaInput.setBackground(new java.awt.Color(43, 43, 43));
        contraseniaInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        contraseniaInput.setForeground(new java.awt.Color(210, 210, 210));
        contraseniaInput.setText("Contraseña:");
        contraseniaInput.setToolTipText("");
        contraseniaInput.setBorder(null);
        contraseniaInput.setCaretColor(new java.awt.Color(204, 204, 204));
        contraseniaInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contraseniaInputKeyTyped(evt);
            }
        });

        cedulaInput.setBackground(new java.awt.Color(43, 43, 43));
        cedulaInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cedulaInput.setForeground(new java.awt.Color(210, 210, 210));
        cedulaInput.setText("Cedula");
        cedulaInput.setToolTipText("");
        cedulaInput.setBorder(null);
        cedulaInput.setCaretColor(new java.awt.Color(204, 204, 204));
        cedulaInput.setNextFocusableComponent(contraseniaInput);
        cedulaInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedulaInputKeyTyped(evt);
            }
        });

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkingapp/resources/images/parkingLogo150.png"))); // NOI18N

        contraseniaOlvidada.setForeground(new java.awt.Color(210, 210, 210));
        contraseniaOlvidada.setText("¿Olvidaste tu contraseña?");
        contraseniaOlvidada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contraseniaOlvidada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contraseniaOlvidadaMouseClicked(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(33, 150, 243));
        loginButton.setFont(new java.awt.Font("Source Code Pro", 1, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Ingresar");
        loginButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        contraText.setForeground(new java.awt.Color(210, 210, 210));
        contraText.setText("Contraseña:");

        panelAlert.setBackground(java.awt.SystemColor.activeCaption);
        panelAlert.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEtchedBorder()));

        messageAlert.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        messageAlert.setForeground(new java.awt.Color(255, 255, 255));
        messageAlert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        imgAlert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgAlert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkingapp/resources/gifs/midPriority.gif"))); // NOI18N
        imgAlert.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);

        javax.swing.GroupLayout panelAlertLayout = new javax.swing.GroupLayout(panelAlert);
        panelAlert.setLayout(panelAlertLayout);
        panelAlertLayout.setHorizontalGroup(
            panelAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelAlertLayout.setVerticalGroup(
            panelAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgAlert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
            .addComponent(messageAlert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkingapp/resources/images/icons8-usuario-masculino-en-círculo-25.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkingapp/resources/images/icons8-contraseña-25.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(contraseniaOlvidada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17))
                                    .addComponent(separadorContra1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                                .addComponent(panelAlert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                                .addComponent(imgLogo)
                                .addGap(70, 70, 70))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contraText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(contraseniaInput, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(separadorContra, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(separadorCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(cedulaInput, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cedulaInput, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(separadorCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(contraText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contraseniaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorContra, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contraseniaOlvidada)
                .addGap(2, 2, 2)
                .addComponent(separadorContra1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAlert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        setVisible(true);
        revalidate();
        repaint();

        getContentPane().add(panelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String id = cedulaInput.getText();
        if (id.equals("Cedula")){
            messageAlert.setFont(new java.awt.Font("Segoe UI", 1, 15));
            panelAlert.setBackground(java.awt.SystemColor.activeCaption);
            messageAlert.setText("Porfavor, ingresa la cedula.");
            imgAlert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkingapp/resources/gifs/midPriority.gif")));
            panelAlert.setVisible(true);
            return;
        }
        int length = id.length();
        if (length <= 0){
            messageAlert.setFont(new java.awt.Font("Segoe UI", 1, 15));
            panelAlert.setBackground(java.awt.SystemColor.activeCaption);
            messageAlert.setText("Porfavor, ingresa la cedula.");
            imgAlert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkingapp/resources/gifs/midPriority.gif")));
            panelAlert.setVisible(true);
            return;
        }
        String password = new String(contraseniaInput.getPassword());
        Map<String, String> getData = new HashMap<>();
        getData.put("iduser", id);
        getData.put("validatePass", password);
        showLoading();
        String endpoint = "/users/getUser.php";
        endpoint = dataConfig.getEndPoint(endpoint);
        getUser = Herramientas.consumoGET(endpoint, getData);
        System.out.println("User: " + getUser);
        hideLoading();

        JsonObject jsonObject = JsonParser.parseString(getUser).getAsJsonObject();
        boolean status = jsonObject.get("status").getAsBoolean();
        String message = jsonObject.get("message").getAsString();
        
        if (!status){
            messageAlert.setFont(new java.awt.Font("Segoe UI", 1, 14));
            messageAlert.setText(message);
            panelAlert.setBackground(new java.awt.Color(199, 84, 80));
            panelAlert.setVisible(true);
            cedulaInput.requestFocus();
            return;
        }

        JsonObject datosObject = jsonObject.getAsJsonObject("datos");
        String estado = datosObject.get("status").getAsString();

        if (estado.equals("inactivo")){
            messageAlert.setFont(new java.awt.Font("Segoe UI", 1, 14));
            panelAlert.setBackground(new java.awt.Color(199, 84, 80));
            messageAlert.setText("<html>El usuario se encuentra desactivado. <br>Porfavor, contacte con soporte si cree que esto es un error.</html>");
            panelAlert.setVisible(true);
            return;
        }
        String idUser = datosObject.get("id").getAsString();
        String name = datosObject.get("name").getAsString();
        String email = datosObject.get("email").getAsString();
        String rol = datosObject.get("rol").getAsString();
        String pass = datosObject.get("password").getAsString();
        String statusUser = datosObject.get("status").getAsString();
        String parking = datosObject.get("parking_id").getAsString();

        System.out.println("validate: " + pass);
        if (pass.equals("OK")){
            int idUserInt = Integer.parseInt(idUser);
            User user = new User(idUserInt, name, email, rol, statusUser, parking);
            System.out.println("User Parking: " + user.getParking());
            MainFrame frame = new MainFrame(user);
            frame.setVisible(true);
            this.setVisible(false);
        }else{
            contraseniaInput.requestFocus();
            messageAlert.setFont(new java.awt.Font("Segoe UI", 1, 17));
            panelAlert.setBackground(new java.awt.Color(199, 84, 80));
            messageAlert.setText("Contraseña incorrecta.");
            panelAlert.setVisible(true);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void contraseniaOlvidadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contraseniaOlvidadaMouseClicked
        System.out.println("hola olvide la contra");
        LostPassword olvido = new LostPassword();
        olvido.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_contraseniaOlvidadaMouseClicked
    private boolean borradoCedula = false;
    private boolean delAlert = false;
    private void cedulaInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaInputKeyTyped
        char c = evt.getKeyChar();
        if (c == '\n') {
            if (cedulaInput.getText().equals("Cedula")){
                messageAlert.setFont(new java.awt.Font("Segoe UI", 1, 15));
                messageAlert.setText("Porfavor, ingresa la cedula.");
                panelAlert.setBackground(java.awt.SystemColor.activeCaption);
                imgAlert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkingapp/resources/gifs/midPriority.gif")));
                panelAlert.setVisible(true);
                return;
            }
            loginButtonActionPerformed(null);
        }
        
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        
        if (!borradoCedula) {
            cedulaInput.setText("");
        }
        borradoCedula = true;
        
        if (!delAlert) {
            panelAlert.setVisible(false);
        }
        delAlert = true;
    }//GEN-LAST:event_cedulaInputKeyTyped
    private boolean borradoContra = false;
    private void contraseniaInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraseniaInputKeyTyped
        if (!borradoContra) {
            contraseniaInput.setText("");
        }
        borradoContra = true;
        char c = evt.getKeyChar();
        if (c == '\n') {
            if (cedulaInput.getText().equals("Cedula")){
                messageAlert.setFont(new java.awt.Font("Segoe UI", 1, 15));
                messageAlert.setText("Porfavor, ingresa la cedula.");
                panelAlert.setBackground(java.awt.SystemColor.activeCaption);
                imgAlert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkingapp/resources/gifs/midPriority.gif")));
                panelAlert.setVisible(true);
                return;
            }
            loginButtonActionPerformed(null);
        }
    }//GEN-LAST:event_contraseniaInputKeyTyped
    
    private void showLoading() {
        System.out.println("### cargando...");
    }
    
    private void hideLoading() {
        System.out.println("### cargado");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cedulaInput;
    private javax.swing.JLabel contraText;
    private javax.swing.JPasswordField contraseniaInput;
    private javax.swing.JLabel contraseniaOlvidada;
    private javax.swing.JLabel imgAlert;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel login;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel messageAlert;
    private javax.swing.JPanel panelAlert;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JSeparator separadorCedula;
    private javax.swing.JSeparator separadorContra;
    private javax.swing.JSeparator separadorContra1;
    // End of variables declaration//GEN-END:variables
}
