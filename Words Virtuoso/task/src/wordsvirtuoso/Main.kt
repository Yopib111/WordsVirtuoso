package wordsvirtuoso

import java.io.File
import kotlin.random.Random
import kotlin.system.exitProcess

private var wrongSymbolsSet = mutableSetOf<Char>()

fun main(wordsAndCandidates: Array<String>) { // wordsAndCandidates: Array<String>
//    ссылка на путь: C:\Users\user\Desktop\words111.txt C:\Users\user\Desktop\cand.txt
//    print("Input the words file: ")
//    val lene = "C:\\Users\\user\\Desktop\\words.txt C:\\Users\\user\\Desktop\\candidates.txt"
//    val wordsAndCandidates = lene.split(' ') //эту строчку потом нужно будет закомментить

//    проверка файлов на соответствие условиям игры
    if (wordsAndCandidates.size != 2) {
        print("Error: Wrong number of arguments.")
        exitProcess(0)
    }
    val wordsFile = File(wordsAndCandidates[0])
    val candidatesFile = File(wordsAndCandidates[1])

    if (!wordsFile.exists()) {
        println("Error: The words file $wordsFile doesn't exist.")
        exitProcess(0)
    }
    if (!candidatesFile.exists()) {
        println("Error: The candidate words file $candidatesFile doesn't exist.")
        exitProcess(0)
    }
    var invalidWordsCounter = 0
    for (line in wordsFile.readLines()) {
        if (!checkAlphabet(line) || duplicateCheckTrue(line) || line.length != 5) invalidWordsCounter++
    }
    if (invalidWordsCounter > 0) {
        println("Error: $invalidWordsCounter invalid words were found in the $wordsFile file.")
        exitProcess(0)
    }
    invalidWordsCounter = 0
    for (line in candidatesFile.readLines()) {
        if (!checkAlphabet(line) || duplicateCheckTrue(line) || line.length != 5) invalidWordsCounter++
    }
    if (invalidWordsCounter > 0) {
        println("Error: $invalidWordsCounter invalid words were found in the $candidatesFile file. ")
        exitProcess(0)
    }
    var numberCandidateNotIncluded = 0
    for (words in candidatesFile.readLines()) {
        var checkOk = 0
        for (basicWords in wordsFile.readLines()) {
            if (words.lowercase() == basicWords.lowercase()) checkOk ++
        }
        if (checkOk == 0) numberCandidateNotIncluded++
    }
    if (numberCandidateNotIncluded > 0) {
        println("Error: $numberCandidateNotIncluded candidate words are not included in the $wordsFile file.")
        exitProcess(0)
    }
    else println("Words Virtuoso")
    println()

// начало игры
    val totalNumberOfCandidateWords = candidatesFile.readLines().size
    val correctWordNumber = Random.nextInt(0, totalNumberOfCandidateWords)
    val correctWord = candidatesFile.readLines()[correctWordNumber]

//    println(correctWord) // УДАЛИТЬ ПОТОМ ПРИ ПРОВЕРКЕ
//    начало цикла по угадыванию слова
    var tryingWord = ""
    var tryingCounter = 0
    val tryingWordsList = emptyList<String>().toMutableList()
    val start = System.currentTimeMillis()

    do {
        println("Input a 5-letter word:")
        tryingWord = readln().lowercase()
        if (tryingWord == correctWord) {
            if (tryingCounter == 0) {
                println()
                for (i in 0..4) {
                    print("\u001B[48:5:10m${tryingWord[i].uppercase()}\u001B[0m")
                }
//                println("\u001B[48:5:10m${tryingWord.uppercase()}\u001B[0m")
                println()
                println("Correct!")
                println("Amazing luck! The solution was found at once.")
            } else {
                println(tryingWordsList.joinToString(separator = "\n"))
                println()
                for (i in 0..4) {
                    print("\u001B[48:5:10m${tryingWord[i].uppercase()}\u001B[0m")
                }
//                println("\u001B[48:5:10m${tryingWord.uppercase()}\u001B[0m")
                println("Correct!")
                val end = System.currentTimeMillis()
                val duration = (end - start) / 1000 // Milliseconds as a Long
                println("The solution was found after ${tryingCounter+1} tries in $duration seconds.")
            }
            exitProcess(0)
        }
        if (tryingWord == "exit") break
        if (tryingWord.length != 5) {
            println("The input isn't a 5-letter word.")
            continue
        }
        if (!checkAlphabet(tryingWord)) {
            println("One or more letters of the input aren't valid.")
            continue
        }
        if (duplicateCheckTrue(tryingWord)) {
            println("The input has duplicate letters.")
            continue
        }
        if (tryingWord !in wordsFile.readLines()) {
            println("The input word isn't included in my words list.")
            continue
        }

        tryingWordsList += (checkInputWord(correctWord, tryingWord))
        println(tryingWordsList.joinToString(separator = "\n"))
        println()
        println("\u001B[48:5:14m${wrongSymbolsSet.sorted().joinToString(separator = "", prefix = "", postfix = "")}\u001B[0m")
        tryingCounter++


    }
    while (tryingWord != "wlnaskgjnslknvcvnbsgkbnaa")
    println("The game is over.")
}

fun checkAlphabet(str: String): Boolean {
    for (i in str) {
        if (i !in 'a'..'z' && i !in 'A'..'Z') return false
    }
    return true
}

fun duplicateCheckTrue(str: String): Boolean {
    for (i in str) {
        var count = 0
        for (j in str) {
            if (i == j) count++
        }
        if ( count > 1) return true

    }
    return false
}

fun checkInputWord(secretWord: String, inputWord: String) :String {
    var outputStr = ""
    for (i in 0..4) {
        if (inputWord[i] == secretWord[i]) {
            outputStr += "\u001B[48:5:10m${inputWord[i].uppercase()}\u001B[0m"
        } else {
            if (inputWord[i] in secretWord) {
                outputStr += "\u001B[48:5:11m${inputWord[i].uppercase()}\u001B[0m"
            } else {
                outputStr += "\u001B[48:5:7m${inputWord[i].uppercase()}\u001B[0m"
                wrongSymbolsSet += inputWord[i].uppercaseChar()
            }
        }
    }
    return outputStr
}