package com.nasifproject.pcbuilder.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Optional<Admin> findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

}