import scala.collection.mutable.ListBuffer

object leetcode417 {

  val res = ListBuffer[List[Int]]()
  var leftFlag = false
  var rightFlag = false
  val d = List((-1,0),(0,-1),(1,0),(0,1))

  def _dfs(matrix: Array[Array[Int]],startX:Int,startY:Int,visited:Array[Array[Int]]): Boolean ={
    if(startX==0 || startY==0 ){
      leftFlag=true
    }
    if(startX==matrix.length-1 || startY==matrix(0).length-1 ){
      rightFlag=true
    }
    if(rightFlag&&leftFlag){
      return true
    }

    visited(startX)(startY)=1
    for((x,y) <- d){
      val newX = startX + x
      val newY = startY + y
      if(newX >=0 && newX < matrix.length && newY>=0 && newY < matrix(0).length && visited(newX)(newY)==0 &&(matrix(newX)(newY)<= matrix(startX)(startY))){
        if(_dfs(matrix,newX,newY,visited))
          return true
      }
    }
    visited(startX)(startY)=0
    false
  }

  def pacificAtlantic(matrix: Array[Array[Int]]): List[List[Int]] = {
    res.clear()


    for(i<-Range(0,matrix.length)){
      for(j<-Range(0,matrix(0).length)){
        leftFlag=false
        rightFlag=false
        val visited = Array.ofDim[Int](matrix.length,matrix(0).length)
        if(_dfs(matrix,i,j,visited))
          res.append(List(i,j))
      }
    }
    res.toList
  }

  def main(args: Array[String]): Unit = {
    val matrixs = Array(
      Array(
        Array(1,2,2,3,5),
        Array(3,2,3,4,4),
        Array(2,4,5,3,1),
        Array(6,7,1,4,5),
        Array(5,1,1,2,4)
      )
    )
    matrixs.foreach(matrix=>{
      pacificAtlantic(matrix)
    })
  }
}
