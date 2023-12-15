/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookmanager;

/**
 *
 * @author sonki
 */
import java.io.Serializable;

// Định nghĩa lớp Book, triển khai giao diện Comparable và Serializable
public class Book implements Comparable<Book>, Serializable {
    
    // Số phiên bản của lớp để đảm bảo tính duy nhất khi đọc/ghi đối tượng
    private static final long serialVersionUID = 1L;
    
    // Khai báo các thuộc tính của đối tượng Book
    private String id;
    private String title;
    private String author;
    private String publicationDate;
    private String Categories;

    // Constructors, getters, setters, compareTo, equals, and hashCode methods
    public Book(String id, String title, String author, String publicationDate, String Categories) {
        super();
        this.id = id;
        this.title = title;
        this.author = author ;
        this.publicationDate = publicationDate ;
        this.Categories=  Categories;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author + ", publicationDate=" + publicationDate + ", summary=" + Categories + '}';
    }
    // (Các phương thức khởi tạo, getters, setters, compareTo, equals và hashCode không được hiển thị trong đoạn mã này)
    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getCategories() {
        return Categories;
    }

    public void setCategories(String Categories) {    
        this.Categories = Categories;
    }

    // Phương thức compareTo, triển khai từ giao diện Comparable
    @Override
    public int compareTo(Book other) {
        // So sánh đối tượng hiện tại với đối tượng khác dựa trên thuộc tính id
        return this.id.compareTo(other.id);
    }
}

