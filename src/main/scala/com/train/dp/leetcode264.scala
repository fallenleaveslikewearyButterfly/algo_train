package com.train.dp
object leetcode264 {

  def nthUglyNumber(n: Int): Int = {
    var dp = Array.ofDim[Int](n+1)
    dp(1)=1
    var p2 = 1
    var p3 = 1
    var p5 = 1

    for(i<-Range(2,n+1)){
      val num2 = dp(p2)*2
      val num3 = dp(p3)*3
      val num5 = dp(p5)*5
      dp(i) = Math.min(Math.min(num2,num3),num5)
      if(dp(i) == num2){
        p2 +=1
      }
      if(dp(i) == num3){
        p3 +=1
      }
      if(dp(i) == num5){
        p5 +=1
      }
    }
    return dp(n)
  }

  def main(args: Array[String]): Unit = {
    println(nthUglyNumber(39))
  }
}
