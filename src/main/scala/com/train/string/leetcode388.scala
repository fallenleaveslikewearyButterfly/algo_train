package com.train.string


object leetcode388 {
  def lengthLongestPath(input: String): Int = {
    if(input.length==0){
      return 0
    }
    var res = 0
    val l = Array.fill(input.length+1)(0)
    input.split('\n').foreach(s=>{
      var level = s.lastIndexOf('\t')+2
      var len = s.length - (level -1)
      if(s.contains(".")){
        res = Math.max(res,l(level -1)+len)
      }else{
        l(level) = l(level-1)+len+1
      }
    })
    return res
  }

  def main(args: Array[String]): Unit = {
    println(lengthLongestPath("a"))//20
    println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"))//20
    println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"))
    //32
  }
}
