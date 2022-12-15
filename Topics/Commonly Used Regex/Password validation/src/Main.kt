fun main() {
    val aaa = readln()
    val regex = Regex("([A-Z]+[a-z]+[0-9]+)+")
    if (aaa.matches(regex)) println("Password saved") else println("Password is too simple")
    // write your code here

}