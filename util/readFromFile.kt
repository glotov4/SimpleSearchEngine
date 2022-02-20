package search.util

import java.io.File

/** Read database from a file **/
fun readFromFile(args: Array<String>): List<String> {
    val defaultFileName = "default.txt"

    /** Create database with input or default filename **/
    // check if there are 2 arguments, first is --data, second is a name of a valid file. If no - use default
    val fileName = if (args.size == 2 && args[0] == "--data" && File(args[1]).canRead()) args[1]
        else defaultFileName
    val file = File(fileName)
    println("Database: $fileName")
    // create database from a file
    return file.readLines()
}