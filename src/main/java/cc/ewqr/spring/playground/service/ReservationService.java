package cc.ewqr.spring.playground.service;

import cc.ewqr.spring.playground.domain.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> query(String courtName);
}
