
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    JButton add,view,update,remove;
    Home(){
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/8.jpg"));
        Image i2=i1.getImage().getScaledInstance(1050, 500, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1050,500);
        add(image);
        
        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(350,0,500, 50);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(heading);
        
        add=new JButton("Add Employee");
        add.setBounds(155, 85, 120, 50);
        add.addActionListener(this);
        image.add(add);
        
        view=new JButton("View Employee");
        view.setBounds(382, 110, 120, 50);
        view.addActionListener(this);
        image.add(view);
        
        update=new JButton("Update Employee");
        update.setBounds(600, 75, 120, 45);
        update.addActionListener(this);
        image.add(update);
        
        remove=new JButton("Remove Employee");
        remove.setBounds(820, 80, 130, 50);
        remove.addActionListener(this);
        image.add(remove);
        
        setSize(1050,500);
        setLocation(250,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            setVisible(false);
            new AddEmp();
        }else if(ae.getSource()== view){
            setVisible(false);
            new ViewEmp();
        }else if(ae.getSource()== update){
            setVisible(false);
            new ViewEmp();
        }else{
            setVisible(false);
            new RemoveEmp();
        }
    }
    
    public static void main(String[] args){
        new Home();
    }
}



