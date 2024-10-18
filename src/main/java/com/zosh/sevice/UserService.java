package com.zosh.sevice;

import com.zosh.exception.UserException;
import com.zosh.model.User;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;


public interface UserService {

    public User findUserById(Long userId)throws UserException;
    public User findUserProfileByJwt(String jwt) throws UserException;
}
