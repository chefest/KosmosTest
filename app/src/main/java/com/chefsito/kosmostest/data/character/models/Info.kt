package com.chefsito.kosmostest.data.character.models

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Int = 0
)