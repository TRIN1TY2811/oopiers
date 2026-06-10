package schoolsystem3.TeachersFunctions;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class JamesEarlAttendance extends JFrame implements ActionListener {

    private JButton btnback, btnOOP, btnInteg, btnCP, btnNetAd, btnOS, btnSubmit, btnSubmit2, btnSubmit3, btnSubmit4, btnSubmit5;
    private JButton btnUpdate, btnUpdate2, btnUpdate3, btnUpdate4, btnUpdate5;
    private JButton btnDelete, btnDelete2, btnDelete3, btnDelete4, btnDelete5;
    private JButton btnSearch, btnSearch2, btnSearch3, btnSearch4, btnSearch5; 
    private JPanel pnlSideBar, pnlMain;
    private CardLayout cardLayout;
    

private JTextField[] oopID = new JTextField[10];
private JTextField[] oopName = new JTextField[10];
private JTextField[][] oopWeek = new JTextField[10][5];

private JTextField[] integID = new JTextField[10];
private JTextField[] integName = new JTextField[10];
private JTextField[][] integWeek = new JTextField[10][5];

private JTextField[] cpID = new JTextField[10];
private JTextField[] cpName = new JTextField[10];
private JTextField[][] cpWeek = new JTextField[10][5];

private JTextField[] netID = new JTextField[10];
private JTextField[] netName = new JTextField[10];
private JTextField[][] netWeek = new JTextField[10][5];

private JTextField[] osID = new JTextField[10];
private JTextField[] osName = new JTextField[10];
private JTextField[][] osWeek = new JTextField[10][5];

    public JamesEarlAttendance() {

        setSize(1000, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        pnlSideBar = new JPanel();
        pnlSideBar.setLayout(null);
        pnlSideBar.setBounds(0, 0, 180, 750);
        pnlSideBar.setBackground(Color.decode("#c0c0c0"));
        add(pnlSideBar);

        JLabel lblMenu = new JLabel("James Earl Amodia");
        lblMenu.setBounds(20, 40, 150, 30);
        pnlSideBar.add(lblMenu);

        btnOOP = createSideButton("OOP", 120);
        btnInteg = createSideButton("Integrative", 170);
        btnCP = createSideButton("Programming", 220);
        btnNetAd = createSideButton("Network", 270);
        btnOS = createSideButton("Operating Sys", 320);

        pnlSideBar.add(btnOOP);
        pnlSideBar.add(btnInteg);
        pnlSideBar.add(btnCP);
        pnlSideBar.add(btnNetAd);
        pnlSideBar.add(btnOS);

        cardLayout = new CardLayout();
        pnlMain = new JPanel(cardLayout);
        pnlMain.setBounds(200, 0, 800, 550);

        pnlMain.add(createOOPPanel(), "OOP");
        pnlMain.add(createIntegPanel(), "INTEG");
        pnlMain.add(createCompPanel(), "CP");
        pnlMain.add(createNetAdPanel(), "NET");
        pnlMain.add(createOSPanel(), "OS");

        add(pnlMain);

        btnback = new JButton("Back");
        btnback.setBounds(650, 620, 100, 30);
        add(btnback);

        

        btnOOP.addActionListener(this);
        btnInteg.addActionListener(this);
        btnCP.addActionListener(this);
        btnNetAd.addActionListener(this);
        btnOS.addActionListener(this);
        btnback.addActionListener(this);

        cardLayout.show(pnlMain, "OOP");      

    }

   private JPanel createOOPPanel() {

    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.WHITE);

    JLabel title = new JLabel("OOP Attendance", SwingConstants.CENTER);
    title.setBounds(0, 10, 760, 40);
    title.setFont(new Font("Arial", Font.BOLD, 24));
    panel.add(title);
   
    panel.add(createLabel("Student ID", 80, 80));
    panel.add(createLabel("Name", 200, 80));
    panel.add(createLabel("Week 1", 300, 80));
    panel.add(createLabel("Week2 ", 380, 80));
    panel.add(createLabel("Week 3", 460, 80));
    panel.add(createLabel("Week 4", 540, 80));
    panel.add(createLabel("Week 5", 620, 80));

   int yStart = 120;

for (int i = 0; i < 10; i++) {

    int y = yStart + (i * 35);

     
oopID[i] = addField(panel, "", 80, y, 100, 30);


oopName[i] = addField(panel, "", 200, y, 100, 30);


for (int j = 0; j < 5; j++) {
    oopWeek[i][j] =
        addField(panel, "", 320 + (j * 80), y, 70, 30);
}
}
    btnUpdate = new JButton("Update");
    btnUpdate.setBounds(650, 500, 120, 30);
    panel.add(btnUpdate);
    btnUpdate.addActionListener(this);

    btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(520, 500, 120, 30);
    panel.add(btnSubmit);
    btnSubmit.addActionListener(this);
    
    btnDelete = new JButton("Delete");
    btnDelete.setBounds(390, 500, 120, 30);
    panel.add(btnDelete);
    btnDelete.addActionListener(this);
    
    btnSearch = new JButton("Search");
    btnSearch.setBounds(260, 500, 120, 30);
    panel.add(btnSearch);
    btnSearch.addActionListener(this);

    return panel;
}


    private JLabel createLabel(String text, int x, int y) {
    JLabel lbl = new JLabel(text, SwingConstants.CENTER);
    lbl.setBounds(x, y, 100, 20);
    lbl.setFont(new Font("Arial", Font.BOLD, 12));
    return lbl;
}
  private JPanel createIntegPanel() {
      

    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.WHITE);
    

    JLabel title = new JLabel("Integrative Attendance", SwingConstants.CENTER);
    title.setBounds(0, 10, 760, 40);
    panel.add(title);

    panel.add(createLabel("Name", 80, 80));
    panel.add(createLabel("Week 1", 200, 80));
    panel.add(createLabel("Week2 ", 280, 80));
    panel.add(createLabel("Week 3", 360, 80));
    panel.add(createLabel("Week 4", 440, 80));
    panel.add(createLabel("Week 5", 520, 80));

    int yStart = 120;

for (int i = 0; i < 10; i++) {

    int y = yStart + (i * 35);

    integName[i] = addField(panel, "", 80, y, 100, 30);

    for (int j = 0; j < 5; j++) {
        integWeek[i][j] =
           addField(panel, "", 200 + (j * 80), y, 70, 30);
    }
}

    btnSubmit2 = new JButton("Submit");
    btnSubmit2.setBounds(520, 500, 120, 30);
    panel.add(btnSubmit2);
    btnSubmit2.addActionListener(this);
    
    btnUpdate2 = new JButton("Update");
    btnUpdate2.setBounds(650, 500, 120, 30);
    panel.add(btnUpdate2);
    btnUpdate2.addActionListener(this);
    
    btnDelete2 = new JButton("Delete");
    btnDelete2.setBounds(390, 500, 120, 30);
    panel.add(btnDelete2);
    btnDelete2.addActionListener(this);


    return panel;
}
    private JPanel createCompPanel() {

    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.WHITE);

    JLabel title = new JLabel("Computer Programming Attendance", SwingConstants.CENTER);
    title.setBounds(0, 10, 760, 40);
    panel.add(title);

    panel.add(createLabel("Name", 80, 80));
    panel.add(createLabel("Week 1", 200, 80));
    panel.add(createLabel("Week2 ", 280, 80));
    panel.add(createLabel("Week 3", 360, 80));
    panel.add(createLabel("Week 4", 440, 80));
    panel.add(createLabel("Week 5", 520, 80));

   int yStart = 120;

