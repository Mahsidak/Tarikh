import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class Dates extends JFrame implements ActionListener{
	
	private JPanel Panel;
	private JButton B1;
	private Color frameColor=new Color(152, 144, 209);
	private LocalDate today = LocalDate.now();
	private int monthValue =today.getMonthValue();
	private String month=today.getMonth().toString();
	private int year= today.getYear();
	private LocalDate yymmdd = LocalDate.of(year,monthValue,1);
	private	int currentDate=today.getDayOfMonth();
	private String weekday=yymmdd.getDayOfWeek().toString();
	private int lastDayOfMonth=yymmdd.lengthOfMonth();
	private int days=1;
	private int firstDayOfMonth;
	
	public JPanel buttons(){
			Panel = new JPanel();
			Panel.setBounds(40,155,1190,500);
			Panel.setBackground(Color.white);
			Panel.setLayout(new GridLayout(5,7));		
			
			switch(weekday) {
				case "SUNDAY":
					firstDayOfMonth=1;
					break;
				case "MONDAY":
					firstDayOfMonth=2;
					break;
				case "TUESDAY":
					firstDayOfMonth=3;
					break;
				case "WEDNESDAY":
					firstDayOfMonth=4;
					break;
				case "THURSDAY":
					firstDayOfMonth=5;
					break;
				case "FRIDAY":
					firstDayOfMonth=6;				
					break;
				default:
					firstDayOfMonth=7;
			}
			for(int i=1;i<36;i++){
				
				if(i>=firstDayOfMonth && i<=lastDayOfMonth+firstDayOfMonth){					
					if(i==currentDate+firstDayOfMonth){
						String date=Integer.toString(days);
						B1=new JButton(date);
						B1.setFont(new Font("Roboto",Font.BOLD,28));
						B1.setBackground(Color.white);
						B1.setForeground(frameColor);
						B1.setBorder(BorderFactory.createLineBorder(frameColor,3));
						B1.setFocusPainted(false);
						B1.setBorderPainted(true);
						B1.addActionListener(this);
						Panel.add(B1);
						days++;
					}
					else{
						String date=Integer.toString(days);
						B1=new JButton(date);
						B1.setFont(new Font("Roboto",Font.BOLD,28));
						B1.setBackground(Color.white);
						B1.setForeground(frameColor);
						B1.setFocusPainted(false);
						B1.setBorderPainted(false);
						B1.addActionListener(this);
						Panel.add(B1);
						days++;
					}
				}
				else{
					B1=new JButton("");
					B1.setFont(new Font("Roboto",Font.BOLD,28));
					B1.setBackground(Color.white);
					B1.setForeground(frameColor);
					B1.setFocusPainted(false);
					B1.setBorderPainted(false);
					Panel.add(B1);
					i++;
				}
		
			}				
		
		return Panel;
	}
	
	public String today(){
		String monthYear= month+","+Integer.toString(year);
		return monthYear;
	}
	
	public void actionPerformed(ActionEvent ae)
    {
        String str = ae.getActionCommand();
		EventsPage events= new EventsPage(str);
		events.setVisible(true);
    }
	
}