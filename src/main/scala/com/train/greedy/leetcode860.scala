package com.train.Greedy

object leetcode860 {
  def lemonadeChange(bills: Array[Int]): Boolean = {
    val money = Array.fill(3)(0)
    bills.foreach(bill=>{
      if(bill==5){
        money(0) += 1
      }else if(bill==10){
        if(money(0)<=0){
          return false
        }
        money(0) -= 1
        money(1) += 1
      }else if(bill==20){
        var t = 20
        while(money(1)>0 && t>10){
          t -= 10
          money(1) -= 1
        }
        while(money(0)>0 && t>5){
          t -= 5
          money(0) -= 1
        }
        if(t!=5){
          return false
        }
      }
    })
    return true
  }

  def main(args: Array[String]): Unit = {
    println(lemonadeChange(Array(5,5,5,10,20)))//true
    println(lemonadeChange(Array(5,5,10)))//true
    println(lemonadeChange(Array(10,10)))//false
    println(lemonadeChange(Array(5,5,10,10,20)))//false
  }
}
