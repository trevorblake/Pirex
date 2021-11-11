package Display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import java.awt.GridLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.Box;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Dimension;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.DropMode;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Display {

	private JFrame frmPirex;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display window = new Display();
					window.frmPirex.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPirex = new JFrame();
		frmPirex.setResizable(false);
		frmPirex.setIconImage(Toolkit.getDefaultToolkit().getImage("images/p.png"));
		frmPirex.getContentPane().setBackground(Color.WHITE);
		frmPirex.setBackground(new Color(0, 0, 0));
		frmPirex.setForeground(Color.WHITE);
		frmPirex.setBounds(100, 100, 896, 798);
		frmPirex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPirex.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		tabbedPane.setBounds(0, 0, 797, 800);

		tabbedPane.setBounds(0, 0, 880, 802);

		frmPirex.getContentPane().add(tabbedPane);
		
// Code for "Welcome Page"
		JPanel welcome = new JPanel();
		welcome.setBorder(null);
		welcome.setBackground(Color.WHITE);
		welcome.setForeground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/pirex.png"), welcome, null);
		tabbedPane.setDisabledIconAt(0, new ImageIcon("images/pirex.png"));
		tabbedPane.setEnabledAt(0, false);
		welcome.setLayout(null);
		
		JTextPane welcomeText = new JTextPane();
		welcomeText.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		welcomeText.setText("                      Welcome to Pirex\r\nPlease click on one of the tabs above to begin");
		welcomeText.setBounds(69, 179, 650, 97);
		welcome.add(welcomeText);
		
// Code for " Summarize Documents" page

		JPanel summarize = new JPanel();
		summarize.setForeground(Color.WHITE);
		summarize.setBorder(null);
		summarize.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/summ iconr1.png"), summarize, "Summarized Document View");
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		summarize.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane summarizeScrollPane = new JScrollPane();
		summarizeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		summarizeScrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 3));
		summarize.add(summarizeScrollPane);
		
		JTextArea summarizeTextArea = new JTextArea();
		summarizeTextArea.setForeground(Color.WHITE);
		summarizeScrollPane.setViewportView(summarizeTextArea);
		
		//Code for "Load Documents" page


		JPanel load = new JPanel();
		load.setForeground(Color.WHITE);
		load.setBorder(null);
		load.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/ld iconr.png"), load, "Load Documents Section");
		tabbedPane.setBackgroundAt(2, Color.WHITE);
		load.setLayout(new GridLayout(1, 0, 0, 0));
		
//Code for "Search Documents" page

		JPanel search = new JPanel();
		search.setForeground(Color.WHITE);
		search.setBorder(null);
		search.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/sea iconr.png"), search, "Search For Documents");
		tabbedPane.setBackgroundAt(3, Color.WHITE);
		search.setLayout(new GridLayout(1, 0, 0, 0));


						

		
// Code for "Help Page"

		JPanel help = new JPanel();
		help.setForeground(Color.WHITE);
		help.setBorder(null);
		help.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/help iconr.png"), help, "Need Help?");
		tabbedPane.setEnabledAt(4, true);
		tabbedPane.setDisabledIconAt(4, new ImageIcon("images/help icong.jpg"));
		tabbedPane.setBackgroundAt(4, Color.WHITE);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		//"Search" button next to fillable text box
		JButton btnNewButton = new JButton("Search Topics");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		//Label next to fillable text box
		JTextPane txtpnEnterTheTopic = new JTextPane();
		txtpnEnterTheTopic.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnEnterTheTopic.setText("Enter the topic you would like help with:");
		
		//Scroll pane that displays search topic results when "Search Topics" button is clicked
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//Creates hyperlink with label "About" page. This will be a pop-up window.
		JLabel hyperlink = new JLabel("About Pyrex");
		hyperlink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				hyperlink.setText("<html><a href=''>About Pyrex</a></html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hyperlink.setText("About Pyrex");
			}
		});
		hyperlink.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hyperlink.setForeground(new Color(51, 153, 255));
		hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Will become link that generates a window pop-up, or will display text in the scrollpane display box
		JLabel howToSearch_hyperlink = new JLabel("How to search for documents");
		howToSearch_hyperlink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				howToSearch_hyperlink.setText("<html><a href=''>How to search for documents</a></html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				howToSearch_hyperlink.setText("How to search for documents");
			}
		});
		howToSearch_hyperlink.setForeground(new Color(51, 153, 255));
		howToSearch_hyperlink.setFont(new Font("Tahoma", Font.PLAIN, 14));
		howToSearch_hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Will become link that generates a window pop-up, or will display text in the scrollpane display box
		JLabel howToLoad_hyperlink = new JLabel("How to load documents");
		howToLoad_hyperlink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				howToLoad_hyperlink.setText("<html><a href=''>How to load documents</a></html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				howToLoad_hyperlink.setText("How to load documents");
			}
		});
		howToLoad_hyperlink.setForeground(new Color(51, 153, 255));
		howToLoad_hyperlink.setFont(new Font("Tahoma", Font.PLAIN, 14));
		howToLoad_hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		GroupLayout gl_help = new GroupLayout(help);
		gl_help.setHorizontalGroup(
			gl_help.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_help.createSequentialGroup()
					.addGroup(gl_help.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_help.createSequentialGroup()
							.addGap(45)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE))
						.addGroup(gl_help.createSequentialGroup()
							.addGap(26)
							.addComponent(txtpnEnterTheTopic, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
							.addComponent(btnNewButton)))
					.addGap(49))
				.addGroup(gl_help.createSequentialGroup()
					.addGap(95)
					.addGroup(gl_help.createParallelGroup(Alignment.LEADING)
						//relevant to "About Pyrex" hyperlink	
						.addComponent(hyperlink, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
						//
						.addComponent(howToSearch_hyperlink, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
						.addComponent(howToLoad_hyperlink, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
					.addContainerGap(545, GroupLayout.PREFERRED_SIZE))
		);
		
		gl_help.setVerticalGroup(
			gl_help.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_help.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_help.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_help.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton))
						.addComponent(txtpnEnterTheTopic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					//relevant to "About Pyrex" hyperlink
					.addGap(58)
					.addComponent(hyperlink, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					//
					.addGap(18)
					.addComponent(howToSearch_hyperlink)
					.addGap(18)
					.addComponent(howToLoad_hyperlink)
					.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addGap(134))
		);
		help.setLayout(gl_help);
		

	}
}
