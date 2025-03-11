import java.util.ArrayList;  // Provides a resizable array implementation of the List interface (Liste arayüzünün değiştirilebilir bir dizi uygulamasını sağlar)
import java.util.Collections;  // Contains static methods for operating on collections (Koleksiyonlar üzerinde işlem yapmak için statik metodlar içerir)
import java.util.Comparator;  // Used to define custom sorting logic for collections (Koleksiyonlar için özel sıralama mantığı tanımlamak için kullanılır)

public class Library {
    private ArrayList<Book> bookList = new ArrayList<>();  // List to store the books in the library (Kütüphanedeki kitapları tutan liste)
    private ArrayList<Member> memberList = new ArrayList<>();  // List to store the members of the library (Kütüphanedeki üyeleri tutan liste)


    public void addBook(Book book) {
        bookList.add(book);  // Adds a book to the list (Kitap listeye eklenir)
    }


    public Book removeBook(String isbn) {
        for (Book book : bookList) {  // Iterates through the list of books (Kitap listesini döngü ile kontrol eder)
            if (book.getIsbn().equals(isbn)) {  // Checks if the book's ISBN matches the given ISBN (Kitabın ISBN'si verilen ISBN ile eşleşiyorsa)
                bookList.remove(book);  // Removes the book from the list (Kitap listeden çıkarılır)
                return book;  // Returns the removed book (Çıkarılan kitap geri döndürülür)
            }
        }
        return null;  // If no book is found with the given ISBN, returns null (Verilen ISBN ile eşleşen kitap bulunamazsa null döndürülür)
    }


    public Book searchBook(String isbn) {
        for (Book book : bookList) {  // Iterates through the list of books (Kitaplar listesinde döngü başlatır)
            if (book.getIsbn().equals(isbn)) {  // Checks if the book's ISBN matches the given ISBN (Kitabın ISBN'si verilen ISBN ile eşleşiyorsa)
                return book;  // Returns the book if found (Kitap bulunduysa, kitabı geri döndürür)
            }
        }
        return null;  // If no book is found with the given ISBN, returns null (Verilen ISBN ile eşleşen kitap bulunamazsa null döndürülür)
    }


    public void listBooks() {
        if (bookList.isEmpty()) {  // Checks if the book list is empty (Kitap listesi boşsa kontrol eder)
            System.out.println("No books available in the library.");  // Displays a message if no books are available (Hiç kitap yoksa mesaj gösterir)
        } else {
            for (Book book : bookList) {  // Iterates through the list of books (Kitaplar listesinde döngü başlatır)
                System.out.println(book);  // Prints each book in the list (Listedeki her kitabı yazdırır)
            }
        }
    }


    public boolean checkBookAvailability(String isbn) {
        for (Book book : bookList) {  // Iterates through the list of books (Kitaplar listesinde döngü başlatır)
            if (book.getIsbn().equals(isbn)) {  // Checks if the book's ISBN matches the given ISBN (Kitabın ISBN'si verilen ISBN ile eşleşiyorsa)
                System.out.println("Book available: " + book);  // Prints a message indicating the book is available (Kitabın mevcut olduğunu belirten mesajı yazdırır)
                return true;  // Returns true if the book is available (Kitap mevcutsa true döndürür)
            }
        }
        System.out.println("Book is not available.");  // If the book is not found, prints a message (Kitap bulunmazsa, mesaj yazdırır)
        return false;  // Returns false if the book is not available (Kitap mevcut değilse false döndürür)
    }


    public void addMember(Member member) {
        memberList.add(member);  // Adds a member to the member list (Bir üyeyi üye listesine ekler)
    }


    public Member removeMember(String phone) {
        for (Member member : memberList) {  // Iterates through the list of members (Üyeler listesini döngüyle gezerek)
            if (member.getPhone().equals(phone)) {  // Checks if the member's phone matches the given phone number (Üyenin telefon numarası verilen telefon numarasıyla eşleşiyorsa)
                memberList.remove(member);  // Removes the member from the list (Üyeyi listeden çıkarır)
                return member;  // Returns the removed member (Çıkarılan üyeyi döndürür)
            }
        }
        return null;  // Returns null if the member is not found (Üye bulunmazsa null döndürür)
    }


    public Member searchMember(String phone) {
        for (Member member : memberList) {  // Iterates through the list of members (Üyeler listesini döngüyle gezerek)
            if (member.getPhone().equals(phone)) {  // Checks if the member's phone matches the given phone number (Üyenin telefon numarası verilen telefon numarasıyla eşleşiyorsa)
                return member;  // Returns the found member (Bulunan üyeyi döndürür)
            }
        }
        return null;  // Returns null if the member is not found (Üye bulunmazsa null döndürür)
    }


