package com.train.Sorter

import com.train.common.SortTestHelper

/*
  *快速排序
 */
object QuickSort {
  /*
  *快排递归版
   */
  def quickSort[E <% Ordered[E]](arr:Array[E], n:Int): Unit ={

    _quickSort(arr,0,n-1)

  }

  private def _quickSort[E <% Ordered[E]](arr:Array[E], s:Int,e:Int): Unit ={
    var mid = -1

    for(i<-Range(s,e)){
      if(arr(i)>arr(i+1)){
        SortTestHelper.swap(arr,i,i+1)
        mid=i
      }
    }
    if(mid == -1)
      return
    _quickSort(arr,s,mid)
    _quickSort(arr,mid+1,e)
    }

 }
