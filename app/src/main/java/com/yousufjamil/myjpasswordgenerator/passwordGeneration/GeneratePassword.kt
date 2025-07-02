package com.yousufjamil.myjpasswordgenerator.passwordGeneration

fun GeneratePassword(length: Int): String {
    val chars = "012345678901234567890123456789!@#$%^&*()_+!@#$%^&*()_+"

    val vowels = "aeiou"
    val consonants = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdfghjklmnpqrstvwxyz"
    val wordLength = 6
    val part1 = (0 until (length/2 + length/4)).map {
        if (it % 2 == 0) consonants.random() else vowels.random()
    }.joinToString("").replaceFirstChar { it.uppercase() }

    var part2 = (1..length/4)
        .map {
            chars.random()
        }
        .joinToString("")
    if (part1.length + part2.length < length) {
        while (part1.length + part2.length < length) {
            part2 += chars.random()
        }
    }

    return part1+part2
}