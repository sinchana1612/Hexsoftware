import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        LibraryManagement manager = new LibraryManagement(library);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Books");
            System.out.println("6. Show Members");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    manager.addBook(bookId, title, author);
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    manager.addMember(memberId, name);
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    String bId = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String mId = scanner.nextLine();
                    manager.issueBook(bId, mId);
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    String returnBId = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String returnMId = scanner.nextLine();
                    manager.returnBook(returnBId, returnMId);
                    break;

                case 5:
                    System.out.println("\nBooks:");
                    for (Book b : library.getBooks()) {
                        System.out.println(b);
                    }
                    break;

                case 6:
                    System.out.println("\nMembers:");
                    for (Member m : library.getMembers()) {
                        System.out.println(m);
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

