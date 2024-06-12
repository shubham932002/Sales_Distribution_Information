import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Product_DistributionDEF extends JFrame implements ActionListener
{
    Connection con;
    Statement st, stcount, st_prod, st_product_count, st_distributor, st_distributor_count;
    ResultSet rs, rscount, rs_prod, rs_product_count, rs_distributor, rs_distributor_count;
    JLabel lb_title1, lb_title2, lb_distno, lb_distdate, lb_distid, lb_distname, lb_city, lb_proid, lb_proname, lb_promrp, lb_pkgunit, lb_distqty, lb_distrate,  lb_gstper, lb_addcrg, lb_infaddcrg;
    JTextField tf_distno, tf_distdate, tf_distid, tf_distname, tf_city, tf_productid, tf_productname, tf_productmrp, tf_pkgunit, tf_distqty, tf_distrate, tf_gstper, tf_addcharges, tf_infoaddcharges;
    JButton but_validate_distributor, but_distributor_list, but_validate_product, but_products_list, but_add, but_save, but_search, but_close;
    int count = 0, product_count = 0, distributor_count = 0;
    Product_DistributionDEF()
    {
        setSize(1550, 880);
        setVisible(true);
        setLayout(null);
        lb_title1 = new JLabel("Product's : Distribution Transaction");
        lb_title2 = new JLabel("(Distributed Products to Distributor, Data Entry Form)");
        lb_distno = new JLabel("Distribution Bill No.");
        lb_distdate = new JLabel("Distribution Date");
        lb_distid = new JLabel("Distributed to : Distributor ID");
        lb_distname = new JLabel("Distributor Firm Name");
        lb_city = new JLabel("City");
        lb_proid = new JLabel("Sold Products ID");
        lb_proname = new JLabel("Product Name");
        lb_pkgunit = new JLabel("Packaging Unit");
        lb_promrp = new JLabel("Product MRP");
        lb_distqty = new JLabel("Distributed Quantity");
        lb_distrate = new JLabel("Distribution Rate");
        lb_gstper = new JLabel("GST (in %)");
        lb_addcrg = new JLabel("Additional Charges");
        lb_infaddcrg = new JLabel("Information about Additional Charges");
        tf_distno = new JTextField(); 
        tf_distdate = new JTextField(); 
        tf_distid = new JTextField(); 
        tf_distname = new JTextField(); 
        tf_city = new JTextField(); 
        tf_productid = new JTextField(); 
        tf_productname = new JTextField(); 
        tf_productmrp = new JTextField(); 
        tf_pkgunit = new JTextField(); 
        tf_distqty = new JTextField(); 
        tf_distrate = new JTextField(); 
        tf_gstper = new JTextField(); 
        tf_addcharges = new JTextField(); 
        tf_infoaddcharges = new JTextField();
        but_validate_distributor = new JButton("Validate") ;
        but_distributor_list = new JButton("Distributor List") ;
        but_validate_product = new JButton("Validate") ;
        but_products_list = new JButton("Products List") ;
        but_add = new JButton("Add Distribution Record") ;
        but_save = new JButton("Save Distribution Data") ;
        but_search = new JButton("Search Distribution Bill") ;
        but_close = new JButton("Close Form");
        but_validate_distributor.addActionListener(this);
        but_distributor_list.addActionListener(this);
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
        lb_distno.setFont(f3); 
        lb_distdate.setFont(f3); 
        lb_distid.setFont(f3); 
        lb_distname.setFont(f3); 
        lb_city.setFont(f3); 
        lb_proid.setFont(f3); 
        lb_proname.setFont(f3); 
        lb_pkgunit.setFont(f3); 
        lb_distqty.setFont(f3); 
        lb_distrate.setFont(f3); 
        lb_promrp.setFont(f3);  
        lb_gstper.setFont(f3); 
        lb_addcrg.setFont(f3); 
        lb_infaddcrg.setFont(f3);
        tf_distno.setFont(f4) ;
        tf_distdate.setFont(f4) ;
        tf_distid.setFont(f4) ;
        tf_distname.setFont(f4) ;
        tf_city.setFont(f4) ;
        tf_productid.setFont(f4) ;
        tf_productname.setFont(f4) ;
        tf_productmrp.setFont(f4) ;
        tf_pkgunit.setFont(f4) ;
        tf_distqty.setFont(f4) ;
        tf_distrate.setFont(f4) ;
        tf_gstper.setFont(f4) ;
        tf_addcharges.setFont(f4) ;
        tf_infoaddcharges.setFont(f4);
        but_validate_distributor.setFont(f3) ;
        but_distributor_list.setFont(f3) ;
        but_validate_product.setFont(f3) ;
        but_products_list.setFont(f3) ;
        but_add.setFont(f3) ;
        but_save.setFont(f3) ;
        but_search.setFont(f3) ;
        but_close.setFont(f3);



        add(lb_title1);
        add(lb_title2);
        add(lb_distno);
        add(lb_distdate);
        add(lb_distid);
        add(lb_distname);
        add(lb_city);
        add(lb_proid);
        add(lb_proname);
        add(lb_promrp);
        add(lb_pkgunit);
        add(lb_distqty);
        add(lb_distrate);
        add(tf_productmrp);
        add(lb_gstper);
        add(lb_addcrg);
        add(lb_infaddcrg);
        add(tf_distno);
        add(tf_distdate);
        add(tf_distid);
        add(tf_distname);
        add(tf_city);
        add(tf_productid);
        add(tf_productname);
        add(tf_pkgunit);
        add(tf_distqty);
        add(tf_distrate);
        add(tf_gstper);
        add(tf_addcharges);
        add(tf_infoaddcharges);
        add(but_validate_distributor);
        add(but_distributor_list);
        add(but_validate_product);
        add(but_products_list);
        add(but_add);
        add(but_save);
        add(but_search);
        add(but_close);
        
        lb_title1.setBounds(400, 25, 1000, 42); 
        lb_title2.setBounds(410, 75, 1000, 35); 
        lb_distno.setBounds(200, 150, 250, 30); 
        tf_distno.setBounds(525, 150, 150, 30); 
        lb_distdate.setBounds(775, 150, 250, 30); 
        tf_distdate.setBounds(975, 150, 150, 30); 
        lb_distid.setBounds(200, 225, 400, 30); 
        tf_distid.setBounds(550, 225, 125, 30); 
        but_validate_distributor.setBounds(725, 225, 150, 30); 
        but_distributor_list.setBounds(900, 225, 275, 30); 
        lb_distname.setBounds(200, 275, 300, 30); 
        tf_distname.setBounds(525, 275, 300, 30); 
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
        lb_distqty.setBounds(200, 575, 300, 30); 
        tf_distqty.setBounds(525, 575, 125, 30); 
        lb_distrate.setBounds(775, 575, 200, 30); 
        tf_distrate.setBounds(975, 575, 150, 30); 
        lb_gstper.setBounds(200, 625, 300, 30); 
        tf_gstper.setBounds(525, 625, 125, 30); 
        lb_addcrg.setBounds(775, 625, 250, 30); 
        tf_addcharges.setBounds(1025, 625, 200, 30); 
        lb_infaddcrg.setBounds(200, 675, 450, 30);
        tf_infoaddcharges.setBounds(675, 675, 200, 30);
        but_add.setBounds(150, 750, 325, 30); 
        but_save.setBounds(500, 750, 300, 30); 
        but_search.setBounds(825, 750, 300, 30); 
        but_close.setBounds(1150, 750, 200, 30);

        tf_distno.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_distno.getText().length() >= 6) {
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
        tf_distqty.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_distqty.getText().length() >= 3) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();
                    }
                });
        tf_distrate.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_distrate.getText().length() >= 4) {
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

        tf_distno.setEditable(false); 
        tf_distdate.setEditable(false); 
        tf_distid.setEditable(false); 
        tf_distname.setEditable(false); 
        tf_city.setEditable(false); 
        tf_productid.setEditable(false); 
        tf_productname.setEditable(false); 
        tf_productmrp.setEditable(false); 
        tf_pkgunit.setEditable(false); 
        tf_distqty.setEditable(false); 
        tf_distrate.setEditable(false); 
        tf_gstper.setEditable(false); 
        tf_addcharges.setEditable(false); 
        tf_infoaddcharges.setEditable(false);
        but_validate_distributor.setEnabled(false);
        but_distributor_list.setEnabled(false);
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
            Distributor_Add();    
        }
        else if(ae.getSource() == but_save)
        {
            Distribution_Save();
        }
        else if(ae.getSource() == but_search)
        {
            Distribution_Search();
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
            rs = st.executeQuery("select * from Products_Distribution order by Distribution_billno");
            stcount = con.createStatement();
            rscount = stcount.executeQuery("select count(*) from Products_Distribution");
            rscount.next();
            count = rscount.getInt(1);
            st_distributor = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs_distributor = st_distributor.executeQuery("select * from Distributors_Master order by Distributor_id");
            st_distributor_count = con.createStatement();
            rs_distributor_count = st_distributor_count.executeQuery("select count(*) from Distributors_Master");
            rs_distributor_count.next();
            distributor_count = rs_distributor_count.getInt(1);
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

    void Distributor_Add(){
        int autocode = 0;
        if(count == 0)
            autocode = 1;
        else{
            try{
                rs.last();
                autocode = rs.getInt(1) + 1;
            }
            catch(SQLException e3){
                JOptionPane.showMessageDialog(this, "Problem during Generating Distribution Bill Number."); 
            }
        }
        tf_distno.setEditable(true) ;
        tf_distno.setText(String.valueOf(autocode));
        tf_distno.setEditable(false);
        tf_distdate.setEditable(true);
        tf_distid.setEditable(true);
        tf_productid.setEditable(true);
        tf_distqty.setEditable(true) ;
        tf_distrate.setEditable(true);
        tf_gstper.setEditable(true);
        tf_addcharges.setEditable(true);
        tf_infoaddcharges.setEditable(true);
        but_save.setEnabled(true);
        but_add.setEnabled(false);
        but_search.setEnabled(false);
        but_validate_product.setEnabled(true);
        but_products_list.setEnabled(true);
        but_validate_distributor.setEnabled(true);
        but_distributor_list.setEnabled(true);
        tf_distdate.setText(CurrentDate());
        tf_distname.setText(""); 
        tf_distid.setText("");
        tf_city.setText(""); 
        tf_productid.setText(""); 
        tf_productname.setText(""); 
        tf_productmrp.setText(""); 
        tf_pkgunit.setText(""); 
        tf_distqty.setText(""); 
        tf_distrate.setText(""); 
        tf_gstper.setText(""); 
        tf_addcharges.setText(""); 
        tf_infoaddcharges.setText("");
        tf_distdate.requestFocus();
    }

    void Distribution_Save(){
        if(tf_distno.getText().length() == 0 || tf_distdate.getText().length() == 0 ||  tf_distid.getText().length() == 0 || tf_productid.getText().length() == 0 || tf_distqty.getText().length() == 0 || tf_distrate.getText().length() == 0 )
            JOptionPane.showMessageDialog(this, "Invalid Inputs, some Textfields may be empty. Please Input Complete Data."); 
        else{
            try{
                PreparedStatement pst = con.prepareStatement("Insert into Products_Distribution values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
                pst.setInt(1, Integer.parseInt(tf_distno.getText()));
                pst.setString(2, tf_distdate.getText());
                pst.setInt(3, Integer.parseInt(tf_distid.getText()));
                pst.setInt(4, Integer.parseInt(tf_productid.getText()));
                pst.setInt(5, Integer.parseInt(tf_distqty.getText()));
                pst.setInt(6, Integer.parseInt(tf_distrate.getText()));
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
                pstmt.setInt(1, Integer.parseInt(tf_distqty.getText()));
                pstmt.setInt(2, Integer.parseInt(tf_productid.getText()));
                pstmt.executeUpdate();
                int dqty = Integer.parseInt(tf_distqty.getText());
                int drate = Integer.parseInt(tf_distrate.getText());
                double gstper, addch;
                if(tf_gstper.getText().length() == 0)
                    gstper = 0;
                else
                    gstper = Double.parseDouble(tf_gstper.getText());
                if(tf_addcharges.getText().length() == 0)
                    addch = 0;
                else
                    addch = Double.parseDouble(tf_addcharges.getText());
                int damt = dqty * drate ;
                double gstamt = gstper * (double)damt/100 ;
                long netamt = damt + Math.round(gstamt) + Math.round(addch) ;
                PreparedStatement pst_balpay = con.prepareStatement("Update Distributors_Bal_Pay set Balance_Amount = Balance_Amount + ? where Distributor_id = ?");
                pst_balpay.setLong(1, netamt);
                pst_balpay.setInt(2, Integer.parseInt(tf_distid.getText()));
                pst_balpay.executeUpdate();
                JOptionPane.showMessageDialog(this, "New Distributed Product's Record is Saved Successfully.");
                count++;
                rs = st.executeQuery("select * from Products_Distribution order by Distribution_billno");        
            }
            catch(SQLException e4){
                JOptionPane.showMessageDialog(this, "Problem during Saving Record."); 
            }
        }
    tf_distno.setEditable(false);
    tf_distdate.setEditable(false);
    tf_distid.setEditable(false) ;
    tf_productid.setEditable(false);
    tf_distqty.setEditable(false);
    tf_distrate.setEditable(false);
    tf_gstper.setEditable(false);
    tf_addcharges.setEditable(false);
    tf_infoaddcharges.setEditable(false);
    but_add.setEnabled(true);
    but_search.setEnabled(true);
    but_save.setEnabled(false);
    but_validate_distributor.setEnabled(false);
    but_distributor_list.setEnabled(false);
    but_validate_product.setEnabled(false);
    but_products_list.setEnabled(false);
}

void Distribution_Search() {
    try {
        int distno = Integer.parseInt(
                JOptionPane.showInputDialog(this, "Enter Distribution Bill No. whose record you want to Search."));
        rs.beforeFirst();
        while (rs.next()) {
            if (rs.getInt(1) == distno)
                break;
            }
        if (rs.isAfterLast())
            JOptionPane.showMessageDialog(this, "Record of Input Distribution Bill No. Not Found.");
        else{
            tf_distno.setText(String.valueOf(rs.getInt(1)));
            tf_distdate.setText(Date_Formatting(rs.getDate(2).getDate(), rs.getDate(2).getMonth()+1, 
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
                tf_distname.setText(rs_distributor.getString(2));
                tf_city.setText(rs_distributor.getString(4));
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
            tf_distqty.setText(String.valueOf(rs.getInt(5)));
            tf_distrate.setText(String.valueOf(rs.getInt(6)));
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
                    tf_distrate.setText(tf_productmrp.getText());
                }
            }
            catch(SQLException e5){
                JOptionPane.showMessageDialog(this,"Problem during Product ID Validation.");
            }
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
                    tf_distname.setText(rs_distributor.getString(2));
                    tf_city.setText(rs_distributor.getString(4));
                }
            }
            catch(SQLException e5){
                JOptionPane.showMessageDialog(this,"Problem during Distributor's ID Validation.");
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

    void Distributors_List(){
        JFrame fview = new JFrame();
        fview.setBounds(375, 200, 800, 500);
        fview.setVisible(true);
        String data[][] = new String[distributor_count][8];
        try{
            int r = 0;
            rs_distributor.beforeFirst();
            while(rs_distributor.next()){
                data[r][0] = String.valueOf(rs_distributor.getInt(1));
                data[r][1] = rs_distributor.getString(2);
                data[r][2] = rs_distributor.getString(3);
                data[r][3] = rs_distributor.getString(4);   
                data[r][4] = rs_distributor.getString(5);
                data[r][5] = String.valueOf(rs_distributor.getLong(6));
                if(rs_distributor.getLong(7) == -1)
                    data[r][6] = "";
                else
                    data[r][6] = String.valueOf(rs_distributor.getLong(7));
                String distdate = Date_Formatting(rs_distributor.getDate(8).getDate(), rs_distributor.getDate(8).getMonth()+1, rs_distributor.getDate(8).getYear()+1900);
                data[r][7] = distdate;
                r++;
            } 
        }
        catch(SQLException e6){
            JOptionPane.showMessageDialog(this, "Problem during viewing the Distributors Data."); 
        }
        String colnames[] = new String[8];
        colnames[0] = "Distributor ID";
        colnames[1] = "Distributor Firm Name";
        colnames[2] = "Address";
        colnames[3] = "City";
        colnames[4] = "Contact Person";
        colnames[5] = "Mobile Number 1";
        colnames[6] = "Mobile Number 2";
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
        new Product_DistributionDEF();
    }
}
