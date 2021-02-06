/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evisitoruser;

/**
 *
 * @author Uwimana
 */
public class system_user {
    
    String NAMES,USER_ID, USER_PSWD, ID_NUMBER,TEL,ACCESS;

    public system_user(String NAMES, String USER_ID, String USER_PSWD, String ID_NUMBER, String TEL,String ACCESS) {
        this.NAMES = NAMES;
        this.USER_ID = USER_ID;
        this.USER_PSWD = USER_PSWD;
        this.ID_NUMBER = ID_NUMBER;
        this.TEL = TEL;
       this.ACCESS=ACCESS;
    }

    public String getACCESS() {
        return ACCESS;
    }

    public void setACCESS(String ACCESS) {
        this.ACCESS = ACCESS;
    }

    public String getNAMES() {
        return NAMES;
    }

    public void setNAMES(String NAMES) {
        this.NAMES = NAMES;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_PSWD() {
        return USER_PSWD;
    }

    public void setUSER_PSWD(String USER_PSWD) {
        this.USER_PSWD = USER_PSWD;
    }

    public String getID_NUMBER() {
        return ID_NUMBER;
    }

    public void setID_NUMBER(String ID_NUMBER) {
        this.ID_NUMBER = ID_NUMBER;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }
    
    
}
