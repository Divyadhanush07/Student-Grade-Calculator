import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Input number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Arrays to store student names, total marks, and grades
        String[] studentNames = new String[numStudents];
        int[][] marks = new int[numStudents][numSubjects];
        int[] totalMarks = new int[numStudents];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];

        // Input details for each student
        for (int i = 0; i < numStudents; i++) {
            scanner.nextLine(); // Consume newline
            System.out.println("Enter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            studentNames[i] = scanner.nextLine();

            int sum = 0;
            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter marks for Subject " + (j + 1) + ": ");
                marks[i][j] = scanner.nextInt();
                sum += marks[i][j];
            }

            totalMarks[i] = sum;
            percentages[i] = (double) sum / numSubjects;

            // Calculate grade
            if (percentages[i] >= 90) {
                grades[i] = 'A';
            } else if (percentages[i] >= 75) {
                grades[i] = 'B';
            } else if (percentages[i] >= 50) {
                grades[i] = 'C';
            } else {
                grades[i] = 'F';
            }
        }

        // Display results
        System.out.println("\n--- Student Grade Report ---");
        System.out.printf("%-15s %-15s %-10s %-10s\n", "Name", "Total Marks", "Percentage", "Grade");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-15s %-15d %-10.2f %-10c\n", studentNames[i], totalMarks[i], percentages[i], grades[i]);
        }

        scanner.close();
    }
}
