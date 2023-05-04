package com.jerome.learningspring.data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "RESERVATION_ID")
    private long reservationID;
    /*
    From https://stackoverflow.com/questions/42692082/jpa-biginteger-is-beeing-mapped-to-decimal-for-mysql:
        "Recommended Java mapping for SQL BIGINT = long"
     */
    @Column(name = "ROOM_ID")
    private long roomID;

    @Column(name = "GUEST_ID")
    private long guestID;

    @Column(name = "RES_DATE")
    private Date date;

    public long getReservationID() {
        return reservationID;
    }

    public void setReservationID(long reservationID) {
        this.reservationID = reservationID;
    }

    public long getRoomID() {
        return roomID;
    }

    public void setRoomID(long roomID) {
        this.roomID = roomID;
    }

    public long getGuestID() {
        return guestID;
    }

    public void setGuestID(long guestID) {
        this.guestID = guestID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationID=" + reservationID +
                ", roomID=" + roomID +
                ", guestID=" + guestID +
                ", date=" + date +
                '}';
    }
}
