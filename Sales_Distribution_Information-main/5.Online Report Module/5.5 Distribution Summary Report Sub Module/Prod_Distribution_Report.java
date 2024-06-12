import java.io.*;
import java.sql.*;
public class Prod_Distribution_Report
{
    int productid;
    String prodname, pkgunit;
    Connection con;
    ResultSet rs, rs_prod;
    Prod_Distribution_Report(int prodid, String start_date, String end_date)
    {
        productid = prodid;
        try{
            Connection_method(start_date, end_date);
            BufferedWriter bw = new BufferedWriter(new FileWriter("Sales3.html"));
            bw.write("<html>");
            bw.write("<body>");
            bw.write("<center><h1>Samsung Electronics Public Limited</h1></center>");     
            bw.write("<center><h1>Product wise Distribution Summary Report</h1></center>");
            bw.write("<center><h3>(Products Distribution Register)</h3></center>");
            bw.write("<br>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Period From : "+start_date);
            String cdate = CurrentDate();
            bw.write("&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Report Date : "+cdate);
            bw.write("<br>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Period To : "+end_date);
            String ctime = CurrentTime();
            bw.write("&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Report Time : "+ctime); 
            bw.write("<br><br><br>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Product ID : "+productid);
            bw.write("<br>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Product Name : "+prodname);
            bw.write("<br>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Packaging Unit: "+pkgunit);
            bw.write("<br><br><br>");
            bw.write("<center>");
            bw.write("<table border = 1 cell padding = 0 cell spacing = 0>");
            bw.write("<tr>");
            bw.write("<th>Dist Bill No.</th>");
            bw.write("<th>Dist Date</th>");
            bw.write("<th>Dist ID</th>");
            bw.write("<th>Distributor Firm Name</th>");
            bw.write("<th>City</th>");
            bw.write("<th>Distributed Quantity</th>");
            bw.write("<th>Distribution Rate</th>");
            bw.write("<th>Distribution Amount</th>");
            bw.write("<th>GST (in %)</th>");
            bw.write("<th>GST Amount</th>");
            bw.write("<th>Add-Charges</th>");
            bw.write("<th>Net Amount</th>");
            bw.write("</tr>");
            try {
                long sa;
                double gst_amt, net_amt, gr_tot = 0;
                while(rs.next()){
                    bw.write("<tr>");
                    bw.write("<td>"+String.valueOf(rs.getInt(1))+"</td>");
                    String indate = String.valueOf(rs.getDate(2).getDate()) + "-" + String.valueOf((rs.getDate(2).getMonth()+1)) + "-" + String.valueOf(rs.getDate(2).getYear()+1900);
                    bw.write("<td>"+indate+"</td>");
                    //bw.write("<td>"+rs.getString(2)+"</td>");
                    bw.write("<td>"+String.valueOf(rs.getInt(3))+"</td>");
                    bw.write("<td>"+rs.getString(4)+"</td>");
                    bw.write("<td>"+rs.getString(5)+"</td>");
                    bw.write("<td>"+String.valueOf(rs.getInt(6))+"</td>");
                    bw.write("<td>"+String.valueOf(rs.getInt(7))+"</td>");
                    sa = rs.getInt(6) * rs.getInt(7);
                    bw.write("<td>"+sa+"</td>");
                    bw.write("<td>"+String.valueOf(rs.getDouble(8))+"</td>");
                    gst_amt = rs.getDouble(8) * (double)sa/100;
                    bw.write("<td>"+gst_amt+"</td>");
                    bw.write("<td>"+String.valueOf(rs.getDouble(9))+"</td>");
                    net_amt = sa + gst_amt + rs.getDouble(9);
                    gr_tot = gr_tot + net_amt;
                    bw.write("<td>"+net_amt+"</td>");
                    bw.write("</tr>");
                }
                bw.write("<tr>");
                bw.write("<td><td><td><td><td><td><td><td><td><td>");
                bw.write("<td>Total Distribution Amount (Summary) : "+"</td>");
                bw.write("<td>"+gr_tot+"</td>");
                bw.write("</tr>");
                con.close();
            } 
            catch (SQLException e3) {
                System.out.println("Problem when Producing the Report.");
            }
            bw.write("</table>");
            bw.write("</center>");
            bw.write("</body>");
            bw.write("</html>");
            bw.close(); 
            Runtime rt = Runtime.getRuntime();
            rt.exec("Explorer Sales3.html");
        }
        catch(IOException ioe1)
        {
        }
    }
    public static void main(String args[]){
        new Prod_Distribution_Report(3, "16-DEC-2022", "31-DEC-2022");
    }
    void Connection_method(String sdate, String edate) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String qry = "Select s.distribution_billno, s.distribution_date, s.distributor_id, d.dist_firmname, d.city, s.distribution_qty, s.distribution_rate, s.gst_in_per, s.add_amount from Products_Distribution s, Distributors_Master d where s.distributor_id = d.distributor_id and s.distribution_date between '"+ sdate +"' and '"+ edate +"' and s.product_id = "+ productid +" order by s.distribution_date";
            rs = st.executeQuery(qry);
            Statement st_prod = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String prodqry = "Select product_name, packaging_unit from Products_Master where product_id = "+ productid;
            rs_prod = st_prod.executeQuery(prodqry);
            rs_prod.next();
            prodname = rs_prod.getString(1);
            pkgunit = rs_prod.getString(2);
        } 
        catch (SQLException e1) {
            System.out.println("Problem in Java-Oracle Connection");
        } catch (ClassNotFoundException e2) {
            System.out.println("Problem when Loading the Driver.");
        }
    }
    String CurrentDate(){
        java.util.Date obj = new java.util.Date();
        int d = obj.getDate();
        int m = obj.getMonth() + 1;
        int y = obj.getYear() + 1900;
        String mon = "";
        switch(m){
            case 1 : mon = "January";       
                    break;
            case 2 : mon = "February";       
                    break;
            case 3 : mon = "March";       
                    break;
           case 4 : mon = "April";       
                    break;
            case 5 : mon = "May";       
                    break;
            case 6 : mon = "June";       
                    break;
            case 7 : mon = "July";       
                    break;
            case 8 : mon = "August";       
                    break;
            case 9 : mon = "September";       
                    break;
            case 10 : mon = "October";       
                    break;
            case 11 : mon = "November";       
                    break;
            case 12 : mon = "December";       
                    break;
        }
        String cdate = mon + " " + d + ", " + y;
        //System.out.println("Current Date is : "+cdate);
        return cdate;
    }
    String CurrentTime(){
        java.util.Date obj = new java.util.Date();
        int h = obj.getHours();
        int min = obj.getMinutes();
        int s = obj.getSeconds();
        String ctime = h + ":" + min + ":" + s;
        //System.out.println("Current Time : "+ctime);
        return ctime;        
    }
}
