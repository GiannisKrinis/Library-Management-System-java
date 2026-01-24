import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
     
    Library library = new Library();
    library.loadFromFile("Library.dat"); //Load the library from the file when the program starts
    Scanner scanner = new Scanner(System.in);
    boolean running = true;   

     //Display menu
     while (running){
     
     openMenu();//Display Menu

        
     //Read user's choice
      String choice = scanner.nextLine();

      //process user's choice, with switch 
       switch(choice){

         //add book
         case "1":
           System.out.println("Enter book title");
           String title = scanner.nextLine();
           System.out.println("Enter book author");
           String author = scanner.nextLine();

           //Check if the title || author is empty (Validation)
           if(title.isBlank() || author.isBlank()){
              System.out.println("Title and author cannot be empty");
              break;
           }
           //The user write Title AND author, add it to the library
           boolean added = library.addBook(new Book(title, author));

             
           //Check if the book already exists in the library    
            if (!added){ //If exists break
              System.out.println("Book already exists");
              break;
           }
           else{ 
             //if it doesn't exist, add it to the library and break
             System.out.println("Book added successfully");
             break;
           }
          //Borrow book 
          case "2":
           System.out.println("Enter book title to borrow");
           String titleToBorrow = scanner.nextLine();

           //Check the if the book is available.
           boolean success = library.borrowBook(titleToBorrow);
            
          // If the book is available you can borrow it. If not, you can try again for other book.
           if (success){
              System.out.println("Book borrowed successfully");
           }
           else{
              System.out.println("Book not available");
           }
            break;

           //List books
           case "3":     
       
           System.out.println("List of books");
           if (library.getBooks().isEmpty()){
              System.out.println("No books in the library");//If the library is empty
           }
           else{
            for (Book book : library.getBooks()){ //If the library is NOT empty
              if (book.isAvailable()){
               System.out.println(book.getTitle() + " " + "- Available");//If the book is available
              }
              else{
                 System.out.println(book.getTitle() + " " + "- Borrowed");//If the book is borrowed
              }
            }
           }
            break;

           //Return book
         case "4":
            System.out.println("Enter book title to return");
            String titleToReturn = scanner.nextLine();

           //Check if the book is borrowed, if it is borrowed return it 
           boolean returnSuccess = library.returnBook(titleToReturn);
           if (returnSuccess){
              System.out.println("Book returned successfully");
           }
           else {
              System.out.println("Book not found or not borrowed");
           }

           break; 


         //Save Library
        case "5":
           library.saveToFile("Library.dat");
           System.out.println("Library saved successfully");
           break;

        //Load Library from file
         case "6":
           library.loadFromFile("Library.dat");
           System.out.println("Library loaded successfully");
           break;
             
            
         //Exit
         case "0":
            library.saveToFile("Library.dat");
            System.out.println("Library saved. Goodbye!!");
            running = false;
            break;
         //Anything else except the options above it will be invalid.
         default:
            System.out.println("Invalid Choice, please try again :) ");
      }     
      
      
    }
    scanner.close();     
  }
 



public static void openMenu(){
    System.out.println("1. Add Book");
    System.out.println("2. Borrow Book");
    System.out.println("3. List Books");
    System.out.println("4. Return Book");
    System.out.println("5. Save Library");
    System.out.println("6. Load library");
    System.out.println("0. Exit");
}
}//end of main class