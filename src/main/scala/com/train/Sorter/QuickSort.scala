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

  def quickSort2[E <% Ordered[E]](arr:Array[E], n:Int): Unit ={

    _quickSort2(arr,0,n-1)

  }

  def quickSort3[E <% Ordered[E]](arr:Array[E], n:Int): Unit ={
    _quickSort3(arr,0,n-1)
  }

  def quickSort4[E <% Ordered[E]](arr:Array[E], n:Int): Unit ={
    _quickSort4(arr,0,n-1)
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
    /*
      单路快排
     */
    private def _quickSort2[E <% Ordered[E]](arr:Array[E], s:Int,e:Int): Unit ={
      if(s>=e)
        return
      val t = arr(s)
      var j = s+1
      for(i<-Range(s+1,e+1)){
        if(arr(i)<t){
          SortTestHelper.swap(arr,j+1,i)
          j+=1
        }
      }
      SortTestHelper.swap(arr,j,s)
      _quickSort2(arr,s,j)
      _quickSort2(arr,j+1,e) 
    }

  /*
  双路快排序
   */
  private def _quickSort3[E <% Ordered[E]](arr:Array[E], s:Int,e:Int): Unit ={

  }

  private def _quickSort4[E <% Ordered[E]](arr:Array[E], s:Int,e:Int): Unit ={

  }

 }
