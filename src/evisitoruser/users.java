
package evisitoruser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
public class users extends JFrame {
    public static DBCLASS dbOBJ;
    public static users users;
      public static JPanel userpanel,photopanel;
   public static  JButton reset,submit,update,delete,back;
  public static JLabel usersheaderlabel,nameslabel,usernamelabel,passwordlabel,idnumberlabel,phonenumberlabel,accesslabel;
  public static JTextField namestext,usernametext,passwordtext,idnumbertext,phonenumbertext,phototext;
  public static JCheckBox visentry,branchcheck,userscheck,statisticcheck,equipcheck,visrepcheck,reportcheck;
   
  users(String type,system_user value){
      usersheaderlabel=new JLabel("E-VISITORS USERS");
     nameslabel=new JLabel("Names");
     usernamelabel=new JLabel("Username");
     passwordlabel=new JLabel("Password");
     idnumberlabel=new JLabel("Id Number");
     phonenumberlabel=new JLabel("Phonenumber");
     accesslabel=new JLabel("Access Levels");
     namestext=new JTextField("");
     usernametext=new JTextField("");
     passwordtext=new JTextField("");
     idnumbertext=new JTextField("");
     phonenumbertext=new JTextField("");
     phototext=new JTextField("");
     LinkedList<JCheckBox> checkBoxes=new LinkedList();
     visentry=new JCheckBox("Visitor_Entry_Data");
     checkBoxes.add(visentry);
     branchcheck=new JCheckBox("Branches_Management");
     checkBoxes.add(branchcheck);
     userscheck=new JCheckBox("Users_management");
     checkBoxes.add(userscheck);
     statisticcheck=new JCheckBox("Equipements");
     checkBoxes.add(statisticcheck);
     equipcheck=new JCheckBox("Statistics");
     checkBoxes.add(equipcheck);
     visrepcheck=new JCheckBox("Reports");
      checkBoxes.add(visrepcheck);
     reportcheck=new JCheckBox("Other_Reports");
      checkBoxes.add(reportcheck);
     reset=new JButton("RESET");
     submit=new JButton("SUBMIT");
     update=new JButton("UPDATE");
     delete=new JButton("DELETE");
     back=new JButton("Back home");
     
     usersheaderlabel.setBounds(200, 50, 350,50);
      usersheaderlabel.setForeground(new Color(255,255,255));
         usersheaderlabel.setFont(new Font("TimesRoman",Font.ITALIC,30));
         nameslabel.setBounds(30,39,100,200);
         namestext.setBounds(150,120,400,30);
         nameslabel.setFont(new Font("TimesRoman",Font.ITALIC,17));
          usernamelabel.setBounds(30,90,100,200);   
        usernametext.setBounds(150,170,400,30);
         usernamelabel.setFont(new Font("TimesRoman",Font.ITALIC,17)); 
          passwordlabel.setBounds(30,130,100,200);
          passwordtext.setBounds(150,220,400,30);
         passwordlabel.setFont(new Font("TimesRoman",Font.ITALIC,17));
          idnumberlabel.setBounds(30,180,100,200);
          idnumbertext.setBounds(150,270,400,30);
         idnumberlabel.setFont(new Font("TimesRoman",Font.ITALIC,17));
          phonenumberlabel.setBounds(30,230,150,200);
          phonenumbertext.setBounds(150,320,400,30);
         phonenumberlabel.setFont(new Font("TimesRoman",Font.ITALIC,17));
         
         
           accesslabel.setBounds(200,270,200,200);
          accesslabel.setFont(new Font("TimesRoman",Font.ITALIC,17));
     
         visentry.setBounds(100,400,200,20);
         accesslabel.setFont(new Font("TimesRoman",Font.ITALIC,17));
          branchcheck.setBounds(350,400,200,20);
          accesslabel.setFont(new Font("TimesRoman",Font.ITALIC,17));
           userscheck.setBounds(100,450,200,20);
           accesslabel.setFont(new Font("TimesRoman",Font.ITALIC,17));
            statisticcheck.setBounds(350,450,200,20);
            accesslabel.setFont(new Font("TimesRoman",Font.ITALIC,17));
             equipcheck.setBounds(100,500,200,20);
             accesslabel.setFont(new Font("TimesRoman",Font.ITALIC,17));
            visrepcheck.setBounds(350,500,200,20);
            accesslabel.setFont(new Font("TimesRoman",Font.ITALIC,17));
             reportcheck.setBounds(200,550,200,20);
             accesslabel.setFont(new Font("TimesRoman",Font.ITALIC,17));
         
             reset.setBounds(100,600,100,50);
             submit.setBounds(250,600,100,50);
             update.setBounds(100,670,100,50);
             delete.setBounds(250,670,100,50);
             back.setBounds(550,650,200,60);
               back.setFont(new Font("TimesRoman",Font.ITALIC,20));
             back.setBackground(new Color(255,200,240));
             
//==================================================================================================================================         
  
if(type.equals("Update")){
namestext.setText(value.NAMES);
usernametext.setText(value.USER_ID);
passwordtext.setText(value.USER_PSWD);
idnumbertext.setText(value.ID_NUMBER);
phonenumbertext.setText(value.TEL);
String [] accesses=value.ACCESS.split(" ");

for(int i=0;i<accesses.length;i++){
    for(int j=i;j<checkBoxes.size();j++){
     //   System.out.println(checkBoxes.get(j).getText()+"##"+accesses[i]);
if(checkBoxes.get(j).getText().contains(accesses[i])){
   // System.out.println(checkBoxes.get(j).getText()+"##"+accesses[i]);  
checkBoxes.get(j).setSelected(true);
 break;
}
    }
   // System.out.println("=====================================================================================================");
    
}

}
//=================================================================================================================================             
             
     userpanel=new JPanel();
     userpanel.add(usersheaderlabel);
     userpanel.add(nameslabel);
     userpanel.add(usernamelabel);
     userpanel.add(passwordlabel);
     userpanel.add(idnumberlabel);
     userpanel.add(phonenumberlabel);
     userpanel.add(accesslabel);
     userpanel.add(namestext);
     userpanel.add(usernametext);
     userpanel.add(passwordtext);
     userpanel.add(idnumbertext);
     userpanel.add(phonenumbertext);
     userpanel.add(phototext); 
     userpanel.add(visentry);
     userpanel.add(branchcheck);
     userpanel.add(userscheck);
     userpanel.add(statisticcheck);
     userpanel.add(visrepcheck);
     userpanel.add(reset);
     userpanel.add(submit);
     userpanel.add(update);
     userpanel.add(delete);
     userpanel.add(back);
     
     
     userpanel.setLayout(null);
     userpanel.setSize(1000,1000);
     userpanel.setBackground(new Color(200,200,240));
     super.setSize(800,800);
     super.add(userpanel);
     
     back.addActionListener((ActionEvent e) -> {
        
     mainvisitors.Mainvisitors.setVisible(true);
     });
     
     submit.addActionListener((ActionEvent e) -> {
      if(namestext.getText().equals("")||usernametext.getText().equals("")||
              passwordtext.getText().equals("")||idnumbertext.getText().equals("")||
              phonenumbertext.getText().equals(""))
      { JOptionPane.showMessageDialog(null, "All fields are required!"); return;}
         
         DBCLASS db=new DBCLASS();
      String accesslist="";
      
      for(int accessCount=0;accessCount<checkBoxes.size();accessCount++){
      if(checkBoxes.get(accessCount).isSelected()){
      accesslist+=checkBoxes.get(accessCount).getText()+" ";
      }
}
     
  system_user user=new system_user(namestext.getText(),usernametext.getText(), passwordtext.getText(), idnumbertext.getText(), phonenumbertext.getText(),accesslist);     
  
 System.out.println("Selected access list:\n"+user.getACCESS());  
  if(db.insertUser(user)){
    
        JOptionPane.showMessageDialog(null, "User added!");
    }
  
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      });
     
     
     update.addActionListener((ActionEvent e) -> {
      if(namestext.getText().equals("")||usernametext.getText().equals("")||
              passwordtext.getText().equals("")||idnumbertext.getText().equals("")||
              phonenumbertext.getText().equals(""))
      { JOptionPane.showMessageDialog(null, "All fields are required!"); return;}
         
         DBCLASS db=new DBCLASS();
      String accesslist="";
      
      for(int accessCount=0;accessCount<checkBoxes.size();accessCount++){
      if(checkBoxes.get(accessCount).isSelected()){
      accesslist+=checkBoxes.get(accessCount).getText()+" ";
      }
}
     
  system_user user=new system_user(namestext.getText(),usernametext.getText(), passwordtext.getText(), idnumbertext.getText(), phonenumbertext.getText(),accesslist);     
  
 System.out.println("Selected access list:\n"+user.getACCESS());  
  if(db.updateUser(user)){
    
        JOptionPane.showMessageDialog(null, "User Updated!");
    }
  
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      });
     
     
     
  }
       
  
  public static void main(String [] args){
 // new users().setVisible(true);
  }


  
}