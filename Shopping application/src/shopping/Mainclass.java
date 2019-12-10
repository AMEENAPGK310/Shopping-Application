package shopping;

import java.sql.SQLException;
import java.util.Scanner;

public class Mainclass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Mainclass ma=new Mainclass();
		ma.show();
	}
     
    public void show() throws ClassNotFoundException, SQLException 
    {
		Scanner s=new Scanner(System.in);
		
		System.out.println("1)Admin Login\n2)Agent login\n3)Exit");
		System.out.println("enter the choice");
		int ch=s.nextInt();
		switch(ch)
		{
		case 1:
			Admin admin=new Admin();
			admin.add();
		break;
		case 2:
			Agent agent=new Agent();
			agent.display();
		case 3:
			System.exit(0);
		}
	}

}
