import java.sql.*;
class Wholeseller_CreateTables  {
    public static void main(String args[])throws Exception{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            Statement st = con.createStatement();
            /*
            String qry = "Create table Wholesellers_Master(Wholeseller_id number(3) not null Primary Key, Wholeseller_Name varchar2(25) not null, Address varchar2(60), City varchar2(15) not null, Mobile_No1 number(10) not null, Mobile_No2 number(10), Business_Nature varchar2(25))";
            st.executeUpdate(qry);
            */
            System.out.println("Table is created Successfully.");
            con.close();
        }                       
        catch(SQLException e){
            System.out.println("Problem during creating the Table.");
        }
    }
}