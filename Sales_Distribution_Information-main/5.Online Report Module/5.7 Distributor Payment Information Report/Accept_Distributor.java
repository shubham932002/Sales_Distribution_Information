import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Accept_Distributor extends JFrame implements ActionListener{
    JLabel lb_title, lb_reportname, lb_distid, lb_sdate, lb_edate;
    JTextField tf_distid, tf_sdate, tf_edate;
    JButton but_viewdist, but_pro, but_cancel;
    String global_source = "";
    ResultSet rs;
    Accept_Distributor(String source){
        global_source = source;
        String x = "";
        if(source.equals("Distribution_Report"))
            x = "Distributor wise Sales Summary Report (Distributor's Sales Register)";
        else if(source.equals("Distribution_Report"))
            x = "Distributor wise Distribution Summary Report (Distributor's Distribution Register)";
        else if(source.equals("DistPay_Report"))
            x = "Distributor wise Payment Summary Report (Distributor's Payment Register)";
        setSize(900,500);
        setVisible(true);
        setLayout(null);
        lb_title = new JLabel("Enter the Period to Produce : ");
        lb_reportname = new JLabel(x);
        lb_distid = new JLabel("Distributor ID");
        lb_sdate = new JLabel("Starting Date");
        lb_edate = new JLabel("Ending Date");
        tf_distid = new JTextField("1");
        tf_sdate = new JTextField("01-DEC-2022");
        tf_edate = new JTextField("31-DEC-2022");
        but_viewdist = new JButton("Distributors List");
        but_pro = new JButton("Produce Report");
        but_cancel = new JButton("Cancel");
        but_viewdist.addActionListener(this);
        but_pro.addActionListener(this);
        but_cancel.addActionListener(this);
        Font f1, f2;
        f1 = new Font("Arial", Font.BOLD, 32);
        f2 = new Font("Times New Roman", Font.PLAIN, 24);
        lb_title.setFont(f1);
        lb_reportname.setFont(f1);
        lb_distid.setFont(f2);
        lb_sdate.setFont(f2);
        lb_edate.setFont(f2);
        tf_distid.setFont(f2);
        tf_sdate.setFont(f2);
        tf_edate.setFont(f2);
        but_viewdist.setFont(f2);
        but_pro.setFont(f2);
        but_cancel.setFont(f2);
        add(lb_title);
        add(lb_reportname);
        add(lb_distid);
        add(lb_sdate);
        add(lb_edate);
        add(tf_distid);
        add(tf_sdate);
        add(tf_edate);
        add(but_viewdist);
        add(but_pro);
        add(but_cancel);

        lb_title.setBounds(225, 100, 450, 40);
        lb_reportname.setBounds(75, 150, 800, 40);
        lb_distid.setBounds(250, 225, 150, 30);
        tf_distid.setBounds(450, 225, 75, 30);
        but_viewdist.setBounds(600, 225, 225, 30);
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
                tf_distid.addKeyListener(
                    new KeyAdapter() {
                        public void keyTyped(KeyEvent ke) {
                            if (tf_distid.getText().length() >= 3) {
                                ke.consume();
                            }
                            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                                return;
                            else
                                ke.consume();
                        }
                    });
            tf_distid.requestFocus();
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == but_viewdist)
            Distributors_List();
        else if(ae.getSource() == but_pro){
            if(global_source.equals("Distribution_Report"))
                new Dist_Distribution_Report(Integer.parseInt(tf_distid.getText()), tf_sdate.getText(), tf_edate.getText());
            else if(global_source.equals("Distribution_Report"))
                new Prod_Distribution_Report(Integer.parseInt(tf_distid.getText()), tf_sdate.getText(), tf_edate.getText());
            else if(global_source.equals("DistPay_Report"))
                new Dist_DistPay_Report(Integer.parseInt(tf_distid.getText()), tf_sdate.getText(), tf_edate.getText());
        }
        else if(ae.getSource() == but_cancel){
            dispose();
        }
    }
    void Distributors_List(){
        int count = 0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from Distributors_Master order by Distributor_id");
            Statement stcount = con.createStatement();
            ResultSet rscount = stcount.executeQuery("select count(*) from Distributors_Master");
            rscount.next();
            count = rscount.getInt(1);
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(this, "Problem in Java-Oracle Connection");
        } catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(this, "Problem when Loading the Driver.");
        }
        int distid = Integer.parseInt(tf_distid.getText());
        JFrame fview = new JFrame();
        fview.setBounds(250, 250, 800, 500);
        fview.setVisible(true);
        String data[][] = new String[count][8];
        try{
            int r = 0;
            rs.beforeFirst();
            while(rs.next()){
                data[r][0] = String.valueOf(rs.getInt(1));
                data[r][1] = rs.getString(2);
                data[r][2] = rs.getString(3);
                data[r][3] = rs.getString(4);
                data[r][4] = rs.getString(5);
                data[r][5] = String.valueOf(rs.getLong(6));
                if(rs.getLong(7) == -1)
                    data[r][6] = "";
                else
                    data[r][6] = String.valueOf(rs.getLong(7));
                data[r][7] = Date_Formatting(rs.getDate(8).getDate(), rs.getDate(8).getMonth()+1, 
                                             rs.getDate(8).getYear()+1900);
                r++;
            }
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt(1) == distid)
                    break;
            }
        }
        catch(SQLException e3){
            JOptionPane.showMessageDialog(this, "Problem during viewing the Distributors Data."); 
        }
        String colnames[] = new String[8];
        colnames[0] = "Distributor ID";
        colnames[1] = "Distributor Firm Name";
        colnames[2] = "Address";
        colnames[3] = "City";
        colnames[4] = "Contact Person";
        colnames[5] = "Mobile No. 1";
        colnames[6] = "Mobile No. 2";
        colnames[7] = "Distributorship Date";
        JTable jt = new JTable(data, colnames);
        JScrollPane jsp = new JScrollPane(jt);
        fview.add(jsp);
        jt.setEnabled(false);
    }    
    String Date_Formatting(int d, int m, int y){
        String mon = "";
        switch(m){
            case 1 : mon = "Jan";
                    break;
            case 2 : mon = "Feb";
                    break;
            case 3 : mon = "Mar";
                    break;
            case 4 : mon = "Apr";
                    break;
            case 5 : mon = "May";
                    break;
            case 6 : mon = "Jun";
                    break;
            case 7 : mon = "Jul";
                    break;
            case 8 : mon = "Aug";
                    break;
            case 9 : mon = "Sep";
                    break;
            case 10 : mon = "Oct";
                    break;
            case 11 : mon = "Nov";
                    break;
            case 12 : mon = "Dec";
                    break;
        }
        String date = d + "-" + mon + "-" + y;
        return date;
    }
    public static void main(String args[]){
        new Accept_Distributor("");
    }
    
}
