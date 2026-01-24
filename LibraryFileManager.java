import java.io.*;
import java.util.List;
import java.util.ArrayList;
//This class is responsible for saving and loading the library to and from a file.
public class LibraryFileManager{

  public static void saveLibrary(List<Book> books, String filename){
    try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){ //Objects--->Files Of Bytes 
       out.writeObject(books);//Write the list of the books to the file but with bytes
    } catch (IOException e){
        System.out.println("Error saving library: " + e.getMessage());
      }
  }//End of serialization
    

  public static List<Book> loadLibrary(String filename){
    try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){//Files of bytes ---> Objects
        return (List<Book>) in.readObject();//Read the list of the books from the file
    } catch (IOException | ClassNotFoundException e){
        System.out.println("Error loading library: " + e.getMessage());
        return new ArrayList<>();//If loading fails, return an empty list
      }
  }//End of deserialization
  
}