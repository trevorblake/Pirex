package Display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

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
import javax.swing.JFileChooser;
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

import Data.Doc;

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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.ProcessHandle.Info;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Display {

	private JFrame frmPirex;
	JTabbedPane tabbedPane;
	private JTextField textField;
	private JTextField textFieldTextFile;
	private JTextField textFieldTitle;
	private JTextField textFieldAuthor;
	JTextArea textFieldScroll = new JTextArea();
	private int index = 0;
	private Timer timer;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JTextArea summary;
	
	private JFileChooser fc = new JFileChooser();
	private ArrayList<String> loadInfo = new ArrayList<>();
	private ArrayList<Doc> docs = new ArrayList<>();
	

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
		
		docs.add(new Doc("Monty Python", "Trevor Blake", "00:09 11-16-2021"));
		docs.add(new Doc("Star Wars", "Trevor Blake", "00:09 11-16-2021"));
		frmPirex = new JFrame();
		frmPirex.setResizable(true);
		frmPirex.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Aman Singh\\git\\Final-Project\\Pirex\\images\\p.png"));
		frmPirex.getContentPane().setBackground(Color.WHITE);
		frmPirex.setBackground(new Color(0, 0, 0));
		frmPirex.setForeground(Color.WHITE);
		frmPirex.setBounds(100, 100, 896, 798);
		frmPirex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPirex.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
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
		
		JScrollPane summarizeScrollPane = new JScrollPane();
		summarizeScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		summarizeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		summarizeScrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 4));
		GroupLayout gl_summarize = new GroupLayout(summarize);
		gl_summarize.setHorizontalGroup(
			gl_summarize.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_summarize.createSequentialGroup()
					.addGap(22)
					.addComponent(summarizeScrollPane, GroupLayout.PREFERRED_SIZE, 827, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_summarize.setVerticalGroup(
			gl_summarize.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_summarize.createSequentialGroup()
					.addGap(77)
					.addComponent(summarizeScrollPane, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		
		summary = new JTextArea();
		summary.setWrapStyleWord(true);
		summary.setLineWrap(true);
		summary.setEditable(false);
		summarizeScrollPane.setViewportView(summary);
		summarize.setLayout(gl_summarize);
		summary.setText(summaryText(docs));
		summary.setCaretPosition(0);
		
		
		
		//Code for "Load Documents" page



		JPanel load = new JPanel();
		load.setForeground(Color.WHITE);
		load.setBorder(null);
		load.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/ld iconr.png"), load, "Load Documents Section");
		
		JLabel lblTextFile = new JLabel("Text File");
		lblTextFile.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textFieldTextFile = new JTextField();
		textFieldTextFile.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAuthor.setForeground(new Color(0, 0, 0));
		

		
		
		JScrollPane scrollPaneLoadState = new JScrollPane();
		scrollPaneLoadState.setViewportView(textFieldScroll);
		
		JButton btnBrowse = new JButton("BROWSE");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int a = fc.showSaveDialog(null);
				
				if (a == JFileChooser.APPROVE_OPTION)
				{
					textFieldTextFile.setText(fc.getSelectedFile().getAbsolutePath());
				}
			}
		});
		
		
		JButton btnProcess = new JButton("PROCESS");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				processing();
			}
		});
		
		textFieldAuthor = new JTextField();
		textFieldAuthor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
		        if (e.getKeyCode() == KeyEvent.VK_ENTER)
		        {
				 
		        	processing();
		        }
			}
		});
		textFieldAuthor.setColumns(10);
		
		GroupLayout gl_load = new GroupLayout(load);
		gl_load.setHorizontalGroup(
			gl_load.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_load.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_load.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneLoadState, GroupLayout.PREFERRED_SIZE, 805, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_load.createSequentialGroup()
							.addGroup(gl_load.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTextFile, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_load.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldTextFile, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_load.createSequentialGroup()
									.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblAuthor)
									.addGap(28)
									.addComponent(textFieldAuthor, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)))
							.addGap(18, 19, Short.MAX_VALUE)
							.addGroup(gl_load.createParallelGroup(Alignment.LEADING)
								.addComponent(btnProcess, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
								.addComponent(btnBrowse, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))))
					.addGap(33))
		);
		gl_load.setVerticalGroup(
			gl_load.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_load.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_load.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTextFile)
						.addComponent(textFieldTextFile, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowse, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_load.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnProcess, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldAuthor, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAuthor))
					.addGap(100)
					.addComponent(scrollPaneLoadState, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(123, Short.MAX_VALUE))
		);
		

		load.setLayout(gl_load);

		tabbedPane.setBackgroundAt(2, Color.WHITE);
		
		

