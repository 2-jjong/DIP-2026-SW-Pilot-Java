package course04.problem02;

public class RuleOfBodome02 {
    public static void main(String[] args) {
        Library library = new Library();

        // 관리자 1명, 이용자 2명 생성 및 도서관 등록
        Manager seiko = new Manager("M01", "세이코");
        Member mary = new Member("U01", "메리");
        Member manok = new Member("U02", "만옥");

        library.registerUser(seiko);
        library.registerUser(mary);
        library.registerUser(manok);

        System.out.println();

        // 관리자가 책 5권 등록
        seiko.addBook(library, new Book("B01", "자바의 구름", "제임스밥"));
        seiko.addBook(library, new Book("B02", "파이썬 마스터", "한송희"));
        seiko.addBook(library, new Book("B03", "에너지 플로우", "키네틱스"));
        seiko.addBook(library, new Book("B04", "화성에서의 기억", "한송희"));
        seiko.addBook(library, new Book("B05", "야채의 비밀", "송은정"));

        System.out.println();

        // 이용자 1명이 책 1권 대출
        Book javaCloud = library.findBookByTitle("자바의 구름");
        mary.borrowBook(javaCloud);

        System.out.println();

        // 관리자가 책 2권 추가
        seiko.addBook(library, new Book("B06", "자료구조의 언덕", "황수"));
        seiko.addBook(library, new Book("B07", "그곳에 가면", "한송희"));

        System.out.println();

        // 이미 대출한 책을 다른 이용자가 대출 시도
        manok.borrowBook(javaCloud);

        System.out.println();

        // 이용자 1명이 빌린 책을 반납
        mary.returnBook(javaCloud);

        System.out.println();

        // 관리자가 책 대출
        Book marsMemory = library.findBookByTitle("화성에서의 기억");
        seiko.borrowBook(marsMemory);

        System.out.println();

        // 저자명으로 책 검색
        library.searchByAuthor("한송희");
    }
}
