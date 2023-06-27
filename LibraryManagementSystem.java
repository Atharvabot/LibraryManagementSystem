import java.util.*;

public class LibraryManagementSystem {

    private List<Book> books;
    private List<Member> members;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Book getBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Member getMember(String id) {
        for (Member member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }

    public void borrowBook(String isbn, String memberId) {
        Book book = getBook(isbn);
        Member member = getMember(memberId);
        if (book != null && member != null) {
            if (book.isAvailable()) {
                book.setAvailable(false);
                member.addBook(book);
            }
        }
    }

    public void returnBook(String isbn, String memberId) {
        Book book = getBook(isbn);
        Member member = getMember(memberId);
        if (book != null && member != null) {
            if (!book.isAvailable()) {
                book.setAvailable(true);
                member.removeBook(book);
            }
        }
    }
}

class Book {

    private String isbn;
    private String title;
    private String author;
    private boolean available;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Member {

    private String id;
    private String name;
    private List<Book> books;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
}
