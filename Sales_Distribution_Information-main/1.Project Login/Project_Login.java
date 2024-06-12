// Project Application NO - 1
// Login Form

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Project_Login extends JFrame implements ActionListener
{
    ResultSet rs;
    Connection con;
    JLabel lb1, lb2, lb3, lb4, lb5, lb_usnm, lb_pwd;
    JTextField tf_username;
    JButton but_log, but_cancel;
    JPasswordField tf_pwd;
    Project_Login()
    {
        setSize(1550, 880);
        setVisible(true);
        setLayout(null);        
        lb1 = new JLabel("A S/W Project");
        lb2 = new JLabel("Company Products Sales & Distribution System");
        lb3 = new JLabel("Developed for the Company/Industry");
        lb4 = new JLabel("Samsung Electronics Limited");
        lb5 = new JLabel("User's Authentication Form (Login Form)");
        lb_usnm = new JLabel("Username/ID : ");
        lb_pwd = new JLabel("Password      : ");
        tf_pwd = new JPasswordField();
        //tf_pwd.setEchoChar('#');
        tf_username = new JTextField();
        but_log = new JButton("Login");
        but_cancel = new JButton("Cancel");
        but_log.addActionListener(this);
        but_cancel.addActionListener(this);

        Font f1, f2, f3;
        f1 = new Font("arial black", Font.PLAIN, 36);
        f2 = new Font("arial", Font.BOLD, 32);
        f3 = new Font("times new roman", Font.BOLD, 22);
        lb1.setFont(f3);
        lb2.setFont(f2);
        lb3.setFont(f3);
        lb4.setFont(f2);
        lb5.setFont(f1);
        lb_usnm.setFont(f3);
        lb_pwd.setFont(f3);
        tf_pwd.setFont(f3);
        tf_username.setFont(f3);
        but_log.setFont(f3);
        but_cancel.setFont(f3);

        add(lb1);
        add(lb2);
        add(lb3);
        add(lb4);
        add(lb5);
        add(lb_usnm);
        add(lb_pwd);
        add(tf_pwd);
        add(tf_username);
        add(but_log);
        add(but_cancel);

        lb1.setBounds(675, 50, 200, 25);
        lb2.setBounds(375, 100, 800, 40);
        lb3.setBounds(575, 150, 500, 25);
        lb4.setBounds(525, 200, 500, 35);
        lb5.setBounds(350, 275, 800, 45);
        lb_usnm.setBounds(550, 375, 175, 30);
        tf_username.setBounds(725, 375, 250, 30);
        lb_pwd.setBounds(550, 425, 175, 30);
        tf_pwd.setBounds(725, 425, 150, 30);
        but_log.setBounds(600, 490, 150, 30);
        but_cancel.setBounds(775, 490, 150, 30);

        Connection_method();
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == but_log)
        {
            if(tf_username.getText().length() == 0 || tf_pwd.getText().length() == 0)
            {
                tf_username.requestFocus();
                JOptionPane.showMessageDialog(this, "You did not enter Username or Password. Please Enter.");
            }
            else
            {
                int permode = 0;
                try{
                    rs.beforeFirst();
                    while(rs.next()){
                        if(tf_username.getText().equals(rs.getString(1)) && tf_pwd.getText().equals(rs.getString(2))){
                            permode = rs.getInt(3);
                            break;
                        }
                    }
                    if(rs.isAfterLast())
                        JOptionPane.showMessageDialog(this, "You are not an Authorized User, so rejected.");
                    else{
                        new Sales_Distribution_Menu();
                        dispose();
                    }
                }
                catch(SQLException e3){
                    JOptionPane.showMessageDialog(this, "Problem during Verification of User ID and Password.");
                }
            }
        }
        else if(ae.getSource() == but_cancel)
        {
            try{
                con.close();
            }
            catch(SQLException e4){
                JOptionPane.showMessageDialog(this, "Problem during closing Java-Oracle Connection.");
            }
            dispose();
        }
    }
    
    void Connection_method() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from Sales_Distribution_Users");
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(this, "Problem during Java-Oracle Connection or User's authentication.");
        } catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(this, "Problem when Loading the Driver.");
        }
    }
    public static void main(String args[])
    {
        Project_Login obj = new Project_Login();
        obj.addWindowListener
        (
            new WindowAdapter()
            {
                public void windowClosing(WindowEvent we)
                {
                    System.exit(0);
                }
            }
        );
    }
}
