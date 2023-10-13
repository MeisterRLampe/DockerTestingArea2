package com.meisterlampe.dockertestingarea2.serviceImpl;
import com.meisterlampe.dockertestingarea2.services.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.function.Function;

@Service
public class JWTServiceImpl implements JWTService {



    public String generateToken(UserDetails userDetails){

        TimeZone timeZone = TimeZone.getTimeZone("Europe/Berlin");
        TimeZone.setDefault(timeZone);

        Date now = new Date();
        Date expirationDate = new Date(now.getTime() +1000*60*24);

        String token = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expirationDate)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
        System.out.println("Generierter Token "+token );
        System.out.println("Millis Token: "+expirationDate);
        return token;

    }



    public String generateRefreshToken(Map<String,Object> extraClaims , UserDetails userDetails){

        TimeZone timeZone = TimeZone.getTimeZone("Europe/Berlin");
        TimeZone.setDefault(timeZone);

        Date now = new Date();
        Date refreshExpirationDate = new Date(now.getTime() + 604800000);


        String refresh= Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(refreshExpirationDate)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

        System.out.println("Generierter RefreshToken: " +refresh);
        System.out.println("Millis Refresh:" + refreshExpirationDate );

        return refresh;
    }


    public String extractUserName(String token){
        return extractClaim(token, Claims::getSubject);
    }


    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers){
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
    }


    private Key getSignInKey(){
        byte[] key = Decoders.BASE64.decode("413F4428472B4B6250655368566D5970337336763979244226452948404D6351");
        return Keys.hmacShaKeyFor(key);
    }

    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }



    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
}
