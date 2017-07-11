package by.specificgroup.kirill.authentication;

import by.specificgroup.kirill.hashing.HashData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * Created by user1 on 7/10/2017.
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {


    public JWTLoginFilter(String url, AuthenticationManager authenticationManager){
        super(new AntPathRequestMatcher(url, "POST"));
        setAuthenticationManager(authenticationManager);
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        AccountCredentials credentials = new ObjectMapper()
                .readValue(request.getInputStream(), AccountCredentials.class);
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentials.getEmail(),
                        HashData.getHashByData(credentials.getPassword()),
                        Collections.emptyList()
                )
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        TokenAuthenticationService.addAuthentication(response, authResult.getName());
    }
}
