import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Frame1 {

	private JFrame frame;
	private JTextField txtField;
	private JLabel txtFieldLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton messageButton = new JButton("Hello");
		messageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// JOptionPane.showMessageDialog(null, "bello!!!");

			}
		});
		messageButton.setBounds(183, 176, 89, 23);
		frame.getContentPane().add(messageButton);

		txtField = new JTextField();
		txtField.setBounds(233, 74, 86, 20);
		frame.getContentPane().add(txtField);
		txtField.setColumns(10);

		txtFieldLabel = new JLabel("Message");
		txtFieldLabel.setBounds(140, 77, 46, 14);
		frame.getContentPane().add(txtFieldLabel);
	}
}
