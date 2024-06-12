import java.io.*;
import java.sql.*;
public class Products_Inward_Report
{
    Connection con;
    ResultSet rs;
    Products_Inward_Report(String start_date, String end_date)
    {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("Inward.html"));
            bw.write("<html>");
            bw.write("<body>");
            bw.write("<center><h1>Samsung Electronics Public Limited</h1></center>");     
            bw.write("<center><h1>Manufactured Products Inward Report (Periodical)</h1></center>");
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
            bw.write("<th>Inward No.</th>");
            bw.write("<th>Inward Date</th>");
            bw.write("<th>Product ID</th>");
            bw.write("<th>Product Name</th>");
            bw.write("<th>Colour - Size</th>");
            bw.write("<th>Packaging Unit</th>");
            bw.write("<th>Inward Quantity</th>");
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
                    bw.write("<td>"+rs.getString(6)+"</td>");
                    bw.write("<td>"+String.valueOf(rs.getInt(7))+"</td>");
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
            rt.exec("Explorer Inward.html");
        }
        catch(IOException ioe1)
        {
        }
    }
    public static void main(String args[]){
        new Products_Inward_Report("16-DEC-2022", "31-DEC-2022");
    }
    void Connection_method(String sdate, String edate) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String qry = "Select i.inward_entryno, i.inward_date, i.product_id, p.product_name, p.colour_size, p.packaging_unit, i.inward_qty from Products_Inward i, Products_Master p where i.product_id = p.product_id and i.inward_date between '"+ sdate +"' and '"+ edate +"' order by i.inward_date";
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
