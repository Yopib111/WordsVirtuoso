fun main() {
    val aaa = readln()
    val regex = Regex("(\\b\\d{2}|\\d{4})\\.\\d{2}\\.\\d{2}")
    val matching = regex.findAll(aaa)
    for (i in matching) println(i.value)
    // write your code here
}