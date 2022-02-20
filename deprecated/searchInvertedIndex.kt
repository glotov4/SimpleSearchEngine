package search.deprecated

import java.util.Scanner

/** Deprecated **/
/** Read and process single-word query. Print lines that contain that query **/
fun searchInvertedIndex(dataSet: List<String>, invertedIndexMap: MutableMap<String, MutableSet<Int>>) {
    /** Read query from standard input, make it uppercase **/
    println("Enter a name or email to search for all matching people:")
    val query = Scanner(System.`in`).nextLine()!!.uppercase()

    /** Searching **/
    if (invertedIndexMap.containsKey(query)) {
        // How many people found?
        if (invertedIndexMap[query]!!.size == 1) {
            println("1 person found:")
        } else {
            println("${invertedIndexMap[query]!!.size} persons found:")
        }

        // Word is in the list? Yes - print every line
            for (index in invertedIndexMap[query]!!) {
                println(dataSet[index])
            }
        // Word is not in the list: "not found"
    } else println("No matching people found.")
}
