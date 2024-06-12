import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Product_SalesDEF extends JFrame implements ActionListener
{
    Connection con;
    Statement st, stcount, st_prod, st_product_count, st_wholeseller, st_wholeseller_count;
    ResultSet rs, rscount, rs_prod, rs_product_count, rs_wholeseller, rs_wholeseller_count;
    JLabel lb_title1, lb_title2, lb_billno, lb_billdate, lb_wholeid, lb_wholename, lb_city, lb_proid, lb_proname, lb_pkgunit, lb_salesqty, lb_salesrate, lb_promrp,  lb_gstper, lb_addcrg, lb_infaddcrg;
    JTextField tf_salesno, tf_salesdate, tf_wholesellerid, tf_wholesellername, tf_city, tf_productid, tf_productname, tf_productmrp, tf_pkgunit, tf_salesqty, tf_salesrate, tf_gstper, tf_addcharges, tf_infoaddcharges;
    JButton but_validate_wholeseller, but_wholesellers_list, but_validate_product, but_products_list, but_add, but_save, but_search, but_close;
    int count = 0, product_count = 0, wholeseller_count = 0;
    Product_SalesDEF()
    {
        setSize(1550, 880);
        setVisible(true);
        setLayout(null);
        lb_title1 = new JLabel("Product's : Sales Transaction");
        lb_title2 = new JLabel("(Products sold to Wholesellers, Data Entry Form)");
        lb_billno = new JLabel("Sales Bill No.");
        lb_billdate = new JLabel("Sales Date");
        lb_wholeid = new JLabel("Sold to : Wholeseller ID");
        lb_wholename = new JLabel("Wholeseller Name");
        lb_city = new JLabel("City");
        lb_proid = new JLabel("Sold Products ID");
        lb_proname = new JLabel("Product Name");
        lb_pkgunit = new JLabel("Packaging Unit");
        lb_promrp = new JLabel("Product MRP");
        lb_salesqty = new JLabel("Sales Quantity");
        lb_salesrate = new JLabel("Sales Rate");
        lb_gstper = new JLabel("GST (in %)");
        lb_addcrg = new JLabel("Additional Charges");
        lb_infaddcrg = new JLabel("Information about Additional Charges");
        tf_salesno = new JTextField(); 
        tf_salesdate = new JTextField(); 
        tf_wholesellerid = new JTextField(); 
        tf_wholesellername = new JTextField(); 
        tf_city = new JTextField(); 
        tf_productid = new JTextField(); 
        tf_productname = new JTextField(); 
        tf_productmrp = new JTextField(); 
        tf_pkgunit = new JTextField(); 
        tf_salesqty = new JTextField(); 
        tf_salesrate = new JTextField(); 
        tf_gstper = new JTextField(); 
        tf_addcharges = new JTextField(); 
        tf_infoaddcharges = new JTextField();
        but_validate_wholeseller = new JButton("Validate") ;
        but_wholesellers_list = new JButton("Wholesellers List") ;
        but_validate_product = new JButton("Validate") ;
        but_products_list = new JButton("Products List") ;
        but_add = new JButton("Add Sales Record") ;
        but_save = new JButton("Save Sales Data") ;
        but_search = new JButton("Search Sales Bill") ;
        but_close = new JButton("Close Form");
        but_validate_wholeseller.addActionListener(this);
        but_wholesellers_list.addActionListener(this);
        but_validate_product.addActionListener(this);
        but_products_list.addActionListener(this); 
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
        lb_billno.setFont(f3); 
        lb_billdate.setFont(f3); 
        lb_wholeid.setFont(f3); 
        lb_wholename.setFont(f3); 
        lb_city.setFont(f3); 
        lb_proid.setFont(f3); 
        lb_proname.setFont(f3); 
        lb_pkgunit.setFont(f3); 
        lb_salesqty.setFont(f3); 
        lb_salesrate.setFont(f3); 
        lb_promrp.setFont(f3);  
        lb_gstper.setFont(f3); 
        lb_addcrg.setFont(f3); 
        lb_infaddcrg.setFont(f3);
        tf_salesno.setFont(f4) ;
        tf_salesdate.setFont(f4) ;
        tf_wholesellerid.setFont(f4) ;
        tf_wholesellername.setFont(f4) ;
        tf_city.setFont(f4) ;
        tf_productid.setFont(f4) ;
        tf_productname.setFont(f4) ;
        tf_productmrp.setFont(f4) ;
        tf_pkgunit.setFont(f4) ;
        tf_salesqty.setFont(f4) ;
        tf_salesrate.setFont(f4) ;
        tf_gstper.setFont(f4) ;
        tf_addcharges.setFont(f4) ;
        tf_infoaddcharges.setFont(f4);
        but_validate_wholeseller.setFont(f3) ;
        but_wholesellers_list.setFont(f3) ;
        but_validate_product.setFont(f3) ;
        but_products_list.setFont(f3) ;
        but_add.setFont(f3) ;
        but_save.setFont(f3) ;
        but_search.setFont(f3) ;
        but_close.setFont(f3);



        add(lb_title1);
        add(lb_title2);
        add(lb_billno);
        add(lb_billdate);
        add(lb_wholeid);
        add(lb_wholename);
        add(lb_city);
        add(lb_proid);
        add(lb_proname);
        add(lb_promrp);
        add(lb_pkgunit);
        add(lb_salesqty);
        add(lb_salesrate);
        add(tf_productmrp);
        add(lb_gstper);
        add(lb_addcrg);
        add(lb_infaddcrg);
        add(tf_salesno);
        add(tf_salesdate);
        add(tf_wholesellerid);
        add(tf_wholesellername);
        add(tf_city);
        add(tf_productid);
        add(tf_productname);
        add(tf_pkgunit);
        add(tf_salesqty);
        add(tf_salesrate);
        add(tf_gstper);
        add(tf_addcharges);
        add(tf_infoaddcharges);
        add(but_validate_wholeseller);
        add(but_wholesellers_list);
        add(but_validate_product);
        add(but_products_list);
        add(but_add);
        add(but_save);
        add(but_search);
        add(but_close);
        
        lb_title1.setBounds(450, 25, 1000, 42); 
        lb_title2.setBounds(420, 75, 1000, 35); 
        lb_billno.setBounds(200, 150, 200, 30); 
        tf_salesno.setBounds(525, 150, 150, 30); 
        lb_billdate.setBounds(775, 150, 150, 30); 
        tf_salesdate.setBounds(950, 150, 150, 30); 
        lb_wholeid.setBounds(200, 225, 300, 30); 
        tf_wholesellerid.setBounds(525, 225, 125, 30); 
        but_validate_wholeseller.setBounds(700, 225, 150, 30); 
        but_wholesellers_list.setBounds(875, 225, 275, 30); 
        lb_wholename.setBounds(200, 275, 300, 30); 
        tf_wholesellername.setBounds(525, 275, 300, 30); 
        lb_city.setBounds(200, 325, 300, 30); 
        tf_city.setBounds(525, 325, 200, 30); 
        lb_proid.setBounds(200, 400, 300, 30); 
        tf_productid.setBounds(525, 400, 125, 30); 
        but_validate_product.setBounds(700, 400, 150, 30); 
        but_products_list.setBounds(875, 400, 275, 30); 
        lb_proname.setBounds(200, 450, 300, 30); 
        tf_productname.setBounds(525, 450, 300, 30); 
        lb_pkgunit.setBounds(200, 500, 300, 30); 
        tf_pkgunit.setBounds(525, 500, 200, 30); 
        lb_promrp.setBounds(775, 500, 200, 30);  
        tf_productmrp.setBounds(975, 500, 150, 30);
        lb_salesqty.setBounds(200, 575, 300, 30); 
        tf_salesqty.setBounds(525, 575, 125, 30); 
        lb_salesrate.setBounds(775, 575, 200, 30); 
        tf_salesrate.setBounds(975, 575, 150, 30); 
        lb_gstper.setBounds(200, 625, 300, 30); 
        tf_gstper.setBounds(525, 625, 125, 30); 
        lb_addcrg.setBounds(775, 625, 250, 30); 
        tf_addcharges.setBounds(1025, 625, 200, 30); 
        lb_infaddcrg.setBounds(200, 675, 450, 30);
        tf_infoaddcharges.setBounds(675, 675, 200, 30);
        but_add.setBounds(200, 750, 275, 30); 
        but_save.setBounds(525, 750, 225, 30); 
        but_search.setBounds(800, 750, 270, 30); 
        but_close.setBounds(1125, 750, 200, 30);

        tf_salesno.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_salesno.getText().length() >= 6) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();
                    }
                });
        tf_salesdate.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_salesdate.getText().length() >= 12) {
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
        tf_productid.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_productid.getText().length() >= 3) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();
                    }
                });
        tf_salesqty.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_salesqty.getText().length() >= 3) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();
                    }
                });
        tf_salesrate.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_salesrate.getText().length() >= 4) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();
                    }
                });
        tf_gstper.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_gstper.getText().length() >= 5) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else if(ke.getKeyChar() == '.')
                            return;
                        else
                            ke.consume();
                    }
                });
        tf_addcharges.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_addcharges.getText().length() >= 8) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else if(ke.getKeyChar() == '.')
                            return;
                        else
                            ke.consume();
                    }
                });
        tf_infoaddcharges.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_infoaddcharges.getText().length() >= 25) {
                            ke.consume();
                        } else {
                            return;
                        }
                    }
                });

        tf_salesno.setEditable(false); 
        tf_salesdate.setEditable(false); 
        tf_wholesellerid.setEditable(false); 
        tf_wholesellername.setEditable(false); 
        tf_city.setEditable(false); 
        tf_productid.setEditable(false); 
        tf_productname.setEditable(false); 
        tf_productmrp.setEditable(false); 
        tf_pkgunit.setEditable(false); 
        tf_salesqty.setEditable(false); 
        tf_salesrate.setEditable(false); 
        tf_gstper.setEditable(false); 
        tf_addcharges.setEditable(false); 
        tf_infoaddcharges.setEditable(false);
        but_validate_wholeseller.setEnabled(false);
        but_wholesellers_list.setEnabled(false);
        but_validate_product.setEnabled(false);
        but_products_list.setEnabled(false);
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
            Sales_Add();    
        }
        else if(ae.getSource() == but_save)
        {
            Sales_Save();
        }
        else if(ae.getSource() == but_search)
        {
            Sales_Search();
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
        else if(ae.getSource() == but_validate_product)
        {
            Product_Validate();
        }
        else if(ae.getSource() == but_products_list)
        {
            Products_List();
        }
    }
    void Connection_method() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from Products_Sales order by Sales_billno");
            stcount = con.createStatement();
            rscount = stcount.executeQuery("select count(*) from Products_Sales");
            rscount.next();
            count = rscount.getInt(1);
            st_wholeseller = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs_wholeseller = st_wholeseller.executeQuery("select * from Wholesellers_Master order by Wholeseller_id");
            st_wholeseller_count = con.createStatement();
            rs_wholeseller_count = st_wholeseller_count.executeQuery("select count(*) from Wholesellers_Master");
            rs_wholeseller_count.next();
            wholeseller_count = rs_wholeseller_count.getInt(1);
            st_prod = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs_prod = st_prod.executeQuery("select * from Products_Master order by Product_id");
            st_product_count = con.createStatement();
            rs_product_count = st_product_count.executeQuery("select count(*) from Products_Master");
            rs_product_count.next();
            product_count = rs_product_count.getInt(1);
            
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(this, "Problem in Java-Oracle Connection");
        } catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(this, "Problem when Loading the Driver.");
        }
    }

    void Sales_Add(){
        int autocode = 0;
        if(count == 0)
            autocode = 1;
        else{
            try{
                rs.last();
                autocode = rs.getInt(1) + 1;
            }
            catch(SQLException e3){
                JOptionPane.showMessageDialog(this, "Problem during Generating Sales Bill Number."); 
            }
        }
        tf_salesno.setEditable(true) ;
        tf_salesno.setText(String.valueOf(autocode));
        tf_salesno.setEditable(false);
        tf_salesdate.setEditable(true);
        tf_wholesellerid.setEditable(true);
        tf_productid.setEditable(true);
        tf_salesqty.setEditable(true) ;
        tf_salesrate.setEditable(true);
        tf_gstper.setEditable(true);
        tf_addcharges.setEditable(true);
        tf_infoaddcharges.setEditable(true);
        but_save.setEnabled(true);
        but_add.setEnabled(false);
        but_search.setEnabled(false);
        but_validate_product.setEnabled(true);
        but_products_list.setEnabled(true);
        but_validate_wholeseller.setEnabled(true);
        but_wholesellers_list.setEnabled(true);
        tf_salesdate.setText(CurrentDate()); 
        tf_wholesellerid.setText(""); 
        tf_wholesellername.setText(""); 
        tf_city.setText(""); 
        tf_productid.setText(""); 
        tf_productname.setText(""); 
        tf_productmrp.setText(""); 
        tf_pkgunit.setText(""); 
        tf_salesqty.setText(""); 
        tf_salesrate.setText(""); 
        tf_gstper.setText(""); 
        tf_addcharges.setText(""); 
        tf_infoaddcharges.setText("");
        tf_salesdate.requestFocus();
    }

    void Sales_Save(){
        if(tf_salesno.getText().length() == 0 || tf_salesdate.getText().length() == 0 ||  tf_wholesellerid.getText().length() == 0 || tf_productid.getText().length() == 0 || tf_salesqty.getText().length() == 0 || tf_salesrate.getText().length() == 0 )
            JOptionPane.showMessageDialog(this, "Invalid Inputs, some Textfields may be empty. Please Input Complete Data."); 
        else{
            try{
                PreparedStatement pst = con.prepareStatement("Insert into Products_Sales values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
                pst.setInt(1, Integer.parseInt(tf_salesno.getText()));
                pst.setString(2, tf_salesdate.getText());
                pst.setInt(3, Integer.parseInt(tf_wholesellerid.getText()));
                pst.setInt(4, Integer.parseInt(tf_productid.getText()));
                pst.setInt(5, Integer.parseInt(tf_salesqty.getText()));
                pst.setInt(6, Integer.parseInt(tf_salesrate.getText()));
                if(tf_gstper.getText().length() == 0)
                    pst.setDouble(7, 0);
                else
                    pst.setDouble(7, Double.parseDouble(tf_gstper.getText()));
                if(tf_addcharges.getText().length() == 0)
                    pst.setDouble(8, 0);
                else
                    pst.setDouble(8, Double.parseDouble(tf_addcharges.getText()));
                pst.setString(9, tf_infoaddcharges.getText());
                pst.executeUpdate();
                PreparedStatement pstmt = con.prepareStatement("Update Products_Stock set Current_Stock = Current_Stock - ? where Product_id = ?");
                pstmt.setInt(1, Integer.parseInt(tf_salesqty.getText()));
                pstmt.setInt(2, Integer.parseInt(tf_productid.getText()));
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "New Sold Product's Record is Saved Successfully.");
                count++;
                rs = st.executeQuery("select * from Products_Sales order by Sales_billno");        
            }
            catch(SQLException e4){
                JOptionPane.showMessageDialog(this, "Problem during Saving Record."); 
            }
        }
    tf_salesno.setEditable(false);
    tf_salesdate.setEditable(false);
    tf_wholesellerid.setEditable(false) ;
    tf_productid.setEditable(false);
    tf_salesqty.setEditable(false);
    tf_salesrate.setEditable(false);
    tf_gstper.setEditable(false);
    tf_addcharges.setEditable(false);
    tf_infoaddcharges.setEditable(false);
    but_add.setEnabled(true);
    but_search.setEnabled(true);
    but_save.setEnabled(false);
    but_validate_wholeseller.setEnabled(false);
    but_wholesellers_list.setEnabled(false);
    but_validate_product.setEnabled(false);
    but_products_list.setEnabled(false);
}

