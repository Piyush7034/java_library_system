package librarymanagementsystem;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable {
    
    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    int s;
    Thread th;
    
    public static void main() {
        new Loading().setVisible(true);
    }
    
    public void setUploading() {
        th.start();
    }
    
    public Loading() {
        super("Loading");
        th = new Thread((Runnable) this);
        
        setBounds(600, 300, 600, 400);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel labelLibraryManagement = new JLabel("Smart Library vS.1");
        labelLibraryManagement.setForeground(new Color(72, 209, 204));
        labelLibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        labelLibraryManagement.setBounds(130, 46, 500, 35);
        contentPane.add(labelLibraryManagement);
        
        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 135, 300, 25);
        contentPane.add(progressBar);
        
        JLabel labelNewLabel_2 = new JLabel("Please Wait....");
        labelNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        labelNewLabel_2.setForeground(new Color(160, 82, 45));
        labelNewLabel_2.setBounds(200, 165, 150, 20);
        contentPane.add(labelNewLabel_2);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 590, 390);
        contentPane.add(panel);
        
        setUploading();
    }

    @Override
    public void run() {
        try {
            for(int i=0;i<200;i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if(v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new Home().setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
