package com.train.tree

object leetcode222 {
  def countNodes(root: TreeNode): Int = {
    if(root==null){
      return 0
    }
    val left = countDepth(root.left)
    var right = countDepth(root.right)
    if(left == right){
      return countNodes(root.right) + (1<<left)
    }else{
      return countNodes(root.left) + (1<<right)
    }
  }

  private def countDepth(root:TreeNode):Int = {
    var depth = 0
    var r = root
    while(r != null){
      depth += 1
      r = r.left
    }
    return depth
  }

}
