fun main() {
    val size = readln().toInt()
    val aaa = IntArray(size)
    for (i in 0 .. aaa.lastIndex) {
        aaa[i] = readln().toInt()
    }
    val (a, b) = readln().split(' ')
    if (a.toInt() in aaa && b.toInt() in aaa) println("YES") else println("NO")
    // write your code here
}