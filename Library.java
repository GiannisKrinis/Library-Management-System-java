import java.util.ArrayList;
import java.util.List;

public class Library {
  // attributes
  private List<Book> books = new ArrayList<Book>();

  // Add a book at the library
  public boolean addBook(Book book) {
    if(findBookByTitle(book.getTitle()) != null){
       return false;
    }  
    books.add(book);
    return true;
  }

  // Find a book by title in the library , if not return nulll
  public Book findBookByTitle(String title) {
    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        return book;
      }
    }
    return null;
  }

  // Find if a book is available to borrow. If it is available(not borrowed) then
  // borrow it and return true. If isn't available return false.
  public boolean borrowBook(String title) {
    Book book = findBookByTitle(title);
    if (book != null && !book.isAvailable()) {
      book.borrow();
      return true;
    }
    return false;
  }

  // Return a book to the library
  public boolean returnBook(String title) {
    Book book = findBookByTitle(title);
    if (book != null && book.isAvailable()) { // If the book is borrowed return it
      book.returnBook(); // Status of the book is changed ( BORROWED ----->AVAILABLE)
      return true; // Return true if the book is returned
    }
    return false; // Return false if the book is NOT returned (the book doesn't exist or it isn't
                  // borrowed )
  }

  // Getter for books
  public List<Book> getBooks() {
    return books;
  }

  public void saveToFile(String filename) {
    LibraryFileManager.saveLibrary(books, filename);
  }

  public void loadFromFile(String filename) {
    this.books = LibraryFileManager.loadLibrary(filename);
  }

}
