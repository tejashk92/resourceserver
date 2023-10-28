package com.example.springoauth2.resourceserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/users")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public ResponseEntity<Principal> getUsers(final Principal principal) {
        return ResponseEntity.ok(principal);
    }
    
    @GetMapping("/admins")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Principal> getAdmins(final Principal principal) {
        return ResponseEntity.ok(principal);
    }
    
    @GetMapping("/guests")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_GUEST','ROLE_CLIENT')")
    public ResponseEntity<Principal> getGuests(final Principal principal) {
        return ResponseEntity.ok(principal);
    }
    
    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_GUEST','ROLE_CLIENT')")
    public ResponseEntity<Principal> userMe(final Principal principal) {
    	System.out.println(principal);
        return ResponseEntity.ok(principal);
    }
    
    @GetMapping("/public")
    public ResponseEntity<String> getPublic() {
        return ResponseEntity.ok("public api success");
    }

}
