package booking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookingSystem {
    private Map<String, Movie> movies;

    public BookingSystem() {
        movies = new HashMap<>();
    }

    public void addMovie(String title, int seats) {
        movies.put(title, new Movie(title, seats));
    }

    public void showMovies() {
        System.out.println("Available movies:");
        for (Movie movie : movies.values()) {
            System.out.println(movie.getTitle() + " - Available seats: " + movie.getAvailableSeats());
        }
    }

    public boolean bookTicket(String movieTitle, String customerName) {
        Movie movie = movies.get(movieTitle);
        if (movie != null) {
            return movie.bookTicket(customerName);
        }
        return false;
    }

    public boolean cancelBooking(String movieTitle, String customerName) {
        Movie movie = movies.get(movieTitle);
        if (movie != null) {
            return movie.cancelBooking(customerName);
        }
        return false;
    }

    public void printBookings(String movieTitle) {
        Movie movie = movies.get(movieTitle);
        if (movie != null) {
            movie.printBookings();
        } else {
            System.out.println("Movie not found.");
        }
    }

    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();
        system.addMovie("Inception", 5);
        system.addMovie("Interstellar", 3);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Show movies\n2. Book ticket\n3. Cancel booking\n4. Show bookings\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    system.showMovies();
                    break;
                case 2:
                    System.out.println("Enter movie title:");
                    String movieTitle = scanner.nextLine();
                    System.out.println("Enter customer name:");
                    String customerName = scanner.nextLine();
                    if (system.bookTicket(movieTitle, customerName)) {
                        System.out.println("Ticket booked successfully.");
                    } else {
                        System.out.println("Failed to book ticket. No available seats.");
                    }
                    break;
                case 3:
                    System.out.println("Enter movie title:");
                    movieTitle = scanner.nextLine();
                    System.out.println("Enter customer name:");
                    customerName = scanner.nextLine();
                    if (system.cancelBooking(movieTitle, customerName)) {
                        System.out.println("Booking canceled successfully.");
                    } else {
                        System.out.println("Failed to cancel booking. Booking not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter movie title:");
                    movieTitle = scanner.nextLine();
                    system.printBookings(movieTitle);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}