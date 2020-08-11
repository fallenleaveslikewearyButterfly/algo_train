package com.train.Sorter

import java.util.Comparator

import com.train.common.SortTestHelper

import scala.reflect.ClassTag

/**
  * @author:
  * @date: 2020/8/8 7:56
  */
object SelectionSort{
  /***
    *选择排序交换数据的次数比插入排序少
    *
  ***/
  def selectionSort[E <% Ordered[E]](arr:Array[E], n:Int): Unit ={
    for(i <- Range(0,n)){
      var minIndex = i
      for(j <- Range(i+1,n)){
        if(arr(j)<=arr(minIndex)){
          minIndex=j
        }
      }
      SortTestHelper.swap(arr,i,minIndex)
    }
  }

  def selectionSort2[E <% Ordered[E]](arr:Array[E], n:Int): Unit ={
    //Todo:优化一次选出最大和最小的，减少比较次数
  }
}
