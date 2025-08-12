package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

public class CollectionsTest {

    private double[] unsortedData = {77.2, 4.0, -2.6, 0.0, 30.5, -60.7, 23.1, 420.0, -17.5};
    private double[] sortedData = {-60.7, -17.5, -2.6, 0.0, 4.0, 23.1, 30.5, 77.2, 420.0};
    private double[] dataArray;
    private List<Double> dataList;

    @BeforeEach
    public void setUp(){
        dataArray = unsortedData.clone();
        dataList = new ArrayList<Double>();
        for(double eachDouble : unsortedData){
            dataList.add(eachDouble);
        }
    }

    @AfterEach
    public void tearDown(){
        dataArray = null;
        dataList = null;
    }

    @Test
    public void testBubbleSortArray(){
        Collections.bubbleSort(dataArray);
        for(int index = 0; index < dataArray.length; ++index){
            assertEquals(sortedData[index], dataArray[index]);
        }
    }

    @Test
    public void testBubbleSortList(){
        Collections.bubbleSort(dataList);
        for(int index = 0; index < dataList.size(); ++index){
            assertEquals(sortedData[index], dataList.get(index));
        }
    }

    // Note: For selection sort, there should only be one swap per pass.
    @Test
    public void testSelectionSortArray(){
        Collections.selectionSort(dataArray);
        for(int index = 0; index < dataArray.length; ++index){
            assertEquals(sortedData[index], dataArray[index]);
        }
    }

    @Test
    public void testSelectionSortList(){
        Collections.selectionSort(dataList);
        for(int index = 0; index < dataList.size(); ++index){
            assertEquals(sortedData[index], dataList.get(index));
        }
    }

    @Test
    public void testBinarySearchArray(){
        int index = Collections.binarySearch(sortedData, -62.3);
        assertEquals(-1, index);
        index = Collections.binarySearch(sortedData, 423.1);
        assertEquals(-1, index);
        index = Collections.binarySearch(sortedData, 9.9);
        assertEquals(-1, index);
        index = Collections.binarySearch(sortedData, -60.7);
        assertEquals(0, index);
        index = Collections.binarySearch(sortedData, 420.0);
        assertEquals(8, index);
        index = Collections.binarySearch(sortedData, -2.6);
        assertEquals(2, index);
    }

    @Test
    public void testBinarySearchList(){
        Collections.selectionSort(dataList);
        int index = Collections.binarySearch(dataList, -62.3);
        assertEquals(-1, index);
        index = Collections.binarySearch(dataList, 423.1);
        assertEquals(-1, index);
        index = Collections.binarySearch(dataList, 9.9);
        assertEquals(-1, index);
        index = Collections.binarySearch(dataList, -60.7);
        assertEquals(0, index);
        index = Collections.binarySearch(dataList, 420.0);
        assertEquals(8, index);
        index = Collections.binarySearch(dataList, -2.6);
        assertEquals(2, index);
    }


    @Test 
        public void TestoccurancesOf(){
         assertEquals(2, Collections.occurancesOf("hello", 'l'));
    }
}