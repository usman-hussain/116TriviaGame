package Trivia.web
import io.socket.client.{IO, Socket}
import io.socket.emitter.Emitter





class HandleMessagesFromPython() extends Emitter.Listener {
  override def call(objects: Object*): Unit = {
    val gold = objects.apply(0).toString
    println("I have " + gold + " gold")
  }
}
object Client {
  def main(args: Array[String]): Unit = {
    val socket: Socket = IO.socket("http://localhost:8080/")
    socket.on("message", new HandleMessagesFromPython)
    socket.connect()
    socket.emit("register", "ScalaUser")
    socket.emit("clickGold")
    socket.emit("clickGold")
    socket.emit("clickGold")
    socket.emit("clickGold")
    socket.emit("clickGold")
  }
}
