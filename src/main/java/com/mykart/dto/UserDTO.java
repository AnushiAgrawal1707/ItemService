package com.mykart.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


/**
 *
 *
 */
@Getter
@Setter
public class UserDTO  {


        private int userId;
        private String firstName;
        private String lastName;
        private String address;
        private String mobileNo;
        private String email;
        private String password;
        private int cartId;






}
