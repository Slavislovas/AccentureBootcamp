package com.example.demo.Service.impl;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.Guest;
import com.example.demo.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements com.example.demo.Service.GuestService {
    private GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        super();
        this.guestRepository = guestRepository;
    }

    @Override
    public Guest saveGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public List<Guest> getGuests() {
        return guestRepository.findAll();
    }

    @Override
    public Guest getGuestById(Long id) {
        Optional<Guest> guest = guestRepository.findById(id);
        if(guest.isPresent()){
            return guest.get();
        }
        throw new ResourceNotFoundException("Guest", "Id", id);
    }

    @Override
    public Guest updateGuest(Guest guest, Long id) {
        Guest existingGuest = guestRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Guest", "Id", id));
        existingGuest.setFirstName(guest.getFirstName());
        existingGuest.setLastName(guest.getLastName());
        existingGuest.setEmail(guest.getEmail());
        guestRepository.save(existingGuest);
        return existingGuest;
    }

    @Override
    public void deleteGuest(Long id) {
        Optional<Guest> guest = guestRepository.findById(id);
        if(guest.isPresent()){
        guestRepository.deleteById(id);
        } else{
            throw new ResourceNotFoundException("Id", "Id", id);
        }
    }
}