for (int i = 0; i < 10; i++) {

    int y = yStart + (i * 35);

    cpName[i] = addField(panel, "", 80, y, 100, 30);

    for (int j = 0; j < 5; j++) {
        cpWeek[i][j] =
            addField(panel, "", 200 + (j * 80), y, 70, 30);
    }
}

    btnSubmit3 = new JButton("Submit");
    btnSubmit3.setBounds(520, 500, 120, 30);
    panel.add(btnSubmit3);
    btnSubmit3.addActionListener(this);
    
    btnUpdate3 = new JButton("Update");
    btnUpdate3.setBounds(650, 500, 120, 30);
    panel.add(btnUpdate3);
    btnUpdate3.addActionListener(this);
    
    btnDelete3 = new JButton("Delete");
    btnDelete3.setBounds(390, 500, 120, 30);
    panel.add(btnDelete3);
    btnDelete3.addActionListener(this);


    return panel;
}


  private JPanel createNetAdPanel() {

    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.WHITE);

    JLabel title = new JLabel("Network Administration Attendance", SwingConstants.CENTER);
    title.setBounds(0, 10, 760, 40);
    panel.add(title);

    panel.add(createLabel("Name", 80, 80));
    panel.add(createLabel("Week 1", 200, 80));
    panel.add(createLabel("Week2 ", 280, 80));
    panel.add(createLabel("Week 3", 360, 80));
    panel.add(createLabel("Week 4", 440, 80));
    panel.add(createLabel("Week 5", 520, 80));

    int yStart = 120;

