fun main() {
    val text = readln()
    val outputText = text.replace("[aA]+".toRegex(), "a")
    println(outputText)
    // write your code here
}