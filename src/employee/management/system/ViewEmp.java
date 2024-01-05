
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;


public class ViewEmp extends JFrame implements ActionListener{
    JTable table;
    Choice cemployeeid;
    JButton search,print,update,back;
    ViewEmp(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Employee ID");
        searchlbl.setBounds(20,20,170,20);
        add(searchlbl);
        
        cemployeeid=new Choice();
        cemployeeid.setBounds(200, 20, 150, 20);
        add(cemployeeid);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            while(rs.next()){
                cemployeeid.add(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table=new JTable();
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0, 100, 1040, 600);
        add(jsp);
        
        search=new JButton("Search");
        search.setBounds(20,70,100,20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(140,70,100,20);
        print.addActionListener(this);
        add(print);
        
        update=new JButton("Update");
        update.setBounds(260,70,100,20);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back");
        back.setBounds(380,70,100,20);
        back.addActionListener(this);
        add(back);
        
        setSize(1050,600);
        setLocation(250,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="select * from employee where empId='"+cemployeeid.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                //error line
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmp(cemployeeid.getSelectedItem());
        }else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args){
        new ViewEmp();
    }
}
