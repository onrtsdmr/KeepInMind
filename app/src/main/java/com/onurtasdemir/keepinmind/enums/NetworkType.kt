package com.onurtasdemir.keepinmind.enums

enum class NetworkType {
    NO_NETWORK{
        override fun toString(): String {
            return "Bağlantı Hatası"
        }
    },
    RELOAD{
        override fun toString(): String {
            return "Yenile"
        }
    }
}