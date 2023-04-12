package com.example.authorization.repositories;

import com.example.authorization.Authorities;
import com.example.authorization.model.User;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private static ConcurrentHashMap<User, List<Authorities>> usersMap;

    static {
        User user1 = new User("Biba", "pass1");
        User user2 = new User("Boba", "pass2");
        User user3 = new User("Buba", "pass3");
        usersMap = new ConcurrentHashMap<>();
        usersMap.put(user1, List.of(Authorities.READ));
        usersMap.put(user2, List.of(Authorities.READ, Authorities.WRITE));
        usersMap.put(user3, List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
    }


    public List<Authorities> getUserAuthorities(String user, String password) {
        // Ищем пользователя в мапе
        User currentUser = usersMap.keySet().stream()
                .filter(u -> u.getName().equals(user) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
        // Проверяем, если пользователь не найден
        if (currentUser == null) {
            return List.of();
        }
        // Возвращаем список разрешений для найденного пользователя
        return usersMap.get(currentUser);
    }
}
