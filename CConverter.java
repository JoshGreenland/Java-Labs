import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class CConverter extends JFrame implements ActionListener {

	
	public void actionPerformed(ActionEvent event){
		
		if (event.getSource() == compute) {
			
			
			String Amount = cobalt.getText().toString();
			double amount = Double.parseDouble(Amount);
			
			
			String Years = years.getText().toString();
			int years = Integer.parseInt(Years);
			
			
			for(int n=1; n<=years; n++) 
				amount -= (amount * 0.12); 
			
			
			result.setText("" + amount);
	
		}else if(event.getSource() == quit) 
			dispose();  
	}
	

	public CConverter(){
	
		 
		cobaltLabel = new JLabel();
		cobaltLabel.setSize(200, 20);
		cobaltLabel.setLocation(100, 10);
		cobaltLabel.setText("Amount of Cobalt");
		
		
		cobalt = new JTextField();
		cobalt.setSize(100, 20);
		cobalt.setLocation(300, 10);
		
		
		yearsLabel = new JLabel();
		yearsLabel.setSize(200, 20);
		yearsLabel.setLocation(100, 50);
		yearsLabel.setText("Number of Years");
		
		 
		years = new JTextField();
		years .setSize(100, 20);
		years .setLocation(300, 50);
		
		
		compute = new JButton();
		compute.setLocation(150, 90);
		compute.setSize(100, 20);
		compute.addActionListener(this);
		compute.setText("Compute");
		
		quit = new JButton();
		quit.setSize(100, 20);
		quit.setLocation(270, 90);
		quit.addActionListener(this);
		quit.setText("Quit");
		
		resultLablel = new JLabel();
		resultLablel.setSize(100, 20);
		resultLablel.setLocation(100, 140);
		resultLablel.setText("Amount Left:");
		
	
		result = new JLabel("");
		result.setSize(100, 40);
		result.setLocation(300, 140);
		
		
		
		container = getContentPane();
		container.setLayout(null);
		container.add(cobaltLabel);
		container.add(cobalt);
		container.add(yearsLabel);
		container.add(years);
		container.add(compute);
		container.add(quit);
		container.add(resultLablel);
		container.add(result);
		
		
		setTitle("Cobalt Converter");
		setBounds(100, 100, 500, 220);
		setVisible(true);
	}
	

	private JLabel cobaltLabel;
	private JTextField cobalt;
	private JLabel result;
	private JLabel resultLablel;
	private JLabel yearsLabel;
	private JTextField years;
	private JButton compute;
	private JButton quit;
	private Container container;
	
	
	public static void main(String[] args) throws Exception{
		CConverter cobalConverter = new CConverter();
	}
	
}