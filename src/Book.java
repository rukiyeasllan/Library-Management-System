import java.time.LocalDate;  // Importing LocalDate class for date operations (Tarih işlemleri için LocalDate sınıfını içeri aktarma)

public class Book {
    private String isbn;  // ISBN number of the book (Kitabın ISBN numarası)
    private String title;  // Title of the book (Kitabın başlığı)
    private String author;  // Author of the book (Kitabın yazarı)
    private int publicationYear;  // Year the book was published (Kitabın yayımlandığı yıl)
    private boolean available;  // Availability of the book (Kitabın mevcut olup olmadığı)
    private String borrowedByMember;  // Phone number of the member who borrowed the book (Kitabı ödünç alan üyenin telefon numarası)
    private LocalDate borrowDate;  // Date the book was borrowed (Kitabın ödünç alındığı tarih)
    private LocalDate returnDate;  // Date the book was returned (Kitabın geri verildiği tarih)

    public Book(String isbn, String title) {
        this.isbn = isbn;  // Sets the ISBN of the book (Kitabın ISBN numarasını ayarlar)
        this.title = title;  // Sets the title of the book (Kitabın başlığını ayarlar)
        this.available = true;  // By default, the book is available (Varsayılan olarak kitap mevcut)
        this.borrowDate = null;  // Initially, the book has not been borrowed (Başlangıçta, kitap ödünç alınmamıştır)
        this.returnDate = null;  // Initially, the return date is null (Başlangıçta, geri dönüş tarihi yoktur)
    }

    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;  // Sets the ISBN of the book (Kitabın ISBN numarasını ayarlar)
        this.title = title;  // Sets the title of the book (Kitabın başlığını ayarlar)
        this.author = author;  // Sets the author of the book (Kitabın yazarını ayarlar)
        this.publicationYear = publicationYear;  // Sets the publication year of the book (Kitabın basım yılını ayarlar)
        this.available = true;  // By default, the book is available for borrowing (Varsayılan olarak, kitap ödünç almak için mevcut)
        this.borrowedByMember = null;  // Initially, no member has borrowed the book (Başlangıçta, hiçbir üye kitabı ödünç almamıştır)
        this.borrowDate = null;  // Initially, the book has not been borrowed (Başlangıçta, kitap ödünç alınmamıştır)
        this.returnDate = null;  // Initially, the return date is null (Başlangıçta, geri dönüş tarihi yoktur)
    }

    public String getIsbn() {
        return isbn;  // Returns the ISBN of the book (Kitabın ISBN numarasını döndürür)
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;  // Sets the ISBN of the book (Kitabın ISBN numarasını ayarlar)
    }

    public String getTitle() {
        return title;  // Returns the title of the book (Kitabın başlığını döndürür)
    }

    public void setTitle(String title) {
        this.title = title;  // Sets the title of the book (Kitabın başlığını ayarlar)
    }

    public String getAuthor() {
        return author;  // Returns the author of the book (Kitabın yazarını döndürür)
    }

    public void setAuthor(String author) {
        this.author = author;  // Sets the author of the book (Kitabın yazarını ayarlar)
    }

    public int getPublicationYear() {
        return publicationYear;  // Returns the publication year of the book (Kitabın basım yılını döndürür)
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;  // Sets the publication year of the book (Kitabın basım yılını ayarlar)
    }

    public boolean isAvailable() {
        return available;  // Returns whether the book is available (Kitap mevcut mu olduğunu döndürür)
    }

    public void setAvailable(boolean available) {
        this.available = available;  // Sets the availability status of the book (Kitabın mevcutluk durumunu ayarlar)
    }

    public String getBorrowedByMember() {
        return borrowedByMember;  // Returns the name or phone number of the member who borrowed the book (Kitabı ödünç alan üyenin adını veya telefon numarasını döndürür)
    }

    public void setBorrowedByMember(String borrowedByMember) {
        this.borrowedByMember = borrowedByMember;  // Sets the member who borrowed the book (Kitabı ödünç alan üyeyi ayarlar)
    }

    public LocalDate getBorrowDate() {
        return borrowDate;  // Returns the borrow date of the book (Kitabın ödünç alınma tarihini döndürür)
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;  // Sets the borrow date of the book (Kitabın ödünç alınma tarihini ayarlar)
    }

    public LocalDate getReturnDate() {
        return returnDate;  // Returns the return date of the book (Kitabın geri teslim tarihini döndürür)
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;  // Sets the return date of the book (Kitabın geri teslim tarihini ayarlar)
    }

    public boolean borrow(String memberPhone) {
        if (this.available) {  // Checks if the book is available (Kitap mevcut mu diye kontrol eder)
            this.available = false;  // Marks the book as unavailable (Kitap mevcut olmayan olarak işaretlenir)
            this.borrowedByMember = memberPhone;  // Sets the member's phone number who borrowed the book (Kitabı ödünç alan üyenin telefon numarasını ayarlar)
            this.borrowDate = LocalDate.now();  // Sets the current date as the borrow date (Mevcut tarihi ödünç alınma tarihi olarak ayarlar)
            return true;  // Returns true indicating the book was successfully borrowed (Kitap başarılı bir şekilde ödünç alındı)
        }
        return false;  // Returns false if the book is not available (Kitap mevcut değilse false döner)
    }

    public boolean returnBook() {
        if (!this.available) {  // Checks if the book is not available (Kitap mevcut değilse kontrol eder)
            this.available = true;  // Marks the book as available again (Kitabı tekrar mevcut olarak işaretler)
            this.borrowedByMember = null;  // Clears the member's phone number who borrowed the book (Kitabı ödünç alan üyenin telefon numarasını temizler)
            this.returnDate = LocalDate.now();  // Sets the current date as the return date (Mevcut tarihi iade tarihi olarak ayarlar)
            this.borrowDate = null;  // Clears the borrow date (Ödünç alınma tarihini temizler)
            return true;  // Returns true indicating the book was successfully returned (Kitap başarıyla iade edildi)
        }
        return false;  // Returns false if the book was not borrowed (Kitap ödünç alınmamışsa false döner)
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + isbn + '\'' +  // ISBN of the book (Kitabın ISBN numarası)
                ", Title='" + title + '\'' +  // Title of the book (Kitabın adı)
                ", Author='" + author + '\'' +  // Author of the book (Kitabın yazarı)
                ", Publication Year=" + publicationYear +  // Year the book was published (Kitabın yayın yılı)
                ", Status=" + (available ? "Available" : "Borrowed") +  // Status of the book: Available or Borrowed (Kitabın durumu: Mevcut ya da Ödünç alındı)
                (available ? "" : ", Borrowed By Member='" + borrowedByMember + "', Borrow Date=" + borrowDate + ", Return Date=" + returnDate) +  // If borrowed, show member details and dates (Eğer ödünç alındıysa, üye bilgileri ve tarihleri gösterir)
                '}';
    }
}