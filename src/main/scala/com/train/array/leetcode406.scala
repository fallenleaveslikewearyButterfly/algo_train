package com.train.array

object leetcode406 {

  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
    var peopleSorted = people.sortWith((a,b)=>{
      if(a(0)==b(0)){
        a(1)<b(1)
      }else{
        a(0)>b(0)
      }
    })
    for(i<-Range(1,peopleSorted.length)){
      var t = peopleSorted(i)
      for(j<-Range(i,t(1),-1)){
        peopleSorted(j) = peopleSorted(j-1)
      }
      peopleSorted(t(1)) = t
    }
    return peopleSorted
  }

  def main(args: Array[String]): Unit = {
    val r = reconstructQueue(Array(
      Array(7,0),
      Array(4,4),
      Array(5,0),
      Array(6,1),
      Array(5,2)
    ))//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    print(r)
  }
}
