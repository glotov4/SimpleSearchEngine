package search.util

/** Create an Inverted Index map **/
// Inverted Index maps each word to all lines (or positions/documents) in which the word occurs
fun createInvertedIndex(lines: List<String>) : MutableMap<String, MutableSet<Int>> {

    // Key: Words - String, Value: Indices of lines - Set<Int>
    val invertedIndexMap = mutableMapOf<String, MutableSet<Int>>()

    /** Put every word of a line in a map (in uppercase): word[line's_index] **/
    lines.forEachIndexed { index, line ->
        val words = line.uppercase().split("\\s+".toRegex())

        /** For each word in line check if it is in map, add it in **/
        for (word in words) {
            if (!invertedIndexMap.containsKey(word)) {
                // Yes - add index to map entry
                invertedIndexMap[word] = mutableSetOf<Int>(index)
            } else {
                // No - create new map entry
                invertedIndexMap[word]!!.add(index)
            }
        }
    }
    return invertedIndexMap
}