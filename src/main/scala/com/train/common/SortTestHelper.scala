package com.train.common

import java.time.Clock
import java.util.Calendar

import scala.reflect.ClassTag
import scala.util.Random
/**
  * @author: Lilan
  * @date: 2020/8/8 7:19
  */
class SortTestHelper[T <%Ordered[T]] {

  def isSorted(arr:Array[T],n:Int):  Boolean ={
    for(i <- Range(0,n-1)){
      if(arr(i)>arr(i+1)){
        println(i,arr(i),arr(i+1))
        return false
      }
    }
    return true
  }

  def testSort(sortName:String, sort:(Array[T],Int)=>Unit, arr:Array[T], n:Int): Unit ={

    val s = System.currentTimeMillis()
    sort(arr,n)
    val e = System.currentTimeMillis()
    assert(isSorted(arr,n))
    println(sortName+" : " + (e-s)/1000.toDouble + " s")

  }
}

object SortTestHelper{

  def generateRandomArray(n:Int,rangeL:Int,rangeR:Int):Array[Int] = {

    assert(rangeL<=rangeR)

    val arr = new Array[Int](n)
    val srand = new Random(System.currentTimeMillis())
    for(i <- Range(0,n,1)){
      arr(i) = Math.abs(srand.nextInt()) % (rangeR - rangeL + 1) + rangeL
    }
    arr
  }

  def swap[T](arr:Array[T],i:Int,j:Int):Unit={
    val tmp=arr(i)
    arr(i)=arr(j)
    arr(j)=tmp
  }

  def printArray[T](arr:Array[T]): Unit ={
    arr.foreach(item=>{print(item+" ")})
    println()
  }

  def generateNearlyOrderedArray(n:Int,swapTimes:Int):Array[Int]={
    val arr = new Array[Int](n)
    for(i <- Range(0,n))
      arr(i) = i
    val srand = new Random(System.currentTimeMillis())
    for(i <- Range(0,swapTimes)){
      val xPos = Math.abs(srand.nextInt()%n)
      val yPos = Math.abs(srand.nextInt()%n)
      swap(arr,xPos,yPos)
    }
    arr
  }

  def apply[T <%Ordered[T]]() = new SortTestHelper[T]()

}

