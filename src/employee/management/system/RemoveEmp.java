
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmp extends JFrame implements ActionListener{
    Choice cEmpId;
    JButton delete,back;
    RemoveEmp(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempId=new JLabel("Employee ID");
        labelempId.setBounds(50,50,100,30);
        add(labelempId);
        
        cEmpId=new Choice();
        cEmpId.setBounds(200,50,150,30);
        add(cEmpId);
        
        try{
            Conn c=new Conn();
            String query="select * from employee";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                cEmpId.add(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JLabel labelphone=new JLabel("Phone Number");
        labelphone.setBounds(50,150,100,30);
        add(labelphone);
        
        JLabel lblphone=new JLabel();
        lblphone.setBounds(200,150,100,30);
        add(lblphone);
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        add(labelemail);
        
        JLabel lblemail=new JLabel();
        lblemail.setBounds(200,200,100,30);
        add(lblemail);
        
        JLabel labelaadhar=new JLabel("Aadhar Number");
        labelaadhar.setBounds(50,100,100,30);
        add(labelaadhar);
        
        JLabel lblaadhar=new JLabel();
        lblaadhar.setBounds(200,100,100,30);
        add(lblaadhar);
        
        try{
            Conn c=new Conn();
            String query="select * from employee where empId='"+cEmpId.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
               lblaadhar.setText(rs.getString("Aadhar Number"));
               lblphone.setText(rs.getString("Phone Number"));
               lblemail.setText(rs.getString("Email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c=new Conn();
                    String query="select * from employee where empId='"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(query);
                    while(rs.next()){
                       lblaadhar.setText(rs.getString("Aadhar Number"));
                       lblphone.setText(rs.getString("Phone Number"));
                       lblemail.setText(rs.getString("Email"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        delete=new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.addActionListener(this);
        add(delete);
        
        back=new JButton("Back");
        back.setBounds(220,300,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/4.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450,30,500,400);
        add(image);
        
        setSize(1050,500);
        setLocation(250,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                Conn c=new Conn();
                String query="delete from employee where empId ='"+cEmpId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Information Deleted!");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args){
        new RemoveEmp();
    }
}
