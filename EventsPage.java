import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;

public class EventsPage extends JFrame implements ActionListener{
	private JButton ButtonAdd,ButtonList;
	private JPanel PanelMain;
	private Color frameColor=new Color(152, 144, 209);
	private String date;
	
	public EventsPage(String date){

		super(" Tarikh ");	
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(400,50,350,550);
		this.date=date;
		
		PanelMain = new JPanel();
		PanelMain.setBounds(0,0,350,550);
		PanelMain.setBackground(frameColor);
		PanelMain.setLayout(null);
		
		//Button new
		ButtonAdd=new JButton("New");
		ButtonAdd.setFont(new Font("Roboto",Font.BOLD,18));
		ButtonAdd.setBounds(240,20,74,30);
		ButtonAdd.setBackground(Color.white);
		ButtonAdd.setForeground(frameColor);
		ButtonAdd.setFocusPainted(false);
		ButtonAdd.setBorderPainted(false);
		ButtonAdd.addActionListener(this);
		
		lists();
		PanelMain.add(ButtonAdd);
		
		this.add(PanelMain);
	}
	
	
	public void lists(){
		
		try{
			File file = new File("currentUser.txt");
			Scanner sc= new Scanner(file);
			if(sc.hasNextLine()){
				String currentUser= sc.nextLine();
				currentUser=currentUser.substring(0,currentUser.indexOf("@"));
				File file1=new File(currentUser+"-events.txt");
				Scanner scc = new Scanner(file1);
				int height=80;
				while(scc.hasNextLine()){
					String line= scc.nextLine();
					String eventDate=line.substring(0,line.indexOf("@"));
					if(eventDate.equals(date)){
					String line1=line.substring(line.indexOf("@")+1);
					ButtonList=new JButton(line1);
					ButtonList.setFont(new Font("Roboto",Font.PLAIN,18));
					ButtonList.setBounds(7,height,320,25);
					ButtonList.setBackground(Color.white);
					ButtonList.setForeground(frameColor);
					ButtonList.setFocusPainted(false);
					ButtonList.setBorderPainted(false);
					PanelMain.add(ButtonList);
					height+=30;	
					}
				}			
				
			}
		}
		catch(Exception ex){
			ButtonList=new JButton("NO EVENTS HAS BEEN ADDED");
			ButtonList.setFont(new Font("Roboto",Font.PLAIN,18));
			ButtonList.setBounds(7,80,320,25);
			ButtonList.setBackground(Color.white);
			ButtonList.setForeground(Color.red);
			ButtonList.setFocusPainted(false);
			ButtonList.setBorderPainted(false);
			PanelMain.add(ButtonList);
			ex.printStackTrace();
		}
		
	}
	
	
	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==ButtonAdd)
			{
				CreateEvents e= new CreateEvents(date);
				this.setVisible(false);
				e.setVisible(true);
			}
		}
}
	
	