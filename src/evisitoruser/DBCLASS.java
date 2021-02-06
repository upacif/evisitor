/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evisitoruser;

//import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Uwimana
 */
public class DBCLASS {
    Connection con;
       
    DBCLASS(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-visitors", "root","");
        } catch (SQLException ex) {
            Logger.getLogger(DBCLASS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection(){
        Connection conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-visitors", "root","");
        } catch (SQLException ex) {
            Logger.getLogger(DBCLASS.class.getName()).log(Level.SEVERE, null, ex);
        }
      return conn;
    }
    
    
    
     public Connection getConnection2(){
        Connection connn=null;
        try {
            connn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-visitors", "root","");
        } catch (SQLException ex) {
            Logger.getLogger(DBCLASS.class.getName()).log(Level.SEVERE, null, ex);
        }
      return connn;
    }
    
     
     public boolean insertVisitor(String Telphone ,String Names, String Nid){
     String insertvisitor="INSERT INTO `visitors`( `Telphone`, `Names`, `Nid`,`in_out`) VALUES ('"+Telphone+"','"+Names+"','"+Nid+"',true)";
      System.out.println(insertvisitor);
     Connection db2Con=getConnection2();
     
        try {
            Statement stInsertVisitor=db2Con.createStatement();
          if( stInsertVisitor.executeUpdate(insertvisitor)!=-1)
              return true;
        } catch (SQLException ex) {
            
          System.out.println("This Statement Failed::.."+insertvisitor);
          JOptionPane.showMessageDialog(null,"Insert Visitor Failed!!..."+ex);
          return false;
        }
     return false;
     }
     
     public boolean insertUser(system_user System_user){
     String insertUSER=" INSERT INTO `employe`(`NAMES`, `USER_ID`, `USER_PSWD`, `ID_NUMBER`, `TEL`, `ACCESS`) VALUES ('"+System_user.NAMES+"',"
             + "'"+System_user.USER_ID+"','"+System_user.USER_PSWD+"','"+System_user.ID_NUMBER+"','"+System_user.TEL+"','"+System_user.ACCESS+"')";
      System.out.println(insertUSER);
     Connection db2Con=getConnection2();
     
        try {
            Statement insertUSERST=db2Con.createStatement();
          if( insertUSERST.executeUpdate(insertUSER)!=-1){
              return true;
          }
        } catch (SQLException ex) {    
          System.out.println("This Statement Failed::.."+insertUSER);
          JOptionPane.showMessageDialog(null,"Insert User Failed!!..."+ex);
          return false;
        }
     return false;
     }
     
     
     
     public boolean updateUser(system_user System_user){
 String updateUSER="UPDATE `employe` SET `NAMES`='"+System_user.NAMES+"',`USER_ID`='"+System_user.USER_ID+"',"
         + "`USER_PSWD`='"+System_user.USER_PSWD+"',`ID_NUMBER`='"+System_user.ID_NUMBER+"',"
        + "`TEL`='"+System_user.TEL+"',`ACCESS`='"+System_user.ACCESS+"' WHERE `USER_ID`='"+System_user.USER_ID+"'";
 
      System.out.println(updateUSER);
     Connection db2Con=getConnection2();
     
        try {
            Statement updateUSERST=db2Con.createStatement();
          if( updateUSERST.executeUpdate(updateUSER)!=-1){
              return true;
          }
        } catch (SQLException ex) {    
          System.out.println("This Statement Failed::.."+updateUSER);
          JOptionPane.showMessageDialog(null,"Insert User Failed!!..."+ex);
          return false;
        }
     return false;
     }
    
     
     
     
     public boolean insertIntoAttendance(String NID, String Destination,String Entryequip){
     
     String insertIntoAttendance="INSERT INTO `attendance`(`NID`,`Destination`,`Entryequip`) VALUES "
             + "('"+NID+"','"+Destination+"','"+Entryequip+"')";
     
     System.out.println("Insert in Attendance ::..."+insertIntoAttendance);
        try {
            Statement stmntIntoAttendance=getConnection2().createStatement();
            
            if(stmntIntoAttendance.executeUpdate(insertIntoAttendance)!=-1)
                return true;
        } catch (SQLException ex) {
            
            System.out.println("Insert in Attendance Failed::..."+insertIntoAttendance);
            return false;
        }
     
     return false;
     }
     
     
     public boolean userExist(String username,String pswd){
        try {
            String loginString= "SELECT * FROM `employe` WHERE `USER_ID`='"+username+"' and `USER_PSWD`='"+pswd+"'";
            Statement loginSt=getConnection2().createStatement();
            ResultSet loginRs=loginSt.executeQuery(loginString);
           if(loginRs.next()){  
               mainvisitors.logedinUser.NAMES= loginRs.getString("NAMES"); 
               mainvisitors.logedinUser.USER_ID= loginRs.getString("USER_ID");
               mainvisitors.logedinUser.USER_PSWD= loginRs.getString("USER_PSWD");
                mainvisitors.logedinUser.ID_NUMBER= loginRs.getString("ID_NUMBER");
                mainvisitors.logedinUser.TEL= loginRs.getString("TEL");
                mainvisitors.logedinUser.ACCESS= loginRs.getString("ACCESS");
               return true;
           }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Login Failed");
            return false;
        }
        return false;
    }
     
     
     
     
     
     
      public LinkedList<system_user> getSystemUsers(){
          
          LinkedList<system_user> returnedusers=new LinkedList();
          
        try {
            String selectUsers= "SELECT * FROM `employe`";
            Statement selectUserStatement=getConnection2().createStatement();
            ResultSet userResultSet=selectUserStatement.executeQuery(selectUsers);
           while(userResultSet.next()){
               system_user user=new system_user("", "", "", "", "", "");
               user.NAMES= userResultSet.getString("NAMES"); 
               user.USER_ID= userResultSet.getString("USER_ID");
                user.USER_PSWD= userResultSet.getString("USER_PSWD");
                user.ID_NUMBER= userResultSet.getString("ID_NUMBER");
                user.TEL= userResultSet.getString("TEL");
                user.ACCESS= userResultSet.getString("ACCESS");
                returnedusers.add(user);               
           }
           return returnedusers;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Get users Failed");
            return null;
        }
       
    }
     
     
     
    public boolean exitVisitor(String tel,String id){
    
    if(getConnection2()!=null){
        String updateVisitor="UPDATE `visitors` SET `in_out`=false WHERE `Telphone`='"+tel+"' or Nid='"+id+"'";
        String updateAttendance="UPDATE `attendance` SET `Timeout`=now(),`IN_STATUS`=false WHERE Nid='"+id+"'"
                + "and id=(SELECT max(id) FROM attendance where `NID`='"+id+"')";
        System.out.println(updateVisitor);
         System.out.println(updateAttendance);
        try {
            Statement upst=getConnection2().createStatement();
            if(upst.executeUpdate(updateVisitor)!=-1 && upst.executeUpdate(updateAttendance)!=-1){
            return true;
            }
        } catch (SQLException ex) {
           // Logger.getLogger(DBCLASS.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Exiting Visitor Failed");
           System.out.println("one of the following has issue:::..."+updateVisitor+"\n....."+updateAttendance);
           return false;
           
        }
        
    }
    else
    JOptionPane.showMessageDialog(null,"Connection Lost on Check Update Exited User");
    return false;
    }
    
    public LinkedList<String[]> getNonExitedVisitors(String choice,String start ,String end){
    
        LinkedList<String[]> non_exitedVisitorsList=new LinkedList();
        
    if(getConnection2()!=null){
        String getnonExitedVisitors=null;
      if(choice.equals("all")){
        getnonExitedVisitors="SELECT attendance.NID,`Names`,`Timin`,`Timeout`,`Destination`,`Entryequip` FROM attendance,visitors where attendance.NID=visitors.NID"
                + " and Timin>='"+start+"' and Timin<='"+end+"'";
        
        System.out.println(getnonExitedVisitors);
      }
      else if(choice.equals("non_exited")){
        getnonExitedVisitors="SELECT attendance.NID,`Names`,`Timin`,`Destination`,`Entryequip` FROM attendance,visitors where attendance.NID=visitors.NID and in_out is true"
                + " and Timin>='"+start+"' and Timin<='"+end+"'";
      }
      
       else if(choice.equals("exited")){
        getnonExitedVisitors="SELECT attendance.NID,`Names`,`Timeout`,`Destination`,`Entryequip` FROM attendance,visitors where attendance.NID=visitors.NID\n" +
"and `Timeout`>='"+start+"' and `Timeout`<='"+end+"' and `IN_STATUS`=false";
      }
      
      
         try {
            Statement nonexitedStatement=getConnection2().createStatement();
           ResultSet nonExitedVisitorsResult=nonexitedStatement.executeQuery(getnonExitedVisitors);
       
           while(nonExitedVisitorsResult.next()){
           String[] rowReceid=new String[5];
           if(choice.equals("all"))
                   rowReceid=new String[6];
          rowReceid[0]=(nonExitedVisitorsResult.getString(1));
           rowReceid[1]=(nonExitedVisitorsResult.getString(2));
            rowReceid[2]=(nonExitedVisitorsResult.getString(3));
          rowReceid[3]=(nonExitedVisitorsResult.getString(4));
           rowReceid[4]=(nonExitedVisitorsResult.getString(5));
           if(choice.equals("all"))
               rowReceid[5]=(nonExitedVisitorsResult.getString(6));
       
                  non_exitedVisitorsList.add(rowReceid);
         //  System.out.println(non_exitedVisitorsList.get(0)[0]);
             
           }
        
            
        } catch (SQLException ex) {
            //Logger.getLogger(DBCLASS.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex);
            return non_exitedVisitorsList;
        }
       return non_exitedVisitorsList;  
    }
    JOptionPane.showMessageDialog(null,"Connection Lost on Getting In Visitors");
    return non_exitedVisitorsList;
    }
   
    public boolean enterVisitor(String tel,String id){
    
    if(getConnection2()!=null){
      
         String updateVisitor="UPDATE `visitors` SET `in_out`=true WHERE `Telphone`='"+tel+"' or Nid='"+id+"'";
        try {
            Statement upst=getConnection2().createStatement();
            if(upst.executeUpdate(updateVisitor)!=-1){
            return true;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DBCLASS.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }
       return false;  
    }
    JOptionPane.showMessageDialog(null,"Connection Lost on Check Update Entered User");
    return false;
    }
    
    
    
    
    public boolean checkIfUserExit(String tel,String id){
    
    if(getConnection2()!=null){
        
        String checkVisitorExist="";
        if(!id.equals("")){
       checkVisitorExist ="select * from `visitors` WHERE `Telphone`='"+tel+"' or Nid='"+id+"'";
        }
        else{
       checkVisitorExist ="select * from `visitors` WHERE `Telphone`='"+tel+"'"; 
        }
        System.out.println(checkVisitorExist);
        try {
            Statement checkUserexistst=getConnection2().createStatement();
           ResultSet rst= checkUserexistst.executeQuery(checkVisitorExist);
           if(rst.next()){
           return true;
           }
           
        } catch (SQLException ex) {
            Logger.getLogger(DBCLASS.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
     return false;   
    }
    JOptionPane.showMessageDialog(null,"Connection Lost on Check User Existance");
    return false;
    }
    
    
    
     public boolean equipmentExist(String equipment_id){
    
    if(getConnection2()!=null){
        String checkEquipment="SELECT * FROM `equipments` WHERE equipment_id='"+equipment_id+"'";
        
        System.out.println(checkEquipment);
        try {
            Statement checkUserexistst=getConnection2().createStatement();
           ResultSet rst= checkUserexistst.executeQuery(checkEquipment);
           if(rst.next()){
           return true;
           }
           
        } catch (SQLException ex) {
            Logger.getLogger(DBCLASS.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
     return false;   
    }
    JOptionPane.showMessageDialog(null,"Connection Lost on Check Equipment Existance");
    return false;
    }
    
    
    
    
    //INSERT INTO `equipments`(`id`, `visitorID`, `Equipname`, `equipment_id`, `price`, `blong_to`)
    public boolean insertEquipment( String visitorID, String Equipname, String equipment_id, String blong_to, double price){
    String inertInEquipment="INSERT INTO `equipments`(`visitorID`, `Equipname`, `equipment_id`, `blong_to`,`price`) VALUES"
            + " ('"+visitorID+"','"+Equipname+"','"+equipment_id+"','"+blong_to+"',"+price+")";
    System.out.println("Do this:...."+inertInEquipment);
  Connection conntoEquip= getConnection2();
        try {
            Statement insertEquip=conntoEquip.createStatement();
            
            if(insertEquip.executeUpdate(inertInEquipment)!=-1){
            return true;
            }
        } catch (SQLException ex) {
           System.out.println("This Statement Failed::.."+inertInEquipment);
           JOptionPane.showMessageDialog(null,ex);
            return false;
        }
     return false;
    }
    
    
    public boolean visitorIsIn(String tel,String id){
     boolean in_out=false;
    if(getConnection2()!=null){
        String checkVisitorExist="";
        
        if(!id.equals("")){
          checkVisitorExist="select in_out from `visitors` WHERE `Telphone`='"+tel+"' or Nid='"+id+"'";
                    }
        
        else{
        checkVisitorExist="select in_out from `visitors` WHERE `Telphone`='"+tel+"'";
        }
        System.out.println(checkVisitorExist);
        try {
            Statement checkUserexistst=getConnection2().createStatement();
           ResultSet rst= checkUserexistst.executeQuery(checkVisitorExist);
           while(rst.next()){       
           in_out=rst.getBoolean(1);        
           }
           //JOptionPane.showMessageDialog(null,"we have as in_out::.."+in_out);
          return in_out;
        } catch (SQLException ex) {
            Logger.getLogger(DBCLASS.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"we have as in_out::.."+in_out+"  As Exception   "+ex);
            System.out.println("we have as in_out::.."+in_out+"  As Exception   "+ex);
             return  in_out;
        }
    
    }
    JOptionPane.showMessageDialog(null,"Connection Lost on Check In or Out");
    return in_out;
    
    }
    
   
    
    
}
