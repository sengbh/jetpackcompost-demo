package com.example.jetpackcompost_demo.api

import kotlinx.serialization.Serializable

@Serializable
data class Results(
    var kind        : String?               = null,
    var domain      : String?               = null,
    var source      : Source?               = Source(),
    var title       : String?               = null,
    var publishedAt : String?               = null,
    var slug        : String?               = null,
//    var currencies  : ArrayList<Currencies> = arrayListOf(),
    var id          : Int?                  = null,
    var url         : String?               = null,
    var createdAt   : String?               = null,
//    var votes       : Votes?                = Votes()
)
