package cc.ewqr.spring.playground.domain;

import java.util.Objects;

public final class Player {
    private final String name;
    private final String phone;

    public Player(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(phone, player.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }
}
