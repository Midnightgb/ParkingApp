package parkingapp.vehicle;

import parkingapp.user.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer {
    private String name;
    private Color buttonColor;

    public ButtonRenderer(String name, Color buttonColor) {
        this.name = name;
        this.buttonColor = buttonColor;
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(buttonColor); // Aplicar el color al botón
        }
        setText(name);
        return this;
    }
}
