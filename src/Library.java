import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Library {
    // Lista dostępnych książek
    private static List<String> books = new ArrayList<>();

    // Lista zarezerwowanych książek
    private static List<String> reservedBooks = new ArrayList<>();

    public static void main(String[] args) {
        initializeBooks(); // Inicjalizacja książek
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Pętla główna programu biblioteki
        System.out.println(" ");
        System.out.println("Leshcyshena Karina , 123809");
        while (running) {
            // Wyświetlenie menu
            System.out.println("\n Menu Biblioteki ");
            System.out.println("1. Spis książek");
            System.out.println("2. Wziąć książkę");
            System.out.println("3. Pomóc w wybraniu książki");
            System.out.println("4. Spis zarezerwowanych książek");
            System.out.println("0. Wyjście");
            System.out.println("---------------------------");
            System.out.print("Twój wybór: ");

            // Odczytanie wyboru użytkownika
            int choice = scanner.nextInt();
            scanner.nextLine(); // Czyszczenie bufora po wprowadzeniu liczby
            System.out.println("---------------------------");

            // Obsługa wybranej opcji
            switch (choice) {
                case 1:
                    displayBooks(); // Wyświetlenie listy książek
                    break;
                case 2:
                    takeBook(scanner); // Wypożyczenie książki
                    break;
                case 3:
                    generateRandomBook(scanner); // Losowe wybieranie książki
                    break;
                case 4:
                    displayReservedBooks(); // Wyświetlenie listy zarezerwowanych książek
                    break;
                case 0:
                    // Zakończenie działania programu
                    System.out.println("Dziękujemy za skorzystanie z biblioteki!");
                    running = false;
                    break;
                default:
                    // Obsługa nieprawidłowego wyboru
                    System.out.println("Nieprawidłowy wybór. Proszę spróbować ponownie.");
            }
        }
        scanner.close(); // Zamknięcie skanera
    }

    // Inicjalizacja listy książek
    private static void initializeBooks() {
        books.add("Harry Potter i Kamień Filozoficzny ~ J.K.Rowling");
        books.add("Chirurg ~ Tess Gerritsen");
        books.add("Nic mnie nie złamie ~ David Goggins");
        books.add("Kolor purpury ~ Alice Walker");
        books.add("Pani Dalloway ~ Virginia Woolf");
        books.add("Niewidzialny człowiek ~ Ralph Ellison");
        books.add("Sto lat samotności ~ Gabriel Garcia");
        books.add("Anna Karenina ~ Lew Tołstoj");
        books.add("Zabić drozda ~ Harper Lee");
        books.add("Wielki Gatsby ~ F. Scott Fitzgerald");
    }

    // Wyświetlenie listy dostępnych książek
    private static void displayBooks() {
        System.out.println("\n Spis książek");
        if (books.isEmpty()) {
            System.out.println("Niestety, wszystkie książki zostały wypożyczone.");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }

    // Wypożyczenie książki
    private static void takeBook(Scanner scanner) {
        System.out.println("\n Wypożyczanie książki ");
        if (books.isEmpty()) {
            System.out.println("Niestety, wszystkie książki zostały wypożyczone.");
            return;
        }
        displayBooks(); // Wyświetlenie listy książek
        System.out.println("---------------------------");
        System.out.print("Wprowadź numer książki, którą chcesz wypożyczyć: ");
        int bookNumber = scanner.nextInt();
        scanner.nextLine(); // Czyszczenie bufora

        // Sprawdzenie poprawności wyboru
        if (bookNumber < 1 || bookNumber > books.size()) {
            System.out.println("Nieprawidłowy numer. Proszę spróbować ponownie.");
        } else {
            // Przeniesienie książki na listę zarezerwowanych
            String book = books.remove(bookNumber - 1);
            reservedBooks.add(book);
            System.out.println("Książka \"" + book + "\" została wypożyczona!");
        }
    }

    // Losowe wybieranie książki
    private static void generateRandomBook(Scanner scanner) {
        System.out.println("\n Pomoc w wyborze książki ");
        if (books.isEmpty()) {
            System.out.println("Brak dostępnych książek do losowania.");
            return;
        }
        System.out.print("Naciśnij Enter, aby wylosować książkę...");
        scanner.nextLine();
        Random random = new Random();
        int randomIndex = random.nextInt(books.size());
        System.out.println("---------------------------");
        System.out.println("Wylosowana książka to: " + books.get(randomIndex));
    }

    // Wyświetlenie listy zarezerwowanych książek
    private static void displayReservedBooks() {
        System.out.println("\n Spis zarezerwowanych książek ");
        if (reservedBooks.isEmpty()) {
            System.out.println("Brak zarezerwowanych książek.");
        } else {
            for (int i = 0; i < reservedBooks.size(); i++) {
                System.out.println((i + 1) + ". " + reservedBooks.get(i));
            }
        }
    }
}
