import java.sql.*;
class Sales_DistributionCreateTables  {
    public static void main(String args[])throws Exception{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            Statement st = con.createStatement();
            /*
            String qry = "Create table Distributors_Master(Distributor_id number(3) Primary Key, Dist_FirmName varchar2(30) not null, Address varchar2(60), City varchar2(15) not null, Contact_person varchar2(30) not null, Mobile_No1 number(10) not null, Mobile_No2 number(10), Distributorship_Date date)";
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