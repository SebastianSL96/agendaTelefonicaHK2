import javax.swing.*;
import java.awt.*;

public class MainAgendaGUI extends JFrame {

    private Agenda agenda;
    private JTextArea area;

    public MainAgendaGUI() {
        agenda = new Agenda();
        setTitle("Agenda Telefónica");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextField nombre = new JTextField(10);
        JTextField apellido = new JTextField(10);
        JTextField telefono = new JTextField(10);
        JButton agregar = new JButton("Agregar");
        JButton listar = new JButton("Listar");
        area = new JTextArea();
        area.setEditable(false);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Nombre"));
        panel.add(nombre);
        panel.add(new JLabel("Apellido"));
        panel.add(apellido);
        panel.add(new JLabel("Teléfono"));
        panel.add(telefono);
        panel.add(agregar);
        panel.add(listar);
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);
        agregar.addActionListener(e -> {
            try {
                agenda.añadirContacto(
                        new Contacto(
                                nombre.getText(),
                                apellido.getText(),
                                telefono.getText()
                        )
                );
                JOptionPane.showMessageDialog(this, "Contacto agregado");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
        listar.addActionListener(e -> {
            area.setText("");
            agenda.getContactos().forEach(c -> area.append(c + "\n"));
        });
    }
    
    public static void main(String[] args) {
        new MainAgendaGUI().setVisible(true);
    }
}
