package cc.ewqr.spring.playground;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class UserResource {
    @NotNull
    private final String name;
    @NotNull
    private final String email;
    private final Long userId;

    public UserResource(Long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public UserResource(
            @JsonProperty("name") String name,
            @JsonProperty("email") String email) {
        this.userId = 42L;
        this.name = name;
        this.email = email;

    }

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserResource{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResource that = (UserResource) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, userId);
    }
}
