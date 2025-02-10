package com.saludSystem.services.modules.configuration.User;

import com.saludSystem.dtos.configuration.User.UserDTO;
import com.saludSystem.services.PaginatedService;

import java.util.List;

public interface UserService extends PaginatedService {

    List<UserDTO> getUserList();

}
