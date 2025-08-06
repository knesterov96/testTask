package com.nka.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Tickets {
    @SerializedName("tickets")
    private List<Ticket> ticketList;

    public Tickets() {
    }

    public Tickets(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tickets tickets = (Tickets) o;
        return Objects.equals(getTicketList(), tickets.getTicketList());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getTicketList());
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "ticketList=" + ticketList +
                '}';
    }
}
