fun main() {
    val text = readln()
    val regex = Regex("[a-z]*pa[a-z]*")
    val matching = regex.findAll(text)
    for (i in matching) println(i.value)
    // write your code here

}