    public ArrayList<Member> getMemberList() {
        return memberList;  // Returns the list of members (Üyeler listesini döndürür)
    }


    public void sortMemberListById() {
        // Sorts the member list by member ID (Üye listesini üye ID'sine göre sıralar)
        Collections.sort(memberList, new Comparator<Member>() {
            @Override
            public int compare(Member member1, Member member2) {
                return Integer.compare(member1.getMemberId(), member2.getMemberId());  // Compares the member IDs (Üye ID'lerini karşılaştırır)
            }
        });
    }


    public boolean updateMember(String phone, String newFirstName, String newLastName, String newPhone) {
        Member member = searchMember(phone);  // Finds the member by phone number (Üyeyi telefon numarasına göre bulur)
        if (member != null) {
            member.setFirstName(newFirstName);  // Updates the first name of the member (Üyenin adını günceller)
            member.setLastName(newLastName);    // Updates the last name of the member (Üyenin soyadını günceller)
            member.setPhone(newPhone);          // Updates the phone number of the member (Üyenin telefon numarasını günceller)
            return true;
        }
        return false;  // Returns false if the member is not found (Üye bulunamazsa false döner)
    }


    public void showBorrowHistory(String phone) {
        Member member = searchMember(phone);  // Finds the member by phone number (Üyeyi telefon numarasına göre bulur)
        if (member != null) {
            member.showBorrowHistory();  // Displays the borrow history of the member (Üyenin ödünç alma geçmişini gösterir)
        } else {
            System.out.println("Member not found.");  // Prints a message if the member is not found (Üye bulunamazsa mesaj yazdırır)
        }
    }


    public boolean borrowBook(Book book, Member member) {
        if (book != null && member != null && book.isAvailable()) {  // Checks if the book and member exist, and if the book is available (Kitap ve üye var mı, kitap kullanılabilir mi kontrol eder)
            book.setAvailable(false);  // Marks the book as borrowed (Kitabı ödünç alındı olarak işaretler)
            book.setBorrowDate(java.time.LocalDate.now());  // Sets the current date as the borrow date (Ödünç alınan tarihi bugünün tarihi olarak ayarlar)
            member.borrowBook(book);  // Adds the book to the member's borrowed books list (Kitabı üyenin ödünç kitaplar listesine ekler)
            System.out.println("Book borrowed: " + book.getTitle() + " (" + book.getIsbn() + ")");  // Prints the book's title and ISBN (Kitabın başlığı ve ISBN'sini yazdırır)
            return true;
        }
        System.out.println("Book could not be borrowed.");  // Prints a message if the book could not be borrowed (Kitap ödünç alınamadı mesajı yazdırır)
        return false;
    }


    public boolean returnBook(Book book) {
        if (book != null && !book.isAvailable()) {  // Checks if the book exists and is currently borrowed (Kitap var mı ve şu anda ödünç alınmış mı kontrol eder)
            book.setAvailable(true);  // Marks the book as available (Kitabı kullanılabilir olarak işaretler)
            book.setReturnDate(java.time.LocalDate.now());  // Sets the current date as the return date (İade edilen tarihi bugünün tarihi olarak ayarlar)
            System.out.println("Book returned: " + book.getTitle() + " (" + book.getIsbn() + ")");  // Prints the book's title and ISBN (Kitabın başlığı ve ISBN'sini yazdırır)
            return true;
        }
        System.out.println("Book could not be returned.");  // Prints a message if the book could not be returned (Kitap iade edilemedi mesajı yazdırır)
        return false;
    }


    public boolean verifyMemberInfo(String phone) {
        for (Member member : memberList) {  // Loops through the list of members to find a match (Üye listesinde eşleşen bir telefon numarası arar)
            if (member.getPhone().equals(phone)) {  // If a member with the given phone number is found (Verilen telefon numarasına sahip bir üye bulunursa)
                System.out.println("Member registered: " + member);  // Prints the member's details (Üyenin bilgilerini yazdırır)
                return true;  // Returns true if the member is found (Üye bulunduysa true döner)
            }
        }
        System.out.println("No registered member found in the system.");  // If no member is found with the given phone number (Verilen telefon numarasına sahip üye bulunmazsa)
        return false;  // Returns false if no match is found (Eşleşme bulunmazsa false döner)
    }

}