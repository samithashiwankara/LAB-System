package com.LAB.LabSystem.Entitiy;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="RegisterDetails")
public class Register {

    @Id
    private String _id;
    @NotEmpty(message = "Username must not be empty")
    private String UserName;
    @NotEmpty(message = "Email must not be empty")
    private String Email;
    @NotEmpty(message = "Password must not be empty")
    private String Password;
    @NotEmpty(message = "Mobile must not be empty")
    private String Mobile;

    public Register(String _id, String userName, String email, String password, String mobile) {
        this._id = _id;
        this.UserName = userName;
        this.Email = email;
        this.Password = password;
        this.Mobile = mobile;
    }

    public Register() {
    }

    public Register(String email, String encode) {
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public  String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    @Override
    public String toString() {
        return "Register{" +
                "_id='" + _id + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Mobile='" + Mobile + '\'' +
                '}';
    }
}
