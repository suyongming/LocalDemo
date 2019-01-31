package com.listener;

public interface MyEvent {
    public static final String createEvent = "CREATE_EVENT";
    public static final String deleteEvent = "DELETE_EVENT";
    public static final String updateEvent = "UPDATE_EVENT";


    public String getEvent();
}
