package com.example.bookingmanagersystem.service;

import com.example.bookingmanagersystem.model.Booking;
import com.example.bookingmanagersystem.model.Guest;
import com.example.bookingmanagersystem.model.Hotel;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    @Override
    public int queryAvaliableRoomsByDate(String date) {
        return Hotel.getAvaliableRoomsByDate(date);
    }

    @Override
    public List<Booking> queryBookingsOfGuest(String guestId) {
        Guest guest = Hotel.getGuestById(guestId);
        return guest.getBookings();
    }
}
