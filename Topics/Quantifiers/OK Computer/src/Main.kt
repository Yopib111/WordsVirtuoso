fun main() {
    val text = readln()
    val regex = Regex(".*Computer.*")
    println(regex.matches(text))
    // write your code here
}