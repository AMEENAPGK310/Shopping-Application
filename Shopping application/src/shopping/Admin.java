package shopping;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin 
{ 
	
	Connectionshop con=new Connectionshop();
    public void add() throws ClassNotFoundException, SQLException
	{
		Scanner s=new Scanner(System.in);
		int n,pquantity;
		System.out.println("enter the user name");
		String user=s.next();
		System.out.println("enter the password");
		String pwd=s.next();
		Statement st=con.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select * from admin_login");
		while(rs.next())
		{
			if(rs.getString(1).equals(user)&&rs.getString(2).equals(pwd))
			{
				System.out.println("Successfully verified");
				do
				{
				System.out.println("1)Add product\n2)Display product\n3)Remove Product\n4)Update Product\n5)Logout");
				System.out.println("enter the choice");
				n=s.nextInt();
				
				switch(n)
				{
				case 1:
					System.out.println("enter the product id");
					int pid=s.nextInt();
					System.out.println("enter the product name");
					String pname=s.next();
					System.out.println("enter the minimum selled quantity");
					pquantity=s.nextInt();
					System.out.println("enter the price");
					int pprice=s.nextInt();
		            PreparedStatement ps=con.getConnection().prepareStatement("insert into add_product(Product_id,Product_name,Quantity,Price)values(?,?,?,?)");
		            ps.setInt(1,pid);
		            ps.setString(2,pname);
		            ps.setInt(3,pquantity);
		            ps.setInt(4,pprice);
		            ps.executeUpdate();
		            System.out.println("Product added successfully");
		         break;
				 case 2:
					 System.out.println("##########*********#########");
					Statement st1=con.getConnection().createStatement();
					ResultSet rst=st1.executeQuery("select * from add_product");
					while(rst.next())
					{
						System.out.println("Product id:"+rst.getInt(1)+"\n"+"Product name:"+rst.getString(2)+"\n"+"Quantity:"+rst.getInt(3)+"\n"+"Price:"+rst.getInt(4)+"\n");
					}
					System.out.println("##########*********#########");
		         break;
				 case 3:
					 System.out.println("##########List of id's#########");
					 Statement str=con.getConnection().createStatement();
						ResultSet rstr=str.executeQuery("select * from add_product");
						while(rstr.next())
						{
							System.out.println("Product id:"+rstr.getInt(1)+"\n"+"Product name:"+rstr.getString(2));
						}
					 System.out.println("enter the delete id");
					 int id=s.nextInt();
					 PreparedStatement pss=con.getConnection().prepareStatement("delete from add_product where Product_id=?");
					 pss.setInt(1,id);
					 pss.executeUpdate();
					 System.out.println("Product removed successfully");
				break;
				 case 4:
					 System.out.println("##########List of id's#########");
					   System.out.println("enter the id");
						int id1=s.nextInt();
						System.out.println("enter the added quantity");
						int q1=s.nextInt();
					    Statement str2=con.getConnection().createStatement();
						ResultSet rstr2=str2.executeQuery("select Quantity from add_product where Product_id="+id1);
						int p=0,total=0;
						while(rstr2.next())
						{
							int s1=rstr2.getInt(1);
							total=total+s1+q1;
						}
						   System.out.println(total);

						PreparedStatement pst1=con.getConnection().prepareStatement("update add_product set Quantity=? where Product_id=?");
					    pst1.setInt(1,total);
					    pst1.setInt(2,id1);
						pst1.executeUpdate();
					    System.out.println("product updated successfully");
				 break;
				 case 5:
						System.out.println("Admin account logout");
						Mainclass ma=new Mainclass();
						ma.show();
				break;
				}
				
			}while(n!=0);
				
		}
			else
				System.out.println("invalid");
			
		}
		
	}

}
