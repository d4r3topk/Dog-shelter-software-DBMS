package dbmsdatabase;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;


public class DatabaseLatest { 

private Table table; 
private String forName="com.mysql.jdbc.Driver";
private String URL="jdbc:mysql://localhost:3306/";
private String Username="root";
private String password="";


private static Connection connect; 
private static Statement statement; 
private static ResultSet resultSet; 
private Text text;
private Text text_1;
private Text text_2;

static Statement st;
static OpenDemo1 o;
public static void main(String[] args){

	try { 
		DatabaseLatest window = new DatabaseLatest(); 
		window.open(); 
		} catch (Exception e) { 
		e.printStackTrace(); 
		}
}
	
		public void open() throws SQLException { 
			Display display = Display.getDefault(); 
			final Shell shell = new Shell(display);  
			shell.setSize(498, 452);
			shell.setText("SWT Application"); 
			
			Button btnNewButton = new Button(shell, SWT.NONE);
			btnNewButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
				}
			});
			btnNewButton.setBounds(30, 21, 75, 25);
			btnNewButton.setText("Select");
			
			Button btnNewButton_1 = new Button(shell, SWT.NONE);
			btnNewButton_1.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
				}
			});
			btnNewButton_1.setBounds(227, 21, 75, 25);
			btnNewButton_1.setText("From");
			
			Button btnNewButton_2 = new Button(shell, SWT.NONE);
			btnNewButton_2.setBounds(95, 80, 75, 25);
			btnNewButton_2.setText("Where");
			
			text = new Text(shell, SWT.BORDER);
			text.setBounds(136, 21, 76, 21);
			
			text_1 = new Text(shell, SWT.BORDER);
			text_1.setBounds(318, 23, 76, 21);
			
			text_2 = new Text(shell, SWT.BORDER);
			text_2.setBounds(193, 82, 76, 21);
			
			Button btnPressMe = new Button(shell, SWT.NONE);
			btnPressMe.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					shell.dispose();
					o=new OpenDemo1();
					
				}
			});
			btnPressMe.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					o=new OpenDemo1();
				}
			});
			btnPressMe.setBounds(328, 164, 75, 25);
			btnPressMe.setText("Go");
			
			
			 shell.open();
			 shell.layout(); 
				while (!shell.isDisposed()) { 
				if (!display.readAndDispatch()) { 
				display.sleep(); 
				} 
				} 
				
				 
			
/*			try{
				Class.forName(forName); 
				connect = DriverManager.getConnection( 
						URL,Username,password); 
				System.out.println("Connecting succesfully");
				st=connect.createStatement();
				}catch (Exception e) { 
					System.out.println("Cannot connect to database server"); 
					} 
			
			ResultSet rs=st.executeQuery("SELECT * from animalshelter");
			while(rs.next())
				System.out.println(rs.getString("a_id"));
			
			
*/			
		
		}
}