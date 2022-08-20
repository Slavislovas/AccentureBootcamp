package com.example.demo.Service.impl;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.Guest;
import com.example.demo.Model.Hotel;
import com.example.demo.Repository.HotelRespository;
import com.example.demo.Service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
    private HotelRespository hotelRespository;

    public HotelServiceImpl(HotelRespository hotelRespository) {
        super();
        this.hotelRespository = hotelRespository;
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRespository.save(hotel);
    }

    @Override
    public List<Hotel> getHotels() {
        return hotelRespository.findAll();
    }

    @Override
    public Hotel getHotelById(Long id) {
        Optional<Hotel> hotel = hotelRespository.findById(id);
        if(hotel.isPresent()){
            return hotel.get();
        } else{
            throw new ResourceNotFoundException("Id", "Id", id);
        }

    }

    @Override
    public Hotel updateHotel(Hotel hotel, Long id) {
        Hotel existingHotel = hotelRespository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Hotel", "Id", id));
        existingHotel.setName(hotel.getName());
        existingHotel.setAddress(hotel.getAddress());
        existingHotel.setCity(hotel.getCity());
        existingHotel.setCountry(hotel.getCity());
        existingHotel.setStarRating(hotel.getStarRating());
        hotelRespository.save(existingHotel);
        return existingHotel;
    }

    @Override
    public void deleteHotel(Long id) {
        Optional<Hotel> hotel = hotelRespository.findById(id);
        if(!hotel.isPresent()){
            throw new ResourceNotFoundException("id", "id", id);
        } else{
            hotelRespository.deleteById(id);
        }
    }
}
