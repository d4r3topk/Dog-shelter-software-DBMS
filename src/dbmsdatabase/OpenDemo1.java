package dbmsdatabase;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class OpenDemo1 {

	private static Connection connect; 
	private static Statement statement; 
	private static ResultSet resultSet; 
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	
	private Table table; 
	private String forName="com.mysql.jdbc.Driver";
	private String URL="jdbc:mysql://localhost:3306/etihadairways";
	private String Username="root";
	private String password="localhost";
	private String QUERY;
	public OpenDemo1() { 
		
		Display display = Display.getDefault(); 
		Shell shell = new Shell(Display.getCurrent()); 
		shell.setLayout(new GridLayout(1, false)); 
		shell.setSize(450, 300); 
		shell.setText("DBMS PROJECT"); 
		{ 
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION 
		| SWT.VIRTUAL); 
		table.setLinesVisible(true); 
		table.setHeaderVisible(true); 
		table.setItemCount(1); 
		table.addListener(SWT.SetData, new Listener() { 
		public void handleEvent(org.eclipse.swt.widgets.Event event) { 
		table.setItemCount(0); 
		try { 
		Class.forName("com.mysql.jdbc.Driver"); 
		connect = (Connection) DriverManager.getConnection( 
		"jdbc:mysql://localhost:3306/etihadairways", "root", 
		"localhost"); 
		System.out.println("Connecting succesfully"); 
		statement = (Statement) connect.createStatement(); 
		resultSet = statement.executeQuery("SELECT * from "); 
		while (resultSet.next()) { 
		TableItem item = new TableItem(table, SWT.NONE); 
		item.setText(new String[] { resultSet.getString(1), 
		resultSet.getString(2), 
		resultSet.getString(3), 
		resultSet.getString(4), 
		resultSet.getString(5) }); 
		} 
		connect.close(); 
		} catch (Exception e) { 
		System.out.println("Cannot connect to database server"); 
		} 

		}

		

	
		}); 

		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 
		1)); 
		{ 
		TableColumn tblclmnNos = new TableColumn(table, SWT.NONE); 
		tblclmnNos.setWidth(100); 
		tblclmnNos.setText("REVE"); 
		} 
		{ 
		TableColumn tblclmnEno = new TableColumn(table, SWT.NONE); 
		tblclmnEno.setWidth(100); 
		tblclmnEno.setText("Admin Type"); 
		} 
		{ 
		TableColumn tblclmnEname = new TableColumn(table, SWT.NONE); 
		tblclmnEname.setWidth(100); 
		tblclmnEname.setText("Admin Name"); 
		} 
		{ 
		TableColumn tblclmnAge = new TableColumn(table, SWT.NONE); 
		tblclmnAge.setWidth(100); 
		tblclmnAge.setText("Login Name"); 
		} 
		{ 
		TableColumn tblclmnPosition = new TableColumn(table, SWT.NONE); 
		tblclmnPosition.setWidth(100); 
		tblclmnPosition.setText("Login Password"); 
		} 

		} 

		shell.open(); 
		shell.layout(); 
		while (!shell.isDisposed()) { 
		if (!display.readAndDispatch()) { 
		display.sleep(); 
		} 
		} 
		} 
}