for (int i = 0; i < 10; i++) {

    int y = yStart + (i * 35);

    netName[i] = addField(panel, "", 80, y, 100, 30);

    for (int j = 0; j < 5; j++) {
       netWeek[i][j] =
            addField(panel, "", 200 + (j * 80), y, 70, 30);
    }
}

    btnSubmit4 = new JButton("Submit");
    btnSubmit4.setBounds(520, 500, 120, 30);
    panel.add(btnSubmit4);
    btnSubmit4.addActionListener(this);
    
    btnUpdate4 = new JButton("Update");
    btnUpdate4.setBounds(650, 500, 120, 30);
    panel.add(btnUpdate4);
    btnUpdate4.addActionListener(this);
    
    btnDelete4 = new JButton("Delete");
    btnDelete4.setBounds(390, 500, 120, 30);
    panel.add(btnDelete4);
    btnDelete4.addActionListener(this);


    return panel;
}
 private JPanel createOSPanel() {

    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.WHITE);

    JLabel title = new JLabel("Operating System Attendance", SwingConstants.CENTER);
    title.setBounds(0, 10, 760, 40);
    panel.add(title);

    panel.add(createLabel("Name", 80, 80));
    panel.add(createLabel("Week 1", 200, 80));
    panel.add(createLabel("Week2 ", 280, 80));
    panel.add(createLabel("Week 3", 360, 80));
    panel.add(createLabel("Week 4", 440, 80));
    panel.add(createLabel("Week 5", 520, 80));

    int yStart = 120;

