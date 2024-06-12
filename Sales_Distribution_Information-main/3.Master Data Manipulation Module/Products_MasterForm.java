import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


class Products_MasterForm extends JFrame implements ActionListener { 
    Connection con;
    Statement st;
    ResultSet rs;
    JLabel lb_title1, lb_title2, lb_prodid, lb_prodname, lb_purpose, lb_coloursize, lb_pkgunit, lb_prodmrp;
    JTextField tf_prodid, tf_prodname, tf_purpose, tf_coloursize, tf_pkgunit, tf_prodmrp;
    JButton but_add, but_save, but_change, but_delete, but_view, but_search, but_close, but_first, but_previous, but_next, but_last;
    char chk = 'X';
    int count = 0;
    Products_MasterForm() {
        setSize(1920, 920);
        setVisible(true);
        setLayout(null);
        lb_title1 = new JLabel("Company Products");
        lb_title2 = new JLabel("Master Data Manipulation Form");
        lb_prodid = new JLabel("Product ID No.");
        lb_prodname = new JLabel("Product Name");
        lb_purpose = new JLabel("Purpose");
        lb_coloursize = new JLabel("Colour Size");
        lb_pkgunit = new JLabel("Packaging Unit");
        lb_prodmrp = new JLabel("Product MRP");
        tf_prodid = new JTextField();
        tf_prodname = new JTextField();
        tf_purpose = new JTextField();
        tf_coloursize = new JTextField();
        tf_pkgunit = new JTextField();
        tf_prodmrp = new JTextField();
        but_add = new JButton("Add Product");
        but_save = new JButton("Save Record");
        but_change = new JButton("Change Record");
        but_delete = new JButton("Delete Record");
        but_view = new JButton("View All Products");
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
        lb_prodid.setFont(f2);
        lb_prodname.setFont(f2);
        lb_purpose.setFont(f2);
        lb_coloursize.setFont(f2);
        lb_pkgunit.setFont(f2);
        lb_prodmrp.setFont(f2);
        tf_prodid.setFont(f2);
        tf_prodname.setFont(f2);
        tf_purpose.setFont(f2);
        tf_coloursize.setFont(f2);
        tf_pkgunit.setFont(f2);
        tf_prodmrp.setFont(f2);
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
        add(lb_prodid);
        add(lb_prodname);
        add(lb_purpose);
        add(lb_coloursize);
        add(lb_pkgunit);
        add(lb_prodmrp);
        add(tf_prodid);
        add(tf_prodname);
        add(tf_purpose);
        add(tf_coloursize);
        add(tf_pkgunit);
        add(tf_prodmrp);
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

        lb_title1.setBounds(525, 50, 500, 45);
        lb_title2.setBounds(450, 100, 600, 45);
        lb_prodid.setBounds(250, 250, 250, 30);
        tf_prodid.setBounds(525, 250, 100, 30);
        lb_prodname.setBounds(250, 310, 275, 30);
        tf_prodname.setBounds(525, 310, 300, 30);
        lb_purpose.setBounds(250, 370, 250, 30);
        tf_purpose.setBounds(525, 370, 500, 30);
        lb_coloursize.setBounds(250, 430, 250, 30);
        tf_coloursize.setBounds(525, 430, 300, 30);
        lb_pkgunit.setBounds(250, 490, 250, 30);
        tf_pkgunit.setBounds(525, 490, 200, 30);
        lb_prodmrp.setBounds(250, 550, 250, 30);
        tf_prodmrp.setBounds(525, 550, 200, 30);
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
        tf_prodname.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_prodname.getText().length() >= 25) {
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
        tf_purpose.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_purpose.getText().length() >= 30) {
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

        tf_coloursize.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_coloursize.getText().length() >= 25) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') {
                            return;
                        } else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z') {
                            return;
                        } else if (ke.getKeyChar() == ' ') {
                            return;
                        } 
                        else if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                                        return;
                        else {
                            ke.consume();
                        }
                    }
                });

                
                tf_pkgunit.addKeyListener(
                    new KeyAdapter() {
                        public void keyTyped(KeyEvent ke) {
                            if (tf_pkgunit.getText().length() >= 25) {
                                ke.consume();
                            }
                            if (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') {
                                return;
                            } else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z') {
                                return;
                            } else if (ke.getKeyChar() == ' ' || ke.getKeyChar() == ',') {
                                return;
                            } 
                            else if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                                return;
                            else {
                                ke.consume();
                            }
                        }
                    });
                    
                    tf_prodmrp.addKeyListener(
                            new KeyAdapter() {
                                public void keyTyped(KeyEvent ke) {
                                    if (tf_prodmrp.getText().length() >= 5) {
                                        ke.consume();
                                    }
                                    if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                                        return;
                                    else
                                        ke.consume();
                                }
                            });

        Connection_method();
        tf_prodid.setEditable(false) ;
        tf_prodname.setEditable(false) ;
        tf_purpose.setEditable(false) ;
        tf_coloursize.setEditable(false);
        tf_pkgunit.setEditable(false);
        tf_prodmrp.setEditable(false);
        but_save.setEnabled(false);
        Buttons_Enable_Disable();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == but_add)
            Add_New_Product();
        else if (ae.getSource() == but_change)
            Change_Product();
        else if (ae.getSource() == but_save)
            Save_Product();
        else if (ae.getSource() == but_delete)
            Delete_Product();
        else if(ae.getSource() == but_view)
            View_Product();
        else if (ae.getSource() == but_search)
            Search_Product();
        else if (ae.getSource() == but_first)
            First_Product();
        else if (ae.getSource() == but_previous)
            Previous_Product();
        else if (ae.getSource() == but_next)
            Next_Product();
        else if (ae.getSource() == but_last)
            Last_Product();
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
            rs = st.executeQuery("select * from Products_Master order by Product_id");
            Statement stcount = con.createStatement();
            ResultSet rscount = stcount.executeQuery("select count(*) from Products_Master");
            rscount.next();
            count = rscount.getInt(1);
            if(count > 0){
                rs.first();
                Read_Products_Data();
            }
            //JOptionPane.showMessageDialog(this, "Java-Oracle Connection is established succesfully.");
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(this, "Problem in Java-Oracle Connection");
        } catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(this, "Problem when Loading the Driver.");
        }
    }

    void Add_New_Product(){
        int autocode = 0;
        if(count == 0)
            autocode = 1;
        else{
            try{
                rs.last();
                autocode = rs.getInt(1) + 1;
            }
            catch(SQLException e4){
                JOptionPane.showMessageDialog(this, "Problem during Generating ID for Product."); 
            }
        }
        tf_prodid.setEditable(true) ;
        tf_prodid.setText(String.valueOf(autocode));
        tf_prodid.setEditable(false);
        tf_prodname.setEditable(true) ;
        tf_purpose.setEditable(true) ;
        tf_coloursize.setEditable(true);
        tf_pkgunit.setEditable(true);
        tf_prodmrp.setEditable(true);
        chk = 'A';
        but_save.setEnabled(true);
        tf_prodname.setText("");
        tf_purpose.setText("");
        tf_coloursize.setText("");
        tf_pkgunit.setText("");
        tf_prodmrp.setText("");
        tf_prodname.requestFocus();
    }
    void Change_Product(){  
        tf_prodname.setEditable(true) ;
        tf_purpose.setEditable(true) ;
        tf_coloursize.setEditable(true);
        tf_pkgunit.setEditable(true);
        tf_prodmrp.setEditable(true);
        chk = 'C';
        but_save.setEnabled(true);
    }
    void Save_Product(){
        if(chk == 'A'){
            if(tf_prodid.getText().length() == 0 || tf_prodname.getText().length() == 0 || tf_purpose.getText().length() == 0 || tf_coloursize.getText().length() == 0 || tf_pkgunit.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Invalid Inputs, some Textfields may be empty. Please Input Complete Data."); 
            else{
                try{
                    PreparedStatement pst = con.prepareStatement("Insert into Products_Master values(?, ?, ?, ?, ?, ?)");
                    pst.setInt(1, Integer.parseInt(tf_prodid.getText()));
                    pst.setString(2, tf_prodname.getText());
                    pst.setString(3, tf_purpose.getText());
                    pst.setString(4, tf_coloursize.getText());
                    pst.setString(5, tf_pkgunit.getText());
                    pst.setLong(6, Integer.parseInt(tf_prodmrp.getText()));
                    pst.executeUpdate();
                    PreparedStatement pstmt = con.prepareStatement("Insert into Products_Stock values(?, 0)");
                    pstmt.setInt(1, Integer.parseInt(tf_prodid.getText()));
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, "New Product's Record is Added/Saved Successfully.");
                    count++;
                    rs = st.executeQuery("select * from Products_Master order by Product_id");
                    rs.last();
                    Buttons_Enable_Disable();
                }
                catch(SQLException e5){
                    JOptionPane.showMessageDialog(this, "Problem during Adding new Product data."); 
                }
            }
        }
        else if(chk == 'C'){
             if(tf_prodid.getText().length() == 0 || tf_prodname.getText().length() == 0 || tf_purpose.getText().length() == 0 || tf_coloursize.getText().length() == 0 || tf_pkgunit.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Invalid Inputs, some Textfields may be empty. Please Input Complete Data."); 
            else{
                try{
                    PreparedStatement pst = con.prepareStatement("Update Products_Master set Product_Name = ?, Purpose = ?,  Colour_Size = ?, Packaging_Unit = ?, Product_mrp = ? where Product_id = ?");
                    pst.setString(1, tf_prodname.getText());
                    pst.setString(2, tf_purpose.getText());
                    pst.setString(3, tf_coloursize.getText());
                    pst.setString(4, tf_pkgunit.getText());
                    pst.setLong(5, Integer.parseInt(tf_prodmrp.getText()));
                    pst.setInt(6, Integer.parseInt(tf_prodid.getText()));
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Product's Record is Updated Successfully.");
                    rs = st.executeQuery("select * from Products_Master order by Product_id");
                    while(rs.next()){
                        if(rs.getInt(1) == Integer.parseInt(tf_prodid.getText()))
                            break;
                    }
                }
                catch(SQLException e5){
                    JOptionPane.showMessageDialog(this, "Problem during Changing Record."); 
                }
            }
        }
        tf_prodname.setEditable(false) ;
        tf_purpose.setEditable(false) ;
        tf_coloursize.setEditable(false);
        tf_pkgunit.setEditable(false);
        tf_prodmrp.setEditable(false);
        chk = 'X';
        but_save.setEnabled(false);
        Buttons_Enable_Disable();
    }
    
    void Delete_Product() {
        int ans = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record permanently.", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
        if (ans == 0) {
            try {
                PreparedStatement pst = con.prepareStatement("delete from Products_Master where Product_id = ?");
                pst.setInt(1, Integer.parseInt(tf_prodid.getText()));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Product's Record is Deleted Successfully.");
                count--;
                rs = st.executeQuery("select * from Products_Master order by Product_id");
                if(count == 0){
                    tf_prodid.setText("");
                    tf_prodname.setText("");
                    tf_purpose.setText("");
                    tf_coloursize.setText("");
                    tf_pkgunit.setText("");
                    tf_prodmrp.setText("");
                } else{
                    rs.first();
                    Read_Products_Data();
                }
                Buttons_Enable_Disable();
            } catch (SQLException e6) {
                JOptionPane.showMessageDialog(this, "Problems when deleting the records.");
            }
        }
    }

    void Search_Product(){
        try {
            int prodno = Integer.parseInt(
            JOptionPane.showInputDialog(this, "Enter Product's Id No. whose record you want to Search."));
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getInt(1) == prodno) {
                    Read_Products_Data();
                    Buttons_Enable_Disable();
                    break;
                }
            }
            if (rs.isAfterLast()) {
                JOptionPane.showMessageDialog(this, "Product of Input ID No. Not Found.");
                rs.last();
                Read_Products_Data();
                Buttons_Enable_Disable();
            }
        } catch (SQLException e10) {
            JOptionPane.showMessageDialog(this, "Problem when Searching the Product's Record.");
        }
    }

    void First_Product(){
        try{
            rs.first();
            Read_Products_Data();
            Buttons_Enable_Disable();
        }
        catch(SQLException e7){
            JOptionPane.showMessageDialog(this, "Problem during navigating first record."); 
        }
    }

    void Previous_Product(){
        try{
            rs.previous();
            Read_Products_Data();
            Buttons_Enable_Disable();
        }
        catch(SQLException e8){
            JOptionPane.showMessageDialog(this, "Problem during navigating previous record."); 
        }
    }

    void Next_Product(){
        try{
            rs.next();
            Read_Products_Data();
            Buttons_Enable_Disable();
        }
        catch(SQLException e7){
            JOptionPane.showMessageDialog(this, "Problem during navigating next record."); 
        }
    }

    void Last_Product(){
        try{
            rs.last();
            Read_Products_Data();
            Buttons_Enable_Disable();
        }
        catch(SQLException e7){
            JOptionPane.showMessageDialog(this, "Problem during navigating last record."); 
        }
    }

    void Read_Products_Data(){
        try{
            tf_prodid.setText(String.valueOf(rs.getInt(1)));
            tf_prodname.setText(rs.getString(2));
            tf_purpose.setText(rs.getString(3));
            tf_coloursize.setText(rs.getString(4));
            tf_pkgunit.setText(rs.getString(5));
            tf_prodmrp.setText(String.valueOf(rs.getLong(6)));
        }
        catch(SQLException e6){
            JOptionPane.showMessageDialog(this, "Problem during reading Products Data."); 
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

    public static void main(String args[]) {
        new Products_MasterForm();
    }
   
    void View_Product(){
        int prodid = Integer.parseInt(tf_prodid.getText());
        JFrame fview = new JFrame();
        fview.setBounds(250, 250, 800, 500);
        fview.setVisible(true);
        String data[][] = new String[count][6];
        try{
            int r = 0;
            rs.beforeFirst();
            while(rs.next()){
                data[r][0] = String.valueOf(rs.getInt(1));
                data[r][1] = rs.getString(2);
                data[r][2] = rs.getString(3);
                data[r][3] = rs.getString(4);
                data[r][4] = rs.getString(5);
                data[r][5] = String.valueOf(rs.getInt(6));
                r++;
            }
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt(1) == prodid)
                    break;
            }
        }
        catch(SQLException e12){
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

 }  
