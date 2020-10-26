package com.train.string

import scala.util.control.Breaks._
object leetcode925 {

  def isLongPressedName(name: String, typed: String): Boolean = {
    var i = 0
    var j = 0
    while(i<name.length && j<typed.length){
      if(name(i)==typed(j)){
        var countI=0
        var countJ=0
        breakable{
          for(t<-Range(i,name.length)){
            if(name(t)==name(i)){
              countI +=1
            }else{
              break()
            }
          }
        }
        breakable{
          for(t<-Range(j,typed.length)){
            if(typed(t)==typed(j)){
              countJ +=1
            }else{
              break()
            }
          }
        }
        i += countI
        j += countJ
        if(countI>countJ)
          return false
      }else{
        return false
      }

    }
    if((i==name.length-1 && j!=typed.length-1) || (i!=name.length-1 && j==typed.length-1)){
      return false
    }else{
      return true
    }

  }

  def main(args: Array[String]): Unit = {
    //"vtkgn"
    //"vttkgnn"
    println(isLongPressedName("leelee","lleeelee"))
    println(isLongPressedName("saeed","ssaaedd"))
    println(isLongPressedName("alex","alexxr"))
    println(isLongPressedName("pyplrz","ppyypllr"))
    println(isLongPressedName("vtkgn","vttkgnn"))
  }
}
