/**
  * Created by thom 
  * On 2-11-2016
  */
class TicTacToeGame {
  var board = Array(
    1 to 3,
    4 to 6,
    7 to 9
  )

  var values = 1 to 9

  /**
    * function to show the current board in the console
    */
  def printBoard {
    board.foreach { row =>
      row.foreach { cell =>
        print("|" + cell )
      }
      print("| \n")
    }
  }

  def turn(location: Int): Unit = {
    if(values contains location) {
      changeValueOnBoard(location)
      printBoard
    }
  }

  def changeValueOnBoard(location: Int): Unit = {
    if(location > 0 && location < 4) {
      board(0)(location) = 10
      println(board(0)(location))
    } else if(location > 3 && location < 7) {

    } else if(location > 6 && location < 10) {

    }
  }


}
