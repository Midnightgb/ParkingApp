package parkingapp.login;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import parkingapp.user.User;
import parkingapp.util.Herramientas;

public class CheckCodeAuth extends javax.swing.JFrame {

    private String codigo;
    private User user;
    
    public CheckCodeAuth(String codigo, User userData) {
        initComponents();
        this.codigo = codigo;
        this.user = userData;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConfirmarCodigo = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        primerDigito = new javax.swing.JTextField();
        segundoDigito = new javax.swing.JTextField();
        tercerDigito = new javax.swing.JTextField();
        cuartoDigito = new javax.swing.JTextField();
        textoAyuda = new javax.swing.JLabel();
        confirmar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelConfirmarCodigo.setBackground(new java.awt.Color(43, 43, 43));

        primerDigito.setBackground(new java.awt.Color(90, 90, 90));
        primerDigito.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        primerDigito.setForeground(new java.awt.Color(204, 204, 204));
        primerDigito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        primerDigito.setBorder(null);
        primerDigito.setCaretColor(new java.awt.Color(255, 255, 255));
        primerDigito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                primerDigitoKeyPressed(evt);
            }
        });

        segundoDigito.setBackground(new java.awt.Color(90, 90, 90));
        segundoDigito.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        segundoDigito.setForeground(new java.awt.Color(204, 204, 204));
        segundoDigito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        segundoDigito.setBorder(null);
        segundoDigito.setCaretColor(new java.awt.Color(255, 255, 255));
        segundoDigito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                segundoDigitoKeyPressed(evt);
            }
        });

        tercerDigito.setBackground(new java.awt.Color(90, 90, 90));
        tercerDigito.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        tercerDigito.setForeground(new java.awt.Color(204, 204, 204));
        tercerDigito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tercerDigito.setBorder(null);
        tercerDigito.setCaretColor(new java.awt.Color(255, 255, 255));
        tercerDigito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tercerDigitoKeyPressed(evt);
            }
        });

        cuartoDigito.setBackground(new java.awt.Color(90, 90, 90));
        cuartoDigito.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        cuartoDigito.setForeground(new java.awt.Color(204, 204, 204));
        cuartoDigito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cuartoDigito.setBorder(null);
        cuartoDigito.setCaretColor(new java.awt.Color(255, 255, 255));
        cuartoDigito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cuartoDigitoKeyPressed(evt);
            }
        });

        textoAyuda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoAyuda.setForeground(new java.awt.Color(255, 255, 255));
        textoAyuda.setText("Ingresa el codigo que te llego al correo asociado a esta cuenta.");

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

        javax.swing.GroupLayout panelConfirmarCodigoLayout = new javax.swing.GroupLayout(panelConfirmarCodigo);
        panelConfirmarCodigo.setLayout(panelConfirmarCodigoLayout);
        panelConfirmarCodigoLayout.setHorizontalGroup(
            panelConfirmarCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfirmarCodigoLayout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(img)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConfirmarCodigoLayout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(panelConfirmarCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoAyuda)
                    .addGroup(panelConfirmarCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelConfirmarCodigoLayout.createSequentialGroup()
                            .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelConfirmarCodigoLayout.createSequentialGroup()
                            .addComponent(primerDigito, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(segundoDigito, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tercerDigito, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cuartoDigito, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(101, 101, 101))
        );
        panelConfirmarCodigoLayout.setVerticalGroup(
            panelConfirmarCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfirmarCodigoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(img)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoAyuda)
                .addGap(31, 31, 31)
                .addGroup(panelConfirmarCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(segundoDigito, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(primerDigito, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tercerDigito, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuartoDigito, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelConfirmarCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConfirmarCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConfirmarCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        aplicarRestriccion(primerDigito, segundoDigito);
        aplicarRestriccion(segundoDigito, tercerDigito);
        aplicarRestriccion(tercerDigito, cuartoDigito);
        aplicarRestriccion(cuartoDigito, null);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aplicarRestriccion(JTextField textField, JTextField nextTextField){
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d") && fb.getDocument().getLength() == 0) {
                    super.insertString(fb, offset, string, attr);
                    if (nextTextField != null) {
                        nextTextField.requestFocus(); 

                    }
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d") && fb.getDocument().getLength() == 0) {
                    super.replace(fb, offset, length, text, attrs);
                    if (nextTextField != null) {
                        nextTextField.requestFocus();
                    } else {

                    }
                }
            }
        });
    }
    private void cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseClicked
        System.out.println("cancelar codigo");
        LoginFrame login = new LoginFrame();
        setVisible(false);
    }//GEN-LAST:event_cancelarMouseClicked
    
    private boolean estado;
    private void confirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmarMouseClicked
        String codigoIngresado = primerDigito.getText()+segundoDigito.getText()+tercerDigito.getText()+cuartoDigito.getText();
        System.out.println(codigoIngresado);
        if (codigoIngresado.equals(codigo)){
            estado = true;
        } else {
            Herramientas.alerta("El código no coincide.",false);
            estado = false;
        }
        
        if(estado){
            CodeConfirmed confirmado = new CodeConfirmed(user);
            confirmado.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_confirmarMouseClicked

    private void cuartoDigitoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cuartoDigitoKeyPressed
        char c = evt.getKeyChar();
        if (c == '\n') {
            confirmarMouseClicked(null);
        }
    }//GEN-LAST:event_cuartoDigitoKeyPressed

    private void tercerDigitoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tercerDigitoKeyPressed
        char c = evt.getKeyChar();
        if (c == '\n') {
            confirmarMouseClicked(null);
        }
    }//GEN-LAST:event_tercerDigitoKeyPressed

    private void segundoDigitoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_segundoDigitoKeyPressed
        char c = evt.getKeyChar();
        if (c == '\n') {
            confirmarMouseClicked(null);
        }
    }//GEN-LAST:event_segundoDigitoKeyPressed

    private void primerDigitoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_primerDigitoKeyPressed
        char c = evt.getKeyChar();
        if (c == '\n') {
            confirmarMouseClicked(null);
        }
    }//GEN-LAST:event_primerDigitoKeyPressed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton confirmar;
    private javax.swing.JTextField cuartoDigito;
    private javax.swing.JLabel img;
    private javax.swing.JPanel panelConfirmarCodigo;
    private javax.swing.JTextField primerDigito;
    private javax.swing.JTextField segundoDigito;
    private javax.swing.JTextField tercerDigito;
    private javax.swing.JLabel textoAyuda;
    // End of variables declaration//GEN-END:variables
}
