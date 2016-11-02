/**
  * Created by thom 
  * On 2-11-2016
  */
object ticTacToe {
  def main(args: Array[String]): Unit = {
    val input = readLine("Start new tic tac toe game? (Y/N) ")
    if(input == "Y"){
      println("start game")
      var game = new TicTacToeGame();
      game.printBoard
      game.turn(2)
    }

  }
}
