package cc.ewqr.spring.playground.repository;

import cc.ewqr.spring.playground.model.User;
import org.springframework.stereotype.Component;

@Component
public interface RegisterUseCase {
    Long registerUser(User user, boolean sendWelcomeEmail);
}
