package com.darabi.mohammad.news.utils.enums

sealed class Language constructor(val code: String){

    object Arabic : Language ("ar")
    object Deutchland : Language("de")
    object English : Language("en")
    object Italy : Language("it")
    object Russia : Language("ru")
}