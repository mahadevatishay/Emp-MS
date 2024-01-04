package employee.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmp extends JFrame implements ActionListener{
    
    
    JTextField tfeducation,tfname,tffname,tfaddress, tfphone,tfsalary, tfemail, tfdesignation;
    JLabel lblempId,lbldob,lblaadhar;
    JButton add,back;
    String empId;
    
    UpdateEmp(String empId){
        this.empId=empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Employee Details");
        heading.setBounds(370,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,125,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        
        tfname=new JTextField();
        tfname.setBounds(200,125,150,30);
        add(tfname);
        
        JLabel labelfname=new JLabel("Father's Name");
        labelfname.setBounds(600,125,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
        
        tffname=new JTextField();
        tffname.setBounds(750,125,150,30);
        add(tffname);
        
        JLabel labeldob=new JLabel("Date of Birth");
        labeldob.setBounds(50,175,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);
        
        JLabel lbldob=new JLabel();
        lbldob.setBounds(200,175,150,30);
        add(lbldob);
        
        JLabel labelsalary=new JLabel("Salary");
        labelsalary.setBounds(600,175,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);
        
        tfsalary=new JTextField();
        tfsalary.setBounds(750,175,150,30);
        add(tfsalary);
        
        JLabel labeladdress=new JLabel("Address");
        labeladdress.setBounds(50,225,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,225,150,30);
        add(tfaddress);
        
        JLabel labelphone=new JLabel("Phone Number");
        labelphone.setBounds(600,225,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(750,225,150,30);
        add(tfphone);
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,275,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(200,275,150,30);
        add(tfemail);
        
        JLabel labeleducation=new JLabel("Highest Education");
        labeleducation.setBounds(600,275,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleducation);
        
        tfeducation=new JTextField();
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(750,275,150,30);
        add(tfeducation);
        
        JLabel labelaadhar=new JLabel("Aadhar Number");
        labelaadhar.setBounds(50,325,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labelaadhar);
        
        JLabel lblaadhar=new JLabel();
        lblaadhar.setBounds(200,325,150,30);
        add(lblaadhar);
        
        JLabel labeldesignation=new JLabel("Designation");
        labeldesignation.setBounds(600,325,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);
        
        tfdesignation=new JTextField();
        tfdesignation.setBounds(750,325,150,30);
        add(tfdesignation);
        
        JLabel labelempId=new JLabel("Employee ID");
        labelempId.setBounds(50,375,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempId);
        
        lblempId=new JLabel();
        lblempId.setBounds(200,375,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);
        
        try{
           Conn c=new Conn();
           String query="select * from employee where empId='"+empId+"'";
           ResultSet rs=c.s.executeQuery(query);
           while(rs.next()){
               tfname.setText(rs.getString("name"));
               tffname.setText(rs.getString("fname"));
               lbldob.setText(rs.getString("dob"));
               tfaddress.setText(rs.getString("address"));
               tfsalary.setText(rs.getString("salary"));
               tfphone.setText(rs.getString("phone"));
               tfemail.setText(rs.getString("email"));
               tfeducation.setText(rs.getString("education"));
               lblaadhar.setText(rs.getString("aadhar"));
               tfdesignation.setText(rs.getString("designation"));
               lblempId.setText(rs.getString("empId"));
               
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        add=new JButton("Update Details");
        add.setBounds(320, 475, 120, 50);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(520, 475, 120, 50);
        back.addActionListener(this);
        add(back);
        
        setSize(1050,600);
        setLocation(250,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            String name=tfname.getText();
            String fname=tffname.getText();
            String salary=tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education=tfeducation.getText();
            String designation=tfdesignation.getText();
            
            try{
               Conn c=new Conn();
               String query="update employee set name='"+name+"',fname='"+fname+"',salary='"+salary+"',addres='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"'where empId='"+empId+"'";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Details updated successfully");
               setVisible(false);
               new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args){
        new UpdateEmp("");
    
    }
}