package librarymanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LoginUser extends JFrame implements ActionListener {
    
    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1, b2, b3;
    
    public LoginUser() {
        
        setLayout(null);
        setBackground(new Color(169, 169, 169));
        setBounds(600, 300, 600, 400);
        
        panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        setContentPane(panel);
        panel.setLayout(null);
        
        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(124, 89, 95, 24);
        panel.add(l1);
        
        JLabel l2 = new JLabel("Password : ");
        l1.setBounds(124, 124, 95, 24);
        panel.add(l1);
        
        textField = new JTextField();
        textField.setBounds(210, 93, 157, 20);
        panel.add(textField);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(210, 128, 157, 20);
        panel.add(passwordField);
        
        b1 = new JButton("Login");
        b1.addActionListener(this);
        
        b1.setForeground(new Color(46, 139, 87));
        b1.setBackground(new Color(255, 235, 205));
        b1.setBounds(149, 181, 113, 39);
        panel.add(b1);
        
        b2 = new JButton("Sign Up");
        b2.addActionListener(this);
        
        b2.setForeground(new Color(139, 69, 19));
        b2.setBackground(new Color(255, 235, 205));
        b2.setBounds(289, 181, 113, 39);
        panel.add(b2);
        
        b3 = new JButton("Forgot Password");
        b3.addActionListener(this);
        
        b3.setForeground(new Color(205, 92, 92));
        b3.setBackground(new Color(253, 245, 230));
        b3.setBounds(199, 231, 179, 39);
        panel.add(b3);
        
        JLabel l5 = new JLabel("Trouble in Login?");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l5.setForeground(new Color(255, 0, 0));
        l5.setBounds(70, 240, 130, 20);
        panel.add(l5);
         
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) {
            Boolean status = false;
            try {
                Conn con = new Conn();
                String sql = "Select * from account where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                
                st.setString(1, textField.getText());
                st.setString(2, String.valueOf(passwordField.getPassword()));
                
                ResultSet rs = st.executeQuery();
                if(rs.next()) {
                    this.setVisible(false);
                    new Loading().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }
                
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
        if(e.getSource() == b2) {
            setVisible(false);
            new Signup().setVisible(true);
        }
        
        if(e.getSource() == b3) {
            setVisible(false);
            Forgot forgot = new Forgot();
            forgot.setVisible(true);
        }
    }
}
 