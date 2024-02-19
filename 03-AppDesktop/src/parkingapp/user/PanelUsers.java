
package parkingapp.user;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import parkingapp.MainFrame;
import parkingapp.util.Herramientas;



public class PanelUsers extends javax.swing.JPanel {
    Herramientas consumo ;
    DefaultTableModel model;
    
    private ArrayList<User> activeUsers;
    private ArrayList<User> inactiveUsers;
    private ArrayList<User> assignedUsers;
    private ArrayList<User> noassignedUsers;
    MainFrame frame;
    String idUser;
    String filtro;

    public PanelUsers(String idUser,MainFrame frame) {
        consumo = new Herramientas() {};
        activeUsers = new ArrayList<>();
        noassignedUsers = new ArrayList<>();
        inactiveUsers= new ArrayList<>();
        assignedUsers=new ArrayList<>();
        
        this.idUser=idUser;
        this.frame=frame;
        initComponents();
        initAlterComponents();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableUsers = new javax.swing.JTable();
        btnCrearUser = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(43, 43, 43));
        setPreferredSize(new java.awt.Dimension(1001, 496));

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));
        jPanel1.setFocusable(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(808, 509));

        LabelTitulo.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(210, 210, 210));
        LabelTitulo.setText("USUARIOS");

        TableUsers.setBackground(new java.awt.Color(102, 102, 102));
        TableUsers.setForeground(new java.awt.Color(255, 255, 255));
        TableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CEDULA", "NOMBRE", "CORREO", "ROL", "ESTADO", "Editar", "Eliminar", "Asignar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableUsers);
        if (TableUsers.getColumnModel().getColumnCount() > 0) {
            TableUsers.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        btnCrearUser.setBackground(new java.awt.Color(33, 150, 243));
        btnCrearUser.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        btnCrearUser.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearUser.setText("CREAR USUARIO");
        btnCrearUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUserActionPerformed(evt);
            }
        });

        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activos", "Inactivos", "Asignados", "Sin asignacion", " ", " " }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(LabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrearUser, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(LabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247)
                        .addComponent(btnCrearUser)))
                .addGap(90, 90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUserActionPerformed
        PanelCrearUser temporaryPanel = new PanelCrearUser(idUser,frame);
        this.frame.replacePanel(temporaryPanel);
    }//GEN-LAST:event_btnCrearUserActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        filtro = jComboBox1.getSelectedItem().toString();
        
        switch (filtro) {
            case "Activos":
               mostrarUsuariosEnTabla(activeUsers);
                break;
            case "Inactivos":
                mostrarUsuariosEnTabla(inactiveUsers);
                break;
            case "Asignados":
                
                mostrarUsuariosEnTabla(assignedUsers);
                break;
            case"Sin asignacion":
                mostrarUsuariosEnTabla(noassignedUsers);
                break;
        default:
            // Puedes manejar otros casos o dejarlos en blanco según sea necesario.
            break;
    }
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    public void initAlterComponents() {
        
        setupTable();
        llenarArreglos();
        //Image img_logo= getToolkit().createImage(ClassLoader.getSystemResource("parkingapp.resources.images/logo_parking.PNG"));
        //img_logo = img_logo.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        //LabelLogo.setIcon(new ImageIcon(img_logo));
    }

    public void setupTable() {
        model = (DefaultTableModel) this.TableUsers.getModel();
        Object[] columnNames = {"CEDULA", "NOMBRE", "CORREO", "ROL","ESTADO", "Editar", "Eliminar", "Asignar"};
        model = new DefaultTableModel(columnNames, 0) {
            public boolean isCellEditable(int row, int column) {
                // Hacer que las celdas de las columnas con botones sean editables
                if (column == TableUsers.getColumn("Editar").getModelIndex() || 
                    column == TableUsers.getColumn("Eliminar").getModelIndex() ||
                    column == TableUsers.getColumn("Asignar").getModelIndex()) {
                    return true;
                } else {
                    // Hacer que las demás celdas no sean editables
                    return false;
                }
            }
        };
        TableUsers.setModel(model);
        
        this.TableUsers.getTableHeader().setReorderingAllowed(false);
        this.TableUsers.getTableHeader().setResizingAllowed(false);
        this.TableUsers.getColumn("Editar").setCellRenderer(new ButtonRenderer());
        this.TableUsers.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox()));
        this.TableUsers.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        this.TableUsers.getColumn("Eliminar").setCellEditor(new ButtonEditor(new JCheckBox()));
        this.TableUsers.getColumn("Asignar").setCellRenderer(new ButtonRenderer());
        this.TableUsers.getColumn("Asignar").setCellEditor(new ButtonEditor(new JCheckBox()));
        this.TableUsers.getTableHeader().setReorderingAllowed(false);
        this.TableUsers.getTableHeader().setBackground(Color.decode("#2196F3"));
        this.TableUsers.getTableHeader().setForeground(Color.BLACK);
    }

    public void llenarArreglos() {
        
         
        String consult = consumo.consumoGET("http://localhost/parkingAPI/users/getUsers.php");
        Gson gson = new Gson();

        // Parsear la respuesta JSON
        JsonObject jsonObject = JsonParser.parseString(consult).getAsJsonObject();
        JsonArray usersArray = jsonObject.getAsJsonArray("users");
        
        for (JsonElement element : usersArray) {
            JsonObject userObject = element.getAsJsonObject();
            int id = userObject.get("id").getAsInt();
            
            String nombre = userObject.get("name").getAsString();
            String correo = userObject.get("email").getAsString();
            String rol = userObject.get("rol").getAsString();
            String estado = userObject.get("status").getAsString();
            String parking = "0";
            User user = new User(id, nombre, correo, rol, estado, parking);
            
            String consultparkins = consumo.consumoGET("http://localhost/parkingAPI/parking_seller/getParkingSellers.php");
        
            // Separar usuarios activos e inactivos
            if(rol.contentEquals("seller")){
                if (estado.equals("activo")) {
                    activeUsers.add(user);
                } else if (estado.equals("inactivo")) {
                    inactiveUsers.add(user);
                }
                
                
                JsonObject jsonObjectps = JsonParser.parseString(consultparkins).getAsJsonObject();
                JsonArray usersparkin = jsonObjectps.getAsJsonArray("parking_seller");
                int cont=0;
                for (JsonElement useren : usersparkin) {
                    JsonObject userParkinObject = useren.getAsJsonObject();
                    int user_id = userParkinObject.get("user_id").getAsInt();

                    if(user_id==id){
                        assignedUsers.add(user);
                        cont++;
                        break;
                    }
                }
                if(cont==0){
                  noassignedUsers.add(user);  
                }else{
                    
                }
                
                
                 
                
            }
            
            
        }
        

        
        mostrarUsuariosEnTabla(activeUsers);
    }
    
    public void mostrarUsuariosEnTabla(ArrayList<User> users) {
        model.setRowCount(0); // Limpiar la tabla
        String consultparkins = consumo.consumoGET("http://localhost/parkingAPI/parking_seller/getParkingSellers.php");
        
        for (User user : users) {
            
            String textbtn=new String();
            if(user.getEstado().equals("activo")){
                textbtn="disable";
            }else{
                textbtn="enable";
            }
            JButton btnEditar = new JButton("editar");
            JButton btnEliminar = new JButton(textbtn);
            JButton btnAsignar = new JButton("Asignar");
            btnEditar.setBackground(new Color(255,183,77));
            
            btnEliminar.setBackground(new Color(255,107,107));
            btnEditar.setFocusable(false);
            btnEliminar.setFocusable(false);
            btnAsignar.setFocusable(false);
            
            JsonObject jsonObjectps = JsonParser.parseString(consultparkins).getAsJsonObject();
            JsonArray usersparkin = jsonObjectps.getAsJsonArray("parking_seller");
            int cont=0;
            for (JsonElement useren : usersparkin) {
                JsonObject userParkinObject = useren.getAsJsonObject();
                int user_id = userParkinObject.get("user_id").getAsInt();

                if(user_id==user.getId()){

                    cont++;
                    break;
                }
            }
            
            
            
            
            
            ActionListener editar = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    editarActionPerfofed(user);
                }
            };
            
            btnEditar.addActionListener(editar);



            
            ActionListener eliminarListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    eliminarActionPerfofed(user, btnEliminar);
                }
            };
            
            
            btnEliminar.addActionListener(eliminarListener);

            // Luego, para eliminar el ActionListener
            
            if(user.getEstado().equals("activo")){
                ActionListener asignarListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        asignarActionPerfofed(user);
                    }
                };

                btnAsignar.removeActionListener(asignarListener);
                btnAsignar.addActionListener(asignarListener);

                // Luego, para eliminar el ActionListener
                
               
            }
            
            if (jComboBox1.getSelectedItem().equals("Asignados")) {
                btnAsignar.setEnabled(false);
                btnEditar.setEnabled(false);
                btnEliminar.setEnabled(false);
            } else {
                btnAsignar.setEnabled(true);
                btnEditar.setEnabled(true);
                btnEliminar.setEnabled(true);
            }
            
            if(cont==0){
              
                if(user.getEstado().equals("inactivo")){
                    btnAsignar.setEnabled(false);
                
                }else{
                    btnAsignar.setEnabled(true);
                }
            }else{
                btnAsignar.setEnabled(false);
            }
           
            
            model.addRow(new Object[]{user.getId(),user.getNombre(), user.getCorreo(), user.getRol(), user.getEstado(),btnEditar,btnEliminar,btnAsignar});
        }
    }
    
    public void editarActionPerfofed(User temp){
        PanelEditarUser temporaryPanel = new PanelEditarUser(temp,frame);
        this.frame.replacePanel(temporaryPanel);
    }
    public void eliminarActionPerfofed(User temp,JButton boton){
        int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "¿Estás seguro de que deseas eliminar a este usuario?",
            "Confirmación de Eliminación",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            int id=temp.getId();
            String estado=new String();
            if(temp.getEstado().equals("inactivo")){
                estado="activo";
            }else if(temp.getEstado().equals("activo")){
                estado="inactivo";
            }
            String idString = String.valueOf(id);
            Map<String, String> insertData = new HashMap<>();
            insertData.put("iduser", idString);
            insertData.put("name", temp.getNombre());
            insertData.put("email", temp.getCorreo());
            insertData.put("status", estado);
            insertData.put("rol", temp.getRol());

            String actualizar=Herramientas.insert("http://localhost/parkingAPI/users/Update.php", insertData);
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
                    //PanelCrearUser temporaryPanel = new PanelCrearUser(idUser,frame);
                    
                    
                    if (estado.equals("activo")) {
                        for (int i=0; i<inactiveUsers.size(); i++) {
                            if ( inactiveUsers.get(i).equals(temp) ) {
                                User intercambio = inactiveUsers.get(i);
                                intercambio.setEstado(estado);
                                inactiveUsers.remove(temp);
                                activeUsers.add(intercambio);
                                boton.setText("disable");
                                for (int j=0; j<assignedUsers.size(); j++) {
                                    if ( assignedUsers.get(j).equals(temp) ) {
                                        User assignedUser = assignedUsers.get(j);
                                        assignedUser.setEstado(estado);
                                        assignedUsers.set(j, assignedUser);

                                        break;
                                    }
                                }
                                for (int j=0; j<noassignedUsers.size(); j++) {
                                    if ( noassignedUsers.get(j).equals(temp) ) {
                                        User assignedUser = noassignedUsers.get(j);
                                        assignedUser.setEstado(estado);
                                        noassignedUsers.set(j, assignedUser);

                                        break;
                                    }
                                }

                                
                                break;
                            }
                        }
                        jComboBox1.setSelectedItem("Activos");

                        setupTable() ;
                        mostrarUsuariosEnTabla(activeUsers);
                        
                    }else if(estado.equals("inactivo")){
                        for (int i=0; i<activeUsers.size(); i++) {
                            if ( activeUsers.get(i).equals(temp) ) {
                                User intercambio = activeUsers.get(i);
                                intercambio.setEstado(estado);
                                activeUsers.remove(temp);
                                inactiveUsers.add(intercambio);
                                boton.setText("enable");
                                for (int j=0; j<assignedUsers.size(); j++) {
                                    if ( assignedUsers.get(j).equals(temp) ) {
                                        User assignedUser = assignedUsers.get(j);
                                        assignedUser.setEstado(estado);
                                        assignedUsers.set(j, assignedUser);

                                        break;
                                    }
                                }
                                for (int j=0; j<noassignedUsers.size(); j++) {
                                    if ( noassignedUsers.get(j).equals(temp) ) {
                                        User assignedUser = noassignedUsers.get(j);
                                        assignedUser.setEstado(estado);
                                        noassignedUsers.set(j, assignedUser);

                                        break;
                                    }
                                }
                                
                                break;
                            }
                        }
                        jComboBox1.setSelectedItem("Inactivos");
                        setupTable() ;
                        mostrarUsuariosEnTabla(inactiveUsers);
                        
                    }
                }else{
                    Herramientas.alerta(message, false);
                }

            }else{
                Herramientas.alerta("No se pudo editar el usuario", false);
            }

        }
      
    
    }
    
    public void asignarActionPerfofed(User temp){
        System.out.println("se dio click");
        AsignarUserParking panelasignar = new AsignarUserParking(temp,frame);
        this.frame.replacePanel(panelasignar);
    }






    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JTable TableUsers;
    private javax.swing.JButton btnCrearUser;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
