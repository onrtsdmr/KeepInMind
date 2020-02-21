package com.onurtasdemir.keepinmind.enums

enum class Level {
    EASY{
        override fun toString(): String {
            return "Easy"
        }
    },
    NORMAL{
        override fun toString(): String {
            return "Normal"
        }
    },
    HARD{
        override fun toString(): String {
            return "Hard"
        }
    }
}