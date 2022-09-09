import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class HomePage extends JFrame implements ActionListener{
	private JLabel LabelTitle, LabelWeek1,LabelWeek2,LabelWeek3,LabelWeek4,LabelWeek5,LabelWeek6,LabelWeek7;
	private JButton ButtonLogout,ButtonGroups; 
	private JPanel PanelHomePage,PanelWeek;
	private Icon previousIcon,nextIcon;
	private Color frameColor=new Color(152, 144, 209);
	public HomePage(){
		//frame preferences
		super(" Tarikh ");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		Dates date= new Dates();
		String todayDate=date.today();
		//main panel
		PanelHomePage = new JPanel();
		//PanelHomePage.setSize(new Dimension(1280,720));
		PanelHomePage.setBounds(0,0,1280,720);
		PanelHomePage.setBackground(frameColor);
		PanelHomePage.setLayout(null);
		
			//Button to groups
			ButtonGroups=new JButton("Groups");
			ButtonGroups.setBounds(20,20,135,40);
			ButtonGroups.setFont(new Font("Roboto",Font.BOLD,28));
			ButtonGroups.setBackground(Color.white);
			ButtonGroups.setForeground(frameColor);
			ButtonGroups.setFocusPainted(false);
			ButtonGroups.setBorderPainted(false);
			ButtonGroups.addActionListener(this);
			
			
			//title
			LabelTitle = new JLabel(todayDate);
			LabelTitle.setFont(new Font("Roboto",Font.BOLD,35));
			LabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
			LabelTitle.setVerticalAlignment(SwingConstants.CENTER);
			LabelTitle.setForeground(Color.white);
			LabelTitle.setBounds(515,60,250,35);
			
			
			
			//Button logout
			ButtonLogout=new JButton("Logout");
			ButtonLogout.setFont(new Font("Roboto",Font.BOLD,28));
			ButtonLogout.setBounds(1115,20,130,40);
			ButtonLogout.setBackground(Color.white);
			ButtonLogout.setForeground(new Color(220, 10, 14));
			ButtonLogout.setFocusPainted(false);
			ButtonLogout.setBorderPainted(false);
			ButtonLogout.addActionListener(this);
			
			//Panel week
			PanelWeek = new JPanel();
			PanelWeek.setBounds(40,110,1190,40);
			PanelWeek.setBackground(Color.white);
			PanelWeek.setLayout(new GridLayout(1,7));
			
				//Layout week
				LabelWeek1 = new JLabel("Sun");
				LabelWeek1.setFont(new Font("Roboto",Font.BOLD,20));
				LabelWeek1.setHorizontalAlignment(SwingConstants.CENTER);
				LabelWeek1.setVerticalAlignment(SwingConstants.CENTER);
				LabelWeek1.setForeground(frameColor);
				//LabelWeek1.setSize(new Dimension(182,40));
				
				LabelWeek2 = new JLabel("Mon");
				LabelWeek2.setHorizontalAlignment(SwingConstants.CENTER);
				LabelWeek2.setVerticalAlignment(SwingConstants.CENTER);
				LabelWeek2.setFont(new Font("Roboto",Font.BOLD,20));
				LabelWeek2.setForeground(frameColor);
				//LabelWeek2.setSize(new Dimension(182,40));
				
				LabelWeek3 = new JLabel("Tue");
				LabelWeek3.setHorizontalAlignment(SwingConstants.CENTER);
				LabelWeek3.setVerticalAlignment(SwingConstants.CENTER);
				LabelWeek3.setFont(new Font("Roboto",Font.BOLD,20));
				LabelWeek3.setForeground(frameColor);
				//LabelWeek3.setSize(new Dimension(182,40));
				
				LabelWeek4 = new JLabel("Wed");
				LabelWeek4.setHorizontalAlignment(SwingConstants.CENTER);
				LabelWeek4.setVerticalAlignment(SwingConstants.CENTER);
				LabelWeek4.setFont(new Font("Roboto",Font.BOLD,20));
				LabelWeek4.setForeground(frameColor);
				//LabelWeek4.setSize(new Dimension(182,40));
				
				LabelWeek5 = new JLabel("Thu");
				LabelWeek5.setHorizontalAlignment(SwingConstants.CENTER);
				LabelWeek5.setVerticalAlignment(SwingConstants.CENTER);
				LabelWeek5.setFont(new Font("Roboto",Font.BOLD,20));
				LabelWeek5.setForeground(frameColor);
				//LabelWeek5.setSize(new Dimension(182,40));
				
				LabelWeek6 = new JLabel("Fri");
				LabelWeek6.setHorizontalAlignment(SwingConstants.CENTER);
				LabelWeek6.setVerticalAlignment(SwingConstants.CENTER);
				LabelWeek6.setFont(new Font("Roboto",Font.BOLD,20));
				LabelWeek6.setForeground(frameColor);
				//LabelWeek6.setSize(new Dimension(182,40));
				
				LabelWeek7 = new JLabel("Sat");
				LabelWeek7.setHorizontalAlignment(SwingConstants.CENTER);
				LabelWeek7.setVerticalAlignment(SwingConstants.CENTER);
				LabelWeek7.setFont(new Font("Roboto",Font.BOLD,20));
				LabelWeek7.setForeground(frameColor);
				//LabelWeek7.setSize(new Dimension(182,40));
			
			PanelWeek.add(LabelWeek1);
			PanelWeek.add(LabelWeek2);
			PanelWeek.add(LabelWeek3);
			PanelWeek.add(LabelWeek4);
			PanelWeek.add(LabelWeek5);
			PanelWeek.add(LabelWeek6);
			PanelWeek.add(LabelWeek7);
			
			//Panel Days
			this.add(date.buttons());
			
			
			//adding elements into MAIN PANEL
			PanelHomePage.add(ButtonGroups);
			PanelHomePage.add(LabelTitle);
			PanelHomePage.add(ButtonLogout);
			PanelHomePage.add(PanelWeek);
			PanelHomePage.add(PanelWeek);
		
		//adding elements into FRAME
		this.add(PanelHomePage);
		
		
	} 
	
	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==ButtonGroups)
			{
				GroupsPage groupsPage = new GroupsPage();
				this.setVisible(false);
				groupsPage.setVisible(true);
			}
			else if(ae.getSource()==ButtonLogout)
			{
				try{
				File file=new File("currentUser.txt");
				FileWriter writer=new FileWriter(file, false);
				writer.close();
				LoginPage loginPage = new LoginPage();
				this.setVisible(false);
				loginPage.setVisible(true);
				}
				catch(Exception io){}
			}
			
		}
		
		
		public static void main(String args[]){
		HomePage d= new HomePage();
		d.setVisible(true);
	}	

}