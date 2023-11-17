package com.example.springboot.controller;

import com.example.springboot.model.HotelBooking;
import com.example.springboot.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel-booking")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/{id}")
    public HotelBooking getBookingById(@PathVariable Long id) {
        HotelBooking booking = BookingService.getBookingById(id);
        return booking;
        //return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PostMapping
    public HotelBooking createBooking(@RequestBody HotelBooking booking) {
        HotelBooking createdBooking = BookingService.createBooking(booking);
       // return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
        return createdBooking;
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelBooking> updateBooking(@PathVariable Long id, @RequestBody HotelBooking booking) {
        HotelBooking updatedBooking = BookingService.updateBooking(id, booking);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        BookingService.deleteBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public BookingService getBookingService() {
        return bookingService;
    }
}
