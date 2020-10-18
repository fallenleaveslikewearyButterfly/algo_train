package com.train.Sorter

import com.train.common.SortTestHelper

/**
  * @author: Lilan
  * @date: 2020/10/18 18:56
  */
object ShellSort {
  def shellSort[E <% Ordered[E]](arr:Array[E], n:Int): Unit ={

    var gap=n/2
    while(gap>0){
      for(i<-Range(gap,n)){
        var e = arr(i)
        var j = i
        while(j-gap>=0 && (arr(j-gap) > e)){
          arr(j)=arr(j-gap)
          j=j-gap
        }
        arr(j)=e
      }
      gap = gap/2
    }
    arr.foreach(print)
  }
}
