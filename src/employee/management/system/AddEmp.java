package employee.management.system;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class AddEmp extends JFrame implements ActionListener{
    
    Random r=new Random();
    int number=r.nextInt(99999);
    
    JTextField tfname,tffname,tfaddress, tfphone,tfsalary, tfaadhar, tfemail, tfdesignation;
    JComboBox cbeducation;
    JDateChooser dcdob;
    JLabel lblempId;
    JButton add,back;
    
    AddEmp(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Add Employee Details");
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
        
        dcdob=new JDateChooser();
        dcdob.setBounds(200,175,150,30);
        add(dcdob);
        
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
        
        String courses[]={"BTech","MTech","BBA","MBA","BCA","MCA","PHd","MPhil","BA","MA","BCom","BSc","MSc","12th","10th"};
        cbeducation=new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(750,275,150,30);
        add(cbeducation);
        
        JLabel labelaadhar=new JLabel("Aadhar Number");
        labelaadhar.setBounds(50,325,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labelaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(200,325,150,30);
        add(tfaadhar);
        
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
        
        lblempId=new JLabel(""+number);
        lblempId.setBounds(200,375,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);
        
        add=new JButton("Add Details");
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
            String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary=tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education=(String)cbeducation.getSelectedItem();
            String aadhar=tfaadhar.getText();
            String designation=tfdesignation.getText();
            String empId=lblempId.getText();
            
            try{
               Conn c=new Conn();
               String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+aadhar+"','"+designation+"','"+empId+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Details added successfully");
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
        new AddEmp();
    
    }
}
