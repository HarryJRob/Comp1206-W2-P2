import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FontFrame extends JFrame {
	
	public void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setLayout(new FlowLayout());
		this.setTitle("Font Chooser");
		
		JTextField output = new JTextField(16);
		
		{
			Panel optionPanel = new Panel();
			optionPanel.setLayout(new GridLayout(2,1));
			JCheckBox boldCheck = new JCheckBox("Bold");
			JCheckBox italicCheck = new JCheckBox("Italic");
			
			boldCheck.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED){
						output.setFont(output.getFont().deriveFont(Font.BOLD));
					} else if (e.getStateChange() == ItemEvent.DESELECTED) 
						output.setFont(output.getFont().deriveFont(Font.PLAIN));
				}

			});
			
			italicCheck.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED){
					    output.setFont(output.getFont().deriveFont(Font.ITALIC));
					} else if (e.getStateChange() == ItemEvent.DESELECTED) 
						output.setFont(output.getFont().deriveFont(Font.PLAIN));
				}

			});
			
			optionPanel.add(boldCheck);
			optionPanel.add(italicCheck);
			
			this.add(optionPanel);
		}
		
		{
			Panel fontPanel = new Panel();
			fontPanel.setLayout(new GridLayout(3,1));
			
			JRadioButton timesRadio = new JRadioButton("Times",true);
			JRadioButton helvRadio = new JRadioButton("Helvetica");
			JRadioButton courRadio = new JRadioButton("Courier");
			
			ButtonGroup fontOptions = new ButtonGroup();
			
			timesRadio.addItemListener(new ItemListener () {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED){
					    output.setFont(new Font("Times", output.getFont().getStyle(), output.getFont().getSize()));
					}
			} });
			
			helvRadio.addItemListener(new ItemListener () {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED){
					    output.setFont(new Font("Helvetica", output.getFont().getStyle(), output.getFont().getSize()));
					}
			} });
			
			courRadio.addItemListener(new ItemListener () {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED){
					    output.setFont(new Font("Courier", output.getFont().getStyle(), output.getFont().getSize()));
					}
			} });
			
			fontOptions.add(timesRadio);
			fontOptions.add(helvRadio);
			fontOptions.add(courRadio);
			
			fontPanel.add(timesRadio);
			fontPanel.add(helvRadio);
			fontPanel.add(courRadio);
			
			this.add(fontPanel);
		}

		{
			Panel outputPanel = new Panel();
			outputPanel.setLayout(new FlowLayout());
			outputPanel.add(output);
			outputPanel.add(new JButton("OK"));
			
			this.add(outputPanel);
		}
		
        this.setSize(420,120);
       	this.setVisible(true);
	}
}
