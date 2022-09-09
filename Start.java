import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Start{
	
	public void checkingCurrentUser(){
		try{
			File file = new File("currentUser.txt");
			FileWriter writer=new FileWriter(file, true);
			writer.close();
			Scanner sc= new Scanner(file);
			if(sc.hasNextLine()){
				String currentUser;
				currentUser= sc.nextLine();
				currentUser=currentUser.substring(0,currentUser.indexOf("@"));
				HomePage homePage=new HomePage();
				homePage.setVisible(true);
			}
			else{
				LoginPage loginPage = new LoginPage();
				loginPage.setVisible(true);
			}
		}
		catch(Exception io){
			io.printStackTrace();
		}
	}
	
	public static void main(String [] args)
	{
		Start start=new Start();
		start.checkingCurrentUser();
	}
}