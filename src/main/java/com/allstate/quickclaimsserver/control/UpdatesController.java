package com.allstate.quickclaimsserver.control;

import com.allstate.quickclaimsserver.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/updates")
public class UpdatesController {

    @Autowired
    private ClaimService claimService;

    @GetMapping()
    public List<String> getAllUpdates() {
        return claimService.getAllUpdates();
    }

}