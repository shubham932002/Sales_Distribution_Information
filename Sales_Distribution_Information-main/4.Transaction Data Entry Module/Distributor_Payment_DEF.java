import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Distributor_Payment_DEF extends JFrame implements ActionListener
{
    Connection con;
    Statement st, stcount, st_distributor, st_distributor_count;
    ResultSet rs, rscount, rs_distributor, rs_distributor_count;
    JLabel lb_title1, lb_title2, lb_payno, lb_paydate, lb_distid, lb_firmname, lb_city, lb_rec_amt, lb_pay_mode;
    JTextField tf_payno, tf_paydate, tf_distid, tf_firmname, tf_city, tf_rec_amt, tf_pay_mode;
    JButton but_validate_distributor, but_distributor_list, but_add, but_save, but_search, but_close;
    int count = 0, distributor_count = 0;
    Distributor_Payment_DEF()
    {
        setSize(1550, 880);
        setVisible(true);
        setLayout(null);
        lb_title1 = new JLabel("Distributor's Payment Received Transaction");
        lb_title2 = new JLabel("(Received Pyament from Distributor against Distribution, Data Entry Form)");
        lb_payno = new JLabel("Distributors Payment Receipt No.");
        lb_paydate = new JLabel("Payment Received Date");
        lb_distid = new JLabel("Received From : Distributor ID");
        lb_firmname = new JLabel("Distributor FirmName");
        lb_city = new JLabel("City");
        lb_rec_amt = new JLabel("Received Payment Amount");
        lb_pay_mode = new JLabel("Mode of Payment");
        tf_payno = new JTextField(); 
        tf_paydate = new JTextField(); 
        tf_distid = new JTextField(); 
        tf_firmname = new JTextField(); 
        tf_city = new JTextField(); 
        tf_rec_amt = new JTextField(); 
        tf_pay_mode = new JTextField(); 
        but_validate_distributor = new JButton("Validate") ;
        but_distributor_list = new JButton("Distributors List") ;
        but_add = new JButton("Add Payment Record") ;
        but_save = new JButton("Save Payment Data") ;
        but_search = new JButton("Search Payment Bill") ;
        but_close = new JButton("Close Form");
        but_validate_distributor.addActionListener(this);
        but_distributor_list.addActionListener(this);
        but_add.addActionListener(this); 
        but_save.addActionListener(this); 
        but_search.addActionListener(this); 
        but_close.addActionListener(this);

        Font f1, f2, f3, f4;
        f1 = new Font("arial black", Font.BOLD, 36);
        f2 = new Font("arial", Font.PLAIN, 30);
        f3 = new Font("arial", Font.PLAIN, 26);
        f4 = new Font("times new roman", Font.PLAIN, 24);
        

        lb_title1.setFont(f1) ;
        lb_title2.setFont(f2) ;
        lb_payno.setFont(f3); 
        lb_paydate.setFont(f3); 
        lb_distid.setFont(f3); 
        lb_firmname.setFont(f3); 
        lb_city.setFont(f3); 
        lb_rec_amt.setFont(f3); 
        lb_pay_mode.setFont(f3);
        tf_payno.setFont(f4) ;
        tf_paydate.setFont(f4) ;
        tf_distid.setFont(f4) ;
        tf_firmname.setFont(f4) ;
        tf_city.setFont(f4) ;
        tf_rec_amt.setFont(f4) ;
        tf_pay_mode.setFont(f4) ;
        but_validate_distributor.setFont(f3) ;
        but_distributor_list.setFont(f3) ;
        but_add.setFont(f3) ;
        but_save.setFont(f3) ;
        but_search.setFont(f3) ;
        but_close.setFont(f3);



        add(lb_title1);
        add(lb_title2);
        add(lb_payno);
        add(lb_paydate);
        add(lb_distid);
        add(lb_firmname);
        add(lb_city);
        add(lb_rec_amt);
        add(lb_pay_mode);
        add(tf_payno);
        add(tf_paydate);
        add(tf_distid);
        add(tf_firmname);
        add(tf_city);
        add(tf_rec_amt);
        add(tf_pay_mode);
        add(but_validate_distributor);
        add(but_distributor_list);
        add(but_add);
        add(but_save);
        add(but_search);
        add(but_close);
        
        lb_title1.setBounds(300, 25, 1000, 42); 
        lb_title2.setBounds(280, 75, 1200, 35); 
        lb_payno.setBounds(200, 150, 400, 30); 
        tf_payno.setBounds(600, 150, 150, 30); 
        lb_paydate.setBounds(800, 150, 275, 30); 
        tf_paydate.setBounds(1100, 150, 150, 30); 
        lb_distid.setBounds(200, 225, 400, 30); 
        tf_distid.setBounds(600, 225, 100, 30); 
        but_validate_distributor.setBounds(725, 225, 150, 30); 
        but_distributor_list.setBounds(900, 225, 275, 30); 
        lb_firmname.setBounds(200, 275, 300, 30); 
        tf_firmname.setBounds(600, 275, 300, 30); 
        lb_city.setBounds(200, 325, 300, 30); 
        tf_city.setBounds(600, 325, 200, 30); 
        lb_rec_amt.setBounds(200, 400, 325, 30); 
        tf_rec_amt.setBounds(600, 400, 125, 30); 
        lb_pay_mode.setBounds(200, 450, 250, 30); 
        tf_pay_mode.setBounds(600, 450, 250, 30); 
        but_add.setBounds(200, 600, 300, 30); 
        but_save.setBounds(525, 600, 275, 30); 
        but_search.setBounds(825, 600, 275, 30); 
        but_close.setBounds(1125, 600, 200, 30);

        tf_payno.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_payno.getText().length() >= 6) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();
                    }
                });
        tf_paydate.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_paydate.getText().length() >= 12) {
                            ke.consume();
                        } else {
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
        tf_rec_amt.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_rec_amt.getText().length() >= 7) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();
                    }
                });
        tf_pay_mode.addKeyListener(
                    new KeyAdapter() {
                        public void keyTyped(KeyEvent ke) {
                            if (tf_pay_mode.getText().length() >= 30) {
                                ke.consume();
                            } else {
                                return;
                            }
                        }
                    });
        tf_payno.setEditable(false); 
        tf_paydate.setEditable(false); 
        tf_distid.setEditable(false); 
        tf_firmname.setEditable(false); 
        tf_city.setEditable(false); 
        tf_rec_amt.setEditable(false); 
        tf_pay_mode.setEditable(false); 
        but_validate_distributor.setEnabled(false);
        but_distributor_list.setEnabled(false);
        but_save.setEnabled(false);
        Connection_method();
        if(count <= 1)
            but_search.setEnabled(false);
        else
            but_search.setEnabled(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == but_add)
        {
            Payment_Add();    
        }
        else if(ae.getSource() == but_save)
        {
            Payment_Save();
        }
        else if(ae.getSource() == but_search)
        {
            Payment_Search();
        }
        else if(ae.getSource() == but_close)
        {
            dispose();
        }
        else if(ae.getSource() == but_validate_distributor)
        {
            Distributor_Validate();
        }
        else if(ae.getSource() == but_distributor_list)
        {
            Distributors_List();
        }
    }
    void Connection_method() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from Distributors_Payment order by Dist_Pay_recno");
            stcount = con.createStatement();
            rscount = stcount.executeQuery("select count(*) from Distributors_Payment");
            rscount.next();
            count = rscount.getInt(1);
            st_distributor = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs_distributor = st_distributor.executeQuery("select * from Distributors_Master order by Distributor_id");
            st_distributor_count = con.createStatement();
            rs_distributor_count = st_distributor_count.executeQuery("select count(*) from Distributors_Master");
            rs_distributor_count.next();
            distributor_count = rs_distributor_count.getInt(1);
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(this, "Problem in Java-Oracle Connection");
        } catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(this, "Problem when Loading the Driver.");
        }
    }

    void Payment_Add(){
        int autocode = 0;
        if(count == 0)
            autocode = 1;
        else{
            try{
                rs.last();
                autocode = rs.getInt(1) + 1;
            }
            catch(SQLException e3){
                JOptionPane.showMessageDialog(this, "Problem during Generating Distributors Payment Receipt Number."); 
            }
        }
        tf_payno.setEditable(true) ;
        tf_payno.setText(String.valueOf(autocode));
        tf_payno.setEditable(false);
        tf_paydate.setEditable(true);
        tf_distid.setEditable(true);
        tf_rec_amt.setEditable(true) ;
        tf_pay_mode.setEditable(true);
        but_save.setEnabled(true);
        but_add.setEnabled(false);
        but_search.setEnabled(false);
        but_validate_distributor.setEnabled(true);
        but_distributor_list.setEnabled(true);
        tf_paydate.setText(CurrentDate()); 
        tf_distid.setText(""); 
        tf_firmname.setText(""); 
        tf_city.setText(""); 
        tf_rec_amt.setText(""); 
        tf_pay_mode.setText(""); 
        tf_paydate.requestFocus();
    }

    void Payment_Save(){
        if(tf_payno.getText().length() == 0 || tf_paydate.getText().length() == 0 ||  tf_distid.getText().length() == 0 || tf_rec_amt.getText().length() == 0 || tf_pay_mode.getText().length() == 0 )
            JOptionPane.showMessageDialog(this, "Invalid Inputs, some Textfields may be empty. Please Input Complete Data."); 
        else{
            try{
                PreparedStatement pst = con.prepareStatement("Insert into Distributors_Payment values(?, ?, ?, ?, ?)");
                pst.setInt(1, Integer.parseInt(tf_payno.getText()));
                pst.setString(2, tf_paydate.getText());
                pst.setInt(3, Integer.parseInt(tf_distid.getText()));
                pst.setInt(4, Integer.parseInt(tf_rec_amt.getText()));
                pst.setString(5, tf_pay_mode.getText());
                pst.executeUpdate();
                PreparedStatement pst_balpay = con.prepareStatement("Update Distributors_Bal_Pay set Balance_Amount = Balance_Amount - ? where Distributor_id = ?");
                pst_balpay.setInt(1, Integer.parseInt(tf_rec_amt.getText()));
                pst_balpay.setInt(2, Integer.parseInt(tf_distid.getText()));
                pst_balpay.executeUpdate();
                JOptionPane.showMessageDialog(this, "New Distributor's Payment Record is Saved Successfully.");
                count++;
                rs = st.executeQuery("select * from Distributors_Payment order by Dist_Pay_Recno");     
                   
            }
            catch(SQLException e4){
                JOptionPane.showMessageDialog(this, "Problem during Saving Record."); 
            }
        }
    tf_payno.setEditable(false);
    tf_paydate.setEditable(false);
    tf_distid.setEditable(false) ;
    tf_rec_amt.setEditable(false);
    tf_pay_mode.setEditable(false);
    but_add.setEnabled(true);
    but_search.setEnabled(true);
    but_save.setEnabled(false);
    but_validate_distributor.setEnabled(false);
    but_distributor_list.setEnabled(false);
}

