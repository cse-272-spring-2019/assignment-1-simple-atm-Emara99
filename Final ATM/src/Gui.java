import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;



public class Gui extends Application {
	Bank Check= new Bank();
	Client Process = new Client();
	
	public void start(Stage primaryStage) {
		
		Stage HomeStage = new Stage();
		Stage DepositStage = new Stage();
		Stage WithDrawStage = new Stage();
		Stage NextHistoryStage = new Stage();
		Stage PreviousHistoryStage = new Stage();

		
		primaryStage.setTitle("ATM");
		Label item1=new Label("Enter your Visa_id");
		TextField Visa_id= new TextField();
		Label item2 = new Label("Enter your Passcode");
		PasswordField Passcode =new PasswordField();
		Label item3=new Label();
		
		Button Submit= new Button("Submit");
		Submit.setOnAction(m->{
			
			String x=Visa_id.getText();
			String y=Passcode.getText();
			Check.CheckPasscode(x, y);
			if(Check.CheckPasscode(x, y) == false) {
				item3.setText("your Visa id or passcode is wrong");
			}
			else {
				Visa_id.clear();
				Passcode.clear();
				primaryStage.close();
				HomeStage.show();
			}
			
		});
		
		HBox h=new HBox();
		h.getChildren().addAll(item1,Visa_id);
		h.setSpacing(100);
		
		HBox h2=new HBox();
		h2.getChildren().addAll(item2, Passcode);
		h2.setSpacing(100);
		
		
		VBox v=new VBox();
		v.getChildren().addAll(h,h2,Submit,item3);
		v.setSpacing(20);
		
		Scene scene =new Scene(v);
		primaryStage.setScene(scene);
		primaryStage.setMinHeight(300);
		primaryStage.setMinWidth(400);
		primaryStage.show();
		
		
		
		HomeStage.setTitle("ATM");
		
		Button item4 = new Button("Deposit");
		item4.setOnAction(m->{
		DepositStage.show();
		});
		
      Label new1 = new Label("Enter the Money you want to deposit");
      TextField money = new TextField();
      Label new2 =new  Label();
      
      Button bt=new Button("Save");
     
      bt.setOnAction(m->{
    	  String z= money.getText();
    	  
    	 
    	  try {
    		  Double.parseDouble(z);
    		  if(Double.parseDouble(z)>0) {
    		  Process.Deposit(Double.parseDouble(z));
        	  new2.setText("Your Current Balance= "+String.valueOf(Process.getBalance()));
    		  }
    		  else {
        		  JFrame panel2=new JFrame("Warning ");
        			JOptionPane.showMessageDialog(null,"You have entered a negative character");
        	  }
    	  }catch(Exception e) {
    		  JFrame panel2=new JFrame("Warning ");
  			JOptionPane.showMessageDialog(null,"You have entered a  character");
    	  }
    	  
    	 money.clear(); 
    	 
      });
      
      DepositStage.setTitle("Deposit");
      HBox D=new HBox();
	D.getChildren().addAll(new1,money);
	D.setSpacing(100);
	
	VBox D2=new VBox();
	D2.getChildren().addAll(D,bt, new2);
	D2.setSpacing(20);
	
	Scene sceneD =new Scene(D2);
	DepositStage.setScene(sceneD);
	DepositStage.setMinHeight(300);
	DepositStage.setMinWidth(400);
     
      
      
		
		
		
		Button  item5 = new Button("WithDraw");
		item5.setOnAction(m->{
			WithDrawStage.show();
			});
		
		   Label W = new Label("Enter the Money you want to WithDraw");
		      TextField opp = new TextField();
		      Label opp2 =new  Label();
		      
		      Button btw=new Button("Save");
		      
		      btw.setOnAction(m->{
		    	  String g= opp.getText();
		    	
		    	  try {
		    		  Double.parseDouble(g);
		    		 if( Double.parseDouble(g)>0) {
		    		  Process.WithDraw(Double.parseDouble(g));
			    	  opp2.setText("Current Balance = "+String.valueOf(Process.getBalance()));
		    		 }
		    		 else {
		    			 JFrame panel3=new JFrame("Warning ");
			    			JOptionPane.showMessageDialog(null,"You have entered a negative character");  
		    		 }
		    	  }catch(Exception e) {
		    		  JFrame panel3=new JFrame("Warning ");
		    			JOptionPane.showMessageDialog(null,"You have entered a character");
		    	  }
		    	  

		      opp.clear();
		    	  
	     });		
		      
		      WithDrawStage. setTitle("WithDraw");
		      HBox WD=new HBox();
			WD.getChildren().addAll(W,opp);
			WD.setSpacing(100);
			
			VBox WD2=new VBox();
			WD2.getChildren().addAll(WD,btw, opp2);
			WD2.setSpacing(20);
			
			Scene sceneWD =new Scene(WD2);
			WithDrawStage.setScene(sceneWD);
			WithDrawStage.setMinHeight(300);
			WithDrawStage.setMinWidth(400);
		
		
		
		
		
		Button item7 = new Button("Previous");
		Label B=new Label();
		item7.setOnAction(m->{
			PreviousHistoryStage.show();
			B.setText(Process.previous());
			});
		 PreviousHistoryStage. setTitle("Previous History");
		    HBox k3=new HBox();
	    	k3.getChildren().addAll(B);
	    	k3.setSpacing(100);
	    	
	    	Scene scenePH =new Scene(k3);
	    	PreviousHistoryStage.setScene(scenePH);
	    	PreviousHistoryStage.setMinHeight(90);
	    	PreviousHistoryStage.setMinWidth(70);
		
		Button item8 = new Button("Next");
		Label N=new Label();
		item8.setOnAction(m->{
			NextHistoryStage.show();
			N.setText(Process.next());
			});
		
		 NextHistoryStage. setTitle("Next History");
		    HBox k4=new HBox();
	    	k4.getChildren().addAll(N);
	    	k4.setSpacing(100);
	    	
	    	Scene sceneNH =new Scene(k4);
	    	NextHistoryStage.setScene(sceneNH);
	    	NextHistoryStage.setMinHeight(90);
	    	NextHistoryStage.setMinWidth(70);
		
		
		
		
		
		Button item9 = new Button("SignOut");
		item9.setOnAction(m->{
			HomeStage.close();
			primaryStage.show();
			});
		
		
		
		HBox k=new HBox();
		k.getChildren().addAll(item4,item5);
		k.setSpacing(100);
		
		HBox g=new HBox();
		g.getChildren().addAll(item7);
		g.setSpacing(100);
		
		HBox p=new HBox();
		p.getChildren().addAll(item8,item9);
		p.setSpacing(100);
		
		VBox r=new VBox();
		r.getChildren().addAll(k,g,p);
		r.setSpacing(20);
		
		
		Scene scene2 =new Scene(r);
		HomeStage.setScene(scene2);
		HomeStage.setMinHeight(300);
		HomeStage.setMinWidth(400);
	
	}
	
		
	    
			
		

	}




