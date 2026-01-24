//This class (Book) is the entity (data and behavior)
import java.io.Serializable;

public class Book implements Serializable {
  // attributes 
  private static final long serialVersionUID = 1L;
  private String title;
  private String author;
  private BookStatus status;

  // constructor
  public Book(String title, String author) {
   this.title = title;
   this.author = author;
   this.status = BookStatus.AVAILABLE;
  }

  // Getters
  public String getTitle() {
    return title;
  }

  // Business Methods
  public void borrow() {
    this.status = BookStatus.BORROWED;
  }

  public void returnBook() {
    this.status = BookStatus.AVAILABLE;
  }

  public boolean isAvailable(){
    return status == BookStatus.AVAILABLE;
  }

  // toString method
  @Override
  public String toString() {
    return title + " by " + author;
  }

}
