package com.train.Binary

object leetcode34 {
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    var left = 0
    var right = nums.length-1

    if(nums.length==1){
      if(nums(0)==target){
        return Array(1,1)
      }else{
        return Array(-1,-1)
      }
    }

    while(left<=right){
      val mid = left + (right-left)/2
      if(nums(mid)<target){
        left = mid+1
      }else if(nums(mid)>target){
        right=mid-1
      }else{
        var l = mid
        while(l>=0 && nums(l)==target){
          l -=1
        }
        var r = mid
        while(r<nums.length && nums(r)==target){
          r +=1
        }
        return Array(l+1,r-1)
      }
    }
    return Array(-1,-1)
  }

  def main(args: Array[String]): Unit = {
    print(searchRange(
      Array(1,4),
      4
    ).toList)//[-1,-1]

    print(searchRange(
      Array(1),
      0
    ).toList)//[-1,-1]

    print(searchRange(
      Array(5,7,7,8,8,10),
      8
    ).toList)//[3,4]
    print(searchRange(
      Array(5,7,7,8,8,10),
      6
    ).toList)//[-1,-1]
  }
}
