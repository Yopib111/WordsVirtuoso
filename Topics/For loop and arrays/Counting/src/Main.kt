fun main() {
    val size = readln().toInt()
    val aaa = IntArray(size)
    for (i in 0..aaa.lastIndex) {
        aaa[i] = readln().toInt()
    }
    val num = readln().toInt()
    var sum = 0
    for (i in aaa) {
        if (i == num) sum++
    }
    println(sum)
    // write your code here
}