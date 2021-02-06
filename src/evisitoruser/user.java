
package evisitoruser;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import static evs.EVs.numberIndex;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Cell;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;


/**
 *
 * @author katys
 */
public class user extends javax.swing.JFrame {
String path = null;
public static noId child;
String twahereye="";
 JButton export;
 JTable no_exitedTabel;
 static String startTime1=null;
 static String endTime2=null;
  
 DefaultTableModel non_exited_model;
public DBCLASS DB=new DBCLASS();
//static user convertToStatic=new user();
    DefaultListModel defaultlistmodel = new DefaultListModel();
    public user() {
        initComponents();
         showDate();
        CurrentTime();
        dbbackup();
       // getStars();
       this.bindData();
        scannerInput.requestFocusInWindow();
    }
    
    public user(String needScannerInput){
   
    }
    private ArrayList getStars(){
        ArrayList stars =new ArrayList();
       
    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-visitors","root","");
        String sql ="SELECT * FROM visitors_table ORDER BY id DESC";
        PreparedStatement pst =con.prepareStatement(sql);
        ResultSet rs =pst.executeQuery();
        while(rs.next()){
            String name =rs.getString(2)+" ** "+rs.getString(3)+" ** "+rs.getString(4)+" ** "+rs.getString(5)+" ** "+rs.getString(6)+" ** "+rs.getString(7)+" ** "+rs.getString(8);
           // defaultlistmodel.addElement(name);
            stars.add(name);
            
        }
     // myJList.setModel(defaultlistmodel);
    } catch (SQLException ex) {
        Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
    }

//        stars.add("skit");
//        stars.add("smith");
//        stars.add("micheal");
//        stars.add("chaeng");
//        stars.add("uno jing");
//        stars.add("illjingo");
//        //
        return stars;
    }
    
    
    public  JTextField getscannerInput(){
    return scannerInput;
    }
    private void bindData(){
        getStars().stream().forEach((star) ->{
        defaultlistmodel.addElement(star);
        
        });
        myJList.setModel(defaultlistmodel);
        myJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    private void searchFilter( String searchTerm){
        DefaultListModel filteredItems = new DefaultListModel();
        ArrayList stars = getStars();
        stars.stream().forEach((star) ->{
        String starName=star.toString().toLowerCase();
        if(starName.contains(searchTerm.toLowerCase())){
          filteredItems.addElement(star);
        }
        });
       defaultlistmodel = filteredItems;
       myJList.setModel(defaultlistmodel);
 }
      private void dbbackup(){
      try{
                            Date d = new Date();
                         SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
                         String date = s.format(d);
int processComplete; // to verify that either process completed or not

Process runtimeProcess = Runtime.getRuntime().exec("C:/xampp/mysql/bin/mysqldump.exe -uroot  --add-drop-database -B evisitors -r C:/evisitorsbcp/bcpdb/evisitors_"+date+".sql");

// call the mysqldump in terminal and execute it

processComplete = runtimeProcess.waitFor();//store the state in variable

if(processComplete==1){//if values equal 1 process failed

JOptionPane.showMessageDialog(null, "Backup Failed");//display message
}

else if(processComplete==0){//if values equal 0 process failed
System.out.println("created successful");
//JOptionPane.showMessageDialog(null,"\n Backup created Successfully..\n Check the Backup File in the C:\\evisitorsbcp\\bcpdb Directory named as backup.sql");
//display message
}

}catch(HeadlessException | IOException | InterruptedException e){

JOptionPane.showMessageDialog(null,e);//exeception handling

}
  }
 private void CurrentTime() {
        Thread clock;
    clock = new Thread() {
        
        @Override
        public void run() {
            for (; ; ) {
                Calendar cal = new GregorianCalendar();
                int second = cal.get(Calendar.SECOND);
                int minute = cal.get(Calendar.MINUTE);
                int hour = cal.get(Calendar.HOUR);
                dateLab.setText("Time: " + hour + " : " + minute + " : " + second);
                try {
                    sleep(1000);
                    
                    
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    };
        clock.start();
    }
 


   private void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        datelab1.setText(s.format(d));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        barchart = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        reports = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        dateLab = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        datelab1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        scannerInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        myJList = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 130, 143));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User dasboard");

        barchart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        barchart.setText("Statistics");
        barchart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barchartActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Register a Visitor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Contat-us");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("About-us");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        reports.setText("REPORTS");
        reports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(barchart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barchart, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reports))
        );

        jPanel5.setBackground(new java.awt.Color(0, 130, 143));

        jPanel8.setBackground(new java.awt.Color(0, 153, 51));

        dateLab.setForeground(new java.awt.Color(255, 255, 255));
        dateLab.setText("time");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("On:");

        datelab1.setForeground(new java.awt.Color(255, 255, 255));
        datelab1.setText("date");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateLab)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datelab1)))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(datelab1))
                .addGap(18, 18, 18)
                .addComponent(dateLab)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Welcome to E-Visitors platform");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(295, 295, 295))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(239, 235, 234));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "FIRST NAME", "LAST NAME", "SEX", "ID_NUMBER"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(2);
        }

        scannerInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                scannerInputKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                scannerInputKeyTyped(evt);
            }
        });

        jLabel3.setText("Search Visitor:");

        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        myJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(myJList);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(scannerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(42, 42, 42)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scannerInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 130, 143));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("E-visitors system is the system that helps  the company/ organization/ institution to get needed information(data) from visitors by tapping the national ID cards to the provided electronic device (bar-code reader).");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addContainerGap(728, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel29)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barchartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barchartActionPerformed
        // TODO add your handling code here:
