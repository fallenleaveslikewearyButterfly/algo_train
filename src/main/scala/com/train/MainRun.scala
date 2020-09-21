package com.train

import com.train.Sorter.{BubbleSort, InsertionSort, QuickSort, SelectionSort}
import com.train.common.SortTestHelper

/**
  * @author: Lilan
  * @date: 2020/8/8 7:30
  */
object MainRun {
  def main(args: Array[String]): Unit = {
    val n=10

    val sortTestHelper = SortTestHelper[Int]

    val arr = SortTestHelper.generateRandomArray(n,0,n)
    //val arr = SortTestHelper.generateNearlyOrderedArray(n,0)//
    val arr2 = arr.clone()
    val arr3 = arr.clone()
    val arr4 = arr.clone()
    //sortTestHelper.testSort("Bubble Sort",BubbleSort.bubbleSort,arr4,n)
    //sortTestHelper.testSort("Selection Sort",SelectionSort.selectionSort,arr,n)
    //sortTestHelper.testSort("Insertion Sort",InsertionSort.insertionSort,arr2,n)
    //sortTestHelper.testSort("Insertion Sort2",InsertionSort.insertionSort2,arr3,n)
    //sortTestHelper.testSort("Quick Sort",QuickSort.quickSort,arr3,n)
    //sortTestHelper.testSort("Quick Sort2",QuickSort.quickSort2,arr4,n)
    sortTestHelper.testSort("Quick Sort2",QuickSort.quickSort3,arr4,n)
  }
}
