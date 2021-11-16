package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Doc {
    Scanner scan;
    static String fileText = "";

    
    public void open() {

        try {
            scan = new Scanner(new File("PirexData/Star Wars.txt"));
            System.out.println("it is working");
        } catch (FileNotFoundException e) {
            System.out.println("it is not working");
        }
    }

    public String Read() {
    	
    	while(scan.hasNext())
    	{
    			fileText += scan.nextLine() + "\r\n";
    	}
        scan.close();
        
        return fileText;

    }
}
