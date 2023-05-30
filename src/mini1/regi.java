package mini1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class regi extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JPasswordField p1,p2;
	JRadioButton r1,r2;
	JComboBox c1,c2;
	JButton b1,b2;
	public regi() {}
	public regi(String s)
	{
		super(s);
	}
	public void setComponents() {
		l1=new JLabel("REGISTRATION (FOR NEW USER)");
		l2=new JLabel("LOGIN (IF ALREADY A USER)");
		l3=new JLabel("ENTER USER NAME");
		l4=new JLabel("ENTER PASSWORD");
		l5=new JLabel("ENTER EMAIL");
		l6=new JLabel("ENTER PHONE NO.");
		l7=new JLabel("ADDRESS");
		l8=new JLabel("GENDER");
		l9=new JLabel("QUALIFICATION");
		l10=new JLabel("NATIONALITY");
		l11=new JLabel("USER NAME");
		l12=new JLabel("PASSWORD");
		l13=new JLabel("OR");
		t1=new JTextField();
		p1=new JPasswordField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		p1=new JPasswordField();
		p2=new JPasswordField();
		r1=new JRadioButton("MALE");
		r2=new JRadioButton("FEMALE");
		String[] arr1= {"-select-","BCA","BTECH","BBA","MCA","MTECH","MBA","OTHER"};
		c1=new JComboBox(arr1);
		String[] arr2= {"-select-","INDIA","NEPAL","BHUTAN","SHRI_LANKA","BANGLADESH","OTHER"};
		c2=new JComboBox(arr2);
		b1=new JButton("REGISTER");
		b2=new JButton("LOGIN");
		setLayout(null);
		l1.setBounds(50,50,300,20);
		l2.setBounds(500,50,200,20);
		l3.setBounds(50,90,150,20);
		l4.setBounds(50,120,150,20);
		l5.setBounds(50,150,150,20);
		l6.setBounds(50,180,150,20);
		l7.setBounds(50,210,150,20);
		l8.setBounds(50,240,150,20);
		l9.setBounds(50,270,150,20);
		l10.setBounds(50,300,150,20);
		l11.setBounds(500,90,100,20);
		l12.setBounds(500,120,100,20);
		l13.setBounds(420,50,20,20);
		t1.setBounds(210,90,200,20);
		p1.setBounds(210,120,200,20);
		t3.setBounds(210,150,200,20);
		t4.setBounds(210,180,200,20);
		t5.setBounds(210,210,200,20);
		t6.setBounds(610,90,150,20);
		p2.setBounds(610,120,150,20);
		r1.setBounds(210,240,80,20);
		r2.setBounds(300,240,100,20);
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);bg.add(r2);
		c1.setBounds(210,270,200,20);
		c2.setBounds(210,300,200,20);
		b1.setBounds(260,360,100,20);
		b2.setBounds(550,180,100,20);
		t1.setBackground(Color.lightGray);
		p1.setBackground(Color.lightGray);
		t3.setBackground(Color.lightGray);
		p2.setBackground(Color.lightGray);
		t4.setBackground(Color.lightGray);
		t5.setBackground(Color.lightGray);
		t6.setBackground(Color.lightGray);
		c1.setBackground(Color.lightGray);
		c2.setBackground(Color.lightGray);
		r1.setBackground(Color.lightGray);
		r2.setBackground(Color.lightGray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(l11);
		add(l12);
		add(l13);
		add(t1);
		add(p1);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(p2);
		add(r1);
		add(r2);
		add(c1);
		add(c2);
		add(b1);
		add(b2);
		getContentPane().setBackground(Color.pink);
		ImageIcon i=new ImageIcon("image/icon.jpg");
		setIconImage(i.getImage());
		
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
         String name,password,email,contact,address;
         String radio=null,quali,nation;
         name=t1.getText();
         password=p1.getText();
         email=t3.getText();
         contact=t4.getText();
         address=t5.getText();
         
	String url="jdbc:ucanaccess://C:/Users/IBM/Documents/UserTb.accdb";
	
	
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
			Connection con =DriverManager.getConnection(url);
			System.out.println("connection established");
			if(e.getSource()==b1) 
                        {
		
			PreparedStatement ps = con.prepareStatement("insert into userdb(u_name,u_password,u_email,u_contact,u_address,u_gender,u_qualification,u_nationality)values(?,?,?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,contact);
			ps.setString(5,address);
			if(r1.isSelected())
			{
				radio=r1.getText();
			}
			if(r2.isSelected())
			{
				radio=r2.getText();
			}
			ps.setString(6,radio);
			quali=c1.getSelectedItem().toString();
			ps.setString(7, quali);
			nation=c2.getSelectedItem().toString();
			ps.setString(8, nation);
			ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"you are registered");
			t1.setText("");
			p1.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			r1.setSelected(false);
            r2.setSelected(false);
            c1.setSelectedIndex(0);
            c2.setSelectedIndex(0);
	        t1.grabFocus();
             }
			
			 if(e.getSource()==b2)
	         {
				 String uname=t6.getText();
				 String upass=String.valueOf(p2.getPassword());
				 PreparedStatement pre=con.prepareStatement("select * from userdb where u_name=? and u_password=?");
				 pre.setString(1, uname);
				 pre.setString(2, upass);
				 ResultSet r=pre.executeQuery();
				 if(r.next())
				 {
	          login lo=new login("EDIT OR SAVE");
	          lo.setComponents();
	         }
				 else
				 {
					 JOptionPane.showMessageDialog(null,"incorrect id or password");
				 }
				 
	         }
			 con.close();
                        
		}
			
		catch(ClassNotFoundException e1)
		{
			System.out.println("driver not loaded");
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		 
	}

	public static void main(String[] args) {
		regi jf=new regi("FORM");
		jf.setSize(800,500);
	    jf.setVisible(true);
		jf.setComponents();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
class login extends JFrame implements ActionListener
{
 JLabel lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12;
	JTextField tf1,tf3,tf4,tf5,tf6;
	JPasswordField ps1,ps2;
	JRadioButton ra1,ra2;
	JComboBox co1,co2;
    JButton bu1,bu2;
    public login() {}
	public login(String s1)
	{
		super(s1);
	}
	public void setComponents() {
		lb2=new JLabel("ENTER REGISTERED EMAIL TO UPDATE YOUR RECORD");
        lb3=new JLabel("ENTER USER NAME");
		lb4=new JLabel("ENTER PASSWORD");
		lb5=new JLabel("ENTER EMAIL");
		lb6=new JLabel("ENTER PHONE NO.");
		lb7=new JLabel("ADDRESS");
		lb8=new JLabel("GENDER");
		lb9=new JLabel("QUALIFICATION");
		lb10=new JLabel("NATIONALITY");
		lb11=new JLabel("EMAIL");
		lb12=new JLabel("PASSWORD");
        tf1=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		tf6=new JTextField();
		ps1=new JPasswordField();
		ps2=new JPasswordField();
		ra1=new JRadioButton("MALE");
		ra2=new JRadioButton("FEMALE");
		String[] arra1= {"-select-","BCA","BTECH","MCA","MTECH","MBA","OTHER"};
		co1=new JComboBox(arra1);
		String[] arra2= {"-select-","INDIA","NEPAL","SHRI_LANKA","BHUTAN","BANGLADESH","OTHER"};
		co2=new JComboBox(arra2);
		bu1=new JButton("EDIT");
		bu2=new JButton("SAVE");
		setLayout(null);
		lb2.setBounds(50,45,700,50);
        lb3.setBounds(50,90,150,20);
		lb4.setBounds(50,120,150,20);
		lb5.setBounds(50,150,150,20);
		lb6.setBounds(50,180,150,20);
		lb7.setBounds(50,210,150,20);
		lb8.setBounds(50,240,150,20);
		lb9.setBounds(50,270,150,20);
		lb10.setBounds(50,300,150,20);
		lb11.setBounds(500,90,100,20);
		lb12.setBounds(500,120,100,20);
        tf1.setBounds(210,90,200,20);
		ps1.setBounds(210,120,200,20);
		tf3.setBounds(210,150,200,20);
		tf4.setBounds(210,180,200,20);
		tf5.setBounds(210,210,200,20);
		tf6.setBounds(610,90,150,20);
		ps2.setBounds(610,120,150,20);
        ra1.setBounds(210,240,80,20);
		ra2.setBounds(300,240,100,20);
		ButtonGroup bg=new ButtonGroup();
		bg.add(ra1);bg.add(ra2);
		co1.setBounds(210,270,200,20);
		co2.setBounds(210,300,200,20);
		bu1.setBounds(210,360,100,20);
		bu2.setBounds(500,360,100,20);
		tf1.setBackground(Color.lightGray);
		ps1.setBackground(Color.lightGray);
		tf3.setBackground(Color.lightGray);
		tf4.setBackground(Color.lightGray);
		tf5.setBackground(Color.lightGray);
		tf6.setBackground(Color.lightGray);
		ps2.setBackground(Color.lightGray);
		ps1.setBackground(Color.lightGray);
		co1.setBackground(Color.lightGray);
		co2.setBackground(Color.lightGray);
		ra1.setBackground(Color.lightGray);
		ra2.setBackground(Color.lightGray);
                bu1.addActionListener(this);
                bu2.addActionListener(this);
                add(lb2);
        add(lb3);
		add(lb4);
		add(lb5);
		add(lb6);
		add(lb7);
		add(lb8);
		add(lb9);
		add(lb10);
		add(lb11);
		add(lb12);
        add(tf1);
        add(ps1);
        add(ps2);
		add(tf3);
		add(tf4);
		add(tf5);
		add(tf6);
        add(ra1);
		add(ra2);
		add(co1);
		add(co2);
		add(bu1);
		add(bu2);
		getContentPane().setBackground(Color.pink);
		ImageIcon i=new ImageIcon("image/icon.jpg");
		setIconImage(i.getImage());
        setVisible(true);
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}

	public void actionPerformed(ActionEvent e2)
	{
		try
		{
         String name,password,email,contact,address;
         String radio=null,quali,nation;
         name=tf1.getText();
         password=ps1.getText();
         email=tf3.getText();
         contact=tf4.getText();
         address=tf5.getText();
         
	String url="jdbc:ucanaccess://C:/Users/IBM/Documents/UserTb.accdb";
	
	
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
			Connection con =DriverManager.getConnection(url);
			System.out.println("connection established");
			if(e2.getSource()==bu1) 
                        {
		
			PreparedStatement ps = con.prepareStatement("update userdb set u_name=?,u_password=?,u_contact=?,u_address=?,u_gender=?,u_qualification=?,u_nationality=? where u_email=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,contact);
			ps.setString(4,address);
			if(ra1.isSelected())
			
			{
				radio=ra1.getText();
			}
			if(ra2.isSelected())
			{
				radio=ra2.getText();
			}
			ps.setString(5,radio);
			quali=co1.getSelectedItem().toString();
			ps.setString(6, quali);
			nation=co2.getSelectedItem().toString();
			ps.setString(7, nation);
			ps.setString(8,email);
			ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"records updated & registered");
			tf1.setText("");
			ps1.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			ra1.setSelected(false);
            ra2.setSelected(false);
            co1.setSelectedIndex(0);
            co2.setSelectedIndex(0);
	        tf1.grabFocus();
             }

				 if(e2.getSource()==bu2)
		         {
					 String uemail=tf6.getText();
					 String upass=String.valueOf(ps2.getPassword());
					 PreparedStatement pre=con.prepareStatement("select * from userdb where u_email=? and u_password=?");
					 pre.setString(1, uemail);
					 pre.setString(2, upass);
					 ResultSet r=pre.executeQuery();
					 if(r.next())
					 {
		          profile pr=new profile("PROFILE");
		          pr.setComponents1(r);
		         }
					 else
					 {
						 JOptionPane.showMessageDialog(null,"incorrect id or password");
					 }
					 
		         }
				 con.close();	
			
				
			
		}
			
			catch(ClassNotFoundException e1)
			{
				System.out.println("driver not loaded");
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
}
class profile extends JFrame implements ActionListener 
{
 JLabel lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10;
	JTextField tf1,tf3,tf4,tf5;
	JPasswordField ps1;
	JTextField ra1;
	JTextField co1,co2;
    JButton bu1;
    public profile() {}
	public profile(String s2)
	{
		super(s2);
	}
	public void setComponents1(ResultSet r) throws SQLException {
		ResultSet re=r;
        lb3=new JLabel("USER NAME");
		lb4=new JLabel("PASSWORD");
		lb5=new JLabel("EMAIL");
		lb6=new JLabel("PHONE NO.");
		lb7=new JLabel("ADDRESS");
		lb8=new JLabel("GENDER");
		lb9=new JLabel("QUALIFICATION");
		lb10=new JLabel("NATIONALITY");
        tf1=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		ps1=new JPasswordField();
		ra1=new JTextField();
		co1=new JTextField();
		co2=new JTextField();
		bu1=new JButton("NEXT");
		setLayout(null);
        lb3.setBounds(50,90,150,20);
		lb4.setBounds(50,120,150,20);
		lb5.setBounds(50,150,150,20);
		lb6.setBounds(50,180,150,20);
		lb7.setBounds(50,210,150,20);
		lb8.setBounds(50,240,150,20);
		lb9.setBounds(50,270,150,20);
		lb10.setBounds(50,300,150,20);
        tf1.setBounds(210,90,200,20);
		ps1.setBounds(210,120,200,20);
		tf3.setBounds(210,150,200,20);
		tf4.setBounds(210,180,200,20);
		tf5.setBounds(210,210,200,20);
        ra1.setBounds(210,240,200,20);
		co1.setBounds(210,270,200,20);
		co2.setBounds(210,300,200,20);
		bu1.setBounds(210,360,100,20);
		tf1.setBackground(Color.lightGray);
		ps1.setBackground(Color.lightGray);
		tf3.setBackground(Color.lightGray);
		tf4.setBackground(Color.lightGray);
		tf5.setBackground(Color.lightGray);
		ra1.setBackground(Color.lightGray);
		co1.setBackground(Color.lightGray);
		co2.setBackground(Color.lightGray);
        add(lb3);
		add(lb4);
		add(lb5);
		add(lb6);
		add(lb7);
		add(lb8);
		add(lb9);
		add(lb10);
        add(tf1);
        add(ps1);
		add(tf3);
		add(tf4);
		add(tf5);
        add(ra1);
		add(co1);
		add(co2);
		add(bu1);
		getContentPane().setBackground(Color.pink);
		ImageIcon i=new ImageIcon("image/icon.jpg");
		setIconImage(i.getImage());
		bu1.addActionListener(this);
        setVisible(true);
        setSize(600,500);
        String name,password,email,contact,address;
        String radio=null,quali,nation;
        name=tf1.getText();
        password=ps1.getText();
        email=tf3.getText();
        contact=tf4.getText();
        address=tf5.getText();
        
        tf1.setText(re.getString("u_name"));
		ps1.setText(re.getString("u_password"));
		tf3.setText(re.getString("u_email"));
		tf4.setText(re.getString("u_contact"));
		tf5.setText(re.getString("u_address"));
		ra1.setText(re.getString("u_gender"));
		co1.setText(re.getString("u_qualification"));
		co2.setText(re.getString("u_nationality"));
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
	public void actionPerformed(ActionEvent et)
	{
		feedback fe=new feedback("FEEDBACK FORM");
		fe.setComponents5();
	}
}
class feedback extends JFrame implements ActionListener 
{
	JLabel lab1,lab2,lab3;
	JTextField tex1,tex2,tex3;
	JButton jb1,jb2;
	JTextArea ta;
	JScrollPane js;
	 public feedback() {}
		public feedback(String s1)
		{
			super(s1);
		}
		public void setComponents5() {
			lab1=new JLabel("USER ID");
			lab2=new JLabel("MESSAGE");
			lab3=new JLabel("DATE");
			tex1=new JTextField();
			tex2=new JTextField();
			tex3=new JTextField();
			jb1=new JButton("SAVE");
			jb2=new JButton("VIEW FEEDBACK");
			ta=new JTextArea();
			setLayout(null);
			lab1.setBounds(50,60,150,20);
			lab2.setBounds(50,90,150,20);
			lab3.setBounds(50,120,150,20);
			tex1.setBounds(200,60,150,20);
			tex2.setBounds(200,90,150,20);
			tex3.setBounds(200,120,150,20);
			jb1.setBounds(200,200,150,20);
			jb2.setBounds(400,400,150,20);
			ta.setBounds(400,60,150,100);
			ta.setBackground(Color.lightGray);
			tex1.setBackground(Color.lightGray);
			tex2.setBackground(Color.lightGray);
			tex3.setBackground(Color.lightGray);
			JScrollPane js=new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			js.setBounds(400,60,150,100);
                        add(lab1);
                        add(lab2);
                        add(lab3);
                        add(tex1);
                        add(tex2);
                        add(tex3);
                        add(jb1);
                        add(jb2);
			            add(js);
                        jb1.addActionListener(this);
                        jb2.addActionListener(this);
			setSize(750,500);
			getContentPane().setBackground(Color.pink);
			ImageIcon i=new ImageIcon("image/icon.jpg");
			setIconImage(i.getImage());
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		public void actionPerformed(ActionEvent ev)
		{
			try
			{
				 int userid;
				 String message,date,fid;
		         userid=Integer.parseInt(tex1.getText());
		         message=tex2.getText();
		         date=tex3.getText();
				String url="jdbc:ucanaccess://C:/Users/IBM/Documents/UserTb.accdb";
				
				
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				
				Connection con =DriverManager.getConnection(url);
				System.out.println("connection established");
				if(ev.getSource()==jb1) 
	                        {
					PreparedStatement ps = con.prepareStatement("insert into feedback(u_id,f_message,f_datetime)values(?,?,?)");
					ps.setInt(1,userid);
					ps.setString(2,message);
					ps.setString(3,date);
					ps.executeUpdate();
		            JOptionPane.showMessageDialog(this,"THANK YOU FOR FEEDBACK");
					tex1.setText("");
					tex2.setText("");
					tex3.setText("");
					tex1.grabFocus();
					
	                        }
				if(ev.getSource()==jb2)
				{    
					 PreparedStatement pre=con.prepareStatement("select * from feedback where u_id=?");
					 int id=Integer.parseInt(tex1.getText());
					 pre.setInt(1, id);
					 ResultSet r=pre.executeQuery();
					 if(r.next()==false)
					 {
						  JOptionPane.showMessageDialog(this,"YOU HAVEN'T GIVEN ANY FEEDBACK YET");
						    tex1.setText("");
							tex2.setText("");
							tex3.setText("");
							tex1.grabFocus();
							
					 }
					 else
					 {
						 //ta.setText("FEEDBACK ID: "+r.getInt("f_id")+"\n");
						 ta.setText("feedback id : "+r.getInt("f_id")+"\n"+r.getString("f_message")+"\n"+"reviewed on: "+r.getString("f_datetime"));
					 }
				  	
				}
				
			}
			catch(ClassNotFoundException e)
			{
				System.out.println("driver not loaded");
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			}

}
