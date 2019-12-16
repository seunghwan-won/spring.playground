package cc.ewqr.spring.playground.controller;

import cc.ewqr.spring.playground.domain.Reservation;
import cc.ewqr.spring.playground.service.ReservationService;
import cc.ewqr.spring.playground.service.ReservationServiceImplement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(path = "/reservationQuery")
public class ReservationQueryController {
    private static final Logger logger = LoggerFactory.getLogger(ReservationQueryController.class);
    private final ReservationService reservationService;

    public ReservationQueryController() {
        reservationService = new ReservationServiceImplement();
    }

    @GetMapping
    public void setupForm() {

    }

    @PostMapping
    public String submitForm(@RequestParam("courtName") String courtName, Model model) {
        List<Reservation> reservations = Collections.emptyList();
        if (courtName != null) {
            reservations = reservationService.query(courtName);
        }
        model.addAttribute("reservation", reservations);
        return "reservationQuery";
    }
}
