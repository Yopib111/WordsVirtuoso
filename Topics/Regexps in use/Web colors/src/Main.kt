fun main() {
    val text = readLine()!!
    val regexColors = "#[0-9a-fA-F]{6}\\b".toRegex()
    val res = regexColors.findAll(text)
    for (matches in res) println(matches.value)
    // write your code here
}