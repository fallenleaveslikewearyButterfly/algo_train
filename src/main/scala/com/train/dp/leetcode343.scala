package com.train.dp

object leetcode343_2{

  def integerBreak(n: Int): Int = {
    val memo = Array.fill(n+1)(-1)
    memo(1)=1
    for(i<-Range(2,n+1)){
      for(j<-Range(1,i)){
        memo(i) = Math.max(memo(i),Math.max(j*(i-j),j*memo(i-j)))
      }
    }
    return memo(n)
  }

  def main(args: Array[String]): Unit = {
    println(integerBreak(2))//1
    println(integerBreak(10))//36
  }
}

object leetcode343 {

  def breakInteger(n:Int,memo:Array[Int]):Int={
    if(n==1){
      return 1
    }
    if(memo(n)!= -1){
      return memo(n)
    }
    var res = 0
    for(i<-Range(1,n)){
      res = Math.max(res,Math.max(i*(n-i),i*integerBreak(n-i)))
    }
    memo(n)=res
    return res
  }
  def integerBreak(n: Int): Int = {
    var memo = Array.fill(n+1)(-1)
    return breakInteger(n,memo)
  }

  def main(args: Array[String]): Unit = {
    println(integerBreak(2))//1
    println(integerBreak(10))//36
  }
}
