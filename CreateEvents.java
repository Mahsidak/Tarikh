import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

public class CreateEvents extends JFrame implements ActionListener{
	private JButton ButtonAdd,ButtonList;
	private JTextField TextEvent;
	private JLabel LabelTitle,LabelEventName;
	private JPanel PanelMain;
	private JComboBox EventType;
	private String currentUser;
	private String list[]=new String[50];
	private Color frameColor=new Color(152, 144, 209);
	private String date;
	
	public CreateEvents(String date){
		super(" Tarikh ");		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(400,50,350,550);
		this.date=date;
		
		PanelMain = new JPanel();
		PanelMain.setBounds(0,0,350,550);
		PanelMain.setBackground(frameColor);
		PanelMain.setLayout(null);
		
		
		printEventType();
		EventType= new JComboBox(list);
		EventType.setBounds(70,170,200,30);
		
		LabelEventName = new JLabel("Event details");
		LabelEventName.setFont(new Font("Roboto",Font.BOLD,18));
		LabelEventName.setForeground(Color.white);
		LabelEventName.setBounds(17,230,200,25);
		
		
		
		TextEvent=new JTextField("");
		TextEvent.setBounds(17,270,300,25);
		TextEvent.setFont(new Font("Roboto",Font.PLAIN,18));
		TextEvent.setBorder(null);
		
		
		LabelTitle = new JLabel("Add new event");
		LabelTitle.setFont(new Font("Roboto",Font.BOLD,25));
		LabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTitle.setVerticalAlignment(SwingConstants.CENTER);
		LabelTitle.setForeground(Color.white);
		LabelTitle.setBounds(0,30,350,30);
		
		//Button Add
		ButtonAdd=new JButton("ADD");
		ButtonAdd.setFont(new Font("Roboto",Font.BOLD,18));
		ButtonAdd.setBounds(17,370,300,40);
		ButtonAdd.setBackground(Color.white);
		ButtonAdd.setForeground(frameColor);
		ButtonAdd.setFocusPainted(false);
		ButtonAdd.setBorderPainted(false);
		ButtonAdd.addActionListener(this);

		PanelMain.add(ButtonAdd);
		PanelMain.add(LabelTitle);
		//PanelMain.add(EventType);
		PanelMain.add(TextEvent);
		PanelMain.add(LabelEventName);
		
		this.add(PanelMain);
	}
	
	public void printEventType(){
		list[0]="Personal";
		int lastIndex=1;
		try{			
			File file = new File("currentUser.txt");
			Scanner sc= new Scanner(file);
			if(sc.hasNextLine()){
				currentUser= sc.nextLine();
				currentUser=currentUser.substring(0,currentUser.indexOf("@"));
				try{
				String userGroupList=currentUser+"-groupList.txt";			
				File currentUserGroupList= new File(userGroupList);		
				Scanner scc = new Scanner(currentUserGroupList);
						while(scc.hasNextLine()){
						list[lastIndex]=scc.nextLine();
						lastIndex++;
						}
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		catch(Exception io){
			
			io.printStackTrace();
		}
	}
	
	
	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==ButtonAdd)
			{
				String selectedEventType = EventType.getSelectedItem().toString();
				String eventDetail=TextEvent.getText();
				if(eventDetail!=null || !eventDetail.isEmpty()){
					try{
					File file =new File(currentUser+"-events.txt");
					FileWriter writer = new FileWriter(file, true);
					writer.write(date+'@'+eventDetail+"\n");
					writer.flush();
					writer.close();
					this.setVisible(false);
					EventsPage e= new EventsPage(date);
					e.setVisible(true);
					}
					catch(Exception ioe){
						ioe.printStackTrace();
					}
				}
			}
		}
		
}
	
	