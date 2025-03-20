package com.hcr.swd392g3.project.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hcr.swd392g3.project.entity.Person;
import com.hcr.swd392g3.project.repository.PersonRepository;

/*
JWTUserDetailsService implements the Spring Security UserDetailsService interface.
It overrides the loadUserByUsername for fetching user details from the database using the username.
The Spring Security Authentication Manager calls this method for getting the user details from the database
when authenticating the user details provided by the user. Here we are getting the user details from a hardcoded
User List. In the next tutorial we will be adding the DAO implementation for fetching User Details from the Database.
Also the password for a user is stored in encrypted format using BCrypt.
Previously we have seen Spring Boot Security - Password Encoding Using Bcrypt.
Here using the Online Bcrypt Generator you can generate the Bcrypt for a password.
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    //set role and get loadUserByUsername
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person user = personRepo.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (user.getRole() == 1) authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
        else if (user.getRole() == 2) authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
        else if (user.getRole() == 3) authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
//                new ArrayList<>()
                authorities);
    }

    public String GeneratingRandomAlphanumericString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    public Person save(Person user) {
        Person newUser = new Person();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setPersonID(user.getPersonID());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setAddress(user.getAddress());
        newUser.setRole(user.getRole());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setStatus(user.isStatus());
        newUser.setGender(user.isGender());
        newUser.setEmail(user.getEmail());
        return personRepo.save(newUser);
    }
}
