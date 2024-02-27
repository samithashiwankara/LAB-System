package com.LAB.LabSystem.Controller;

import com.LAB.LabSystem.Entitiy.LoginResponse;
import com.LAB.LabSystem.Entitiy.Register;
import com.LAB.LabSystem.Entitiy.UserLoginDTO;
import com.LAB.LabSystem.Service.RegisterService;
import com.LAB.LabSystem.Service.RegisterServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/Register")
public class RegisterControlle {

    @Autowired
    private RegisterService registerService;
//    @Autowired
//    private RegisterServiceInterface registerServiceInterface;

    @PostMapping(value = "/save")
    private String saveUsers(@RequestBody Register register) {

        registerService.saveorUpdate(register);
        return register.getEmail();
    }

    @GetMapping(value = "/getall")
    public Iterable<Register> getUsers() {
        return registerService.listAll();
    }

    @PutMapping(value = "/edit/{Id}")
    private Register update(@RequestBody Register register, @PathVariable(name = "Id") String id) {
        register.get_id();
        registerService.saveorUpdate(register);
        return register;
    }

    @DeleteMapping("/delete/{ID}")
    private void deleteUser(@PathVariable("Id") String id) {
        registerService.deleteUser(id);
    }

    @RequestMapping("/search/{id}")
    private Register getUser(@PathVariable(name = "Id") String id) {
        return registerService.getRegistertByID(id);
    }

}
