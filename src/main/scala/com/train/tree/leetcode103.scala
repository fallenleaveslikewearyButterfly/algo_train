/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
 import scala.collection.mutable.{Queue,ListBuffer}
object Solution {
  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    val que = Queue[TreeNode]()
        if(root == null){
      return List()
    }
    que.enqueue(root)
    var level = 1
    val res = ListBuffer[List[Int]]()
    while(!que.isEmpty){
      val n = que.size
      val t = ListBuffer[Int]()
      for(i<-Range(0,n)){
        val node = que.dequeue()
        t.append(node.value)
        if(node.left !=null){
          que.enqueue(node.left)
        }
        if(node.right !=null){
          que.enqueue(node.right)
        }
      }
      if(level % 2 ==1){
        res.append(t.toList)
      }else{
        res.append(t.toList.reverse)
      }
      level += 1
    }
    return res.toList
  }
}
