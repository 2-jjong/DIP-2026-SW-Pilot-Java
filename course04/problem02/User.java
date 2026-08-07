package course04.problem02;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String userId;
    private String name;
    private List<Book> borrowedBooks;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book == null) {
            System.out.println("[예외] 존재하지 않는 책입니다.");
            return;
        }

        if (book instanceof Textbook && !(this instanceof Student)) {
            System.out.println("[예외] 교과서는 학생만 대출할 수 있습니다.");
            return;
        }

        if (book.isBorrowed()) {
            System.out.println("'" + book.getTitle() + "'은 대출 중입니다.");
            return;
        }

        book.setBorrowed(true);
        borrowedBooks.add(book);

        if (this instanceof Manager) {
            System.out.println("관리자 '" + name + "'가 '" + book.getTitle() + "' 대출합니다.");
        } else {
            System.out.println("이용자 '" + name + "' '" + book.getTitle() + "' 대출합니다.");
        }
    }

    public void returnBook(Book book) {
        if (book == null) {
            System.out.println("[예외] 존재하지 않는 책입니다.");
            return;
        }

        if (!borrowedBooks.contains(book) || !book.isBorrowed()) {
            System.out.println("[예외] 등록되지 않은 책을 반납하는 경우: " + book.getTitle());
            return;
        }

        book.setBorrowed(false);
        borrowedBooks.remove(book);
        System.out.println("이용자 '" + name + "'가 '" + book.getTitle() + "' 반납합니다.");
    }
}
