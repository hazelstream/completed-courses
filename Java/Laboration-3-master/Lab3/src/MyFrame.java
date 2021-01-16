import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

	private JButton buttonClear, buttonSave, buttonOpen;
	private JPanel southPanel, rightPanel, färgRubrikPanel, shapePanel, formRubrikPanel, buttonPanel;
	private DrawingSurface drawingSurface;
	private ColorButtons färger;
	private ShapeButtons former;
	private JLabel färg, form;


	public MyFrame() {
		//Mainframe
		super("Välkommen till ritprogrammet!");
		this.setSize(1000, 800);
		this.setLayout(new BorderLayout());


		//Southpanel
		southPanel = new JPanel(new BorderLayout());
		southPanel.setBackground(Color.LIGHT_GRAY);
		this.add(southPanel, BorderLayout.SOUTH);

		//Rightpanel /w GridBagLayout
		rightPanel = new JPanel(new GridBagLayout());
		rightPanel.setBackground(Color.LIGHT_GRAY);
		rightPanel.setPreferredSize(new Dimension(30, getSize().height));
		this.add(rightPanel, BorderLayout.EAST);

		GridBagConstraints c = new GridBagConstraints();

		//Rityta
		drawingSurface = new DrawingSurface();
		this.add(drawingSurface);

		//Buttonpanel
		buttonPanel = new JPanel();
		southPanel.add(buttonPanel, BorderLayout.WEST);
		buttonPanel.setBackground(Color.LIGHT_GRAY);

		//Clearbutton
		buttonClear = new JButton("Rensa");
		buttonClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawingSurface.getModell().clearList();
				repaint();
			}
		});
		
		buttonPanel.add(buttonClear);

		//Savebutton
		buttonSave = new JButton("Spara");
		buttonSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		//buttonPanel.add(buttonSave);
		
		//Openbutton
		buttonOpen = new JButton("Öppna");
		buttonOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});

		//buttonPanel.add(buttonOpen);

		//JLabel för nedanstående JPanel
		färg = new JLabel("Färg");
		färg.setFont(färg.getFont().deriveFont(11.0f));
		färg.setBackground(Color.LIGHT_GRAY);

		//Rubrik, skriver ut färg överst i rightpanel
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		färgRubrikPanel = new JPanel(new BorderLayout());	
		färgRubrikPanel.add(färg);
		rightPanel.add(färgRubrikPanel, c);

		//Färgknappar
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 0.5;
		färger = new ColorButtons(drawingSurface.getModell());
		färger.setPreferredSize(new Dimension(30, 300));
		rightPanel.add(färger, c);


		//JLabel för nedanstående JPanel
		form = new JLabel("Form");
		form.setFont(form.getFont().deriveFont(10.0f));
		form.setBackground(Color.LIGHT_GRAY);
		
		//Shapepanel
		shapePanel = new JPanel(new BorderLayout());
		c.gridx = 0;
		c.gridy = 2;
		c.weighty = 0.5;
		shapePanel.setBackground(Color.LIGHT_GRAY);
		rightPanel.add(shapePanel, c);

		//Rubrik, skriver ut form överst i rightpanel

		formRubrikPanel = new JPanel(new BorderLayout());	
		formRubrikPanel.add(form);
		shapePanel.add(formRubrikPanel, BorderLayout.NORTH);

		//Formknappar

		former = new ShapeButtons(drawingSurface.getModell());
		former.setPreferredSize(new Dimension(30, 300));
		shapePanel.add(former);






		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	
}
