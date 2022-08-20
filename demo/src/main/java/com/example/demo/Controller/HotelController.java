package com.example.demo.Controller;

import com.example.demo.Model.Guest;
import com.example.demo.Model.Hotel;
import com.example.demo.Service.HotelService;
import com.example.demo.Service.impl.HotelServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hotels")
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.saveHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Hotel> getHotels(){
        return hotelService.getHotels();
    }

    @GetMapping("{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("id") Long id){
        return new ResponseEntity<Hotel>(hotelService.getHotelById(id), HttpStatus.FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable("id") Long id, @RequestBody Hotel hotel){
        return new ResponseEntity<Hotel>(hotelService.updateHotel(hotel, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable("id") Long id){
        hotelService.deleteHotel(id);
        return new ResponseEntity<String>("Hotel deleted", HttpStatus.OK);
    }
}