for (int i = 0; i < 10; i++) {

    int y = yStart + (i * 35);

    osName[i] = addField(panel, "", 80, y, 100, 30);

    for (int j = 0; j < 5; j++) {
       osWeek[i][j] =
            addField(panel, "", 200 + (j * 80), y, 70, 30);
    }
}

    btnSubmit5 = new JButton("Submit");
    btnSubmit5.setBounds(520, 500, 120, 30);
    panel.add(btnSubmit5);
    btnSubmit5.addActionListener(this);
    
    btnUpdate5 = new JButton("Update");
    btnUpdate5.setBounds(650, 500, 120, 30);
    panel.add(btnUpdate5);
    btnUpdate5.addActionListener(this);
    
    btnDelete5 = new JButton("Delete");
    btnDelete5.setBounds(390, 500, 120, 30);
    panel.add(btnDelete5);
    btnDelete5.addActionListener(this);
    return panel;
}
     
 private void loadAttendanceData() {

    try {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql = "SELECT * FROM oopattendance";

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

       
        for (int r = 0; r < 10; r++) {

            oopID[r].setText("");
            oopName[r].setText("");

            for (int c = 0; c < 5; c++) {
                oopWeek[r][c].setText("");
            }
        }

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

        rs.close();
        pst.close();
        conn.close();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage());
    }
}   
    private void loadAttendanceData2() {

    try {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql = "SELECT * FROM integattendance";

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        // Clear all fields first
        for (int r = 0; r < 10; r++) {

            oopID[r].setText("");
            oopName[r].setText("");

            for (int c = 0; c < 5; c++) {
                oopWeek[r][c].setText("");
            }
        }

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

        rs.close();
        pst.close();
        conn.close();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage());
    }
} 
    private void loadAttendanceData3() {

    try {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql = "SELECT * FROM cpattendance";

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        // Clear all fields first
        for (int r = 0; r < 10; r++) {

            oopID[r].setText("");
            oopName[r].setText("");

            for (int c = 0; c < 5; c++) {
                oopWeek[r][c].setText("");
            }
        }

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

        rs.close();
        pst.close();
        conn.close();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage());
    }
} 
    private void loadAttendanceData4() {

    try {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql = "SELECT * FROM netattendance";

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        // Clear all fields first
        for (int r = 0; r < 10; r++) {

            oopID[r].setText("");
            oopName[r].setText("");

            for (int c = 0; c < 5; c++) {
                oopWeek[r][c].setText("");
            }
        }

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

        rs.close();
        pst.close();
        conn.close();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage());
    }
} 
    private void loadAttendanceData5() {

    try {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql = "SELECT * FROM osattendance";

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        // Clear all fields first
        for (int r = 0; r < 10; r++) {

            oopID[r].setText("");
            oopName[r].setText("");

            for (int c = 0; c < 5; c++) {
                oopWeek[r][c].setText("");
            }
        }

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

        rs.close();
        pst.close();
        conn.close();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage());
    }
} 
  
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnback) {
            setVisible(false);
            new TeacherDashB().setVisible(true);
        }

