/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {

      private var ans = Integer.MAX_VALUE
  private var pre = -1

      def dfs(root:TreeNode):Unit={
    if(root.left!=null){
      dfs(root.left)
    }
    if(pre == -1){
      pre = root.value
    }else{
      ans = Math.min(ans,Math.abs(root.value-pre))
      pre = root.value
    }
    if(root.right!=null){
      dfs(root.right)
    }
  }
    def getMinimumDifference(root: TreeNode): Int = {
            ans = Integer.MAX_VALUE
    pre = -1
    dfs(root)
    return ans
    }
    def main(args: Array[String]): Unit = {
    val root = new TreeNode(4)
    root.left = new TreeNode(2)
    root.right = new TreeNode(6)
    root.left.left = new TreeNode(1)
    root.left.right = new TreeNode(3)
    println(minDiffInBST(root))
  }
}
