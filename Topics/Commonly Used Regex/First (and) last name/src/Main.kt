fun main() {
    val aaa = readln()
    val regex = Regex("[A-Z][a-z]*(\\s?[A-Z][a-z]*)?")
    val matching = regex.findAll(aaa)
    for (i in matching) println(i.value)
    // write your code here

}