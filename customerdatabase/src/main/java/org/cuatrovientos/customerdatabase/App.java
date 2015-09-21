package org.cuatrovientos.customerdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Simple class to use a customer table in a data base
 * @author Yeray García
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException{
    	Class.forName("org.sqlite.JDBC");
		Connection connection =
				DriverManager.getConnection("jdbc:sqlite:test.db");
		Statement statement = connection.createStatement();
		String delete = "drop table customer";
		statement.executeUpdate(delete);
		String sql = "create table customer (id integer, name varchar(30))";
		statement.executeUpdate(sql);
		String line = "";
        String option = "";
       
       Scanner reader = new Scanner(System.in);
		do {
			System.out.println("Please, select an option");
			System.out.println("1.Show all records");
			System.out.println("2.Insert a new record");
			System.out.println("3.Modify one record");
			System.out.println("4.Delete one record");
			System.out.println("5.Delete all records");
			System.out.println("6.Exit");
			option = reader.nextLine();
			switch (option) {
			case "1":
				String select = "select * from customer order by name desc";
				ResultSet resultSet = statement.executeQuery(select);
				
				while (resultSet.next()) {
					
					System.out.print("ID: " + resultSet.getInt("id"));
					System.out.println(" Name: " + resultSet.getString("name"));
				}
				break;
				
			
			
			case "2":
				String id = "";
				String name = "";
				System.out.println("Insert ID");
				id = reader.nextLine();
				System.out.println("Insert name");
				name = reader.nextLine();
				String insertSql = 
						"insert into customer values("+id+",'"+name+"')";
				statement.executeUpdate(insertSql);
				break;
				
			case "3":
				String idUpd = "";
				String newName = "";
				System.out.println("Insert customer ID");
				idUpd  = reader.nextLine();
				System.out.println("Insert new customer name");
				newName = reader.nextLine();
				String updateSql = "update customer set name='" + newName + "',id="+idUpd+ " where id=" + idUpd;
				statement.executeUpdate(updateSql);
				break;
				
			case "4":
				String idDel = "";
				System.out.println("Insert user ID");
				idDel = reader.nextLine();
				String deleteSql= "delete from customer where id=" + idDel;
				statement.executeUpdate(deleteSql);
				break;
			
			case "5":
				String deleteAll =("delete from customer");
				statement.executeUpdate(deleteAll);
				break;
				
			case "6":
				System.out.println("See you around");
				
			
			
		}
    	
    	
    	
    }while (!option.equals("6"));
    }
}
