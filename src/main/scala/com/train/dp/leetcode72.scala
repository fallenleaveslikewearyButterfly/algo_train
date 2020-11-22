package com.train.dp

object leetcode72 {
  def minDistance(word1: String, word2: String): Int = {
    val dp = Array.ofDim[Int](word1.length+1,word2.length+1)
    for(i<-Range(1,word1.length+1)){
      dp(i)(0) = i
    }
    for(i<-Range(1,word2.length+1)){
      dp(0)(i) = i
    }
    for(i<-Range(1,word1.length+1)){
      for(j<-Range(1,word2.length+1)){
        if(word1(i-1)==word2(j-1)){
          dp(i)(j) = dp(i-1)(j-1)
        }else{
          dp(i)(j) = Math.min(dp(i-1)(j)+1,dp(i)(j-1)+1)
          dp(i)(j) = Math.min(dp(i)(j),dp(i-1)(j-1)+1)
        }
      }
    }
    return dp(word1.length)(word2.length)
  }

  def main(args: Array[String]): Unit = {
    println(minDistance("horse","ros"))//3
    println(minDistance("intention","execution"))//5
    println(minDistance("b",""))//1
    println(minDistance("a","ab"))//1
    println(minDistance("sea","eat"))//2
    println(minDistance("plasma","altruism"))//6
    println(minDistance("trinitrophenylmethylnitramine", "dinitrophenylhydrazine"))//10
  }
}
