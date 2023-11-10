package ru.netology.springbootproxynginx.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootproxynginx.enums.Authorities;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> listAuthorities = new ArrayList<>();
        Map<String, String> mapUsers = new HashMap<>();
        mapUsers.put("Alex", "qwerty");
        mapUsers.put("Alena", "2323");
        mapUsers.put("Svetlana", "7777");

        if (mapUsers.containsKey(user) && mapUsers.get(user).equals(password)) {
            listAuthorities.add(Authorities.WRITE);
//            listAuthorities.add(Authorities.DELETE);
//            listAuthorities.add(Authorities.READ);
        }
        return listAuthorities;
    }
}

