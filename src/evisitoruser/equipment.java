
package evisitoruser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Uwimana
 */
public class equipment {

    public equipment() {
    }
    
    String barcode, name, owner;
    double price;
JFrame epuipmentFrame=new JFrame();
    public equipment(String barcode, String name, String owner,double price) {
        this.barcode = barcode;
        this.name = name;
        this.owner = owner;
       this.price=price;
    }

    public equipment(String barcode) {
        this.barcode = barcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public void showEquipmentInterface(){
    JPanel p1=new JPanel();
    p1.setLayout(null);
    JButton insert=new JButton("Add");
    JLabel barcodeL=new JLabel("Barcode");
    JLabel priceL=new JLabel("Price");
    JLabel nameL=new JLabel("Name");
    JLabel ownerL=new JLabel("Owner");
    JTextField barcodeT=new JTextField();
    JTextField nameT=new JTextField();
    JTextField priceT=new JTextField();
    JTextField ownerT=new JTextField("Institution");
 //======================================================================================================================================   
  barcodeL.setBounds(10, 10, 100, 25); barcodeT.setBounds(120, 10, 200, 25);
  nameL.setBounds(10, 45, 100, 25);  nameT.setBounds(120, 45, 200, 25);
  priceL.setBounds(10, 80, 100, 25); priceT.setBounds(120, 80, 200, 25);
  ownerL.setBounds(10, 120, 100, 25); ownerT.setBounds(120, 120, 200, 25);
  
  ownerT.setEditable(false);
  
  insert.setBounds(20, 160, 100, 50);
 // ========================================================================================================================================= 
    p1.add(nameT);
    p1.add(nameL);
    p1.add(barcodeL);
    p1.add(barcodeT);
    p1.add(ownerT);
    p1.add(ownerL);
    p1.add(insert);
     p1.add(priceL);
          p1.add(priceT);
    p1.setSize(500, 500);
    epuipmentFrame.add(p1);
    epuipmentFrame.setSize(500, 500);
    epuipmentFrame.setVisible(true);
    insert.addActionListener((ActionEvent e) -> {
  double price1=0.0;
  try{
 price1=Double.parseDouble( priceT.getText());    
  }catch(Exception exx){
  JOptionPane.showMessageDialog(null,"Price must be a Real number!");
  return;
  }
equipment Equipment=new equipment(
barcodeT.getText(),nameT.getText(),ownerT.getText(),price1);
DBCLASS db=new DBCLASS();
if(db.insertEquipment(null,Equipment.getName(),Equipment.getBarcode(), 
Equipment.getOwner(), Equipment.getPrice())){
    JOptionPane.showMessageDialog(null,"Equipment Added!");
    }

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    });
    
    
    }
    public void closeEquipmentInterface(){
    
        epuipmentFrame.dispose();
    }
    
    public static void main(String []args){
    new equipment().showEquipmentInterface();
    }
}
