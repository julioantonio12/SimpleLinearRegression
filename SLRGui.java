package examples.slr;
import jade.core.AID;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SLRGui extends JFrame {
    private SLRAgent myAgent;
    private JTextField valuePredictField;

    SLRGui(SLRAgent a) {
        super(a.getLocalName());
        myAgent = a;
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 2));
		p.add(new JLabel("x Value:"));
        valuePredictField = new JTextField(15);
        p.add(valuePredictField);
        getContentPane().add(p, BorderLayout.CENTER);
        JButton addButton = new JButton("Predecir");

        addButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					String valuePredict = valuePredictField.getText().trim();
					myAgent.addValueToPredict(Double.parseDouble(valuePredict));
					valuePredictField.setText("");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(SLRGui.this, "Valores inválidos "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		} );
        p = new JPanel();
		p.add(addButton);
		getContentPane().add(p, BorderLayout.SOUTH);

		addWindowListener(new	WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				myAgent.doDelete();
			}
		} );
		
		setResizable(false);
    }

    public void showGui() {
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
		super.setVisible(true);
	}	
}