package com.mundet.app_multiplatform

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}