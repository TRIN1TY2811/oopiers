package schoolsystem3.StudentInsideData.Attendance;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import schoolsystem3.Homepage;
import schoolsystem3.StudentsData.Student1;

public class Student1Attendance extends JFrame implements ActionListener {

    private JTextField txtSearch;
    private JButton btnSearch, btnBack;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    // OOP fields
    private JTextField[] oopID = new JTextField[10];
    private JTextField[] oopName = new JTextField[10];
    private JTextField[][] oopWeek = new JTextField[10][5];

    // subject buttons
    private JButton btnOOP, btnInteg, btnCP, btnNet, btnOS;

    public Student1Attendance() {

        setTitle("Student Attendance Viewer");
        setSize(1000, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        // ===== TOP SEARCH PANEL =====
        JLabel lbl = new JLabel("Enter Student ID or Name:");
        lbl.setBounds(200, 20, 200, 30);
        add(lbl);

        txtSearch = new JTextField();
        txtSearch.setBounds(380, 20, 200, 30);
        add(txtSearch);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(600, 20, 100, 30);
        btnSearch.addActionListener(this);
        add(btnSearch);

        // ===== SIDE MENU =====
        JPanel side = new JPanel();
        side.setLayout(null);
        side.setBounds(0, 0, 180, 700);
        side.setBackground(Color.LIGHT_GRAY);
        add(side);

        btnOOP = createButton("OOP", 120);
        btnInteg = createButton("Integrative", 170);
        btnCP = createButton("Programming", 220);
        btnNet = createButton("Network", 270);
        btnOS = createButton("OS", 320);

        side.add(btnOOP);
        side.add(btnInteg);
        side.add(btnCP);
        side.add(btnNet);
        side.add(btnOS);

        btnOOP.addActionListener(this);
        btnInteg.addActionListener(this);
        btnCP.addActionListener(this);
        btnNet.addActionListener(this);
        btnOS.addActionListener(this);

        // ===== MAIN PANEL =====
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBounds(200, 80, 760, 550);
        add(mainPanel);

        mainPanel.add(createOOPPanel(), "OOP");

        btnBack = new JButton("Back");
        btnBack.setBounds(820, 610, 150, 40); // bottom-right position
        add(btnBack);
        btnBack.addActionListener(this);

        setVisible(true);
    }

    // ================= OOP PANEL =================
    private JPanel createOOPPanel() {

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);

        JLabel title = new JLabel("OOP Attendance (View Only)", SwingConstants.CENTER);
        title.setBounds(0, 10, 760, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(title);

        JLabel[] headers = {
            new JLabel("ID"),
            new JLabel("Name"),
            new JLabel("W1"),
            new JLabel("W2"),
            new JLabel("W3"),
            new JLabel("W4"),
            new JLabel("W5")
        };

        int[] x = {50, 150, 250, 320, 390, 460, 530};

        for (int i = 0; i < headers.length; i++) {
            headers[i].setBounds(x[i], 60, 70, 25);
            panel.add(headers[i]);
        }

        int yStart = 100;

        for (int i = 0; i < 10; i++) {

            int y = yStart + (i * 35);

            oopID[i] = createField(panel, 50, y);
            oopName[i] = createField(panel, 150, y);

            for (int j = 0; j < 5; j++) {
                oopWeek[i][j] = createField(panel, 250 + (j * 70), y);
            }
        }

        return panel;
    }

    private JTextField createField(JPanel panel, int x, int y) {
        JTextField t = new JTextField();
        t.setBounds(x, y, 60, 25);
        t.setEditable(false); // IMPORTANT: student view only
        panel.add(t);
        return t;
    }

    private JButton createButton(String text, int y) {
        JButton b = new JButton(text);
        b.setBounds(10, y, 160, 35);
        return b;
    }

    // ================= DATABASE SEARCH =================
   private void searchStudent() {

    String key = txtSearch.getText().trim();

    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/schoolsystemdb",
            "root",
            "")) {

        PreparedStatement pst;

        if (key.isEmpty()) {

            String sql = "SELECT * FROM oopattendance";
            pst = conn.prepareStatement(sql);

        } else {

            String sql = "SELECT * FROM oopattendance WHERE ID=? OR Name=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, key);
            pst.setString(2, key);
        }

        ResultSet rs = pst.executeQuery();

        clearOOP();

        int i = 0;

        while (rs.next() && i < 10) {

            oopID[i].setText(rs.getString("ID"));
            oopName[i].setText(rs.getString("Name"));

            oopWeek[i][0].setText(rs.getString("Week1"));
            oopWeek[i][1].setText(rs.getString("Week2"));
            oopWeek[i][2].setText(rs.getString("Week3"));
            oopWeek[i][3].setText(rs.getString("Week4"));
            oopWeek[i][4].setText(rs.getString("Week5"));

            i++;
        }

        if (i == 0) {
            JOptionPane.showMessageDialog(this, "No record found!");
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "DB Error: " + ex.getMessage());
    }
}

    private void clearOOP() {

        for (int i = 0; i < 10; i++) {

            if (oopID[i] != null) {
                oopID[i].setText("");
                oopName[i].setText("");
            }

            for (int j = 0; j < 5; j++) {
                if (oopWeek[i][j] != null) {
                    oopWeek[i][j].setText("");
                }
            }
        }
    }

    // ================= ACTION LISTENER =================
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSearch) {
            searchStudent();
        } else if (e.getSource() == btnOOP) {
            cardLayout.show(mainPanel, "OOP");
        } else if (e.getSource() == btnBack) {
            Student1 st = new Student1();
            st.setVisible(true);
            dispose();
        }
    }

}
