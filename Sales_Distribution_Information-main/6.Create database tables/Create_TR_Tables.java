import java.sql.*;
class Create_TR_Tables  {
    public static void main(String args[])throws Exception{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            Statement st = con.createStatement();
            /*
            String qry = "Create Table Products_Inward(Inward_Entryno Number(6) Primary Key, Inward_Date Date not null, Product_id Number(3) references Products_Master, Inward_Qty Number(3) not null)";
            st.executeUpdate(qry);
            System.out.println("Table Products_Inward is created Successfully.");
            qry = "Create Table Products_Sales(Sales_billno number(6) primary key, Sales_Date Date not null, Wholeseller_id number(3) references Wholesellers_Master, Product_id number(3) references Products_Master, Sales_Qty number(3) not null,  Sales_rate number(4) not null, GST_in_per number(5,2), Add_Amount number(8,2), Add_info varchar2(25))";
            st.executeUpdate(qry);
            System.out.println("Table Product_Sales is created Successfully.");
            qry = "Create Table Products_Distribution(Distribution_billno number(6) primary key, Distribution_Date Date not null, Distributor_id number(3) references Distributors_Master, Product_id number(3) references Products_Master, Distribution_Qty number(3) not null,  Distribution_rate number(4) not null, GST_in_per number(5,2), Add_Amount number(8,2), Add_info varchar2(25))";
            st.executeUpdate(qry);
            System.out.println("Table Product_Distribution is created Successfully.");
            qry = "Create Table Products_Stock(Product_id number(3) references Products_Master, Current_Stock number(6) not null)";
            st.executeUpdate(qry);
            System.out.println("Table Products_Stock is created Successfully.");
            qry = "Create Table Distributors_Bal_Pay(Distributor_id number(3) references Distributors_Master, Balance_Amount number(7) not null)";
            st.executeUpdate(qry);
            System.out.println("Table Distributors_Bal_Pay is created Successfully.");
            con.close();
            qry = "Create Table Distributors_Payment(Dist_Pay_Recno number(6) primary key, Dist_Pay_Recdate Date not null, Distributor_id number(3) references Distributors_Master, Rec_Amount number(7) not null, Dist_Pay_Mode_Info varchar2(20))";
            st.executeUpdate(qry);
            System.out.println("Table Distributors_Payment is created Successfully.");
            
            qry = "Create Table Wholesellers_Payment(Whol_Pay_Recno number(6) primary key, Whol_Pay_Recdate Date not null, Wholeseller_id number(3) references Wholesellers_Master, Rec_Amount number(7) not null, Whol_Pay_Mode_Info varchar2(20))";
            st.executeUpdate(qry);
            */
            System.out.println("Table Wholesellers_Payment is created Successfully.");
        }                       
        catch(SQLException e){
            System.out.println("Problem during creating the Table.");
        }
    }
}