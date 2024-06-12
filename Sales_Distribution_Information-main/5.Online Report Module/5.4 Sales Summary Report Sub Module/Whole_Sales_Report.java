import java.io.*;
import java.sql.*;
public class Whole_Sales_Report
{
    int wholesellerid;
    String wholename, wholecity;
    Connection con;
    ResultSet rs, rs_whole;
    Whole_Sales_Report(int wholeid, String start_date, String end_date)
    {
        wholesellerid = wholeid;
        try{
            Connection_method(start_date, end_date);
            BufferedWriter bw = new BufferedWriter(new FileWriter("Sales4.html"));
            bw.write("<html>");
            bw.write("<body>");
            bw.write("<center><h1>Samsung Electronics Public Limited</h1></center>");     
            bw.write("<center><h1>Wholeseller wise Sales Summary Report</h1></center>");
            bw.write("<center><h4>(Wholeseller's Sales Register)</h4></center>");
            bw.write("<br>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Period From : "+start_date);
            String cdate = CurrentDate();
            bw.write("&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Report Date : "+cdate);
            bw.write("<br>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Period To : "+end_date);
            String ctime = CurrentTime();
            bw.write("&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Report Time : "+ctime); 
            bw.write("<br><br><br>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Wholeseller ID : "+wholesellerid);
            bw.write("<br>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Wholeseller Name : "+wholename);
            bw.write("<br>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;City: "+wholecity);
            bw.write("<br><br><br>");
            bw.write("<center>");
            bw.write("<table border = 1 cell padding = 0 cell spacing = 0>");
            bw.write("<tr>");
            bw.write("<th>Sales Bill No.</th>");
            bw.write("<th>Sales Date</th>");
            bw.write("<th>Product ID</th>");
            bw.write("<th>Product Name</th>");
            bw.write("<th>Packaging Unit</th>");
            bw.write("<th>Sales Quantity</th>");
            bw.write("<th>Sales Rate</th>");
            bw.write("<th>Sales Amount</th>");
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
                bw.write("<td>Total Sales (Summary) : "+"</td>");
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
            rt.exec("Explorer Sales4.html");
        }
        catch(IOException ioe1)
        {
        }
    }
    public static void main(String args[]){
        new Whole_Sales_Report(2, "16-DEC-2022", "31-DEC-2022");
    }
    void Connection_method(String sdate, String edate) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String qry = "Select s.sales_billno, s.sales_date, s.product_id, p.product_name, p.Packaging_unit, s.sales_qty, s.sales_rate, s.gst_in_per, s.add_amount from Products_Sales s, Products_Master p where s.product_id = p.product_id and s.sales_date between '"+ sdate +"' and '"+ edate +"' and s.wholeseller_id = "+ wholesellerid +" order by s.sales_date";
            rs = st.executeQuery(qry);
            Statement st_whole = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String wholeqry = "Select wholeseller_name, city from Wholesellers_Master where wholeseller_id = "+ wholesellerid;
            rs_whole = st_whole.executeQuery(wholeqry);
            rs_whole.next();
            wholename = rs_whole.getString(1);
            wholecity = rs_whole.getString(2);
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
