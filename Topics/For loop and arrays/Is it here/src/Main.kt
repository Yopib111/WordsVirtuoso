fun main() {
    val size = readln().toInt()
    val aaa = IntArray(size)
    for (i in 0..aaa.lastIndex) {
        aaa[i] = readln().toInt()
    }
    val num = readln().toInt()
    if (num in aaa) println("YES") else println("NO")
    // write your code here
}