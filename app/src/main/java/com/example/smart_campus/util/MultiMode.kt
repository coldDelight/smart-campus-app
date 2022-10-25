package com.example.smart_campus.util

sealed class MultiMode {
    data class Item(val id :Int,val  text:String):MultiMode()
    data class Header(val  text:String):MultiMode()
}