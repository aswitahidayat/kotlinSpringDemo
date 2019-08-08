package com.example.springBootDemo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Hotel(val name: String, val classification: Int, val nbRooms: Int) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Long = 0
    var nbFreeRooms = nbRooms

    constructor(): this("", 0, 0)

    fun checkIn(nbGuest: Int){
        if(nbFreeRooms >= nbGuest){
            nbFreeRooms -= nbGuest
        }
    }

    fun checkOut(nbGuest: Int){
        nbFreeRooms += nbGuest
    }
}