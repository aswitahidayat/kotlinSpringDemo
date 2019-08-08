package com.example.springBootDemo

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hotels")
class HotelController(val hotelRepository: HotelRepository) {

    @GetMapping("/all")
    fun all(): MutableIterable<Hotel> = this.hotelRepository.findAll()

    @GetMapping("/{name}")
    fun byName(@PathVariable(value = "name") name: String): List<Hotel>  = hotelRepository.findByName(name)

    @PostMapping("/checking")
    fun checkIn(@RequestBody checkInRequest: ChekInRequest){
        val hotel = hotelRepository.findByName(checkInRequest.hotelName)[0]
        hotel.checkIn(checkInRequest.nbGuest)

        this.hotelRepository.save(hotel)
    }
}