package com.example.springboot.service;

import com.example.springboot.model.HotelBooking;
import com.example.springboot.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    private static final List<HotelBooking> bookings = new ArrayList<>();
    private static Long bookingId = 0L;


    public static HotelBooking getBookingById(Long id) {
        Optional<HotelBooking> booking = bookings.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();

        return booking.orElse(null);
    }

    public static HotelBooking createBooking(HotelBooking booking) {
        booking.setId(++bookingId);
        bookings.add(booking);
        System.out.println("Booking Created Successfully!");
        return booking;
    }

    public static HotelBooking updateBooking(Long id, HotelBooking booking) {
        Optional<HotelBooking> bookingToUpdate = bookings.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();

        if (bookingToUpdate.isPresent()) {
            HotelBooking updatedBooking = bookingToUpdate.get();
            updatedBooking.setGuestName(booking.getGuestName());
            updatedBooking.setCheckInDate(booking.getCheckInDate());
            updatedBooking.setCheckOutDate(booking.getCheckOutDate());
            updatedBooking.setNumberOfGuests(booking.getNumberOfGuests());
            updatedBooking.setRoomType(booking.getRoomType());
            return updatedBooking;
        } else {
            return null;
        }
    }

    public static void deleteBooking(Long id) {
        bookings.removeIf(b -> b.getId().equals(id));
    }
}