void Sales_Search() {
    try {
        int salesno = Integer.parseInt(
                JOptionPane.showInputDialog(this, "Enter Sales Bill No. whose record you want to Search."));
        rs.beforeFirst();
        while (rs.next()) {
            if (rs.getInt(1) == salesno)
                break;
            }
        if (rs.isAfterLast())
            JOptionPane.showMessageDialog(this, "Record of Input Sales Bill No. Not Found.");
        else{
            tf_salesno.setText(String.valueOf(rs.getInt(1)));
            tf_salesdate.setText(Date_Formatting(rs.getDate(2).getDate(), rs.getDate(2).getMonth()+1, 
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
            tf_productid.setText(String.valueOf(rs.getInt(4)));
            rs_prod.beforeFirst();
            while(rs_prod.next()){
                if(rs_prod.getInt(1) == Integer.parseInt(tf_productid.getText()))
                    break;
            }
            if(rs_prod.isAfterLast()){
                JOptionPane.showMessageDialog(this, "Input Product ID is Invalid. Please Enter Correct Product ID.");
            }
            else{
                tf_productname.setText(rs_prod.getString(2));
                tf_pkgunit.setText(rs_prod.getString(5));
                tf_productmrp.setText(String.valueOf(rs_prod.getInt(6)));
            }
            tf_salesqty.setText(String.valueOf(rs.getInt(5)));
            tf_salesrate.setText(String.valueOf(rs.getInt(6)));
            tf_gstper.setText(String.valueOf(rs.getInt(7)));
            tf_addcharges.setText(String.valueOf(rs.getInt(8)));
            tf_infoaddcharges.setText(rs.getString(9));
        }
    } catch (SQLException e7) {
        JOptionPane.showMessageDialog(this, "Problem when Searching the Record.");
    }
}

    void Product_Validate(){
        if(tf_productid.getText().length() == 0)
            JOptionPane.showMessageDialog(this, "Product ID is Empty, so cannot Validate. Please enter Valid Product ID.");
        else if(product_count == 0)
            JOptionPane.showMessageDialog(this, "No Records in PRODUCTS_MASTER, so Cannot Validate.");
        else{
            try{
                rs_prod.beforeFirst();
                while(rs_prod.next()){
                    if(rs_prod.getInt(1) == Integer.parseInt(tf_productid.getText()))
                        break;
                }
                if(rs_prod.isAfterLast()){
                    tf_productid.requestFocus();
                    JOptionPane.showMessageDialog(this, "Input Product ID is Invalid. Please Enter Correct Product ID.");
                }
                else{
                    tf_productname.setText(rs_prod.getString(2));
                    tf_pkgunit.setText(rs_prod.getString(5));
                    tf_productmrp.setText(String.valueOf(rs_prod.getInt(6)));
                }
            }
            catch(SQLException e5){
                JOptionPane.showMessageDialog(this,"Problem during Product ID Validation.");
            }
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

    void Products_List(){
        JFrame fview = new JFrame();
        fview.setBounds(375, 200, 800, 500);
        fview.setVisible(true);
        String data[][] = new String[product_count][6];
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
        new Product_SalesDEF();
    }
}
