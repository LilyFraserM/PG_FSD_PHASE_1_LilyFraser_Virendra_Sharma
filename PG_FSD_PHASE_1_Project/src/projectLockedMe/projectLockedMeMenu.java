package projectLockedMe;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class projectLockedMeMenu {
	   final static String filePath ="C:\\Users\\lilyf\\OneDrive\\Documents\\lockedMe";
	 
	    static File[] files = new File(filePath).listFiles();
	   static Scanner scanner = new Scanner(System.in); 
	   static File fileDir = new File(filePath);
		 static Path path = Paths.get(filePath);
	 
	public static void main(String[] args) throws Exception {
		
		 showWelcomeScreen();
		 signInMenu();
		
		 }
	
		
	


	// TODO Auto-generated method stub
	private static void showWelcomeScreen() {
		
        System.out.println("***********************************************************");
        System.out.println("*********************  LOCKED ME. COM  ********************");
        System.out.println("******************Developed by Lily Fraser*****************");
        System.out.println("***********************************************************\n");
       
	}
	public static void signInMenu() throws Exception {
		int num = 0;
    	Scanner input = new Scanner(System.in);
        System.out.println(" 1. New User - Register");
        System.out.println(" 2. Registered User - Login");
        System.out.println();
        
        System.out.println("Enter Your Choice:");
        num = input.nextInt();   
         
        //   Object obj;
		//Object h = null;
		switch(num){    
           case 1: System.out.println("Register"); 
                   registration.userInput_Reg(); 
                   break;  
           case 2: System.out.println("Login");  
			try {registration.readFromFile_Login();
				
			} catch (InputMismatchException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
				
                   break;    
           default: System.out.println("\nPlease select 1 or 2 option");  
           }

	}	
	
	public static void showMainMenu() throws Exception {
		
		System.out.println("************MAIN MENU ******************");
        System.out.println("1. Show files in ascending order");
        System.out.println("2. Perform file operations (add, delete or search)");
        System.out.println("3. Close the application");
        System.out.println("****************************************");
        mainMenuOption();
	}





	private static void mainMenuOption() throws Exception {
		
		 System.out.println("Please choose 1, 2 or 3:");
		 
	        int option = scanner.nextInt();
	        switch (option) {
	            case 1:
	                showFilesInAscendingOrder();
	                break;
	            case 2:
	            	buisinessLevelOperations();
	            	break;
	            case 3:
	            	System.out.println("\nThanks for using lockedme.com. Closing application.");
	                System.exit(0);
	                break;
	            default:
	                System.out.println("\nInvalid input provided, please choose 1, 2 or 3.\n");
	        }
	        showMainMenu();
		
	}





	private static void buisinessLevelOperations() throws Exception {
		
		 System.out.println("\n********************************");
		 System.out.println("1. Add a file");
		 System.out.println("2. Delete a file");
		 System.out.println("3. Search for a file");
		 System.out.println("4. Main Menu");
		 System.out.println("*******************************");
		
		 System.out.println("Please choose the operation you would like to perform :\n ");
		 int option = scanner.nextInt();
		 
		 switch (option) {
         case 1:
        	// String filename = scanner.next().trim().toLowerCase();
        	 addFile();
             break;
         case 2:
        	 deleteFile();
        	 break;
         case 3:
        	 searchFile();
        	 break;
         case 4:	 
        	 showMainMenu();
             break;
         default:
             System.out.println("Invalid input provided, please choose 1, 2 or 3.\n");
     }
	}





	private static  void showFilesInAscendingOrder() throws Exception{
		
		List<String> folder= new ArrayList<String>();
		 System.out.println("Showing files in ascending order\n");
		 
		 for(File file :files) {
			 System.out.println(file.getName());
			 if(file.isFile()) {
				
				 folder.add(file.getName());
			 }
		 }
			/*
			 * for(int i=0; i < folder.size(); i++){ System.out.println("folder contents:" +
			 * folder.get(i) ); }// this loop is just to test contents of folder
			 */		
		 if(folder.isEmpty()) {
			 System.out.println("Folder is empty\n");
			 
			 
		 }
		 System.out.println("\n");
		 showMainMenu();
			
		 
		 }
	     
	        
	
	
	static void addFile() throws Exception {
		
		
		System.out.println("\nPlease enter file name:");
		String fileName = scanner.next();
		File F = new File(path + File.separator + fileName);
		if(F.exists()) {
			 System.out.println("File " + fileName + " already exists at " + fileDir + "\n");
		}else {
			F.createNewFile();
			//F = new File(fileDir, "filename");
		System.out.println("File "+fileName+" added to "+ F.getAbsolutePath() + "\n");
		
		
}	
		showMainMenu();
	}
    
	
	public static void deleteFile() throws CustomDeleteException {//make a custom exception
		System.out.println("Enter file to be deleted: ");
		String fileName = scanner.next();
		File F = new File(path + File.separator + fileName);

		
	//	System.out.println("file delete path:" + fileDir);
         try {
			if (fileDir.isDirectory() == true) {
			   List listFile = Arrays.asList(fileDir.list());
			   if (listFile.contains(fileName)) {
				   F.delete();
				System.out.println("File " + fileName + " deleted from " + filePath +"\n");
				
			}else {
				System.out.println("Delete Operation failed. FILE NOT FOUND\n");
			}
			 }
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
	}

	public  static void searchFile() throws Exception  {
		System.out.println("Enter file to be searched: ");
		String fileName = scanner.next();
		
		File F = new File(fileName);
		
		 File fileDir = new File(filePath);
		
         if (fileDir.isDirectory() == true) {
           List listFile = Arrays.asList(fileDir.list());
           if (listFile.contains(fileName)) {
            
				 System.out.println("File found! : File " + fileName + " exists at " + filePath + "\n");	 
			 }else {
				
				 throw new FileNotFoundException("File was not found(FNF)");
			 }
		 }
		 
		
}
}
	



