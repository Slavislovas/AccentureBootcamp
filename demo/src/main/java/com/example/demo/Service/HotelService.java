package com.example.demo.Service;

import com.example.demo.Model.Hotel;

import java.util.List;

public interface HotelService {
    Hotel saveHotel(Hotel hotel);
    List<Hotel> getHotels();

    Hotel getHotelById(Long id);

    Hotel updateHotel(Hotel hotel, Long id);

    void deleteHotel(Long id);
}
