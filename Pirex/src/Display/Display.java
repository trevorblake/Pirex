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
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
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
import javax.swing.ListModel;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.ProcessHandle.Info;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Display {

	private JFrame frmPirex;
	JTabbedPane tabbedPane;
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
	private DefaultListModel<String> model = new DefaultListModel<String>();
	private JList<String> list = new JList<String>(model);
	//private JOptionPane deleteOption = new JOptionPane();
	

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

		load();
		
		frmPirex = new JFrame();
		frmPirex.setTitle("Pirex");
		frmPirex.setResizable(false);
		frmPirex.setIconImage(Toolkit.getDefaultToolkit().getImage("images/p.png"));
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
		welcomeText.setBounds(113, 178, 650, 97);
		welcome.add(welcomeText);
		


		
//Code for "Search Documents" page

		JPanel search = new JPanel();
		search.setForeground(Color.WHITE);
		search.setBorder(null);
		search.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/sea iconr.png"), search, "Search For Documents");
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		
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
		scrollPane_2.setBounds(33, 388, 813, 311);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton btnNewButton_2 = new JButton("EDIT\r\n");
		btnNewButton_2.setBounds(718, 212, 94, 23);
		
		JButton btnNewButton_3 = new JButton("DELETE");
		btnNewButton_3.setBounds(718, 270, 94, 23);
		
		//String[] arr = {docs.get(0).shortForm("coconut")};
		//model.addElement(arr[0]);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteFile();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Query:");
		lblNewLabel.setBounds(44, 93, 45, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Retrieved Document:");
		lblNewLabel_1.setBounds(33, 371, 138, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		search.setLayout(null);
		search.add(lblNewLabel);
		search.add(lblNewLabel_1);
		search.add(scrollPane_1);
		
		String[] arr = {docs.get(1).shortForm("He became so")};
		model.addElement(arr[0]);
		//JList list = new JList(arr);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane_1.setViewportView(list);
		search.add(textField_3);
		search.add(btnNewButton_3);
		search.add(btnNewButton_1);
		search.add(btnNewButton_2);
		search.add(scrollPane_2);
		
		JTextArea textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(33, 65, 813, 295);
		search.add(panel);
		
		
		
		//Code for "Load Documents" page



		JPanel load = new JPanel();
		load.setForeground(Color.WHITE);
		load.setBorder(null);
		load.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/ld iconr.png"), load, "Load Documents Section");
		
				tabbedPane.setBackgroundAt(2, Color.WHITE);
		
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

				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
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
		
// Code for " Summarize Documents" page

		JPanel summarize = new JPanel();
		summarize.setForeground(Color.WHITE);
		summarize.setBorder(null);
		summarize.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/summ iconr1.png"), summarize, "Summarized Document View");
		tabbedPane.setBackgroundAt(3, Color.WHITE);
		
		JScrollPane summarizeScrollPane = new JScrollPane();
		summarizeScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		summarizeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		summarizeScrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 4));
		
		JButton btnNewButton = new JButton("Export PirexData To A Directory");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int a = fc.showSaveDialog(null);
				
				if (a == JFileChooser.APPROVE_OPTION)
				{
					try {
						copyDirectory(new File("PirexData"), new File(fc.getSelectedFile().getAbsoluteFile()+ "/PirexDataCopy"));
						JOptionPane.showMessageDialog(null, "PirexData has been copied to " 
									+ fc.getSelectedFile().getAbsoluteFile(), "Success!", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		GroupLayout gl_summarize = new GroupLayout(summarize);
		gl_summarize.setHorizontalGroup(
			gl_summarize.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_summarize.createSequentialGroup()
					.addGap(22)
					.addComponent(summarizeScrollPane, GroupLayout.PREFERRED_SIZE, 827, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
				.addGroup(gl_summarize.createSequentialGroup()
					.addContainerGap(363, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(325))
		);
		gl_summarize.setVerticalGroup(
			gl_summarize.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_summarize.createSequentialGroup()
					.addGap(25)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
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
		
		

//Code for "Help" page
					

		JPanel help = new JPanel();
		help.setForeground(Color.WHITE);
		help.setBorder(null);
		help.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/help iconr.png"), help, "Need Help?");
		tabbedPane.setEnabledAt(4, true);
		tabbedPane.setDisabledIconAt(4, new ImageIcon("images/help icong.jpg"));
		tabbedPane.setBackgroundAt(4, Color.WHITE);
		
		//Scroll pane that displays search topic results when "Search Topics" button is clicked
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JLabel lblNewLabel_2 = new JLabel("About / Frequently Asked Questions");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		GroupLayout gl_help = new GroupLayout(help);
		gl_help.setHorizontalGroup(
			gl_help.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_help.createSequentialGroup()
					.addGap(45)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
					.addGap(49))
				.addGroup(gl_help.createSequentialGroup()
					.addGap(54)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(444, Short.MAX_VALUE))
		);
		gl_help.setVerticalGroup(
			gl_help.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_help.createSequentialGroup()
					.addContainerGap(96, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
					.addGap(134))
		);
		
		JTextArea txtrPirexIsA = new JTextArea();
		txtrPirexIsA.setWrapStyleWord(true);
		txtrPirexIsA.setText("           Pirex is a document retrieval program! It includes the following features: \r\n\r\n\t                              Load Documents\r\n\t                         Edit and Delete Documents\r\n\t                            Search for Documents \r\n\t                           Included Summary Page\r\n\r\n               Pirex was designed and developed by the Scrum Team, We Don't Byte!\r\n\r\n\t\t\t    Credit to the members included below:\r\n                                      Victoria Larson\r\n                                      Oksana Daniliuk\r\n                                        Trevor Blake\r\n                                        Justin Roome\r\n                                       Fernando Ramos\r\n                                        Hartej Singh\r\n                                       Amanjot Singh\r\n                                      Ganesh Renukunta\r\n\r\n----------------------------------------------------------------------------------------------\r\n\r\n* How to SEARCH For Documents in Pirex: *\r\n\r\nTo search for a document in Pirex, follow the following steps:\r\n\r\n1. Click the \"SEARCH\" Navigational Tab at the top of the screen.\r\n\r\n2. Type the title or the author of the desired document in the text box next to \"Query\".\r\n\r\n3. Press \"Enter\" on your keyboard.\r\n\r\n4. A list of documents with that same author or similar title will show up in the display text box.\r\n\r\nFor a New Search:\r\n\r\n1. Press the \"CLEAR\" button at the top of the page next to the fillable search box.\r\n\r\n----------------------------------------------------------------------------------------------\r\n\r\n* How to LOAD Documents into Pirex: *\r\n\r\nTo load a document in Pirex, follow the following steps:\r\n\r\n1. Click the \"LOAD\" Navigational Tab at the top of the screen.\r\n\r\n2. Click the \"BROWSE\" button towards the top of the screen, beneath the Navigational Tabs.\r\n\r\n3. A file explorer window will appear. Locate and select the desired text document.\r\n\r\n4. Click \"Save\".\r\n\r\n5. The filepath of the selected document should now appear in the text box next to the \"BROWSE\" button.\r\n\r\n6. Type the title and author of the selected document into the respective fillable text boxes.\r\n\r\n7. Click the \"PROCESS\" button, next to the \"Author\" text box.\r\n\r\n8. The display text box at the bottom half of the window will show the document being processed.\r\n\r\n9. Once the display text box shows the words \"Uploaded Successfully!\", the file is now in the Pirex database.\r\n\r\n----------------------------------------------------------------------------------------------\r\n\r\n* How to EDIT Documents in Pirex: *\r\n\r\nTo edit a document in Pirex, follow the following steps:\r\n\r\n1. Make sure you've logged into Pirex with your Admin credentials to gain Admin privileges.\r\n\r\n2. Click the \"SEARCH\" tab at the top of the screen.\r\n\r\n3. Type the title or the author of the desired document in the text box next to \"Query\".\r\n\r\n4. Press \"Enter\" on your keyboard.\r\n\r\n5. A list of documents with that same author or similar title will show up in the display text box.\r\n\r\n6. Select the desired document from the search results by clicking on it.\r\n\r\n7. The document will be opned in your default text editor\r\n\r\n8. Make your changes.\r\n\r\nTo Save the Changes in Pirex:\r\n\r\n1. In your text editor, click \"File\".\r\n\r\n2. Click \"Save\", not \"Save As\".\r\n\r\n3. The document will be updated in Pirex. \r\n\r\n----------------------------------------------------------------------------------------------\r\n\r\n* How to REMOVE Documents in Pirex: *\r\n\r\nTo remove document from Pirex, follow the following steps:\r\n\r\n1. Make sure you've logged into Pirex with your Admin credentials to gain Admin privileges.\r\n\r\n2. Click the \"SEARCH\" tab at the top of the screen.\r\n\r\n3. Type the title or the author of the desired document in the text box next to \"Query\".\r\n\r\n4. Press \"Enter\" on your keyboard.\r\n\r\n5. A list of documents with that same author or similar title will show up in the display text box.\r\n\r\n6. Select the desired document from the search results by clicking on it.\r\n\r\n7. Click the \"DELETE\" button to the right of the search results box, under the \"EDIT\" button.\r\n\r\n8. The document you had selected will now be removed from the Pirex database, and will no longer show up in search results.\r\n\r\n----------------------------------------------------------------------------------------------\r\n");
		txtrPirexIsA.setEditable(false);
		txtrPirexIsA.setLineWrap(true);
		scrollPane.setViewportView(txtrPirexIsA);
		txtrPirexIsA.setCaretPosition(0);
		help.setLayout(gl_help);

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
		save();
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
	
	public void copyDirectory(File sourceLocation , File targetLocation)
		    throws IOException {

		        if (sourceLocation.isDirectory()) {
		            if (!targetLocation.exists()) {
		                targetLocation.mkdir();
		            }

		            String[] children = sourceLocation.list();
		            for (int i=0; i<children.length; i++) {
		                copyDirectory(new File(sourceLocation, children[i]),
		                        new File(targetLocation, children[i]));
		            }
		        } else {

		            InputStream in = new FileInputStream(sourceLocation);
		            OutputStream out = new FileOutputStream(targetLocation);

		            int len;
		            while ((len = in.read()) > 0) {
		                out.write(len);
		            }
		            in.close();
		            out.close();
		        }
		    }
	
	public void load()
	{
		File documents = new File("PirexData/documents.txt");
		Scanner d;
		try {
			d = new Scanner(documents);
			
			while (d.hasNextLine())
			{
				String raw = d.nextLine();
				StringTokenizer st = new StringTokenizer(raw, "*");
				String title = st.nextToken();
				String author = st.nextToken();
				String date = st.nextToken();
				Path path = Paths.get("PirexData/" + title + ".txt");			
				if(Files.exists(path)) 
				{ 
					docs.add(new Doc(title, author, date));
				}

			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void save()
	{
		FileWriter myWriter;
		try {
			myWriter = new FileWriter("PirexData/documents.txt", false);
			
			for(int i = 0; i < docs.size(); i++)
			{
				myWriter.write(docs.get(i).getTitle() + "*" + docs.get(i).getAuthor() + "*" + docs.get(i).getDate());
				myWriter.write(System.getProperty( "line.separator" ));
			}
			
			myWriter.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String summaryText(ArrayList<Doc> docs)
	{
		String s = "";
		for(int i = 0; i < docs.size(); i++)
		{
			s+= docs.get(i).toString();
			
			if (i < docs.size() - 1)
			{
				s+=  "--------------------------------------------------"
					+ "-------------------------------------------------"
				    + "\r\n\r\n\r\n";
			}
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

	public void deleteFile() {
		//File file = fc.getSelectedFile();
		int selectedIndex = list.getSelectedIndex();
		File file = new File(docs.get(selectedIndex).getLocation());
		if (selectedIndex != -1) {
			int choice = JOptionPane.showConfirmDialog(frmPirex,"Are you sure you want to delete?", "Select an Option" , JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
			if (choice == 0) {
				model.remove(selectedIndex);
				file.delete();
				save();
				JOptionPane.showMessageDialog(frmPirex, "Document successfully deleted");
			}
			else {
				return;
			}
		}
	}
}

