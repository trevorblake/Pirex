package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Doc 
{
	private String title;
	private String author;
	private String date;
	private String location;
	private String text;
	Scanner scan;
    
    
    public Doc(String title, String author, String date)
    {
    	this.title = title;
    	this.author = author;
    	this.date = date;
    	this.location = "PirexData/" + title + ".txt";
    	this.text = formText();   	
    }
    
    public String getTitle()
    {
		return this.title;	
    }
    
    public void setTitle(String title)
    {
    	this.title = title;
    }
    
    public String getAuthor()
    {
		return this.author;	
    }
    
    public void setAuthor(String author)
    {
    	this.author = author;
    }
    
    public String getDate()
    {
		return this.date;
    }
    
    public String getLocation()
    {
		return this.location;
    	
    }
    
    public String getText() 
    {
    	return this.text;
    }
    
    public String formText()
    {	
    	this.text = "";
    	
        try {
            scan = new Scanner(new File(this.location));
            //System.out.println("it is working");
        } catch (FileNotFoundException e) {
            //System.out.println("it is not working");
        }
    	
    	while(scan.hasNext())
    	{
    			this.text += scan.nextLine() + "\r\n";
    	}
        scan.close();
        
        return this.text;       
    }
    
    public String shortForm() // formatting for short form displays
    {
    	return null;
    }
    
    public String toString() // formatting for long form displays
    {
    	String s = "";
		s = "Title: " + title;
		s+= "\r\nAuthor: " + author;
		s+= "\r\nDate Uploaded: " + date + "\r\n";
		s+= "\r\n" + this.text + "\r\n\r\n";

		return s;
    }
}
