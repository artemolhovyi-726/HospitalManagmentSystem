import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HospitalManagementSystem extends JFrame {
    private JTextField patientNameField;
    private JComboBox<String> departmentComboBox;
    private JTextArea outputArea;

    public HospitalManagementSystem() {
        setTitle("Hospital Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        JLabel patientNameLabel = new JLabel("Patient Name:");
        patientNameField = new JTextField();

        JLabel departmentLabel = new JLabel("Department:");
        departmentComboBox = new JComboBox<>();
        departmentComboBox.addItem("Cardiology");
        departmentComboBox.addItem("Orthopedics");
        departmentComboBox.addItem("Neurology");
        departmentComboBox.addItem("Ophthalmology");

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientName = patientNameField.getText();
                String department = (String) departmentComboBox.getSelectedItem();
                String output = "Patient Name: " + patientName + "\nDepartment: " + department + "\n\n";
                outputArea.append(output);
                JOptionPane.showMessageDialog(HospitalManagementSystem.this, "Patient registered successfully!");
                patientNameField.setText("");
                departmentComboBox.setSelectedIndex(0);
            }
        });

        inputPanel.add(patientNameLabel);
        inputPanel.add(patientNameField);
        inputPanel.add(departmentLabel);
        inputPanel.add(departmentComboBox);
        inputPanel.add(new JLabel());
        inputPanel.add(registerButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HospitalManagementSystem();
            }
        });
    }
}
