package cc.ewqr.spring.playground.service;

import cc.ewqr.spring.playground.domain.Player;
import cc.ewqr.spring.playground.domain.Reservation;
import cc.ewqr.spring.playground.domain.SportType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReservationServiceImplement implements ReservationService {
      private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImplement.class);
    private static final SportType TENNIS = new SportType(1, "Tennis");
    private static final SportType SOCCER = new SportType(2, "Soccer");
    private static final List<Reservation> reservationList = new ArrayList<>();

    public ReservationServiceImplement() {
        reservationList.add(new Reservation("Tennis #1", LocalDate.of(2008, 1, 14), 16, new Player("Roger", "N/A"), TENNIS));
        reservationList.add(new Reservation("Tennis #2", LocalDate.of(2008, 1, 14), 20, new Player("James", "N/A"), TENNIS));
        logger.error("Service construct : " + reservationList);
    }

    @Override
    public List<Reservation> query(String courtName) {
        return this.reservationList.stream()
                .filter(reservation -> Objects.equals(reservation.getCourtName(), courtName))
                .collect(Collectors.toList());
    }
}
