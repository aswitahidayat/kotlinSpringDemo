package com.example.springBootDemo

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DbSeeder(val hotelRepository: HotelRepository) : CommandLineRunner{
    override fun run(vararg args: String?) {
        this.hotelRepository.deleteAll()

        val ibis = Hotel("Ibis", 3, 30)
        val goldenTulip = Hotel("Golden Tulip", 4, 40)
        val baliBeach = Hotel("Bali Beach", 5, 50)

        val hotels = mutableListOf<Hotel>()
        hotels.add(ibis)
        hotels.add(goldenTulip)
        hotels.add(baliBeach)

        this.hotelRepository.saveAll(hotels)
        print("Database has been initialized")
    }
}