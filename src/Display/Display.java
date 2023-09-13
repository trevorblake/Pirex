package Display;

import Pirex.Doc;
import org.apache.tika.exception.TikaException;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Timer;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.JarURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class Display implements DocumentListener {

    final static Color  HILIT_COLOR = Color.LIGHT_GRAY;
    final static Color  ERROR_COLOR = Color.PINK;
    final static String CANCEL_ACTION = "cancel-search";
	public static int privilege = 1;
    final Highlighter hilit;
    final Highlighter.HighlightPainter painter;
	public JFrame pirex;
	public JTabbedPane tabs;
	public JTextField fileTextField;
	public JTextField titleTextField;
	public JTextField authorTextField;
	public JTextArea loadText = new JTextArea();
	public JTextArea summary = new JTextArea();
	public Timer timer;
	public JTextField query;
	public JFileChooser fc = new JFileChooser();
	public JFileChooser mfc = new JFileChooser();
	public ArrayList<String> loadInfo = new ArrayList<>();
	public ArrayList<Doc> docs = new ArrayList<>();
	public DefaultListModel<String> model = new DefaultListModel<String>();
	public JList<String> queryList = new JList<String>(model);
	public int selectedIndex = queryList.getSelectedIndex();
	public ArrayList<Doc> keyDocsList = new ArrayList<Doc>();
	public String[] keyDocsArrText;
	public Doc[] keyDocsArr;
	public boolean timerRunning;
	public int choice;
	public int nextIndex;
	public int currentIndex;
	public int index;
	File jarDir = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
	File dir = new File(jarDir.getParentFile().getAbsolutePath());
	File dataDir;
	String dataDirString;
	JTextArea docTextArea = new JTextArea();
	public int loadIndex = 0;

	/**
	 * Create the application.
	 */
	public Display(){
		initialize();
        hilit = new DefaultHighlighter();
        painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);
        docTextArea.setHighlighter(hilit);

	}

	public static void copy(File source, File dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;

	    if(source != null)
	    {
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
	}

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public void createGUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		EventQueue.invokeLater(new Runnable() {
			public void run() {

					privilege = Login.privilege;
					Display window = new Display();
					window.pirex.setVisible(true);


			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		boolean containsData = false;

		for(String s : dir.list())
            if (s.equals("Data")) {
                containsData = true;
                break;
            }

		if(!containsData) {
			final URL configFolderURL = getClass().getResource("/Data");

			try {
				copyJarResourcesRecursively(dir.toPath(), (JarURLConnection) configFolderURL.openConnection());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		dataDir = new File(jarDir.getParentFile().getAbsolutePath() + File.separator + "Data");
		dataDirString = dataDir.getAbsolutePath() + File.separator;

		load();

		pirex = new JFrame();
		pirex.setTitle("Pirex");
		pirex.setResizable(false);
		pirex.setIconImage(Toolkit.getDefaultToolkit().getImage("/Data/Images/p.png"));
		pirex.getContentPane().setBackground(Color.WHITE);
		pirex.setBackground(new Color(0, 0, 0));
		pirex.setForeground(Color.WHITE);
		pirex.setBounds(100, 100, 896, 798);
		pirex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pirex.getContentPane().setLayout(null);

		tabs = new JTabbedPane(JTabbedPane.TOP);
		tabs.setBackground(Color.WHITE);
		tabs.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabs.setBounds(0, 0, 797, 800);
		tabs.setBounds(0, 0, 880, 802);
		pirex.getContentPane().add(tabs);

// Code for "Welcome Page"

		JPanel welcome = new JPanel();
		welcome.setBorder(null);
		welcome.setBackground(Color.WHITE);
		welcome.setForeground(Color.WHITE);
		tabs.addTab("", new ImageIcon(dataDirString + "Images/pirex.png"), welcome, null);
		tabs.setDisabledIconAt(0, new ImageIcon(dataDirString + "Images/pirex.png"));
		tabs.setEnabledAt(0, false);
		welcome.setLayout(null);

		JTextPane welcomeText = new JTextPane();
		welcomeText.setEditable(false);
		welcomeText.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		welcomeText.setText("                      Welcome to Pirex\r\nPlease click on one of the tabs above to begin");
		welcomeText.setBounds(113, 178, 650, 97);
		welcome.add(welcomeText);

//Code for "Search Data.Documents" page

		JPanel search = new JPanel();
		search.setForeground(Color.WHITE);
		search.setBorder(null);
		search.setBackground(Color.WHITE);
		tabs.addTab("", new ImageIcon(dataDirString + "Images/sea iconr.png"), search, "Search For Data.Documents");
		tabs.setEnabledAt(1, true);
		tabs.setBackgroundAt(1, Color.WHITE);

		query = new JTextField();
		query.getDocument().addDocumentListener(this);
		query.setBounds(108, 89, 604, 30);
		query.setColumns(10);

		JScrollPane queryScroll = new JScrollPane();
		queryScroll.setBounds(62, 141, 630, 204);
		queryScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		queryScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		JScrollPane docScroll = new JScrollPane();
		docScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		docScroll.setBounds(33, 388, 813, 311);
		docScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		docTextArea.setWrapStyleWord(true);
		docTextArea.setLineWrap(true);
		docTextArea.setEditable(false);
		docScroll.setViewportView(docTextArea);

		JLabel lblNewLabel = new JLabel("Query:");
		lblNewLabel.setBounds(44, 93, 45, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_1 = new JLabel("Retrieved Document:");
		lblNewLabel_1.setBounds(33, 371, 138, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		search.setLayout(null);
		search.add(lblNewLabel);
		search.add(lblNewLabel_1);
		search.add(queryScroll);

		queryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JButton clearButton = new JButton("CLEAR\r\n");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				query.setText("");
				search();
				query.requestFocus();
			}
		});
		clearButton.setBounds(718, 93, 94, 23);

		JButton openButton = new JButton("OPEN\r\n");
		openButton.setBounds(718, 154, 94, 23);
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(privilege == 0)
				{
					JOptionPane.showMessageDialog(pirex, "Only administrators can open documents!");
				}

				else
				{
					try {
						openFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		JButton deleteButton = new JButton("DELETE");
		deleteButton.setBounds(718, 212, 94, 23);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(privilege == 0)
				{
					JOptionPane.showMessageDialog(pirex, "Only administrators can delete documents!");
				}

				else
				{
					deleteFile();
				}
			}
		});

		JButton nextButton = new JButton("NEXT");
		nextButton.setBounds(718, 270, 94, 23);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				docTextArea.setText(keyDocsArr[queryList.getSelectedIndex()].toString());
				docTextArea.setCaretPosition(0);
				String s = query.getText().toLowerCase();
				String content = docTextArea.getText().toLowerCase();
				nextIndex = index + s.length();
				index = content.indexOf(s, nextIndex);

				if(index == -1) {
					index = content.indexOf(s);
				}
				if (index >= 0) {
					try {
						int end = index + s.length();
						hilit.addHighlight(index, end, painter);
						docTextArea.setCaretPosition(end);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		queryList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (queryList.getSelectedIndex() == -1)
				{
					openButton.setEnabled(false);
					deleteButton.setEnabled(false);
					nextButton.setEnabled(false);
					docTextArea.setText("");
				}

				else
				{
					openButton.setEnabled(true);
					deleteButton.setEnabled(true);
					nextButton.setEnabled(true);
					docTextArea.setText(keyDocsArr[queryList.getSelectedIndex()].toString());
					docTextArea.setCaretPosition(0);
					String s = query.getText().toLowerCase();
					String content = docTextArea.getText().toLowerCase();
					index = content.indexOf(s);

					if (index >= 0) {
			            try {
			                int end = index + s.length();
			                hilit.addHighlight(index, end, painter);
			                docTextArea.setCaretPosition(end);
			            } catch (BadLocationException e1) {
			                e1.printStackTrace();
			            }
					}
				}
			}
		});

		queryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		queryScroll.setViewportView(queryList);
		search.add(query);
		search.add(deleteButton);
		search.add(clearButton);
		search.add(openButton);
		search.add(nextButton);
		search.add(docScroll);
		JPanel queryPanel = new JPanel();
		queryPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		queryPanel.setBackground(Color.WHITE);
		queryPanel.setBounds(33, 65, 813, 295);
		search.add(queryPanel);

		//Code for "Load Data.Documents" page

		JPanel load = new JPanel();
		load.setForeground(Color.WHITE);
		load.setBorder(null);
		load.setBackground(Color.WHITE);
		tabs.addTab("", new ImageIcon(dataDirString + "Images/ld iconr.png"), load, "Load Data.Documents Section");

		tabs.setBackgroundAt(2, Color.WHITE);

		JLabel fileLabel = new JLabel("File");
		fileLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

		fileTextField = new JTextField();
		fileTextField.setColumns(10);

		JLabel titleLabel = new JLabel("Title:");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

		titleTextField = new JTextField();
		titleTextField.setColumns(10);

		JLabel authorLabel = new JLabel("Author:");
		authorLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		authorLabel.setForeground(new Color(0, 0, 0));

		JScrollPane loadScroll = new JScrollPane();
		loadScroll.setViewportView(loadText);

		JButton browseButton = new JButton("BROWSE");
		browseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(privilege == 0)
				{
					JOptionPane.showMessageDialog(pirex, "Only administrators can upload documents!");
				}

				else
				{
					int a = fc.showSaveDialog(null);

					if (a == JFileChooser.APPROVE_OPTION)
					{
						fileTextField.setText(fc.getSelectedFile().getAbsolutePath());
					}
				}
			}
		});

		JButton multDocsButton = new JButton("Want to load multiple files?");

		multDocsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(privilege == 0)
				{
					JOptionPane.showMessageDialog(pirex, "Only administrators can upload documents!");
				}

				else
				{
					mfc.setMultiSelectionEnabled(true);
					int a = mfc.showSaveDialog(null);

					if (a == JFileChooser.APPROVE_OPTION)
					{
						try {
							processingMultDocs(mfc.getSelectedFiles());
						} catch (IOException ex) {
							throw new RuntimeException(ex);
						}
					}
				}
			}
		});

		JButton processButton = new JButton("PROCESS");
		processButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(privilege == 0)
				{
					JOptionPane.showMessageDialog(pirex, "Only administrators can upload documents!");
				}

				else
				{

						try {
							processingSingleDoc();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (TikaException ex) {
                            throw new RuntimeException(ex);
                        }

                }
			}
		});

		authorTextField = new JTextField();
		authorTextField.setColumns(10);

		GroupLayout gl_load = new GroupLayout(load);
		gl_load.setHorizontalGroup(
			gl_load.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_load.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_load.createParallelGroup(Alignment.LEADING)
						.addComponent(loadScroll, GroupLayout.PREFERRED_SIZE, 805, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_load.createSequentialGroup()
							.addGroup(gl_load.createParallelGroup(Alignment.LEADING)
								.addComponent(fileLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_load.createParallelGroup(Alignment.LEADING, false)
								.addComponent(fileTextField, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_load.createSequentialGroup()
									.addComponent(titleTextField, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(authorLabel)
									.addGap(28)
									.addComponent(authorTextField, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)))
							.addGap(18, 19, Short.MAX_VALUE)
							.addGroup(gl_load.createParallelGroup(Alignment.LEADING)
								.addComponent(processButton, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
								.addComponent(browseButton, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))))
					.addGap(33))
		);
		gl_load.setVerticalGroup(
			gl_load.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_load.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_load.createParallelGroup(Alignment.BASELINE)
						.addComponent(fileLabel)
						.addComponent(fileTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(browseButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_load.createParallelGroup(Alignment.BASELINE)
						.addComponent(titleLabel)
						.addComponent(titleTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(processButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(authorTextField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(authorLabel))
					.addGap(100)
					.addComponent(loadScroll, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(123, Short.MAX_VALUE))
		);

		load.setLayout(gl_load);

		multDocsButton.setBounds(340,165,180, 30);
		load.add(multDocsButton);

// Code for " Summarize Data.Documents" page

		JPanel summarize = new JPanel();
		summarize.setForeground(Color.WHITE);
		summarize.setBorder(null);
		summarize.setBackground(Color.WHITE);
		tabs.addTab("", new ImageIcon(dataDirString + "Images/summ iconr1.png"), summarize, "Summarized Document View");
		tabs.setBackgroundAt(3, Color.WHITE);

		JScrollPane summarizeScrollPane = new JScrollPane();
		summarizeScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		summarizeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		summarizeScrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 4));

		JButton exportButton = new JButton("Export PirexData To A Directory");
		exportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(privilege == 0)
				{
					JOptionPane.showMessageDialog(pirex, "Only administrators can upload documents!");
				}

				else
				{
					fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int a = fc.showSaveDialog(null);

					if (a == JFileChooser.APPROVE_OPTION)
					{
						try {
							copyDirectory(new File(dataDirString + "Documents"), new File(fc.getSelectedFile().getAbsoluteFile()+ "/PirexDataCopy"));
							JOptionPane.showMessageDialog(null, "PirexData has been copied to "
										+ fc.getSelectedFile().getAbsoluteFile(), "Success!", JOptionPane.INFORMATION_MESSAGE);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
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
					.addComponent(exportButton)
					.addGap(325))
		);

		gl_summarize.setVerticalGroup(
			gl_summarize.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_summarize.createSequentialGroup()
					.addGap(25)
					.addComponent(exportButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(summarizeScrollPane, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(71, Short.MAX_VALUE))
		);

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
		tabs.addTab("", new ImageIcon(dataDirString + "Images/help iconr.png"), help, "Need Help?");
		tabs.setEnabledAt(4, true);
		tabs.setDisabledIconAt(4, new ImageIcon(dataDirString + "Images/help iconr.png"));
		tabs.setBackgroundAt(4, Color.WHITE);

		JScrollPane helpScroll = new JScrollPane();
		helpScroll.setViewportBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		helpScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		helpScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JLabel aboutLabel = new JLabel("About / Frequently Asked Questions");
		aboutLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

		GroupLayout gl_help = new GroupLayout(help);
		gl_help.setHorizontalGroup(
			gl_help.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_help.createSequentialGroup()
					.addGap(45)
					.addComponent(helpScroll, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
					.addGap(49))
				.addGroup(gl_help.createSequentialGroup()
					.addGap(54)
					.addComponent(aboutLabel, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(444, Short.MAX_VALUE))
		);
		gl_help.setVerticalGroup(
			gl_help.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_help.createSequentialGroup()
					.addContainerGap(96, Short.MAX_VALUE)
					.addComponent(aboutLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(helpScroll, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
					.addGap(134))
		);

		JTextArea helpTextArea = new JTextArea();
		helpTextArea.setWrapStyleWord(true);
		helpTextArea.setText("           Pirex is a document retrieval program! It includes the following features: \r\n\r\n\t                              Load Data.Documents\r\n\t                         Edit and Delete Data.Documents\r\n\t                            Search for Data.Documents \r\n\t                           Included Summary Page\r\n\r\n               Pirex was designed and developed by the Scrum Team, We Don't Byte!\r\n\r\n\t\t\t    Credit to the members included below:\r\n                                      Victoria Larson\r\n                                      Oksana Daniliuk\r\n                                        Trevor Blake\r\n                                        Justin Roome\r\n                                       Fernando Ramos\r\n                                        Hartej Singh\r\n                                       Amanjot Singh\r\n                                      Ganesh Renukunta\r\n\r\n----------------------------------------------------------------------------------------------\r\n\r\n* How to SEARCH For Data.Documents in Pirex: *\r\n\r\nTo search for a document in Pirex, follow the following steps:\r\n\r\n1. Click the \"SEARCH\" Navigational Tab at the top of the screen.\r\n\r\n2. Type the title or the author of the desired document in the text box next to \"Query\".\r\n\r\n3. Press \"Enter\" on your keyboard.\r\n\r\n4. A list of documents with that same author or similar title will show up in the display text box.\r\n\r\nFor a New Search:\r\n\r\n1. Press the \"CLEAR\" button at the top of the page next to the fillable search box.\r\n\r\n----------------------------------------------------------------------------------------------\r\n\r\n* How to LOAD Data.Documents into Pirex: *\r\n\r\nTo load a document in Pirex, follow the following steps:\r\n\r\n1. Click the \"LOAD\" Navigational Tab at the top of the screen.\r\n\r\n2. Click the \"BROWSE\" button towards the top of the screen, beneath the Navigational Tabs.\r\n\r\n3. A file explorer window will appear. Locate and select the desired text document.\r\n\r\n4. Click \"Save\".\r\n\r\n5. The filepath of the selected document should now appear in the text box next to the \"BROWSE\" button.\r\n\r\n6. Type the title and author of the selected document into the respective fillable text boxes.\r\n\r\n7. Click the \"PROCESS\" button, next to the \"Author\" text box.\r\n\r\n8. The display text box at the bottom half of the window will show the document being processed.\r\n\r\n9. Once the display text box shows the words \"Uploaded Successfully!\", the file is now in the Pirex database.\r\n\r\n----------------------------------------------------------------------------------------------\r\n\r\n* How to EDIT Data.Documents in Pirex: *\r\n\r\nTo edit a document in Pirex, follow the following steps:\r\n\r\n1. Make sure you've logged into Pirex with your Admin credentials to gain Admin privileges.\r\n\r\n2. Click the \"SEARCH\" tab at the top of the screen.\r\n\r\n3. Type the title or the author of the desired document in the text box next to \"Query\".\r\n\r\n4. Press \"Enter\" on your keyboard.\r\n\r\n5. A list of documents with that same author or similar title will show up in the display text box.\r\n\r\n6. Select the desired document from the search results by clicking on it.\r\n\r\n7. The document will be opned in your default text editor\r\n\r\n8. Make your changes.\r\n\r\nTo Save the Changes in Pirex:\r\n\r\n1. In your text editor, click \"File\".\r\n\r\n2. Click \"Save\", not \"Save As\".\r\n\r\n3. The document will be updated in Pirex. \r\n\r\n----------------------------------------------------------------------------------------------\r\n\r\n* How to REMOVE Data.Documents in Pirex: *\r\n\r\nTo remove document from Pirex, follow the following steps:\r\n\r\n1. Make sure you've logged into Pirex with your Admin credentials to gain Admin privileges.\r\n\r\n2. Click the \"SEARCH\" tab at the top of the screen.\r\n\r\n3. Type the title or the author of the desired document in the text box next to \"Query\".\r\n\r\n4. Press \"Enter\" on your keyboard.\r\n\r\n5. A list of documents with that same author or similar title will show up in the display text box.\r\n\r\n6. Select the desired document from the search results by clicking on it.\r\n\r\n7. Click the \"DELETE\" button to the right of the search results box, under the \"EDIT\" button.\r\n\r\n8. The document you had selected will now be removed from the Pirex database, and will no longer show up in search results.\r\n\r\n----------------------------------------------------------------------------------------------\r\n");
		helpTextArea.setEditable(false);
		helpTextArea.setLineWrap(true);
		helpScroll.setViewportView(helpTextArea);
		helpTextArea.setCaretPosition(0);
		help.setLayout(gl_help);
	}

	public void processingSingleDoc() throws IOException, TikaException {

		File file = new File(fileTextField.getText());
		String extension = file.getName().substring(file.getName().indexOf('.'));
		String title = titleTextField.getText() + extension;
		String author = authorTextField.getText();
		String date = new SimpleDateFormat("HH:mm MM-dd-yyyy").format(new Date());
		loadIndex = 0;
		loadInfo.clear();

		try
		{
			FileInputStream fs = new FileInputStream(file.getAbsolutePath());
			FileOutputStream os = new FileOutputStream(dataDirString + "Documents/" + title);
			int b;
			while ((b = fs.read()) != -1)
			{
				os.write(b);
			}
			os.close();
			fs.close();
		} catch (Exception E) {
			E.printStackTrace();
		}

		Doc temp = new Doc(title, author, date, dataDirString + "Documents/" + title);

		boolean exists = false;
		for (Doc doc : docs) {
            if (doc.getText().equals(temp.getText())) {
                exists = true;
                break;
            }
		}

		if(exists)
		{
			loadInfo.add("File \"" + title + "\" already exists in the database. \r\n\r\n");
			loadTimer(loadInfo);
		}

		else
		{
			docs.add(temp);
			loadText.setText("");
			loadInfo.add("File: ");
			loadInfo.add(file.getAbsolutePath());
			loadInfo.add("\r\nTitle: ");
			loadInfo.add(title);
			loadInfo.add("\r\nAuthor: ");
			loadInfo.add(author);
			loadInfo.add("\r\nDate Uploaded: ");
			loadInfo.add(date);
			info(loadInfo, title);
			loadTimer(loadInfo);
			summary.setText(summaryText(docs));
			summary.setCaretPosition(0);
			save();
		}
	}
	
	public void processingMultDocs(File[] selectedFiles) throws IOException
	{
		loadIndex = 0;
		loadInfo.clear();

		for(File file: selectedFiles)
		{
			String title = file.getName();
			String author = "N/A";
			String date = new SimpleDateFormat("HH:mm MM-dd-yyyy").format(new Date());

			try
			{
				FileInputStream fs = new FileInputStream(file.getAbsolutePath());
				FileOutputStream os = new FileOutputStream(dataDirString + "Documents/" + title);
				int b;
				while ((b = fs.read()) != -1)
				{
					os.write(b);
				}
				os.close();
				fs.close();
			} catch (Exception E) {
				E.printStackTrace();
			}

			Doc temp = new Doc(title, author, date, dataDirString + "Documents/" + title);
			boolean exists = false;

            for (Doc doc : docs) {
                if (doc.getText().equals(temp.getText())) {
                    exists = true;
                    break;
                }
            }

			if(exists)
			{
				loadInfo.add("File \"" + title + "\" already exists in the database. \r\n\r\n");
				loadTimer(loadInfo);
			}

			else
			{
				docs.add(temp);
				loadText.setText("");
				loadInfo.add("File: ");
				loadInfo.add(file.getAbsolutePath());
				loadInfo.add("\r\nTitle: ");
				loadInfo.add(title);
				loadInfo.add("\r\nAuthor: ");
				loadInfo.add(author);
				loadInfo.add("\r\nDate Uploaded: ");
				loadInfo.add(date);
				info(loadInfo, title);
				loadTimer(loadInfo);
			}
		}
		save();
		summary.setText(summaryText(docs));
		summary.setCaretPosition(0);

	}
	
	public void copyDirectory(File sourceLocation , File targetLocation)
		    throws IOException {

	    if (sourceLocation.isDirectory()) {
	        if (!targetLocation.exists()) {
	            targetLocation.mkdir();
	        }

	        String[] children = sourceLocation.list();
	        for (int i = 0; i < sourceLocation.listFiles().length; i++) {

	            copyDirectory(new File(sourceLocation, children[i]),
	                    new File(targetLocation, children[i]));
	        }
	    } else {

	        InputStream in = new FileInputStream(sourceLocation);

	        OutputStream out = new FileOutputStream(targetLocation);

	        // Copy the bits from instream to outstream
	        byte[] buf = new byte[1024];
	        int len;
	        while ((len = in.read(buf)) > 0) {
	            out.write(buf, 0, len);
	        }
	        in.close();
	        out.close();
	    }
	}
	
	public void load()
	{
		File documents = new File(dataDir, "documents.txt");
		Scanner d;
		try {
			d = new Scanner(documents);
			docs.clear();
			while (d.hasNextLine())
			{
				String raw = d.nextLine();
				StringTokenizer st = new StringTokenizer(raw, "*");
				String title = st.nextToken();
				String author = st.nextToken();
				String date = st.nextToken();
				Path path = Paths.get(dataDirString + "Documents/" + title);// + ".txt");
				if(Files.exists(path))
					docs.add(new Doc(title, author, date, path.toString()));

			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		summary.setText(summaryText(docs));
		summary.setCaretPosition(0);

	}
	
	public void save()
	{
		FileWriter myWriter;
		try {
			myWriter = new FileWriter(dataDirString + "documents.txt", false);
			
			for(int i = 0; i < docs.size(); i++)
			{
				myWriter.write(docs.get(i).getTitle() + "*" + docs.get(i).getAuthor() + "*" + docs.get(i).getDate());
				myWriter.write(System.getProperty( "line.separator" ));
			}
			
			myWriter.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		load();
		
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
				if (loadIndex < loadInfo.size())
				{
					loadText.append(loadInfo.get(loadIndex));
					loadIndex++;
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
	
	public void info(ArrayList<String> loadInfo, String title)
	{
    	loadInfo.add("\r\nUploading Document To Pirex Database");
    	addDots(2);
    	loadInfo.add(".\r\n");
    	addDots(21);
    	loadInfo.add("\r\n" + title + " Uploaded Successfully!" + "\r\n\r\n");
	}
	
	public void addDots(int x)
	{
		for (int i = 0; i < x; i++)
		{
			loadInfo.add(".");
		}
	}

	public void deleteFile() {
		int selectedIndex = queryList.getSelectedIndex();
		int indexNeeded = 0;
		for(int i = 0; i < docs.size(); i++)
		{
			if(docs.get(i).shortForm(query.getText()).equals(queryList.getSelectedValue()))
			{
				indexNeeded = i;
			}
		}
		
		if (selectedIndex != -1) {			
			choice = JOptionPane.showConfirmDialog(pirex,"Are you sure you want to delete " + docs.get(indexNeeded).getTitle() + "?", "Select an Option" , JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

			
			if (choice == 0) {
				File file = new File(docs.get(indexNeeded).getLocation());
				docs.remove(docs.get(indexNeeded));
				model.remove(selectedIndex);
				
				file.delete();
				save();
				JOptionPane.showMessageDialog(pirex, "Document successfully deleted");
				search();
			}
		}
	}
	
	public void openFile() throws IOException {
		int selectedIndex = queryList.getSelectedIndex();
		int selectedIndexTemp = selectedIndex;
		int indexNeeded = 0;
		for(int i = 0; i < docs.size(); i++)
		{
			if(docs.get(i).shortForm(query.getText()).equals(queryList.getSelectedValue()))
                indexNeeded = i;
		}
		
		if (selectedIndex != -1) {
            File file = new File(docs.get(indexNeeded).getLocation());
            java.awt.Desktop.getDesktop().open(file);
            Object[] options = {"OK"};
            int n = JOptionPane.showOptionDialog(pirex,"Click OK when after saving the document.", "Finished Editing?", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, null);

            if (n == 0 || n == JOptionPane.CLOSED_OPTION)
            {
            	save();
				search();

				queryList.setSelectedIndex(selectedIndexTemp);
				docTextArea.setText(keyDocsArr[selectedIndexTemp].toString());
				docTextArea.setCaretPosition(0);
				String s = query.getText().toLowerCase();
				String content = docTextArea.getText().toLowerCase();

				if (index >= 0) {
					try {
						int end = index + s.length();
						hilit.addHighlight(index, end, painter);
						docTextArea.setCaretPosition(end);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
            }
        }
	}
	
	public void search()
	{
		String keywords = query.getText().toLowerCase();
		keyDocsArr = null;
		keyDocsArrText = null;
		keyDocsList.clear();
		model.clear();
		for (int i = 0; i < docs.size(); i++)
		{
			if (docs.get(i).getText().toLowerCase().contains(keywords))
			{
				keyDocsList.add(docs.get(i));
			}
		}
		
		keyDocsArr = new Doc[keyDocsList.size()];
		keyDocsArrText = new String[keyDocsList.size()];
		
		for (int i = 0; i < keyDocsList.size(); i++)
		{
			keyDocsArr[i] = keyDocsList.get(i);
			keyDocsArrText[i] = keyDocsList.get(i).shortForm(keywords);
			model.addElement(keyDocsArrText[i]);
		}
		
		if(keywords.equals(null) || keywords.equals("") || keywords.equals(" "))
		{
			model.clear();
		}
		
		
	}

	private void copyJarResourcesRecursively(Path destination, JarURLConnection jarConnection) throws IOException {
		JarFile jarFile = jarConnection.getJarFile();
		Iterator<JarEntry> it;
		for (it = jarFile.entries().asIterator(); it.hasNext();) {
			JarEntry entry = it.next();
			if (entry.getName().startsWith(jarConnection.getEntryName())) {
				if (!entry.isDirectory()) {
					try (InputStream entryInputStream = jarFile.getInputStream(entry)) {
						Files.copy(entryInputStream, Paths.get(destination.toString(), entry.getName()));
					}
				} else {
					Files.createDirectories(Paths.get(destination.toString(), entry.getName()));
				}
			}
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		search();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		search();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
	}
}