import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class GroupsPage extends JFrame implements ActionListener{
	private JLabel LabelTitle,LabelAlert,LabelAlert1,LabelMyGroups,LabelJoined;
	private JButton ButtonBack,ButtonNew,ButtonJoin; 
	private JPanel PanelGroupPage,PanelGroupList;
	private Icon icon;
	private Color frameColor=new Color(152, 144, 209);
	public GroupsPage(){
		//frame preferences
		super(" Tarikh ");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		//main panel
		PanelGroupPage = new JPanel();
		PanelGroupPage.setSize(new Dimension(1280,720));
		PanelGroupPage.setBackground(frameColor);
		PanelGroupPage.setLayout(null);
		
			//back button
			icon = new ImageIcon(getClass().getResource("/resource/backIcon.PNG"));
			ButtonBack=new JButton(icon);
			ButtonBack.setBounds(20,20,48,48);
			ButtonBack.setOpaque(false);
			ButtonBack.setFocusPainted(false);
			ButtonBack.setBorderPainted(false);
			ButtonBack.setContentAreaFilled(false);
			ButtonBack.addActionListener(this);
			
			//title
			LabelTitle = new JLabel("Groups");
			LabelTitle.setFont(new Font("Roboto",Font.BOLD,35));
			LabelTitle.setForeground(Color.white);
			LabelTitle.setBounds(570,20,140,40);
		
			//nested panel
			PanelGroupList = new JPanel();
			PanelGroupList.setSize(new Dimension(1280,720));
			PanelGroupList.setBackground(Color.white);
			PanelGroupList.setLayout(null);
			PanelGroupList.setBounds(70,130,1120,530);
				
				//Join button
				ButtonJoin=new JButton("Join");
				ButtonJoin.setFont(new Font("Roboto",Font.BOLD,28));
				ButtonJoin.setBounds(20,20,100,40);
				ButtonJoin.setBackground(frameColor);
				ButtonJoin.setForeground(Color.white);
				ButtonJoin.setFocusPainted(false);
				ButtonJoin.setBorderPainted(false);
				ButtonJoin.addActionListener(this);
				
				//new button
				ButtonNew=new JButton("New");
				ButtonNew.setFont(new Font("Roboto",Font.BOLD,28));
				ButtonNew.setBounds(1000,20,100,40);
				ButtonNew.setBackground(frameColor);
				ButtonNew.setForeground(Color.white);
				ButtonNew.setFocusPainted(false);
				ButtonNew.setBorderPainted(false);
				ButtonNew.addActionListener(this);
				
				//label MyGroups
				LabelMyGroups = new JLabel("| My Groups");
				LabelMyGroups.setFont(new Font("Roboto",Font.PLAIN,25));
				LabelMyGroups.setForeground(frameColor);
				LabelMyGroups.setBounds(580,70,150,40);
				
				//label JoinedGroups
				LabelJoined = new JLabel("| Joined Groups");
				LabelJoined.setFont(new Font("Roboto",Font.PLAIN,25));
				LabelJoined.setForeground(frameColor);
				LabelJoined.setBounds(20,70,180,40);
				
				printGroupList();
			
			PanelGroupList.add(ButtonNew);
			PanelGroupList.add(ButtonJoin);
			PanelGroupList.add(LabelMyGroups);
			PanelGroupList.add(LabelJoined);
			
			
			//adding elements into MAIN PANEL
			PanelGroupPage.add(PanelGroupList);
			PanelGroupPage.add(ButtonBack);
			PanelGroupPage.add(LabelTitle);
		
		//adding elements into FRAME
		this.add(PanelGroupPage);
		
	} 
	
	public void printGroupList(){
		//checking existance of grouplist file
		
		try{			
			File file = new File("currentUser.txt");
			Scanner sc= new Scanner(file);
			if(sc.hasNextLine()){
				String currentUser= sc.nextLine();
				currentUser=currentUser.substring(0,currentUser.indexOf("@"));
				printGroupListButtons(currentUser);
				printJoinedListButtons(currentUser);
			}
		}
		catch(Exception io){
			
			io.printStackTrace();
		}
	}	
		public void printGroupListButtons(String currentUser){
			try{
				String userGroupList=currentUser+"-groupList.txt";			
				File currentUserGroupList= new File(userGroupList);		
				Scanner sc = new Scanner(currentUserGroupList);
				if(sc.hasNextLine()){
					int height=110;
					while(sc.hasNextLine()){
					String groupName=sc.nextLine();
					JButton ButtonGroupLink;
					ButtonGroupLink=new JButton(groupName);
					ButtonGroupLink.setBounds(580,height,520,50);
					ButtonGroupLink.setBackground(frameColor);
					ButtonGroupLink.setForeground(Color.white);
					ButtonGroupLink.setFont(new Font("Roboto",Font.BOLD,20));
					ButtonGroupLink.setFocusPainted(false);
					ButtonGroupLink.setBorderPainted(false);
					PanelGroupList.add(ButtonGroupLink);
					height+=55;
					}
				}			
				else{
					//alert label
					LabelAlert = new JLabel("Empty List");
					LabelAlert.setFont(new Font("Roboto",Font.BOLD,30));
					LabelAlert.setForeground(frameColor);
					LabelAlert.setBounds(740,230,200,60);
					PanelGroupList.add(LabelAlert);
				}
			}
			catch(Exception io){
				try{
					String user=currentUser+"-groupList.txt";
					File currentUserGroupList= new File(user);
					currentUserGroupList.createNewFile();
					
					LabelAlert = new JLabel("Empty List");
					LabelAlert.setFont(new Font("Roboto",Font.BOLD,30));
					LabelAlert.setForeground(frameColor);
					LabelAlert.setBounds(740,230,200,60);
					PanelGroupList.add(LabelAlert);}
				catch(Exception ioe){
					ioe.printStackTrace();
				}
			}
		}
	
	//
	public void printJoinedListButtons(String currentUser){
			try{	
				String userJoinedGroupList= currentUser+"-joinedGroupList.txt";
				File currentUserJoinedGroupList= new File(userJoinedGroupList);
				Scanner scc = new Scanner(currentUserJoinedGroupList);
				if(scc.hasNextLine()){
					int height=110;
					while(scc.hasNextLine()){
					String groupName=scc.nextLine();
					JButton ButtonJoinedGroupLink;
					ButtonJoinedGroupLink=new JButton(groupName);
					ButtonJoinedGroupLink.setBounds(20,height,520,50);
					ButtonJoinedGroupLink.setBackground(frameColor);
					ButtonJoinedGroupLink.setForeground(Color.white);
					ButtonJoinedGroupLink.setFont(new Font("Roboto",Font.BOLD,20));
					ButtonJoinedGroupLink.setFocusPainted(false);
					ButtonJoinedGroupLink.setBorderPainted(false);
					PanelGroupList.add(ButtonJoinedGroupLink);
					height+=55;
					}
				}
				else{
					//alert label
					LabelAlert1 = new JLabel("Empty List");
					LabelAlert1.setFont(new Font("Roboto",Font.BOLD,30));
					LabelAlert1.setForeground(frameColor);
					LabelAlert1.setBounds(160,230,200,60);
					PanelGroupList.add(LabelAlert1);
				}
			}
			catch(Exception io){
				try{
					String userJoinedGroupList= currentUser+"-joinedGroupList.txt";
					File currentUserJoinedGroupList= new File(userJoinedGroupList);
					currentUserJoinedGroupList.createNewFile();
					
					LabelAlert1 = new JLabel("Empty List");
					LabelAlert1.setFont(new Font("Roboto",Font.BOLD,30));
					LabelAlert1.setForeground(frameColor);
					LabelAlert1.setBounds(160,230,200,60);
					PanelGroupList.add(LabelAlert1);
				}
				catch(Exception ioe){
					ioe.printStackTrace();
				}
			}
		}
	
	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==ButtonNew)
			{
				CreateNewGroupPage createNewGroupPage = new CreateNewGroupPage();
				this.setVisible(false);
				createNewGroupPage.setVisible(true);
			}
			else if(ae.getSource()==ButtonBack)
			{
				HomePage homePage = new HomePage();
				this.setVisible(false);
				homePage.setVisible(true);
			}
			else if(ae.getSource()==ButtonJoin){
				JoinGroupsPage joinGroupsPage=new JoinGroupsPage();
				this.setVisible(false);
				joinGroupsPage.setVisible(true);
			}
			
		}
		
		
}