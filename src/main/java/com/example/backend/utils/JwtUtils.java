//package com.example.backend.utils;
//
//import com.example.backend.entities.Account;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtUtils {
//    private static String secret = "This_is_secret";
//    private static long expiryDuration = 60 * 60;
//    public String generateJwt(Account account){
//        long milliTime = System.currentTimeMillis();
//        long expiryTime= milliTime + expiryDuration * 1000;
//        Date issueAt = new Date();
//        Date expiryAt = new Date(expiryTime);
//        //claims
//        Claims claims = Jwts.claims().setIssuer(account.getId().toString())
//                .setIssuedAt(issueAt)
//                .setExpiration(expiryAt);
//        //generate jwt using claims
//        return Jwts.builder().setClaims(claims).compact();
//    }
//}
