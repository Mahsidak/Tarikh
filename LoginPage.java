import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginPage extends JFrame implements ActionListener{
	
	private JLabel LabelTitle,LabelIntro,LabelLogin,LabelEmail,LabelPassword,LabelError1,LabelError2,LabelError3,LabelError4;
	private JTextField TextUserName;
	private JPasswordField Password;
	private JButton ButtonLogin,ButtonRegister; 
	private JPanel PanelLoginPage;
	private Icon icon;
	private Color frameColor=new Color(152, 144, 209);
	public LoginPage(){
		//frame preferences
		super(" Tarikh ");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		//main panel
		PanelLoginPage = new JPanel();
		PanelLoginPage.setSize(new Dimension(1280,720));
		PanelLoginPage.setBackground(frameColor);
		PanelLoginPage.setLayout(null);
			
			//Title
			LabelTitle = new JLabel("TARIKH");
			LabelTitle.setFont(new Font("Roboto",Font.BOLD,60));
			LabelTitle.setForeground(Color.white);
			LabelTitle.setBounds(500,80,250,40);
			LabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
			LabelTitle.setVerticalAlignment(SwingConstants.CENTER);
			
			//Intro
			LabelIntro = new JLabel("Manage Your events easily");
			LabelIntro.setFont(new Font("Roboto",Font.PLAIN,15));
			LabelIntro.setForeground(Color.white);
			LabelIntro.setBounds(600,125,250,20);
			LabelIntro.setHorizontalAlignment(SwingConstants.CENTER);
			LabelIntro.setVerticalAlignment(SwingConstants.CENTER);
			
			//Label- login to your acocunt
			LabelLogin = new JLabel("| Login to your account");
			LabelLogin.setFont(new Font("Roboto",Font.BOLD,30));
			LabelLogin.setForeground(Color.white);
			LabelLogin.setBounds(430,220,400,60);
			
			LabelEmail = new JLabel("Email");
			LabelEmail.setFont(new Font("Roboto",Font.PLAIN,18));
			LabelEmail.setForeground(Color.white);
			LabelEmail.setBounds(430,290,400,40);
			//Input username
			TextUserName=new JTextField("");
			TextUserName.setBounds(430,330,400,40);
			TextUserName.setFont(new Font("Roboto",Font.PLAIN,20));
			TextUserName.setBorder(null);

			LabelPassword = new JLabel("Password");
			LabelPassword.setFont(new Font("Roboto",Font.PLAIN,18));
			LabelPassword.setForeground(Color.white);
			LabelPassword.setBounds(430,370,400,40);
			//Input password
			Password=new JPasswordField();
			Password.setBounds(430, 410, 400, 40);
			Password.setFont(new Font("Roboto",Font.PLAIN,20));
			Password.setBorder(null);
			
				
			//Login button
			ButtonLogin=new JButton("Login");
			ButtonLogin.setFont(new Font("Roboto",Font.BOLD,28));
			ButtonLogin.setBounds(430,500,195,40);
			ButtonLogin.setBackground(Color.white);
			ButtonLogin.setForeground(frameColor);
			ButtonLogin.setFocusPainted(false);
			ButtonLogin.setBorderPainted(false);
			ButtonLogin.addActionListener(this);
			
			//Register Button
			ButtonRegister=new JButton("Register");
			ButtonRegister.setFont(new Font("Roboto",Font.BOLD,28));
			ButtonRegister.setBounds(635,500,195,40);
			ButtonRegister.setBackground(Color.white);
			ButtonRegister.setForeground(frameColor);
			ButtonRegister.setFocusPainted(false);
			ButtonRegister.setBorderPainted(false);
			ButtonRegister.addActionListener(this);
			
			
			//Errors
			LabelError1 = new JLabel("Credentials Doesn't match, Please try again.");
			LabelError1.setFont(new Font("Roboto",Font.PLAIN,13));
			LabelError1.setForeground(Color.red);
			LabelError1.setBounds(2000,2000,400,15);
			
			LabelError2 = new JLabel("User already exists.");
			LabelError2.setFont(new Font("Roboto",Font.PLAIN,13));
			LabelError2.setForeground(Color.red);
			LabelError2.setBounds(2000,2000,400,15);
			
			LabelError3 = new JLabel("Empty credentials.");
			LabelError3.setFont(new Font("Roboto",Font.PLAIN,13));
			LabelError3.setForeground(Color.red);
			LabelError3.setBounds(2000,2000,400,15);
			
			LabelError4 = new JLabel("Invalid Email.");
			LabelError4.setFont(new Font("Roboto",Font.PLAIN,13));
			LabelError4.setForeground(Color.red);
			LabelError4.setBounds(2000,2000,400,15);
			
			
			//adding elements into MAIN PANEL
			PanelLoginPage.add(LabelTitle);
			PanelLoginPage.add(LabelIntro);
			PanelLoginPage.add(LabelLogin);
			PanelLoginPage.add(ButtonRegister);
			PanelLoginPage.add(TextUserName);
			PanelLoginPage.add(Password);
			PanelLoginPage.add(ButtonLogin);
			PanelLoginPage.add(LabelEmail);
			PanelLoginPage.add(LabelPassword);
			PanelLoginPage.add(LabelError1);
			PanelLoginPage.add(LabelError2);
			PanelLoginPage.add(LabelError3);
			PanelLoginPage.add(LabelError4);
		
		//adding elements into FRAME
		this.add(PanelLoginPage);
		
	}
	public void authentication(String user){
		try{
			File file = new File("userData.txt");
			Scanner sc = new Scanner(file);
			boolean userExists=false;
			while (sc.hasNextLine()){
				if(sc.nextLine().equals(user)){
					userExists=true;
					currentUser(user);
					HomePage homePage=new HomePage();
					this.setVisible(false);
					homePage.setVisible(true);
					break;
				}
			}
			if(!userExists){
				LabelError2.setBounds(2000,2000,400,15);
				LabelError3.setBounds(2000,2000,400,15);
				LabelError4.setBounds(2000,2000,400,15);
				
				LabelError1.setBounds(430,460,400,15);
			}
		}
				
		catch(Exception ioe){
			ioe.printStackTrace();
		}
	}
	
	public void registration(String user){
		try{
			File file = new File("userData.txt");
			Scanner sc = new Scanner(file);
			boolean userExists=false;
			while (sc.hasNextLine()){
				if(sc.nextLine().equals(user)){
					LabelError1.setBounds(2000,2000,400,15);
					LabelError3.setBounds(2000,2000,400,15);
					LabelError4.setBounds(2000,2000,400,15);
					LabelError2.setBounds(430,460,400,15);
					userExists=true;
					break;
				}
			}
			
			if(!userExists){
				try{
					FileWriter writer = new FileWriter(file, true);
					writer.write("\n"+user);
					writer.flush();
					writer.close();
					currentUser(user);//created current user text file
					HomePage homePage=new HomePage();
					this.setVisible(false);
					homePage.setVisible(true);
				
				}
				catch(Exception ioe){
					ioe.printStackTrace();
				}
			}
		}		
		catch(Exception ioe){
			ioe.printStackTrace();
		}
	}
	
	public void currentUser(String user){
		try {
			File currentUser= new File("currentUser.txt");
			FileWriter writer = new FileWriter(currentUser, true);
			writer.write(user);
			writer.flush();
			writer.close();
		}
		catch(Exception ioe){
			ioe.printStackTrace();
		}
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==ButtonLogin){
				
				String email=TextUserName.getText();
				String password=String.valueOf(Password.getPassword());
				
				//checking email validation
				if(email==null || email.isEmpty()||password==null || password.isEmpty()){
					LabelError1.setBounds(2000,2000,400,15);
					LabelError2.setBounds(2000,2000,400,15);
					LabelError4.setBounds(2000,2000,400,15);
					LabelError3.setBounds(430,460,400,15);
				}
				else{
				String emailRegex= "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
				Pattern pattern = Pattern.compile(emailRegex);
					if(pattern.matcher(email).matches()){
						//getting username and password
						String user= email+" "+password;
						authentication(user);
					}
					else{
						LabelError1.setBounds(2000,2000,400,15);
						LabelError2.setBounds(2000,2000,400,15);
						LabelError3.setBounds(2000,2000,400,15);
						LabelError4.setBounds(430,460,400,15);
					}
				
				}
					
			}
			
			else if(ae.getSource()==ButtonRegister){
				
				String email=TextUserName.getText();
				String password=String.valueOf(Password.getPassword());
				
				//checking email validation
				if(email==null || email.isEmpty()||password==null || password.isEmpty()){
					LabelError1.setBounds(2000,2000,400,15);
					LabelError2.setBounds(2000,2000,400,15);
					LabelError4.setBounds(2000,2000,400,15);
					LabelError3.setBounds(430,460,400,15);
				}
				else{
				String emailRegex= "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
				Pattern pattern = Pattern.compile(emailRegex);
					if(pattern.matcher(email).matches()){
						//getting username and password
						String user= email+" "+password;
						registration(user);
					}
					else{
						LabelError1.setBounds(2000,2000,400,15);
						LabelError2.setBounds(2000,2000,400,15);
						LabelError3.setBounds(2000,2000,400,15);
						LabelError4.setBounds(430,460,400,15);
					}
				
				}
					
			}
			
		}
}