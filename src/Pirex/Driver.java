package Pirex;
import javax.swing.UnsupportedLookAndFeelException;

import Display.Display;
 
public class Driver {
	public static void main(String[] args)
	{
		new Driver();
		//Login a = new Login();
		//a.createLogin();
    	Display a = new Display();
    	try {
			a.createGUI();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
