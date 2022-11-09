package com.example.modeloe10.algorithm;

import com.example.module10.algorithm.InsertionSort;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/19/2022 2:03 PM
 **/
public class InsertionSortTest {

  @Test
  public void testInsertSort() {
    InsertionSort insertionSort = new InsertionSort();
    int[] array={10,6,9,3,5};
    int[] finalArray = {3,5,6,9,10};
    insertionSort.insertSort(array);
    Assert.assertTrue(Arrays.equals(array,finalArray));
  }
}
