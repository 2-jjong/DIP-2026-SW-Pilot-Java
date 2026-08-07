package course04.problem02;

public class Manager extends User implements BookManageable {
    public Manager(String userId, String name) {
        super(userId, name);
    }

    @Override
    public void addBook(Library library, Book book) {
        System.out.println("관리자 '" + getName() + "'가 책을 추가합니다: '" + book.getTitle() + "', '" + book.getAuthor() + "'");
        library.addBook(book);
    }

    @Override
    public void removeBook(Library library, Book book) {
        library.removeBook(book);
    }
}
