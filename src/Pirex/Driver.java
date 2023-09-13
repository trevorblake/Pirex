package Pirex;
import Display.Display;
import org.apache.tika.exception.TikaException;

import javax.swing.*;
import java.io.IOException;
public class Driver {
	public static void main(String[] args) throws TikaException, IOException {
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
