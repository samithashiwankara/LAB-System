package com.LAB.LabSystem.Service;

import com.LAB.LabSystem.Entitiy.LoginResponse;
import com.LAB.LabSystem.Entitiy.Register;
import com.LAB.LabSystem.Entitiy.UserLoginDTO;

public interface RegisterServiceInterface {
//    String addUsers(Register register);
//    LoginResponse loginUser(UserLoginDTO userLoginDTO);

    String addUsers(Register register1);

    //     Register register;
    LoginResponse LOGIN_RESPONSE(UserLoginDTO userLoginDTO);

    UserLoginDTO LoginUser(UserLoginDTO userLoginDTO);
}
