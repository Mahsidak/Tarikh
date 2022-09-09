//import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GroupDetails{
	
	private String currentUserText;
	
	public void createGroup(String groupName, CreateNewGroupPage createNewGroupPage){
		
		//getting current user name
		try{
			File file = new File("currentUser.txt");
			Scanner sc= new Scanner(file);
			if(sc.hasNextLine()){
				currentUserText= sc.nextLine();
				currentUserText=currentUserText.substring(0,currentUserText.indexOf("@"));
			}
		}
		catch(Exception io){
			io.printStackTrace();
		}
		
		finally{
			
			//adding grouplink
			try{
				String user=currentUserText+"-groupList.txt";
				File currentUserGroupList= new File(user);
				Scanner sc = new Scanner(currentUserGroupList);
				boolean linkExists=false;
				String link=currentUserText+"-"+groupName;
				while (sc.hasNextLine()){
					if(sc.nextLine().equals(link)){
						CreateNewGroupPage.LabelError1.setBounds(2000,2000,400,18);
						CreateNewGroupPage.LabelError2.setBounds(430,320,400,18);
						linkExists=true;
						//CreateNewGroupPage createNewGroupPage= new CreateNewGroupPage();
						//createNewGroupPage.setVisible(true);
						break;
					}
				}
				
				if(!linkExists)
				{
					FileWriter writer = new FileWriter(currentUserGroupList, true);
					writer.write(currentUserText+"-"+groupName+"\n");
					writer.flush();
					writer.close();
					GroupsPage groupsPage = new GroupsPage();
					createNewGroupPage.setVisible(false);
					groupsPage.setVisible(true);
				}	
			}
			catch(Exception io){
				io.printStackTrace();
				
			}
		}
		
	}
	
	
}