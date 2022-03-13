package com.example.bookingmanagersystem.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Data
public class Hotel {
    public static final int ROOM_TOTAL = 100;
    private static LinkedHashMap<String, Object[]> bookingsByDate;
    private static HashMap<String, Guest> guests;

    public static int getAvaliableRoomsByDate(String date) {
        return ROOM_TOTAL - (Integer) bookingsByDate.get(date)[0];
    }

    public static boolean addBooking(Booking booking) {
        Object[] numberAndBookings = bookingsByDate.get(booking.getDate());
        if (numberAndBookings == null) {
            numberAndBookings = new Object[2];

            // store room number booked by guests
            numberAndBookings[0] = 0;

            // store bookings
            numberAndBookings[1] = new ArrayList<>();
        }

        List<Booking> bookings = (List<Booking>) numberAndBookings[1];

        // iterate bookings to make sure no duplicate bookings
        for (Booking existBooking : bookings) {
            if (existBooking.getId().equals(booking.getId())) {
                return false;
            }
        }
        bookings.add(booking);
        numberAndBookings[0] = (Integer) numberAndBookings[0] + booking.getRoomNumber();
        return true;
    }

    public static boolean addGuest(Guest guest) {
        if (guests == null) {
            guests = new HashMap<>();
        }
        guests.put(guest.getId(),guest);
        return true;
    }

    public static Guest getGuestById(String guestId){
        return guests.get(guestId);
    }
}
