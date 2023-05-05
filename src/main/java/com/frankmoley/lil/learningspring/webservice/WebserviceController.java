package com.frankmoley.lil.learningspring.webservice;

import com.frankmoley.lil.learningspring.business.ReservationService;
import com.frankmoley.lil.learningspring.business.RoomReservation;
import com.frankmoley.lil.learningspring.data.Guest;
import com.frankmoley.lil.learningspring.data.Room;
import com.frankmoley.lil.learningspring.util.DateUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController // converts any method output into a JSON object
@RequestMapping("/api")
public class WebserviceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebserviceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @GetMapping(path = "/reservations")
    public List<RoomReservation> getReservations(
            @RequestParam(value = "date", required = false) String dateString) {
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @GetMapping(path="/guest-page")
    public List<Guest> getGuests() {
        return this.reservationService.getGuests();
    }

    @PostMapping(path = "/guest-page")
    public void addGuest(Guest guest) {
        this.reservationService.addGuest(guest);
    }

    @GetMapping(path = "rooms")
    public List<Room> getRooms() {
        return this.reservationService.getRooms();
    }
}
