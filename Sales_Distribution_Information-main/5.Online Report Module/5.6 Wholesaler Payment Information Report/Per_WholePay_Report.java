import java.io.*;
import java.sql.*;
public class Per_WholePay_Report
{
    Connection con;
    ResultSet rs;
    Per_WholePay_Report(String start_date, String end_date)
    {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("Pay1.html"));
            bw.write("<html>");
            bw.write("<body>");
            bw.write("<center><h1>Samsung Electronics Public Limited</h1></center>");     
            bw.write("<center><h1>Wholesellers Payment Received Transaction Report (Periodical)</h1></center>");
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
            bw.write("<th>Payment Receipt No.</th>");
            bw.write("<th>Payment Received Date</th>");
            bw.write("<th>Wholeseller ID</th>");
            bw.write("<th>Wholeseller Name</th>");
            bw.write("<th>City</th>");
            bw.write("<th>Payment Received Amount</th>");
            bw.write("<th>Mode of Payment</th>");
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
            rt.exec("Explorer Pay1.html");
        }
        catch(IOException ioe1)
        {
        }
    }
    public static void main(String args[]){
        new Per_WholePay_Report("1-DEC-2022", "31-DEC-2022");
    }
    void Connection_method(String sdate, String edate) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String qry = "Select p.whol_pay_recno, p.whol_pay_recdate, p.wholeseller_id, w.wholeseller_name, w.city, p.rec_amount, p.whol_pay_mode_info from wholesellers_payment p, wholesellers_master w where p.wholeseller_id = w.wholeseller_id and p.whol_pay_recdate between '"+ sdate +"' and '"+ edate +"' order by p.whol_pay_recdate";
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
