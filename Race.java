import java.util.*;

class Race {

    int[] array = {1, 2, 3, 4};
    Race() {
    }
    void readysetgo() {
        int n = array.length;
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {

            int randomValue = i + random.nextInt(n - i);

            int randomElement = array[randomValue];
            array[randomValue] = array[i];
            array[i] = randomElement;
        }
    }

    int first() {
        return array[0];
    }
    int second() {
        return array[1];
    }
    int third() {
        return array[2];
    }
    int fourth() {
        return array[3];
    }
    int[] getarray() {
        return array;
    }
}