//        Statistics  stat= new Statistics();
//        stat.setVisible(true);
 try{
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-visitors", "root", "");
            java.sql.Statement stmt = con.createStatement();
            String query = "SELECT entry_date,id FROM visitors_table ";
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                JDBCCategoryDataset dataset = new JDBCCategoryDataset(con,query);
                JFreeChart jchart = ChartFactory.createLineChart("visitors", "weekly days", "visitors", dataset, PlotOrientation.VERTICAL, true, true, false);
                CategoryPlot plot = jchart.getCategoryPlot();
                plot.setRangeGridlinePaint(Color.black);
                ChartFrame chartfrm = new ChartFrame("Vistors", jchart, true);
                chartfrm.setVisible(true);
                chartfrm.setSize(700, 500);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_barchartActionPerformed

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1AncestorAdded

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed

    private void scannerInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scannerInputKeyPressed
       
//        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
//            DefaultTableModel table = new DefaultTableModel();
//            table.addColumn("#");
//            table.addColumn("First Name");
//            table.addColumn("Last Name");
//            table.addColumn("Sex");
//            table.addColumn("Id number");
//            //        table.addColumn("Entry Date");
//            //        table.addColumn("Entry time");
//            //        table.addColumn("Exit time");
//            //table.addColumn("barcode");
//
//            try{
//                //query to select data from nida data table
//
//                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/evisitors", "root", "");
//                java.sql.Statement stmt = con.createStatement();
//                String DBQ = "SELECT id,first_name,last_name,sex,id_no FROM nida_datatable where barcode_id='"+barcode.getText()+"'";
//                ResultSet rs = stmt.executeQuery(DBQ);
//
//                if(rs.next()){
//                    table.addRow(new Object[]{
//                        rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(5),
//
//                        // rs.getString(7),
//                        // rs.getString(10),
//
//                    }
//
//                );
//                jTable1.setModel(table);
//
//                try{
//
//                    int rows=jTable1.getRowCount();
//                    // System.out.println(rows);
//                    //if(rows>0){
//                        //System.out.println(rows);
//                        for(int row = 0; row<rows; row++)
//                        {
//                            //Integer id = (Integer)jTable1.getValueAt(row, 0);
//                            String firstname = (String) jTable1.getValueAt(row, 1);
//                            String lastname = (String)jTable1.getValueAt(row, 2);
//                            String sex = (String)jTable1.getValueAt(row, 3);
//                            String idnumber = (String)jTable1.getValueAt(row, 4);
//                            //qeury to check if visitor exist on database.
//                            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/evisitors", "root", "");
//                            java.sql.Statement stt = conn.createStatement();
//                            Date day = new Date();
//                            SimpleDateFormat sss = new SimpleDateFormat("dd-MM-yyyy");
//                            String todaydatee = sss.format(day);
//                            String in_out ="1";
//                            String selectQuery="SELECT id_no,entry_date from visitors_table where entry_date ='"+todaydatee+"' AND id_no = '"+idnumber+"' AND in_out='"+in_out+"'";
//                            // System.out.println(selectQuery);
//                            ResultSet rss = stt.executeQuery(selectQuery);
//
//                            if(rss.next()){
//                                //if to check exit time
//                                Date ex = new Date();
//                                SimpleDateFormat ti = new SimpleDateFormat("dd-MM-yyyy  HH:mm:ss");
//                                String exte = ti.format(ex);
//                                String inn_out ="0";
//                                //update visitor set exit time.
//                                String sqll="UPDATE visitors_table SET exit_time=? ,in_out=? WHERE entry_date ='"+todaydatee+"' AND id_no = '"+idnumber+"'";
//                                PreparedStatement pst =con.prepareStatement(sqll);
//                                pst.setString(1,exte);
//                                pst.setString(2, inn_out);
//                                pst.executeUpdate();
//
//                                int TIME_VISIBLE = 3000;
//                                JOptionPane pane = new JOptionPane("Good bye, have nice journey",
//                                    JOptionPane.INFORMATION_MESSAGE);
//                                JDialog dialog = pane.createDialog(null, "Info");
//                                dialog.setModal(false);
//                                dialog.setVisible(true);
//
//                                new Timer(TIME_VISIBLE, (ActionEvent e) -> {
//                                    dialog.setVisible(false);
//                                }).start();
//                                //JOptionPane.showMessageDialog(this, "Good bye, have nice journry");
//                                barcode.setText("");
//                            }
//
//                            else{
//
//                                // Date dat =new DATE();
//                                Date d = new Date();
//                                SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
//                                String datee = s.format(d);
//                                //System.out.println(dateFormat.format(date));
//                                //String datee =(String)jTable1.getValueAt(row, 5);
//                                Calendar cal = Calendar.getInstance();
//                                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//                                String timee =sdf.format(cal.getTime());
//                                String inn_out ="1";
//                                // System.out.println( sdf.format(cal.getTime()) );
//                                String queryco = "Insert into visitors_table(first_name, last_name, sex, id_no,entry_date,entry_time,in_out) values ('"+firstname+"','"+lastname+"','"+sex+"','"+idnumber+"','"+datee+"','"+timee+"','"+inn_out+"')";
//                                PreparedStatement  pst = con.prepareStatement(queryco);
//                                pst.execute();
//                                int TIME_VISIBLE = 3000;
//                                JOptionPane pane = new JOptionPane("record found and saved successfull",
//                                    JOptionPane.INFORMATION_MESSAGE);
//                                JDialog dialog = pane.createDialog(null, "Info");
//                                dialog.setModal(false);
//                                dialog.setVisible(true);
//
//                                new Timer(TIME_VISIBLE, (ActionEvent e) -> {
//                                    dialog.setVisible(false);
//                                }).start();
//                                //JOptionPane.showMessageDialog(null, "Successfully Save");
//                                barcode.setText("");
//                            }
//
//                        }
//
//                        //else{
//                            // JOptionPane.showMessageDialog(null, "data not found");
//                            //     }
//
//                        // barcode.setText("");
//                    }
//                    catch(HeadlessException | SQLException e){
//                        JOptionPane.showMessageDialog(this, e);
//                    }
//
//                }  //end if of select nida
//
//                else{
//                    int TIME_VISIBLE = 3000;
//                    JOptionPane pane = new JOptionPane("No record found",
//                        JOptionPane.INFORMATION_MESSAGE);
//                    JDialog dialog = pane.createDialog(null, "Info");
//                    dialog.setModal(false);
//                    dialog.setVisible(true);
//
//                    new Timer(TIME_VISIBLE, (ActionEvent e) -> {
//                        dialog.setVisible(false);
//                    }).start();
//                    //JOptionPane.showMessageDialog(null, "data not found");
//                    barcode.setText("");
//                }
//
//            }
//            catch(SQLException e){
//                JOptionPane.showMessageDialog(this, e);
//            }
//        }
    }//GEN-LAST:event_scannerInputKeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
      searchFilter(jTextField1.getText());
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        noId child = new noId();
        child.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
       
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        contact cont = new contact();
        cont.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        about ab = new about();
        ab.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void scannerInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scannerInputKeyTyped
        // TODO add your handling code here:
        jTextField1.setEnabled(false);
         char c=evt.getKeyChar();
          int numIndex;
          
                if(!(Character.isAlphabetic(c) || Character.isDigit(c)||Character.isSpaceChar(c))){
                    evt.consume();
                
                   scannerInput.setEditable(false);
                   String cString=scannerInput.getText();
     System.out.println("Twabonye::"+cString);
                     if(isInteger(cString.substring(0,1))) {   
             System.out.println("0 Start");
     scannerInput.setText(cString.substring(0,21));
          System.out.println("reba names :"+cString.substring(31, cString.length()-1));
              numIndex= numberIndex(cString.substring(31, cString.length()-1)+31);
              
              System.out.println("Num Index is "+numIndex);
         }else{
             System.out.println("4 Start");
          scannerInput.setText(twahereye+cString.substring(3,23));
               System.out.println("reba names :"+cString.substring(33, cString.length()-1));
               numIndex= numberIndex(cString.substring(33, cString.length()-1)+33);
              
              System.out.println("Num Index is "+numIndex);
         }                 
              
         if(isInteger(cString.substring(0,1))) {   
             System.out.println("0 Start");
     noId.idNumber=cString.substring(0,21);
         }else{
             System.out.println("4 Start");
          noId.idNumber=twahereye+cString.substring(3,23);
         }
               child = new noId();
              child.getNoIdTextFields()[0].setEditable(false);
              child.getNoIdTextFields()[1].setEditable(false);
             // child.getNoIdTextFields()[2].setEditable(false);
      String [] names;            
          if(isInteger(cString.substring(0,1))) {   
             System.out.println("0 Start 2");
              names=getFandLnames(cString.substring(31, numIndex+31));
    child.getNoIdTextFields()[0].setText(cString.substring(0,21));
         }else{
             System.out.println("4 Start 2");
               names=getFandLnames(cString.substring(33, numIndex+33));
          child.getNoIdTextFields()[0].setText(twahereye+cString.substring(3,23));
         }
          
          
              child.getNoIdTextFields()[1].setText(names[0]+" "+names[1]);
              //child.getNoIdTextFields()[2].setText(names[1]);
//             try {
//                 Thread.sleep(250);
//             } catch (InterruptedException ex) {
//                 Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
//             }
//             if(DB.checkIfUserExit("NO PHONE",noId.idNumber) && !DB.visitorIsIn("NO PHONE",noId.idNumber)){
//                 
//         Thread tt=new Thread(new Runnable() {
//             @Override
//             public void run() {
//                 try {
//                     sleep(1000);
//                 } catch (InterruptedException ex) {
//                     Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
//                 }
//            child.registerButtonClicked();
//
//// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//             }
//         });   
//            tt.start();
//             return;
//             }
             JOptionPane.showMessageDialog(null,"User may be registerd!");
        child.setVisible(true);
//        if(DB.checkIfUserExit("NO PHONE",noId.idNumber) && !DB.visitorIsIn("NO PHONE",noId.idNumber)){
//        
//        JOptionPane.showMessageDialog(null,"User need phone free check in");
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException ex) {
//                            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//        return;
//        }
        Thread t1=new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                            if(DB.visitorIsIn("NO PHONE",noId.idNumber)){
//            try {
//                Thread.sleep(250);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(noId.class.getName()).log(Level.SEVERE, null, ex);
//            }
       JOptionPane.showMessageDialog(null,"Visitor is In");
       if(DB.exitVisitor("NO PHONE", noId.idNumber)){
//             try {
//                Thread.sleep(10);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(noId.class.getName()).log(Level.SEVERE, null, ex);
//            }
           JOptionPane.showMessageDialog(null,"Visitor Exited!!");
            mainvisitors.userCheckInMainInterface.getScannerInput().setEditable(true);
      mainvisitors.userCheckInMainInterface.getScannerInput().setText("");
      mainvisitors.userCheckInMainInterface.getScannerInput().requestFocus();
           child.dispose();
       }
      // this.dispose();
       
       }       
                        
                        }
                    });
            
            t1.start();
        
        
        //String telString=JOptionPane.showInputDialog("INPUT ID","ENTER ID");
        
