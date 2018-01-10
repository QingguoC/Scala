package demo
import org.apache.spark.sql.SparkSession
object sparkDemo extends App{
    /*http://blog.miz.space/tutorial/2016/08/30/how-to-integrate-spark-intellij-idea-and-scala-install-setup-ubuntu-windows-mac/
    * must config build.sbt file to add spark dependencies and the scala version must match spark's
    * Then rebuild the project
    * */
    val spark = SparkSession.builder
      .master("local[*]")
      .appName("Spark Word Count")
      .getOrCreate()

    val lines = spark.sparkContext.parallelize(
      Seq("Spark Intellij Idea Scala test one",
        "Spark Intellij Idea Scala test two",
        "Spark Intellij Idea Scala test three"))

    val counts = lines
      .flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)

    counts.foreach(println)

}
