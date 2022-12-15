fun main() {
    val number = readln()
    val fixed = number.replace("[a-zA-Z]".toRegex(),"")
    println(fixed)
    // write your code here
}