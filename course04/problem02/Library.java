package course04.problem02;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    private static String getJosa(String text, String withBatchim, String withoutBatchim) {
        char lastChar = text.charAt(text.length() - 1);
        if (lastChar < 0xAC00 || lastChar > 0xD7A3) {
            return withBatchim;
        }
        return ((lastChar - 0xAC00) % 28 > 0) ? withBatchim : withoutBatchim;
    }

    public void registerUser(User user) {
        users.add(user);
        String josa = getJosa(user.getName(), "을", "를");
        String userTypeStr = (user instanceof Manager) ? "새로운 관리자" : "새로운 이용자";
        System.out.println(userTypeStr + " '" + user.getName() + "'" + josa + " 등록합니다.");
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        if (book.isBorrowed()) {
            System.out.println("대출 중인 책을 삭제할 수 없습니다.");
            return;
        }
        books.remove(book);
        System.out.println("책 '" + book.getTitle() + "'이 삭제되었습니다.");
    }

    public Book findBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                return b;
            }
        }
        return null;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().equals(author)) {
                results.add(b);
            }
        }

        if (results.isEmpty()) {
            System.out.println("검색 결과 해당하는 책이 없습니다.");
            return results;
        }

        System.out.println("저자 '" + author + "'의 책 목록:");
        for (Book b : results) {
            b.displayInfo();
        }
        System.out.println();

        return results;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }
}
