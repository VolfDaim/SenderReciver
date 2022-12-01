package com.example.receiver.User;

import java.util.Optional;

public interface UserInterface {
    Optional<UserModel> findUserById(String id);

    void deleteUserById(String id);

}
