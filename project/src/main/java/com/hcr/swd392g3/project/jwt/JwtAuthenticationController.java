package com.hcr.swd392g3.project.jwt;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcr.swd392g3.project.dto.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcr.swd392g3.project.converter.PersonConverter;
import com.hcr.swd392g3.project.dto.PersonDTO;
import com.hcr.swd392g3.project.entity.Person;
import com.hcr.swd392g3.project.repository.PersonRepository;

/*
Expose a POST API /authenticate using the JwtAuthenticationController. The POST API gets username and password in the
body- Using Spring Authentication Manager we authenticate the username and password.If the credentials are valid,
a JWT token is created using the JWTTokenUtil and provided to the client.
 */
@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private PersonConverter personConverter;

    @Autowired
    private PersonRepository personRepo;


    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailDTO email) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        Person person = personRepo.findByEmail(email.getEmail());
        if (person != null) {
            message.setFrom(new InternetAddress("vuvthe163299@fpt.edu.vn"));
            String password = userDetailsService.GeneratingRandomAlphanumericString();
            person.setPassword(bcryptEncoder.encode(password));
            message.setRecipients(MimeMessage.RecipientType.TO, email.getEmail());
            message.setSubject("Security alert for " + person.getEmail());
            message.setContent("<p>Hello,</p>\n" +
                    "<p>We have received your request to reset the password for your account at Hola Cruisine Restaurant Website. We are happy to announce that we have found and below is the new password.</p>\n" +
                    "<p>Here is your new password: <strong>" + password + "</strong></p>\n" +
                    "<p>If you encounter any problems or have questions, please contact us via this email address or phone number <strong>0911017757</strong>.</p>\n" +
                    "<p>We appreciate your cooperation and are always here to support you.</p>\n" +
                    "<p>Best regards,</p>\n" +
                    "<p>Hola Cruise Restaurant</p>\n" +
                    "<p></p>\n" +
                    "<p>------------------------------</p>" +
                    "<p><em>This message is sent from the warning system. Please do not reply to this message.</em></p>\n", "text/html");
            mailSender.send(message);
            personRepo.save(person);
            return ResponseEntity.ok("Success");
        } else return ResponseEntity.badRequest().body("Not Found");
    }

    @RequestMapping(value = "/login")
    public ModelAndView loginpage() throws Exception {
        return new ModelAndView("loginpage");
    }

    @RequestMapping(value = "/forgotpassword")
    public ModelAndView forgotpasswordpage() throws Exception {
        return new ModelAndView("forgotpasswordpage");
    }

    @RequestMapping(value = "/register")
    public ModelAndView registerpage() throws Exception {
        return new ModelAndView("registerpage");
    }

    // return value is ResponseEntity<?> if return  return ResponseEntity.ok(new JwtResponse(token));
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody PersonDTO authenticationRequest, HttpServletResponse response) throws Exception {
        authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUserName());

        final String token = jwtTokenUtil.generateToken(userDetails);

//        // Create a new cookie with the same name as the one you want to remove
//        Cookie cookieToRestore = new Cookie("token",token); 
//        // Set the cookie's maxAge to 12 hours
//        cookieToRestore.setMaxAge( 12 * 60 * 60);
//        // Add the cookie to the response
//        response.addCookie(cookieToRestore);


        Person person = personRepo.findByUserName(authenticationRequest.getUserName());
        // Assuming you have a roles field in your JwtResponse
        JwtResponse jwtResponse = new JwtResponse(token);
        // Check the user's role and set the redirect URL accordingly
        if (person.getRole() == 1) {
            jwtResponse.setRedirectUrl("/hcr/manager/employeepage");
        } else if (person.getRole() == 2) {
            jwtResponse.setRedirectUrl("/hcr/employee/tablepage");
        } else {
            jwtResponse.setRedirectUrl("/hcr/home");
        }

        return ResponseEntity.ok(jwtResponse);
    }//        return ResponseEntity.ok(new JwtResponse(token));

    @GetMapping("/logout")
    public ModelAndView removeCookie(HttpServletResponse response, HttpServletRequest request) {
        return new ModelAndView("login");
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
