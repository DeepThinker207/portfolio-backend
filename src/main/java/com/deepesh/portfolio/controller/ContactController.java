package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.entity.ContactMessage;
import com.deepesh.portfolio.repository.ContactMessageRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    private final ContactMessageRepository contactRepository;

    public ContactController(ContactMessageRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping
    public ContactMessage sendMessage(@Valid @RequestBody ContactMessage contactMessage) {
        return contactRepository.save(contactMessage);
    }

    // GET: To see all the messages
    @GetMapping
    public List<ContactMessage> getAllMessages() {
        return contactRepository.findAll();
    }


}