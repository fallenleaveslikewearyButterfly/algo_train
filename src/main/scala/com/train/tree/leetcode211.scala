package com.train.tree

import scala.collection.mutable.Map
class WordDictionary() {

  /** Initialize your data structure here. */
  private val children = Map[Char,WordDictionary]()
  private var isEnd = false

  /** Inserts a word into the trie. */
  def addWord(word: String): Unit = {
    var node = this
    for(i<-Range(0,word.length)){
      val ch = word(i)
      if(!node.children.contains(ch)){
        node.children.+=(ch->new WordDictionary())
      }
      node = node.children(ch)
    }
    node.isEnd = true
  }

  private def _search(word:String,wordDic:WordDictionary):Boolean={
    if(word.length==0){
      return wordDic.isEnd
    }
    else{
      for(i<-Range(0,word.length)){
        val ch = word(i)
        if(ch == '.' ){
          for(item<-wordDic.children.values){
            if(_search(word.slice(i+1,word.length),item)){
              return true
            }
          }
          return false
        }else{
          if(wordDic.children.contains(ch)){
            return _search(word.slice(i+1,word.length),wordDic.children(ch))
          }else{
            return false
          }
        }
      }
    }
    return true
  }

  def search(word: String): Boolean = {
    return _search(word,this)
  }

}

object leetcode211 {
  def main(args: Array[String]): Unit = {
    val wc = new WordDictionary()
    wc.addWord("bad")
    wc.addWord("dad")
    wc.addWord("mad")
    println(wc.search("pad"))//false
    println(wc.search("bad"))//true
    println(wc.search(".ad"))//true
    println(wc.search("b.."))//true
  }

}
