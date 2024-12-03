import java.util.*;

class Student {
    String id;
    String name;
    double score;
    String ranking;

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.ranking = getRanking(score);
    }

    String getRanking(double score) {
        if (score < 5.0) return "Fail";
        if (score < 6.5) return "Average";
        if (score < 7.5) return "Good";
        if (score < 9.0) return "Very Good";
        return "Excellent";
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Score: " + score + ", Ranking: " + ranking;
    }
}

public class StudentManagement {
    private List<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        double score = getValidScore();
        students.add(new Student(id, name, score));
        System.out.println("Student added successfully!");
    }

    public void editStudent() {
        System.out.print("Enter Student ID to edit: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.id.equals(id)) {
                System.out.print("Enter new name: ");
                student.name = scanner.nextLine();
                student.score = getValidScore();
                student.ranking = student.getRanking(student.score);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        students.removeIf(student -> student.id.equals(id));
        System.out.println("Student deleted successfully!");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            System.out.println("Student List:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void sortStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to sort!");
            return;
        }
        quickSort(0, students.size() - 1);
        System.out.println("Students sorted by score!");
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        double pivot = students.get(high).score;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (students.get(j).score <= pivot) {
                i++;
                Collections.swap(students, i, j);
            }
        }
        Collections.swap(students, i + 1, high);
        return i + 1;
    }

    public void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.id.equals(id)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    private double getValidScore() {
        while (true) {
            try {
                System.out.print("Enter Student Score (0-10): ");
                double score = Double.parseDouble(scanner.nextLine());
                if (score >= 0 && score <= 10) {
                    return score;
                } else {
                    System.out.println("Score must be between 0 and 10. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
    }
}
