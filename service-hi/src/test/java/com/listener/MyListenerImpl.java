package com.listener;

public class MyListenerImpl  implements MyEvent {

    public void handle(MyEvent myEvent) {
        if(myEvent.getEvent().equals("CREATE_EVENT")){
            System.out.println("myListener get a create event!");
        }
        else if(myEvent.getEvent().equals("DELETE_EVENT")){

        }
    }


    @Override
    public String getEvent() {
        return null;
    }
}
