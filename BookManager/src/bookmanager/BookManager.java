/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bookmanager;

/**
 *
 * @author sonki
 */
import java.io.*;
import java.util.*;

// Quản lý các hoạt động liên quan đến sách
public class BookManager {
    
    // Set để lưu trữ đối tượng Book, sắp xếp tự động theo Comparable
    private Set<Book> books;
    // Thêm phương thức để cho phép thay đổi dữ liệu sách
    public  Set<Book> getModifiableBooks() {
        return books;
    }
    // Khởi tạo BookManager, khởi tạo Set<Book> để lưu trữ sách
    public BookManager() {
        this.books = new TreeSet<>();
    }
    
    // Thêm hoặc cập nhật sách trong Set
    public  void addOrUpdateBook(Book book) {
        // Kiểm tra xem sách đã tồn tại chưa
        if (books.contains(book)) {
            // Cập nhật thông tin sách
            // Ví dụ: bạn có thể remove sách cũ và thêm sách mới để giả lập cập nhật
            books.remove(book);
            books.add(book);
        } else {
            // Thêm sách mới nếu chưa tồn tại
            books.add(book);
        }
    }

    // Trả về tất cả id sách (không thể sửa đổi)
    public Set<String> getAllBookIds() {
        Set<String> bookIds = new HashSet<>();
        for (Book book : books) {
            bookIds.add(book.getId());
        }
        return Collections.unmodifiableSet(bookIds);
    }
    public Book getBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }


    // Lưu danh sách sách vào tệp tin
    public  void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            // Ghi Set<Book> vào ObjectOutputStream để lưu trữ
            for (Book book : books) {
                oos.writeObject(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Đọc danh sách sách từ tệp tin
    @SuppressWarnings("unchecked")
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            // Đọc Set<Book> từ ObjectInputStream để khôi phục danh sách sách
             while (true) {
                try {
                    Book book = (Book) ois.readObject();
                    books.add(book);
                } catch (EOFException e) {
                    // Khi hết dữ liệu, thoát khỏi vòng lặp
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        MainForm MF= new MainForm();
        MF.show();
    }
}
