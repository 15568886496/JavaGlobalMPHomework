package com.example.modeloe10.algorithm;

import com.example.module10.algorithm.MergeSort;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/19/2022 2:04 PM
 **/
public class MergeSortTest {
  @Test
  public  void testMergeSort(){
    MergeSort mergeSort = new MergeSort();
    int[] arr = {6, 8, 4, 4, 6, 36, 673, 13, 6, 7};
    int[] finalArr = {4,4,6,6,6,7,8,13,36,673};
    mergeSort.sort(arr, 0, arr.length - 1);
    Assert.assertTrue(Arrays.equals(arr,finalArr));
  }
}