//Code for "Help" page
					

		JPanel help = new JPanel();
		help.setForeground(Color.WHITE);
		help.setBorder(null);
		help.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/help iconr.png"), help, "Need Help?");
		tabbedPane.setEnabledAt(3, true);
		tabbedPane.setDisabledIconAt(3, new ImageIcon("images/help icong.jpg"));
		tabbedPane.setBackgroundAt(3, Color.WHITE);
		
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
		


		
//Code for "Search Documents" page

		JPanel search = new JPanel();
		search.setForeground(Color.WHITE);
		search.setBorder(null);
		search.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/sea iconr.png"), search, "Search For Documents");
		tabbedPane.setEnabledAt(4, true);
		tabbedPane.setBackgroundAt(4, Color.WHITE);
		
		JButton btnNewButton_1 = new JButton("CLEAR\r\n");
		btnNewButton_1.setBounds(718, 93, 94, 23);
		
		textField_3 = new JTextField();
		textField_3.setBounds(108, 89, 604, 30);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(62, 141, 630, 204);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(33, 388, 813, 325);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton btnNewButton_2 = new JButton("EDIT\r\n");
		btnNewButton_2.setBounds(718, 212, 94, 23);
		
		JButton btnNewButton_3 = new JButton("DELETE");
		btnNewButton_3.setBounds(718, 270, 94, 23);
		
		JLabel lblNewLabel = new JLabel("Query:");
		lblNewLabel.setBounds(44, 93, 45, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Retrieved Document:");
		lblNewLabel_1.setBounds(33, 371, 138, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 11, 120, 43);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Aman Singh\\git\\Final-Project\\Pirex\\images\\pirex.png"));
		search.setLayout(null);
		search.add(lblNewLabel);
		search.add(lblNewLabel_1);
		search.add(scrollPane_1);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		search.add(textField_3);
		search.add(btnNewButton_3);
		search.add(btnNewButton_1);
		search.add(btnNewButton_2);
		search.add(scrollPane_2);
		
		JTextArea textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);
		search.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(33, 65, 813, 295);
		search.add(panel);

	}

	public void processing()
	{
		String file = textFieldTextFile.getText();
		String title = textFieldTitle.getText();
		String author = textFieldAuthor.getText();
		String date = new SimpleDateFormat("HH:mm MM-dd-yyy").format(new Date());
		try {
	    	   File a = new File("PirexData/" + title + ".txt");
	    	   a.createNewFile();
	    	   copy(new File(file), a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		docs.add(new Doc(title, author, date));
		textFieldScroll.setText("");
		loadInfo.add("File: ");
		loadInfo.add(file);
		loadInfo.add("\r\nTitle: ");
		loadInfo.add(title);
		loadInfo.add("\r\nAuthor: ");
		loadInfo.add(author);
		loadInfo.add("\r\nDate Uploaded: ");
		loadInfo.add(date);
		info(loadInfo);
		loadTimer(loadInfo);
		summary.setText(summaryText(docs));
		summary.setCaretPosition(0);
	}
	
	private static void copy(File source, File dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;

	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);

	        int length;
	        while ((length = is.read()) > 0) {
	            os.write(length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }
	}
	
	public void load()
	{
		
	}
	
	public String summaryText(ArrayList<Doc> docs)
	{
		String s = "";
		for(int i = 0; i < docs.size(); i++)
		{
			s+= docs.get(i).toString();
		}
		
		return s;
	}
	
	public void loadTimer(ArrayList<String> loadInfo)
	{
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent av) {
				if (index < loadInfo.size())
				{
					textFieldScroll.append(loadInfo.get(index));
					index++;
				}
				else
				{
				timer.stop();

				}
			}
		};
		timer = new Timer(100, actionListener);
		timer.setInitialDelay(5);
		timer.start();
	}
	
	public void info(ArrayList<String> loadInfo)
	{
    	loadInfo.add("\r\nUploading Document To Pirex Database");
    	addDots(2);
    	loadInfo.add(".\r\n");
    	addDots(21);
    	loadInfo.add("\r\n" + loadInfo.get(3) + " Uploaded Successfully!");
	}
	
	public void addDots(int x)
	{
		for (int i = 0; i < x; i++)
		{
			loadInfo.add(".");
		}
	}
}