//        if(!child.getIdNo().getText().equals("")){
//        JOptionPane.showMessageDialog(null,"ID :"+child.getIdNo().getText());
//        }
        
                }  
    
           if(!scannerInput.getText().isEmpty() && (scannerInput.getText().length()<2)){
          final String startString=scannerInput.getText().substring(0,1);
           System.out.println("Duhereye kuri:: "+startString);
           twahereye=startString;
           }
    
                
        
    }//GEN-LAST:event_scannerInputKeyTyped

    
    boolean isInteger(String aa){     
       try{
    int aaa=Integer.parseInt(aa);
    System.out.println("First is: "+aaa);
    return true;
       }
       catch(Exception ew){
           System.out.println("First is: "+aa);
       return false;
       }
    }
    
    private void reportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsActionPerformed
       String choose = (String) JOptionPane.showInputDialog(null, "options", "", 
        JOptionPane.QUESTION_MESSAGE, null,
new String[]{"NON_EXITED","EXITED","ALL VISITORS"}, 
              "NON_EXITED");
      
       //JOptionPane.showMessageDialog(null, choose);
       
     switch(choose){
     
         
     case "NON_EXITED":
         
         
         //==============================================================================================================
         getNonExitedUserReport();
         //==============================================================================================================
         
        
       break;
       
       
       case "EXITED":
          //======================================================================================================
           getExitedUserReport();
           
           //===========================================================================
           
          
       break;
       
       
       
       
       
       case "ALL VISITORS":
           
 
//=================================================================================================================================
startAndEndTime();
            
//==========================================================================================================================================           
           
     
         
        break;       
     }
       
       
    }//GEN-LAST:event_reportsActionPerformed

    
    public String getCellValue(int x,int y){
    return no_exitedTabel.getValueAt(x, y).toString();
    }
   public void exportClicked(String type){
       XSSFWorkbook workbook=new XSSFWorkbook();
       XSSFSheet sheet = workbook.createSheet();
       TreeMap<String, Object[]> data=new TreeMap<>();
       for(int i=0;i<no_exitedTabel.getRowCount();i++){
       data.put(""+i+"",new Object[]{getCellValue(i,0),getCellValue(i,1),
           getCellValue(i,2),getCellValue(i,3),getCellValue(i,4),getCellValue(i,5)});
      
       }  
      
  // Set<String> ids=data.keySet();
  
  Set<String> ids=data.keySet();
       XSSFRow row;
       int rowIO=0;
       for(String key: ids){
          row=sheet.createRow(rowIO++); 
      Object [] values=data.get(key);
          int cellIO=0;
          for(Object o: values)
          {
         // XSSFCell cell=row.createCell(cellIO);
          XSSFCell cell=row.createCell(cellIO++);
      cell.setCellValue(o.toString());
          }
       }
       
    try {
        FileOutputStream fos=new FileOutputStream(new File("C:\\EVISITOR\\"+type+".xls"));
   
        workbook.write(fos);
         fos.close();
    } catch (IOException ex) {
        //Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(null, ex);
    }
  
   }
    
    public String[]  getFandLnames(String name){
    String [] fullName=new String[2];
   
    for (int i=0;i<name.length();i++){
    //char characterOfName=name.charAt(i);
    if(Character.isLowerCase(name.charAt(i))){
        fullName[0]=name.substring(0, i-1);
        fullName[1]=name.substring(i-1, name.length());
        return fullName;
    }
    }
    return fullName;
    }
    public  JTextField getScannerInput(){
    return scannerInput;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
          // new user().setVisible(true);
          userInterface.setVisible(true);
        });
    }
    public void getNonExitedUserReport(){
        String startTime=null;
        String endTime=null;
        
    JTextField availablefromT=new JTextField();
    JTextField availablefromT2=new JTextField();
    JButton done=new JButton("Done");
     JPanel contentPane =new JPanel();
    JPanel calendarP=new JPanel();
contentPane.setSize(400, 250);
calendarP.setSize(400, 250);
contentPane.setLayout(null);
calendarP.setLayout(null);
JFrame frame1=new JFrame();
frame1.setSize(400, 250);
frame1.setLocation(300,300);
///JDateChooser availFromDate = new JDateChooser();
JDateChooser availFromDate=new JDateChooser();
JDateChooser availFromDate2=new JDateChooser();

availFromDate.setDateFormatString("yyyy-MM-dd HH:mm:ss");
availFromDate2.setDateFormatString("yyyy-MM-dd HH:mm:ss");

availFromDate.setDate(new Date());
availFromDate2.setDate(new Date());
///JTextFieldDateEditor dateEditor = (JTextFieldDateEditor)availFromDate.getComponent(1);
JTextFieldDateEditor dateEditor=(JTextFieldDateEditor)availFromDate.getComponent(1);
JTextFieldDateEditor dateEditor2=(JTextFieldDateEditor)availFromDate2.getComponent(1);
dateEditor.setHorizontalAlignment(JTextField.RIGHT);
dateEditor2.setHorizontalAlignment(JTextField.RIGHT);
availFromDate.setSize(new Dimension(50,0));
availFromDate2.setSize(new Dimension(50,0));
availFromDate.add(availablefromT);
availFromDate2.add(availablefromT2);
availFromDate.setBounds(10, 10, 200, 30);
availFromDate2.setBounds(10, 50, 200, 30);
done.setBounds(10, 100, 100, 40);
calendarP.add(availFromDate);
calendarP.add(availFromDate2);
calendarP.add(done);
calendarP.setBounds(0, 0, 400, 250);
contentPane.add(calendarP);


  SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  Date cDate=new Date();
  
  //availablefromT.setText(availFromDate.getDate().toString());
  
   String date = fmt.format(cDate); //jdatechooser
//        String date = fmt.format(availFromDate); //jdatechooser
        availablefromT.setText(fmt.format(availFromDate.getDate()));
        availablefromT2.setText(fmt.format(availFromDate2.getDate()));
        
        
frame1.add(contentPane);
frame1.setVisible(true);

availFromDate.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            
            
  if("date".equals(evt.getPropertyName())){
             System.out.println(
             evt.getPropertyName()+":"+(Date)evt.getNewValue());
             availablefromT.setText(fmt.format(availFromDate.getDate()));
             }           


//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });


availFromDate2.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            
            
  if("date".equals(evt.getPropertyName())){
             System.out.println(
             evt.getPropertyName()+":"+(Date)evt.getNewValue());
             availablefromT2.setText(fmt.format(availFromDate2.getDate()));
             }           


//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });
    

done.addActionListener((ActionEvent e) -> {
    startTime1=availablefromT.getText();
     endTime2=availablefromT2.getText();
     
     
     
     
         //startTime1=JOptionPane.showInputDialog("Start Time(YYYY-MM-DD hh:mm:ss)", "2020-01-01 00:00:00");
         if(!startTime1.matches(mainvisitors.dateDbFormat)){
             JOptionPane.showMessageDialog(null,"Wrong start Date Format:"+startTime1);
             return;
         }
         //endTime2=JOptionPane.showInputDialog("End Time(YYYY-MM-DD hh:mm:ss)", "2020-01-01 00:00:00");
         
         if(!endTime2.matches(mainvisitors.dateDbFormat)){
             JOptionPane.showMessageDialog(null,"Wrong end Date Format");
             return;
         }
         
         
         JFrame tableFrame=new JFrame();
         JPanel p1=new JPanel();
         
         
         System.out.println("Getting Report of All Visitors!!");
         String allVisitorsexitedTableColumns[]={"ID","NAMES","TIME IN","TIME OUT","DESTINATION","EQUIPMENT"};
          no_exitedTabel=new JTable();
          non_exited_model=new DefaultTableModel();
          non_exited_model.addColumn(allVisitorsexitedTableColumns);
          non_exited_model.setColumnCount(6);
          non_exited_model.setColumnIdentifiers(allVisitorsexitedTableColumns);
          no_exitedTabel.setModel(non_exited_model);
           p1=new JPanel();
          export=new JButton("Export");
         p1.setLayout(null);
         p1.setSize(1000,600);
         no_exitedTabel.setBounds(5, 5, 995, 595);
         export.setBounds(5, 700, 100, 40);
         
         export.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
exportClicked("AllVisitors");             
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
         //JScrollPane jscp=new JScrollPane(no_exitedTabel);
        
        // p1.add(jscp);
            p1.add(no_exitedTabel);
             p1.add(export);
         tableFrame=new JFrame();
         tableFrame.setLayout(null);
         tableFrame.setSize(1000,800);
         tableFrame.add(p1);
         tableFrame.setTitle("NON EXITED VISITORS");
         tableFrame.setVisible(true);
         LinkedList<String[]> nonExitedVisitorList=new LinkedList<>();
         nonExitedVisitorList=DB.getNonExitedVisitors("non_exited",startTime1,endTime2);
         non_exited_model.addRow(allVisitorsexitedTableColumns);
         for(int i=0;i<nonExitedVisitorList.size();i++){
             
         non_exited_model.addRow(nonExitedVisitorList.get(i));
        
         //System.out.println(nonExitedVisitorList.get(i)[0]+" "+nonExitedVisitorList.get(i)[1]+" "+nonExitedVisitorList.get(i)[2]);
         }
     
     
     
     
     
     
     
     
     
     
     frame1.dispose();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.


        });
    }
    
    public void getExitedUserReport(){
     String startTime=null;
        String endTime=null;
        
    JTextField availablefromT=new JTextField();
    JTextField availablefromT2=new JTextField();
    JButton done=new JButton("Done");
     JPanel contentPane =new JPanel();
    JPanel calendarP=new JPanel();
contentPane.setSize(400, 250);
calendarP.setSize(400, 250);
contentPane.setLayout(null);
calendarP.setLayout(null);
JFrame frame1=new JFrame();
frame1.setSize(400, 250);
frame1.setLocation(300,300);
///JDateChooser availFromDate = new JDateChooser();
JDateChooser availFromDate=new JDateChooser();
JDateChooser availFromDate2=new JDateChooser();

availFromDate.setDateFormatString("yyyy-MM-dd HH:mm:ss");
availFromDate2.setDateFormatString("yyyy-MM-dd HH:mm:ss");

availFromDate.setDate(new Date());
availFromDate2.setDate(new Date());
///JTextFieldDateEditor dateEditor = (JTextFieldDateEditor)availFromDate.getComponent(1);
JTextFieldDateEditor dateEditor=(JTextFieldDateEditor)availFromDate.getComponent(1);
JTextFieldDateEditor dateEditor2=(JTextFieldDateEditor)availFromDate2.getComponent(1);
dateEditor.setHorizontalAlignment(JTextField.RIGHT);
dateEditor2.setHorizontalAlignment(JTextField.RIGHT);
availFromDate.setSize(new Dimension(50,0));
availFromDate2.setSize(new Dimension(50,0));
availFromDate.add(availablefromT);
availFromDate2.add(availablefromT2);
availFromDate.setBounds(10, 10, 200, 30);
availFromDate2.setBounds(10, 50, 200, 30);
done.setBounds(10, 100, 100, 40);
calendarP.add(availFromDate);
calendarP.add(availFromDate2);
calendarP.add(done);
calendarP.setBounds(0, 0, 400, 250);
contentPane.add(calendarP);


  SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  Date cDate=new Date();
  
  //availablefromT.setText(availFromDate.getDate().toString());
  
   String date = fmt.format(cDate); //jdatechooser
//        String date = fmt.format(availFromDate); //jdatechooser
        availablefromT.setText(fmt.format(availFromDate.getDate()));
        availablefromT2.setText(fmt.format(availFromDate2.getDate()));
        
        
frame1.add(contentPane);
frame1.setVisible(true);

availFromDate.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            
            
  if("date".equals(evt.getPropertyName())){
             System.out.println(
             evt.getPropertyName()+":"+(Date)evt.getNewValue());
             availablefromT.setText(fmt.format(availFromDate.getDate()));
             }           


//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });


availFromDate2.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            
            
  if("date".equals(evt.getPropertyName())){
             System.out.println(
             evt.getPropertyName()+":"+(Date)evt.getNewValue());
             availablefromT2.setText(fmt.format(availFromDate2.getDate()));
             }           


//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });
    

done.addActionListener((ActionEvent e) -> {
    startTime1=availablefromT.getText();
     endTime2=availablefromT2.getText();
     
     
     
     
         //startTime1=JOptionPane.showInputDialog("Start Time(YYYY-MM-DD hh:mm:ss)", "2020-01-01 00:00:00");
         if(!startTime1.matches(mainvisitors.dateDbFormat)){
             JOptionPane.showMessageDialog(null,"Wrong start Date Format:"+startTime1);
             return;
         }
         //endTime2=JOptionPane.showInputDialog("End Time(YYYY-MM-DD hh:mm:ss)", "2020-01-01 00:00:00");
         
         if(!endTime2.matches(mainvisitors.dateDbFormat)){
             JOptionPane.showMessageDialog(null,"Wrong end Date Format");
             return;
         }
         
         
         JFrame tableFrame=new JFrame();
         JPanel p1=new JPanel();
         
         
         System.out.println("Getting Report of All Visitors!!");
         String allVisitorsexitedTableColumns[]={"ID","NAMES","TIME IN","TIME OUT","DESTINATION","EQUIPMENT"};
          no_exitedTabel=new JTable();
          non_exited_model=new DefaultTableModel();
          non_exited_model.addColumn(allVisitorsexitedTableColumns);
          non_exited_model.setColumnCount(6);
          non_exited_model.setColumnIdentifiers(allVisitorsexitedTableColumns);
          no_exitedTabel.setModel(non_exited_model);
           p1=new JPanel();
          export=new JButton("Export");
         p1.setLayout(null);
         p1.setSize(1000,600);
         no_exitedTabel.setBounds(5, 5, 995, 595);
         export.setBounds(5, 700, 100, 40);
         
         export.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
exportClicked("AllVisitors");             
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
         //JScrollPane jscp=new JScrollPane(no_exitedTabel);
        
        // p1.add(jscp);
            p1.add(no_exitedTabel);
             p1.add(export);
         tableFrame=new JFrame();
         tableFrame.setLayout(null);
         tableFrame.setSize(1000,800);
         tableFrame.add(p1);
         tableFrame.setTitle("EXITED VISITORS");
         tableFrame.setVisible(true);
         LinkedList<String[]> nonExitedVisitorList=new LinkedList<>();
         nonExitedVisitorList=DB.getNonExitedVisitors("exited",startTime1,endTime2);
         non_exited_model.addRow(allVisitorsexitedTableColumns);
         for(int i=0;i<nonExitedVisitorList.size();i++){
             
         non_exited_model.addRow(nonExitedVisitorList.get(i));
        
         //System.out.println(nonExitedVisitorList.get(i)[0]+" "+nonExitedVisitorList.get(i)[1]+" "+nonExitedVisitorList.get(i)[2]);
         }
     
     
     
     
     
     
     
     
     
     
     frame1.dispose();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.


        });
   
    }
    
    public void startAndEndTime(){  
        String startTime=null;
        String endTime=null;
        
    JTextField availablefromT=new JTextField();
    JTextField availablefromT2=new JTextField();
    JButton done=new JButton("Done");
     JPanel contentPane =new JPanel();
    JPanel calendarP=new JPanel();
contentPane.setSize(500, 500);
calendarP.setSize(500, 500);
contentPane.setLayout(null);
calendarP.setLayout(null);
JFrame frame1=new JFrame();
frame1.setSize(500, 500);
///JDateChooser availFromDate = new JDateChooser();
JDateChooser availFromDate=new JDateChooser();
JDateChooser availFromDate2=new JDateChooser();

availFromDate.setDateFormatString("yyyy-MM-dd HH:mm:ss");
availFromDate2.setDateFormatString("yyyy-MM-dd HH:mm:ss");
availFromDate.setDate(new Date());
availFromDate2.setDate(new Date());
///JTextFieldDateEditor dateEditor = (JTextFieldDateEditor)availFromDate.getComponent(1);
JTextFieldDateEditor dateEditor=(JTextFieldDateEditor)availFromDate.getComponent(1);
JTextFieldDateEditor dateEditor2=(JTextFieldDateEditor)availFromDate2.getComponent(1);
dateEditor.setHorizontalAlignment(JTextField.RIGHT);
dateEditor2.setHorizontalAlignment(JTextField.RIGHT);
availFromDate.setSize(new Dimension(50,0));
availFromDate2.setSize(new Dimension(50,0));
availFromDate.add(availablefromT);
availFromDate2.add(availablefromT2);
availFromDate.setBounds(10, 10, 200, 30);
availFromDate2.setBounds(10, 50, 200, 30);
done.setBounds(10, 100, 100, 40);
calendarP.add(availFromDate);
calendarP.add(availFromDate2);
calendarP.add(done);
calendarP.setBounds(0, 0, 500, 500);
contentPane.add(calendarP);


  SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  Date cDate=new Date();
  
  //availablefromT.setText(availFromDate.getDate().toString());
  
   String date = fmt.format(cDate); //jdatechooser
//        String date = fmt.format(availFromDate); //jdatechooser
        availablefromT.setText(fmt.format(availFromDate.getDate()));
        availablefromT2.setText(fmt.format(availFromDate2.getDate()));
        
        
frame1.add(contentPane);
frame1.setVisible(true);

availFromDate.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            
            
  if("date".equals(evt.getPropertyName())){
             System.out.println(
             evt.getPropertyName()+":"+(Date)evt.getNewValue());
             availablefromT.setText(fmt.format(availFromDate.getDate()));
             }           


//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });


availFromDate2.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            
            
  if("date".equals(evt.getPropertyName())){
             System.out.println(
             evt.getPropertyName()+":"+(Date)evt.getNewValue());
             availablefromT2.setText(fmt.format(availFromDate2.getDate()));
             }           


//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });
    

done.addActionListener((ActionEvent e) -> {
    startTime1=availablefromT.getText();
     endTime2=availablefromT2.getText();
     
     
     
     
         //startTime1=JOptionPane.showInputDialog("Start Time(YYYY-MM-DD hh:mm:ss)", "2020-01-01 00:00:00");
         if(!startTime1.matches(mainvisitors.dateDbFormat)){
             JOptionPane.showMessageDialog(null,"Wrong start Date Format:"+startTime1);
             return;
         }
         //endTime2=JOptionPane.showInputDialog("End Time(YYYY-MM-DD hh:mm:ss)", "2020-01-01 00:00:00");
         
         if(!endTime2.matches(mainvisitors.dateDbFormat)){
             JOptionPane.showMessageDialog(null,"Wrong end Date Format");
             return;
         }
         
         
         JFrame tableFrame=new JFrame();
         JPanel p1=new JPanel();
         
         
         System.out.println("Getting Report of All Visitors!!");
         String allVisitorsexitedTableColumns[]={"ID","NAMES","TIME IN","TIME OUT","DESTINATION","EQUIPMENT"};
          no_exitedTabel=new JTable();
          non_exited_model=new DefaultTableModel();
          non_exited_model.addColumn(allVisitorsexitedTableColumns);
          non_exited_model.setColumnCount(6);
          non_exited_model.setColumnIdentifiers(allVisitorsexitedTableColumns);
          no_exitedTabel.setModel(non_exited_model);
           p1=new JPanel();
          export=new JButton("Export");
         p1.setLayout(null);
         p1.setSize(1000,800);
         no_exitedTabel.setBounds(5, 5, 995, 595);
         export.setBounds(5, 700, 100, 40);
         
         export.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
exportClicked("AllVisitors");             
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
         //JScrollPane jscp=new JScrollPane(no_exitedTabel);
        
        // p1.add(jscp);
            p1.add(no_exitedTabel);
             p1.add(export);
         tableFrame=new JFrame();
         tableFrame.setLayout(null);
         tableFrame.setSize(1000,800);
         tableFrame.add(p1);
         tableFrame.setTitle("ALL VISITORS");
         tableFrame.setVisible(true);
         LinkedList<String[]> nonExitedVisitorList=new LinkedList<>();
         nonExitedVisitorList=DB.getNonExitedVisitors("all",startTime1,endTime2);
         non_exited_model.addRow(allVisitorsexitedTableColumns);
         for(int i=0;i<nonExitedVisitorList.size();i++){
             
         non_exited_model.addRow(nonExitedVisitorList.get(i));
        
         //System.out.println(nonExitedVisitorList.get(i)[0]+" "+nonExitedVisitorList.get(i)[1]+" "+nonExitedVisitorList.get(i)[2]);
         }
     
     
     
     
     
     
     
     
     
     
     frame1.dispose();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.


        });

    }  
    
    
    public static user userInterface=new user();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton barchart;
    private javax.swing.JLabel dateLab;
    private javax.swing.JLabel datelab1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JList<String> myJList;
    private javax.swing.JButton reports;
    private javax.swing.JTextField scannerInput;
    // End of variables declaration//GEN-END:variables
}
