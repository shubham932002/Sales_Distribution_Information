import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Accept_Product extends JFrame implements ActionListener{
    JLabel lb_title, lb_reportname, lb_prodid, lb_sdate, lb_edate;
    JTextField tf_prodid, tf_sdate, tf_edate;
    JButton but_viewprod, but_pro, but_cancel;
    String global_source = "";
    ResultSet rs_prod ;
    Accept_Product(String source){
        global_source = source;
        String x = "";
        if(source.equals("Sales_Report"))
            x = "Products wise Sales Summary Report (Products Sales Register)";
        else if(source.equals("Distribution_Report"))
            x = "Products wise Distribution Summary Report (Products Distribution Register)";
        setSize(900,500);
        setVisible(true);
        setLayout(null);
        lb_title = new JLabel("Enter the Period to Produce : ");
        lb_reportname = new JLabel(x);
        lb_prodid = new JLabel("Product ID");
        lb_sdate = new JLabel("Starting Date");
        lb_edate = new JLabel("Ending Date");
        tf_prodid = new JTextField("1");
        tf_sdate = new JTextField("01-DEC-2022");
        tf_edate = new JTextField("31-DEC-2022");
        but_viewprod = new JButton("Products List");
        but_pro = new JButton("Produce Report");
        but_cancel = new JButton("Cancel");
        but_viewprod.addActionListener(this);
        but_pro.addActionListener(this);
        but_cancel.addActionListener(this);
        Font f1, f2;
        f1 = new Font("Arial", Font.BOLD, 32);
        f2 = new Font("Times New Roman", Font.PLAIN, 24);
        lb_title.setFont(f1);
        lb_reportname.setFont(f1);
        lb_prodid.setFont(f2);
        lb_sdate.setFont(f2);
        lb_edate.setFont(f2);
        tf_prodid.setFont(f2);
        tf_sdate.setFont(f2);
        tf_edate.setFont(f2);
        but_viewprod.setFont(f2);
        but_pro.setFont(f2);
        but_cancel.setFont(f2);
        add(lb_title);
        add(lb_reportname);
        add(lb_prodid);
        add(lb_sdate);
        add(lb_edate);
        add(tf_prodid);
        add(tf_sdate);
        add(tf_edate);
        add(but_viewprod);
        add(but_pro);
        add(but_cancel);

        lb_title.setBounds(225, 100, 450, 40);
        lb_reportname.setBounds(75, 150, 800, 40);
        lb_prodid.setBounds(250, 225, 150, 30);
        tf_prodid.setBounds(450, 225, 75, 30);
        but_viewprod.setBounds(625, 225, 175, 30);
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
            tf_prodid.requestFocus();
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == but_viewprod)
            Products_List();
        else if(ae.getSource() == but_pro){
            if(global_source.equals("Sales_Report"))
                new Prod_Sales_Report(Integer.parseInt(tf_prodid.getText()), tf_sdate.getText(), tf_edate.getText());
            else if(global_source.equals("Distribution_Report"))
                new Prod_Distribution_Report(Integer.parseInt(tf_prodid.getText()), tf_sdate.getText(), tf_edate.getText());
        }
        else if(ae.getSource() == but_cancel){
            dispose();
        }
    }
    void Products_List(){
        int product_count= 0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            Statement st_prod = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs_prod = st_prod.executeQuery("select * from Products_Master order by Product_id");
            Statement st_product_count = con.createStatement();
            ResultSet rs_product_count = st_product_count.executeQuery("select count(*) from Products_Master");
            rs_product_count.next();
            product_count = rs_product_count.getInt(1);
            
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(this, "Problem in Java-Oracle Connection");
        } catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(this, "Problem when Loading the Driver.");
        }
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
    public static void main(String args[]){
        new Accept_Product("");
    }
    
}
