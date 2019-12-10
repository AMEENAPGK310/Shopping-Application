package shopping;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Agent
{
	Connectionshop con=new Connectionshop();
	public void display() throws ClassNotFoundException, SQLException 
	{
		Scanner s=new Scanner(System.in);
		int m,t = 1,u=0,q2=0,id2=0;
		System.out.println("enter the username");
		String user1=s.next();
		System.out.println("enter the password");
		String pwd1=s.next();
		Statement st=con.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select * from agent_login");
		while(rs.next())
		{
			if(rs.getString(1).equals(user1)&&rs.getString(2).equals(pwd1))
			{
				System.out.println("Successfully verified");
				do
				{
				System.out.println("1)BuySell\n2)View product\n3)Logout");
				System.out.println("enter the choice");
				m=s.nextInt();
				switch(m)
				{
				case 1:
				    System.out.println("enter the id");
					id2=s.nextInt();
					System.out.println("enter the quantity");
					q2=s.nextInt();
					Statement str=con.getConnection().createStatement();
					ResultSet rstr=str.executeQuery("select Price from add_product where Product_id="+id2);
					while(rstr.next())
					    t=q2*rstr.getInt(1);
					System.out.println("cost:"+t);
					System.out.println("enter 1 to confirm booking");
					int jk=s.nextInt();
					System.out.println("Your booking is confirmed\nThank you....!");
			   break;
				case 2:
					System.out.println("##########List of id's#########");
					Statement st1=con.getConnection().createStatement();
					ResultSet rst=st1.executeQuery("select * from add_product");
					while(rst.next())
					{
						u=rst.getInt(3)-q2;
						
						System.out.println("Product id:"+rst.getInt(1)+"\n"+"Product name:"+rst.getString(2)+"\n"+"Quantity:"+u+"\n"+"Price:"+rst.getInt(4)+"\n");
					}
					//System.out.println(u);
									
				break;
				case 3:
					System.out.println("Process will be complete");
					Mainclass ma=new Mainclass();
					ma.show();

				break;
				}
				
				}while(m!=0);
				
				
            }
			else
				System.out.println("invalid");
					}
	}
}