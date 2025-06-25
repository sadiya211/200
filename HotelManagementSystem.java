import java.util.*;

class Room {
    int roomNumber;
    boolean isAvailable;
    String customerName;

    Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isAvailable = true;
        this.customerName = "";
    }

    void bookRoom(String customerName) {
        if (isAvailable) {
            this.isAvailable = false;
            this.customerName = customerName;
            System.out.println("Room " + roomNumber + " booked successfully for " + customerName);
        } else {
            System.out.println("Room " + roomNumber + " is not available.");
        }
    }

    void vacateRoom() {
        if (!isAvailable) {
            this.isAvailable = true;
            System.out.println("Room " + roomNumber + " vacated by " + customerName);
            this.customerName = "";
        } else {
            System.out.println("Room " + roomNumber + " is already vacant.");
        }
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " | " + (isAvailable ? "Available" : "Occupied by " + customerName);
    }
}

class HotelManagement {
    List<Room> rooms = new ArrayList<>();

    HotelManagement(int totalRooms) {
        for (int i = 1; i <= totalRooms; i++) {
            rooms.add(new Room(i));
        }
    }

    void displayRooms() {
        System.out.println("Room Status:");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                return room;
            }
        }
        return null;
    }

    void bookRoom(int roomNumber, String customerName) {
        Room room = getRoomByNumber(roomNumber);
        if (room != null) {
            room.bookRoom(customerName);
        } else {
            System.out.println("Room number " + roomNumber + " does not exist.");
        }
    }

    void vacateRoom(int roomNumber) {
        Room room = getRoomByNumber(roomNumber);
        if (room != null) {
            room.vacateRoom();
        } else {
            System.out.println("Room number " + roomNumber + " does not exist.");
        }
    }
}

public class HotelManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelManagement hotel = new HotelManagement(10); // Initialize with 10 rooms

        while (true) {
            System.out.println("\nHotel Management System");
            System.out.println("1. Display Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Vacate Room");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.displayRooms();
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomToBook = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    hotel.bookRoom(roomToBook, customerName);
                    break;
                case 3:
                    System.out.print("Enter room number to vacate: ");
                    int roomToVacate = scanner.nextInt();
                    hotel.vacateRoom(roomToVacate);
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
