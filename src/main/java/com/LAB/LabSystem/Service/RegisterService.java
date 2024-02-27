package com.LAB.LabSystem.Service;

import com.LAB.LabSystem.Entitiy.LoginResponse;
import com.LAB.LabSystem.Entitiy.Register;
import com.LAB.LabSystem.Entitiy.UserLoginDTO;
import com.LAB.LabSystem.Repo.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {


    @Autowired
    private RegisterRepo Rrepo;
    @Autowired
    private RegisterServiceInterface registerServiceInterface;

    public void saveorUpdate(Register register) {

        Rrepo.save(register);
    }

    public Iterable<Register> listAll() {

        return this.Rrepo.findAll();
    }


    public void deleteUser(String Id) {

        Rrepo.deleteById(Id);
    }

    public Register getRegistertByID(String Id) {

        return Rrepo.findById(Id).get();
    }


    public LoginResponse LoggingUser(UserLoginDTO userLoginDTO) {
        return new LoginResponse(userLoginDTO);
    }
}
