package utilities;

import java.util.List;

public class Collections {
    public static void bubbleSort(double[] array) {
        int n = array.length;

        for (int count = 0; count < n - 1; count++) {
            boolean switched = false;

            for (int index = 0; index < n - 1 - count; index++) {
                if (array[index] > array[index + 1]) {
                    double temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                    switched = true;
                }
            }
            if (!switched) {
                break;
            }
        }

    }

    public static void bubbleSort(List<Double> list) {
        int n = list.size();

        for (int count = 0; count < n - 1; count++) {
            boolean switched = false;

            for (int index = 0; index < n - 1 - count; index++) {
                if (list.get(index) > (list.get(index + 1))) {
                    double temp = list.get(index);
                    list.set(index, list.get(index + 1));
                    list.set(index + 1, temp);

                    switched = true;
                }
            }

            if (!switched) {
                break;
            }
        }
    }

    public static void selectionSort(double[] array) {
        int length = array.length;
        for (int currentPos = 0; currentPos < length - 1; currentPos++) {
            int smallestIndex = currentPos;

            for (int searchIndex = currentPos + 1; searchIndex < length; searchIndex++) {
                if (array[searchIndex] < array[smallestIndex]) {
                    smallestIndex = searchIndex;
                }
            }
            double temp = array[currentPos];
            array[currentPos] = array[smallestIndex];
            array[smallestIndex] = temp;
        }
    }

    public static void selectionSort(List<Double> list) {
        int n = list.size();

        for (int currentIndex = 0; currentIndex < n - 1; currentIndex++) {
            int minIndex = currentIndex;

            for (int nextIndex = currentIndex + 1; nextIndex < n; nextIndex++) {
                if (list.get(nextIndex) < list.get(minIndex)) {
                    minIndex = nextIndex;
                }
            }

            if (minIndex != currentIndex) {
                Double temp = list.get(currentIndex);
                list.set(currentIndex, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }

    public static int binarySearch(double[] array, double target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearch(List<Double> list, double target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

public static int occurancesOf(String aString, char aChar){

    if (aString.length() == 0)
        return 0;
    else{
        int oneIfAy=0;
        if(aChar == aString.charAt(0)){
            oneIfAy =1;

        }
        return oneIfAy + occurancesOf(aString.substring(1), aChar);
        
        }
    }
}