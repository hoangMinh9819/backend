//package com.example.backend.services;
//
//import com.example.backend.common.APIResponse;
//import com.example.backend.dto.LoginRequestDTO;
//import com.example.backend.dto.SignUpRequestDTO;
//import com.example.backend.entities.Account;
//import com.example.backend.repositories.AccountRepository;
//import com.example.backend.utils.JwtUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LoginService {
//    @Autowired
//    private AccountRepository accountRepository;
//    @Autowired
//    private JwtUtils jwtUtils;
//    public APIResponse signUp(SignUpRequestDTO signUpRequestDTO) {
//        APIResponse apiResponse = new APIResponse();
//        //validation
//
//        // dto to entity
//        Account accountEntity = new Account();
//        accountEntity.setUsername(signUpRequestDTO.getUsername());
//        accountEntity.setPassword(signUpRequestDTO.getPassword());
//        accountEntity.setDob(signUpRequestDTO.getDob());
//        accountEntity.setEmail(signUpRequestDTO.getEmail());
//        accountEntity.setGender(signUpRequestDTO.getGender());
//        accountEntity.setFirstName(signUpRequestDTO.getFirstName());
//        accountEntity.setLastName(signUpRequestDTO.getLastName());
//        accountEntity.setImage(signUpRequestDTO.getImage());
//        accountEntity.setPhone(signUpRequestDTO.getPhone());
//        accountEntity.setRole("User");
//        accountEntity.setStatus("Active");
//        // store entity
//        accountEntity = accountRepository.save(accountEntity);
//        apiResponse.setData(accountEntity);
//        //return
//        return apiResponse;
//    }
//
//    public APIResponse login(LoginRequestDTO loginRequestDTO) {
//        APIResponse apiResponse = new APIResponse();
//        //validation
//        //verify user exist with given username and password
//        Account account = accountRepository.findOneByUserNameAndPassword(loginRequestDTO.getUsername(),loginRequestDTO.getPassword());
//        //response
//        if(account == null ){
//            apiResponse.setData("User login failed");
//            return apiResponse;
//        }
//        //generate jwt
//        String token = jwtUtils.generateJwt(account);
//        apiResponse.setData(token);
//        return apiResponse;
//    }
//}
