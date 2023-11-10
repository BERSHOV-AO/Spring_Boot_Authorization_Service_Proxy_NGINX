package ru.netology.springbootproxynginx.service;

import org.springframework.stereotype.Service;
import ru.netology.springbootproxynginx.domain.User;
import ru.netology.springbootproxynginx.enums.Authorities;
import ru.netology.springbootproxynginx.exception.InvalidCredentials;
import ru.netology.springbootproxynginx.exception.UnauthorizedUser;
import ru.netology.springbootproxynginx.repository.UserRepository;


import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getUser()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getUser(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
