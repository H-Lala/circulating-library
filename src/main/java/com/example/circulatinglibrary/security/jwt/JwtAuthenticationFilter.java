package com.example.circulatinglibrary.security.jwt;

import com.example.circulatinglibrary.security.UserDetailService;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Security;
import java.util.Optional;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private  final JwtTokenService tokenService;
    private final UserDetailService  userDetailService;

    public JwtAuthenticationFilter(JwtTokenService tokenService, UserDetailService userDetailService) {
        this.tokenService = tokenService;
        this.userDetailService = userDetailService;
    }
    private Optional<String> extractTokenFromRequest(HttpServletRequest request){
        final String auth_header = request.getHeader(Const.AUTH_HEADER);
        if (StringUtils.hasText(auth_header)
        &&
        auth_header.startsWith(Const.AUTH_BEARER)){
           return Optional.of(auth_header.substring(Const.AUTH_BEARER.length()));
        }
        String par_token = request.getParameter(Const.AUTH_TOKEN);
        if(!StringUtils.isEmpty(par_token)){
            return  Optional.of(par_token.substring(Const.AUTH_BEARER.length()));
        }
        return Optional.empty();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
     try {
         extractTokenFromRequest(httpServletRequest)
                 .flatMap(tokenService::tokenToClaim)
                 .map(tokenService::extractUserIdFromClaims)
                 .map(userDetailService::loadUserById)
                 .map(ud-> new UsernamePasswordAuthenticationToken(ud, null,ud.getAuthorities()))
                  .ifPresent(auht->{
                      auht.setDetails(new WebAuthenticationDetailsSource()
                      .buildDetails(httpServletRequest));
                      SecurityContextHolder.getContext().setAuthentication(auht);
                  });
         filterChain.doFilter(httpServletRequest,httpServletResponse);
     }catch (Exception ex){
         logger.error("Could not set user authentication in security context ",ex);
     }
    }
}
