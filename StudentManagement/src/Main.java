public class Main {
    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Students");
            System.out.println("5. Sort Students");
            System.out.println("6. Search Student");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> management.addStudent();
                case 2 -> management.editStudent();
                case 3 -> management.deleteStudent();
                case 4 -> management.displayStudents();
                case 5 -> management.sortStudents();
                case 6 -> management.searchStudent();
                case 7 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
