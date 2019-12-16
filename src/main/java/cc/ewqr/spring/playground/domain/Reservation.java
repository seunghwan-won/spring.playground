package cc.ewqr.spring.playground.domain;

import java.time.LocalDate;
import java.util.Objects;

public final class Reservation {
    private final String courtName;
    private final LocalDate date;
    private final int hour;
    private final Player player;
    private final SportType sportType;

    public Reservation(String courtName, LocalDate date, int hour, Player player, SportType sportType) {
        this.courtName = courtName;
        this.date = date;
        this.hour = hour;
        this.player = player;
        this.sportType = sportType;
    }

    public String getCourtName() {
        return courtName;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public Player getPlayer() {
        return player;
    }

    public SportType getSportType() {
        return sportType;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "courtName='" + courtName + '\'' +
                ", date=" + date +
                ", hour=" + hour +
                ", player=" + player +
                ", sportType=" + sportType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return hour == that.hour &&
                Objects.equals(courtName, that.courtName) &&
                Objects.equals(date, that.date) &&
                Objects.equals(player, that.player) &&
                Objects.equals(sportType, that.sportType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courtName, date, hour, player, sportType);
    }
}
