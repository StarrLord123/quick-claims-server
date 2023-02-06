package com.allstate.quickclaimsserver.service;

import com.allstate.quickclaimsserver.data.NoteRepository;
import com.allstate.quickclaimsserver.data.UserRepository;
import com.allstate.quickclaimsserver.domain.Note;
import com.allstate.quickclaimsserver.domain.User;
import com.allstate.quickclaimsserver.domain.UserRole;
import com.allstate.quickclaimsserver.data.ClaimRepository;
import com.allstate.quickclaimsserver.domain.Claim;
import com.allstate.quickclaimsserver.exceptions.ClaimNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

@Service
public class BootstrapService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserService userService;

    @PostConstruct
    public void createInitialUsers(){
        if (userRepository.count() == 0) {
            User user1 = new User("david", "David", "pass1", UserRole.USER);
            User user2 = new User("sarah", "Sarah", "pass1", UserRole.MANAGER);
            userService.save(user1);
            userService.save(user2);
        }
    }

    @PostConstruct
    public void setUpInitialData() {
        int numberOfClaims = claimRepository.findAll().size();
        if (numberOfClaims == 0) {
            Claim newClaim1 = new Claim(null, "101", LocalDate.of(2023,Month.JANUARY,01), "Property", "Mr", "John", "Smith", 100.00, "House burnt down", "No updates yet", "new claim", "1 Fake Street", "", "", "", "", "");
            Claim savedClaim1 = claimRepository.save(newClaim1);

            Claim newClaim2 = new Claim(null, "102", LocalDate.of(2023,Month.JANUARY,01), "Motor", "Mr", "Arnold", "Smithy", 100.00, "Car on fire", "Claim has been assessed", "assessed", "", "Ford", "Fiesta", "2000", "", "");
            Claim savedClaim2 = claimRepository.save(newClaim2);

            Claim newClaim3 = new Claim(null, "103", LocalDate.of(2023,Month.JANUARY,01), "Pet", "Ms", "Barbara", "Johnson", 100.00, "Pet hurt leg", "This claim has been rejected", "rejected", "", "", "", "", "Dog", "Westie");
            Claim savedClaim3 = claimRepository.save(newClaim3);

            Claim newClaim4 = new Claim(null, "104", LocalDate.of(2023,Month.JANUARY,01), "Property", "Mr", "Donald", "Williams", 100.00, "House burnt down", "Awaiting payment", "accepted - awaiting payment", "2 Fake Street", "", "", "", "", "");
            Claim savedClaim4 = claimRepository.save(newClaim4);

            Claim newClaim5 = new Claim(null, "105", LocalDate.of(2023,Month.JANUARY,01), "Motor", "Ms", "Emma", "Brown", 100.00, "Car broke down", "Paid", "accepted - paid", "", "Volkswagen", "Polo", "2010", "", "");
            Claim savedClaim5 = claimRepository.save(newClaim5);

            Claim newClaim6 = new Claim(null, "106", LocalDate.of(2023,Month.JANUARY,01), "Pet", "Ms", "Francine", "Jones", 100.00, "Pet hurt leg", "This claim has been rejected", "rejected", "", "", "", "", "Cat", "Tabby");
            Claim savedClaim6 = claimRepository.save(newClaim6);

            Claim newClaim7 = new Claim(null, "107", LocalDate.of(2023,Month.JANUARY,01), "Property", "Mr", "Harold", "Garcia", 1000.00, "House burnt down", "This claim is high value", "high value", "3 Fake Street", "", "", "", "", "");
            Claim savedClaim7 = claimRepository.save(newClaim7);

            Claim newClaim8 = new Claim(null, "108", LocalDate.of(2023,Month.JANUARY,01), "Motor", "Ms", "Jane", "Miller", 100.00, "Car broke down", "This claim has been assessed", "assessed", "", "Volkswagen", "Golf", "2020", "", "");
            Claim savedClaim8 = claimRepository.save(newClaim8);

            Claim newClaim9 = new Claim(null, "109", LocalDate.of(2023,Month.JANUARY,01), "Pet", "Mr", "Keith", "David", 100.00, "Pet hurt leg", "Just awaiting payment", "accepted - awaiting payment", "", "", "", "", "Dog", "Labradoodle");
            Claim savedClaim9 = claimRepository.save(newClaim9);

            Claim newClaim10 = new Claim(null, "110", LocalDate.of(2023,Month.JANUARY,01), "Property", "Ms", "Laura", "Stephens", 100.00, "House burnt down", "This claim has been paid", "accepted - paid", "4 Fake Street", "", "", "", "", "");
            Claim savedClaim10 = claimRepository.save(newClaim10);
        }
    }

    @PostConstruct
    public void createInitialNotes() throws ClaimNotFoundException {
        int numberOfNotes = noteRepository.findAll().size();
        if (numberOfNotes == 0) {
            Claim claim1 = claimRepository.findById(1).orElseThrow(() -> new ClaimNotFoundException("Claim not found"));
            Claim claim3 = claimRepository.findById(3).orElseThrow(() -> new ClaimNotFoundException("Claim not found"));
            Note note1 = new Note(null, "Completed", LocalDate.of(2023,Month.JANUARY,01), "This is note 1 for Claim 1", 1);
            Note note2 = new Note(null, "Not Completed", LocalDate.of(2023,Month.JANUARY,02), "This is note 2 for Claim 1", 1);
            Note note3 = new Note(null, "Not Completed", LocalDate.of(2023,Month.JANUARY,02), "This is note 1 for Claim 3", 3);
            noteRepository.save(note1);
            noteRepository.save(note2);
            noteRepository.save(note3);
        }
    }

}