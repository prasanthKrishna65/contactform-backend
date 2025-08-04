

package com.example.contactform.controller;

import com.example.contactform.model.Contact;
import com.example.contactform.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Replace * with your frontend domain for production
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/contact")
    public ResponseEntity<?> saveContact(@Valid @RequestBody Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            String errorMsg = result.getFieldErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(errorMsg);
        }
        contactRepository.save(contact);
        return ResponseEntity.ok("Contact received successfully!");
    }
}

