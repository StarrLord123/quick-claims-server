package com.allstate.quickclaimsserver.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String completed;
    private LocalDate date;
    private String note;

    private Integer claimId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getClaimId() {
        return claimId;
    }

    public void setClaimId(Integer claimId) {
        this.claimId = claimId;
    }

    public Note(Integer id, String completed, LocalDate date, String note, Integer claimId) {
        this.id = id;
        this.completed = completed;
        this.date = date;
        this.note = note;
        this.claimId = claimId;
    }

    public Note() {
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", completed='" + completed + '\'' +
                ", date=" + date +
                ", note='" + note + '\'' +
                ", claimId=" + claimId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note1 = (Note) o;
        return Objects.equals(id, note1.id) && Objects.equals(completed, note1.completed) && Objects.equals(date, note1.date) && Objects.equals(note, note1.note) && Objects.equals(claimId, note1.claimId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, completed, date, note, claimId);
    }
}
