import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Accept_Period extends JFrame implements ActionListener{
    JLabel lb_title, lb_reportname, lb_sdate, lb_edate;
    JTextField tf_sdate, tf_edate;
    JButton but_pro, but_cancel;
    String global_source = "";
    Accept_Period(String source){
        global_source = source;
        String x = "";
        if(source.equals("Inward_Report"))
            x = "Manufactured Products Inward Report (Periodical)";
        else if(source.equals("Sales_Report"))
            x = "Products Sales Transaction Report (Periodical)";
        else if(source.equals("Distribution_Report"))
            x = "Products Distribution Transaction Report (Periodical)";
        else if(source.equals("WholePay_Report"))
            x = "Wholesellers Payment Received Transaction Report (Periodical)";
        else if(source.equals("DistPay_Report"))
            x = "Distributors Payment Received Transaction Report (Periodical)";
        setSize(900,500);
        setVisible(true);
        setLayout(null);
        lb_title = new JLabel("Enter the Period to Produce : ");
        lb_reportname = new JLabel(x);
        lb_sdate = new JLabel("Starting Date");
        lb_edate = new JLabel("Ending Date");
        tf_sdate = new JTextField("01-DEC-2022");
        tf_edate = new JTextField("31-DEC-2022");
        but_pro = new JButton("Produce Report");
        but_cancel = new JButton("Cancel");
        but_pro.addActionListener(this);
        but_cancel.addActionListener(this);
        Font f1, f2;
        f1 = new Font("Arial", Font.BOLD, 32);
        f2 = new Font("Times New Roman", Font.PLAIN, 24);
        lb_title.setFont(f1);
        lb_reportname.setFont(f1);
        lb_sdate.setFont(f2);
        lb_edate.setFont(f2);
        tf_sdate.setFont(f2);
        tf_edate.setFont(f2);
        but_pro.setFont(f2);
        but_cancel.setFont(f2);
        add(lb_title);
        add(lb_reportname);
        add(lb_sdate);
        add(lb_edate);
        add(tf_sdate);
        add(tf_edate);
        add(but_pro);
        add(but_cancel);

        lb_title.setBounds(225, 100, 450, 40);
        lb_reportname.setBounds(75, 150, 800, 40);
        lb_sdate.setBounds(250, 250, 150, 30);
        tf_sdate.setBounds(450, 250, 150, 30);
        lb_edate.setBounds(250, 300, 150, 30);
        tf_edate.setBounds(450, 300, 150, 30);
        but_pro.setBounds(200, 375, 250, 30);
        but_cancel.setBounds(500, 375, 150, 30);

        tf_sdate.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_sdate.getText().length() >= 12) {
                            ke.consume();
                        }
                        else {
                            return;
                        }
                    }
                });
        tf_edate.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_edate.getText().length() >= 12) {
                            ke.consume();
                        }
                        else {
                            return;
                        }
                    }
                });
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == but_pro){
            if(global_source.equals("Inward_Report"))
                new Products_Inward_Report(tf_sdate.getText(), tf_edate.getText());
            else if(global_source.equals("Sales_Report"))
                new Per_Sales_Report(tf_sdate.getText(), tf_edate.getText());
            else if(global_source.equals("Distribution_Report"))
                new Per_Distribution_Report(tf_sdate.getText(), tf_edate.getText());
            else if(global_source.equals("WholePay_Report"))
                new Per_WholePay_Report(tf_sdate.getText(), tf_edate.getText());
            else if(global_source.equals("DistPay_Report"))
                new Per_DistPay_Report(tf_sdate.getText(), tf_edate.getText());
        }
        else if(ae.getSource() == but_cancel){
            dispose();
        }
    }
    /*
    public static void main(String args[]){
        Accept_Period obj = new Accept_Period();
    }
    */
}
