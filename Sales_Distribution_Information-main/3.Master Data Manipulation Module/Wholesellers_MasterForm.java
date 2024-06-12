import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


class Wholesellers_MasterForm extends JFrame implements ActionListener { 
    Connection con;
    Statement st;
    ResultSet rs;
    JLabel lb_title1, lb_title2, lb_wholeid, lb_wholename, lb_address, lb_city, lb_mobile1, lb_mobile2, lb_bus_nature;
    JTextField tf_wholeid, tf_wholename, tf_address, tf_city, tf_mobile1, tf_mobile2, tf_bus_nature;
    JButton but_add, but_save, but_change, but_delete, but_view, but_search, but_close, but_first, but_previous, but_next, but_last;
    char chk = 'X';
    int count = 0;
    Wholesellers_MasterForm() {
        setSize(1920, 920);
        setVisible(true);
        setLayout(null);
        lb_title1 = new JLabel("Wholesellers");
        lb_title2 = new JLabel("Master Data Manipulation Form");
        lb_wholeid = new JLabel("Wholeseller ID No.");
        lb_wholename = new JLabel("Wholeseller Name");
        lb_address = new JLabel("Address");
        lb_city = new JLabel("City");
        lb_mobile1 = new JLabel("Mobile No. 1");
        lb_mobile2 = new JLabel("Mobile No. 2");
        lb_bus_nature = new JLabel("Business Nature");
        tf_wholeid = new JTextField();
        tf_wholename = new JTextField();
        tf_address = new JTextField();
        tf_city = new JTextField();
        tf_mobile1 = new JTextField();
        tf_mobile2 = new JTextField();
        tf_bus_nature = new JTextField();
        but_add = new JButton("Add Wholeseller");
        but_save = new JButton("Save Record");
        but_change = new JButton("Change Record");
        but_delete = new JButton("Delete Record");
        but_view = new JButton("View All Wholesellers");
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
        lb_wholeid.setFont(f2);
        lb_wholename.setFont(f2);
        lb_address.setFont(f2);
        lb_city.setFont(f2);
        lb_mobile1.setFont(f2);
        lb_mobile2.setFont(f2);
        lb_bus_nature.setFont(f2);
        tf_wholeid.setFont(f2);
        tf_wholename.setFont(f2);
        tf_address.setFont(f2);
        tf_city.setFont(f2);
        tf_mobile1.setFont(f2);
        tf_mobile2.setFont(f2);
        tf_bus_nature.setFont(f2);
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
        add(lb_wholeid);
        add(lb_wholename);
        add(lb_address);
        add(lb_city);
        add(lb_mobile1);
        add(lb_mobile2);
        add(lb_bus_nature);
        add(tf_wholeid);
        add(tf_wholename);
        add(tf_address);
        add(tf_city);
        add(tf_mobile1);
        add(tf_mobile2);
        add(tf_bus_nature);
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

        lb_title1.setBounds(600, 50, 500, 45);
        lb_title2.setBounds(450, 100, 600, 45);
        lb_wholeid.setBounds(250, 250, 250, 30);
        tf_wholeid.setBounds(525, 250, 100, 30);
        lb_wholename.setBounds(250, 310, 275, 30);
        tf_wholename.setBounds(525, 310, 300, 30);
        lb_address.setBounds(250, 370, 250, 30);
        tf_address.setBounds(525, 370, 500, 30);
        lb_city.setBounds(250, 430, 250, 30);
        tf_city.setBounds(525, 430, 300, 30);
        lb_mobile1.setBounds(250, 490, 200, 30);
        tf_mobile1.setBounds(525, 490, 200, 30);
        lb_mobile2.setBounds(750, 490, 150, 30);
        tf_mobile2.setBounds(925, 490, 200, 30);
        lb_bus_nature.setBounds(250, 550, 250, 30);
        tf_bus_nature.setBounds(525, 550, 300, 30);
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
        tf_wholename.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_wholename.getText().length() >= 25) {
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

        tf_bus_nature.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tf_bus_nature.getText().length() >= 25) {
                            ke.consume();
                        }
                        if (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') {
                            return;
                        } else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z') {
                            return;
                        } else if (ke.getKeyChar() == ' ' || ke.getKeyChar() == ',') {
                            return;
                        } else {
                            ke.consume();
                        }
                    }
                });


        Connection_method();
        tf_wholeid.setEditable(false) ;
        tf_wholename.setEditable(false) ;
        tf_address.setEditable(false) ;
        tf_city.setEditable(false);
        tf_mobile1.setEditable(false);
        tf_mobile2.setEditable(false);
        tf_bus_nature.setEditable(false);
        but_save.setEnabled(false);
        Buttons_Enable_Disable();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == but_add)
            Add_New_Wholeseller();
        else if (ae.getSource() == but_change)
            Change_Wholeseller();
        else if (ae.getSource() == but_save)
            Save_Wholeseller();
        else if (ae.getSource() == but_delete)
            Delete_Wholeseller();
        else if(ae.getSource() == but_view)
            View_Wholeseller();
        else if (ae.getSource() == but_search)
            Search_Wholeseller();
        else if (ae.getSource() == but_first)
            First_Wholselller();
        else if (ae.getSource() == but_previous)
            Previous_Wholeseller();
        else if (ae.getSource() == but_next)
            Next_Wholeseller();
        else if (ae.getSource() == but_last)
            Last_Wholeseller();
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
            rs = st.executeQuery("select * from Wholesellers_Master order by Wholeseller_id");
            Statement stcount = con.createStatement();
            ResultSet rscount = stcount.executeQuery("select count(*) from Wholesellers_Master");
            rscount.next();
            count = rscount.getInt(1);
            if(count > 0){
                rs.first();
                Read_Wholesellers_Data();
            }
            //JOptionPane.showMessageDialog(this, "Java-Oracle Connection is established succesfully.");
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(this, "Problem in Java-Oracle Connection");
        } catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(this, "Problem when Loading the Driver.");
        }
    }

    void Add_New_Wholeseller(){
        int autocode = 0;
        if(count == 0)
            autocode = 1;
        else{
            try{
                rs.last();
                autocode = rs.getInt(1) + 1;
            }
            catch(SQLException e4){
                JOptionPane.showMessageDialog(this, "Problem during Generating ID for Wholeseller."); 
            }
        }
        tf_wholeid.setEditable(true) ;
        tf_wholeid.setText(String.valueOf(autocode));
        tf_wholeid.setEditable(false);
        tf_wholename.setEditable(true) ;
        tf_address.setEditable(true) ;
        tf_city.setEditable(true);
        tf_mobile1.setEditable(true);
        tf_mobile2.setEditable(true);
        tf_bus_nature.setEditable(true);
        chk = 'A';
        but_save.setEnabled(true);
        tf_wholename.setText("");
        tf_address.setText("");
        tf_city.setText("");
        tf_mobile1.setText("");
        tf_mobile2.setText("");
        tf_bus_nature.setText("");
        tf_wholename.requestFocus();
    }
    void Change_Wholeseller(){  
        tf_wholename.setEditable(true) ;
        tf_address.setEditable(true) ;
        tf_city.setEditable(true);
        tf_mobile1.setEditable(true);
        tf_mobile2.setEditable(true);
        tf_bus_nature.setEditable(true);
        chk = 'C';
        but_save.setEnabled(true);
    }
    void Save_Wholeseller(){
        if(chk == 'A'){
            if(tf_wholeid.getText().length() == 0 || tf_wholename.getText().length() == 0 || tf_address.getText().length() == 0 || tf_city.getText().length() == 0 || tf_mobile1.getText().length() == 0 || tf_bus_nature.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Invalid Inputs, some Textfields may be empty. Please Input Complete Data."); 
            else{
                try{
                    PreparedStatement pst = con.prepareStatement("Insert into Wholesellers_Master values(?, ?, ?, ?, ?, ?, ?)");
                    pst.setInt(1, Integer.parseInt(tf_wholeid.getText()));
                    pst.setString(2, tf_wholename.getText());
                    pst.setString(3, tf_address.getText());
                    pst.setString(4, tf_city.getText());
                    pst.setLong(5, Long.parseLong(tf_mobile1.getText()));
                    if(tf_mobile2.getText().length() == 0)
                        pst.setLong(6, -1);
                    else
                        pst.setLong(6, Long.parseLong(tf_mobile2.getText()));
                    pst.setString(7, tf_bus_nature.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "New Wholeseller's Record is Added/Saved Successfully.");
                    count++;
                    rs = st.executeQuery("select * from Wholesellers_Master order by Wholeseller_id");
                    rs.last();
                    Buttons_Enable_Disable();
                }
                catch(SQLException e5){
                    JOptionPane.showMessageDialog(this, "Problem during Adding new Wholeseller data."); 
                }
            }
        }
        else if(chk == 'C'){
             if(tf_wholeid.getText().length() == 0 || tf_wholename.getText().length() == 0 || tf_address.getText().length() == 0 || tf_city.getText().length() == 0 || tf_mobile1.getText().length() == 0 || tf_bus_nature.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Invalid Inputs, some Textfields may be empty. Please Input Complete Data."); 
            else{
                try{
                    PreparedStatement pst = con.prepareStatement("Update Wholesellers_Master set Wholeseller_Name = ?, Address = ?,  City = ?, Mobile_No1 = ?, Mobile_No2 = ?, Business_Nature = ? where Wholeseller_id = ?");
                    pst.setString(1, tf_wholename.getText());
                    pst.setString(2, tf_address.getText());
                    pst.setString(3, tf_city.getText());
                    pst.setLong(4, Long.parseLong(tf_mobile1.getText()));
                    if(tf_mobile2.getText().length() == 0)
                        pst.setLong(5, -1);
                    else
                        pst.setLong(5, Long.parseLong(tf_mobile2.getText()));
                    pst.setString(6, tf_bus_nature.getText());
                    pst.setInt(7, Integer.parseInt(tf_wholeid.getText()));
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Wholeseller's Record is Updated Successfully.");
                    rs = st.executeQuery("select * from Wholesellers_Master order by Wholeseller_id");
                    while(rs.next()){
                        if(rs.getInt(1) == Integer.parseInt(tf_wholeid.getText()))
                            break;
                    }
                }
                catch(SQLException e5){
                    JOptionPane.showMessageDialog(this, "Problem during Changing Record."); 
                }
            }
        }
        tf_wholename.setEditable(false) ;
        tf_address.setEditable(false) ;
        tf_city.setEditable(false);
        tf_mobile1.setEditable(false);
        tf_mobile2.setEditable(false);
        tf_bus_nature.setEditable(false);
        chk = 'X';
        but_save.setEnabled(false);
        Buttons_Enable_Disable();
    }
    
    void Delete_Wholeseller() {
        int ans = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record permanently.", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
        if (ans == 0) {
            try {
                PreparedStatement pst = con.prepareStatement("delete from Wholesellers_Master where Wholeseller_id = ?");
                pst.setInt(1, Integer.parseInt(tf_wholeid.getText()));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Wholeseller's Record is Deleted Successfully.");
                count--;
                rs = st.executeQuery("select * from Wholesellers_Master order by Wholeseller_id");
                if(count == 0){
                    tf_wholeid.setText("");
                    tf_wholename.setText("");
                    tf_address.setText("");
                    tf_city.setText("");
                    tf_mobile1.setText("");
                    tf_mobile2.setText("");
                    tf_bus_nature.setText("");
                } else{
                    rs.first();
                    Read_Wholesellers_Data();
                }
                Buttons_Enable_Disable();
            } catch (SQLException e6) {
                JOptionPane.showMessageDialog(this, "Problems when deleting the records.");
            }
        }
    }

    void Search_Wholeseller(){
        try {
            int wholeno = Integer.parseInt(
            JOptionPane.showInputDialog(this, "Enter Wholeseller's Id No. whose record you want to Search."));
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getInt(1) == wholeno) {
                    Read_Wholesellers_Data();
                    Buttons_Enable_Disable();
                    break;
                }
            }
            if (rs.isAfterLast()) {
                JOptionPane.showMessageDialog(this, "Wholeseller of Input ID No. Not Found.");
                rs.last();
                Read_Wholesellers_Data();
                Buttons_Enable_Disable();
            }
        } catch (SQLException e10) {
            JOptionPane.showMessageDialog(this, "Problem when Searching the Wholeseller's Record.");
        }
    }

    void First_Wholselller(){
        try{
            rs.first();
            Read_Wholesellers_Data();
            Buttons_Enable_Disable();
        }
        catch(SQLException e7){
            JOptionPane.showMessageDialog(this, "Problem during navigating first record."); 
        }
    }

    void Previous_Wholeseller(){
        try{
            rs.previous();
            Read_Wholesellers_Data();
            Buttons_Enable_Disable();
        }
        catch(SQLException e8){
            JOptionPane.showMessageDialog(this, "Problem during navigating previous record."); 
        }
    }

    void Next_Wholeseller(){
        try{
            rs.next();
            Read_Wholesellers_Data();
            Buttons_Enable_Disable();
        }
        catch(SQLException e7){
            JOptionPane.showMessageDialog(this, "Problem during navigating next record."); 
        }
    }

    void Last_Wholeseller(){
        try{
            rs.last();
            Read_Wholesellers_Data();
            Buttons_Enable_Disable();
        }
        catch(SQLException e7){
            JOptionPane.showMessageDialog(this, "Problem during navigating last record."); 
        }
    }

    void Read_Wholesellers_Data(){
        try{
            tf_wholeid.setText(String.valueOf(rs.getInt(1)));
            tf_wholename.setText(rs.getString(2));
            tf_address.setText(rs.getString(3));
            tf_city.setText(rs.getString(4));
            tf_mobile1.setText(String.valueOf(rs.getLong(5)));
            if(rs.getLong(6) == -1)
                tf_mobile2.setText("");
            else
                tf_mobile2.setText(String.valueOf(rs.getLong(6)));
            tf_bus_nature.setText(rs.getString(7));
        }
        catch(SQLException e6){
            JOptionPane.showMessageDialog(this, "Problem during reading Wholesellers Data."); 
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
        new Wholesellers_MasterForm();
    }
   
    void View_Wholeseller(){
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

 }  
