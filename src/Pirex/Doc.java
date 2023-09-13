package Pirex;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class Doc 
{
	private final String title;
	private final String author;
	private final String date;
	private final String location;
	private String text;
	Scanner scan;
    
    
    public Doc(String title, String author, String date, String location) {
    	this.title = title;
    	this.author = author;
    	this.date = date;
    	this.location = location;
		try {
			this.text = formText();
		} catch (IOException | TikaException e) {
			throw new RuntimeException(e);
		}
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
    
    public String formText() throws IOException, TikaException {
		AutoDetectParser parser = new AutoDetectParser();
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();

		try (InputStream stream = new FileInputStream(this.location)) {
			try {
				parser.parse(stream, handler, metadata);
			} catch (IOException | SAXException | TikaException e) {
				throw new RuntimeException(e);
			}
            return handler.toString();
		}
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
    				index += i + " ";
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
