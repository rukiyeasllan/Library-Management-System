import java.util.Scanner; // Import the Scanner class to take input from the user (Kullanıcıdan giriş almak için Scanner sınıfını içe aktar)

public class Main { // Main class that contains the program's entry point (Programın başlangıç noktası olan ana sınıf)
    public static void main(String[] args) { // The main method, the entry point of the program (Ana yöntem, programın başlangıç noktası)
        Scanner scanner = new Scanner(System.in);  // Create a scanner object to take user input (Kullanıcı girişi almak için bir scanner nesnesi oluşturuluyor)
        Library library = new Library();  // Create a Library object to manage the library system (Kütüphane sistemini yönetmek için bir Library nesnesi oluşturuluyor)

        while (true) {  // Infinite loop to keep showing the menu until the user decides to exit (Kullanıcı çıkana kadar menüyü göstermeye devam etmek için sonsuz döngü)
            System.out.println("\n--- Library Management System ---");  // Display the menu title (Menü başlığını ekrana yazdır)
            System.out.println("1. Add Book");  // Option to add a new book (Yeni bir kitap ekleme seçeneği)
            System.out.println("2. Delete Book");  // Option to delete an existing book (Mevcut bir kitabı silme seçeneği)
            System.out.println("3. List Books");  // Option to list all books (Tüm kitapları listeleme seçeneği)
            System.out.println("4. Search Book");  // Option to search for a book (Bir kitap arama seçeneği)
            System.out.println("5. Check Book Availability");  // Option to check if a book is available (Bir kitabın mevcut olup olmadığını kontrol etme seçeneği)
            System.out.println("6. Add Member");  // Option to add a new member (Yeni bir üye ekleme seçeneği)
            System.out.println("7. Delete Member");  // Option to delete an existing member (Mevcut bir üyeyi silme seçeneği)
            System.out.println("8. List Members");  // Option to list all members (Tüm üyeleri listeleme seçeneği)
            System.out.println("9. Search Member");  // Option to search for a member (Bir üyeyi arama seçeneği)
            System.out.println("10. Update Member Info");  // Option to update a member's information (Bir üyenin bilgilerini güncelleme seçeneği)
            System.out.println("11. Borrow Book");  // Option for a member to borrow a book (Bir üyenin kitap ödünç alma seçeneği)
            System.out.println("12. View Member Borrow History");  // Option to view a member's borrow history (Bir üyenin ödünç alma geçmişini görüntüleme seçeneği)
            System.out.println("13. Member Verification");  // Option to verify a member (Bir üyeyi doğrulama seçeneği)
            System.out.println("14. Return Book");  // Option to return a borrowed book (Ödünç alınan kitabı geri verme seçeneği)
            System.out.println("15. Exit");  // Option to exit the program (Programdan çıkma seçeneği)
            System.out.print("Please select an option: ");  // Prompt user to select an option (Kullanıcıdan bir seçenek seçmesini istemek)
            int choice = scanner.nextInt();  // Read the user's choice (Kullanıcının seçimini oku)
            scanner.nextLine();  // Consume the newline character after reading an integer (Bir tamsayı okuduktan sonra yeni satır karakterini tüket)



            switch (choice) {  // Check which option the user selected (Kullanıcının hangi seçeneği seçtiğini kontrol et)
                case 1:  // Case for adding a new book (Yeni bir kitap eklemek için durum)
                    System.out.print("Book ISBN: ");  // Prompt the user to enter the book's ISBN (Kullanıcıdan kitabın ISBN numarasını girmesini iste)
                    String isbn = scanner.nextLine();  // Read the ISBN input from the user (Kullanıcının ISBN girişini oku)
                    System.out.print("Book Title: ");  // Prompt the user to enter the book's title (Kullanıcıdan kitabın başlığını girmesini iste)
                    String bookTitle = scanner.nextLine();  // Read the book title input from the user (Kullanıcının kitap başlığını girmesini oku)
                    System.out.print("Author: ");  // Prompt the user to enter the author's name (Kullanıcıdan yazar adını girmesini iste)
                    String author = scanner.nextLine();  // Read the author's name input from the user (Kullanıcının yazar adını girmesini oku)
                    System.out.print("Year: ");  // Prompt the user to enter the publication year (Kullanıcıdan kitabın yayın yılına dair bilgi girmesini iste)
                    int year = scanner.nextInt();  // Read the publication year input from the user (Kullanıcının yayın yılı bilgisini oku)
                    scanner.nextLine();  // Consume the newline character after reading an integer (Bir tamsayı okuduktan sonra yeni satır karakterini tüket)
                    Book newBook = new Book(isbn, bookTitle, author, year);  // Create a new Book object with the provided details (Verilen bilgilerle yeni bir Book nesnesi oluştur)
                    library.addBook(newBook);  // Add the new book to the library (Yeni kitabı kütüphaneye ekle)
                    System.out.println("Book successfully added.");  // Notify the user that the book has been added successfully (Kullanıcıya kitabın başarıyla eklendiğini bildir)
                    break;  // Exit the switch case (Switch case'den çık)



                case 2:  // Case for deleting a book (Bir kitabı silmek için durum)
                    System.out.print("Enter the ISBN of the book you want to delete: ");  // Prompt the user to enter the ISBN of the book to be deleted (Kullanıcıdan silmek istediği kitabın ISBN numarasını girmesini iste)
                    String deleteIsbn = scanner.nextLine();  // Read the ISBN of the book to be deleted (Silinecek kitabın ISBN numarasını oku)
                    Book deletedBook = library.removeBook(deleteIsbn);  // Attempt to remove the book from the library by ISBN (Kitabı kütüphaneden ISBN numarasına göre silmeye çalış)
                    if (deletedBook != null) {  // Check if the book was successfully removed (Kitap başarılı bir şekilde silindiyse kontrol et)
                        System.out.println("Deleted book: " + deletedBook);  // Inform the user that the book was deleted (Kitabın silindiğini kullanıcıya bildir)
                    } else {  // If the book was not found (Kitap bulunamazsa)
                        System.out.println("Book not found.");  // Notify the user that the book was not found (Kitap bulunamadığını kullanıcıya bildir)
                    }
                    break;  // Exit the case (Durumdan çık)



                case 3:  // Case for listing all books (Tüm kitapları listelemek için durum)
                    library.listBooks();  // List all the books in the library (Kütüphanedeki tüm kitapları listele)
                    break;  // Exit the case (Durumdan çık)



                case 4:  // Case for searching a book (Bir kitabı aramak için durum)
                    System.out.print("Enter the ISBN of the book you want to search: ");  // Prompt the user to enter the ISBN of the book to search (Kullanıcıdan aramak istediği kitabın ISBN numarasını girmesini iste)
                    String searchIsbn = scanner.nextLine();  // Read the ISBN input for the book to search (Aranacak kitabın ISBN numarasını oku)
                    Book foundBook = library.searchBook(searchIsbn);  // Attempt to find the book in the library by ISBN (Kitabı kütüphanede ISBN numarasına göre aramaya çalış)
                    if (foundBook != null) {  // If the book is found (Kitap bulunduysa)
                        System.out.println("Found book: " + foundBook);  // Inform the user that the book was found (Kitabın bulunduğunu kullanıcıya bildir)
                    } else {  // If the book is not found (Kitap bulunamazsa)
                        System.out.println("Book not found.");  // Notify the user that the book was not found (Kitap bulunamadığını kullanıcıya bildir)
                    }
                    break;  // Exit the case (Durumdan çık)



                case 5:  // Case for checking book availability (Kitap mevcudiyetini kontrol etmek için durum)
                    System.out.print("Enter the ISBN of the book you want to check: ");  // Prompt the user to enter the ISBN of the book to check its availability (Kullanıcıdan kontrol etmek istediği kitabın ISBN numarasını girmesini iste)
                    String checkIsbn = scanner.nextLine();  // Read the ISBN input for the book availability check (Kitabın mevcudiyetini kontrol etmek için ISBN numarasını oku)
                    library.checkBookAvailability(checkIsbn);  // Check if the book is available in the library (Kitabın kütüphanede mevcut olup olmadığını kontrol et)
                    break;  // Exit the case (Durumdan çık)



                case 6:  // Case for adding a new member (Yeni bir üye eklemek için durum)
                    System.out.print("Member first name: ");  // Prompt the user to enter the member's first name (Kullanıcıdan üyenin adını girmesini iste)
                    String memberFirstName = scanner.nextLine();  // Read the first name input for the member (Üyenin adını oku)
                    System.out.print("Member last name: ");  // Prompt the user to enter the member's last name (Kullanıcıdan üyenin soyadını girmesini iste)
                    String memberLastName = scanner.nextLine();  // Read the last name input for the member (Üyenin soyadını oku)
                    System.out.print("Member phone: ");  // Prompt the user to enter the member's phone number (Kullanıcıdan üyenin telefon numarasını girmesini iste)
                    String memberPhone = scanner.nextLine();  // Read the phone number input for the member (Üyenin telefon numarasını oku)
                    Member newMember = new Member(memberFirstName, memberLastName, memberPhone);  // Create a new Member object with the provided details (Verilen bilgilerle yeni bir Member nesnesi oluştur)
                    library.addMember(newMember);  // Add the new member to the library (Yeni üyeyi kütüphaneye ekle)
                    System.out.println("Member successfully added.");  // Inform the user that the member was successfully added (Kullanıcıya üyenin başarıyla eklendiğini bildir)
                    break;  // Exit the case (Durumdan çık)



                case 7:  // Case for deleting a member (Bir üyeyi silmek için durum)
                    System.out.print("Enter the phone number of the member you want to delete: ");  // Prompt the user to enter the phone number of the member to delete (Kullanıcıdan silmek istediği üyenin telefon numarasını girmesini iste)
                    String deletePhone = scanner.nextLine();  // Read the phone number input for the member to be deleted (Silinecek üyenin telefon numarasını oku)
                    Member deletedMember = library.removeMember(deletePhone);  // Attempt to remove the member from the library by phone number (Üyeyi telefon numarasına göre kütüphaneden silmeye çalış)
                    if (deletedMember != null) {  // Check if the member was successfully removed (Üye başarılı bir şekilde silindiyse kontrol et)
                        System.out.println("Deleted member: " + deletedMember);  // Inform the user that the member was deleted (Üyenin silindiğini kullanıcıya bildir)
                    } else {  // If the member was not found (Üye bulunamazsa)
                        System.out.println("Member not found.");  // Notify the user that the member was not found (Üye bulunamadığını kullanıcıya bildir)
                    }
                    break;  // Exit the case (Durumdan çık)



                case 8:  // Case for listing all members (Tüm üyeleri listelemek için durum)
                    System.out.println("Member List:");  // Print the header for the member list (Üye listesi başlığını yazdır)
                    for (Member m : library.getMemberList()) {  // Loop through all the members in the library (Kütüphanedeki tüm üyeleri dolaş)
                        System.out.println(m);  // Print each member's details (Her üyenin bilgilerini yazdır)
                    }
                    break;  // Exit the case (Durumdan çık)



                case 9:  // Case for searching a member (Bir üyeyi aramak için durum)
                    System.out.print("Enter the phone number of the member you want to search: ");  // Prompt the user to enter the phone number of the member to search (Kullanıcıdan aramak istediği üyenin telefon numarasını girmesini iste)
                    String searchPhone = scanner.nextLine();  // Read the phone number input for the member (Üyenin telefon numarasını oku)
                    Member foundMember = library.searchMember(searchPhone);  // Attempt to find the member in the library by phone number (Üyeyi kütüphanede telefon numarasına göre aramaya çalış)
                    if (foundMember != null) {  // If the member is found (Üye bulunduysa)
                        System.out.println("Found member: " + foundMember);  // Inform the user that the member was found (Üyenin bulunduğunu kullanıcıya bildir)
                    } else {  // If the member is not found (Üye bulunamazsa)
                        System.out.println("Member not found.");  // Notify the user that the member was not found (Üye bulunamadığını kullanıcıya bildir)
                    }
                    break;  // Exit the case (Durumdan çık)



                case 10:  // Case for updating member information (Üye bilgilerini güncellemek için durum)
                    System.out.print("Enter the phone number of the member whose information you want to update: ");  // Prompt the user to enter the phone number of the member to update (Kullanıcıdan bilgilerini güncellemek istediği üyenin telefon numarasını girmesini iste)
                    String updatePhone = scanner.nextLine();  // Read the phone number input for the member whose info will be updated (Bilgileri güncellenmek istenen üyenin telefon numarasını oku)
                    System.out.print("New First Name: ");  // Prompt the user to enter the new first name (Kullanıcıdan yeni adını girmesini iste)
                    String newFirstName = scanner.nextLine();  // Read the new first name for the member (Üye için yeni adı oku)
                    System.out.print("New Last Name: ");  // Prompt the user to enter the new last name (Kullanıcıdan yeni soyadını girmesini iste)
                    String newLastName = scanner.nextLine();  // Read the new last name for the member (Üye için yeni soyadı oku)
                    System.out.print("New Phone Number: ");  // Prompt the user to enter the new phone number (Kullanıcıdan yeni telefon numarasını girmesini iste)
                    String newPhone = scanner.nextLine();  // Read the new phone number for the member (Üye için yeni telefon numarasını oku)
                    boolean updateStatus = library.updateMember(updatePhone, newFirstName, newLastName, newPhone);  // Try to update the member's information (Üyenin bilgilerini güncellemeye çalış)
                    if (updateStatus) {  // If the update was successful (Güncelleme başarılıysa)
                        System.out.println("Member information successfully updated.");  // Notify the user that the member information was successfully updated (Üye bilgisinin başarıyla güncellendiğini kullanıcıya bildir)
                    } else {  // If the member was not found (Üye bulunamazsa)
                        System.out.println("Member not found.");  // Notify the user that the member was not found (Üye bulunamadığını kullanıcıya bildir)
                    }
                    break;  // Exit the case (Durumdan çık)



                case 11:  // Case for borrowing a book (Bir kitabı ödünç almak için durum)
                    System.out.print("Enter the ISBN of the book you want to borrow: ");  // Prompt the user to enter the ISBN of the book to borrow (Kullanıcıdan ödünç almak istediği kitabın ISBN numarasını girmesini iste)
                    String borrowIsbn = scanner.nextLine();  // Read the ISBN input for the book to borrow (Ödünç alınacak kitabın ISBN numarasını oku)
                    System.out.print("Enter the member's phone number: ");  // Prompt the user to enter the member's phone number (Kullanıcıdan üyenin telefon numarasını girmesini iste)
                    String memberPhoneBorrow = scanner.nextLine();  // Read the phone number input for the member borrowing the book (Kitabı ödünç alacak üyenin telefon numarasını oku)
                    Book borrowedBook = library.searchBook(borrowIsbn);  // Search for the book in the library by ISBN (Kitabı kütüphanede ISBN numarasına göre ara)
                    Member borrowingMember = library.searchMember(memberPhoneBorrow);  // Search for the member in the library by phone number (Üyeyi kütüphanede telefon numarasına göre ara)
                    if (borrowedBook != null && borrowingMember != null) {  // If both the book and member are found (Eğer kitap ve üye bulunursa)
                        borrowingMember.borrowBook(borrowedBook);  // Borrow the book for the member (Kitabı üye için ödünç al)
                        System.out.println("Book borrowed. Borrow date: " + borrowedBook.getBorrowDate());  // Notify the user that the book has been borrowed and show the borrow date (Kitabın ödünç alındığını ve ödünç alma tarihini kullanıcıya bildir)
                    } else {  // If the book or member is not found (Eğer kitap veya üye bulunamazsa)
                        System.out.println("Book or member not found.");  // Notify the user that the book or member was not found (Kitap veya üye bulunamadığını kullanıcıya bildir)
                    }
                    break;  // Exit the case (Durumdan çık)



                case 12:  // Case for viewing a member's borrow history (Bir üyenin ödünç alma geçmişini görüntülemek için durum)
                    System.out.print("Enter the phone number of the member whose borrow history you want to view: ");  // Prompt the user to enter the phone number of the member whose borrow history is to be viewed (Kullanıcıdan ödünç alma geçmişini görmek istediği üyenin telefon numarasını girmesini iste)
                    String historyPhone = scanner.nextLine();  // Read the phone number input for the member whose borrow history will be shown (Ödünç alma geçmişi gösterilecek üyenin telefon numarasını oku)
                    library.showBorrowHistory(historyPhone);  // Show the borrow history for the member (Üyenin ödünç alma geçmişini göster)
                    break;  // Exit the case (Durumdan çık)



                case 13:  // Case for verifying a member's information (Bir üyenin bilgilerini doğrulamak için durum)
                    System.out.print("Enter the phone number of the member you want to verify: ");  // Prompt the user to enter the phone number of the member to verify (Kullanıcıdan doğrulamak istediği üyenin telefon numarasını girmesini iste)
                    String verificationPhone = scanner.nextLine();  // Read the phone number input for the member to verify (Doğrulamak istenen üyenin telefon numarasını oku)
                    boolean verificationResult = library.verifyMemberInfo(verificationPhone);  // Verify the member's information (Üyenin bilgilerini doğrula)
                    if (verificationResult) {  // If the member's information is successfully verified (Eğer üyenin bilgileri başarıyla doğrulanırsa)
                        System.out.println("Member verified.");  // Notify the user that the member has been verified (Üyenin doğrulandığını kullanıcıya bildir)
                    } else {  // If the member's information verification failed (Eğer üyenin bilgileri doğrulanamazsa)
                        System.out.println("Member verification failed.");  // Notify the user that the member verification failed (Üye doğrulaması başarısız olduğunda kullanıcıya bildir)
                    }
                    break;  // Exit the case (Durumdan çık)



                case 14:  // Case for returning a book (Bir kitabı iade etmek için durum)
                    System.out.print("Enter the ISBN of the book you want to return: ");  // Prompt the user to enter the ISBN of the book to return (Kullanıcıdan iade etmek istediği kitabın ISBN numarasını girmesini iste)
                    String returnIsbn = scanner.nextLine();  // Read the ISBN input for the book to return (İade edilecek kitabın ISBN numarasını oku)
                    Book returnedBook = library.searchBook(returnIsbn);  // Search for the book in the library by ISBN (Kitabı kütüphanede ISBN numarasına göre ara)
                    if (library.returnBook(returnedBook)) {  // If the book can be returned successfully (Eğer kitap başarılı bir şekilde iade edilebiliyorsa)
                        System.out.println("Book successfully returned.");  // Notify the user that the book was successfully returned (Kitabın başarıyla iade edildiğini kullanıcıya bildir)
                    } else {  // If the book could not be returned (Eğer kitap iade edilemezse)
                        System.out.println("Book could not be returned.");  // Notify the user that the book could not be returned (Kitap iade edilemediğini kullanıcıya bildir)
                    }
                    break;  // Exit the case (Durumdan çık)



                case 15:  // Case for exiting the program (Programdan çıkmak için durum)
                    System.out.println("Exiting...");  // Notify the user that the program is exiting (Kullanıcıya programın çıktığını bildir)
                    scanner.close();  // Close the scanner to release resources (Kaynakları serbest bırakmak için scanner'ı kapat)
                    return;  // Exit the main method and end the program (Ana metoddan çık ve programı sonlandır)
            }

        }
    }
}