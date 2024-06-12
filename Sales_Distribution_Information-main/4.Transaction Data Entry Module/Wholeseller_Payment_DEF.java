import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Wholeseller_Payment_DEF extends JFrame implements ActionListener
{
    Connection con;
    Statement st, stcount, st_wholeseller, st_wholeseller_count;
    ResultSet rs, rscount, rs_wholeseller, rs_wholeseller_count;
    JLabel lb_title1, lb_title2, lb_payno, lb_paydate, lb_wholeid, lb_wholename, lb_city, lb_rec_amt, lb_pay_mode;
    JTextField tf_payno, tf_paydate, tf_wholesellerid, tf_wholesellername, tf_city, tf_rec_amt, tf_pay_mode;
    JButton but_validate_wholeseller, but_wholesellers_list, but_add, but_save, but_search, but_close;
    int count = 0, wholeseller_count = 0;
    Wholeseller_Payment_DEF()
    {
        setSize(1550, 880);
        setVisible(true);
        setLayout(null);
        lb_title1 = new JLabel("Wholeseller's Payment Received Transaction");
        lb_title2 = new JLabel("(Received Pyament from Wholeseller against Sales, Data Entry Form)");
        lb_payno = new JLabel("Wholeseller Payment Receipt No.");
        lb_paydate = new JLabel("Payment Received Date");
        lb_wholeid = new JLabel("Received From : Wholeseller ID");
        lb_wholename = new JLabel("Wholeseller Name");
        lb_city = new JLabel("City");
        lb_rec_amt = new JLabel("Received Payment Amount");
        lb_pay_mode = new JLabel("Mode of Payment");
        tf_payno = new JTextField(); 
        tf_paydate = new JTextField(); 
        tf_wholesellerid = new JTextField(); 
        tf_wholesellername = new JTextField(); 
        tf_city = new JTextField(); 
        tf_rec_amt = new JTextField(); 
        tf_pay_mode = new JTextField(); 
        but_validate_wholeseller = new JButton("Validate") ;
        but_wholesellers_list = new JButton("Wholesellers List") ;
        but_add = new JButton("Add Payment Record") ;
        but_save = new JButton("Save Payment Data") ;
        but_search = new JButton("Search Payment Bill") ;
        but_close = new JButton("Close Form");
        but_validate_wholeseller.addActionListener(this);
        but_wholesellers_list.addActionListener(this);
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
        lb_wholeid.setFont(f3); 
        lb_wholename.setFont(f3); 
        lb_city.setFont(f3); 
        lb_rec_amt.setFont(f3); 
        lb_pay_mode.setFont(f3);
        tf_payno.setFont(f4) ;
        tf_paydate.setFont(f4) ;
        tf_wholesellerid.setFont(f4) ;
        tf_wholesellername.setFont(f4) ;
        tf_city.setFont(f4) ;
        tf_rec_amt.setFont(f4) ;
        tf_pay_mode.setFont(f4) ;
        but_validate_wholeseller.setFont(f3) ;
        but_wholesellers_list.setFont(f3) ;
        but_add.setFont(f3) ;
        but_save.setFont(f3) ;
        but_search.setFont(f3) ;
        but_close.setFont(f3);



        add(lb_title1);
        add(lb_title2);
        add(lb_payno);
        add(lb_paydate);
        add(lb_wholeid);
        add(lb_wholename);
        add(lb_city);
        add(lb_rec_amt);
        add(lb_pay_mode);
        add(tf_payno);
        add(tf_paydate);
        add(tf_wholesellerid);
        add(tf_wholesellername);
        add(tf_city);
        add(tf_rec_amt);
        add(tf_pay_mode);
        add(but_validate_wholeseller);
        add(but_wholesellers_list);
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
        lb_wholeid.setBounds(200, 225, 400, 30); 
        tf_wholesellerid.setBounds(600, 225, 100, 30); 
        but_validate_wholeseller.setBounds(725, 225, 150, 30); 
        but_wholesellers_list.setBounds(900, 225, 275, 30); 
        lb_wholename.setBounds(200, 275, 300, 30); 
        tf_wholesellername.setBounds(600, 275, 300, 30); 
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
        tf_wholesellerid.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_wholesellerid.getText().length() >= 3) {
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
        tf_wholesellerid.setEditable(false); 
        tf_wholesellername.setEditable(false); 
        tf_city.setEditable(false); 
        tf_rec_amt.setEditable(false); 
        tf_pay_mode.setEditable(false); 
        but_validate_wholeseller.setEnabled(false);
        but_wholesellers_list.setEnabled(false);
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
        else if(ae.getSource() == but_validate_wholeseller)
        {
            Wholeseller_Validate();
        }
        else if(ae.getSource() == but_wholesellers_list)
        {
            Wholesellers_List();
        }
    }
    void Connection_method() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from Wholesellers_Payment order by Whol_Pay_recno");
            stcount = con.createStatement();
            rscount = stcount.executeQuery("select count(*) from Wholesellers_Payment");
            rscount.next();
            count = rscount.getInt(1);
            st_wholeseller = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs_wholeseller = st_wholeseller.executeQuery("select * from Wholesellers_Master order by Wholeseller_id");
            st_wholeseller_count = con.createStatement();
            rs_wholeseller_count = st_wholeseller_count.executeQuery("select count(*) from Wholesellers_Master");
            rs_wholeseller_count.next();
            wholeseller_count = rs_wholeseller_count.getInt(1);
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
                JOptionPane.showMessageDialog(this, "Problem during Generating Wholesellers Payment Receipt Number."); 
            }
        }
        tf_payno.setEditable(true) ;
        tf_payno.setText(String.valueOf(autocode));
        tf_payno.setEditable(false);
        tf_paydate.setEditable(true);
        tf_wholesellerid.setEditable(true);
        tf_rec_amt.setEditable(true) ;
        tf_pay_mode.setEditable(true);
        but_save.setEnabled(true);
        but_add.setEnabled(false);
        but_search.setEnabled(false);
        but_validate_wholeseller.setEnabled(true);
        but_wholesellers_list.setEnabled(true);
        tf_paydate.setText(CurrentDate()); 
        tf_wholesellerid.setText(""); 
        tf_wholesellername.setText(""); 
        tf_city.setText(""); 
        tf_rec_amt.setText(""); 
        tf_pay_mode.setText(""); 
        tf_paydate.requestFocus();
    }

    void Payment_Save(){
        if(tf_payno.getText().length() == 0 || tf_paydate.getText().length() == 0 ||  tf_wholesellerid.getText().length() == 0 || tf_rec_amt.getText().length() == 0 || tf_pay_mode.getText().length() == 0 )
            JOptionPane.showMessageDialog(this, "Invalid Inputs, some Textfields may be empty. Please Input Complete Data."); 
        else{
            try{
                PreparedStatement pst = con.prepareStatement("Insert into Wholesellers_Payment values(?, ?, ?, ?, ?)");
                pst.setInt(1, Integer.parseInt(tf_payno.getText()));
                pst.setString(2, tf_paydate.getText());
                pst.setInt(3, Integer.parseInt(tf_wholesellerid.getText()));
                pst.setInt(4, Integer.parseInt(tf_rec_amt.getText()));
                pst.setString(5, tf_pay_mode.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "New Wholeseller's Payment Record is Saved Successfully.");
                count++;
                rs = st.executeQuery("select * from Wholesellers_Payment order by Whol_Pay_Recno");        
            }
            catch(SQLException e4){
                JOptionPane.showMessageDialog(this, "Problem during Saving Record."); 
            }
        }
    tf_payno.setEditable(false);
    tf_paydate.setEditable(false);
    tf_wholesellerid.setEditable(false) ;
    tf_rec_amt.setEditable(false);
    tf_pay_mode.setEditable(false);
    but_add.setEnabled(true);
    but_search.setEnabled(true);
    but_save.setEnabled(false);
    but_validate_wholeseller.setEnabled(false);
    but_wholesellers_list.setEnabled(false);
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
            tf_wholesellerid.setText(String.valueOf(rs.getInt(3)));
            rs_wholeseller.beforeFirst();
            while(rs_wholeseller.next()){
                if(rs_wholeseller.getInt(1) == Integer.parseInt(tf_wholesellerid.getText()))
                    break;
            }
            if(rs_wholeseller.isAfterLast()){
                JOptionPane.showMessageDialog(this, "Input Wholeseller ID is Invalid. Please Enter Correct Wholeseller ID.");
            }
            else{
                tf_wholesellername.setText(rs_wholeseller.getString(2));
                tf_city.setText(rs_wholeseller.getString(4));
            } 
            tf_rec_amt.setText(String.valueOf(rs.getInt(4)));
            tf_pay_mode.setText(rs.getString(5));
        }
    } catch (SQLException e7) {
        JOptionPane.showMessageDialog(this, "Problem when Searching the Record.");
    }
}
void Wholeseller_Validate(){
        if(tf_wholesellerid.getText().length() == 0)
            JOptionPane.showMessageDialog(this, "Wholeseller ID is Empty, so cannot Validate. Please enter Valid Wholeseller ID.");
        else if(wholeseller_count == 0)
            JOptionPane.showMessageDialog(this, "No Records in WHOLESELLERS_MASTER, so Cannot Validate.");
        else{
            try{
                rs_wholeseller.beforeFirst();
                while(rs_wholeseller.next()){
                    if(rs_wholeseller.getInt(1) == Integer.parseInt(tf_wholesellerid.getText()))
                        break;
                }
                if(rs_wholeseller.isAfterLast()){
                    tf_wholesellerid.requestFocus();
                    JOptionPane.showMessageDialog(this, "Input Wholeseller's ID is Invalid. Please Enter Correct Wholeseller ID.");
                }
                else{
                    tf_wholesellername.setText(rs_wholeseller.getString(2));
                    tf_city.setText(rs_wholeseller.getString(4));
                }
            }
            catch(SQLException e5){
                JOptionPane.showMessageDialog(this,"Problem during Wholeseller ID Validation.");
            }
        }
    } 

    void Wholesellers_List(){
        JFrame fview = new JFrame();
        fview.setBounds(375, 200, 800, 500);
        fview.setVisible(true);
        String data[][] = new String[wholeseller_count][7];
        try{
            int r = 0;
            rs_wholeseller.beforeFirst();
            while(rs_wholeseller.next()){
                data[r][0] = String.valueOf(rs_wholeseller.getInt(1));
                data[r][1] = rs_wholeseller.getString(2);
                data[r][2] = rs_wholeseller.getString(3);
                data[r][3] = rs_wholeseller.getString(4);
                data[r][4] = String.valueOf(rs_wholeseller.getLong(5));
                if(rs_wholeseller.getLong(6) == -1)
                    data[r][5] = "";
                else
                    data[r][5] = String.valueOf(rs_wholeseller.getLong(6));
                data[r][6] = rs_wholeseller.getString(7);
                r++;
            } 
        }
        catch(SQLException e6){
            JOptionPane.showMessageDialog(this, "Problem during viewing the Wholesellers Data."); 
        }
        String colnames[] = new String[7];
        colnames[0] = "Wholeseller ID";
        colnames[1] = "Wholeseller Name";
        colnames[2] = "Address";
        colnames[3] = "City";
        colnames[4] = "Mobile Number 1";
        colnames[5] = "Mobile Number 1";
        colnames[6] = "Business Nature";
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
        new Wholeseller_Payment_DEF();
    }
}
