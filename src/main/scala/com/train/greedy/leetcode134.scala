package com.train.Greedy

object leetcode134 {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {

    for(i<-Range(0,gas.length)){
      var gass = 0
      var end = i

      while(gass>=0){
        gass += gas(end)
        gass -= cost(end)
        end += 1

        if(end==gas.length){
          end = 0
        }
        if(end == i && gass >=0){
          return i
        }
      }
    }
    return -1
  }

  def main(args: Array[String]): Unit = {
    println(canCompleteCircuit(Array(1,2,3,4,5),Array(3,4,5,1,2)))//3
    println(canCompleteCircuit(Array(2,3,4),Array(3,4,3)))//3
    println(canCompleteCircuit(Array(3,1,1),Array(1,2,2)))//0
  }
}
