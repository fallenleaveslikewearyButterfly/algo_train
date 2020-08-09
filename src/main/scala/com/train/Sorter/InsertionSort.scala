package com.train.Sorter

import com.train.common.SortTestHelper

/**
  * @author:
  * @date: 2020/8/9 11:15
  */
object InsertionSort {
  /***
    *一次交换swap 有 三次赋值，比较耗费时间
    *
  ***/
  def insertionSort[E <% Ordered[E]](arr:Array[E], n:Int): Unit ={
    for(i <- Range(1,n))
        for(j <- Range(i,0,-1) if arr(j)<arr(j-1))
            SortTestHelper.swap(arr,j,j-1)
  }

  /***
    *选择排序改进版
    *用一个变量缓存arr(i)的值和它应该所在的位置，如果不是它应该在位置就把元素往后移动
    * 由一次交换swap 三次赋值修优化成一次赋值，找到最后最后应该在的位置在赋值一次
    * 插入排序可以优化：内层循环可以提前终止
    ***/
  def insertionSort2[E <% Ordered[E]](arr:Array[E], n:Int): Unit ={
    for(i <- Range(1,n)) {
      val e = arr(i)
      var j=i
      while(j>0 && (arr(j-1) > e)){
        arr(j)=arr(j-1)
        j-=1
      }
      arr(j) = e
    }
  }
}
