fun main() {
    val aaa = readln()
    val regex = Regex("[(]?[0-8]{3,10}(\\)|\\)-|-)?[0-8]{3,7}?-?[0-8]{4}?")
    val matchesRes = regex.findAll(aaa)
    for (matches in matchesRes) println(matches.value)
    // write your code here

}