package com.example.demo.Service;

import com.example.demo.Model.Guest;

import java.util.List;

public interface GuestService {
    Guest saveGuest(Guest guest);
    List<Guest> getGuests();
    Guest getGuestById(Long id);
    Guest updateGuest(Guest guest, Long id);
    void deleteGuest(Long id);
}
