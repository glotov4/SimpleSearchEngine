package search.deprecated

import java.util.Scanner

/** Deprecated. Uncomment lines in readFromFile & menu and change data types (list<string> to list<list<string>> **/

/** Read and process single query. Print lines that contain that query **/
fun searchRegular(dataSet: MutableList<MutableList<String>>) {

    /** Read query from standard input **/
    println("Enter a name or email to search for all matching people:")
    val query = Scanner(System.`in`).nextLine()!!

    /** Default messages **/
    // create possible messages
    val notFound = "No matching people found."
    val found = "People found:"
    // set default message
    var message = notFound

    /** Searching **/
    // Create output variable (list of lines)
    val output = MutableList(0){MutableList(0){""} }
    // Go through every data unit. If it contains query = add this unit to the output
    for (lines in dataSet) { // for all data units in database
        // joint Words into Lines: dataSet<lines<words>>, case-insensitive
        if (lines.joinToString(separator = " ").uppercase().contains(other = query.uppercase(), ignoreCase = true)) {
            message = found // set new message
            output += lines // add this data unit to our output list
        }
    }

    /** Output **/
    println(message) // print the message (it can be "found" or "not found")
    output.forEach{ println(it.joinToString(separator = " ")) }

    /*     reading number of search queries - deprecated, now we read single query
    println("Enter the number of search queries:")
    val queriesN = scanner.nextLine().toInt() // {number of queries} = number of strings with queries

    // reading and processing queries (searching through input dataset)
    for (queries in 1..queriesN) {    // for each query:*/
}
