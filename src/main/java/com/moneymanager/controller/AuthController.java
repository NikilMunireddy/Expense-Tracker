package com.moneymanager.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import com.moneymanager.Constants;
import com.moneymanager.model.User;
import com.moneymanager.service.AuthServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/users")
public class AuthController {

  @Autowired
  AuthServiceInterface authService;

  // @Route    POST /api/users/login
  // @Desc     Login user 
  // @Access   Public

  @PostMapping("/login")
  public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> userMap) {
    String email = (String) userMap.get("email");
    String password = (String) userMap.get("password");
    User user = authService.validateUser(email, password);
    return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
  }


  // @Route    POST /api/users/register
  // @Desc     Register new user 
  // @Access   Public
  
  @PostMapping("/register")
  public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap) {
    String firstName = (String) userMap.get("firstName");
    String lastName = (String) userMap.get("lastName");
    String email = (String) userMap.get("email");
    String avatarUrl =(String) userMap.get("avatarUrl");
    String password = (String) userMap.get("password");
    String preferedCurrency =(String) userMap.get("preferedCurrency");
    User user = authService.registerUser(firstName, lastName, email, avatarUrl, password, preferedCurrency);
    return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
  }


  private Map<String, String> generateJWTToken(User user) {
    long timestamp = System.currentTimeMillis();

    String token = Jwts.builder()
        .signWith(SignatureAlgorithm.HS512, DatatypeConverter.parseBase64Binary(Constants.API_SECRET_KEY))
        .setIssuedAt(new Date(timestamp)).setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
        .claim("email", user.getEmail()).claim("firstName", user.getFirstName())
        .claim("lastName", user.getLastName()).claim("avatarUrl", user.getAvatarUrl())
        .claim("password", user.getPassword()).claim("preferedCurrency", user.getPreferedCurrency())
        .compact();
    Map<String, String> map = new HashMap<>();
    map.put("token", token);
    return map;
  }
  
}