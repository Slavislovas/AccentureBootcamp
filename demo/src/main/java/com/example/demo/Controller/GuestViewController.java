package com.example.demo.Controller;

import com.example.demo.Model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guests")
public class GuestViewController {

    private GuestController guestController;

    public GuestViewController(GuestController guestController) {
        this.guestController = guestController;
    }

    @GetMapping
    public String getGuests(Model model){
        model.addAttribute("guestList", guestController.getGuests());
        return "guests";
    }

    @GetMapping("/newGuest")
    public String getGuestCreationForm(){
        return "addGuest";
    }

    @PostMapping
    public String createGuest(Guest guest){
        guestController.saveGuest(guest);
        return "redirect:/guests";
    }

    @RequestMapping(value = "/deleteGuest/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteGuest(@PathVariable("id") Long id){
        guestController.deleteGuest(id);
        return "redirect:/guests";
    }
}
