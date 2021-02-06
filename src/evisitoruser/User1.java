package evisitoruser;

import com.toedter.calendar.JDateChooser;

public class User1 {

    JDateChooser dc=new JDateChooser();
    
    private int id;

    private String f_name, l_name,sex, idnumber, entrytime, entrydate, exittime;

    public User1(int id, String f_name, String l_name,String sex, String idnumber, String entrydate, String entrytime, String exittime) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.sex = sex;
        this.idnumber = idnumber;
         this.entrydate = entrydate;
        this.entrytime = entrytime;
        this.exittime = exittime;

    }

    public int getId() {
        return id;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }
    public String getSex(){
        return sex;
    }
    public String getIdNumber() {
        return idnumber;
    }
    public String getEntryDate(){
        return entrydate;
    }
    public String getEntryTime() {
        return entrytime;
    }
    public String getExTime() {
        return exittime;
    }

}
