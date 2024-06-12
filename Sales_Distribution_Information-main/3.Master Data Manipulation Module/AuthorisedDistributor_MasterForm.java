import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


class AuthorisedDistributor_MasterForm extends JFrame implements ActionListener { 
    Connection con;
    Statement st;
    ResultSet rs;
    JLabel lb_title1, lb_title2, lb_distid, lb_distname, lb_address, lb_city, lb_contactperson, lb_mobile1, lb_mobile2, lb_distdate;
    JTextField tf_distid, tf_firmname, tf_address, tf_city, tf_contactperson, tf_mobile1, tf_mobile2, tf_distdate;
    JButton but_add, but_save, but_change, but_delete, but_view, but_search, but_close, but_first, but_previous, but_next, but_last;
    char chk = 'X';
    int count = 0;
    AuthorisedDistributor_MasterForm() {
        setSize(1550, 880);
        setVisible(true);
        setLayout(null);
        lb_title1 = new JLabel("Authorised Distributors");
        lb_title2 = new JLabel("Master Data Manipulation Form");
        lb_distid = new JLabel("Distributor ID No.");
        lb_distname = new JLabel("Distributor's Firm Name");
        lb_address = new JLabel("Address");
        lb_city = new JLabel("City");
        lb_contactperson = new JLabel("Contact Person");
        lb_mobile1 = new JLabel("Mobile No. 1");
        lb_mobile2 = new JLabel("Mobile No. 2");
        lb_distdate = new JLabel("Distributorship Date");
        tf_distid = new JTextField();
        tf_firmname = new JTextField();
        tf_address = new JTextField();
        tf_city = new JTextField();
        tf_contactperson = new JTextField();
        tf_mobile1 = new JTextField();
        tf_mobile2 = new JTextField();
        tf_distdate = new JTextField();
        but_add = new JButton("Add Distributor");
        but_save = new JButton("Save Record");
        but_change = new JButton("Change Record");
        but_delete = new JButton("Delete Record");
        but_view = new JButton("View All Distributors");
        but_search = new JButton("Search Record");
        but_close = new JButton("Close Form");
        but_first = new JButton("First Record");
        but_last = new JButton("Last Record");
        but_previous = new JButton("Previous Record");
        but_next = new JButton("Next Record");
        but_add.addActionListener(this);
        but_save.addActionListener(this);
        but_change.addActionListener(this);
        but_delete.addActionListener(this);
        but_view.addActionListener(this);
        but_search.addActionListener(this);
        but_close.addActionListener(this);
        but_first.addActionListener(this);
        but_last.addActionListener(this);
        but_previous.addActionListener(this);
        but_next.addActionListener(this);

        Font f1 = new Font("Arial Black", Font.PLAIN, 36);
        Font f2 = new Font("Times New Roman", Font.PLAIN, 26);
        Font f3 = new Font("Arial Black", Font.PLAIN, 32);
        lb_title1.setFont(f1);
        lb_title2.setFont(f3);
        lb_distid.setFont(f2);
        lb_distname.setFont(f2);
        lb_address.setFont(f2);
        lb_city.setFont(f2);
        lb_contactperson.setFont(f2);
        lb_mobile1.setFont(f2);
        lb_mobile2.setFont(f2);
        lb_distdate.setFont(f2);
        tf_distid.setFont(f2);
        tf_firmname.setFont(f2);
        tf_address.setFont(f2);
        tf_city.setFont(f2);
        tf_contactperson.setFont(f2);
        tf_mobile1.setFont(f2);
        tf_mobile2.setFont(f2);
        tf_distdate.setFont(f2);
        but_first.setFont(f2);
        but_last.setFont(f2);
        but_previous.setFont(f2);
        but_next.setFont(f2);
        but_add.setFont(f2);
        but_change.setFont(f2);
        but_delete.setFont(f2);
        but_view.setFont(f2);
        but_save.setFont(f2);
        but_search.setFont(f2);
        but_close.setFont(f2);

        add(lb_title1);
        add(lb_title2);
        add(lb_distid);
        add(lb_distname);
        add(lb_address);
        add(lb_city);
        add(lb_contactperson);
        add(lb_mobile1);
        add(lb_mobile2);
        add(lb_distdate);
        add(tf_distid);
        add(tf_firmname);
        add(tf_address);
        add(tf_city);
        add(tf_contactperson);
        add(tf_mobile1);
        add(tf_mobile2);
        add(tf_distdate);
        add(but_first);
        add(but_last);
        add(but_previous);
        add(but_next);
        add(but_add);
        add(but_change);
        add(but_delete);
        add(but_view);
        add(but_save);
        add(but_search);
        add(but_close);

        lb_title1.setBounds(500, 50, 500, 45);
        lb_title2.setBounds(450, 100, 600, 45);
        lb_distid.setBounds(250, 200, 250, 30);
        tf_distid.setBounds(525, 200, 100, 30);
        lb_distname.setBounds(250, 260, 275, 30);
        tf_firmname.setBounds(525, 260, 300, 30);
        lb_address.setBounds(250, 320, 250, 30);
        tf_address.setBounds(525, 320, 500, 30);
        lb_city.setBounds(250, 380, 250, 30);
        tf_city.setBounds(525, 380, 300, 30);
        lb_contactperson.setBounds(250, 440, 250, 30);
        tf_contactperson.setBounds(525, 440, 300, 30);
        lb_mobile1.setBounds(250, 500, 200, 30);
        tf_mobile1.setBounds(525, 500, 200, 30);
        lb_mobile2.setBounds(750, 500, 150, 30);
        tf_mobile2.setBounds(925, 500, 200, 30);
        lb_distdate.setBounds(250, 560, 250, 30);
        tf_distdate.setBounds(525, 560, 200, 30);
        but_add.setBounds(100, 675, 250, 30);
        but_save.setBounds(375, 675, 225, 30);
        but_change.setBounds(625, 675, 200, 30);
        but_delete.setBounds(850, 675, 200, 30);
        but_view.setBounds(1075, 675, 270, 30);
        but_first.setBounds(50, 725, 200, 30);
        but_previous.setBounds(300, 725, 220, 30);
        but_next.setBounds(575, 725, 200, 30);
        but_last.setBounds(825, 725, 200, 30);
        but_search.setBounds(1075, 725, 200, 30);
        but_close.setBounds(1300, 725, 200, 30);

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
        tf_firmname.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_firmname.getText().length() >= 30) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') {
                            return;
                        } else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z') {
                            return;
                        } else if (ke.getKeyChar() == ' ') {
                            return;
                        } else {
                            ke.consume();
                        }
                    }
                });
        tf_address.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_address.getText().length() >= 60) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') {
                            return;
                        } else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z') {
                            return;
                        } else if (ke.getKeyChar() == ' ' || ke.getKeyChar() == ',' || ke.getKeyChar() == '.'  ) {
                            return;
                        } else {
                            ke.consume();
                        }
                    }
                });

        tf_city.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_city.getText().length() >= 15) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') {
                            return;
                        } else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z') {
                            return;
                        } else if (ke.getKeyChar() == ' ') {
                            return;
                        } else {
                            ke.consume();
                        }
                    }
                });

        tf_contactperson.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_contactperson.getText().length() >= 30) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') {
                            return;
                        } else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z') {
                            return;
                        } else if (ke.getKeyChar() == ' ') {
                            return;
                        } else {
                            ke.consume();
                        }
                    }
                });

        tf_mobile1.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_mobile1.getText().length() >= 10) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();
                    }
                });
        tf_mobile2.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_mobile2.getText().length() >= 10) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();
                    }
                });
        tf_distdate.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_distdate.getText().length() >= 12) {
                            ke.consume();
                        } else {
                            return;
                        }
                    }
                });
        Connection_method();
        tf_distid.setEditable(false) ;
        tf_firmname.setEditable(false) ;
        tf_address.setEditable(false) ;
        tf_city.setEditable(false);
        tf_contactperson.setEditable(false) ;
        tf_mobile1.setEditable(false);
        tf_mobile2.setEditable(false);
        tf_distdate.setEditable(false);
        but_save.setEnabled(false);
        Buttons_Enable_Disable();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == but_add)
            Add_New_Distributor();
        else if (ae.getSource() == but_change)
            Change_Distributor();
        else if (ae.getSource() == but_save)
            Save_Distributor();
        else if (ae.getSource() == but_delete)
            Delete_Distributor();
        else if(ae.getSource() == but_view)
            View_Distributors();
        else if (ae.getSource() == but_search)
            Search_Distributor();
        else if (ae.getSource() == but_first)
            First_Distributor();
        else if (ae.getSource() == but_previous)
            Previous_Distributor();
        else if (ae.getSource() == but_next)
            Next_Distributor();
        else if (ae.getSource() == but_last)
            Last_Distributor();
        else if (ae.getSource() == but_close) {
            try{
                con.close();
            }
            catch(SQLException e3){
                JOptionPane.showMessageDialog(this, "Problem during closing Java-Oracle Connection"); 
            }
            dispose();
        }
    }

    void Connection_method() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from Distributors_Master order by Distributor_id");
            Statement stcount = con.createStatement();
            ResultSet rscount = stcount.executeQuery("select count(*) from Distributors_Master");
            rscount.next();
            count = rscount.getInt(1);
            if(count > 0){
                rs.first();
                Read_Distributors_Data();
            }
            //JOptionPane.showMessageDialog(this, "Java-Oracle Connection is established succesfully.");
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(this, "Problem in Java-Oracle Connection");
        } catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(this, "Problem when Loading the Driver.");
        }
    }

    void Add_New_Distributor(){
        int autocode = 0;
        if(count == 0)
            autocode = 1;
        else{
            try{
                rs.last();
                autocode = rs.getInt(1) + 1;
            }
            catch(SQLException e4){
                JOptionPane.showMessageDialog(this, "Problem during Generating ID for Distributor."); 
            }
        }
        tf_distid.setEditable(true) ;
        tf_distid.setText(String.valueOf(autocode));
        tf_distid.setEditable(false);
        tf_firmname.setEditable(true) ;
        tf_address.setEditable(true) ;
        tf_city.setEditable(true);
        tf_contactperson.setEditable(true) ;
        tf_mobile1.setEditable(true);
        tf_mobile2.setEditable(true);
        tf_distdate.setEditable(true);
        chk = 'A';
        but_save.setEnabled(true);
        tf_firmname.setText("");
        tf_address.setText("");
        tf_city.setText("");
        tf_contactperson.setText("");
        tf_mobile1.setText("");
        tf_mobile2.setText("");
        tf_distdate.setText(CurrentDate());
        tf_firmname.requestFocus();
    }
    void Change_Distributor(){  
        tf_firmname.setEditable(true) ;
        tf_address.setEditable(true) ;
        tf_city.setEditable(true);
        tf_contactperson.setEditable(true) ;
        tf_mobile1.setEditable(true);
        tf_mobile2.setEditable(true);
        tf_distdate.setEditable(true);
        chk = 'C';
        but_save.setEnabled(true);
    }
    void Save_Distributor(){
        if(chk == 'A'){
            if(tf_distid.getText().length() == 0 || tf_firmname.getText().length() == 0 || tf_address.getText().length() == 0 || tf_city.getText().length() == 0 || tf_contactperson.getText().length() == 0 || tf_mobile1.getText().length() == 0 || tf_distdate.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Invalid Inputs, some Textfields may be empty. Please Input Complete Data."); 
            else{
                try{
                    PreparedStatement pst = con.prepareStatement("Insert into Distributors_Master values(?, ?, ?, ?, ?, ?, ?, ?)");
                    pst.setInt(1, Integer.parseInt(tf_distid.getText()));
                    pst.setString(2, tf_firmname.getText());
                    pst.setString(3, tf_address.getText());
                    pst.setString(4, tf_city.getText());
                    pst.setString(5, tf_contactperson.getText());
                    pst.setLong(6, Long.parseLong(tf_mobile1.getText()));
                    if(tf_mobile2.getText().length() == 0)
                        pst.setLong(7, -1);
                    else
                        pst.setLong(7, Long.parseLong(tf_mobile2.getText()));
                    pst.setString(8, tf_distdate.getText());
                    pst.executeUpdate();
                    PreparedStatement pstmt = con.prepareStatement("Insert into Distributors_Bal_Pay values(?, ?)");
                    pstmt.setInt(1, Integer.parseInt(tf_distid.getText()));
                    pstmt.setInt(2, 0);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, "New Distributor's Record is Added/Saved Successfully.");
                    count++;
                    rs = st.executeQuery("select * from Distributors_Master order by Distributor_id");
                    rs.last();
                    Buttons_Enable_Disable();
                }
                catch(SQLException e5){
                    JOptionPane.showMessageDialog(this, "Problem during Generating ID for Distributor."); 
                }
            }
        }
        else if(chk == 'C'){
             if(tf_distid.getText().length() == 0 || tf_firmname.getText().length() == 0 || tf_address.getText().length() == 0 || tf_city.getText().length() == 0 || tf_contactperson.getText().length() == 0 || tf_mobile1.getText().length() == 0 || tf_distdate.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Invalid Inputs, some Textfields may be empty. Please Input Complete Data."); 
            else{
                try{
                    PreparedStatement pst = con.prepareStatement("Update Distributors_Master set Dist_Firmname = ?, Address = ?,  City = ?, Contact_person = ?, Mobile_No1 = ?, Mobile_No2 = ?, Distributorship_Date = ? where Distributor_id = ?");
                    pst.setString(1, tf_firmname.getText());
                    pst.setString(2, tf_address.getText());
                    pst.setString(3, tf_city.getText());
                    pst.setString(4, tf_contactperson.getText());
                    pst.setLong(5, Long.parseLong(tf_mobile1.getText()));
                    if(tf_mobile2.getText().length() == 0)
                        pst.setLong(6, -1);
                    else
                        pst.setLong(6, Long.parseLong(tf_mobile2.getText()));
                    pst.setString(7, tf_distdate.getText());
                    pst.setInt(8, Integer.parseInt(tf_distid.getText()));
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Distributor's Record is Updated Successfully.");
                    rs = st.executeQuery("select * from Distributors_Master order by Distributor_id");
                    while(rs.next()){
                        if(rs.getInt(1) == Integer.parseInt(tf_distid.getText()))
                            break;
                    }
                }
                catch(SQLException e5){
                    JOptionPane.showMessageDialog(this, "Problem during Generating ID for Distributor."); 
                }
            }
        }
        tf_firmname.setEditable(false) ;
        tf_address.setEditable(false) ;
        tf_city.setEditable(false);
        tf_contactperson.setEditable(false) ;
        tf_mobile1.setEditable(false);
        tf_mobile2.setEditable(false);
        tf_distdate.setEditable(false);
        chk = 'X';
        but_save.setEnabled(false);
        Buttons_Enable_Disable();
    }
    
    void Delete_Distributor() {
        int ans = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record permanently.", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
        if (ans == 0) {
            try {
                PreparedStatement pst = con.prepareStatement("delete from Distributors_Master where Distributor_id = ?");
                pst.setInt(1, Integer.parseInt(tf_distid.getText()));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Distributor's Record is Deleted Successfully.");
                count--;
                rs = st.executeQuery("select * from Distributors_Master order by Distributor_id");
                if(count == 0){
                    tf_distid.setText("");
                    tf_firmname.setText("");
                    tf_address.setText("");
                    tf_city.setText("");
                    tf_contactperson.setText("");
                    tf_mobile1.setText("");
                    tf_mobile2.setText("");
                    tf_distdate.setText("");
                } else{
                    rs.first();
                    Read_Distributors_Data();
                }
                Buttons_Enable_Disable();
            } catch (SQLException e6) {
                JOptionPane.showMessageDialog(this, "Problems when deleting the records.");
            }
        }
    }

    void Search_Distributor(){
        try {
            int distno = Integer.parseInt(
            JOptionPane.showInputDialog(this, "Enter Distributor's Id No. whose record you want to Search."));
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getInt(1) == distno) {
                    Read_Distributors_Data();
                    Buttons_Enable_Disable();
                    break;
                }
            }
            if (rs.isAfterLast()) {
                JOptionPane.showMessageDialog(this, "Distributor of Input ID No. Not Found.");
                rs.last();
                Read_Distributors_Data();
                Buttons_Enable_Disable();
            }
        } catch (SQLException e10) {
            JOptionPane.showMessageDialog(this, "Problem when Searching the Distributor's Record.");
        }
    }

    void First_Distributor(){
        try{
            rs.first();
            Read_Distributors_Data();
            Buttons_Enable_Disable();
        }
        catch(SQLException e7){
            JOptionPane.showMessageDialog(this, "Problem during navigating first record."); 
        }
    }

    void Previous_Distributor(){
        try{
            rs.previous();
            Read_Distributors_Data();
            Buttons_Enable_Disable();
        }
        catch(SQLException e8){
            JOptionPane.showMessageDialog(this, "Problem during navigating previous record."); 
        }
    }

    void Next_Distributor(){
        try{
            rs.next();
            Read_Distributors_Data();
            Buttons_Enable_Disable();
        }
        catch(SQLException e7){
            JOptionPane.showMessageDialog(this, "Problem during navigating next record."); 
        }
    }

    void Last_Distributor(){
        try{
            rs.last();
            Read_Distributors_Data();
            Buttons_Enable_Disable();
        }
        catch(SQLException e7){
            JOptionPane.showMessageDialog(this, "Problem during navigating last record."); 
        }
    }

    void Read_Distributors_Data(){
        try{
            tf_distid.setText(String.valueOf(rs.getInt(1)));
            tf_firmname.setText(rs.getString(2));
            tf_address.setText(rs.getString(3));
            tf_city.setText(rs.getString(4));
            tf_contactperson.setText(rs.getString(5));
            tf_mobile1.setText(String.valueOf(rs.getLong(6)));
            if(rs.getLong(7) == -1)
                tf_mobile2.setText("");
            else
                tf_mobile2.setText(String.valueOf(rs.getLong(7)));
            String distdate = Date_Formatting(rs.getDate(8).getDate(), rs.getDate(8).getMonth()+1, rs.getDate(8).getYear()+1900);
            tf_distdate.setText(distdate);
        }
        catch(SQLException e6){
            JOptionPane.showMessageDialog(this, "Problem during reading Distributors Data."); 
        }
    }

    void Buttons_Enable_Disable() {
        if (count == 0) {
            but_change.setEnabled(false);
            but_delete.setEnabled(false);
            but_search.setEnabled(false);
            but_first.setEnabled(false);
            but_previous.setEnabled(false);
            but_next.setEnabled(false);
            but_last.setEnabled(false);
            but_view.setEnabled(false);
        } else if (count == 1) {
            but_change.setEnabled(true);
            but_delete.setEnabled(true);
            but_search.setEnabled(false);
            but_first.setEnabled(false);
            but_previous.setEnabled(false);
            but_next.setEnabled(false);
            but_last.setEnabled(false);
            but_view.setEnabled(false);
        } else {
            but_change.setEnabled(true);
            but_delete.setEnabled(true);
            but_search.setEnabled(true);
            but_view.setEnabled(true);
            try {
                if (rs.isFirst()) {
                    but_first.setEnabled(false);
                    but_previous.setEnabled(false);
                    but_next.setEnabled(true);
                    but_last.setEnabled(true);
                } else if (rs.isLast()) {
                    but_first.setEnabled(true);
                    but_previous.setEnabled(true);
                    but_next.setEnabled(false);
                    but_last.setEnabled(false);
                } else {
                    but_first.setEnabled(true);
                    but_previous.setEnabled(true);
                    but_next.setEnabled(true);
                    but_last.setEnabled(true);
                }
            } catch (SQLException e9) {
                JOptionPane.showMessageDialog(this, "Problem during Button Enable-Disable.");
            }
        }
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
    public static void main(String args[]) {
        new AuthorisedDistributor_MasterForm();
    }
   
    void View_Distributors(){
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
        catch(SQLException e12){
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
 }  