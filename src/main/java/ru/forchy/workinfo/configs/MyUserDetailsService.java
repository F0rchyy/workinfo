package ru.forchy.workinfo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.forchy.workinfo.entity.User;
import ru.forchy.workinfo.repository.UserRepo;

import java.util.Optional;

/**
 * Класс, реализующий интерфейс UserDetailsService
 * Необходим для загрузки данных пользователя по логину из БД
 */

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);

        return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь \"" + username + "\" не найден"));
    }

    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByEmail(email);
        return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с email \"" + email + "\" не найден"));
    }
}
