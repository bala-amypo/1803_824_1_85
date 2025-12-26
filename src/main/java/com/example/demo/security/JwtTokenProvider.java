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
// }


package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret:mySecretKeyForJWTTokenGenerationThatIsLongEnoughForHS512Algorithm}")
    private String jwtSecret;

    @Value("${jwt.expiration:86400000}") // 24 hours in milliseconds
    private long jwtExpirationMs;

    /**
     * Generate JWT token from Authentication and User
     */
    public String generateToken(Authentication authentication, User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("userId", user.getId())
                .claim("role", user.getRole())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    /**
     * Get user email from JWT token
     */
    public String getEmailFromToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    /**
     * Get user ID from JWT token
     */
    public Long getUserIdFromToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.get("userId", Long.class);
    }

    /**
     * Get user role from JWT token
     */
    public String getRoleFromToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.get("role", String.class);
    }

    /**
     * Validate JWT token
     */
    public boolean validateToken(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}