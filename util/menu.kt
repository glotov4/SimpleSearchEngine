package search.util

import java.util.Scanner

/** Menu **/
fun menu(dataSet: List<String>, invertedIndex: MutableMap<String, MutableSet<Int>>) { // change to list<list<String>> to work with searchRegular

    /** Menu text - find, print, exit **/
    val menuText = ("""
=== Menu ===
1. Find a person
2. Print all people
0. Exit program""")

    /** Processing menu commands **/
    while (true) { // create infinite loop for inputs from scanner. Break it only with "0" (exit)
        println(menuText)
        when (Scanner(System.`in`).nextLine()) {

            /** 1. Ask for search strategy & conduct search **/
            "1" -> {
                println("""
=== Select a matching strategy: ===
1. ALL
2. ANY
3. NONE
4. Go back
0. Exit program""")
                when (Scanner(System.`in`).nextLine().uppercase()) {
                    "1" -> searchByStrat(dataSet, invertedIndex, "ALL")
                    "2" -> searchByStrat(dataSet, invertedIndex, "ANY")
                    "3" -> searchByStrat(dataSet, invertedIndex, "NONE")
                    "4" -> "" // To the main menu
                    "0" -> break // Exit the program
                    else -> println("Incorrect option! Please, try again.")
                }
            }

            /** 2. Print dataset **/
            "2" -> dataSet.forEach{ println(it) }

            /** 0. Exit program by breaking the loop **/
            "0" -> break

            /** Any other command -> "Incorrect option!" **/
            else -> println("Incorrect option! Please, try again.")
        }
    }
    println("Bye!")
}