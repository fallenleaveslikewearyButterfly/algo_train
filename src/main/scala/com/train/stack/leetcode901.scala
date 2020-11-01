package com.train.stack

// 官方答案
//class StockSpanner {
//  Stack<Integer> prices, weights;
//
//  public StockSpanner() {
//    prices = new Stack();
//    weights = new Stack();
//  }
//
//  public int next(int price) {
//    int w = 1;
//    while (!prices.isEmpty() && prices.peek() <= price) {
//      prices.pop();
//      w += weights.pop();
//    }
//
//    prices.push(price);
//    weights.push(w);
//    return w;
//  }
//}

import scala.collection.mutable.{Stack,ListBuffer}
import scala.collection.mutable.Map


class StockSpanner1 {

  val prices = Stack[Int]()
  val weights = Stack[Int]()

  def next(price: Int): Int = {
    var w = 1
    while (!prices.isEmpty && prices.top <= price) {
      prices.pop()
      w += weights.pop()
    }
    prices.push(price)
    weights.push(w)
    return w
  }
}
class StockSpanner() {
  val stack = Stack[Int]()
  val list = ListBuffer[Int]()
  val res = Map[Int,Int]()
  def next(price: Int): Int = {
    while(!stack.isEmpty && price >= list(stack.top)){
      stack.pop()
    }

    var last = -1
    if(!stack.isEmpty){
      last = stack.top
    }
    stack.push(list.length)
    list.append(price)
    var t =list.length-last-1
    var r = t
    for(k<-res.keys){
      if(k<=price){
        r = Math.max(t,res(k))
      }
    }
    res(price) = r
    return t
  }
}
object leetcode901 {

  def main(args: Array[String]): Unit = {
//    var S = new StockSpanner()
//    println(S.next(1239))
//    println(S.next(2106))
//    println(S.next(1850))
//    println(S.next(9611))
//    println(S.next(8008))

    var s = new StockSpanner1()
    println(s.next(100))
    println(s.next(60))
    println(s.next(50))
    println(s.next(40))
    println(s.next(30))
    println(s.next(80))
    println(s.next(60))
    println(s.next(100))
  }
}
