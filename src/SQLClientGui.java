/*
 * Paul Gatterdam
 * CNT 4714 - Assignment #3
 * Database GUI
 * March 4th, 2011
 */

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * Created by JFormDesigner on Fri Feb 25 17:41:44 EST 2011
 */

/**
 * @author User #10
 */
public class SQLClientGui
{
	public SQLClientGui()
	{
		initComponents();
		this.SQLClientGuiFrame.setVisible(true);
	}
	
	/**
	 * Adds an edited item to the JDBCDriverComboBox
	 */
	private void JDBCDriverComboBoxActionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("comboBoxEdited"))
		{
			this.JDBCDriverComboBox.addItem(this.JDBCDriverComboBox.getSelectedItem());
		}
	}
	
	/**
	 * Adds an edited item to the DatabaseURLComboBox
	 */
	private void DatabaseURLComboBoxActionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("comboBoxEdited"))
		{
			this.DatabaseURLComboBox.addItem(this.DatabaseURLComboBox.getSelectedItem());
		}
	}
	
	/**
	 * Connect to database with button press.
	 */
	private void ConnectButtonActionPerformed(ActionEvent e)
	{

		// TODO add your code here
		if (DBConnect.initDB())
			this.ConnectionStatusLabel.setText("Connection established");
		else
			this.ConnectionStatusLabel.setText("Error connecting to database");
	}
	
	/**
	 * Execute the SQL command in the text area.
	 */
	private void ExecuteSQLCommandButtonActionPerformed(ActionEvent e)
	{

		// TODO add your code here
		try
		{
			String[] queryWords = this.SQLCommandTextArea.getText().split(" ");
			String firstWord = queryWords[0];
			
			if (firstWord.equalsIgnoreCase("SELECT"))
			{
				DBConnect.sqlCmd(2);
			}
			else
			{
				DBConnect.sqlCmd(1);
			}
		}
		catch (NullPointerException npe)
		{
			System.out.println("null command");
		}
	}
	
	/**
	 * Clear the SQL Command in the text area.
	 */
	private void ClearCommandButtonActionPerformed(ActionEvent e)
	{

		// TODO add your code here
		this.SQLCommandTextArea.setText("");
	}
	
	/**
	 * Clear the results table.
	 */
	private void ClearResultsButtonActionPerformed(ActionEvent e)
	{

		// TODO add your code here
		DefaultTableModel model = (DefaultTableModel) this.SQLExecutionResultTable.getModel();
		model.setDataVector(new Vector(), new Vector());
		model.fireTableStructureChanged();
	}
	
	/**
	 * Auto Generated code for GUI construction using JFormDesigner.
	 */
	private void initComponents()
	{

		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		SQLClientGuiFrame = new JFrame();
		EnterDatabaseInformationLabel = new JLabel();
		JDBCDriverLabel = new JLabel();
		DatabaseURLLabel = new JLabel();
		UsernameLabel = new JLabel();
		PasswordLabel = new JLabel();
		JDBCDriverComboBox = new JComboBox();
		DatabaseURLComboBox = new JComboBox();
		UsernameTextField = new JTextField();
		PasswordTextField = new JTextField();
		EnterSQLCommandLabel = new JLabel();
		scrollPane1 = new JScrollPane();
		SQLCommandTextArea = new JTextArea();
		ConnectionStatusLabel = new JLabel();
		ConnectButton = new JButton();
		ExecuteSQLCommandButton = new JButton();
		ClearCommandButton = new JButton();
		separator1 = new JSeparator();
		SQLExecutionResultLabel = new JLabel();
		ClearResultsButton = new JButton();
		scrollPane2 = new JScrollPane();
		SQLExecutionResultTable = new JTable();
		
		// ======== SQLClientGuiFrame ========
		{
			SQLClientGuiFrame.setTitle("SQL Client GUI");
			Container SQLClientGuiFrameContentPane = SQLClientGuiFrame.getContentPane();
			SQLClientGuiFrameContentPane.setLayout(null);
			SQLClientGuiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			SQLClientGuiFrame.setSize(750, 445);
			
			// ---- EnterDatabaseInformationLabel ----
			EnterDatabaseInformationLabel.setText("Enter Database Information");
			SQLClientGuiFrameContentPane.add(EnterDatabaseInformationLabel);
			EnterDatabaseInformationLabel.setBounds(new Rectangle(new Point(10, 5), EnterDatabaseInformationLabel.getPreferredSize()));
			
			// ---- JDBCDriverLabel ----
			JDBCDriverLabel.setText("JDBC Driver");
			SQLClientGuiFrameContentPane.add(JDBCDriverLabel);
			JDBCDriverLabel.setBounds(new Rectangle(new Point(10, 27), JDBCDriverLabel.getPreferredSize()));
			
			// ---- DatabaseURLLabel ----
			DatabaseURLLabel.setText("Database URL");
			SQLClientGuiFrameContentPane.add(DatabaseURLLabel);
			DatabaseURLLabel.setBounds(new Rectangle(new Point(10, 55), DatabaseURLLabel.getPreferredSize()));
			
			// ---- UsernameLabel ----
			UsernameLabel.setText("Username");
			SQLClientGuiFrameContentPane.add(UsernameLabel);
			UsernameLabel.setBounds(new Rectangle(new Point(10, 82), UsernameLabel.getPreferredSize()));
			
			// ---- PasswordLabel ----
			PasswordLabel.setText("Password");
			SQLClientGuiFrameContentPane.add(PasswordLabel);
			PasswordLabel.setBounds(new Rectangle(new Point(10, 107), PasswordLabel.getPreferredSize()));
			
			// ---- JDBCDriverComboBox ----
			JDBCDriverComboBox.setModel(new DefaultComboBoxModel(new String[]
			{ "com.mysql.jdbc.Driver" }));
			JDBCDriverComboBox.setMaximumRowCount(10);
			SQLClientGuiFrameContentPane.add(JDBCDriverComboBox);
			JDBCDriverComboBox.setBounds(95, 25, 285, 21);
			JDBCDriverComboBox.setEditable(true);
			JDBCDriverComboBox.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					JDBCDriverComboBoxActionPerformed(e);
				}
			});
			
			// ---- DatabaseURLComboBox ----
			DatabaseURLComboBox.setModel(new DefaultComboBoxModel(new String[]
			{ "jdbc:mysql://localhost/project3" }));
			DatabaseURLComboBox.setMaximumRowCount(10);
			SQLClientGuiFrameContentPane.add(DatabaseURLComboBox);
			DatabaseURLComboBox.setBounds(95, 53, 285, 20);
			DatabaseURLComboBox.setEditable(true);
			DatabaseURLComboBox.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					DatabaseURLComboBoxActionPerformed(e);
				}
			});
			
			// ---- UsernameTextField ----
			SQLClientGuiFrameContentPane.add(UsernameTextField);
			UsernameTextField.setBounds(95, 80, 285, UsernameTextField.getPreferredSize().height);
			
			// ---- PasswordTextField ----
			SQLClientGuiFrameContentPane.add(PasswordTextField);
			PasswordTextField.setBounds(95, 105, 285, PasswordTextField.getPreferredSize().height);
			
			// ---- EnterSQLCommandLabel ----
			EnterSQLCommandLabel.setText("Enter a SQL Command");
			SQLClientGuiFrameContentPane.add(EnterSQLCommandLabel);
			EnterSQLCommandLabel.setBounds(new Rectangle(new Point(410, 5), EnterSQLCommandLabel.getPreferredSize()));
			
			// ======== scrollPane1 ========
			{
				scrollPane1.setViewportView(SQLCommandTextArea);
			}
			SQLClientGuiFrameContentPane.add(scrollPane1);
			scrollPane1.setBounds(410, 25, 315, 100);
			
			// ---- ConnectionStatusLabel ----
			ConnectionStatusLabel.setText("No Connection Now");
			SQLClientGuiFrameContentPane.add(ConnectionStatusLabel);
			ConnectionStatusLabel.setBounds(new Rectangle(new Point(10, 145), new Dimension(200, ConnectionStatusLabel.getPreferredSize().height)));
			
			// ---- ConnectButton ----
			ConnectButton.setText("Connect");
			ConnectButton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{

					ConnectButtonActionPerformed(e);
				}
			});
			SQLClientGuiFrameContentPane.add(ConnectButton);
			ConnectButton.setBounds(new Rectangle(new Point(300, 140), ConnectButton.getPreferredSize()));
			
			// ---- ExecuteSQLCommandButton ----
			ExecuteSQLCommandButton.setText("Execute SQL Command");
			ExecuteSQLCommandButton.setSelectedIcon(null);
			ExecuteSQLCommandButton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{

					ExecuteSQLCommandButtonActionPerformed(e);
				}
			});
			SQLClientGuiFrameContentPane.add(ExecuteSQLCommandButton);
			ExecuteSQLCommandButton.setBounds(new Rectangle(new Point(410, 140), ExecuteSQLCommandButton.getPreferredSize()));
			
			// ---- ClearCommandButton ----
			ClearCommandButton.setText("Clear Command");
			ClearCommandButton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{

					ClearCommandButtonActionPerformed(e);
				}
			});
			SQLClientGuiFrameContentPane.add(ClearCommandButton);
			ClearCommandButton.setBounds(new Rectangle(new Point(600, 140), ClearCommandButton.getPreferredSize()));
			SQLClientGuiFrameContentPane.add(separator1);
			separator1.setBounds(10, 175, 715, 5);
			
			// ---- SQLExecutionResultLabel ----
			SQLExecutionResultLabel.setText("SQL Execution Result");
			SQLClientGuiFrameContentPane.add(SQLExecutionResultLabel);
			SQLExecutionResultLabel.setBounds(new Rectangle(new Point(10, 190), SQLExecutionResultLabel.getPreferredSize()));
			
			// ---- ClearResultsButton ----
			ClearResultsButton.setText("Clear Results");
			ClearResultsButton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{

					ClearResultsButtonActionPerformed(e);
				}
			});
			SQLClientGuiFrameContentPane.add(ClearResultsButton);
			ClearResultsButton.setBounds(new Rectangle(new Point(615, 185), ClearResultsButton.getPreferredSize()));
			
			// ======== scrollPane2 ========
			{
				scrollPane2.setViewportView(SQLExecutionResultTable);
			}
			SQLClientGuiFrameContentPane.add(scrollPane2);
			scrollPane2.setBounds(10, 220, 715, 180);
			
			{ // compute preferred size
				Dimension preferredSize = new Dimension();
				for (int i = 0; i < SQLClientGuiFrameContentPane.getComponentCount(); i++)
				{
					Rectangle bounds = SQLClientGuiFrameContentPane.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = SQLClientGuiFrameContentPane.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				SQLClientGuiFrameContentPane.setMinimumSize(preferredSize);
				SQLClientGuiFrameContentPane.setPreferredSize(preferredSize);
			}
			// SQLClientGuiFrame.pack();
			SQLClientGuiFrame.setLocationRelativeTo(SQLClientGuiFrame.getOwner());
		}
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}
	
	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	public JFrame SQLClientGuiFrame;
	public JLabel EnterDatabaseInformationLabel;
	public JLabel JDBCDriverLabel;
	public JLabel DatabaseURLLabel;
	public JLabel UsernameLabel;
	public JLabel PasswordLabel;
	public JComboBox JDBCDriverComboBox;
	public JComboBox DatabaseURLComboBox;
	public JTextField UsernameTextField;
	public JTextField PasswordTextField;
	public JLabel EnterSQLCommandLabel;
	public JScrollPane scrollPane1;
	public JTextArea SQLCommandTextArea;
	public JLabel ConnectionStatusLabel;
	public JButton ConnectButton;
	public JButton ExecuteSQLCommandButton;
	public JButton ClearCommandButton;
	public JSeparator separator1;
	public JLabel SQLExecutionResultLabel;
	public JButton ClearResultsButton;
	public JScrollPane scrollPane2;
	public JTable SQLExecutionResultTable;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
