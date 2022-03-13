package com.example.bookingmanagersystem.service;

import com.example.bookingmanagersystem.model.Booking;

import java.util.List;


public interface BookingService {
    int queryAvaliableRoomsByDate(String date);

    List<Booking> queryBookingsOfGuest(String guestName);
}
