
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Start extends JFrame implements ActionListener{
    Start(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80,30,1200,60);
        heading.setFont(new Font("serif",Font.PLAIN,58));
        heading.setForeground(Color.cyan);
        add(heading);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/7.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);
 
        JButton click=new JButton("CLICK HERE TO CONTINUE");
        click.setBounds(460, 330, 250, 70);
        click.addActionListener(this);
        add(click);
 
        setSize(1170,650);
        setLocation(90,50);
        setVisible(true);

        while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){

            }
            heading.setVisible(true);
            try{
              Thread.sleep(1000);
            }catch(Exception e){
 
            }
        }
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args){
        new Start();
    }
}


