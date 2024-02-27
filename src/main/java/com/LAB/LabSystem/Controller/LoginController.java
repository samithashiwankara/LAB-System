package com.LAB.LabSystem.Controller;

import com.LAB.LabSystem.Entitiy.LoginResponse;
import com.LAB.LabSystem.Entitiy.UserLoginDTO;
import com.LAB.LabSystem.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/Users")
public class LoginController {

    @Autowired
    private RegisterService registerService;


    @PostMapping(path = "/login")
    public ResponseEntity<?> LogingUser(@RequestBody UserLoginDTO UserLoginDTO)
    {
        LoginResponse loginResponse = registerService.LoggingUser(UserLoginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}
