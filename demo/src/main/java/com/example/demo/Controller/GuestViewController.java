package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
