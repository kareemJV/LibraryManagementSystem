import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Library {
    private List<Book> books;
    private String filePath;

    public Library(String filePath) {
        this.books = new ArrayList<>();
        this.filePath = filePath;
    }
    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooksToFile();
    }

    public void removeBook(Book book) {
        books.remove(book);
        saveBooksToFile();

    }

    public void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }
    private void saveBooksToFile() {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (Book book : books) {
                writer.println(book.getTitle() + ";" + book.getAuthor());
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern des Buchs.");
        }
    }

    private void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    String title = parts[0];
                    String author = parts[1];
                    books.add(new Book(title, author));
                }
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Laden des Buchs.");
        }
    }

    public void initializeFromExistingFile() {
        loadBooksFromFile();
    }
}