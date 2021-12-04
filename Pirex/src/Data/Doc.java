package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    
    public String getAuthor()
    {
		return this.author;	
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
        } catch (FileNotFoundException e) {
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
    	ArrayList<String> sub = new ArrayList<String>(); 
    	String textFix = text.replaceAll("\\R+", " ").replaceAll("  ", " ");
    	String[] keys = keyword.split(" ");
    	String[] textArr = textFix.split(" ");
    	ArrayList<String> textList = new ArrayList<String>();
    	Collections.addAll(textList, textArr);
    	String index = "";
    	int j = 0;
		int m = 1;
		int n = 1;
    	  	
    	for (int i = 0; i < textList.size(); i++)
    	{	
    		if(j < keys.length)
    		{
    			if(textList.get(i).toLowerCase().contains(keys[j].toLowerCase()))
    			{
    				index += Integer.toString(i) + " ";
    				j++;
    			}
    			
    			else
    			{
    				j = 0;
    				index = "";
    			}
    		}    		
    	}
    	
    	if(!index.equals(""))
    	{
    		String[] indexInText = index.split(" ");
    		for (int i = 0; i < indexInText.length; i++)
    		{
    			sub.add(textList.get(Integer.parseInt(indexInText[i])));		
    		}
    		
    		for(int i = keys.length; i < 9;)
    		{	
    			if (Integer.parseInt(indexInText[0]) - m >= 0)
    			{
    				sub.add(0, textList.get(Integer.parseInt(indexInText[0]) - m));
    				m++;
    				i++;
    			}
    			
    			else
    			{
    				i++;
    			}
    		
				if (Integer.parseInt(indexInText[indexInText.length-1]) + n < textList.size())
				{
					sub.add(textList.get(Integer.parseInt(indexInText[indexInText.length-1]) + n));
					n++;
					i++;
				}
				
				else
				{
					i++;
				}
				
    		}     	
    	}
    	
        s+= title + ", ";
        s+= author + ", ";
        s+= date + " - \"";
        for(int i = 0; i < sub.size(); i++)
        {
        	if(i == sub.size() - 1)
        	{
        		s+=sub.get(i);
        	}
        	
        	else
        	{
        		s+= sub.get(i) + " ";
        	}
        	
        }
        s+= "\"";
    	return s;
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