else if (e.getSource() == btnSubmit) {

    String sql =
        "INSERT INTO oopattendance (ID, Name, Week1, Week2, Week3, Week4, Week5) " +
        "VALUES (?,?,?,?,?,?,?)";

    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/schoolsystemdb",
            "root",
            "");
         PreparedStatement pst = conn.prepareStatement(sql)) {

        int inserted = 0;

        for (int i = 0; i < 10; i++) {

            String id = oopID[i].getText().trim();
            String name = oopName[i].getText().trim();

            if (id.isEmpty() && name.isEmpty()) continue;

            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, oopWeek[i][0].getText().trim());
            pst.setString(4, oopWeek[i][1].getText().trim());
            pst.setString(5, oopWeek[i][2].getText().trim());
            pst.setString(6, oopWeek[i][3].getText().trim());
            pst.setString(7, oopWeek[i][4].getText().trim());

            pst.executeUpdate();
            inserted++;
        }

        JOptionPane.showMessageDialog(this,
                "Inserted rows: " + inserted);
        loadAttendanceData();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "DB Error: " + ex.getMessage());
    }
}
else if (e.getSource() == btnSubmit2) {
    String sql = "INSERT INTO integattendance (ID, Name, Week1, Week2, Week3, Week4, Week5) VALUES (?,?,?,?,?,?,?)";

    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/schoolsystemdb",
            "root",
            "");
         PreparedStatement pst = conn.prepareStatement(sql)) {

        int inserted = 0;

        for (int i = 0; i < 10; i++) {

          String id = oopID[i].getText().trim();
           String name = oopName[i].getText().trim();

            if (name.isEmpty()) continue;

           pst.setString(1, id);
    pst.setString(2, name);
    pst.setString(3, oopWeek[i][0].getText().trim());
    pst.setString(4, oopWeek[i][1].getText().trim());
    pst.setString(5, oopWeek[i][2].getText().trim());
    pst.setString(6, oopWeek[i][3].getText().trim());
    pst.setString(7, oopWeek[i][4].getText().trim());

            pst.executeUpdate();
            inserted++;
        }

        JOptionPane.showMessageDialog(this,
                "Inserted rows: " + inserted);
                loadAttendanceData();


    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "DB Error: " + ex.getMessage());
    }
}
else if (e.getSource() == btnSubmit3) {
String sql = "INSERT INTO cpattendance (Name, Week1, Week2, Week3, Week4, Week5) VALUES (?,?,?,?,?,?)";

    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/schoolsystemdb",
            "root",
            "");
         PreparedStatement pst = conn.prepareStatement(sql)) {

        int inserted = 0;

        for (int i = 0; i < 10; i++) {

            String name = cpName[i].getText().trim();

            if (name.isEmpty()) continue;

            pst.setString(1, name);
            pst.setString(2, cpWeek[i][0].getText().trim());
            pst.setString(3, cpWeek[i][1].getText().trim());
            pst.setString(4, cpWeek[i][2].getText().trim());
            pst.setString(5, cpWeek[i][3].getText().trim());
            pst.setString(6, cpWeek[i][4].getText().trim());

            pst.executeUpdate();
            inserted++;
        }

        JOptionPane.showMessageDialog(this,
                "Inserted rows: " + inserted);

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "DB Error: " + ex.getMessage());
    }
} 
else if (e.getSource() == btnSubmit4) {
String sql = "INSERT INTO netattendance (Name, Week1, Week2, Week3, Week4, Week5) VALUES (?,?,?,?,?,?)";

    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/schoolsystemdb",
            "root",
            "");
         PreparedStatement pst = conn.prepareStatement(sql)) {

        int inserted = 0;

        for (int i = 0; i < 10; i++) {

            String name = netName[i].getText().trim();

            if (name.isEmpty()) continue;

            pst.setString(1, name);
            pst.setString(2, netWeek[i][0].getText().trim());
            pst.setString(3, netWeek[i][1].getText().trim());
            pst.setString(4, netWeek[i][2].getText().trim());
            pst.setString(5, netWeek[i][3].getText().trim());
            pst.setString(6, netWeek[i][4].getText().trim());

            pst.executeUpdate();
            inserted++;
        }

        JOptionPane.showMessageDialog(this,
                "Inserted rows: " + inserted);
                loadAttendanceData();


    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "DB Error: " + ex.getMessage());
    }
}
         else if (e.getSource() == btnSubmit5) {
String sql = "INSERT INTO osattendance (Name, Week1, Week2, Week3, Week4, Week5) VALUES (?,?,?,?,?,?)";

    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/schoolsystemdb",
            "root",
            "");
         PreparedStatement pst = conn.prepareStatement(sql)) {

        int inserted = 0;

        for (int i = 0; i < 10; i++) {

            String name = osName[i].getText().trim();

            if (name.isEmpty()) continue;

            pst.setString(1, name);
            pst.setString(2, osWeek[i][0].getText().trim());
            pst.setString(3, osWeek[i][1].getText().trim());
            pst.setString(4, osWeek[i][2].getText().trim());
            pst.setString(5, osWeek[i][3].getText().trim());
            pst.setString(6, osWeek[i][4].getText().trim());

            pst.executeUpdate();
            inserted++;
        }

        JOptionPane.showMessageDialog(this,
                "Inserted rows: " + inserted);
                loadAttendanceData();


    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "DB Error: " + ex.getMessage());
    }
}

        else if (e.getSource() == btnOOP) {
            cardLayout.show(pnlMain, "OOP");
        }
        else if (e.getSource() == btnInteg) {
            cardLayout.show(pnlMain, "INTEG");
        }
        else if (e.getSource() == btnCP) {
            cardLayout.show(pnlMain, "CP");
        }
        else if (e.getSource() == btnNetAd) {
            cardLayout.show(pnlMain, "NET");
        }
        else if (e.getSource() == btnOS) {
            cardLayout.show(pnlMain, "OS");
        }
        
    else if (e.getSource() == btnUpdate) {

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql =
            "UPDATE oopattendance SET week1=?, week2=?, week3=?, week4=?, week5=? WHERE name=?";

        PreparedStatement pst = conn.prepareStatement(sql);

        int updatedCount = 0;

        for (int i = 0; i < 10; i++) {

            // Skip empty name rows
            if (oopName[i].getText().trim().isEmpty()) {
                continue;
            }

            pst.setString(1, oopWeek[i][0].getText());
            pst.setString(2, oopWeek[i][1].getText());
            pst.setString(3, oopWeek[i][2].getText());
            pst.setString(4, oopWeek[i][3].getText());
            pst.setString(5, oopWeek[i][4].getText());
            pst.setString(6, oopName[i].getText());

            updatedCount += pst.executeUpdate();
        }

        if (updatedCount > 0) {
            JOptionPane.showMessageDialog(
                this,
                " Record(s) updated successfully!"
            );
        } else {
            JOptionPane.showMessageDialog(
                this,
                "No matching records were found.",
                "Update Failed",
                JOptionPane.WARNING_MESSAGE
            );
        }

        pst.close();
        conn.close();

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(
            this,
            "Unable to update attendance.",
            "Update Error",
            JOptionPane.ERROR_MESSAGE
        );

        ex.printStackTrace();
    }
}
             else if (e.getSource() == btnUpdate2) {

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql =
            "UPDATE integattendance SET week1=?, week2=?, week3=?, week4=?, week5=? WHERE name=?";

        PreparedStatement pst = conn.prepareStatement(sql);

        int updatedCount = 0;

        for (int i = 0; i < 10; i++) {

            if (integName[i].getText().trim().isEmpty()) {
                continue;
            }

            pst.setString(1, integWeek[i][0].getText());
            pst.setString(2, integWeek[i][1].getText());
            pst.setString(3, integWeek[i][2].getText());
            pst.setString(4, integWeek[i][3].getText());
            pst.setString(5, integWeek[i][4].getText());
            pst.setString(6, integName[i].getText());

            updatedCount += pst.executeUpdate();
        }

        if (updatedCount > 0) {
            JOptionPane.showMessageDialog(
                this,
                updatedCount + " record(s) updated successfully!"
            );
        } else {
            JOptionPane.showMessageDialog(
                this,
                "No matching records were found.",
                "Update Failed",
                JOptionPane.WARNING_MESSAGE
            );
        }

        pst.close();
        conn.close();

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(
            this,
            "Unable to update attendance.",
            "Update Error",
            JOptionPane.ERROR_MESSAGE
        );

        ex.printStackTrace();
    }
}
        else if (e.getSource() == btnUpdate3) {

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql =
            "UPDATE cpattendance SET week1=?, week2=?, week3=?, week4=?, week5=? WHERE name=?";

        PreparedStatement pst = conn.prepareStatement(sql);

        int updatedCount = 0;

        for (int i = 0; i < 10; i++) {

            // Skip empty name rows
            if (cpName[i].getText().trim().isEmpty()) {
                continue;
            }

            pst.setString(1, cpWeek[i][0].getText());
            pst.setString(2, cpWeek[i][1].getText());
            pst.setString(3, cpWeek[i][2].getText());
            pst.setString(4, cpWeek[i][3].getText());
            pst.setString(5, cpWeek[i][4].getText());
            pst.setString(6, cpName[i].getText());

            updatedCount += pst.executeUpdate();
        }

        if (updatedCount > 0) {
            JOptionPane.showMessageDialog(
                this,
                " Record(s) updated successfully!"
            );
        } else {
            JOptionPane.showMessageDialog(
                this,
                "No matching records were found.",
                "Update Failed",
                JOptionPane.WARNING_MESSAGE
            );
        }

        pst.close();
        conn.close();

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(
            this,
            "Unable to update attendance.",
            "Update Error",
            JOptionPane.ERROR_MESSAGE
        );

        ex.printStackTrace();
    }
}
          else if (e.getSource() == btnUpdate4) {

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql =
            "UPDATE netattendance SET week1=?, week2=?, week3=?, week4=?, week5=? WHERE name=?";

        PreparedStatement pst = conn.prepareStatement(sql);

        int updatedCount = 0;

        for (int i = 0; i < 10; i++) {

            // Skip empty name rows
            if (netName[i].getText().trim().isEmpty()) {
                continue;
            }

            pst.setString(1, netWeek[i][0].getText());
            pst.setString(2, netWeek[i][1].getText());
            pst.setString(3, netWeek[i][2].getText());
            pst.setString(4, netWeek[i][3].getText());
            pst.setString(5, netWeek[i][4].getText());
            pst.setString(6, netName[i].getText());

            updatedCount += pst.executeUpdate();
        }

        if (updatedCount > 0) {
            JOptionPane.showMessageDialog(
                this,
                " Record(s) updated successfully!"
            );
        } else {
            JOptionPane.showMessageDialog(
                this,
                "No matching records were found.",
                "Update Failed",
                JOptionPane.WARNING_MESSAGE
            );
        }

        pst.close();
        conn.close();

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(
            this,
            "Unable to update attendance.",
            "Update Error",
            JOptionPane.ERROR_MESSAGE
        );

        ex.printStackTrace();
    }
}

          else if (e.getSource() == btnUpdate5) {

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql =
            "UPDATE osattendance SET week1=?, week2=?, week3=?, week4=?, week5=? WHERE name=?";

        PreparedStatement pst = conn.prepareStatement(sql);

        int updatedCount = 0;

        for (int i = 0; i < 10; i++) {

            // Skip empty name rows
            if (netName[i].getText().trim().isEmpty()) {
                continue;
            }

            pst.setString(1, osWeek[i][0].getText());
            pst.setString(2, osWeek[i][1].getText());
            pst.setString(3, osWeek[i][2].getText());
            pst.setString(4, osWeek[i][3].getText());
            pst.setString(5, osWeek[i][4].getText());
            pst.setString(6, osName[i].getText());

            updatedCount += pst.executeUpdate();
        }

        if (updatedCount > 0) {
            JOptionPane.showMessageDialog(
                this,
                " Record(s) updated successfully!"
            );
        } else {
            JOptionPane.showMessageDialog(
                this,
                "No matching records were found.",
                "Update Failed",
                JOptionPane.WARNING_MESSAGE
            );
        }

        pst.close();
        conn.close();

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(
            this,
            "Unable to update attendance.",
            "Update Error",
            JOptionPane.ERROR_MESSAGE
        );

        ex.printStackTrace();
    }
}
        else if (e.getSource() == btnDelete) {

    String id = JOptionPane.showInputDialog(
            this,
            "Enter Student ID to delete:"
    );

    if (id == null || id.trim().isEmpty()) {
        return;
    }

    try {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql = "DELETE FROM oopattendance WHERE ID = ?";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, id.trim());

        int rows = pst.executeUpdate();

        if (rows > 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Record deleted successfully."
            );
            loadAttendanceData();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No record found with ID: " + id
            );
        }

        pst.close();
        conn.close();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(
                this,
                "Error: " + ex.getMessage()
        );
    }
}
        else if (e.getSource() == btnDelete2) {

    String id = JOptionPane.showInputDialog(
            this,
            "Enter Student ID to delete:"
    );

    if (id == null || id.trim().isEmpty()) {
        return;
    }

    try {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql = "DELETE FROM integattendance WHERE ID = ?";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, id.trim());

        int rows = pst.executeUpdate();

        if (rows > 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Record deleted successfully."
            );
            loadAttendanceData();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No record found with ID: " + id
            );
        }

        pst.close();
        conn.close();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(
                this,
                "Error: " + ex.getMessage()
        );
    }
}
       else if (e.getSource() == btnDelete3) {

    String id = JOptionPane.showInputDialog(
            this,
            "Enter Student ID to delete:"
    );

    if (id == null || id.trim().isEmpty()) {
        return;
    }

    try {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql = "DELETE FROM cpattendance WHERE ID = ?";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, id.trim());

        int rows = pst.executeUpdate();

        if (rows > 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Record deleted successfully."
            );
            loadAttendanceData();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No record found with ID: " + id
            );
        }

        pst.close();
        conn.close();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(
                this,
                "Error: " + ex.getMessage()
        );
    }
}
       else if (e.getSource() == btnDelete4) {

    String id = JOptionPane.showInputDialog(
            this,
            "Enter Student ID to delete:"
    );

    if (id == null || id.trim().isEmpty()) {
        return;
    }

    try {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql = "DELETE FROM netattendance WHERE ID = ?";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, id.trim());

        int rows = pst.executeUpdate();

        if (rows > 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Record deleted successfully."
            );
            loadAttendanceData();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No record found with ID: " + id
            );
        }

        pst.close();
        conn.close();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(
                this,
                "Error: " + ex.getMessage()
        );
    }
}
        else if (e.getSource() == btnDelete5) {

    String id = JOptionPane.showInputDialog(
            this,
            "Enter Student ID to delete:"
    );

    if (id == null || id.trim().isEmpty()) {
        return;
    }

    try {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql = "DELETE FROM osattendance WHERE ID = ?";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, id.trim());

        int rows = pst.executeUpdate();

        if (rows > 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Record deleted successfully."
            );
            loadAttendanceData();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No record found with ID: " + id
            );
        }

        pst.close();
        conn.close();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(
                this,
                "Error: " + ex.getMessage()
        );
    }
}
        else if (e.getSource() == btnSearch) {
                loadAttendanceData();
    try {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql = "SELECT * FROM oopattendance";

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        int i = 0;
        
        for (int r = 0; r < 10; r++) {

    oopID[r].setText("");
    oopName[r].setText("");

    for (int c = 0; c < 5; c++) {
        oopWeek[r][c].setText("");
    }
}
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

        rs.close();
        pst.close();
        conn.close();

        JOptionPane.showMessageDialog(this, "Records Loaded!");

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage());
    }
}
         else if (e.getSource() == btnSearch2) {
                loadAttendanceData();
    try {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql = "SELECT * FROM integattendance";

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        int i = 0;
        
        for (int r = 0; r < 10; r++) {

    oopID[r].setText("");
    oopName[r].setText("");

    for (int c = 0; c < 5; c++) {
        oopWeek[r][c].setText("");
    }
}
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

        rs.close();
        pst.close();
        conn.close();

        JOptionPane.showMessageDialog(this, "Records Loaded!");

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage());
    }
}
         else if (e.getSource() == btnSearch3) {
                loadAttendanceData();
    try {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql = "SELECT * FROM cpattendance";

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        int i = 0;
        
        for (int r = 0; r < 10; r++) {

    oopID[r].setText("");
    oopName[r].setText("");

    for (int c = 0; c < 5; c++) {
        oopWeek[r][c].setText("");
    }
}
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

        rs.close();
        pst.close();
        conn.close();

        JOptionPane.showMessageDialog(this, "Records Loaded!");

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage());
    }
}
         else if (e.getSource() == btnSearch4) {
                loadAttendanceData();
    try {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql = "SELECT * FROM netattendance";

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        int i = 0;
        
        for (int r = 0; r < 10; r++) {

    oopID[r].setText("");
    oopName[r].setText("");

    for (int c = 0; c < 5; c++) {
        oopWeek[r][c].setText("");
    }
}
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

        rs.close();
        pst.close();
        conn.close();

        JOptionPane.showMessageDialog(this, "Records Loaded!");

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage());
    }
}
         else if (e.getSource() == btnSearch5) {
                loadAttendanceData();
    try {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schoolsystemdb",
                "root",
                ""
        );

        String sql = "SELECT * FROM osattendance";

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        int i = 0;
        
        for (int r = 0; r < 10; r++) {

    oopID[r].setText("");
    oopName[r].setText("");

    for (int c = 0; c < 5; c++) {
        oopWeek[r][c].setText("");
    }
}
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

        rs.close();
        pst.close();
        conn.close();

        JOptionPane.showMessageDialog(this, "Records Loaded!");

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage());
    }
}
    }
    
    
    private JTextField addField(JPanel panel, String text, int x, int y, int w, int h) {
        JTextField txt = new JTextField(text);
        txt.setBounds(x, y, w, h);
        panel.add(txt);
        return txt;
    }

    private JButton createSideButton(String text, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(10, y, 160, 35);
        return btn;
    }       

   
   
}   