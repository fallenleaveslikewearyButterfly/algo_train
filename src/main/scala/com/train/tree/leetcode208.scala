package com.train.tree


class Trie() {

  /** Initialize your data structure here. */
  private val children = Array.ofDim[Trie](26)
  private var isEnd = false

  /** Inserts a word into the trie. */
  def insert(word: String): Unit = {
    var node = this
    for(i<-Range(0,word.length)){
      val ch = word(i)
      val index:Int = ch-'a'
      if(node.children(index)==null){
        node.children(index) = new Trie()
      }
      node = node.children(index)
    }
    node.isEnd = true
  }

  /** Returns if the word is in the trie. */
  def search(word: String): Boolean = {
    val node = searchPrefix(word)
    return node !=null && node.isEnd
  }

  private def searchPrefix(prefix:String): Trie ={
    var node = this
    for(i<-Range(0,prefix.length)){
      val ch = prefix(i)
      val index:Int = ch-'a'
      if(node.children(index)==null){
        return null
      }
      node = node.children(index)
    }
    return node
  }
  /** Returns if there is any word in the trie that starts with the given prefix. */
  def startsWith(prefix: String): Boolean = {
    return searchPrefix(prefix)!=null
  }

}
object leetcode208 {

  def main(args: Array[String]): Unit = {

  }

}
