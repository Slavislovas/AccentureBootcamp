package com.example.demo.Controller;

import com.example.demo.Model.Hotel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hotels")
public class HotelViewController {
    private HotelController hotelController;

    public HotelViewController(HotelController hotelController) {
        this.hotelController = hotelController;
    }

    @GetMapping
    public String getHotels(Model model){
        model.addAttribute("hotelList", hotelController.getHotels());
        return "hotels";
    }

    @GetMapping("/newHotel")
    public String getHotelCreationForm(){
        return "addHotel";
    }

    @PostMapping
    public String saveHotel(Hotel hotel){
        hotelController.saveHotel(hotel);
        return "redirect:/hotels";
    }

    @RequestMapping(value = "/deleteHotel/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteHotel(@PathVariable("id") Long id){
        hotelController.deleteHotel(id);
        return "redirect:/hotels";
    }


}
