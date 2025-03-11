import java.util.ArrayList;  // Importing ArrayList class (ArrayList sınıfını içeri aktarma)
import java.time.LocalDate;  // Importing LocalDate class for date operations (Tarih işlemleri için LocalDate sınıfını içeri aktarma)

public class Member {
    private static int counter = 1;  // Counter to generate unique member IDs (Benzersiz üye ID'leri oluşturmak için sayaç)
    private final int memberId;  // Unique ID for each member (Her üye için benzersiz ID)
    private String firstName;  // Member's first name (Üyenin adı)
    private String lastName;  // Member's last name (Üyenin soyadı)
    private String phone;  // Member's phone number (Üyenin telefon numarası)
    private final ArrayList<Book> borrowHistory = new ArrayList<>();  // List to store borrow history (Ödünç alma geçmişini saklamak için liste)
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();  // List to store current borrowed books (Şu anda ödünç alınan kitapları saklamak için liste)

    public Member(String firstName, String lastName, String phone) {
        this.memberId = counter++;  // Assign unique member ID and increment counter (Benzersiz üye ID'sini atar ve sayaç artırılır)
        this.firstName = firstName;  // Set the member's first name (Üyenin adını ayarlar)
        this.lastName = lastName;  // Set the member's last name (Üyenin soyadını ayarlar)
        this.phone = phone;  // Set the member's phone number (Üyenin telefon numarasını ayarlar)
    }

    public int getMemberId() {
        return memberId;  // Return the unique member ID (Benzersiz üye ID'sini döndürür)
    }

    public String getPhone() {
        return phone;  // Return the member's phone number (Üyenin telefon numarasını döndürür)
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;  // Set the member's first name (Üyenin adını ayarlar)
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;  // Set the member's last name (Üyenin soyadını ayarlar)
    }

    public void setPhone(String phone) {
        this.phone = phone;  // Set the member's phone number (Üyenin telefon numarasını ayarlar)
    }

    public boolean borrowBook(Book book) {
        if (book != null && book.isAvailable()) {  // Check if the book is not null and available (Kitap null değilse ve mevcutsa)
            LocalDate borrowDate = LocalDate.now();  // Get the current date as the borrow date (Ödünç alma tarihini almak için geçerli tarihi alır)
            book.setBorrowDate(borrowDate);  // Set the borrow date for the book (Kitap için ödünç alma tarihini ayarlar)
            borrowedBooks.add(book);  // Add the book to the borrowed books list (Kitabı ödünç alınan kitaplar listesine ekler)
            borrowHistory.add(book);  // Add the book to the borrow history (Kitabı ödünç alma geçmişine ekler)
            book.setAvailable(false);  // Mark the book as unavailable (Kitabı mevcut olmayan olarak işaretler)
            return true;  // Return true indicating the book has been borrowed successfully (Kitap başarıyla ödünç alındı)
        }
        return false;  // Return false if the book is not available (Kitap mevcut değilse false döner)
    }

    public boolean returnBook(Book book) {
        if (borrowedBooks.contains(book)) {  // Check if the book is in the borrowed books list (Kitap ödünç alınan kitaplar listesinde var mı?)
            LocalDate returnDate = LocalDate.now();  // Get the current date as the return date (Ödünç verilen tarih olarak geçerli tarihi alır)
            book.setReturnDate(returnDate);  // Set the return date for the book (Kitap için iade tarihini ayarlar)
            book.setAvailable(true);  // Mark the book as available (Kitabı mevcut olarak işaretler)
            borrowedBooks.remove(book);  // Remove the book from the borrowed books list (Kitabı ödünç alınan kitaplar listesinden çıkarır)
            return true;  // Return true indicating the book has been successfully returned (Kitap başarıyla iade edildi)
        }
        return false;  // Return false if the book is not found in the borrowed books list (Kitap ödünç alınan kitaplar listesinde yoksa false döner)
    }

    public void showBorrowHistory() {
        if (borrowHistory.isEmpty()) {  // Check if there are no borrowed books (Ödünç alınan kitap yoksa kontrol eder)
            System.out.println("No borrowed books found.");  // If no books are borrowed, print this message (Hiçbir kitap ödünç alınmamışsa bu mesajı yazdırır)
        } else {
            System.out.println("Borrowed Books History:");  // Prints the history of borrowed books (Ödünç alınan kitapların geçmişini yazdırır)
            for (Book book : borrowHistory) {  // Loop through the borrow history and display each book (Ödünç alınan kitapları sırasıyla yazdırır)
                System.out.println(book);  // Print details of each borrowed book (Her ödünç alınan kitabın bilgilerini yazdırır)
            }
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +  // Member ID (Üye ID'si)
                ", firstName='" + firstName + '\'' +  // First name of the member (Üyenin adı)
                ", lastName='" + lastName + '\'' +  // Last name of the member (Üyenin soyadı)
                ", phone='" + phone + '\'' +  // Phone number of the member (Üyenin telefon numarası)
                '}';  // Return the member's information as a string (Üyenin bilgilerini bir string olarak döndürür)
    }
}
