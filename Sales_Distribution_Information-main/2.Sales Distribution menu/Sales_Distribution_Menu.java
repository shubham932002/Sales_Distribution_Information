import javax.swing.*;
import java.awt.event.*;
public class Sales_Distribution_Menu extends JFrame implements ActionListener{
    JMenuBar jmb;
    JMenu jmnu_Master, jmnu_DataEntry, jmnu_Reports;
    JMenuItem jmnu_Exit;
    JMenuItem jmaster1, jmaster2, jmaster3;
    JMenuItem jdata1, jdata2, jdata3, jdata4, jdata5;
    JMenuItem jreport2, jreport3;
    JMenu jreport1, jreport4, jreport5, jreport6, jreport7;
    JMenuItem jreport1_1, jreport1_2, jreport1_3,  jreport4_1, jreport4_2, jreport4_3, jreport5_1, jreport5_2, jreport5_3, jreport6_1, jreport6_2, jreport7_1, jreport7_2, jreport7_3;
    Sales_Distribution_Menu(){
        setSize(1550, 880);
        setVisible(true);
        setLayout(null);
        setTitle("Main Menu of the Project : Company Products Sales and Distribution System");
        jmb = new JMenuBar();
        jmnu_Master = new JMenu("Master Data Manipulation module");
        jmnu_DataEntry = new JMenu("Transactions(Data Entry) module"); 
        jmnu_Reports = new JMenu("Online Reports module"); 
        jmnu_Exit = new JMenuItem("Close the System");
        jmaster1 = new JMenuItem("Company Products master-data manipulation form");
        jmaster2 = new JMenuItem("Authorized Distributors master-data manipulation form");
        jmaster3 = new JMenuItem("Wholesellers master-data manipulation form");
        jmaster1.addActionListener(this);
        jmaster2.addActionListener(this);
        jmaster3.addActionListener(this);
        jdata1 = new JMenuItem("Manufactured Product's Inward Transaction");
        jdata2 = new JMenuItem("Company Products Sales Entry(to Wholesellers)");
        jdata3 = new JMenuItem("Wholeseller's Payment Received Transaction");
        jdata4 = new JMenuItem("Company Products Distribtuion Entry(to Distributor)");
        jdata5 = new JMenuItem("Distributor's Payment Received Transaction");
        jdata1.addActionListener(this);
        jdata2.addActionListener(this);
        jdata3.addActionListener(this);
        jdata4.addActionListener(this);
        jdata5.addActionListener(this);
        jreport1 = new JMenu("Information Reports Sub-Module");
        jreport2 = new JMenuItem("Manufactured Products Inward Report (periodical)");
        jreport2.addActionListener(this);
        jreport3 = new JMenuItem("Company Products Current Stock Report");
        jreport3.addActionListener(this);
        jreport4 = new JMenu("Sales Summary Reports Sub-Module");
        jreport5 = new JMenu("Distribution Summary Reports Sub-Module");
        jreport6 = new JMenu("Wholesellers Payments Information Reports");
        jreport7 = new JMenu("Distributors Payments Information Reports Sub-Module");
        jreport1_1 = new JMenuItem("Company Products Information Report");
        jreport1_2 = new JMenuItem("Authorized Distributors Information Report");
        jreport1_3 = new JMenuItem("Wholesellers Information Report");
        jreport1_1.addActionListener(this);
        jreport1_2.addActionListener(this);
        jreport1_3.addActionListener(this);
        jreport4_1 = new JMenuItem("Product Sales Transactions Report (periodical)");
        jreport4_2 = new JMenuItem("Wholeseller wise Sales Summary Report (Wholeseller's sales register)");
        jreport4_3 = new JMenuItem("Product wise Sales Summary Report (Product's sales register)");
        jreport4_1.addActionListener(this);
        jreport4_2.addActionListener(this);
        jreport4_3.addActionListener(this);
        jreport5_1 = new JMenuItem("Products Distribution Transactions Report (periodical)");
        jreport5_2 = new JMenuItem("Distributor wise Products Distribution Summary Report (Distributor's distribution register)");
        jreport5_3 = new JMenuItem("Product wise Distribution Summary Report (Product's distribution register)");
        jreport5_1.addActionListener(this);
        jreport5_2.addActionListener(this);
        jreport5_3.addActionListener(this);
        jreport6_1 = new JMenuItem("Wholesellers Payment Received Transaction Report (periodical)");
        jreport6_2 = new JMenuItem("Wholeseller wise Payment Summary Report (Wholesellers payment register)");
        jreport6_1.addActionListener(this);
        jreport6_2.addActionListener(this);
        jreport7_1 = new JMenuItem("Distributors Payment Received Transaction Report (periodical)");
        jreport7_2 = new JMenuItem("Distributor wise Payment Summary Report (Distributors paymen register)");
        jreport7_3 = new JMenuItem("Distributor wise outstanding Payments Report");
        jreport7_1.addActionListener(this);
        jreport7_2.addActionListener(this);
        jreport7_3.addActionListener(this);

        jmnu_Exit.addActionListener(this);

        jreport1.add(jreport1_1);
        jreport1.add(jreport1_2);
        jreport1.add(jreport1_3);
        jreport4.add(jreport4_1);
        jreport4.add(jreport4_2);
        jreport4.add(jreport4_3);
        jreport5.add(jreport5_1);
        jreport5.add(jreport5_2);
        jreport5.add(jreport5_3);
        jreport6.add(jreport6_1);
        jreport6.add(jreport6_2);
        jreport7.add(jreport7_1);
        jreport7.add(jreport7_2);
        jreport7.add(jreport7_3);
        jmnu_Master.add(jmaster1);
        jmnu_Master.add(jmaster2);
        jmnu_Master.add(jmaster3);
        jmnu_DataEntry.add(jdata1);
        jmnu_DataEntry.add(jdata2);
        jmnu_DataEntry.add(jdata3);
        jmnu_DataEntry.add(jdata4);
        jmnu_DataEntry.add(jdata5);
        jmnu_Reports.add(jreport1);
        jmnu_Reports.add(jreport2);
        jmnu_Reports.add(jreport3);
        jmnu_Reports.add(jreport4);
        jmnu_Reports.add(jreport5);
        jmnu_Reports.add(jreport6);
        jmnu_Reports.add(jreport7);
        jmb.add(jmnu_Master);
        jmb.add(jmnu_DataEntry);
        jmb.add(jmnu_Reports);
        jmb.add(jmnu_Exit);
        setJMenuBar(jmb);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == jmaster1)
            new Products_MasterForm();
        else if(ae.getSource() == jmaster2)
            new AuthorisedDistributor_MasterForm();
        else if(ae.getSource() == jmaster3)
            new Wholesellers_MasterForm();
        else if(ae.getSource() == jdata1)
            new Product_InwardDEF();
        else if(ae.getSource() == jdata2)
            new Product_SalesDEF();
        else if(ae.getSource() == jdata3)
            new Wholeseller_Payment_DEF();
        else if(ae.getSource() == jdata4)
            new Product_DistributionDEF();
        else if(ae.getSource() == jdata5)
            new Distributor_Payment_DEF();
        else if(ae.getSource() == jreport1_1)
            new Products_InfoReport();
        else if(ae.getSource() == jreport1_2)
            new Distributors_InfoReport();
        else if(ae.getSource() == jreport1_3)
            new Wholesellers_InfoReport();
        else if(ae.getSource() == jreport2)
            new Accept_Period("Inward_Report");
        else if(ae.getSource() == jreport3)
            new Products_Stock_Report();
        else if(ae.getSource() == jreport4_1)
            new Accept_Period("Sales_Report");
        else if(ae.getSource() == jreport4_2)
            new Accept_Wholeseller("Sales_Report");
        else if(ae.getSource() == jreport4_3)
            new Accept_Product("Sales_Report");
        else if(ae.getSource() == jreport5_1)
            new Accept_Period("Distribution_Report");
        else if(ae.getSource() == jreport5_2)
            new Accept_Distributor("Distribution_Report");
        else if(ae.getSource() == jreport5_3)
            new Accept_Product("Distribution_Report");
        else if(ae.getSource() == jreport6_1)
            new Accept_Period("WholePay_Report");
        else if(ae.getSource() == jreport6_2)
            new Accept_Wholeseller("WholePay_Report");
        else if(ae.getSource() == jreport7_1)
            new Accept_Period("DistPay_Report");
        else if(ae.getSource() == jreport7_2)
            new Accept_Distributor("DistPay_Report");
        else if(ae.getSource() == jreport7_3)
            new Dist_Outstanding_Report();
        else if(ae.getSource() == jmnu_Exit)
            dispose();
    }
    public static void main(String args[]){
        Sales_Distribution_Menu sdm = new Sales_Distribution_Menu();
        sdm.addWindowListener(
            new WindowAdapter()
            {
                public void windowClosing(WindowEvent we)
                {
                    System.exit(0);
                }
            }
        );
    }
}
