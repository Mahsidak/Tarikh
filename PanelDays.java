import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelDays extends JFrame{
	
	private JPanel Panel;
	private JButton B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19,B20,B21,B22,B23,B24,B25,B26,B27,B28,B29,B30,B31,B32,B33,B34,B35;
	private Color frameColor=new Color(152, 144, 209);
	private String button= "B35";
	public JPanel buttons(){
		Panel = new JPanel();
			Panel.setBounds(40,205,1190,450);
			Panel.setBackground(Color.white);
			Panel.setLayout(new GridLayout(5,7));
				
				B1=new JButton("11");
				B1.setFont(new Font("Roboto",Font.BOLD,28));
				B1.setBackground(Color.white);
				B1.setForeground(frameColor);
				B1.setFocusPainted(false);
				B1.setBorderPainted(false);
				
				B2=new JButton("22");
				B2.setFont(new Font("Roboto",Font.BOLD,28));
				B2.setBackground(Color.white);
				B2.setForeground(frameColor);
				B2.setFocusPainted(false);
				B2.setBorderPainted(false);
				
				B3=new JButton("33");
				B3.setFont(new Font("Roboto",Font.BOLD,28));
				B3.setBackground(Color.white);
				B3.setForeground(frameColor);
				B3.setFocusPainted(false);
				B3.setBorderPainted(false);
				
				B4=new JButton("44");
				B4.setFont(new Font("Roboto",Font.BOLD,28));
				B4.setBackground(Color.white);
				B4.setForeground(frameColor);
				B4.setFocusPainted(false);
				B4.setBorderPainted(false);
				
				B5=new JButton("55");
				B5.setFont(new Font("Roboto",Font.BOLD,28));
				B5.setBackground(Color.white);
				B5.setForeground(frameColor);
				B5.setFocusPainted(false);
				B5.setBorderPainted(false);
				
				B6=new JButton("66");
				B6.setFont(new Font("Roboto",Font.BOLD,28));
				B6.setBackground(Color.white);
				B6.setForeground(frameColor);
				B6.setFocusPainted(false);
				B6.setBorderPainted(false);
				
				B7=new JButton("77");
				B7.setFont(new Font("Roboto",Font.BOLD,28));
				B7.setBackground(Color.white);
				B7.setForeground(frameColor);
				B7.setFocusPainted(false);
				B7.setBorderPainted(false);
				
				///////////////////////////////////////////////////////////////////
				
				B8=new JButton("11");
				B8.setFont(new Font("Roboto",Font.BOLD,28));
				B8.setBackground(Color.white);
				B8.setForeground(frameColor);
				B8.setFocusPainted(false);
				B8.setBorderPainted(false);
				
				B9=new JButton("22");
				B9.setFont(new Font("Roboto",Font.BOLD,28));
				B9.setBackground(Color.white);
				B9.setForeground(frameColor);
				B9.setFocusPainted(false);
				B9.setBorderPainted(false);
				
				B10=new JButton("33");
				B10.setFont(new Font("Roboto",Font.BOLD,28));
				B10.setBackground(Color.white);
				B10.setForeground(frameColor);
				B10.setFocusPainted(false);
				B10.setBorderPainted(false);
				
				B11=new JButton("44");
				B11.setFont(new Font("Roboto",Font.BOLD,28));
				B11.setBackground(Color.white);
				B11.setForeground(frameColor);
				B11.setFocusPainted(false);
				B11.setBorderPainted(false);
				
				B12=new JButton("55");
				B12.setFont(new Font("Roboto",Font.BOLD,28));
				B12.setBackground(Color.white);
				B12.setForeground(frameColor);
				B12.setFocusPainted(false);
				B12.setBorderPainted(false);
				
				B13=new JButton("66");
				B13.setFont(new Font("Roboto",Font.BOLD,28));
				B13.setBackground(Color.white);
				B13.setForeground(frameColor);
				B13.setFocusPainted(false);
				B13.setBorderPainted(false);
				
				B14=new JButton("77");
				B14.setFont(new Font("Roboto",Font.BOLD,28));
				B14.setBackground(Color.white);
				B14.setForeground(frameColor);
				B14.setFocusPainted(false);
				B14.setBorderPainted(false);
				
				//
				
				B15=new JButton("11");
				B15.setFont(new Font("Roboto",Font.BOLD,28));
				B15.setBackground(Color.white);
				B15.setForeground(frameColor);
				B15.setFocusPainted(false);
				B15.setBorderPainted(false);
				
				B16=new JButton("22");
				B16.setFont(new Font("Roboto",Font.BOLD,28));
				B16.setBackground(Color.white);
				B16.setForeground(frameColor);
				B16.setFocusPainted(false);
				B16.setBorderPainted(false);
				
				B17=new JButton("33");
				B17.setFont(new Font("Roboto",Font.BOLD,28));
				B17.setBackground(Color.white);
				B17.setForeground(frameColor);
				B17.setFocusPainted(false);
				B17.setBorderPainted(false);
				
				B18=new JButton("44");
				B18.setFont(new Font("Roboto",Font.BOLD,28));
				B18.setBackground(Color.white);
				B18.setForeground(frameColor);
				B18.setFocusPainted(false);
				B18.setBorderPainted(false);
				
				B19=new JButton("55");
				B19.setFont(new Font("Roboto",Font.BOLD,28));
				B19.setBackground(Color.white);
				B19.setForeground(frameColor);
				B19.setFocusPainted(false);
				B19.setBorderPainted(false);
				
				B20=new JButton("66");
				B20.setFont(new Font("Roboto",Font.BOLD,28));
				B20.setBackground(Color.white);
				B20.setForeground(frameColor);
				B20.setFocusPainted(false);
				B20.setBorderPainted(false);
				
				B21=new JButton("77");
				B21.setFont(new Font("Roboto",Font.BOLD,28));
				B21.setBackground(Color.white);
				B21.setForeground(frameColor);
				B21.setFocusPainted(false);
				B21.setBorderPainted(false);
				
				//
				
				B22=new JButton("11");
				B22.setFont(new Font("Roboto",Font.BOLD,28));
				B22.setBackground(Color.white);
				B22.setForeground(frameColor);
				B22.setFocusPainted(false);
				B22.setBorderPainted(false);
				
				B23=new JButton("22");
				B23.setFont(new Font("Roboto",Font.BOLD,28));
				B23.setBackground(Color.white);
				B23.setForeground(frameColor);
				B23.setFocusPainted(false);
				B23.setBorderPainted(false);
				
				B24=new JButton("33");
				B24.setFont(new Font("Roboto",Font.BOLD,28));
				B24.setBackground(Color.white);
				B24.setForeground(frameColor);
				B24.setFocusPainted(false);
				B24.setBorderPainted(false);
				
				B25=new JButton("44");
				B25.setFont(new Font("Roboto",Font.BOLD,28));
				B25.setBackground(Color.white);
				B25.setForeground(frameColor);
				B25.setFocusPainted(false);
				B25.setBorderPainted(false);
				
				B26=new JButton("55");
				B26.setFont(new Font("Roboto",Font.BOLD,28));
				B26.setBackground(Color.white);
				B26.setForeground(frameColor);
				B26.setFocusPainted(false);
				B26.setBorderPainted(false);
				
				B27=new JButton("66");
				B27.setFont(new Font("Roboto",Font.BOLD,28));
				B27.setBackground(Color.white);
				B27.setForeground(frameColor);
				B27.setFocusPainted(false);
				B27.setBorderPainted(false);
				
				B28=new JButton("77");
				B28.setFont(new Font("Roboto",Font.BOLD,28));
				B28.setBackground(Color.white);
				B28.setForeground(frameColor);
				B28.setFocusPainted(false);
				B28.setBorderPainted(false);
				
				//
				
				B29=new JButton("11");
				B29.setFont(new Font("Roboto",Font.BOLD,28));
				B29.setBackground(Color.white);
				B29.setForeground(frameColor);
				B29.setFocusPainted(false);
				B29.setBorderPainted(false);
				
				B30=new JButton("22");
				B30.setFont(new Font("Roboto",Font.BOLD,28));
				B30.setBackground(Color.white);
				B30.setForeground(frameColor);
				B30.setFocusPainted(false);
				B30.setBorderPainted(false);
				
				B31=new JButton("33");
				B31.setFont(new Font("Roboto",Font.BOLD,28));
				B31.setBackground(Color.white);
				B31.setForeground(frameColor);
				B31.setFocusPainted(false);
				B31.setBorderPainted(false);
				
				B32=new JButton("44");
				B32.setFont(new Font("Roboto",Font.BOLD,28));
				B32.setBackground(Color.white);
				B32.setForeground(frameColor);
				B32.setFocusPainted(false);
				B32.setBorderPainted(false);
				
				B33=new JButton("55");
				B33.setFont(new Font("Roboto",Font.BOLD,28));
				B33.setBackground(Color.white);
				B33.setForeground(frameColor);
				B33.setFocusPainted(false);
				B33.setBorderPainted(false);
				
				B34=new JButton("66");
				B34.setFont(new Font("Roboto",Font.BOLD,28));
				B34.setBackground(Color.white);
				B34.setForeground(frameColor);
				B34.setFocusPainted(false);
				B34.setBorderPainted(false);
				
				B35=new JButton("77");
				B35.setFont(new Font("Roboto",Font.BOLD,28));
				B35.setBackground(Color.white);
				B35.setForeground(frameColor);
				B35.setFocusPainted(false);
				B35.setBorderPainted(false);
				
				button.setForeground(Color.red);
				
		Panel.add(B1);		
		Panel.add(B2);		
		Panel.add(B3);		
		Panel.add(B4);		
		Panel.add(B5);		
		Panel.add(B6);		
		Panel.add(B7);	
		Panel.add(B8);	
		Panel.add(B9);	
		Panel.add(B10);	
		Panel.add(B11);	
		Panel.add(B12);	
		Panel.add(B13);	
		Panel.add(B14);	
		Panel.add(B15);	
		Panel.add(B16);	
		Panel.add(B17);	
		Panel.add(B18);	
		Panel.add(B19);	
		Panel.add(B20);	
		Panel.add(B21);	
		Panel.add(B22);	
		Panel.add(B23);	
		Panel.add(B24);	
		Panel.add(B25);	
		Panel.add(B26);	
		Panel.add(B27);	
		Panel.add(B28);	
		Panel.add(B29);	
		Panel.add(B30);	
		Panel.add(B31);	
		Panel.add(B32);	
		Panel.add(B33);	
		Panel.add(B34);	
		Panel.add(B35);
		
		return Panel;
	}
	
	public static void main(String args[]){
		
		PanelDays hp=new PanelDays();
	}
			
}