
package evisitoruser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Uwimana
 */
public class mainvisitors extends JFrame {
    public static DBCLASS dbOBJ;
    public static String dateDbFormat="[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}[ ]{1}[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}";
    public static mainvisitors Mainvisitors;
   public static  JButton visitor_check,equipment,
           security_officer_check,reports,system_users,statisitcs;
   public static user userCheckInMainInterface;
   public static system_user logedinUser=new system_user("", "", "", "", "", "");
   public static JLabel welcomeLabel;
   public static JPanel mainPanel;
    mainvisitors(){
    visitor_check=new JButton("VISITORS CHECK");
     equipment=new JButton("EQUIPMENTS");
      security_officer_check=new JButton("SECURITY OFFICER CHECK");
       reports=new JButton("REPORTS");
        system_users=new JButton("SYSTEM USERS"); 
         statisitcs=new JButton("STATISTICS");      
         welcomeLabel=new JLabel("WELCOME TO E-VISITORS SYSTEM"); 
        
         welcomeLabel.setBounds(50, 10, 900, 50);
         visitor_check.setBounds(40, 100, 300, 100);           equipment.setBounds(360, 100, 300, 100);
          security_officer_check.setBounds(40, 220, 300, 100); system_users.setBounds(360, 220, 300, 100);
         reports.setBounds(40, 340, 300, 100);                 statisitcs.setBounds(360, 340, 300, 100);

    JButton [] myButtons={visitor_check,equipment,
           security_officer_check,reports,system_users,statisitcs};
    for(int i=0;i<myButtons.length;i++){
    myButtons[i].setBackground(new Color(240,240,240));
    myButtons[i].setFont(new Font("Tahoma",Font.BOLD,18));
    }
       
        
         mainPanel=new JPanel();
         mainPanel.setLayout(null);
         mainPanel.add(visitor_check);
         mainPanel.add(equipment);
           mainPanel.add(security_officer_check);
           mainPanel.add(reports);
           mainPanel.add(system_users);
           mainPanel.add(statisitcs);
           mainPanel.add(welcomeLabel);
           mainPanel.setSize(1000, 700);
           mainPanel.setBackground(new Color(0,153,153));
    super.setSize(1000, 700);
    super.add(mainPanel);
    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
//======================================================================================================================
visitor_check.addActionListener((ActionEvent e) -> {
   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
mainvisitors.Mainvisitors.setVisible(false);

userCheckInMainInterface=new user();
  userCheckInMainInterface.setVisible(true);
});

system_users.addActionListener((ActionEvent e) -> {
   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

   if(mainvisitors.logedinUser.ACCESS.toUpperCase().contains("USERS_MANAGEMENT")){
    //JOptionPane.showMessageDialog(null,"You can go");
    }
    else{
         JOptionPane.showMessageDialog(null,"Permission denied!");
         return;
    }
   
   
      String choose = (String) JOptionPane.showInputDialog(null, "options", "", 
        JOptionPane.QUESTION_MESSAGE, null,
new String[]{"New","Update"}, 
              "New");    
  if(choose.equals("New")) {
   mainvisitors.Mainvisitors.setVisible(false);
   new users("New",null).setVisible(true);
  }
  else if(choose.equals("Update")) {  
      LinkedList<system_user> systemUsers=dbOBJ.getSystemUsers(); 
      //JOptionPane.showMessageDialog(null,String.valueOf(systemUsers.size()));
      String [] users_names=new String[systemUsers.size()];
      for(int i=0;i<users_names.length;i++){
      users_names[i]=systemUsers.get(i).NAMES+"<>"+systemUsers.get(i).USER_ID;
      }
         String chooseUserNmames = (String) JOptionPane.showInputDialog(null, "options", "", 
        JOptionPane.QUESTION_MESSAGE, null,users_names,null);
      
         String [] selectedUserId=chooseUserNmames.split("<>");
         int userIndex=getUserIdToUpdate(selectedUserId[1],systemUsers);
         if(userIndex!=-1){
            mainvisitors.Mainvisitors.setVisible(false);
   new users("Update",systemUsers.get(userIndex)).setVisible(true);//
         
         }
  }
});


reports.addActionListener((ActionEvent e) -> {
   
    if(mainvisitors.logedinUser.ACCESS.toUpperCase().contains("REPORTS")){
    JOptionPane.showMessageDialog(null,"You can go");
    }
    else{
         JOptionPane.showMessageDialog(null,"Permission denied!");
    }
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    });

equipment.addActionListener((ActionEvent e) -> {
   new equipment().showEquipmentInterface();
    
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    });


//=========================================================================================================================
    
    
    
    
    }
    
    public int getUserIdToUpdate(String use_Id,LinkedList<system_user> systemUsers){
    for(int i=0;i<systemUsers.size();i++){
    if(systemUsers.get(i).USER_ID.equals(use_Id)){
        return i;
    }
    }
     return -1;   
    }
    public static void main(String[] args){
        dbOBJ=new DBCLASS();
        String username= JOptionPane.showInputDialog("User ID","");
        String pswd= JOptionPane.showInputDialog("User ID","");
        System.out.println(username+"\n"+pswd);
        if(dbOBJ.userExist(username, pswd)){
              System.out.println("check!!");
           // JOptionPane.showMessageDialog(null, "great");
           
         Mainvisitors=new mainvisitors();
         Mainvisitors.setVisible(true);
           
        }
        else{
        JOptionPane.showMessageDialog(null, "Failed");
        }
        
       
        
    }
}
