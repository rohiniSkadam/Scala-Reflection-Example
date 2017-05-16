/**
  * Created by synerzip on 16/5/17.
  */
case class Student(var name: String, var rollNo: Int, var address: String, var marks: Double) {
  def showStudent: Unit = {
    println("Name : " + name + " Roll Number : " + rollNo + " Address : " + address + " Marks : " + marks)
  }
}