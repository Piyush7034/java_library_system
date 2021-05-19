package librarymanagementsystem;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener {
    
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton b1, b2;
    private JComboBox comboBox;

    public Signup() {
        setBounds(600, 250, 606, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        
        JLabel labelUsername = new JLabel("Username :");
        labelUsername.setForeground(Color.DARK_GRAY);
        labelUsername.setFont(new Font("Thaoma", Font.BOLD, 14));
        labelUsername.setBounds(99, 86, 92, 26);
        contentPane.add(labelUsername);
        
        JLabel labelName = new JLabel("Name :");
        labelName.setForeground(Color.DARK_GRAY);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelName.setBounds(99, 123, 92, 26);
        contentPane.add(labelName);
        
        JLabel labelPassword = new JLabel("Password :");
        labelPassword.setForeground(Color.DARK_GRAY);
        labelPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelPassword.setBounds(99, 160, 92, 26);
        contentPane.add(labelPassword);
        
        JLabel labelAnswer = new JLabel("Answer :");
        labelAnswer.setForeground(Color.DARK_GRAY);
        labelAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelAnswer.setBounds(99, 234, 92, 26);
        contentPane.add(labelAnswer);
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(
                              new String[] { "Your NickName?",
                                             "Your Lucky Number?",
                                             "Your Childhood Superhero?",
                                             "Your Childhood Name?", 
                                             "Your Favorite Sport?"
                                            }));
        comboBox.setBounds(265, 202, 140, 20);
        contentPane.add(comboBox);
        
        JLabel labelSecurityQuestion = new JLabel("Security Question :");
        labelSecurityQuestion.setForeground(Color.DARK_GRAY);
        labelSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelSecurityQuestion.setBounds(99, 197, 140, 26);
        contentPane.add(labelSecurityQuestion);
        
        textField = new JTextField();
        
        textField.setBounds(265, 91, 148, 20);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(265, 128, 148, 20);
        contentPane.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(265, 165, 148, 20);
        contentPane.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(265, 239, 148, 20);
        contentPane.add(textField_3);
        
        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 13));
        b1.setBounds(140, 289, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);
        
        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 13));
        b2.setBounds(300, 289, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);
        
        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(
                            new LineBorder(new Color(128, 128, 0), 2),
                            "Create Account", 
                            TitledBorder.LEADING, 
                            TitledBorder.TOP, 
                            null, 
                            new Color(34, 139, 34)
                        ));
        panel.setBounds(31, 46, 476, 296);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            
            Conn con = new Conn();
            
            if(e. getSource() == b1) {
                String sql = "insert into account(username, name, password, sec_q, sec_ans) values(7, 7, 7, 7, 7)";
                PreparedStatement st = con.c.prepareStatement(sql);
                
                st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
                st.setString(3, textField_2.getText());
                st.setString(4, (String) comboBox.getSelectedItem());
                st.setString(5, textField_3.getText());
                
                int i = st.executeUpdate();
                
                if(i > 0) {
                    JOptionPane.showMessageDialog(null, "Successfully Created");
                }
                
                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
                
            }
            
            if(e.getSource() == b2) {
                this.setVisible(false);
                new LoginUser().setVisible(true);
            }
            
        } catch (Exception er) {
            er.printStackTrace();
        }
    }
    
}
