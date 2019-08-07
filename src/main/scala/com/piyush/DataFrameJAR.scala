package com.piyush

import org.apache.log4j.Logger
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object DataFrameJAR {
  def main(args: Array[String]): Unit = {
    import org.apache.log4j.Level
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sparkSession=SparkSession.builder().appName("First Program").master("local")getOrCreate();
    val Employee=List(Row("Piyush","Jiwane","jiwanepiyush@gmail.com",10000),Row("Gaurav","Jiwane","gaurav.jiwane22@gmail.com",20000));
    val EmployeeSchema=List(StructField("FirstName",StringType,true),StructField("LastName",StringType,true),StructField("Email",StringType,true),StructField("Salary",IntegerType,true));
    val empDF=sparkSession.createDataFrame(sparkSession.sparkContext.parallelize(Employee),StructType(EmployeeSchema));
    empDF.show();

  }
}
