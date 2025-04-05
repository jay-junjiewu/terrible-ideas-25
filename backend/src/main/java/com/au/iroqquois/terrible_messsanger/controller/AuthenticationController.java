package com.au.iroqquois.terrible_messsanger.controller;

import com.au.iroqquois.terrible_messsanger.core.router.InternalRouter;
import com.au.iroqquois.terrible_messsanger.payload.ApiResponse;
import com.au.iroqquois.terrible_messsanger.payload.auth.JWTRequest;
import com.au.iroqquois.terrible_messsanger.payload.auth.JWTResponse;
import com.au.iroqquois.terrible_messsanger.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping(InternalRouter.Authentication.BASE_PATH)
    public ApiResponse<JWTResponse> createAuthenticationToken(@RequestBody JWTRequest jwtRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return ApiResponse.of(new JWTResponse(jwt));
    }
}
