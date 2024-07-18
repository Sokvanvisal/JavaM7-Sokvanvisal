import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends JFrame {
    private final ResultSet rs;
    private JTextField id;
    private JTextField fname;
    private JTextField lname;
    private JTextField phone;
    private JButton btnPrevious;
    private JButton btnNext;

    public Customer() {

        JLabel idLabel = new JLabel("ID");
        JLabel nameLabel = new JLabel("First Name");
        JLabel lnameLabel = new JLabel("Last Name");
        JLabel phoneLabel = new JLabel("Phone Number");

        id = new JTextField(10);
        fname = new JTextField(10);
        lname = new JTextField(10);
        phone = new JTextField(10);
        btnPrevious = new JButton("Previous");
        btnNext = new JButton("Next");

        btnNext.addActionListener(new Operation());
        btnPrevious.addActionListener(new Operation());

        setLayout(new GridLayout(5, 2, 4, 4));
        add(idLabel);
        add(id);
        add(nameLabel);
        add(fname);
        add(lnameLabel);
        add(lname);
        add(phoneLabel);
        add(phone);
        setTitle("Customer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }

    private static class Operation implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();

        }
    }

    private void updateFields() throws SQLException {
        id.setText(rs.getString("id"));
        fname.setText(rs.getString("fname"));
        lname.setText(rs.getString("lname"));
        phone.setText(rs.getString("phone"));
    }

        DBConnection dbConnection = new DBConnection();
        rs = dbConnection.getResultSet();
        btnPrevious.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (rs.previous()) {
                        updateFields();
                    } else {
                        rs.next();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (rs.next()) {
                        updateFields();
                    } else {
                        rs.previous();

                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }



