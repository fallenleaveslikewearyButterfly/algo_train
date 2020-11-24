package com.train.string

object leetcode5605 {
  def arrayStringsAreEqual(word1: Array[String], word2: Array[String]): Boolean = {
    return word1.mkString == word2.mkString
  }

}
