import java.io.*;
import java.sql.*;
public class Wholesellers_InfoReport
{
    Connection con;
    ResultSet rs;
    Wholesellers_InfoReport()
    {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("InfoRep2.html"));
            bw.write("<html>");
            bw.write("<body>");
            bw.write("<center><h1>Samsung Electronics Limited</h1></center>");     
            bw.write("<center><h1>Wholesellers Information Report</h1></center>");
            String cdate = CurrentDate();
            bw.write("<br>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Report Date : "+cdate);
            String ctime = CurrentTime();
            bw.write("<br>"+"&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Report Time : "+ctime); 
            bw.write("<br><br><br>");
            bw.write("<center>");
            bw.write("<table border = 1 cell padding = 0 cell spacing = 0>");
            bw.write("<tr>");
            bw.write("<th>Wholeseller ID</th>");
            bw.write("<th>Wholeseller Name</th>");
            bw.write("<th>Address</th>");
            bw.write("<th>City</th>");
            bw.write("<th>Mobile No. 1</th>");
            bw.write("<th>Mobile No. 2</th>");
            bw.write("<th>Business Nature</th>");
            bw.write("</tr>");
            Connection_method();
            try {
                while(rs.next()){
                    bw.write("<tr>");
                    bw.write("<td>"+String.valueOf(rs.getInt(1))+"</td>");
                    bw.write("<td>"+rs.getString(2)+"</td>");
                    bw.write("<td>"+rs.getString(3)+"</td>");
                    bw.write("<td>"+rs.getString(4)+"</td>");
                    bw.write("<td>"+String.valueOf(rs.getLong(5))+"</td>");
                    if(rs.getLong(6) == -1)
                        bw.write("<td>"+""+"</td>");
                    else
                        bw.write("<td>"+String.valueOf(rs.getLong(6))+"</td>");
                        bw.write("<td>"+rs.getString(7)+"</td>");
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
            rt.exec("Explorer InfoRep2.html");
        }
        catch(IOException ioe1)
        {
        }
    }
    public static void main(String args[]){
        new Wholesellers_InfoReport();
    }
    void Connection_method() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from Wholesellers_Master order by Wholeseller_id");
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
