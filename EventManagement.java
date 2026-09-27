import java.util.ArrayList;
import java.util.Scanner;

class Event {

    int eventId;
    String eventName;
    String date;
    String location;
    int maxParticipants;
    ArrayList<String> participants;

    Event(int eventId, String eventName, String date,
          String location, int maxParticipants) {

        this.eventId = eventId;
        this.eventName = eventName;
        this.date = date;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.participants = new ArrayList<>();
    }
}

public class EventManagement {

    static ArrayList<Event> events = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Event
    static void addEvent() {

        System.out.println("\n===== ADD EVENT =====");

        System.out.print("Enter Event ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Event Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Event Date: ");
        String date = sc.nextLine();

        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        System.out.print("Enter Maximum Participants: ");
        int maxParticipants = sc.nextInt();
        sc.nextLine();

        events.add(
            new Event(id, name, date, location, maxParticipants)
        );

        System.out.println("Event added successfully!");
    }

    // View Events
    static void viewEvents() {

        if (events.isEmpty()) {
            System.out.println("\nNo events available.");
            return;
        }

        System.out.println("\n===== EVENT LIST =====");

        for (Event e : events) {

            System.out.println("----------------------------");
            System.out.println("Event ID      : " + e.eventId);
            System.out.println("Event Name    : " + e.eventName);
            System.out.println("Date          : " + e.date);
            System.out.println("Location      : " + e.location);
            System.out.println(
                "Participants  : " +
                e.participants.size() +
                "/" +
                e.maxParticipants
            );
        }
    }

    // Search Event
    static void searchEvent() {

        System.out.print("\nEnter Event ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Event e : events) {

            if (e.eventId == id) {

                System.out.println("\n===== EVENT DETAILS =====");
                System.out.println("Event ID     : " + e.eventId);
                System.out.println("Event Name   : " + e.eventName);
                System.out.println("Date         : " + e.date);
                System.out.println("Location     : " + e.location);
                System.out.println(
                    "Participants : " +
                    e.participants.size() +
                    "/" +
                    e.maxParticipants
                );

                return;
            }
        }

        System.out.println("Event not found.");
    }

    // Register Participant
    static void registerParticipant() {

        System.out.print("\nEnter Event ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Event e : events) {

            if (e.eventId == id) {

                if (e.participants.size() >= e.maxParticipants) {
                    System.out.println("Event is full.");
                    return;
                }

                System.out.print("Enter Participant Name: ");
                String name = sc.nextLine();

                e.participants.add(name);

                System.out.println(
                    "Participant registered successfully!"
                );

                return;
            }
        }

        System.out.println("Event not found.");
    }

    // View Participants
    static void viewParticipants() {

        System.out.print("\nEnter Event ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Event e : events) {

            if (e.eventId == id) {

                System.out.println("\n===== PARTICIPANTS =====");

                if (e.participants.isEmpty()) {
                    System.out.println("No participants registered.");
                    return;
                }

                for (int i = 0; i < e.participants.size(); i++) {
                    System.out.println(
                        (i + 1) + ". " + e.participants.get(i)
                    );
                }

                return;
            }
        }

        System.out.println("Event not found.");
    }

    // Cancel Event
    static void cancelEvent() {

        System.out.print("\nEnter Event ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Event e : events) {

            if (e.eventId == id) {

                events.remove(e);

                System.out.println(
                    "Event cancelled successfully!"
                );

                return;
            }
        }

        System.out.println("Event not found.");
    }

    // Main Method
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n================================");
            System.out.println("      EVENT MANAGEMENT SYSTEM");
            System.out.println("================================");

            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Search Event");
            System.out.println("4. Register Participant");
            System.out.println("5. View Participants");
            System.out.println("6. Cancel Event");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addEvent();
                    break;

                case 2:
                    viewEvents();
                    break;

                case 3:
                    searchEvent();
                    break;

                case 4:
                    registerParticipant();
                    break;

                case 5:
                    viewParticipants();
                    break;

                case 6:
                    cancelEvent();
                    break;

                case 7:
                    System.out.println(
                        "Thank you for using Event Management System!"
                    );
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
