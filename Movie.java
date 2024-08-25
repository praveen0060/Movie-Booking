package booking;
import java.util.HashMap;
import java.util.Map;

public class Movie {
    private String title;
    private int availableSeats;
    private Map<Integer, String> bookings;

    public Movie(String title, int availableSeats) {
        this.title = title;
        this.availableSeats = availableSeats;
        this.bookings = new HashMap<>();
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean bookTicket(String customerName) {
        if (availableSeats > 0) {
            int seatNumber = bookings.size() + 1;
            bookings.put(seatNumber, customerName);
            availableSeats--;
            return true;
        }
        return false;
    }

    public boolean cancelBooking(String customerName) {
        for (Map.Entry<Integer, String> entry : bookings.entrySet()) {
            if (entry.getValue().equals(customerName)) {
                bookings.remove(entry.getKey());
                availableSeats++;
                return true;
            }
        }
        return false;
    }

    public void printBookings() {
        System.out.println("Bookings for " + title + ":");
        for (Map.Entry<Integer, String> entry : bookings.entrySet()) {
            System.out.println("Seat " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
