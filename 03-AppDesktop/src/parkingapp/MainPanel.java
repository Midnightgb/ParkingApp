
package parkingapp;

import parkingapp.user.User;

public class MainPanel extends javax.swing.JPanel {

    private User dataUser;
    public MainPanel(User userData) {
        initComponents();
        this.dataUser = userData;
        nameUserTxt.setText(dataUser.getNombre());
        System.out.println("Panel principal");
        System.out.println("Nombre: " + dataUser.getNombre());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeTxt = new javax.swing.JLabel();
        nameUserTxt = new javax.swing.JLabel();

        setBackground(new java.awt.Color(43, 43, 43));
        setForeground(new java.awt.Color(255, 255, 255));

        welcomeTxt.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        welcomeTxt.setForeground(new java.awt.Color(255, 255, 255));
        welcomeTxt.setText("Bienvenid@!");

        nameUserTxt.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nameUserTxt.setForeground(new java.awt.Color(255, 255, 255));
        nameUserTxt.setText("{name}");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameUserTxt)
                .addContainerGap(779, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(welcomeTxt)
                    .addComponent(nameUserTxt))
                .addContainerGap(458, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nameUserTxt;
    private javax.swing.JLabel welcomeTxt;
    // End of variables declaration//GEN-END:variables
}
