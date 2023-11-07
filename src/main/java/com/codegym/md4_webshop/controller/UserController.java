package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.jwt.JwtTokenProvider;
import com.codegym.md4_webshop.model.ERole;
import com.codegym.md4_webshop.model.Role;
import com.codegym.md4_webshop.model.User;
import com.codegym.md4_webshop.payload.request.LoginRequest;
import com.codegym.md4_webshop.payload.request.SignupRequest;
import com.codegym.md4_webshop.payload.response.JwtResponse;
import com.codegym.md4_webshop.payload.response.MessageResponse;
import com.codegym.md4_webshop.model.CustomUserDetails;
import com.codegym.md4_webshop.service.impl.RoleService;
import com.codegym.md4_webshop.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder encoder;

    public UserController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @GetMapping
    public ResponseEntity<Iterable<User>> list() {
        List<User> userList = (List<User>) userService.findAll();
        if (userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<Iterable<User>> showAllUserByAdmin() {
        Iterable<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        if (userService.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: User is already"));
        }
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(encoder.encode(signupRequest.getPassword()));
        user.setEmail(signupRequest.getEmail());
        user.setPhone(signupRequest.getPhone());
        Set<String> strRole = signupRequest.getListRole();
        Set<Role> listRole = new HashSet<>();
        if (strRole == null) {
            //User quyền mặc định
            Role userRole = roleService.findByRoleName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found"));
            listRole.add(userRole);
        } else {
            strRole.forEach(role -> {
                if (role.equals("admin")) {
                    Role adminRole = roleService.findByRoleName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                    listRole.add(adminRole);
                }
                if (role.equals("moderator")) {
                    Role modRole = roleService.findByRoleName(ERole.ROLE_MODERATOR)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                    listRole.add(modRole);
                }
               else  {
                    Role userRole = roleService.findByRoleName(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                    listRole.add(userRole);
                }
            });
        }
        user.setAdvertisementSet(listRole);
        userService.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        String jwt = jwtTokenProvider.generateToken(authentication);
        List<String> listRole = customUserDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(
                jwt,
                customUserDetails.getUserId(),
                customUserDetails.getUsername(),
                customUserDetails.getEmail(),
                customUserDetails.getPhone(),
                listRole)
        );
    }
    @PutMapping("/edit")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        Optional<User> imageOptional = userService.findById(user.getId());
        if (!imageOptional.isPresent() ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (user.getAddress() == null) {
            user.setAddress(imageOptional.get().getAddress());
        }
        if (user.getImage() == null) {
            user.setImage(imageOptional.get().getImage());
        }
        if (user.getBirthday() == null) {
            user.setBirthday(null);
        }
        if (user.getEmail() == null) {
            user.setEmail(imageOptional.get().getEmail());
        }
        if (user.getGender() == 0) {
            user.setGender(imageOptional.get().getGender());
        }
        if (user.getName()== null) {
            user.setName(imageOptional.get().getName());

        }
        if (user.getPhone()== null) {
            user.setPhone(imageOptional.get().getPhone());
        }
        if (user.getUsername() == null) {
            user.setUsername(imageOptional.get().getUsername());
        }
        if (user.getAdvertisementSet().isEmpty()) {
            user.setAdvertisementSet(imageOptional.get().getAdvertisementSet());
        }
        if (user.getPassword() == null) {
            user.setPassword(imageOptional.get().getPassword());
        }
        else  {
            user.setPassword(encoder.encode(user.getPassword()));
        }
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        Optional<User> imageOptional = userService.findById(id);
        return imageOptional.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
