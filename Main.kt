package search

import search.util.createInvertedIndex
import search.util.menu
import search.util.readFromFile

fun main(args: Array<String>) {

    /** Read dataSet from the input file in the form of dataSet<lines<words>> **/
    val dataSet = readFromFile(args) // in case of error switches to default file

    /** Create an Inverted Index **/
    // Inverted Index maps each word to all lines (or positions/documents) in which the word occurs
    val invertedIndex = createInvertedIndex(dataSet)

    /** Open the menu **/
    menu(dataSet, invertedIndex)

}