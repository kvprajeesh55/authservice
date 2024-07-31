package com.rakbank.security.controller;

import com.rakbank.security.auth.AuthenticationRequest;
import com.rakbank.security.auth.AuthenticationResponse;
import com.rakbank.security.auth.AuthenticationService;
import com.rakbank.security.auth.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/v1/register")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/v1/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/v1/refresh-token")
  public void refreshToken(HttpServletRequest request,
                          HttpServletResponse response ) throws IOException {
    service.refreshToken(request, response);
  }


}
