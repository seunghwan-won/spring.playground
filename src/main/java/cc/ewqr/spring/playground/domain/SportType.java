package cc.ewqr.spring.playground.domain;

import java.util.Objects;

public final class SportType {
    private final int id;
    private final String name;

    public SportType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "SportType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportType sportType = (SportType) o;
        return id == sportType.id &&
                Objects.equals(name, sportType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
