/*
 * Paul Gatterdam
 * CNT 4714 - Assignment #3
 * Database GUI
 * March 4th, 2011
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class DBConnect
{
	Statement stmt;
	static Connection con;
	static String url;
	static String username;
	static String password;
	static SQLClientGui client;
	
	public static void main(String[] args)
	{

		client = new SQLClientGui();
		System.out.println("Starting program now.");
		return;
	}
	
	/**
	 * Handles SQL commands. Type 1 = Update. Type 2 = Query
	 */
	public static boolean sqlCmd(int type)
	{
		boolean result = false;
		
		if(type == 1)
		{
			Statement stmt;
			try
			{
				stmt = con.createStatement();
				stmt.executeUpdate(client.SQLCommandTextArea.getText());
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				System.out.println("Update failed.");
				e.printStackTrace();
			}
		}
		else if(type == 2)
		{

			Statement stmt;
			try
			{
				stmt = con.createStatement();
				ResultSet resultSet = stmt.executeQuery(client.SQLCommandTextArea.getText());
				ResultSetMetaData md = resultSet.getMetaData();
				int columnCount = md.getColumnCount();
				
				Vector<String> columns = new Vector<String>(columnCount);
				
				// store column names
				for(int i = 1; i <= columnCount; i++)
					columns.add(md.getColumnName(i));
				
				Vector<Vector> data = new Vector<Vector>();
				
				// store row data
				while(resultSet.next())
				{
					Vector<String> row = new Vector<String>(columnCount);
					
					for(int i = 1; i <= columnCount; i++)
					{
						row.add(resultSet.getString(i));
					}
					data.add(row);
				}
				
				DefaultTableModel tableModel = (DefaultTableModel) client.SQLExecutionResultTable.getModel();
				tableModel.setDataVector(data, columns);
				client.SQLExecutionResultTable.setModel(tableModel);
				tableModel.fireTableStructureChanged();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				System.out.println("Query failed.");
				e.printStackTrace();
			}
		}
		
		return(result);
	}
	
	/**
	 * Initialize the database connection.
	 */
	public static boolean initDB()
	{

		try
		{
			Class.forName(client.JDBCDriverComboBox.getSelectedItem().toString());
			url = client.DatabaseURLComboBox.getSelectedItem().toString();
			username = client.UsernameTextField.getText();
			password = client.PasswordTextField.getText();
			con = DriverManager.getConnection(url, username, password);
			
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);
			return(true);
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return(false);
	}
}
