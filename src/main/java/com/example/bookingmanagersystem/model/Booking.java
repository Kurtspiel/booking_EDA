package com.example.bookingmanagersystem.model;

import lombok.Data;


@Data
public class Booking {
    private String id;
    private String name;
    private int roomNumber;
    private String date;
}
