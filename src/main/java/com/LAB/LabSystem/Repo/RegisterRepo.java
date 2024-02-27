package com.LAB.LabSystem.Repo;

import com.LAB.LabSystem.Entitiy.LoginResponse;
import com.LAB.LabSystem.Entitiy.Register;
import com.LAB.LabSystem.Entitiy.UserLoginDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepo extends MongoRepository<Register,String> {

    Optional<Register> findOneByEmailAndPassword(String email, String encodedPassword);

    Register findByEmail(String email);


}
