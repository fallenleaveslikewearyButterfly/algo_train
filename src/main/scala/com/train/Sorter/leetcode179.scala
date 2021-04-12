package com.train.Sorter

object leetcode179 {

  def largestNumber(nums: Array[Int]): String = {
    val t = nums.sortWith((nums1,nums2)=>{
      nums1.toString+nums2.toString>nums2.toString+nums1.toString
    })
    if(t(0)==0){
      "0"
    }else{
      t.mkString
    }

  }

  def main(args: Array[String]): Unit = {
    println(largestNumber(Array(9876,98765,4)))
    println(largestNumber(Array(0,0)))
    println(largestNumber(Array(10,2)))
    println(largestNumber(Array(3,30,34,5,9)))
    println(largestNumber(Array(1)))
    println(largestNumber(Array(10)))
  }

}
