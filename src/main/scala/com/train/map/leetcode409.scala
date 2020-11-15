package com.train.map

import scala.collection.mutable.Map
object leetcode409 {
  def longestPalindrome(s: String): Int = {
    val map=Map[Char,Int]()
    s.foreach(c=>{
      if(!map.contains(c)){
        map(c)=0
      }
      map(c)+=1
    })
    var count = 0
    var flag = false
    map.values.foreach(v=>{
      if(v%2==0){
        count+=v
      }else if(v%1==0){
        flag = true
        count+=(v-1)
      }
    })
    if(flag){
      return count+1
    }else{
      return count
    }

  }

  def main(args: Array[String]): Unit = {
    println(longestPalindrome("abccccdd"))//7
    println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"))//7
  }
}
