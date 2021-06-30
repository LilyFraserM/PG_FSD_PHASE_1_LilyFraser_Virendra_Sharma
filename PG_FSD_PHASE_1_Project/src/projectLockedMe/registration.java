package projectLockedMe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

public class registration {
	private static final Object LOGIN = null;

	public static void userInput_Reg() throws Exception{
		 try {
		   		
	            // Get the name of the contact to be updated from the Command line argument 
	        	   		
	    		Scanner sc = new Scanner(System.in); 
	    		
	    		System.out.println("Please enter name"); 
	        	String userName = sc.next();
	  
	            // Get the number to be updated from the Command line argument 
	        	System.out.println("Please enter password - numeric value only"); 
	        	long password = sc.nextLong(); //Long.parseLong(data[1]); 
	  
	            String nameNumberString; 
	            String name; 
	            long number; 
	            int index; 
	  
	            // Using file pointer creating the file. 
	            File file = new File("C:\\Users\\lilyf\\OneDrive\\Documents\\lockedMe\\credentials.txt");
	            	
	  
	            if (!file.exists()) { 
	                 file.createNewFile(); // Create a new file if not exists. 
	            } 
	  
	            // Opening file in reading and write mode. 
	            RandomAccessFile raf = new RandomAccessFile(file, "rw"); 
	            boolean found = false; 
	  
	            // Checking whether the name of contact already exists. getFilePointer() give the current offset value from start of the file. 
	            while (raf.getFilePointer() < raf.length()) { 
	  
	                // reading line from the file. 
	                nameNumberString = raf.readLine(); 
	  
	                // finding the position of '!' 
	                index = nameNumberString.indexOf('!'); 
	  
	                // separating name and number. 
	                name = nameNumberString.substring(0, index); 
	                number = Long.parseLong(nameNumberString.substring(index + 1)); 
	  
	                // if condition to find existence of record. 
	                if (name == userName || number == password) { 
	                    found = true; 
	                    break; 
	                } 
	            } 
	  
	            if (found == false) {   
	                // Enter the if block when a record is not already present in the file. 
	                nameNumberString = userName + "!" + String.valueOf(password); 
	  
	                // writeBytes function to write a string as a sequence of bytes. 
	                raf.writeBytes(nameNumberString); 
	  
	                // To insert the next record in new line. 
	                raf.writeBytes(System.lineSeparator()); 
	  
	                // Print the message 
	                System.out.println("User added!\n "); 
	                projectLockedMeMenu.signInMenu();
	            
	  
	                // Closing the resources. 
	                raf.close(); 
	            } 
	                   // The contact to be updated could not be found 
	            else { 
	                raf.close(); // Closing the resources. 
	  
	                // Print the message 
	                System.out.println(" User with this name" + " already exist. \n"); 
	                
	                projectLockedMeMenu.signInMenu();
	                
	            } 
	        } 
	  
	        catch (IOException ioe) { 
	            System.out.println(ioe); 
	        } 
	        catch (NumberFormatException nef) { 
	            System.out.println(nef); 
	        } 
	}
	

public static void readFromFile_Login() throws Exception{
	
	
	Scanner scnr = new Scanner(System.in); 
	
	System.out.println("\nPlease enter name\n"); 
	String newName = scnr.next();

    // Get the number to be updated from the Command line argument 
	System.out.println("Please enter password- numeric value only"); 
	long newNumber = scnr.nextLong(); //Long.parseLong(data[1]); 

    String nameNumberString; 
    String name; 
    long number; 
    int index; 

    // Using file pointer creating the file. 
    File file = new File("C:\\Users\\lilyf\\OneDrive\\Documents\\lockedMe\\credentials.txt");
    		

    if (!file.exists()) { 
         file.createNewFile(); // Create a new file if not exists. 
    } 

    // Opening file in reading and write mode. 
    RandomAccessFile raf = new RandomAccessFile(file, "r"); 
    boolean found = false; 

    // Checking whether the name of contact already exists. getFilePointer() give the current offset value from start of the file. 
    while (raf.getFilePointer() < raf.length()) { 

        // reading line from the file. 
        nameNumberString = raf.readLine(); 

        // finding the position of '!' 
        index = nameNumberString.indexOf('!'); 

        // separating name and number. 
        name = nameNumberString.substring(0, index); 
        number = Long.parseLong(nameNumberString.substring(index + 1)); 

        // if condition to find existence of record. 
        if (name == newName || number == newNumber) { 
            found = true; 
            break; 
        } 
    } 

    if (found == false) {   
        

        // Print the message 
        System.out.println(" Invalid username or password. Login failed \n"); 

        // Closing the resources. 
        raf.close(); 
    } 
           // The contact to be updated could not be found 
    else { 
        raf.close(); // Closing the resources. 

       
        System.out.println(" Welcome " + newName + " !!!\n"); 
        projectLockedMeMenu.showMainMenu();
       
    }

} 
	


}
