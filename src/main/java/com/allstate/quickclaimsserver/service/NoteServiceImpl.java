package com.allstate.quickclaimsserver.service;

import com.allstate.quickclaimsserver.data.ClaimRepository;
import com.allstate.quickclaimsserver.data.NoteRepository;
import com.allstate.quickclaimsserver.domain.Claim;
import com.allstate.quickclaimsserver.domain.Note;
import com.allstate.quickclaimsserver.exceptions.ClaimNotFoundException;
import com.allstate.quickclaimsserver.exceptions.NoteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public List<Note> getAllNotes() {
        List<Note> notes = noteRepository.findAll();
        System.out.println("There were " + notes.size() + " notes found");
        return notes;
    }

    @Override
    public List<Note> getAllNotesForClaim(Integer claimId) throws ClaimNotFoundException {
        Optional<Claim> optionalClaim = claimRepository.findById(claimId);
        if (optionalClaim.isPresent()) {
            return noteRepository.findAllByClaimId(claimId);
        }
        else {
            throw new ClaimNotFoundException("There is no claim with id " + claimId);
        }
    }

    @Override
    public Note getById(Integer id) throws NoteNotFoundException {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            return optionalNote.get();
        }
        else {
            throw new NoteNotFoundException("There is no note with id " + id);
        }
    }

    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Integer id, Map<String, Object> fields) {
        Note note = noteRepository.findById(id).get();

        if (fields.containsKey("completed")) {
            note.setCompleted(fields.get("completed").toString());
        }

        if (fields.containsKey("date")) {
            note.setDate(LocalDate.parse(fields.get("date").toString()));
        }

        if (fields.containsKey("note")) {
            note.setNote(fields.get("note").toString());
        }

        return noteRepository.save(note);
    }
}
