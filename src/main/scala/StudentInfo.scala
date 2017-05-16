/**
  * Created by synerzip on 16/5/17.
  */

import scala.reflect.runtime.{universe => ru}

object StudentInfo extends App {
  val stud = new Student("Abc", 101, "Pune", 80.00)

  //Reflective Mirror = Load Symbols & names
  val mirror = ru.runtimeMirror(getClass.getClassLoader)

  //Instance Mirror = Creating invoker mirrors for methods and fields
  val instanceMirror = mirror.reflect(stud)

  //Field Mirror=  for getting/setting instance fields
  val marks = ru.typeOf[Student].decl(ru.TermName("marks")).asTerm.accessed.asTerm
  val fieldMirror = instanceMirror.reflectField(marks)

  //Method Mirror = for invoking instance methods
  val showStudent = ru.typeOf[Student].decl(ru.TermName("showStudent")).asMethod
  val mmShowStudent = instanceMirror.reflectMethod(showStudent)

  println(mmShowStudent)
  println(fieldMirror.get)
  fieldMirror.set(78.75)
  println(fieldMirror.get)
  println(mmShowStudent)
}
