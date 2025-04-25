import java.util.*;
public class GradeList{
    private int[] list;
    private int numOfItems;

    public GradeList() {
        list = new int[100];
        numOfItems = 0;
    }
    public void add(int item) {
        if (item < 0 || item > 100) {
            System.out.println("Grade does not meet requirements. Enter a grade between 0 to 100.");
            return;
        }
        if (numOfItems == list.length) {
            System.out.println("Cannot add, list is full");
            return;
        }
      /*  int i;
        for (i = numOfItems - 1; i >= 0; i--) {
            if (item < list[i]) {
                list[i + 1] = list[i];
            } else {
                break;
            }
        } */
        list[numOfItems] = item;
        numOfItems++;
        System.out.println("Grade added!");

    }

    public boolean delete(int item) {
        if (item < 0 || item > 100) {
            System.out.println("Grade does not meet requirements. Enter a grade between 0 to 100.");
            return false;
        }
        if (numOfItems == 0) {
            System.out.println("The list is empty");
            return false;
        }
        int i;
        for (i = 0; i < numOfItems; i++) {
            if (item == list[i])
                break;
        }
        if (i == numOfItems) {
            System.out.println("Grade Not Found");
            return false;
        } else {
            for (int j = i; j < numOfItems; j++) {
                list[j] = list[j + 1];
            }
        }
        list[numOfItems - 1] = 0;
        numOfItems--;
        System.out.println("Grade removed!");
        return true;
    }

    public int findGrade(int item){
        if (item < 0 || item > 100) {
            System.out.println("Grade does not meet requirements. Enter a grade between 0 to 100.");
            return -1;
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] == item) {
                System.out.println(item + " was found at " + i);
                return i;
            }
        }
        System.out.println("Grade Not Found");
        return -1;
    }
    public void insertionSort() {
        if (numOfItems == 0) {
            System.out.println("No Grades in list");
            return;
        }

        for (int k = 1; k < numOfItems; k++) {
            int cur = list[k];
            int j = k;
            while (j > 0 && list[j - 1] > cur) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = cur;
        }
        System.out.println("Sorting Complete!");
    }

    public double getAverage() {
        if (numOfItems == 0)
            return 0;
        int sum = 0;
        for (int i = 0; i < numOfItems; i++) {
            sum += list[i];
        }
        return (double) sum / numOfItems;
    }

    public int getHighest() {
        if (numOfItems == 0)
            return -1;
        int max = list[0];
        for (int i = 1; i < numOfItems; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        return max;
    }

    public int getLowest() {
        if (numOfItems == 0)
            return -1;
        int min = list[0];
        for (int i = 1; i < numOfItems; i++) {
            if (list[i] < min) {
                min = list[i];
            }
        }
        return min;
    }
    public void displayAll() {
       if (numOfItems == 0) {
            System.out.println("No Grades in list");
            return;
        }
        for(int i = 0; i < numOfItems; i++) {
            System.out.println(list[i]);
        }
    }
}
