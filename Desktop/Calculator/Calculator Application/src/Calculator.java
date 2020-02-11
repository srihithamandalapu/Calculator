import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame{
	
	TextField op1;
	TextField op2;
	TextField result;
	Button add;
	Button diff;
	Button mul;
	Button div;
	Label equal;
	
	public Calculator() {
	
	op1 = new TextField(10);
	op2 = new TextField(10);
	add = new Button("+");
	mul = new Button("*");
	div = new Button("/");
	diff =new Button("-");
	equal = new Label("=");
	result = new TextField(10);
	result.setEditable(false);
	
	
	setLayout(new FlowLayout());
	add(op1);
	add(add);
	add(mul);
	add(div);
	add(diff);
	add(op2);
	add(equal);
	add(result);
		
	
	add.addActionListener(new Calculator_Operation());
	diff.addActionListener(new Calculator_Operation());
	mul.addActionListener(new Calculator_Operation());
	div.addActionListener(new Calculator_Operation());

	new WindowClosingAdapter();
	}
	
	
	private class WindowClosingAdapter extends WindowAdapter
	{
		public void windowClosing(WindowEvent e) {
			dispose();
		}
	}
	
	public class Calculator_Operation implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			Model mv = new Model();
			
			try {
				int operand1 = Integer.parseInt(op1.getText());
				int operand2 = Integer.parseInt(op2.getText());
				
				mv.setOper1(operand1);
				mv.setOper1(operand2);
				
				if(event.getSource() == add)
				{
					mv.setRes(operand1+operand2);
				}
				else if(event.getSource() ==diff )
				{
					mv.setRes(operand1-operand2);
				}
				else if(event.getSource() == mul)
				{
					mv.setRes(operand2*operand1);
				}
				
				else if(event.getSource() == div)
				{
					mv.setRes(operand1/operand2);
				}
			}
			catch(Exception e)
			{
					Label lb = new Label("you better enter a number");
					add(lb);
		
			}
			
			
			
			finally {
		}
			
			result.setText(String.valueOf(mv.getRes()));
	}
	
	
	}	
	
}