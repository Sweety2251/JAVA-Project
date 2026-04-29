import java.net.ContentHandler;
import java.util.*;

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class ContactManger {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("press 1 to add contact");
            System.out.println("press 2 to display all contact");
            System.out.println("press 3 to search contact");
            System.out.println("press 4 to exist");

            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    showContact();
                    break;
                case "3":
                    searchContact();
                    break;
                case "4":
                    System.out.println("Exist.....");
                    break;

            }
        }
    }
    
    static void addContact() {
        System.out.println("Enter the name");
        String name = sc.nextLine();
        System.out.println("Enter the phone number");
        String phone = sc.nextLine();
        contacts.add(new Contact(name, phone));
    }
    
    static void showContact() {
        if (contacts.isEmpty()) {
            System.out.println("No contact found");
            return;
        }
        System.out.println("All Contact");
        for (Contact c : contacts) {
            System.out.println("name: " + c.name + "phone: " + c.phone);
        }
    }

    static void searchContact() {

        System.out.println("Enter the name");
        String name = sc.nextLine();

        boolean found = false;
        for (Contact c : contacts) {
            if (c.name.toLowerCase().contains(name)) {
                System.out.println("name: " + c.name + "phone: " + c.phone);
                found = true;
            }
            if (!found) {
                System.out.println("Contact not found");
            }
        }
    }
}