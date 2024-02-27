package com.LAB.LabSystem.Entitiy;

import com.LAB.LabSystem.Entitiy.LoginResponse;
import com.LAB.LabSystem.Entitiy.Register;
import com.LAB.LabSystem.Entitiy.UserLoginDTO;
import com.LAB.LabSystem.Repo.RegisterRepo;
import com.LAB.LabSystem.Service.RegisterServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginImpl implements RegisterServiceInterface {
    @Autowired
    private RegisterRepo Rrepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUsers(Register register) {
        Register register1 = new Register(
                register.getEmail(),
                this.passwordEncoder.encode(register.getPassword())
        );
        Rrepo.save(register1);
        return register1.getEmail();
    }

//    Register register;
    @Override
    public LoginResponse loginUser(UserLoginDTO userLoginDTO) {
        String msg = "";
        Register register2 = Rrepo.findByEmail(userLoginDTO.getEmail());
        if (register2 != null) {
            String password = userLoginDTO.getPassword();
            String encodedPassword = register2.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Register> employee = Rrepo.findOneByEmailAndPassword(userLoginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }

    @Override
    public UserLoginDTO LoginUser(UserLoginDTO userLoginDTO) {
        return LoginUser(userLoginDTO);
    }


}
