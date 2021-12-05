package Display;

import Data.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public final class Login extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    static Login frame = new Login();
	Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    private final JLabel lblNewLabel = new JLabel("  Please Log In Below");
    User admin = new User("admin", "password", 1);
    User general = new User("user", "password", 0);
    public static int privilege = 1;


    public Login() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 158, 73, 30);
        passwordLabel.setBounds(50, 228, 100, 30);
        userTextField.setBounds(150, 158, 150, 30);
        passwordField.addKeyListener(new KeyAdapter() {
        	@SuppressWarnings("deprecation")
			@Override
        	public void keyPressed(KeyEvent e) {
        		  
        		if (e.getKeyCode() == KeyEvent.VK_ENTER)
        		{
        		
        			String userText;
                    String pwdText;
                    userText = userTextField.getText();
                    pwdText = passwordField.getText();
                    if (userText.equalsIgnoreCase(admin.getUsername()) && pwdText.equalsIgnoreCase(admin.getPassword())) {
           
                        JOptionPane.showMessageDialog(container, "You have administrator privileges!");
                        privilege = 1;
                        frame.dispose();
                        createPirex();
                        
                    } 
                   
                    else if (userText.equalsIgnoreCase(general.getUsername()) && pwdText.equalsIgnoreCase(general.getPassword())) {
                    	   
                        JOptionPane.showMessageDialog(container, "You have general user privileges!");
                        privilege = 0;
                        frame.dispose();
						createPirex();
                        
                    } 
                    
                    else {
                        JOptionPane.showMessageDialog(container, "Invalid Username or Password");
                    }
        		}
        		
        	}
        });
        passwordField.setBounds(150, 228, 150, 30);
        showPassword.setBounds(150, 258, 150, 30);
        loginButton.setBounds(50, 308, 100, 30);
        resetButton.setBounds(200, 308, 100, 30);

    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        
        JLabel pireximage = new JLabel("");
        pireximage.setIcon(new ImageIcon("images/pirex.png"));
        pireximage.setBounds(107, 11, 140, 74);
        getContentPane().add(pireximage);
        lblNewLabel.setBounds(102, 83, 130, 47);
        
        getContentPane().add(lblNewLabel);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @SuppressWarnings("deprecation")
	@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase(admin.getUsername()) && pwdText.equalsIgnoreCase(admin.getPassword())) {
   
                JOptionPane.showMessageDialog(this, "You have administrator privileges!");
                privilege = 1;
                frame.dispose();
                createPirex();
                
            } 
            
            else if (userText.equalsIgnoreCase(general.getUsername()) && pwdText.equalsIgnoreCase(general.getPassword())) {
            	   
                JOptionPane.showMessageDialog(this, "You have general user privileges!");
                privilege = 0;
                frame.dispose();
                createPirex();
                
            } 
            
            else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
            
        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("") ;
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }
    
    public static void createPirex() {
    	Display a = new Display();
    	try {
			a.createGUI();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    public void createLogin() {

        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/p.png"));
        frame.setTitle("Pirex");
        frame.setVisible(true);
        frame.setBounds(10, 10, 371, 411);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }
}
