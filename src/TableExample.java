/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USUARIO
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableExample extends JFrame {
    private JTable table;

    public TableExample() {
        setTitle("Ejemplo de tabla con TableCellEditor");
        setSize(400, 300);

        // Crear datos de ejemplo
        Object[][] data = {
                {"1", "John", "Doe"},
                {"2", "Jane", "Smith"},
                {"3", "Bob", "Johnson"}
        };

        // Crear nombres de columna
        String[] columnNames = {"ID", "Nombre", "Apellido"};

        // Crear el modelo de tabla con los datos y los nombres de columna
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        
        // Crear la tabla con el modelo de datos
        table = new JTable(model);

        // Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TableExample();
    }
}
