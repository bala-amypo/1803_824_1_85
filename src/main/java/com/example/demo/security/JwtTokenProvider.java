// package com.example.demo.security;

// import com.example.demo.entity.User;
// import io.jsonwebtoken.*;
// import org.springframework.security.core.Authentication;
// import org.springframework.stereotype.Component;
// import java.util.Date;

// @Component
// public class JwtTokenProvider {
//     private final String jwtSecret = "SecretKeyToGenJWTsSecretKeyToGenJWTsSecretKeyToGenJWTs";
//     private final int jwtExpirationInMs = 3600000;

//     public String generateToken(Authentication authentication, User user) {
//         return Jwts.builder()
//                 .setSubject(user.getEmail())
//                .claim("id", user.getId())
//                 .claim("role", user.getRole())
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
//                 .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
//     }

//     public String getEmailFromToken(String token) {
//        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
//     }

//     public Long getUserIdFromToken(String token) {
//         return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().get("id", Long.class);
//     }

//     public boolean validateToken(String token) {
//         try { Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token); return true; } 
//         catch (Exception ex) { return false; }
//     }
//}

// package com.example.demo.security;

// import com.example.demo.entity.User;
// import io.jsonwebtoken.*;
// import org.springframework.security.core.Authentication;
// import org.springframework.stereotype.Component;
// import java.util.Date;

// @Component
// public class JwtTokenProvider {
//     private final String secret = "926TaS679139AY56R9812A5CD1234567890ABCDEF1234567890ABCDEF";

//     public String generateToken(Authentication auth, User user) {
//         return Jwts.builder()
//                 .setSubject(user.getEmail())
//                 .claim("id", user.getId())
//                 .claim("role", user.getRole())
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + 86400000))
//                 .signWith(SignatureAlgorithm.HS512, secret)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try { Jwts.parser().setSigningKey(secret).parseClaimsJws(token); return true; } 
//         catch (Exception e) { return false; }
//     }

//     public String getEmailFromToken(String token) {
//         return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
//     }

//     public Long getUserIdFromToken(String token) {
//         return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("id", Long.class);
//     }
//}


// package com.example.demo.security;

// import com.example.demo.entity.User;
// import io.jsonwebtoken.*;
// import org.springframework.security.core.Authentication;
// import org.springframework.stereotype.Component;
// import java.util.Date;

// @Component
// public class JwtTokenProvider {

//     private final String jwtSecret = "926TaS679139AY56R9812A5CD1234567890ABCDEF1234567890ABCDEF";
//     private final int jwtExpirationInMs = 3600000;

//     public String generateToken(Authentication authentication, User user) {
//         return Jwts.builder()
//                 .setSubject(user.getEmail())
//                 .claim("id", user.getId())
//                 .claim("role", user.getRole())
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
//                 .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                 .compact();
//     }

//     public String getEmailFromToken(String token) {
//         return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
//     }

//     public Long getUserIdFromToken(String token) {
//         return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().get("id", Long.class);
//     }

//     public boolean validateToken(String authToken) {
//         try {
//             Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
//             return true;
//         } catch (Exception ex) {
//             return false;
//         }
//     }
// }

package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final String secret = "926TaS679139AY56R9812A5CD1234567890ABCDEF1234567890ABCDEF";

    public String generateToken(Authentication auth, User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("id", user.getId())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try { Jwts.parser().setSigningKey(secret).parseClaimsJws(token); return true; } 
        catch (Exception e) { return false; }
    }

    public String getEmailFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public Long getUserIdFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("id", Long.class);
    }
}
