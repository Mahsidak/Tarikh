import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JoinGroupsPage extends JFrame implements ActionListener{
	private JLabel LabelTitle,LabelGroupName,LabelGroupLink,TextUserName,LabelError1,LabelError2,LabelError3;
	private JTextField TextGroupName;
	private JButton ButtonBack,ButtonCreate; 
	private JPanel PanelCreateNewGroupPage;
	private Icon backIcon;
	private Color frameColor=new Color(152, 144, 209);
	public JoinGroupsPage(){
		//frame preferences
		super(" Tarikh ");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		//main panel
		PanelCreateNewGroupPage = new JPanel();
		PanelCreateNewGroupPage.setSize(new Dimension(1280,720));
		PanelCreateNewGroupPage.setBackground(frameColor);
		PanelCreateNewGroupPage.setLayout(null);
		
			//back button
			backIcon = new ImageIcon(getClass().getResource("/resource/backIcon.PNG"));
			ButtonBack=new JButton(backIcon);
			ButtonBack.setBounds(20,20,48,48);
			ButtonBack.setOpaque(false);
			ButtonBack.setFocusPainted(false);
			ButtonBack.setBorderPainted(false);
			ButtonBack.setContentAreaFilled(false);
			ButtonBack.addActionListener(this);
			
			//title
			LabelTitle = new JLabel("Join new group");
			LabelTitle.setFont(new Font("Roboto",Font.BOLD,40));
			LabelTitle.setForeground(Color.white);
			LabelTitle.setBounds(480,50,300,50);
			
			//Label Group Name
			LabelGroupName = new JLabel("Group Link");
			LabelGroupName.setFont(new Font("Roboto",Font.BOLD,25));
			LabelGroupName.setForeground(Color.white);
			LabelGroupName.setBounds(430,220,200,40);
			
			//TEXT Group Name
			
			TextGroupName=new JTextField("");
			TextGroupName.setBounds(430,270,400,40);
			TextGroupName.setFont(new Font("Roboto",Font.PLAIN,20));
			TextGroupName.setBorder(null);
			
			//Button Create
			ButtonCreate=new JButton("Join");
			ButtonCreate.setFont(new Font("Roboto",Font.BOLD,28));
			ButtonCreate.setBounds(700,340,130,40);
			ButtonCreate.setBackground(Color.white);
			ButtonCreate.setForeground(frameColor);
			ButtonCreate.setFocusPainted(false);
			ButtonCreate.setBorderPainted(false);
			ButtonCreate.addActionListener(this);
			
			//Errors
			LabelError1 = new JLabel("Link is broken or user doesn't exist.");
			LabelError1.setFont(new Font("Roboto",Font.PLAIN,15));
			LabelError1.setForeground(Color.white);
			LabelError1.setBounds(2000,2000,400,15);
			
			LabelError2 = new JLabel("Empty credentials.");
			LabelError2.setFont(new Font("Roboto",Font.PLAIN,15));
			LabelError2.setForeground(Color.white);
			LabelError2.setBounds(2000,2000,400,15);
			
			LabelError3 = new JLabel("Can't join own group.");
			LabelError3.setFont(new Font("Roboto",Font.PLAIN,15));
			LabelError3.setForeground(Color.white);
			LabelError3.setBounds(2000,2000,400,15);
			
			//adding elements into panel
			PanelCreateNewGroupPage.add(ButtonBack);
			PanelCreateNewGroupPage.add(LabelTitle);
			PanelCreateNewGroupPage.add(LabelGroupName);
			PanelCreateNewGroupPage.add(TextGroupName);
			PanelCreateNewGroupPage.add(ButtonCreate);
			PanelCreateNewGroupPage.add(LabelError1);
			PanelCreateNewGroupPage.add(LabelError2);
			PanelCreateNewGroupPage.add(LabelError3);
			
		this.add(PanelCreateNewGroupPage);
	} 
	
	public void addGroupLinkToUserGroupList(String groupLink){
		try{
		String groupLinkUserName=groupLink.substring(0,groupLink.indexOf("-"));
		String groupList=groupLinkUserName+"-groupList.txt";
					try{
						File file = new File(groupList);
						Scanner sc= new Scanner(file);
						while(sc.hasNextLine()){
							if(sc.nextLine().equals(groupLink)){
								//
								try{
									//getting current user info
									File file2 = new File("currentUser.txt");
									Scanner scc= new Scanner(file2);
									String currentUser;
									currentUser= scc.nextLine();							
									currentUser=currentUser.substring(0,currentUser.indexOf("@"));
									if(currentUser.equals(groupLinkUserName)){
										LabelError2.setBounds(2000,2000,400,15);
										LabelError1.setBounds(2000,2000,400,15);
										LabelError3.setBounds(430,320,400,18);
										break;
									}
									String userJoinedList=currentUser+"-joinedGroupList.txt";
									
									File file1=new File(userJoinedList);
									file1.createNewFile();
									FileWriter writer = new FileWriter(file1, true);
									writer.write(groupLink+"\n");
									writer.flush();
									writer.close();
									
									GroupsPage groupsPage=new GroupsPage();
									this.setVisible(false);
									groupsPage.setVisible(true);
									
								}
								catch(Exception ioe){
									LabelError2.setBounds(2000,2000,400,15);
									LabelError3.setBounds(2000,2000,400,15);
									LabelError1.setBounds(430,320,400,18);
									ioe.printStackTrace();
								}								
								break;
							}
							else{
								LabelError2.setBounds(2000,2000,400,15);
								LabelError3.setBounds(2000,2000,400,15);
								LabelError1.setBounds(430,320,400,18);
							}
						}
						
					}
					catch(Exception io){
						LabelError2.setBounds(2000,2000,400,15);
						LabelError3.setBounds(2000,2000,400,15);
						LabelError1.setBounds(430,320,400,18);
						io.printStackTrace();
					}
		}
		catch(Exception e){
			LabelError2.setBounds(2000,2000,400,15);
			LabelError3.setBounds(2000,2000,400,15);
			LabelError1.setBounds(430,320,400,18);
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==ButtonCreate)
			{
				String groupLink=TextGroupName.getText();
				if(groupLink==null || groupLink.isEmpty()){
					LabelError1.setBounds(2000,2000,400,15);
					LabelError3.setBounds(2000,2000,400,15);
					LabelError2.setBounds(430,320,400,18);
				}
				else{
					addGroupLinkToUserGroupList(groupLink);
				}
			}
			else if(ae.getSource()==ButtonBack){
				GroupsPage groupsPage=new GroupsPage();
				this.setVisible(false);
				groupsPage.setVisible(true);
			}
		}
}