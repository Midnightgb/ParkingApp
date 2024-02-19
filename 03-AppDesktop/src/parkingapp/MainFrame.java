package parkingapp;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import parkingapp.vehicle.PanelVehicles;
import parkingapp.user.PanelUsers;
import parkingapp.ticket.*;
import parkingapp.parking.PanelParking;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import parkingapp.user.User;
import parkingapp.util.Herramientas;
import parkingapp.login.LoginFrame;

public class MainFrame extends javax.swing.JFrame {
    private JButton pastButton;
    public User dataUser;
    private String idUser;
    public MainFrame(User userData) {
        initComponents();
        this.dataUser = userData;
        this.idUser = String.valueOf(dataUser.getId());

        currentUser.setText(idUser);
        pastButton = mainButton;
        System.out.println("ID: "+idUser);
        System.out.println("Nombres: "+dataUser.getNombre());
        System.out.println("Rol: "+dataUser.getRol());
        System.out.println("Correo: "+dataUser.getCorreo());

        if (dataUser.getEstado().equals("activo")){
            if (dataUser.getRol().equals("admin")) {
                parkingBtn.setText("Parqueaderos");
                usersBtn.setVisible(true);
            } else {
                parkingBtn.setText("Parqueadero");
                usersBtn.setVisible(false);
            }
        }
        MainPanel mainPanel = new MainPanel(dataUser);
        mainPanel.setSize(contentPanel.getSize());

        contentPanel.add(mainPanel);

        this.repaint();
        this.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setResizable(false);
        nav = new javax.swing.JPanel();
        mainButton = new javax.swing.JButton();
        parkingBtn = new javax.swing.JButton();
        ticketsBtn = new javax.swing.JButton();
        usersBtn = new javax.swing.JButton();
        vehiclesBtn = new javax.swing.JButton();
        cerrarSesion = new javax.swing.JButton();
        topNav = new javax.swing.JPanel();
        navLogo = new javax.swing.JLabel();
        currentUserText = new javax.swing.JLabel();
        currentUser = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        relleno2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nav.setBackground(new java.awt.Color(43, 43, 43));
        nav.setForeground(new java.awt.Color(210, 210, 210));
        nav.setMinimumSize(new java.awt.Dimension(186, 496));
        nav.setPreferredSize(new java.awt.Dimension(186, 496));

        mainButton.setBackground(new java.awt.Color(90, 90, 90));
        mainButton.setForeground(new java.awt.Color(210, 210, 210));
        mainButton.setText("Inicio");
        mainButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainButton.setBorderPainted(false);
        mainButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mainButton.setFocusable(false);
        mainButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mainButton.setIconTextGap(25);
        mainButton.setName(""); // NOI18N
        mainButton.setOpaque(true);
        mainButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mainButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mainButtonMouseExited(evt);
            }
        });
        nav.add(mainButton);

        parkingBtn.setBackground(new java.awt.Color(51, 51, 51));
        parkingBtn.setForeground(new java.awt.Color(255, 255, 255));
        parkingBtn.setText("Parqueaderos");
        parkingBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        parkingBtn.setBorderPainted(false);
        parkingBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        parkingBtn.setFocusable(false);
        parkingBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        parkingBtn.setIconTextGap(23);
        parkingBtn.setMaximumSize(new java.awt.Dimension(179, 41));
        parkingBtn.setMinimumSize(new java.awt.Dimension(179, 41));
        parkingBtn.setName(""); // NOI18N
        parkingBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                parkingBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                parkingBtnMouseExited(evt);
            }
        });
        parkingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parkingBtnActionPerformed(evt);
            }
        });
        nav.add(parkingBtn);

        ticketsBtn.setBackground(new java.awt.Color(51, 51, 51));
        ticketsBtn.setForeground(new java.awt.Color(255, 255, 255));
        ticketsBtn.setText("Tickets");
        ticketsBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ticketsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ticketsBtn.setFocusable(false);
        ticketsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ticketsBtn.setIconTextGap(24);
        ticketsBtn.setMaximumSize(new java.awt.Dimension(179, 41));
        ticketsBtn.setMinimumSize(new java.awt.Dimension(179, 41));
        ticketsBtn.setName(""); // NOI18N
        ticketsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ticketsBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ticketsBtnMouseExited(evt);
            }
        });
        ticketsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketsBtnActionPerformed(evt);
            }
        });
        nav.add(ticketsBtn);

        usersBtn.setBackground(new java.awt.Color(51, 51, 51));
        usersBtn.setForeground(new java.awt.Color(255, 255, 255));
        usersBtn.setText("Usuarios");
        usersBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        usersBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usersBtn.setFocusable(false);
        usersBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        usersBtn.setIconTextGap(24);
        usersBtn.setMaximumSize(new java.awt.Dimension(179, 41));
        usersBtn.setMinimumSize(new java.awt.Dimension(179, 41));
        usersBtn.setName(""); // NOI18N
        usersBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usersBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                usersBtnMouseExited(evt);
            }
        });
        usersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersBtnActionPerformed(evt);
            }
        });
        nav.add(usersBtn);

        vehiclesBtn.setBackground(new java.awt.Color(51, 51, 51));
        vehiclesBtn.setForeground(new java.awt.Color(255, 255, 255));
        vehiclesBtn.setText("Vehiculos");
        vehiclesBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        vehiclesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vehiclesBtn.setFocusable(false);
        vehiclesBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vehiclesBtn.setIconTextGap(20);
        vehiclesBtn.setMaximumSize(new java.awt.Dimension(179, 41));
        vehiclesBtn.setMinimumSize(new java.awt.Dimension(179, 41));
        vehiclesBtn.setName(""); // NOI18N
        vehiclesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vehiclesBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vehiclesBtnMouseExited(evt);
            }
        });
        vehiclesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehiclesBtnActionPerformed(evt);
            }
        });
        nav.add(vehiclesBtn);

        cerrarSesion.setBackground(new java.awt.Color(51, 51, 51));
        cerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        cerrarSesion.setText("Cerrar sesion");
        cerrarSesion.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarSesion.setFocusable(false);
        cerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cerrarSesion.setIconTextGap(20);
        cerrarSesion.setMaximumSize(new java.awt.Dimension(179, 41));
        cerrarSesion.setMinimumSize(new java.awt.Dimension(179, 41));
        cerrarSesion.setName(""); // NOI18N
        cerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cerrarSesionMouseExited(evt);
            }
        });
        cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionActionPerformed(evt);
            }
        });
        nav.add(cerrarSesion);

        getContentPane().add(nav, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 50, 500, 50));

        topNav.setBackground(new java.awt.Color(43, 43, 43));

        navLogo.setForeground(new java.awt.Color(255, 255, 255));
        navLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkingapp/resources/images/parkingLogod-removebg.png"))); // NOI18N

        currentUserText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        currentUserText.setForeground(new java.awt.Color(210, 210, 210));
        currentUserText.setText("Usuario:");

        currentUser.setForeground(new java.awt.Color(210, 210, 210));
        currentUser.setText("{usuario}");

        javax.swing.GroupLayout topNavLayout = new javax.swing.GroupLayout(topNav);
        topNav.setLayout(topNavLayout);
        topNavLayout.setHorizontalGroup(
            topNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topNavLayout.createSequentialGroup()
                .addComponent(navLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 695, Short.MAX_VALUE)
                .addComponent(currentUserText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentUser, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topNavLayout.setVerticalGroup(
            topNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topNavLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentUserText)
                    .addComponent(currentUser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(navLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(topNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1001, 100));

        contentPanel.setBackground(new java.awt.Color(43, 43, 43));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1001, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        getContentPane().add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 112, 1001, 496));

        relleno2.setBackground(java.awt.Color.darkGray);

        javax.swing.GroupLayout relleno2Layout = new javax.swing.GroupLayout(relleno2);
        relleno2.setLayout(relleno2Layout);
        relleno2Layout.setHorizontalGroup(
            relleno2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1001, Short.MAX_VALUE)
        );
        relleno2Layout.setVerticalGroup(
            relleno2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(relleno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 8, 1001, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void parkingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parkingBtnActionPerformed
        System.out.println("Boton parking");
        statusVerification();
        parkingBtn.setBackground(new java.awt.Color(90, 90, 90));
        
        if (pastButton!=parkingBtn)
            pastButton.setBackground(new java.awt.Color(51, 51, 51));
        
        pastButton = parkingBtn;
        
        contentPanel.removeAll();
        PanelParking parkingPanel = new PanelParking(dataUser);
        parkingPanel.setSize(contentPanel.getSize());
        
        contentPanel.add(parkingPanel);

        this.repaint();
        this.revalidate();
    }//GEN-LAST:event_parkingBtnActionPerformed

    private void mainButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainButtonMouseClicked
        System.out.println("Boton inicio");
        statusVerification();
        mainButton.setBackground(new java.awt.Color(90, 90, 90));

        if (pastButton!=mainButton)
            pastButton.setBackground(new java.awt.Color(51, 51, 51));
        pastButton = mainButton;
        
        contentPanel.removeAll();
        
        MainPanel mainPanel = new MainPanel(dataUser);
        mainPanel.setSize(contentPanel.getSize());

        contentPanel.add(mainPanel);

        this.repaint();
        this.revalidate();
    }//GEN-LAST:event_mainButtonMouseClicked

    private void ticketsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketsBtnActionPerformed
        mainTickets();
    }//GEN-LAST:event_ticketsBtnActionPerformed
    
    public void mainTickets(){
        System.out.println("Boton tickets");
        statusVerification();
        ticketsBtn.setBackground(new java.awt.Color(90, 90, 90));
        
        if (pastButton!=ticketsBtn)
            pastButton.setBackground(new java.awt.Color(51, 51, 51));
        
        pastButton = ticketsBtn;
        
        contentPanel.removeAll();
        PanelTickets ticketPanel = new PanelTickets(dataUser, this);
        ticketPanel.setSize(contentPanel.getSize());
        
        contentPanel.add(ticketPanel);


        this.repaint();
        this.revalidate();
    }
    
    private void usersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersBtnActionPerformed
        System.out.println("Boton users");
        usersBtn.setBackground(new java.awt.Color(90, 90, 90));
        
        if (pastButton!=usersBtn)
            pastButton.setBackground(new java.awt.Color(51, 51, 51));
        
        pastButton = usersBtn;
        
        contentPanel.removeAll();
        PanelUsers usersPanel = new PanelUsers(idUser,this);
        usersPanel.setSize(contentPanel.getSize());
        
        contentPanel.add(usersPanel);

        this.repaint();
        this.revalidate();
    }//GEN-LAST:event_usersBtnActionPerformed
    
    public void replacePanel(JPanel new_panel){
        contentPanel.removeAll();
        new_panel.setSize(contentPanel.getSize());
        contentPanel.add(new_panel);
        this.repaint();
        this.revalidate();
    }
    
    private void mainButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainButtonMouseEntered
        mainButton.setBackground(new java.awt.Color(90, 90, 90));
    }//GEN-LAST:event_mainButtonMouseEntered

    private void mainButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainButtonMouseExited
        if (pastButton!=mainButton)
            mainButton.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_mainButtonMouseExited

    private void parkingBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parkingBtnMouseEntered
        parkingBtn.setBackground(new java.awt.Color(90, 90, 90));
    }//GEN-LAST:event_parkingBtnMouseEntered

    private void parkingBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parkingBtnMouseExited
        if (pastButton!=parkingBtn)
            parkingBtn.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_parkingBtnMouseExited

    private void ticketsBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ticketsBtnMouseEntered
        ticketsBtn.setBackground(new java.awt.Color(90, 90, 90));
    }//GEN-LAST:event_ticketsBtnMouseEntered

    private void ticketsBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ticketsBtnMouseExited
        if (pastButton!=ticketsBtn)
            ticketsBtn.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_ticketsBtnMouseExited

    private void usersBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersBtnMouseEntered
        usersBtn.setBackground(new java.awt.Color(90, 90, 90));
    }//GEN-LAST:event_usersBtnMouseEntered

    private void usersBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersBtnMouseExited
        if (pastButton!=usersBtn)
            usersBtn.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_usersBtnMouseExited

    private void vehiclesBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vehiclesBtnMouseEntered
        vehiclesBtn.setBackground(new java.awt.Color(90, 90, 90));
    }//GEN-LAST:event_vehiclesBtnMouseEntered

    private void vehiclesBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vehiclesBtnMouseExited
        if (pastButton!=vehiclesBtn)
            vehiclesBtn.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_vehiclesBtnMouseExited

    private void cerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionMouseEntered
        cerrarSesion.setBackground(new java.awt.Color(90, 90, 90));
    }//GEN-LAST:event_cerrarSesionMouseEntered

    private void cerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionMouseExited
        cerrarSesion.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_cerrarSesionMouseExited

    private void cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionActionPerformed
        System.out.println("CERRAR SESION");
        LoginFrame login = new LoginFrame();
        setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_cerrarSesionActionPerformed

    private void vehiclesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehiclesBtnActionPerformed
        contentVehicle();
    }//GEN-LAST:event_vehiclesBtnActionPerformed
    
    public void contentVehicle(){
       System.out.println("Boton Vehiculos");
       statusVerification();
        vehiclesBtn.setBackground(new java.awt.Color(90, 90, 90));

        if (pastButton!=vehiclesBtn)
            pastButton.setBackground(new java.awt.Color(51, 51, 51));
        
        pastButton = vehiclesBtn;
        
        contentPanel.removeAll();
        PanelVehicles vechilesPanel = new PanelVehicles(dataUser, this);
        vechilesPanel.setSize(contentPanel.getSize());
        
        contentPanel.add(vechilesPanel);

        this.repaint();
        this.revalidate();
    }

    private void statusVerification(){
        try{
            Map<String, String> getData = new HashMap<>();
            getData.put("iduser", idUser);

            String datos = Herramientas.consumoGET("http://localhost/parkingAPI/users/getUser.php", getData);
            System.out.println("Datos: "+datos);
            if (datos.equals("")){
                Herramientas.alerta("Error al obtener los datos del usuario", false);
            }else{
                JsonObject jsonObject = JsonParser.parseString(datos).getAsJsonObject();

                JsonObject datosObject = jsonObject.getAsJsonObject("datos");
                String estado = datosObject.get("status").getAsString();

                String name = datosObject.get("name").getAsString();
                String email = datosObject.get("email").getAsString();
                String rol = datosObject.get("rol").getAsString();
                String statusUser = datosObject.get("status").getAsString();
                String parking = datosObject.get("parking_id").getAsString();

                //settear datos del usuario
                dataUser.setNombre(name);
                dataUser.setCorreo(email);
                dataUser.setRol(rol);
                dataUser.setEstado(statusUser);
                dataUser.setParking(parking);
            }
        } catch (Exception e){
            System.out.println("Error: "+e);
        }

        if (dataUser.getEstado().equals("activo")){
            if (dataUser.getRol().equals("admin")) {
                parkingBtn.setText("Parqueaderos");
                usersBtn.setVisible(true);
            } else {
                parkingBtn.setText("Parqueadero");
                usersBtn.setVisible(false);
            }
        }else{
            parkingBtn.setVisible(false);
            ticketsBtn.setVisible(false);
            usersBtn.setVisible(false);
            vehiclesBtn.setVisible(false);
            this.setVisible(false);
            LoginFrame login = new LoginFrame();
            login.setVisible(true);
            Herramientas.alerta("<html>Su cuenta esta inactiva, contacte con el administrador<html>", false);
        }
        System.out.println("Estado Usuario: "+dataUser.getEstado());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrarSesion;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel currentUser;
    private javax.swing.JLabel currentUserText;
    private javax.swing.JButton mainButton;
    private javax.swing.JPanel nav;
    private javax.swing.JLabel navLogo;
    private javax.swing.JButton parkingBtn;
    private javax.swing.JPanel relleno2;
    private javax.swing.JButton ticketsBtn;
    private javax.swing.JPanel topNav;
    private javax.swing.JButton usersBtn;
    private javax.swing.JButton vehiclesBtn;
    // End of variables declaration//GEN-END:variables

    private void ticketsBtnActionPerformed() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
