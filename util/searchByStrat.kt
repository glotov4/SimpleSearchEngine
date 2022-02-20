package search.util

import java.util.Scanner

/** 1. Ask for search strategy, read query & conduct search **/
fun searchByStrat(dataSet: List<String>, invertedIndexMap: MutableMap<String, MutableSet<Int>>, strategy: String) {

    /** Read query from standard input, make it uppercase, split to list of words **/
    println("Enter a name or email to search for all matching people:")
    val query = Scanner(System.`in`).nextLine()!!.uppercase().split("\\s".toRegex())

    // set default variables
    var output = mutableSetOf<Int>() // set of #s of desired lines. Used by all search strategies
    var counter = 0 // used in "ALL" strategy
    var allLines = invertedIndexMap.flatMap { it.value }.toMutableSet() // set of #s of lines in database, used in NONE

    /** Searching **/
    // Go through every word in a query
    for (word in query) {
        if (invertedIndexMap.containsKey(word)) {
            when (strategy) {
                /** 1. ALL - find the lines containing all the words from the query. **/
                // Find intersecting lines
                "ALL" -> {
                    if (counter == 0) output.addAll(invertedIndexMap[word]!!)
                        else {
                        output = (output.intersect(invertedIndexMap[word]!!)).toMutableSet()
                        }
                    counter++
                }

                /** 2. ANY - find the lines containing at least one word from the query **/
                // Combine lines that contain each word
                "ANY" -> output = (output union invertedIndexMap[word]!!).toMutableSet()

                /** 3. NONE - find the lines that do not contain any words from the query at all **/
                "NONE" -> {
                    // Subtract lines with words from query from list of all lines
                    allLines = allLines.subtract(invertedIndexMap[word]!!).toMutableSet()
                    output = allLines
                }
            }
        }
    }

    /** Print the output & it's size. If zero - print "not found" **/
    when (output.size) {
        0 -> println("No matching people found.")
        else -> {
            var s = "s"
            if (output.size == 1) s = ""
            println("${output.size} person$s found:")
            output.forEach { println(dataSet[it]) }
        }
    }
}
