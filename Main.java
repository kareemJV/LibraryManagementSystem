import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Karee\\Desktop\\YouTube\\Bibliothekverwaltungssystem\\Books.txt"; // Pfad zur externen Textdatei
        Library library = new Library(filePath);
        library.initializeFromExistingFile();

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1. Anzeigen der Bücher");
            System.out.println("2. Buch hinzufügen");
            System.out.println("3. Buch entfernen");
            System.out.println("4. Programm beenden");
            System.out.print("Auswahl: ");

            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Geben Sie den Buchtitel ein: ");
                    String title = scanner.nextLine();
                    System.out.print("Geben Sie den Autor ein: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(title, author);
                    library.addBook(newBook);
                    System.out.println("Das Buch wurde hinzugefügt.");
                    break;
                case 3:
                    System.out.print("Geben Sie den Buchtitel ein, das Sie entfernen möchten: ");
                    String bookTitle = scanner.nextLine();
                    Book bookToRemove = null;
                    for (Book book : library.getBooks()) {
                        if (book.getTitle().equals(bookTitle)) {
                            bookToRemove = book;
                            break;
                        }
                    }
                    if (bookToRemove != null) {
                        library.removeBook(bookToRemove);
                        System.out.println("Das Buch wurde entfernt.");
                    } else {
                        System.out.println("Das Buch wurde nicht gefunden.");
                    }
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Das Programm wird beendet.");
                    break;
                default:
                    System.out.println("Ungültige Auswahl.");
                    break;
            }

            System.out.println();
        }
    }
}
