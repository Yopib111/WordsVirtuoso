fun getCamelStyleString(inputString: String): String {
    var newString = ""
    if (inputString[0] == '_') newString += "" else newString += inputString[0].uppercase()
    for (i in 1..inputString.length-1) {
        if (inputString[i-1] == '_') {
            newString += inputString[i].uppercase()
        } else {
            newString += inputString[i]
        }
    }
    val result = newString.replace("_".toRegex(), "")
    // put your code here   
    return result
}
//
//fun main(){
//    println(getCamelStyleString("A_modern_programming_language_that_makes_developers_happier"))
//}