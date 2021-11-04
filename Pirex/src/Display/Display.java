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
import javax.swing.Box;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Dimension;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.DropMode;

public class Display {

	private JFrame frmPirex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frmPirex.setBounds(100, 100, 896, 553);
		frmPirex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPirex.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.setBounds(0, 0, 875, 800);
		frmPirex.getContentPane().add(tabbedPane);
		
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
		welcomeText.setBounds(102, 185, 697, 247);
		welcome.add(welcomeText);
		
		JPanel help = new JPanel();
		help.setForeground(Color.WHITE);
		help.setBorder(null);
		help.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/help iconr.png"), help, "Need Help?");
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setDisabledIconAt(1, new ImageIcon("images/help icong.jpg"));
		help.setLayout(new GridLayout(1, 0, 0, 0));
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		
		JPanel summarize = new JPanel();
		summarize.setForeground(Color.WHITE);
		summarize.setBorder(null);
		summarize.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/summ iconr1.png"), summarize, "Summarized Document View");
		tabbedPane.setBackgroundAt(2, Color.WHITE);
		summarize.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel load = new JPanel();
		load.setForeground(Color.WHITE);
		load.setBorder(null);
		load.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/ld iconr.png"), load, "Load Documents Section");
		tabbedPane.setBackgroundAt(3, Color.WHITE);
		load.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel search = new JPanel();
		search.setForeground(Color.WHITE);
		search.setBorder(null);
		search.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon("images/sea iconr.png"), search, "Search For Documents");
		tabbedPane.setBackgroundAt(4, Color.WHITE);
		search.setLayout(new GridLayout(1, 0, 0, 0));
	}
}
