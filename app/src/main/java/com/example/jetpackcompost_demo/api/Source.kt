package com.example.jetpackcompost_demo.api

import kotlinx.serialization.Serializable

@Serializable
data class Source(

    var title: String? = null,
    var region: String? = null,
    var domain: String? = null,
    var path: String? = null

)
