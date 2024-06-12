import java.io.*;
import java.sql.*;
public class Distributors_InfoReport
{
    Connection con;
    ResultSet rs;
    Distributors_InfoReport()
    {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("InfoRep1.html"));
            bw.write("<html>");
            bw.write("<body>");
            bw.write("<center><h1>Samsung Electronics Limited</h1></center>");     
            bw.write("<center><h1>Authorised Distributors Information Report</h1></center>");
            String cdate = CurrentDate();
            bw.write("<br>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Report Date : "+cdate);
            String ctime = CurrentTime();
            bw.write("<br>"+"&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Report Time : "+ctime); 
            bw.write("<br><br><br>");
            bw.write("<center>");
            bw.write("<table border = 1 cell padding = 0 cell spacing = 0>");
            bw.write("<tr>");
            bw.write("<th>Distributor ID</th>");
            bw.write("<th>Distributor Firm Name</th>");
            bw.write("<th>Address</th>");
            bw.write("<th>City</th>");
            bw.write("<th>Contact Person</th>");
            bw.write("<th>Mobile No. 1</th>");
            bw.write("<th>Mobile No. 2</th>");
            bw.write("<th>Distributorship Date</th>");
            bw.write("</tr>");
            Connection_method();
            try {
                while(rs.next()){
                    bw.write("<tr>");
                    bw.write("<td>"+String.valueOf(rs.getInt(1))+"</td>");
                    bw.write("<td>"+rs.getString(2)+"</td>");
                    bw.write("<td>"+rs.getString(3)+"</td>");
                    bw.write("<td>"+rs.getString(4)+"</td>");
                    bw.write("<td>"+rs.getString(5)+"</td>");
                    bw.write("<td>"+String.valueOf(rs.getLong(6))+"</td>");
                    if(rs.getLong(7) == -1)
                        bw.write("<td>"+""+"</td>");
                    else
                        bw.write("<td>"+String.valueOf(rs.getLong(7))+"</td>");
                    String ddate = String.valueOf(rs.getDate(8).getDate()) + "-" + String.valueOf((rs.getDate(8).getMonth()+1)) + "-" + String.valueOf(rs.getDate(8).getYear()+1900);
                    bw.write("<td>"+ddate+"</td>");
                    bw.write("</tr>");
                }
                con.close();
            } 
            catch (SQLException e2) {
                System.out.println("Problem when Producing the Report.");
            }
            bw.write("</table>");
            bw.write("</center>");
            bw.write("</body>");
            bw.write("</html>");
            bw.close(); 
            Runtime rt = Runtime.getRuntime();
            rt.exec("Explorer InfoRep1.html");
        }
        catch(IOException ioe1)
        {
        }
    }
    public static void main(String args[]){
        new Distributors_InfoReport();
    }
    void Connection_method() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from Distributors_Master order by Distributor_id");
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
