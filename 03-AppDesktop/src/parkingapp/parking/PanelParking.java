package parkingapp.parking;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.awt.GridBagConstraints;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import parkingapp.user.User;
import parkingapp.util.Herramientas;
import parkingapp.Config;

public class PanelParking extends javax.swing.JPanel {
    
    private final User dataUser;
    private Config dataConfig;

    public PanelParking(User userData) {
        this.dataUser = userData;
        initComponents();
        String rol = dataUser.getRol();
        dataConfig = new Config();

        if (rol.equals("admin")) {
            getParkings();
        } else {
            getParking(dataUser.getParking());
        }
            
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanelParkings = new javax.swing.JPanel();
        scrollPaneParkings = new javax.swing.JScrollPane();
        listParkings = new javax.swing.JPanel();
        cardParking = new javax.swing.JPanel();
        detailsBtn = new javax.swing.JButton();
        parkingID = new javax.swing.JLabel();
        parkingAddress = new javax.swing.JLabel();
        parkingStatus = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        bikePrice = new javax.swing.JTextField();
        statusSelect = new javax.swing.JComboBox<>();
        priceTxt = new javax.swing.JLabel();
        bikeTxt = new javax.swing.JLabel();
        vanTxt = new javax.swing.JLabel();
        truckTxt = new javax.swing.JLabel();
        carTxt = new javax.swing.JLabel();
        addresInput = new javax.swing.JTextField();
        vanPrice = new javax.swing.JTextField();
        truckPrice = new javax.swing.JTextField();
        carPrice = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        nameInput = new javax.swing.JTextField();

        mainPanelParkings.setBackground(new java.awt.Color(43, 43, 43));

        scrollPaneParkings.setBackground(new java.awt.Color(43, 43, 43));
        scrollPaneParkings.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scrollPaneParkings.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneParkings.setAutoscrolls(true);

        listParkings.setBackground(new java.awt.Color(43, 43, 43));
        listParkings.setLayout(new java.awt.GridBagLayout());

        cardParking.setBackground(new java.awt.Color(51, 51, 51));
        cardParking.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 150, 243)));
        cardParking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cardParking.setMinimumSize(new java.awt.Dimension(200, 192));
        cardParking.setPreferredSize(new java.awt.Dimension(203, 192));
        cardParking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        detailsBtn.setBackground(new java.awt.Color(33, 150, 243));
        detailsBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        detailsBtn.setForeground(new java.awt.Color(255, 255, 255));
        detailsBtn.setText("Atras");
        detailsBtn.setToolTipText("");
        detailsBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        detailsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cardParking.add(detailsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, -1));

        parkingID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        parkingID.setForeground(new java.awt.Color(255, 255, 255));
        parkingID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        parkingID.setText("ID:");
        parkingID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(parkingID, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));

        parkingAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        parkingAddress.setForeground(new java.awt.Color(255, 255, 255));
        parkingAddress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        parkingAddress.setText("Direccion:");
        parkingAddress.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(parkingAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, -1, -1));

        parkingStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        parkingStatus.setForeground(new java.awt.Color(255, 255, 255));
        parkingStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        parkingStatus.setText("Estado:");
        parkingStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(parkingStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        idInput.setBackground(new java.awt.Color(102, 102, 102));
        idInput.setForeground(new java.awt.Color(255, 255, 255));
        idInput.setToolTipText("");
        idInput.setCaretColor(new java.awt.Color(255, 255, 255));
        idInput.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        idInput.setEnabled(false);
        cardParking.add(idInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 150, 30));

        bikePrice.setBackground(new java.awt.Color(102, 102, 102));
        bikePrice.setForeground(new java.awt.Color(255, 255, 255));
        bikePrice.setToolTipText("");
        bikePrice.setCaretColor(new java.awt.Color(255, 255, 255));
        bikePrice.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        bikePrice.setEnabled(false);
        cardParking.add(bikePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 150, 30));

        statusSelect.setBackground(new java.awt.Color(102, 102, 102));
        statusSelect.setForeground(new java.awt.Color(255, 255, 255));
        statusSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        statusSelect.setEnabled(false);
        cardParking.add(statusSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 150, 30));

        priceTxt.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        priceTxt.setForeground(new java.awt.Color(255, 255, 255));
        priceTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceTxt.setText("Precios");
        priceTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(priceTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 260, 30));

        bikeTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bikeTxt.setForeground(new java.awt.Color(255, 255, 255));
        bikeTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bikeTxt.setText("Moto:");
        bikeTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(bikeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, -1, -1));

        vanTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        vanTxt.setForeground(new java.awt.Color(255, 255, 255));
        vanTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vanTxt.setText("Camioneta:");
        vanTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(vanTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, -1, -1));

        truckTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        truckTxt.setForeground(new java.awt.Color(255, 255, 255));
        truckTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        truckTxt.setText("Camion:");
        truckTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(truckTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, -1));

        carTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        carTxt.setForeground(new java.awt.Color(255, 255, 255));
        carTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        carTxt.setText("Carro:");
        carTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(carTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, -1));

        addresInput.setBackground(new java.awt.Color(102, 102, 102));
        addresInput.setForeground(new java.awt.Color(255, 255, 255));
        addresInput.setToolTipText("");
        addresInput.setCaretColor(new java.awt.Color(255, 255, 255));
        addresInput.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        addresInput.setEnabled(false);
        cardParking.add(addresInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 150, 30));

        vanPrice.setBackground(new java.awt.Color(102, 102, 102));
        vanPrice.setForeground(new java.awt.Color(255, 255, 255));
        vanPrice.setToolTipText("");
        vanPrice.setCaretColor(new java.awt.Color(255, 255, 255));
        vanPrice.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        vanPrice.setEnabled(false);
        cardParking.add(vanPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 150, 30));

        truckPrice.setBackground(new java.awt.Color(102, 102, 102));
        truckPrice.setForeground(new java.awt.Color(255, 255, 255));
        truckPrice.setToolTipText("");
        truckPrice.setCaretColor(new java.awt.Color(255, 255, 255));
        truckPrice.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        truckPrice.setEnabled(false);
        cardParking.add(truckPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 150, 30));

        carPrice.setBackground(new java.awt.Color(102, 102, 102));
        carPrice.setForeground(new java.awt.Color(255, 255, 255));
        carPrice.setToolTipText("");
        carPrice.setCaretColor(new java.awt.Color(255, 255, 255));
        carPrice.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        carPrice.setEnabled(false);
        cardParking.add(carPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 150, 30));

        saveBtn.setBackground(new java.awt.Color(76, 175, 80));
        saveBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Guardar");
        saveBtn.setToolTipText("");
        saveBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.setEnabled(false);
        cardParking.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, 70, -1));

        editBtn.setBackground(new java.awt.Color(255, 183, 77));
        editBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("Editar");
        editBtn.setToolTipText("");
        editBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cardParking.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 80, -1));

        nameInput.setBackground(new java.awt.Color(102, 102, 102));
        nameInput.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nameInput.setForeground(new java.awt.Color(255, 255, 255));
        nameInput.setToolTipText("");
        nameInput.setCaretColor(new java.awt.Color(255, 255, 255));
        nameInput.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        nameInput.setEnabled(false);
        cardParking.add(nameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 260, 40));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 865;
        gridBagConstraints.ipady = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        listParkings.add(cardParking, gridBagConstraints);

        scrollPaneParkings.setViewportView(listParkings);

        javax.swing.GroupLayout mainPanelParkingsLayout = new javax.swing.GroupLayout(mainPanelParkings);
        mainPanelParkings.setLayout(mainPanelParkingsLayout);
        mainPanelParkingsLayout.setHorizontalGroup(
            mainPanelParkingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneParkings, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1077, Short.MAX_VALUE)
        );
        mainPanelParkingsLayout.setVerticalGroup(
            mainPanelParkingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneParkings, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanelParkings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanelParkings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void getParkings() {
        listParkings.removeAll();
        String endpoint = "/parking/getParkings.php";
        endpoint = dataConfig.getEndPoint(endpoint);
        String parkingsData = Herramientas.consumoGET(endpoint);

        JsonObject jsonObject = JsonParser.parseString(parkingsData).getAsJsonObject();
        JsonArray parkingsArray = jsonObject.getAsJsonArray("parkings");
        
        int gridWidth = 4;
        int row = 0;
        int col = 0;

        for (JsonElement element : parkingsArray) {
            JsonObject parkingObject = element.getAsJsonObject();
            String id = parkingObject.get("id").getAsString();
            String name = parkingObject.get("name").getAsString();
            String address = parkingObject.get("address").getAsString();
            String status = parkingObject.get("status").getAsString();
            
            JPanel cardParking = getCardParking(id, name, address, status);

            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridy = row;
            gridBagConstraints.ipadx = 6;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
            listParkings.add(cardParking, gridBagConstraints);
            
            col++;
            if (col == gridWidth) {
                row++;
                col = 0;
            }
        }
        listParkings.revalidate();
        listParkings.repaint();
    }

    private JPanel getCardParking(String id, String name, String address, String status) {

        JPanel cardParking = new javax.swing.JPanel();
        JLabel parkingName = new javax.swing.JLabel();
        JButton detailsBtn = new javax.swing.JButton();
        JLabel parkingID = new javax.swing.JLabel();
        JLabel parkingAddress = new javax.swing.JLabel();
        JLabel parkingStatus = new javax.swing.JLabel();
        JLabel parkingIDTxt = new javax.swing.JLabel();
        JLabel parkingAddressTxt = new javax.swing.JLabel();
        JLabel parkingStatusTxt = new javax.swing.JLabel();

        cardParking.setBackground(new java.awt.Color(60, 60, 60));
        cardParking.setMinimumSize(new java.awt.Dimension(203, 192));
        cardParking.setPreferredSize(new java.awt.Dimension(203, 192));
        cardParking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        cardParking.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 150, 243)));
        cardParking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cardParking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cardParking.setBackground(new java.awt.Color(80, 80, 80));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cardParking.setBackground(new java.awt.Color(60, 60, 60));
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getParking(id);
            }
        });
        parkingName.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        parkingName.setForeground(new java.awt.Color(255, 255, 255));
        parkingName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        parkingName.setText(name);
        cardParking.add(parkingName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 38));

        detailsBtn.setBackground(new java.awt.Color(33, 150, 243));
        detailsBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        detailsBtn.setForeground(new java.awt.Color(255, 255, 255));
        detailsBtn.setText("detalles");
        detailsBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        detailsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        detailsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cardParking.setBackground(new java.awt.Color(80, 80, 80));
                detailsBtn.setBackground(new java.awt.Color(33, 110, 243));
                cardParking.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 110, 243)));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                cardParking.setBackground(new java.awt.Color(60, 60, 60));
                detailsBtn.setBackground(new java.awt.Color(33, 150, 243));
                cardParking.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 150, 243)));
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getParking(id);
            }
        });
        cardParking.add(detailsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 152, 209, -1));

        parkingID.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        parkingID.setForeground(new java.awt.Color(255, 255, 255));
        parkingID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        parkingID.setText("ID:");
        parkingID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        cardParking.add(parkingID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 44, 70, 30));

        parkingAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        parkingAddress.setForeground(new java.awt.Color(255, 255, 255));
        parkingAddress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        parkingAddress.setText("Direccion:");
        parkingAddress.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        cardParking.add(parkingAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 75, 30));

        parkingStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        parkingStatus.setForeground(new java.awt.Color(255, 255, 255));
        parkingStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        parkingStatus.setText("Estado:");
        parkingStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        cardParking.add(parkingStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 116, 70, 30));

        parkingIDTxt.setForeground(new java.awt.Color(255, 255, 255));
        parkingIDTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        parkingIDTxt.setText(id);
        cardParking.add(parkingIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 44, 133, 30));

        parkingAddressTxt.setForeground(new java.awt.Color(255, 255, 255));
        parkingAddressTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        parkingAddressTxt.setText(address);
        cardParking.add(parkingAddressTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 80, 133, 30));

        parkingStatusTxt.setForeground(new java.awt.Color(255, 255, 255));
        parkingStatusTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        parkingStatusTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkingapp/resources/images/icon-status-"+status+"-30.png"))); 
        parkingStatusTxt.setToolTipText(status);
        cardParking.add(parkingStatusTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 116, 133, 30));

        return cardParking;
    }

    private void getParking(String idParking){
        System.out.println("Obteniendo parking con id: "+idParking+"...");
        String endpoint = "/parking/getParking.php?id=";
        endpoint = dataConfig.getEndPoint(endpoint);
        String parkingData = Herramientas.consumoGET(endpoint+idParking);
        System.out.println(parkingData);
        JsonObject jsonObject = JsonParser.parseString(parkingData).getAsJsonObject();
        System.out.println(jsonObject);
        JsonObject parkingObject = jsonObject.getAsJsonObject("datos");
        System.out.println(parkingObject);
        String id = parkingObject.get("id").getAsString();
        String name = parkingObject.get("name").getAsString();
        String address = parkingObject.get("address").getAsString();
        String status = parkingObject.get("status").getAsString();
        String van = parkingObject.get("camioneta").getAsString();
        String truck = parkingObject.get("camion").getAsString();
        String car = parkingObject.get("carro").getAsString();
        String bike = parkingObject.get("moto").getAsString();

        JPanel panelParking = getCardParking(id, name, address, status, van, truck, car, bike);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.ipadx = 800;
        gridBagConstraints.ipady = 290;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 0);
        listParkings.removeAll();
        listParkings.add(panelParking, gridBagConstraints);
        listParkings.revalidate();
        listParkings.repaint();
    }

    private JPanel getCardParking(String id, String name, String address, String status, String van, String truck, String car, String bike) {

        JPanel cardParking = new javax.swing.JPanel();
        JLabel parkingName = new javax.swing.JLabel();
        JButton detailsBtn = new javax.swing.JButton();
        JLabel parkingID = new javax.swing.JLabel();
        JLabel parkingAddress = new javax.swing.JLabel();
        JLabel parkingStatus = new javax.swing.JLabel();
        JLabel parkingIDTxt = new javax.swing.JLabel();
        JLabel parkingAddressTxt = new javax.swing.JLabel();
        JLabel parkingStatusTxt = new javax.swing.JLabel();
        JTextField idInput = new javax.swing.JTextField();
        JTextField bikePrice = new javax.swing.JTextField();
        JComboBox<String> statusSelect = new javax.swing.JComboBox<>();
        JLabel priceTxt = new javax.swing.JLabel();
        JLabel bikeTxt = new javax.swing.JLabel();
        JLabel vanTxt = new javax.swing.JLabel();
        JLabel truckTxt = new javax.swing.JLabel();
        JLabel carTxt = new javax.swing.JLabel();
        JTextField addresInput = new javax.swing.JTextField();
        JTextField vanPrice = new javax.swing.JTextField();
        JTextField truckPrice = new javax.swing.JTextField();
        JTextField carPrice = new javax.swing.JTextField();
        JButton saveBtn = new javax.swing.JButton();
        JButton editBtn = new javax.swing.JButton();

        cardParking.setBackground(new java.awt.Color(43, 43, 43));
        cardParking.setMinimumSize(new java.awt.Dimension(200, 192));
        cardParking.setPreferredSize(new java.awt.Dimension(203, 192));
        cardParking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        detailsBtn.setBackground(new java.awt.Color(33, 150, 243));
        detailsBtn.setFont(new java.awt.Font("Segoe UI", 0, 14));
        detailsBtn.setForeground(new java.awt.Color(255, 255, 255));
        detailsBtn.setText("Atras");
        detailsBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        detailsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        detailsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                detailsBtn.setBackground(new java.awt.Color(33, 110, 243));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                detailsBtn.setBackground(new java.awt.Color(33, 150, 243));
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getParkings();
            }
        });
        if (dataUser.getRol().equals("admin")) {
            detailsBtn.setVisible(true);
        } else {
            detailsBtn.setVisible(false);
        }

        cardParking.add(detailsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, -1));

        parkingID.setFont(new java.awt.Font("Segoe UI", 0, 18));
        parkingID.setForeground(new java.awt.Color(255, 255, 255));
        parkingID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        parkingID.setText("ID:");
        parkingID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(parkingID, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        parkingAddress.setFont(new java.awt.Font("Segoe UI", 0, 18));
        parkingAddress.setForeground(new java.awt.Color(255, 255, 255));
        parkingAddress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        parkingAddress.setText("Direccion:");
        parkingAddress.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(parkingAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        parkingStatus.setFont(new java.awt.Font("Segoe UI", 0, 18));
        parkingStatus.setForeground(new java.awt.Color(255, 255, 255));
        parkingStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        parkingStatus.setText("Estado:");
        parkingStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(parkingStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, -1));

        idInput.setBackground(new java.awt.Color(102, 102, 102));
        idInput.setForeground(new java.awt.Color(255, 255, 255));
        idInput.setText(id);
        idInput.setCaretColor(new java.awt.Color(255, 255, 255));
        idInput.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        idInput.setEnabled(false);
        cardParking.add(idInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 150, 30));

        bikePrice.setBackground(new java.awt.Color(102, 102, 102));
        bikePrice.setForeground(new java.awt.Color(255, 255, 255));
        bikePrice.setText(bike);
        bikePrice.setCaretColor(new java.awt.Color(255, 255, 255));
        bikePrice.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        bikePrice.setEnabled(false);
        cardParking.add(bikePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 150, 30));

        statusSelect.setForeground(new java.awt.Color(255, 255, 255));
        statusSelect.setBackground(new java.awt.Color(102, 102, 102));
        statusSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo" }));
        statusSelect.setEnabled(false);
        statusSelect.setSelectedItem(status);
        statusSelect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cardParking.add(statusSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 150, 30));

        priceTxt.setFont(new java.awt.Font("Segoe UI", 0, 24));
        priceTxt.setForeground(new java.awt.Color(255, 255, 255));
        priceTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceTxt.setText("Precios");
        priceTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(priceTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 260, 30));

        bikeTxt.setFont(new java.awt.Font("Segoe UI", 0, 18));
        bikeTxt.setForeground(new java.awt.Color(255, 255, 255));
        bikeTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bikeTxt.setText("Moto:");
        bikeTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(bikeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, -1, -1));

        vanTxt.setFont(new java.awt.Font("Segoe UI", 0, 18));
        vanTxt.setForeground(new java.awt.Color(255, 255, 255));
        vanTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vanTxt.setText("Camioneta:");
        vanTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(vanTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, -1));

        truckTxt.setFont(new java.awt.Font("Segoe UI", 0, 18));
        truckTxt.setForeground(new java.awt.Color(255, 255, 255));
        truckTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        truckTxt.setText("Camion:");
        truckTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(truckTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, -1, -1));

        carTxt.setFont(new java.awt.Font("Segoe UI", 0, 18));
        carTxt.setForeground(new java.awt.Color(255, 255, 255));
        carTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        carTxt.setText("Carro:");
        carTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        cardParking.add(carTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, -1, -1));

        addresInput.setBackground(new java.awt.Color(102, 102, 102));
        addresInput.setForeground(new java.awt.Color(255, 255, 255));
        addresInput.setText(address);
        addresInput.setCaretColor(new java.awt.Color(255, 255, 255));
        addresInput.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        addresInput.setEnabled(false);
        cardParking.add(addresInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 150, 30));

        vanPrice.setBackground(new java.awt.Color(102, 102, 102));
        vanPrice.setForeground(new java.awt.Color(255, 255, 255));
        vanPrice.setText(van);
        vanPrice.setCaretColor(new java.awt.Color(255, 255, 255));
        vanPrice.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        vanPrice.setEnabled(false);
        cardParking.add(vanPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 150, 30));

        truckPrice.setBackground(new java.awt.Color(102, 102, 102));
        truckPrice.setForeground(new java.awt.Color(255, 255, 255));
        truckPrice.setText(truck);
        truckPrice.setCaretColor(new java.awt.Color(255, 255, 255));
        truckPrice.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        truckPrice.setEnabled(false);
        cardParking.add(truckPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 150, 30));

        carPrice.setBackground(new java.awt.Color(102, 102, 102));
        carPrice.setForeground(new java.awt.Color(255, 255, 255));
        carPrice.setText(car);
        carPrice.setCaretColor(new java.awt.Color(255, 255, 255));
        carPrice.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        carPrice.setEnabled(false);
        cardParking.add(carPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 150, 30));

        nameInput.setBackground(new java.awt.Color(102, 102, 102));
        nameInput.setFont(new java.awt.Font("Segoe UI", 0, 24)); 
        nameInput.setForeground(new java.awt.Color(255, 255, 255));
        nameInput.setCaretColor(new java.awt.Color(255, 255, 255));
        nameInput.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        nameInput.setText(name);
        nameInput.setEnabled(false);
        cardParking.add(nameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 260, 40));
        
        saveBtn.setBackground(new java.awt.Color(76, 175, 80));
        saveBtn.setFont(new java.awt.Font("Segoe UI", 0, 14));
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Guardar");
        saveBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.setEnabled(false);
        saveBtn.setVisible(false);
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String idUpdate = idInput.getText();
                String nameUpdate = nameInput.getText();
                String addressUpdate = addresInput.getText();
                String statusUpdate = statusSelect.getSelectedItem().toString();
                String vanUpdate = vanPrice.getText();
                String truckUpdate = truckPrice.getText();
                String carUpdate = carPrice.getText();
                String bikeUpdate = bikePrice.getText();

                Map<String, String> postData = new HashMap<>();
                postData.put("id", idUpdate);
                postData.put("name", nameUpdate);
                postData.put("address", addressUpdate);
                postData.put("status", statusUpdate);
                postData.put("camioneta", vanUpdate);
                postData.put("camion", truckUpdate);
                postData.put("carro", carUpdate);
                postData.put("moto", bikeUpdate);
                String endpoint = "/parking/updateParking.php";
                endpoint = dataConfig.getEndPoint(endpoint);
                String response = Herramientas.consumoPOST(endpoint, postData);
                System.out.println(response);
                System.out.println("Datos a guardar: "+id+" "+address+" "+status+" "+van+" "+truck+" "+car+" "+bike);
                
                JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
                System.out.println("Json: ");
                System.out.println(jsonObject);
                boolean status = jsonObject.get("status").getAsBoolean();
                System.out.println("Status: ");
                System.out.println(status);
                String message = jsonObject.get("mesagge").getAsString();
                System.out.println("Mesagge: ");
                System.out.println(message);
                if (status){
                    if (dataUser.getRol().equals("admin")) {
                        getParkings();
                    } else {
                        getParking(id);
                    }
                    Herramientas.alerta(message,true);
                } else {
                    Herramientas.alerta(message,false);
                }
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveBtn.setBackground(new java.awt.Color(56, 142, 60));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveBtn.setBackground(new java.awt.Color(76, 175, 80));
            }
        });
        cardParking.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, 70, -1));

        editBtn.setBackground(new java.awt.Color(255, 183, 77));
        editBtn.setFont(new java.awt.Font("Segoe UI", 0, 14));
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("Editar");
        editBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (dataUser.getRol().equals("admin")) {
                    nameInput.setEnabled(true);
                    addresInput.setEnabled(true);
                    statusSelect.setEnabled(true);
                } else {
                    vanPrice.setEnabled(true);
                    truckPrice.setEnabled(true);
                    carPrice.setEnabled(true);
                    bikePrice.setEnabled(true);
                }
                saveBtn.setEnabled(true);
                saveBtn.setVisible(true);
                editBtn.setVisible(false);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editBtn.setBackground(new java.awt.Color(255, 153, 51));        
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editBtn.setBackground(new java.awt.Color(255, 183, 77));
            }
        });
        cardParking.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 80, -1));

        return cardParking;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addresInput;
    private javax.swing.JTextField bikePrice;
    private javax.swing.JLabel bikeTxt;
    private javax.swing.JTextField carPrice;
    private javax.swing.JLabel carTxt;
    private javax.swing.JPanel cardParking;
    private javax.swing.JButton detailsBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField idInput;
    private javax.swing.JPanel listParkings;
    private javax.swing.JPanel mainPanelParkings;
    private javax.swing.JTextField nameInput;
    private javax.swing.JLabel parkingAddress;
    private javax.swing.JLabel parkingID;
    private javax.swing.JLabel parkingStatus;
    private javax.swing.JLabel priceTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JScrollPane scrollPaneParkings;
    private javax.swing.JComboBox<String> statusSelect;
    private javax.swing.JTextField truckPrice;
    private javax.swing.JLabel truckTxt;
    private javax.swing.JTextField vanPrice;
    private javax.swing.JLabel vanTxt;
    // End of variables declaration//GEN-END:variables
}
