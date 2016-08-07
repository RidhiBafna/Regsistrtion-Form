//package com.dhi;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Frame1 extends Frame implements ActionListener,WindowListener
{
  
    private static final long serialVersionUID = 1L;
    String msg="";

    Button btnNew,btnSubmit,btnView;
    Label lblName,lblAddr,lblGender,lblSub, lblid;
    TextField txtName, txtid;
     TextArea txtAddr,txtAns;
    CheckboxGroup ChkGrp;
    Checkbox chkMale,chkFemale;
    Checkbox chkCse,chkEce,chkCivil,chkMech, chkEe, chkit;

	private String name;
	private int id;
	private String age;
	private String addr;
	private ResultSet rs ;
    public Frame1(String name)
    {    
        super(name);
        setLayout(null);
        this.addWindowListener(this);
        
       lblid = new Label("ID:");
       txtid =new TextField(10);

        lblName = new Label("Name: ");
        txtName = new TextField(10);
        
        lblAddr = new Label("Address : ");
        txtAddr = new TextArea();

        lblGender = new Label("Gender: ");
         ChkGrp = new CheckboxGroup();
        chkMale = new Checkbox("Male",ChkGrp,false);
        chkFemale = new Checkbox("Female",ChkGrp,false); 

        lblSub = new Label("Subject: ");
         chkCse = new Checkbox("CSE");
        chkEce = new Checkbox("ECE");
        chkCivil = new Checkbox("CIVIL");
        chkMech = new Checkbox("ME");
        chkit = new Checkbox("IT");
        chkEe = new Checkbox("EE");

       // btnNew = new Button("NEW");
        btnSubmit = new Button("SUBMIT");
       // btnView = new Button("VIEW");
        
        lblid.setBounds(50,40,50,50);
        txtid.setBounds(150,50,150,25); 
         lblName.setBounds(50,80,50,50); 
        txtName .setBounds(150,90,150,25);
         lblAddr.setBounds(50,120,50,50); 
        txtAddr.setBounds(150,130,300,170); 
        lblGender .setBounds(50,320,50,50);
        chkMale.setBounds(150,325,60,40);
        chkFemale.setBounds(230,325,60,40); 
        lblSub.setBounds(50,380,80,50); 
         chkCse.setBounds(150,390,40,20);
        chkEce.setBounds(200,390,40,20);
        chkCivil.setBounds(250,390,40,20);
        chkMech.setBounds(300,390,40,20);
        chkit.setBounds(350,390,40,20);
        chkEe.setBounds(390,390,40,20);
        btnSubmit.setBounds(200,480,100,40);
       
        add(lblid); 
        add(txtid);
        
        add(lblName);
        add(txtName); 
        
        add(lblAddr);
        add(txtAddr);

        add(lblGender);
        add(chkMale);
        add(chkFemale);

        add(lblSub);
        add(chkCse);
        add(chkEce); 
        add(chkCivil);
        add(chkMech); 
        add(chkit);
        add(chkEe);
       // add(btnNew);
        add(btnSubmit);
        //add(btnView); 
        
    btnSubmit.addActionListener(this);
      }     
public void actionPerformed(ActionEvent a)
{ 
String lblGender="";
String lblSub="";
String lblName=(txtName.getText());
String lblAddr=(txtAddr.getText());
if(chkMale.getState()==true)
lblGender="male";
if(chkFemale.getState()==true)
lblGender="female";

if(chkCse.getState()==true)
lblSub="CSE";
if(chkEce.getState()==true)
lblSub="ECE";
if(chkCivil.getState()==true)
lblSub="CIVIL";
if(chkMech.getState()==true)
lblSub="MECH";
if(chkit.getState()==true)
lblSub="IT";
if(chkEe.getState()==true)
lblSub="EE";
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:stud","", "");
PreparedStatement stmt=con.prepareStatement("insert into student (sname,saddress,sgender,sbranch)values(?,?,?,?)");
stmt.setString(1,txtName.getText());
stmt.setString(2,txtAddr.getText());
stmt.setString(3,lblGender);
stmt.setString(4,lblSub);
int rs = stmt.executeUpdate();

con.close();
}
catch(Exception ex)
{
System.out.println("Error occured");
System.out.println("Error:"+ex);
}
 }



public void windowClosing(WindowEvent e) {
	
	System.exit(0);
}



public String getAge() {
	return age;
}

public void setAge(String age) {
	this.age = age;
}

public String getAddr() {
	return addr;
}

public void setAddr(String addr) {
	this.addr = addr;
}

public int getResult() {
	return getResult();
}

public void setResult(int result) {
	id = result;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public void windowActivated(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}

public void windowClosed(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}


public void windowDeactivated(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}

public void windowDeiconified(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}


public void windowIconified(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}


public void windowOpened(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
class frame
{
    public static void main(String args[])
    {
        try
        {
        Frame1 F = new Frame1("Registration Form");
        F.setSize(800,800);
        F.setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }    

}
