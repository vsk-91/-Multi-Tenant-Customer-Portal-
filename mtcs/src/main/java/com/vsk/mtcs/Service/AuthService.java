package com.vsk.mtcs.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vsk.mtcs.Security.JwtUtil;
import com.vsk.mtcs.dto.LoginRequest;
import com.vsk.mtcs.dto.RegisterRequest;
import com.vsk.mtcs.entity.Tenant;
import com.vsk.mtcs.entity.User;
import com.vsk.mtcs.repository.TenantRepository;
import com.vsk.mtcs.repository.UserRepository;

@Service
public class AuthService {
    
    private final TenantRepository tenantRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthService(TenantRepository tenantRepository,
                       UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       JwtUtil jwtUtil) {
        this.tenantRepository = tenantRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public String register(RegisterRequest request) {

        Tenant tenant = new Tenant(request.getTenantName());
        tenantRepository.save(tenant);

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setTenant(tenant);

        userRepository.save(user);

        return "User registered successfully";
    }

    public String login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail()).get();

        return jwtUtil.generateToken(user.getEmail());
    }
}
