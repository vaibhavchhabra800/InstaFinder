package igProj;
import java.io.*;
import java.lang.*;
import java.util.*;

public class igpclass {

	public static void main(String[] args) {
		HashMap<Integer,String> followers=new HashMap<Integer,String>();
		HashMap<Integer,String> following=new HashMap<Integer,String>();
		String user_name="vaibhav_v301";
		try {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
