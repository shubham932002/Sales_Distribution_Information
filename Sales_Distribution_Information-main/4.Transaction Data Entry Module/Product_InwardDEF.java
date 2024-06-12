
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Product_InwardDEF extends JFrame implements ActionListener
{
    Connection con;
    Statement st, stcount, st_prod, st_prodcount;
    ResultSet rs, rscount, rs_prod, rs_prodcount;
    JLabel lb_title1, lb_title2, lb_inwardno, lb_inwarddate, lb_prodid, lb_prodname, lb_produnit, lb_prodmrp, lb_inwardqty;
    JTextField tf_inwardno, tf_inwarddate, tf_prodid, tf_prodname, tf_produnit, tf_prodmrp, tf_inwardqty;
    JButton but_validate, but_viewpro, but_add, but_save, but_search, but_close;
    int count = 0, prodcount = 0;
    Product_InwardDEF()
    {
        setSize(1550, 880);
        setVisible(true);
        setLayout(null);
        lb_title1 = new JLabel("Manufactured Product's : Inward Transaction");
        lb_title2 = new JLabel("(Inward Products towards Sales Department, Data Entry Form)");
        lb_inwardno = new JLabel("Inward Entry No.");
        lb_inwarddate = new JLabel("Inward Date");
        lb_prodid = new JLabel("Inwarded Products ID");
        lb_prodname = new JLabel("Product Name");
        lb_produnit = new JLabel("Packaging Unit");
        lb_prodmrp = new JLabel("Product MRP");
        lb_inwardqty = new JLabel("Inward Quantity");
        tf_inwardno = new JTextField();
        tf_inwarddate = new JTextField();
        tf_prodid = new JTextField();
        tf_prodname = new JTextField();
        tf_produnit = new JTextField();
        tf_prodmrp = new JTextField();
        tf_inwardqty = new JTextField();
        but_add = new JButton("Add Inward Product");
        but_save = new JButton("Save Record");
        but_search = new JButton("Search Inward Product");
        but_close = new JButton("Close Form");
        but_validate = new JButton("Validate Product");
        but_viewpro = new JButton("View Products");
        but_add.addActionListener(this);
        but_save.addActionListener(this);
        but_search.addActionListener(this);
        but_close.addActionListener(this);
        but_validate.addActionListener(this);
        but_viewpro.addActionListener(this);

        Font f1, f2, f3, f4;
        f1 = new Font("arial black", Font.BOLD, 36);
        f2 = new Font("arial", Font.PLAIN, 30);
        f3 = new Font("arial", Font.PLAIN, 26);
        f4 = new Font("times new roman", Font.PLAIN, 24);
        lb_title1.setFont(f1);
        lb_title2.setFont(f2);
        lb_inwardno.setFont(f3);
        lb_inwarddate.setFont(f3);
        lb_prodid.setFont(f3);
        lb_prodname.setFont(f3);
        lb_produnit.setFont(f3);
        lb_prodmrp.setFont(f3);
        lb_inwardqty.setFont(f3);
        tf_inwardno.setFont(f4);
        tf_inwarddate.setFont(f4);
        tf_prodid.setFont(f4);
        tf_prodname.setFont(f4);
        tf_produnit.setFont(f4);
        tf_prodmrp.setFont(f4);
        tf_inwardqty.setFont(f4);
        but_add.setFont(f3);
        but_save.setFont(f3);
        but_search.setFont(f3);
        but_close.setFont(f3);
        but_validate.setFont(f3);
        but_viewpro.setFont(f3);

        add(lb_title1);
        add(lb_title2);
        add(lb_inwardno);
        add(lb_inwarddate);
        add(lb_prodid);
        add(lb_prodname);
        add(lb_produnit);
        add(lb_prodmrp);
        add(lb_inwardqty);
        add(tf_inwardno);
        add(tf_inwarddate);
        add(tf_prodid);
        add(tf_prodname);
        add(tf_produnit);
        add(tf_prodmrp);
        add(tf_inwardqty);
        add(but_add);
        add(but_save);
        add(but_search);
        add(but_close);  
        add(but_validate);
        add(but_viewpro);

        lb_title1.setBounds(300, 50, 1000, 40);
        lb_title2.setBounds(325, 100, 1000, 35); 
        lb_inwardno.setBounds(300, 200, 250, 30); 
        tf_inwardno.setBounds(575, 200, 75, 30); 
        lb_inwarddate.setBounds(800, 200, 150, 30); 
        tf_inwarddate.setBounds(975, 200, 150, 30); 
        lb_prodid.setBounds(300, 250, 250, 30); 
        tf_prodid.setBounds(575, 250, 75, 30);
        but_validate.setBounds(675, 250, 225, 30); 
        but_viewpro.setBounds(925, 250, 225, 30);
        lb_prodname.setBounds(300, 300, 250, 30); 
        tf_prodname.setBounds(575, 300, 275, 30); 
        lb_produnit.setBounds(300, 350, 250, 30); 
        tf_produnit.setBounds(575, 350, 350, 30); 
        lb_prodmrp.setBounds(300, 400, 250, 30); 
        tf_prodmrp.setBounds(575, 400, 125, 30); 
        lb_inwardqty.setBounds(300, 450, 250, 30);
        tf_inwardqty.setBounds(575, 450, 100, 30);
        but_add.setBounds(200, 600, 275, 30); 
        but_save.setBounds(525, 600, 200, 30); 
        but_search.setBounds(775, 600, 300, 30); 
        but_close.setBounds(1125, 600, 200, 30);
        
        tf_inwardno.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_inwardno.getText().length() >= 6) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();
                    }
                });
        tf_inwarddate.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_inwarddate.getText().length() >= 12) {
                            ke.consume();
                        } else {
                            return;
                        }
                    }
                });
        tf_prodid.addKeyListener(
                    new KeyAdapter() {
                        public void keyTyped(KeyEvent ke) {
                            if (tf_prodid.getText().length() >= 3) {
                                ke.consume();
                            }
                            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                                return;
                            else
                                ke.consume();
                        }
                    });
        tf_inwardqty.addKeyListener(
                        new KeyAdapter() {
                            public void keyTyped(KeyEvent ke) {
                                if (tf_inwardqty.getText().length() >= 3) {
                                    ke.consume();
                                }
                                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                                    return;
                                else
                                    ke.consume();
                            }
                        });
        tf_inwardno.setEditable(false);
        tf_inwarddate.setEditable(false);
        tf_prodid.setEditable(false);
        tf_prodname.setEditable(false);
        tf_produnit.setEditable(false);
        tf_prodmrp.setEditable(false);
        tf_inwardqty.setEditable(false);
        but_save.setEnabled(false);
        but_validate.setEnabled(false);
        but_viewpro.setEnabled(false);
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
           Inward_Add();
        }
        else if(ae.getSource() == but_save)
        {
            Inward_Save();
        }
        else if(ae.getSource() == but_search)
        {
            Inward_Search();
        }
        else if(ae.getSource() == but_close)
        {
            dispose();
        }
        else if(ae.getSource() == but_validate)
        {
            Product_Validate();
        }
        else if(ae.getSource() == but_viewpro)
        {
            View_Products();
        }
    }
    void Connection_method() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from Products_Inward order by Inward_Entryno");
            stcount = con.createStatement();
            rscount = stcount.executeQuery("select count(*) from Products_Inward");
            rscount.next();
            count = rscount.getInt(1);
            st_prod = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs_prod = st_prod.executeQuery("select * from Products_Master order by Product_id");
            st_prodcount = con.createStatement();
            rs_prodcount = st_prodcount.executeQuery("select count(*) from Products_Master");
            rs_prodcount.next();
                prodcount = rs_prodcount.getInt(1);
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(this, "Problem in Java-Oracle Connection");
        } catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(this, "Problem when Loading the Driver.");
        }
    }

    void Inward_Add(){
        int autocode = 0;
        if(count == 0)
            autocode = 1;
        else{
            try{
                rs.last();
                autocode = rs.getInt(1) + 1;
            }
            catch(SQLException e3){
                JOptionPane.showMessageDialog(this, "Problem during Generating Inward Entry Number."); 
            }
        }
        tf_inwardno.setEditable(true) ;
        tf_inwardno.setText(String.valueOf(autocode));
        tf_inwardno.setEditable(false);
        tf_inwarddate.setEditable(true);
        tf_prodid.setEditable(true) ;
        tf_inwardqty.setEditable(true);
        but_add.setEnabled(false);
        but_search.setEnabled(false);
        but_save.setEnabled(true);
        but_validate.setEnabled(true);
        but_viewpro.setEnabled(true);
        tf_inwarddate.setText(CurrentDate());
        tf_prodid.setText("");
        tf_inwardqty.setText("");
        tf_prodname.setText("");
        tf_produnit.setText("");
        tf_prodmrp.setText("");
        tf_inwarddate.requestFocus();
    }
    void Inward_Save(){
            if(tf_inwardno.getText().length() == 0 || tf_inwarddate.getText().length() == 0 || tf_prodid.getText().length() == 0 || tf_inwardqty.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Invalid Inputs, some Textfields may be empty. Please Input Complete Data."); 
            else{
                try{
                    PreparedStatement pst = con.prepareStatement("Insert into Products_Inward values(?, ?, ?, ?)");
                    pst.setInt(1, Integer.parseInt(tf_inwardno.getText()));
                    pst.setString(2, tf_inwarddate.getText());
                    pst.setInt(3, Integer.parseInt(tf_prodid.getText()));
                    pst.setInt(4, Integer.parseInt(tf_inwardqty.getText()));
                    pst.executeUpdate();
                    PreparedStatement pstmt = con.prepareStatement("Update Products_Stock set Current_Stock = Current_Stock + ? where Product_id = ?");
                    pstmt.setInt(1, Integer.parseInt(tf_inwardqty.getText()));
                    pstmt.setInt(2, Integer.parseInt(tf_prodid.getText()));
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Inwarded Product's Record is Saved Successfully.");
                    count++;
                    rs = st.executeQuery("select * from Products_Inward order by Inward_Entryno");        
                }
                catch(SQLException e4){
                    JOptionPane.showMessageDialog(this, "Problem during Saving Record."); 
                }
            }
        tf_inwardno.setEditable(false);
        tf_inwarddate.setEditable(false);
        tf_prodid.setEditable(false) ;
        tf_inwardqty.setEditable(false);
        but_add.setEnabled(true);
        but_search.setEnabled(true);
        but_save.setEnabled(false);
        but_validate.setEnabled(false);
        but_viewpro.setEnabled(false);
    }

    void Inward_Search() {
        try {
            int inwardno = Integer.parseInt(
                    JOptionPane.showInputDialog(this, "Enter Inward Entry No. whose record you want to Search."));
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getInt(1) == inwardno)
                    break;
                }
            if (rs.isAfterLast())
                JOptionPane.showMessageDialog(this, "Record of Inward Entry No. Not Found.");
            else{
                tf_inwardno.setText(String.valueOf(rs.getInt(1)));
                tf_inwarddate.setText(Date_Formatting(rs.getDate(2).getDate(), rs.getDate(2).getMonth()+1, 
                rs.getDate(2).getYear()+1900));
                tf_prodid.setText(String.valueOf(rs.getInt(3)));
                rs_prod.beforeFirst();
                while(rs_prod.next()){
                    if(rs_prod.getInt(1) == Integer.parseInt(tf_prodid.getText()))
                        break;
                }
                if(rs_prod.isAfterLast()){
                    JOptionPane.showMessageDialog(this, "Input Product ID is Invalid. Please Enter Correct Product ID.");
                }
                else{
                    tf_prodname.setText(rs_prod.getString(2));
                    tf_produnit.setText(rs_prod.getString(5));
                    tf_prodmrp.setText(String.valueOf(rs_prod.getInt(6)));
                }
                tf_inwardqty.setText(String.valueOf(rs.getInt(4)));
            }
        } catch (SQLException e7) {
            JOptionPane.showMessageDialog(this, "Problem when Searching the Record.");
        }
    }

    void Product_Validate(){
        if(tf_prodid.getText().length() == 0)
            JOptionPane.showMessageDialog(this, "Product ID is Empty, so cannot Validate. Please enter Valid Product ID.");
        else if(prodcount == 0)
            JOptionPane.showMessageDialog(this, "No Records in PRODUCTS_MASTER, so Cannot Validate.");
        else{
            try{
                rs_prod.beforeFirst();
                while(rs_prod.next()){
                    if(rs_prod.getInt(1) == Integer.parseInt(tf_prodid.getText()))
                        break;
                }
                if(rs_prod.isAfterLast()){
                    tf_prodid.requestFocus();
                    JOptionPane.showMessageDialog(this, "Input Product ID is Invalid. Please Enter Correct Product ID.");
                }
                else{
                    tf_prodname.setText(rs_prod.getString(2));
                    tf_produnit.setText(rs_prod.getString(5));
                    tf_prodmrp.setText(String.valueOf(rs_prod.getInt(6)));
                }
            }
            catch(SQLException e5){
                JOptionPane.showMessageDialog(this,"Problem during Product ID Validation.");
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

    void View_Products(){
        JFrame fview = new JFrame();
        fview.setBounds(375, 200, 800, 500);
        fview.setVisible(true);
        String data[][] = new String[prodcount][6];
        try{
            int r = 0;
            rs_prod.beforeFirst();
            while(rs_prod.next()){
                data[r][0] = String.valueOf(rs_prod.getInt(1));
                data[r][1] = rs_prod.getString(2);
                data[r][2] = rs_prod.getString(3);
                data[r][3] = rs_prod.getString(4);
                data[r][4] = rs_prod.getString(5);
                data[r][5] = String.valueOf(rs_prod.getInt(6));
                r++;
            } 
        }
        catch(SQLException e6){
            JOptionPane.showMessageDialog(this, "Problem during viewing the Products Data."); 
        }
        String colnames[] = new String[6];
        colnames[0] = "Product ID";
        colnames[1] = "Product Name";
        colnames[2] = "Purpose";
        colnames[3] = "Colour_Size";
        colnames[4] = "Packaging Unit";
        colnames[5] = "Product MRP";
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

    public static void main(String args[])
    {
        new Product_InwardDEF();
    }
}
