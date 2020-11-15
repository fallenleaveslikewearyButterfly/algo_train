package com.train.tree

object leetcode814 {

  def containsOne(node: TreeNode):Boolean={
    if(node ==null){
      return false
    }
    val a1 = containsOne(node.left)
    val a2 = containsOne(node.right)
    if(!a1){
      node.left=null
    }
    if(!a2){
      node.right=null
    }
    return node.value==1 || a1 || a2
  }

  def pruneTree(root: TreeNode): TreeNode = {
    if(containsOne(root)){
      return root
    }else{
      return null
    }
  }

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(1)
    root.right =  new TreeNode(0)
    root.right.left = new TreeNode(0)
    root.right.right = new TreeNode(0)
    root.right =  new TreeNode(1)
    root.right.left = new TreeNode(0)
    root.right.right = new TreeNode(1)
    pruneTree(root)
    println(root)
  }
}
