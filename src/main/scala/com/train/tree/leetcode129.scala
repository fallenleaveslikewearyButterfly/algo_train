package com.train.tree

import scala.collection.mutable.ListBuffer

class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

object leetcode129 {


  def _dfs(root:TreeNode,list:ListBuffer[Int],res:ListBuffer[Int]) : Unit={
    if(root.left ==null && root.right == null){
      var t = 0
      for(i<-Range(0,list.length)){
         t = t + list(i)*math.pow(10,list.length-i).toInt
      }

      res.append(t+root.value)
    }else{
      list.append(root.value)
      if(root.left!=null){
        _dfs(root.left,list,res)
      }
      if(root.right!=null){
        _dfs(root.right,list,res)
      }
      list.remove(list.length-1)
    }
  }

  def sumNumbers(root: TreeNode): Int = {
    if(root==null){
      return 0
    }
    val list = ListBuffer[Int]()
    val res = ListBuffer[Int]()
    _dfs(root,list,res)
    return res.sum
  }

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(4)
    root.left = new TreeNode(9)
    root.right = new TreeNode(0)
    root.left.left = new TreeNode(5)
    root.left.right = new TreeNode(1)
    println(sumNumbers(root))
  }


}
