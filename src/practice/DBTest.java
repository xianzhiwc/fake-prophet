package practice;
import java.sql.*;
public class DBTest {
	







	public static void main(String args[]) throws SQLException {
	try {
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("�������سɹ�");
	} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcdemo", "root", "wc950310");


	System.out.println("���������ݿ�");




	}


	}

