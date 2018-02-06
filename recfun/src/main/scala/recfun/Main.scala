package recfun
import scala.collection.mutable.Stack
object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    def pascalsum(col: Int, row: Int): Int = {

      if (col == 0) {
        1
      }
      else if (col == row) {
        1
      }
      else {
        pascalsum(col - 1, row - 1) + pascalsum(col, row - 1)
      }
    }

    pascalsum(c, r)

  }

  /**
    * Exercise 2
    **/
  def balance(chars: List[Char]): Boolean = {
    def foundPairParantheses(parantheses: Stack[Char], index: Int, sentence: List[Char]): Boolean = {
      if (sentence.length == index) {
        if (parantheses.length > 0) {
          false
        }
        else {
          true
        }
      }
      else if (sentence(index) == ')' && parantheses.length == 0) {
        false
      }
      else {
        if (sentence(index) == '(') {
          parantheses.push('(')
        }
        else if (sentence(index) == ')') {
          parantheses.pop

        }
        foundPairParantheses(parantheses, index + 1, sentence)
      }

    }

    foundPairParantheses(Stack(), 0, chars)
  }


  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countPossibility(total:Int,poscoins:List[Int]):Int= {
      if (total==money)
        1
      else if (total> money)
        0
      else {
        if (poscoins.isEmpty)
          {
            0
          }
        else {
          countPossibility(total + poscoins.head, poscoins) + countPossibility(total, poscoins.tail)
        }
      }
    }
    countPossibility(0,coins)
  }
}