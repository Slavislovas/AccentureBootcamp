package com.example.demo.Controller;

import com.example.demo.Model.Guest;
import com.example.demo.Service.GuestService;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {
    private GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping
    public ResponseEntity<Guest> saveGuest(@RequestBody Guest guest){
        return new ResponseEntity<Guest>(guestService.saveGuest(guest), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Guest> getGuests(){
        return guestService.getGuests();
    }

    @GetMapping("{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable("id") Long id){
        return new ResponseEntity<Guest>(guestService.getGuestById(id), HttpStatus.FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable("id") Long id, @RequestBody Guest guest){
        return new ResponseEntity<Guest>(guestService.updateGuest(guest, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGuest(@PathVariable("id") Long id){
        guestService.deleteGuest(id);
        return new ResponseEntity<String>("Guest deleted", HttpStatus.OK);
    }
}
