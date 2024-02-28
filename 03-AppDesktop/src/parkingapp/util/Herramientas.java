package parkingapp.util;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public abstract class Herramientas {

  //FUNCION VENTANA alertas
    public static void alerta(String mensaje, boolean estado){
        JDialog alerta = new javax.swing.JDialog();
        JPanel panelalerta = new javax.swing.JPanel();
        JLabel alertaText = new javax.swing.JLabel();
        JButton cerrarAlerta = new javax.swing.JButton();
        JLabel imgalerta = new javax.swing.JLabel();
        
        if (!estado){
            alerta.setTitle("ERROR");  
            ImageIcon icon = new ImageIcon(Herramientas.class.getResource("/parkingapp/resources/images/icons8-cancelar-100.png"));
            imgalerta.setIcon(icon);
        }else{
            alerta.setTitle("EXITOSO");   
            ImageIcon icon = new ImageIcon(Herramientas.class.getResource("/parkingapp/resources/images/icons8-comprobado-100.png"));
            imgalerta.setIcon(icon);
        }
        
        alertaText.setText(mensaje);

        alerta.setBackground(new java.awt.Color(43, 43, 43));
        alerta.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelalerta.setBackground(new java.awt.Color(43, 43, 43));
        panelalerta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelalerta.setMaximumSize(new java.awt.Dimension(400, 300));
        panelalerta.setMinimumSize(new java.awt.Dimension(400, 300));

        alertaText.setFont(new java.awt.Font("Segoe UI", 1, 18));
        alertaText.setForeground(new java.awt.Color(207, 150, 217));
        
        cerrarAlerta.setText("CERRAR");
        cerrarAlerta.setBackground(new java.awt.Color(90, 90, 90));
        cerrarAlerta.setFont(new java.awt.Font("Segoe UI", 0, 14));
        cerrarAlerta.setForeground(new java.awt.Color(204, 204, 204));
        cerrarAlerta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cerrarAlerta.addMouseListener(new java.awt.event.MouseAdapter() {
        final JDialog alertaFinal = alerta;
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alertaFinal.setVisible(false);
            }
        });

        javax.swing.GroupLayout panelalertaLayout = new javax.swing.GroupLayout(panelalerta);
        panelalerta.setLayout(panelalertaLayout);
        panelalertaLayout.setHorizontalGroup(
            panelalertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelalertaLayout.createSequentialGroup()
                .addGroup(panelalertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelalertaLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(imgalerta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelalertaLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(alertaText))
                    .addGroup(panelalertaLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(cerrarAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        panelalertaLayout.setVerticalGroup(
            panelalertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelalertaLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(imgalerta, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alertaText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(cerrarAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        alerta.getContentPane().add(panelalerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));
        alerta.revalidate();
        alerta.repaint();
        alerta.pack();
        alerta.setLocationRelativeTo(null);
        alerta.setVisible(true);
    }

    public javax.swing.JDialog alerta;
    public javax.swing.JLabel errorText;
    public javax.swing.JLabel imgError;
    public javax.swing.JPanel panelError;
    public javax.swing.JButton cerrarAlerta;

    public static boolean enviarCorreo(String correo, String asunto, String mensaje) throws IOException {
        DataSource source = null;
        Properties propiedades= new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true"); // Habilitar TLS (Transport Layer Security - Seguridad de la capa de transporte)
        propiedades.put("mail.smtp.host", "smtp.gmail.com"); // Servidor SMTP de Gmail (Simple Mail Transfer Protocol - Protocolo simple para transferencia de correo)
        propiedades.put("mail.smtp.port", "587"); // Puerto para TLS

        // Crear una sesión de correo con autenticación
        Session sesion = Session.getInstance(propiedades, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("parkinadso2711@gmail.com", "ylbz pfys bcrw ctpr");
            }
        }); 
        try {
            // Crear mensaje del correo
            Message message = new MimeMessage(sesion);
            message.setFrom(new InternetAddress("parkinadso2711@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            message.setSubject(asunto);

            // Crear el cuerpo del correo en HTML (imagen + texto)
            String contenidoHTML = "<html><body style='width:870px; margin:0 auto; font-size:15px;'>"
                    + "<img width=\"156px\" src='cid:logo' alt='Parking Logo'><br>"
                    + "<p>" + mensaje + "</p>"
                    + "</body></html>";
            // Crear el cuerpo del mensaje con contenido HTML
            MimeBodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(contenidoHTML, "text/html");

            // Agregar la imagen adjunta
            MimeBodyPart imagePart = new MimeBodyPart();
            String imagePath = "parkingLogo.jpeg";
            File imageFile = new File(imagePath);
            System.out.println("Image absolute path: " + imageFile.getAbsolutePath());
            System.out.println("Image path: " + imagePath);
            InputStream inputStream = Herramientas.class.getResourceAsStream("parkingLogo.jpeg");
            if (inputStream != null) {
                source = new ByteArrayDataSource(inputStream, "image/jpeg");
            } else {
                System.out.println("No se pudo encontrar la imagen");
            }
            imagePart.setDataHandler(new DataHandler(source));
            imagePart.setHeader("Content-ID", "<logo>"); // Identificador único para la imagen
            imagePart.setDisposition(MimeBodyPart.INLINE); // Indicar que la imagen es inline 

            // Crear una parte mixta para combinar texto e imagen
            MimeMultipart mixedMultipart = new MimeMultipart("mixed");
            mixedMultipart.addBodyPart(contentPart);
            mixedMultipart.addBodyPart(imagePart);
            // Asignar el cuerpo mixto al mensaje
            message.setContent(mixedMultipart);
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false; 
        }
    }
    
    public static String consumoGET(String endpoint){
        try {
            
            // URL de la API
            URL url = new URL(endpoint);
            
            // Abrir una conexión HTTP y configurar para Metodo GET
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            // Obtener el código de respuesta enviado por el Servidor
            int responseCode = connection.getResponseCode();
            
            // En caso de respuesta exitosa convertir la respuesta en String
            if (responseCode == HttpURLConnection.HTTP_OK) {
                
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                connection.disconnect();
                return response.toString();
            } else {
                System.out.println("Error al consumir la API. Código de respuesta: " + responseCode);
                connection.disconnect();
                return null;
            }
        } catch (Exception e) {
            System.out.println(" -- Catch -- ");
            e.printStackTrace();
            return null;
        }
    }

    public static String insert(String endpoint, Map<String, String> postData){
        try {
            // URL de la API
            URL url = new URL(endpoint);

            // Abrir una conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar la conexión para el método POST
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            
            // Construir la cadena de datos a enviar
            StringBuilder data = new StringBuilder();
            for (Map.Entry<String, String> entry : postData.entrySet()) {
                if (data.length() != 0) {
                    data.append('&');
                }
                data.append(entry.getKey());
                data.append('=');
                data.append(entry.getValue());
            }

            // Enviar los datos en el cuerpo de la solicitud
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.writeBytes(data.toString());
                wr.flush();
            }

            // Obtener el código de respuesta
            int responseCode = connection.getResponseCode();
            
            // En caso de respuesta exitosa convertir la respuesta en String
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Leer la respuesta de la API
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                connection.disconnect();
                return response.toString();
            } else {
                System.out.println("Error al consumir la API. Código de respuesta: " + responseCode);
                connection.disconnect();
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    

    public static String consumoGET(String endpoint, Map<String, String> getData){
      try {
            StringBuilder urlBuilder = new StringBuilder(endpoint);
            if (!getData.isEmpty()) {
                urlBuilder.append('?');
                for (Map.Entry<String, String> entry : getData.entrySet()) {
                    urlBuilder.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    urlBuilder.append('=');
                    urlBuilder.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    urlBuilder.append('&');
                }
                urlBuilder.deleteCharAt(urlBuilder.length() - 1); // Eliminar el último '&'
            }
            
            URL url = new URL(urlBuilder.toString());
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            int responseCode = connection.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                connection.disconnect();
                return response.toString();
            } else {
                System.out.println("Error al consumir la API. Código de respuesta: " + responseCode);
                connection.disconnect();
                return null;
            }
        } catch (Exception e) {
            System.out.println(" -- Catch -- ");
            e.printStackTrace();
            return null;
        }
    }
    

    public static String consumoPOST(String endpoint, Map<String, String> postData){
        try {
            // URL de la API
            URL url = new URL(endpoint);

            // Abrir una conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar la conexión para el método POST
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            
            // Construir la cadena de datos a enviar
            StringBuilder data = new StringBuilder();
            for (Map.Entry<String, String> entry : postData.entrySet()) {
                if (data.length() != 0) {
                    data.append('&');
                }
                data.append(entry.getKey());
                data.append('=');
                data.append(entry.getValue());
            }

            // Enviar los datos en el cuerpo de la solicitud
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.writeBytes(data.toString());
                wr.flush();
            }

            // Obtener el código de respuesta
            int responseCode = connection.getResponseCode();
            
            // En caso de respuesta exitosa convertir la respuesta en String
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Leer la respuesta de la API
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                connection.disconnect();
                return response.toString();
            } else {
                System.out.println("Error al consumir la API. Código de respuesta: " + responseCode);
                connection.disconnect();
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
}