void Payment_Search() {
    try {
        int payno = Integer.parseInt(
                JOptionPane.showInputDialog(this, "Enter Payment Receipt No. whose record you want to Search."));
        rs.beforeFirst();
        while (rs.next()) {
            if (rs.getInt(1) == payno)
                break;
            }
        if (rs.isAfterLast())
            JOptionPane.showMessageDialog(this, "Record of Input Payment Receipt No. Not Found.");
        else{
            tf_payno.setText(String.valueOf(rs.getInt(1)));
            tf_paydate.setText(Date_Formatting(rs.getDate(2).getDate(), rs.getDate(2).getMonth()+1, 
            rs.getDate(2).getYear()+1900));
            tf_distid.setText(String.valueOf(rs.getInt(3)));
            rs_distributor.beforeFirst();
            while(rs_distributor.next()){
                if(rs_distributor.getInt(1) == Integer.parseInt(tf_distid.getText()))
                    break;
            }
            if(rs_distributor.isAfterLast()){
                JOptionPane.showMessageDialog(this, "Input Distributor ID is Invalid. Please Enter Correct Distributor ID.");
            }
            else{
                tf_firmname.setText(rs_distributor.getString(2));
                tf_city.setText(rs_distributor.getString(4));
            } 
            tf_rec_amt.setText(String.valueOf(rs.getInt(4)));
            tf_pay_mode.setText(rs.getString(5));
        }
    } catch (SQLException e7) {
        JOptionPane.showMessageDialog(this, "Problem when Searching the Record.");
    }
}
void Distributor_Validate(){
    if(tf_distid.getText().length() == 0)
        JOptionPane.showMessageDialog(this, "Distributor ID is Empty, so cannot Validate. Please enter Valid Distributor ID.");
    else if(distributor_count == 0)
        JOptionPane.showMessageDialog(this, "No Records in DISTRIBUTORS_MASTER, so Cannot Validate.");
    else{
        try{
            rs_distributor.beforeFirst();
            while(rs_distributor.next()){
                if(rs_distributor.getInt(1) == Integer.parseInt(tf_distid.getText()))
                    break;
            }
            if(rs_distributor.isAfterLast()){
                tf_distid.requestFocus();
                JOptionPane.showMessageDialog(this, "Input Distributor's ID is Invalid. Please Enter Correct Distributor ID.");
            }
            else{
                tf_firmname.setText(rs_distributor.getString(2));
                tf_city.setText(rs_distributor.getString(4));
            }
        }
        catch(SQLException e5){
            JOptionPane.showMessageDialog(this,"Problem during Distributor's ID Validation.");
        }
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

    String CurrentDate(){
        java.util.Date obj = new java.util.Date();
        int d = obj.getDate();
        int m = obj.getMonth() + 1;
        int y = obj.getYear() + 1900;
        String mon = "";
        switch(m){
            case 1 : mon = "JAN";       
                    break;
            case 2 : mon = "FEB";       
                    break;
            case 3 : mon = "MAR";       
                    break;
           case 4 : mon = "APR";       
                    break;
            case 5 : mon = "MAY";       
                    break;
            case 6 : mon = "JUN";       
                    break;
            case 7 : mon = "JUL";       
                    break;
            case 8 : mon = "AUG";       
                    break;
            case 9 : mon = "SEP";       
                    break;
            case 10 : mon = "OCT";       
                    break;
            case 11 : mon = "NOV";       
                    break;
            case 12 : mon = "DEC";       
                    break;
        }
        String cdate;
        if(d >=10)
            cdate = d + "-" + mon + "-" + y;
        else 
            cdate = "0" + d + "-" + mon + "-" + y;
        //System.out.println("Current Date is : "+cdate);
        return cdate;
    }

    public static void main(String args[])
    {
        new Distributor_Payment_DEF();
    }
}
