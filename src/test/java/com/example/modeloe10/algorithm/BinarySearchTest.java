package com.example.modeloe10.algorithm;

import com.example.module10.algorithm.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/19/2022 1:43 PM
 **/
public class BinarySearchTest {

  @Test
  public void testRecursively(){
    BinarySearch binarySearch = new BinarySearch();
    int arr[] = new int[]{1,2,3,4,6,8,12,19};
    int targert = 6;
    Integer integer = binarySearch.recursively(arr, 0, arr.length - 1, 6);
    Assert.assertTrue(arr[integer] == targert);
  }

  @Test
  public void testIteratively(){
    BinarySearch binarySearch = new BinarySearch();
    int nums[] = new int[]{2,4,5,6,7,8,9};
    int target = 6;
    int i = binarySearch.iteratively(nums, target);
    Assert.assertTrue(target == nums[i]);
  }

}
