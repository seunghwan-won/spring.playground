package cc.ewqr.spring.playground;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public interface RegisterUseCase {
//    private final List<User> userList;
//
//    public RegisterUseCase() {
//        this.userList = new ArrayList<>();
//    }
//
//    public Long registerUser(User user, boolean sendWelcomeEmail) {
//        if (sendWelcomeEmail)
//            userList.add(user);
//        return (long) userList.indexOf(user);
//    }
    Long registerUser(User user, boolean sendWelcomeEmail);
}
