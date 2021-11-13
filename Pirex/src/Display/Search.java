package Display;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class Search extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtPleaseEnterYour;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Search() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\amanj\\git\\Final-Project\\Pirex\\images\\p.png"));
		setBackground(UIManager.getColor("Button.disabledShadow"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\amanj\\git\\Final-Project\\Pirex\\images\\pirex.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 122, 49);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(53, 141, 356, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(164, 189, 137, 37);
		contentPane.add(btnNewButton);
		
		txtPleaseEnterYour = new JTextField();
		txtPleaseEnterYour.setBackground(UIManager.getColor("CheckBox.light"));
		txtPleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPleaseEnterYour.setText("Please Enter Your Search Below:");
		txtPleaseEnterYour.setBounds(112, 93, 232, 37);
		contentPane.add(txtPleaseEnterYour);
		txtPleaseEnterYour.setColumns(10);
	}
}
