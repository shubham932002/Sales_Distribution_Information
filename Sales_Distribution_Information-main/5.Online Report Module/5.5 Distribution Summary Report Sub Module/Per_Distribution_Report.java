import java.io.*;
import java.sql.*;
public class Per_Distribution_Report
{
    Connection con;
    ResultSet rs;
    Per_Distribution_Report(String start_date, String end_date)
    {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("Sales1.html"));
            bw.write("<html>");
            bw.write("<body>");
            bw.write("<center><h1>Samsung Electronics Public Limited</h1></center>");     
            bw.write("<center><h1>Products Distribution Transaction Report (Periodical)</h1></center>");
            bw.write("<br>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Period From : "+start_date);
            String cdate = CurrentDate();
            bw.write("&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Report Date : "+cdate);
            bw.write("<br>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Period To : "+end_date);
            String ctime = CurrentTime();
            bw.write("&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Report Time : "+ctime); 
            bw.write("<br><br><br>");
            bw.write("<center>");
            bw.write("<table border = 1 cell padding = 0 cell spacing = 0>");
            bw.write("<tr>");
            bw.write("<th>Distribution Bill No.</th>");
            bw.write("<th>Distribution Date</th>");
            bw.write("<th>Distributor ID</th>");
            bw.write("<th>Distributor Firm Name</th>");
            bw.write("<th>City</th>");
            bw.write("<th>Product ID</th>");
            bw.write("<th>Product Name</th>");
            bw.write("<th>Packaging Unit</th>");
            bw.write("<th>Distributed Quantity</th>");
            bw.write("<th>Distributed Rate</th>");
            bw.write("<th>GST (in %)</th>");
            bw.write("<th>Add-Charges</th>");
            bw.write("<th>Additional Charges Information</th>");
            bw.write("</tr>");
            Connection_method(start_date, end_date);
            try {
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
                    bw.write("<td>"+rs.getString(7)+"</td>");
                    bw.write("<td>"+rs.getString(8)+"</td>");
                    bw.write("<td>"+String.valueOf(rs.getInt(9))+"</td>");
                    bw.write("<td>"+String.valueOf(rs.getInt(10))+"</td>");
                    bw.write("<td>"+String.valueOf(rs.getInt(11))+"</td>");
                    bw.write("<td>"+String.valueOf(rs.getInt(12))+"</td>");
                    bw.write("<td>"+rs.getString(13)+"</td>");
                    bw.write("</tr>");
                }
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
            rt.exec("Explorer Sales1.html");
        }
        catch(IOException ioe1)
        {
        }
    }
    public static void main(String args[]){
        new Per_Distribution_Report("16-DEC-2022", "31-DEC-2022");
    }
    void Connection_method(String sdate, String edate) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String qry = "Select s.distribution_billno, s.distribution_date, s.distributor_id, d.dist_firmname, d.city, s.product_id, p.product_name, p.packaging_unit, s.distribution_qty, s.distribution_rate, s.gst_in_per, s.add_amount, s.add_info from Products_Distribution s, Distributors_Master d, Products_Master p where s.distributor_id = d.distributor_id and s.product_id = p.product_id and s.distribution_date between '"+ sdate +"' and '"+ edate +"' order by s.distribution_date";
            rs = st.executeQuery(qry);
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
