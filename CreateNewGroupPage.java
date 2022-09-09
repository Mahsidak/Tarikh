import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CreateNewGroupPage extends JFrame implements ActionListener{
	private JLabel LabelTitle,LabelGroupName,LabelGroupLink,TextUserName;
	public static JLabel LabelError1,LabelError2;
	private JTextField TextGroupName;
	private JButton ButtonBack,ButtonCreate; 
	private JPanel PanelCreateNewGroupPage;
	private Icon backIcon;
	private Color frameColor=new Color(152, 144, 209);
	public CreateNewGroupPage(){
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
			LabelTitle = new JLabel("Create new group");
			LabelTitle.setFont(new Font("Roboto",Font.BOLD,35));
			LabelTitle.setForeground(Color.white);
			LabelTitle.setBounds(480,20,300,40);
			
			//Label Group Name
			LabelGroupName = new JLabel("Group Name");
			LabelGroupName.setFont(new Font("Roboto",Font.BOLD,28));
			LabelGroupName.setForeground(Color.white);
			LabelGroupName.setBounds(430,200,200,40);
			
			//TEXT Group Name
			
			TextGroupName=new JTextField("");
			TextGroupName.setBounds(430,270,400,40);
			TextGroupName.setFont(new Font("Roboto",Font.PLAIN,20));
			TextGroupName.setBorder(null);
			
			//Label Group Link
			LabelGroupLink = new JLabel("Group Link");
			LabelGroupLink.setFont(new Font("Roboto",Font.BOLD,28));
			LabelGroupLink.setForeground(Color.white);
			LabelGroupLink.setBounds(430,360,200,40);
			
			//Label User Name/
			TextUserName = new JLabel("username-GroupName");
			TextUserName.setFont(new Font("Roboto",Font.BOLD,20));
			TextUserName.setForeground(Color.green);
			TextUserName.setBounds(430,410,400,40);
			
			
			//Button Create
			ButtonCreate=new JButton("Create");
			ButtonCreate.setFont(new Font("Roboto",Font.BOLD,28));
			ButtonCreate.setBounds(700,480,130,40);
			ButtonCreate.setBackground(Color.white);
			ButtonCreate.setForeground(frameColor);
			ButtonCreate.setFocusPainted(false);
			ButtonCreate.setBorderPainted(false);
			ButtonCreate.addActionListener(this);
			
			
			//Errors
			LabelError1 = new JLabel("Empty credentials.");
			LabelError1.setFont(new Font("Roboto",Font.PLAIN,15));
			LabelError1.setForeground(Color.white);
			LabelError1.setBounds(2000,2000,400,18);
			
			LabelError2 = new JLabel("Group name already exists.");
			LabelError2.setFont(new Font("Roboto",Font.PLAIN,15));
			LabelError2.setForeground(Color.white);
			LabelError2.setBounds(2000,2000,400,18);
			
			
			//adding elements into panel
			PanelCreateNewGroupPage.add(ButtonBack);
			PanelCreateNewGroupPage.add(LabelTitle);
			PanelCreateNewGroupPage.add(LabelGroupName);
			PanelCreateNewGroupPage.add(TextUserName);
			PanelCreateNewGroupPage.add(LabelGroupLink);
			PanelCreateNewGroupPage.add(TextGroupName);;
			PanelCreateNewGroupPage.add(ButtonCreate);
			PanelCreateNewGroupPage.add(LabelError1);
			PanelCreateNewGroupPage.add(LabelError2);
			
		this.add(PanelCreateNewGroupPage);
	}
	
	
	
	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==ButtonBack)
			{
				GroupsPage groupsPage = new GroupsPage();
				this.setVisible(false);
				groupsPage.setVisible(true);
			}
			
			else if(ae.getSource()==ButtonCreate){
				String groupName=TextGroupName.getText();
				if(groupName==null || groupName.isEmpty()){
					LabelError2.setBounds(2000,2000,400,18);
					LabelError1.setBounds(430,320,400,18);
				}
				else{
					GroupDetails groupDetails=new GroupDetails();
					groupDetails.createGroup(groupName,this);
					
				}
				
				
			}
			
		}	
		
		
}