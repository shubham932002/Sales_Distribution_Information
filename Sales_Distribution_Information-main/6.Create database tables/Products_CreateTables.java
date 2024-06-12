import java.sql.*;
class Products_CreateTables  {
    public static void main(String args[])throws Exception{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            Statement st = con.createStatement();/*
            String qry = "Create table Products_Master(Product_id number(3) not null Primary Key, Product_Name varchar2(25) not null, Purpose varchar2(30), Colour_Size varchar2(25) not null, Packaging_Unit varchar2(25) not null, Product_mrp number(5) not null)";
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