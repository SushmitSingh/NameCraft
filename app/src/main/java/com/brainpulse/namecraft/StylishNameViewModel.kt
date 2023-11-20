package com.brainpulse.namecraft

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StylishNameViewModel : ViewModel() {

    private val _stylishNames = MutableLiveData<List<String>>()
    val stylishNames: LiveData<List<String>> get() = _stylishNames

    private val styleSets = mapOf(
        "stars" to listOf('★', '☆', '✰', '✩', '✭', '✮', '✯', '✡', '✦', '✧', '✪', '✫', '✬', '✭', '✮', '✯', '✰', '✱', '✲', '✳', '✴', '✵', '✶', '✷', '✸', '✹', '✺', '✻', '✼', '✽', '✾', '✿', '❀', '❁', '❂', '❃', '❄', '❅', '❆', '❇', '❈', '❉', '❊', '❋'),
        "brackets" to listOf('[', ']', '(', ')', '{', '}', '〈', '〉', '⟨', '⟩', '〈', '〉', '❮', '❯', '❬', '❭', '❰', '❱', '❪', '❫', '❴', '❵', '❲', '❳', '⦃', '⦄', '⦅', '⦆', '⦇', '⦈', '⦉', '⦊', '⦋', '⦌', '⦍', '⦎', '⦏', '⦐', '⦑', '⦒', '⦓', '⦔', '⦕', '⦖', '⦗', '⦘', '⧘', '⧙', '⧚', '⧛', '⧼', '⧽', '⸂', '⸃', '⸄', '⸅', '⸉', '⸊', '⸌', '⸍', '⸜', '⸝', '⸠', '⸡', '⸢', '⸣', '⸤', '⸥', '⸦', '⸧', '⸨', '⸩', '〔', '〕', '〖', '〗', '〘', '〙', '〚', '〛', '《', '》', '「', '」', '『', '』', '〔', '〕', '〖', '〗', '〘', '〙', '〚', '〛', '〝', '〞', '〟', '〰', '〽', '〾', '〿', '⌈', '⌉', '⌊', '⌋', '〈', '〉', '❨', '❩', '❪', '❫', '❬', '❭', '❮', '❯', '❰', '❱'),
        "symbols" to listOf('♡', '♢', '♤', '♧', '♚', '♛', '♜', '♝', '♞', '♟', '♔', '♕', '♖', '♗', '♘', '♙', '♩', '♪', '♫', '♬', '♭', '♮', '♯', '♦', '♨', '♣', '♢', '♠', '♡', '♦', '♧', '♥', '♤', '♠', '♚', '♛', '♜', '♝', '♞', '♟', '♔', '♕', '♖', '♗', '♘', '♙'),
        "circles" to listOf('○', '●', '◌', '◍', '◎', '◯', '⭕', '⭖', '⭗', '⭘', '⭙', '⭚', '⭛', '⭜', '⭝', '⭞', '⭟', '⭠', '⭡', '⭢', '⭣', '⭤', '⭥', '⭦', '⭧', '⭨', '⭩', '⭪', '⭫', '⭬', '⭭', '⭮', '⭯', '⭰', '⭱', '⭲', '⭳', '⭴', '⭵', '⭶', '⭷', '⭸', '⭹', '⭺', '⭻', '⭼', '⭽', '⭾', '⭿'),
        "arrows" to listOf('↑', '↓', '←', '→', '↖', '↗', '↘', '↙', '↕', '↔', '⇐', '⇒', '⇑', '⇓', '⇔', '⇗', '⇘', '⇙', '⇚', '⇛', '⇜', '⇝', '⇞', '⇟', '⇠', '⇡', '⇢', '⇣', '⇤', '⇥', '⇦', '⇧', '⇨', '⇩', '⇪', '⇫', '⇬', '⇭', '⇮', '⇯', '⇰', '⇱', '⇲', '⇳', '⇴', '⇵', '⇶', '⇷', '⇸', '⇹', '⇺', '⇻', '⇼', '⇽', '⇾', '⇿'),
    )


    fun generateStylishNames(inputName: String, variations: Int) {
        // Use StyleSets to generate variations of the input names characters and add them to the list
        val namesList = mutableListOf<String>()

        repeat(variations) { variation ->
            val stylishName = buildString {
                for (char in inputName) {
                    appendRandomStyleChar(char, variation)?.let { append(it) }
                }
            }
            namesList.add(stylishName)
        }

        Log.d("TAG", "generateStylishNames: $namesList")
        // Assuming you want to update LiveData with the result
        _stylishNames.value = namesList
    }

    private fun appendRandomStyleChar(char: Char, variation: Int): Comparable<Nothing>? {
        // Map each character to a list of corresponding special characters with different fonts
        val specialCharsMap = mapOf(
            'a' to listOf('α', "𝓪", "𝒶"),
            'b' to listOf('β', "𝓫", "𝒷"),
            'c' to listOf('ç', "𝓬", "𝒸"),
            'd' to listOf('δ', "𝓭", "𝒹"),
            'e' to listOf('ε', "𝓮", 'ℯ'),
            'f' to listOf('ƒ', "𝓯", "𝒻"),
            'g' to listOf('ɢ', "𝓰", "𝓖"),
            'h' to listOf('н', "𝓱", "𝒽"),
            'i' to listOf('ɪ', "𝓲", "𝒾"),
            'j' to listOf('ʝ', "𝓳", "𝒿"),
            'k' to listOf('к', "𝓴", "𝓚"),
            'l' to listOf('ℓ', "𝓵", "𝓛"),
            'm' to listOf('м', "𝓶", "𝓜"),
            'n' to listOf('ɴ', "𝓷", "𝓝"),
            'o' to listOf('σ', "𝓸", "𝒪"),
            'p' to listOf('ρ', "𝓹", "𝒫"),
            'q' to listOf('q', "𝓺", "𝒬"), // No specific mapping, using the same character
            'r' to listOf('ʀ', "𝓻", "𝓡"),
            's' to listOf('ѕ', "𝓼", "𝒮"),
            't' to listOf('т', "𝓽", "𝒯"),
            'u' to listOf('υ', "𝓾", "𝒰"),
            'v' to listOf('ν', "𝓿", "𝒱"),
            'w' to listOf('ω', "𝔀", "𝒲"),
            'x' to listOf('χ', "𝔁", "𝒳"),
            'y' to listOf('у', "𝔂", "𝒴"),
            'z' to listOf('z', "𝔃", "𝒵"), // No specific mapping, using the same character
        )


        val styleSetsList = styleSets.values.toList()
        val style = styleSetsList[variation % styleSetsList.size]

        return specialCharsMap[char]?.let { fonts ->
            val selectedFont = fonts.random()
            styleSets.entries.find { it.value.contains(selectedFont) }?.key ?: selectedFont
        } ?: style.randomOrNull()
    }

}
