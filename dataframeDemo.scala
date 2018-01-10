package demo
import org.apache.spark.sql.SparkSession
object dataframeDemo extends App{
  val spark = SparkSession.builder
    .master("local[*]")
      .config("spark.sql.warehouse.dir", "file:///D:\\study\\scala\\sbt_proj\\HelloScala")
    .appName("Spark Word Count")
    .getOrCreate()
  val df_emps = spark.read.option("header",true).csv("employee.txt")
  for( i <- df_emps.take(10)) {
    println(i)
  }
  df_emps.take(20).foreach(println)
  println(df_emps.schema)
  df_emps.createOrReplaceTempView("emp")
  val sqlEmp1 = spark.sql("SELECT department, count(*) from emp group by department")
  sqlEmp1.show()


}
