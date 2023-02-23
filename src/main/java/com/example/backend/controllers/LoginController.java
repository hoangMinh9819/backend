package com.example.backend.controllers;

import com.example.backend.dto.LoginRequestDTO;
import com.example.backend.entities.Account;
import com.example.backend.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("")
public class LoginController {
    @Autowired
    private AccountService accountService;
//    @Autowired
//    private LoginService loginService;
//    @PostMapping("/signup")
//    public ResponseEntity<APIResponse> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO) {
//        APIResponse apiResponse = loginService.signUp(signUpRequestDTO);
//        return ResponseEntity
//                .status(apiResponse.getStatus())
//                .body(apiResponse);
//    }
//    @PostMapping("/login")
//    public ResponseEntity<APIResponse> login(@RequestBody LoginRequestDTO loginRequestDTO) {
//        APIResponse apiResponse = loginService.login(loginRequestDTO);
//        return ResponseEntity
//                .status(apiResponse.getStatus())
//                .body(apiResponse);
//    }

        @PostMapping("/loginAdmin")
    public ResponseEntity<Account> getAdminLogin(@RequestBody LoginRequestDTO loginRequestDTO) {
        return new ResponseEntity<Account>(accountService.getAdminLogin(loginRequestDTO), HttpStatus.OK);
    }
    @PostMapping("/loginUser")
    public ResponseEntity<Account> getUserLogin(@RequestBody LoginRequestDTO loginRequestDTO) {
        return new ResponseEntity<Account>(accountService.getUserLogin(loginRequestDTO), HttpStatus.OK);
    }
}
