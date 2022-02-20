package search.deprecated

import java.util.Scanner

/** Deprecated **/

/** Reads the size of & the dataset from standard input **/
fun readFromInput(): MutableList<MutableList<String>> {
    val scanner = Scanner(System.`in`)

    /** Read number of lines **/
    println("Enter the number of data units:")
    val dataUN = scanner.nextLine().toInt() // {number of data units} = number of strings with data

    /** Reading dataset line by line **/
    println("Enter data units:")
    val dataSet = MutableList(0) { MutableList(0) { "" } } // List in the list. 1 Inner list = 1 data unit
    for (data in 1..dataUN) { // read input {number of data units} times
        // scan next line, trim from leading and trailing whitespace, split by remaining whitespaces (>=1), put as list in inner list
        dataSet += scanner.nextLine().trim().split("\\s+".toRegex()).toMutableList()
    }
    return dataSet
}

// put it in "readFromFile"
//  uncomment if you need regularSearch
//    /** Map each line into list of words. Output = lines<line<words>> **/
//    val output = mutableListOf<MutableList<String>>()
//    lines.mapTo(output) { it.split("\\s+".toRegex()).toMutableList() }
//
//    /** Output is a list of words **/
//    return output

/* puts each word into separate inner list, deprecated
fun readFromFile(_args: Array<String>): MutableList<MutableList<String>> {
    var fileName = "src/default.txt"
    if (_args[0] == "--data") fileName = "src/" + _args[1]
    val file = File(fileName)
    val lines = file.readLines()
    var output = mutableListOf<MutableList<String>>()
    lines.mapTo(output) { it.split(" ").toMutableList() }
    return output
}
*/
