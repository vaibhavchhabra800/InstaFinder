package igProj;
import java.io.*;
import java.lang.*;
import java.util.*;

public class igpclass {

	public static void main(String[] args) {
		HashMap<Integer,String> followers=new HashMap<Integer,String>();
		HashMap<Integer,String> following=new HashMap<Integer,String>();
		String user_name="";
		
		
		
		try {
		
		
		File file2=new File("F:\\igProject\\igProj\\src\\igProj\\users.txt");    //creates a new file instance  
		FileReader fr=new FileReader(file2);   //reads the file  
		BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
		StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
		String line2;  
		while((line2=br.readLine())!=null)  
		{  
			line2  = line2.replaceAll("\t", "");
			
			user_name=line2;
			
			
			
			sb.append(line2);      //appends line to string buffer  
			sb.append("\n");     //line feed   
		  
		
				
		
		
		
		
		
		
		
		
		
		
			
		Runtime rt = Runtime.getRuntime();
		//String[] commands = {"C:\\Windows\\WinSxS\\amd64_curl_31bf3856ad364e35_10.0.17134.1_none_63ec3c6686553e29\\curl.exe https://www.instagram.com/vaibhav_v301/"};
		Process process = Runtime.getRuntime().exec("C:\\Windows\\WinSxS\\amd64_curl_31bf3856ad364e35_10.0.17134.1_none_63ec3c6686553e29\\curl.exe https://www.instagram.com/"+user_name +"/ | find \"See Instagram photos and videos\"");
		
		 BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		    String line = "";
		    while ((line = reader.readLine()) != null) {
		    	if(line.contains(" <meta property=\"og:description\" content=\"")){
		    		System.out.println(line);
		    		
		    		
		    	
		    	String str = line.replaceAll(",", "");
		    	System.out.println("Hi line now = "+str);
		    	str = str .replaceAll("[^\\d]", " "); 
		    	  
		        // Remove extra spaces from the beginning 
		        // and the ending of the string 
		        str = str.trim(); 
		  
		        // Replace all the consecutive white 
		        // spaces with a single space 
		        str = str.replaceAll(" +", " "); 
		  
		        if (str.equals("")) 
		            System.out.println("Kuch nahi mila") ; 
		        String[] splited = str.split("\\s+");
		        System.out.println("Followers= " +splited[0]);
		        System.out.println("Following= "+ splited[1]);
		        
		        System.out.println( str);
		        followers.put(Integer.parseInt(splited[0]),user_name);
		        following.put(Integer.parseInt(splited[1]),user_name);
		        
		    	}
		    	
		    }
		    
//		 BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//		    String line = "";
//		    while ((line = reader.readLine()) != null) {
//		        System.out.println(line);
//		    }
//		Process proc = rt.exec(commands);
//
//		BufferedReader stdInput = new BufferedReader(new 
//		     InputStreamReader(proc.getInputStream()));
//
//		BufferedReader stdError = new BufferedReader(new 
//		     InputStreamReader(proc.getErrorStream()));
//
//		// Read the output from the command
//		System.out.println("Here is the standard output of the command:\n");
//		String s = null;
		
//			while ((s = stdInput.readLine()) != null) {
//			    System.out.println(s);
//			}
//		
//
//		// Read any errors from the attempted command
//		System.out.println("Here is the standard error of the command (if any):\n");
//		while ((s = stdError.readLine()) != null) {
//		    System.out.println(s);
//		}
		    
		    
		    
		    
		    
		}
		
		fr.close();    //closes the stream and release the resources  
		//  System.out.println("Contents of File: ");  
		//  System.out.println(sb.toString());
		
		    
		    Iterator hmIterator = followers.entrySet().iterator(); 
		    
		    while (hmIterator.hasNext()) { 
	            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
	            int followersInt = ((int)mapElement.getKey());
	            if(followersInt<250)
	            {
	            	//System.out.println(mapElement.getValue() + " : " + followersInt); 
	            	System.out.println(mapElement.getValue() );
	            }
	        }
		    
		    

		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
