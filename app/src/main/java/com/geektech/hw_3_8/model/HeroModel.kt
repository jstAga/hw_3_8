package com.geektech.hw_3_8.model

import java.io.Serializable

data class HeroModel(
    val name: String? = null,
    val status: String? = null,
    val image: String? = null
) : Serializable
