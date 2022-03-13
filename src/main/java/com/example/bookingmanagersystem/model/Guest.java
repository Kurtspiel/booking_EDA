package com.example.bookingmanagersystem.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Guest {
    private String id;
    private String name;
    private List<Booking> bookings;

    public void addBooking(Booking booking){
        if (bookings==null){
            bookings = new ArrayList<>();
        }
        bookings.add(booking);
    }
}
