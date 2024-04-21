package ru.kata.spring.boot_security.demo.password_encoder;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MyNoPassworEncoder implements PasswordEncoder {

    private static final PasswordEncoder INSTANCE = new MyNoPassworEncoder();

    public MyNoPassworEncoder() {
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }

    /**
     * Get the singleton {MyNoPassworEncoder}.
     */
    public static PasswordEncoder getInstance() {
        return INSTANCE;
    }

}
