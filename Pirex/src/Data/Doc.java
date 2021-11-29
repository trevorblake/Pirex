package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;



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
    
    public String shortForm(String keyword) // formatting for short form displays
    {
    	String s = "";
    	String sub = "";
    	Boolean t = true;
    	ArrayList<String> textWords = new ArrayList<String>();
    	String[] keys = keyword.split(" ");
    	String textOnlySpaces = text.replaceAll("\\R+", " ").replaceAll("  ", " ");
    	String[] textArr = textOnlySpaces.split(" ");
    	ArrayList<String> textList = new ArrayList<String>();
    	Collections.addAll(textList, textArr);
    	Enumeration<Boolean> together;
    	Vector<Boolean> f = new Vector<Boolean>();

    	
    	if (text.contains(keyword))
    	{
    		int keyIndex = textList.indexOf(keys[0]);

    	    for(int i = keyIndex - 5; i < keyIndex + 6; i++)
    	    {
    	    	
    	        if (i < 0 || i > textList.size())
    	        {
    	           sub+= "";
    	        }
    	            
    	        else
    	        {
    	            if(i == keyIndex +5)
    	            {
    	                sub+= textList.get(i);
    	            }
    	                
    	            else
    	            {
    	            	sub+= textList.get(i) + " ";
    	            }
    	        }
    	    } 
    	    
	        s+= title + ", ";
	        s+= author + ", ";
	        s+= date + " - \"";
	        s+= sub + "\"";
	        return s;
    	}
    	
    	else
    	{
    		return "No Documents Found";
    	}
    }
    
    public String toString() // formatting for long form displays
    {
    	String s = "";
		s+= "Title: " + title;
		s+= "\r\nAuthor: " + author;
		s+= "\r\nDate Uploaded: " + date + "\r\n";
		s+= "\r\n" + this.text + "\r\n\r\n";

		return s;
    }
}
