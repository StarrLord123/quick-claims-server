package com.allstate.quickclaimsserver.control;

import com.allstate.quickclaimsserver.domain.Note;
import com.allstate.quickclaimsserver.exceptions.ClaimNotFoundException;
import com.allstate.quickclaimsserver.exceptions.NoteNotFoundException;
import com.allstate.quickclaimsserver.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/claim/{claimId}/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> getAllNotesForClaim(@PathVariable Integer claimId) throws ClaimNotFoundException {
        return noteService.getAllNotesForClaim(claimId);
    }

    @GetMapping("/{id}")
    public Note findById (@PathVariable Integer id) throws NoteNotFoundException {
        return noteService.getById(id);
    }

    @PostMapping
    public Note saveNewNote(@RequestBody Note note) {
        System.out.println(note);
        return noteService.saveNote(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Integer id, @RequestBody HashMap<String, Object> fields) {
        System.out.println(id);
        System.out.println(fields);
        return noteService.updateNote(id, fields);
    }
}
