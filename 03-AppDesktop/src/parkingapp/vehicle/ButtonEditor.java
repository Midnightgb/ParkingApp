
package parkingapp.vehicle;

import parkingapp.user.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.UIManager;

/**
 *
 * @author yeras
 */
class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean isClicked;
        private JTable TableUsers;
        private int id;
        
        public ButtonEditor(JTable TableUsers,int id) {
            super(new JCheckBox());
            button = new JButton();
            button.setOpaque(true);
            
            this.TableUsers=TableUsers;
            this.id=id;

            // Agregar un ActionListener para manejar el clic en el botón
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(UIManager.getColor("Button.background"));
            }

            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isClicked = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isClicked) {
                // Aquí puedes obtener el ID del usuario de la fila seleccionada y realizar la acción adecuada
                
                int columnIndex = TableUsers.getSelectedColumn();
                if (columnIndex == 4) {
                    System.out.println("Editar ID: "+id );
                } else if (columnIndex == 5) {
                    System.out.println("Eliminar ID: "+id );
                }
                isClicked = false;
            }
            return label;
        }

        public boolean stopCellEditing() {
            isClicked = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
}
    
