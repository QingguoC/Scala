package demo
import java.sql.{Connection,DriverManager}
object sqlDemo {
  def main(args: Array[String]): Unit = {

      //must add mysql jdbc driver jar file into project structure library


      // connect to the database named "mysql" on port 8889 of localhost
      val url = "jdbc:mysql://localhost:3306/cs6400_fa17_team012"
      val driver = "com.mysql.jdbc.Driver"
      val username = "gatechUser"
      val password = "gatech123"

      try {
        Class.forName(driver)
        val connection:Connection = DriverManager.getConnection(url, username, password)
        val statement = connection.createStatement
        val rs = statement.executeQuery("SELECT * FROM Customer")
        while (rs.next) {
          val usr = rs.getString("username")
          val pwd = rs.getString("password")
          println("usr = %s, pwd = %s".format(usr,pwd))
        }
      } catch {
        case e: Exception => e.printStackTrace
      }
  }
}
