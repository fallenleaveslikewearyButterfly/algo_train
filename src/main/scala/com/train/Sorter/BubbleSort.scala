package com.train.Sorter

import com.train.common.SortTestHelper

/**
  * @author:
  * @date: 2020/8/9 19:03
  *        冒泡排序
  */
object BubbleSort {

  def bubbleSort[E <% Ordered[E]](arr:Array[E], n:Int): Unit ={
    for(i<- Range(0,n)){
      for(j <-Range(i+1,n)){
        if(arr(j)<arr(i))
          SortTestHelper.swap(arr,i,j)
      }
    }
  }
}
