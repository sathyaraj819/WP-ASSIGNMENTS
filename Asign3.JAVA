importjavax.swing.*;
importjava.awt.*;
importjava.awt.event.*;
importjava.sql.*;
importjava.awt.print.*;
publicclassFormextendsJFrameimplements ActionListener{

JLabell1, l2, l3, l4, l5, l6, l7, l8;

	JTextFieldtf1, tf2, tf5, tf6, tf7;

	JButtonbtn1, btn2,btn3;

	JPasswordFieldp1, p2;

	    Form()

	     {

	setVisible(true);

	setSize(700, 700);

	setLayout(null);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	setTitle("Form in Java");

	l1 = newJLabel("FORM");

	l1.setForeground(Color.blue);

	l1.setFont(new Font("Serif", Font.BOLD, 20));

	l2 = newJLabel("NAME:");

	l3 = newJLabel("ADDRESS:");

	l4 = newJLabel("PASSWORD:");

	l5 = newJLabel("GENDER:");

	l6 = newJLabel("HOBBIES:");
	l7 = newJLabel("State:");

	l8 = newJLabel("Phone No:"); 

	tf1 = newJTextField();

	tf2 = newJTextField();

	p1 = newJPasswordField();

	p2 = newJPasswordField();

	tf5 = newJTextField();

	tf6 = newJTextField();

	tf7 = newJTextField();

	btn1 = newJButton("Submit");

	btn2 = newJButton("Clear");

	btn3=newJButton("print");

	btn1.addActionListener(this);

	btn2.addActionListener(this);

	btn3.addActionListener(this);

	l1.setBounds(100, 30, 400, 30);

	l2.setBounds(80, 70, 200, 30);

	l3.setBounds(80, 110, 200, 30);

	l4.setBounds(80, 150, 200, 30);

	l5.setBounds(80, 190, 200, 30);

	l6.setBounds(80, 230, 200, 30);

	l7.setBounds(80, 270, 200, 30);

	l8.setBounds(80, 310, 200, 30);

	tf1.setBounds(300, 70, 200, 30);

	tf2.setBounds(300, 110, 200, 30);

	p1.setBounds(300, 150, 200, 30);

	p2.setBounds(300, 190, 200, 30);

	tf5.setBounds(300, 230, 200, 30);

	tf6.setBounds(300, 270, 200, 30);

	tf7.setBounds(300, 310, 200, 30);

	btn1.setBounds(50, 350, 100, 30);

	btn2.setBounds(170, 350, 100, 30);

	btn3.setBounds(280, 350, 100, 30);

	        add(l1);

	        add(l2);

	        add(tf1);

	        add(l3);

	        add(tf2);

	        add(l4);

	        add(p1);

	        add(l5);

	        add(p2);

	        add(l6);

	        add(tf5);

	        add(l7);

	        add(tf6);

	        add(l8);

	        add(tf7);

	        add(btn1);

	        add(btn2);

	        add(btn3);

	    }

	publicvoidactionPerformed(ActionEvente) 

	     {



	if (e.getSource() == btn1)

	        {

	intx = 0;

	            String s1 = tf1.getText();

	            String s2 = tf2.getText();

	char[] s3 = p1.getPassword();

	char[] s4 = p2.getPassword(); 

	            String s8 = new String(s3);

	            String s9 = new String(s4);

	            String s5 = tf5.getText();

	            String s6 = tf6.getText();

	            String s7 = tf7.getText();

	if (s8.equals(s9))

	           {



	try

	               {

	Class.forName("oracle.jdbc.driver.OracleDriver");

	                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@mcndesktop07:1521:xe", "sandeep", "welcome");

	PreparedStatementps = con.prepareStatement("insert into reg values(?,?,?,?,?,?)");

	ps.setString(1, s1);

	ps.setString(2, s2);

	ps.setString(3, s8);

	ps.setString(4, s5);

	ps.setString(5, s6);

	ps.setString(6, s7);

	ResultSetrs = ps.executeQuery();

	x++;

	if (x> 0) 

	                    {



	JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");



	                    }



	                }

	catch (Exception ex) 

	                {



	System.out.println(ex);



	                }



	            }

	else

	           {



	JOptionPane.showMessageDialog(btn1, "Password Does Not Match");



	            } 



	        } 

	else

	       {



	tf1.setText("");

	tf2.setText("");

	p1.setText("");

	p2.setText("");

	tf5.setText("");

	tf6.setText("");

	tf7.setText("");



	        }

	PrinterJobjob = PrinterJob.getPrinterJob(); //Get the printer's job list

	



if (job.printDialog() == true) { //If we clicked OK in the print dialog



try {job.print();} catch (PrinterExceptionex){



//It did not work (PrinterException thrown), so add any error handling routines.



                }

	    } 

          }

	publicstaticvoid main(String[] args)  {

		new Form();

	}
}
