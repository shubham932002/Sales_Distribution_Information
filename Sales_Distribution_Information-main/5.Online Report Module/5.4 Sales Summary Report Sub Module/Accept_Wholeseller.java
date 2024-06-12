import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Accept_Wholeseller extends JFrame implements ActionListener{
    JLabel lb_title, lb_reportname, lb_wholeid, lb_sdate, lb_edate;
    JTextField tf_wholeid, tf_sdate, tf_edate;
    JButton but_viewwhole, but_pro, but_cancel;
    String global_source = "";
    ResultSet rs;
    Accept_Wholeseller(String source){
        global_source = source;
        String x = "";
        if(source.equals("Sales_Report"))
            x = "Wholeseller wise Sales Summary Report (Wholeseller's Sales Register)";
        else if(source.equals("Distribution_Report"))
            x = "Wholeseller wise Distribution Summary Report (Wholeseller's Distribution Register)";
        else if(source.equals("WholePay_Report"))
            x = "Wholeseller wise Payment Summary Report (Wholeseller's Payment Register)";
        setSize(900,500);
        setVisible(true);
        setLayout(null);
        lb_title = new JLabel("Enter the Period to Produce : ");
        lb_reportname = new JLabel(x);
        lb_wholeid = new JLabel("Wholeseller ID");
        lb_sdate = new JLabel("Starting Date");
        lb_edate = new JLabel("Ending Date");
        tf_wholeid = new JTextField("1");
        tf_sdate = new JTextField("01-DEC-2022");
        tf_edate = new JTextField("31-DEC-2022");
        but_viewwhole = new JButton("Wholesellers List");
        but_pro = new JButton("Produce Report");
        but_cancel = new JButton("Cancel");
        but_viewwhole.addActionListener(this);
        but_pro.addActionListener(this);
        but_cancel.addActionListener(this);
        Font f1, f2;
        f1 = new Font("Arial", Font.BOLD, 32);
        f2 = new Font("Times New Roman", Font.PLAIN, 24);
        lb_title.setFont(f1);
        lb_reportname.setFont(f1);
        lb_wholeid.setFont(f2);
        lb_sdate.setFont(f2);
        lb_edate.setFont(f2);
        tf_wholeid.setFont(f2);
        tf_sdate.setFont(f2);
        tf_edate.setFont(f2);
        but_viewwhole.setFont(f2);
        but_pro.setFont(f2);
        but_cancel.setFont(f2);
        add(lb_title);
        add(lb_reportname);
        add(lb_wholeid);
        add(lb_sdate);
        add(lb_edate);
        add(tf_wholeid);
        add(tf_sdate);
        add(tf_edate);
        add(but_viewwhole);
        add(but_pro);
        add(but_cancel);

        lb_title.setBounds(225, 100, 450, 40);
        lb_reportname.setBounds(75, 150, 800, 40);
        lb_wholeid.setBounds(250, 225, 150, 30);
        tf_wholeid.setBounds(450, 225, 75, 30);
        but_viewwhole.setBounds(600, 225, 225, 30);
        lb_sdate.setBounds(250, 275, 150, 30);
        tf_sdate.setBounds(450, 275, 150, 30);
        lb_edate.setBounds(250, 325, 150, 30);
        tf_edate.setBounds(450, 325, 150, 30);
        but_pro.setBounds(200, 400, 250, 30);
        but_cancel.setBounds(500, 400, 150, 30);

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
                tf_wholeid.addKeyListener(
                    new KeyAdapter() {
                        public void keyTyped(KeyEvent ke) {
                            if (tf_wholeid.getText().length() >= 3) {
                                ke.consume();
                            }
                            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                                return;
                            else
                                ke.consume();
                        }
                    });
            tf_wholeid.requestFocus();
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == but_viewwhole)
            Wholesellers_List();
        else if(ae.getSource() == but_pro){
            if(global_source.equals("Sales_Report"))
                new Whole_Sales_Report(Integer.parseInt(tf_wholeid.getText()), tf_sdate.getText(), tf_edate.getText());
            else if(global_source.equals("Distribution_Report"))
                new Prod_Distribution_Report(Integer.parseInt(tf_wholeid.getText()), tf_sdate.getText(), tf_edate.getText());
            else if(global_source.equals("WholePay_Report"))
                new Whole_WholePay_Report(Integer.parseInt(tf_wholeid.getText()),tf_sdate.getText(), tf_edate.getText());
        }
        else if(ae.getSource() == but_cancel){
            dispose();
        }
    }
    void Wholesellers_List(){
        int count = 0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from Wholesellers_Master order by Wholeseller_id");
            Statement stcount = con.createStatement();
            ResultSet rscount = stcount.executeQuery("select count(*) from Wholesellers_Master");
            rscount.next();
            count = rscount.getInt(1);
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(this, "Problem in Java-Oracle Connection");
        } catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(this, "Problem when Loading the Driver.");
        }
        int wholeid = Integer.parseInt(tf_wholeid.getText());
        JFrame fview = new JFrame();
        fview.setBounds(250, 250, 800, 500);
        fview.setVisible(true);
        String data[][] = new String[count][7];
        try{
            int r = 0;
            rs.beforeFirst();
            while(rs.next()){
                data[r][0] = String.valueOf(rs.getInt(1));
                data[r][1] = rs.getString(2);
                data[r][2] = rs.getString(3);
                data[r][3] = rs.getString(4);
                data[r][4] = String.valueOf(rs.getLong(5));
                if(rs.getLong(6) == -1)
                    data[r][5] = "";
                else
                    data[r][5] = String.valueOf(rs.getLong(6));
                data[r][6] = rs.getString(7);
                r++;
            }
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt(1) == wholeid)
                    break;
            }
        }
        catch(SQLException e12){
            JOptionPane.showMessageDialog(this, "Problem during viewing the Wholesellers Data."); 
        }
        String colnames[] = new String[7];
        colnames[0] = "Wholeseller ID";
        colnames[1] = "Wholeseller Name";
        colnames[2] = "Address";
        colnames[3] = "City";
        colnames[4] = "Mobile No. 1";
        colnames[5] = "Mobile No. 2";
        colnames[6] = "Business Nature";
        JTable jt = new JTable(data, colnames);
        JScrollPane jsp = new JScrollPane(jt);
        fview.add(jsp);
        jt.setEnabled(false);
    }
    public static void main(String args[]){
        new Accept_Wholeseller("");
    }
    
}
