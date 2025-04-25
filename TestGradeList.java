import java.util.*;
public class TestGradeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeList gradelist = new GradeList();

        while (true) {
            System.out.println("\nPlease enter a number to continue--");
            System.out.println("1. Add a Grade");
            System.out.println("2. Remove a Grade");
            System.out.println("3. Find a Grade");
            System.out.println("4. Sort Grades in Ascending Order");
            System.out.println("5. Display Highest, Lowest, and Average Grade");
            System.out.println("6. Display all Grades");
            System.out.println("7. Exit Program");

            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    System.out.println("Enter a Grade to Add: ");
                    int addgrade = scanner.nextInt();
                    gradelist.add(addgrade);
                    break;
                case 2:
                    System.out.println("Enter a Grade to Remove: ");
                    int deletegrade = scanner.nextInt();
                    gradelist.delete(deletegrade);
                    break;
                case 3:
                    System.out.println("Enter a Grade to Find: ");
                    int find = scanner.nextInt();
                    gradelist.findGrade(find);
                    break;
                case 4:
                    gradelist.insertionSort();
                    break;
                case 5:
                    double avg = gradelist.getAverage();
                    int high = gradelist.getHighest();
                    int low = gradelist.getLowest();
                    System.out.println("Average Grade: " + avg);
                    System.out.println("Highest Grade: " + high);
                    System.out.println("Lowest Grade: " + low);
                    break;
                case 6:
                    System.out.println("All Grades: ");
                    gradelist.displayAll();
                    break;
                case 7:
                    System.out.println("Exiting");
                    scanner.close();
                    break;
            }
        }
    }
}