import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.*;

public class Client {
	
	private double Balance=0.0;
	
	 int counter=0;
	String balance[]=new String[5];

	
	
	public double getBalance() {
		return Balance;
	}
	
	public void WithDraw(double x) {
		if(Balance>x) {
        Balance= Balance-x;
        
        if (counter>4) {
			  counter=4;
			  for(int k=0;k<4;k++) {
				  balance[k]=balance[k+1];
				  
			  }
		}
		balance[counter]="WithDraw"+String.valueOf(x) ;
		counter++;
	}
    		
		else {
			JFrame panel=new JFrame("Warning ");
			JOptionPane.showMessageDialog(null,"NO enough Money");
		}
	}
	
	
	public void Deposit(double y) {
		
		Balance=Balance+y;
		
		if (counter>4) {
			  counter=4;
			  for(int k=0;k<4;k++) {
				  balance[k]=balance[k+1];
				  
			  }
		}
		balance[counter]="Deposit"+ String.valueOf(y) ;
		counter++;
	}
	
	
     public String next() { 
    	 if(counter>4) {
    		 JFrame panel=new JFrame("Warning ");
 			JOptionPane.showMessageDialog(null,"NO Next Data");
 			counter--;
    	 }
       return balance[counter++];	
   }
     
     
     public String previous() {
    	 if(counter<=0) {
    		 JFrame panel=new JFrame("Warning ");
 			JOptionPane.showMessageDialog(null,"NO Previous Data");
 			counter++;
    	 }
    	 return balance[--counter];
     }
	
}
