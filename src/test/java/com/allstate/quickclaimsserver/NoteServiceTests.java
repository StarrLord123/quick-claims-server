package com.allstate.quickclaimsserver;

import com.allstate.quickclaimsserver.data.ClaimRepository;
import com.allstate.quickclaimsserver.data.NoteRepository;
import com.allstate.quickclaimsserver.data.UserRepository;
import com.allstate.quickclaimsserver.domain.Claim;
import com.allstate.quickclaimsserver.domain.Note;
import com.allstate.quickclaimsserver.exceptions.ClaimNotFoundException;
import com.allstate.quickclaimsserver.service.BootstrapService;
import com.allstate.quickclaimsserver.service.ClaimService;
import com.allstate.quickclaimsserver.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class NoteServiceTests {

    @Autowired
    private ClaimService claimService;

    @MockBean
    private ClaimRepository claimRepository;

    @MockBean
    private BootstrapService bootstrapService;

    @Autowired
    private NoteService noteService;

    @MockBean
    private NoteRepository noteRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testGetAllNotesForClaim() throws ClaimNotFoundException {

        Claim claim1 = new Claim(1, "101", LocalDate.of(2023, Month.JANUARY,01), "Property", "Mr", "John", "Smith", 100.00, "House burnt down", "New Claim", "Open", "1 Fake Street", "", "", "", "", "");
        claimRepository.save(claim1);

        Note note1 = new Note(null, "Completed", LocalDate.of(2023,Month.JANUARY,01), "This is a note", 1);
        Note note2 = new Note(null, "Completed", LocalDate.of(2023,Month.JANUARY,01), "This is a note", 1);

        noteRepository.save(note1);
        noteRepository.save(note2);

        List<Note> notes = noteService.getAllNotesForClaim(1);
        assertEquals(2, notes.size());
    }
}