package Display;

import Data.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

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


    Login() {
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


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase(User.getUser()) && pwdText.equalsIgnoreCase(User.getPass())) {
                try
                {
                    Thread.sleep(3000);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
               
                frame.dispose();
                Display.main(null);
                
            } else {
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


    public static void main(String[] a) {

        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/p.png"));
        frame.setTitle("Pirex");
        frame.setVisible(true);
        frame.setBounds(10, 10, 371, 411);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }
}
