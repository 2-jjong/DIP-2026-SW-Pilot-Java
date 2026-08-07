# SOLID 원칙 분석 및 도서관 관리 시스템 코드 리팩토링 보고서

**작성자**: 이종현

## 목차
1. [SOLID 원칙의 등장과 필요성](#1-solid-원칙의-등장과-필요성)
2. [다섯 가지 원칙 소개](#2-다섯-가지-원칙-소개)
   - [SRP (Single Responsibility Principle - 단일 책임 원칙)](#srp-single-responsibility-principle---단일-책임-원칙)
   - [OCP (Open-Closed Principle - 개방-폐쇄 원칙)](#ocp-open-closed-principle---개방-폐쇄-원칙)
   - [LSP (Liskov Substitution Principle - 리스코프 치환 원칙)](#lsp-liskov-substitution-principle---리스코프-치환-원칙)
   - [ISP (Interface Segregation Principle - 인터페이스 분리 원칙)](#isp-interface-segregation-principle---인터페이스-분리-원칙)
   - [DIP (Dependency Inversion Principle - 의존역전 원칙)](#dip-dependency-inversion-principle---의존역전-원칙)
3. [도서관 시스템에서 SOLID 원칙에 어긋나는 부분](#3-도서관-시스템에서-solid-원칙에-어긋나는-부분)
   - [소제목 1: LSP (리스코프 치환 원칙) 위반](#소제목-1-lsp-리스코프-치환-원칙-위반)
   - [소제목 2: SRP (단일 책임 원칙) 위반](#소제목-2-srp-단일-책임-원칙-위반)
   - [소제목 3: ISP (인터페이스 분리 원칙) 위반](#소제목-3-isp-인터페이스-분리-원칙-위반)
   - [소제목 4: DIP 및 OCP (의존역전 및 개방-폐쇄 원칙) 위반](#소제목-4-dip-및-ocp-의존역전-및-개방-폐쇄-원칙-위반)

---

## 1. SOLID 원칙의 등장과 필요성

객체 지향 프로그래밍(OOP)에서 **SOLID 원칙**은 로버트 C. 마틴이 2000년대 초반 객체 지향 설계의 5가지 핵심 원칙을 정립한 것이다.

### 필요성과 의의
1. **유지보수성 향상**: 요구사항이 변경되거나 새로운 기능이 추가될 때 기존 코드에 미치는 사이드 이펙트(Side Effect)를 최소화한다.
2. **유연성 및 확장성 확보**: 모듈 간 결합도(Coupling)를 낮추고 응집도(Cohesion)를 높여 시스템 구조를 유연하게 변경할 수 있다.
3. **코드 재사용성 및 가독성 증가**: 역할과 책임이 명확히 분리되어 코드를 이해하기 쉽고 다른 프로젝트에서도 손쉽게 재사용할 수 있다.

---

## 2. 다섯 가지 원칙 소개

### SRP (Single Responsibility Principle - 단일 책임 원칙)
- **개념**: 하나의 클래스는 단 하나의 책임만을 가져야 한다.
- **의의**: 클래스가 수행하는 역할이 명확해지므로 변경 사항이 생겼을 때 해당 클래스만 수정하면 된다.

### OCP (Open-Closed Principle - 개방-폐쇄 원칙)
- **개념**: 소프트웨어 요소는 **확장에는 열려 있어야 하고, 수정에는 닫혀 있어야** 한다.
- **의의**: 기존 코드를 변경하지 않고 새로운 기능이나 클래스를 쉽게 추가할 수 있다.

### LSP (Liskov Substitution Principle - 리스코프 치환 원칙)
- **개념**: 서브 타입(자식 클래스)은 언제나 자신의 베이스 타입(부모 클래스)을 대체할 수 있어야 한다.
- **의의**: 부모 클래스의 인스턴스 대신 자식 클래스의 인스턴스를 사용해도 프로그램의 정상적인 동작이 보장되어야 한다.

### ISP (Interface Segregation Principle - 인터페이스 분리 원칙)
- **개념**: 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.
- **의의**: 범용적인 거대한 인터페이스보다 작고 구체적인 인터페이스 여러 개를 작성하여 필요한 기능만 선택적으로 구현하도록 한다.

### DIP (Dependency Inversion Principle - 의존역전 원칙)
- **개념**: 구현된 클래스보다 변하지 않는 추상화된 것에 의존해야 한다.
- **의의**: 구체적인 클래스(구현체)가 아닌 인터페이스나 추상 클래스에 의존함으로써 모듈 간의 결합도를 획기적으로 줄인다.

---

## 3. 도서관 시스템에서 SOLID 원칙에 어긋나는 부분

제공된 도서관 시스템 코드 (`BiodomeFamily08_Before.java`)를 분석한 결과, 아래와 같은 명백한 위반 지점들을 확인할 수 있다.

### 소제목 1: LSP (리스코프 치환 원칙) 위반

#### 1) 어긋나는 코드
```java
abstract class User {
    ...
    abstract void addBook(Book book, Library library);
    abstract void removeBook(Book book, Library library);
}

class Member extends User {
    public Member(String userId, String name) {
        super(userId, name);
    }

    public void addBook(Book book, Library library) {
        System.out.println("Member can't add book");
    }

    public void removeBook(Book book, Library library) {
        System.out.println("Member can't remove book");
    }
}
```

#### 2) 위반 이유 및 분석
- 부모 클래스 `User`는 `addBook`과 `removeBook`이라는 추상 메서드를 정의하여 하위 타입이 도서를 추가하거나 삭제하는 동작을 수행할 것을 계약한다.
- 그러나 자식 클래스인 `Member`는 해당 기능을 정상적으로 수행하지 않고 `"Member can't add book"` 메시지만 출력하며 거부한다.
- 이는 부모 타입(`User`) 객체를 자식 타입(`Member`)으로 대체했을 때 **정상적인 동작 계약이 깨지므로 명백한 LSP 위반**에 해당한다.

---

### 소제목 2: SRP (단일 책임 원칙) 위반

#### 1) 어긋나는 코드
```java
class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public Book writeBook(String isbn, String title, String author) {
        Book book = new Book(isbn, title, author);
        books.add(book);
        return book;
    }
    ...
}
```

#### 2) 위반 이유 및 분석
- `Library` 클래스의 본래 책임은 **도서 및 사용자 목록을 저장하고 관리**하는 것이다.
- 그러나 `writeBook` 메서드는 `new Book(...)`을 직접 호출하여 새로운 도서 객체를 인스턴스화(생성)하는 책임까지 지고 있다.
- 이로 인해 `Library` 클래스는 '도서 생성 로직의 변경'과 '도서 관리 로직의 변경'이라는 2가지 이상의 수정 이유를 갖게 되므로 **SRP를 위반**한다.

---

### 소제목 3: ISP (인터페이스 분리 원칙) 위반

#### 1) 어긋나는 코드
```java
abstract class User {
    public String userId;
    public String name;
    ...
    abstract void addBook(Book book, Library library);
    abstract void removeBook(Book book, Library library);
}
```

#### 2) 위반 이유 및 분석
- `User` 상위 클래스에 관리자 전용 기능인 `addBook`과 `removeBook`이 정의되어 있다.
- 일반 사용자(`Member`)는 도서 관리 기능이 불필요하지만, 상위 클래스의 추상 메서드로 지정되어 있어 **사용하지도 않는 메서드를 강제로 오버라이딩하여 구현**해야 한다.
- 자신이 사용하지 않는 메서드에 의존하지 않아야 한다는 **ISP에 명백히 반한다.** (해당 관리 기능은 관리자 전용 인터페이스로 분리되어야 한다.)

---

### 소제목 4: DIP 및 OCP (의존역전 및 개방-폐쇄 원칙) 위반

#### 1) 어긋나는 코드
```java
class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    ...
    public void addMember(Member member) {
        users.add(member);
    }

    public void addManager(Manager manager) {
        users.add(manager);
    }
}
```

#### 2) 위반 이유 및 분석
- **DIP 위반**: `Library`는 `User`라는 추상화 타입 리스트(`users`)를 보유하고 있음에도 불구하고, `addMember(Member member)`와 `addManager(Manager manager)`처럼 **구체 클래스인 `Member`와 `Manager`에 직접 의존**하고 있다.
- **OCP 위반**: 향후 새로운 사용자 유형(예: `Admin`, `VIPUser`)이 추가되면 `Library` 클래스를 수정하여 `addAdmin()`, `addVIPUser()` 메서드를 계속 추가해야 하므로 **수정에는 닫혀있어야 한다는 OCP를 위반**한다.
