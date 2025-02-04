package ru.geekbrain.notes.model;

package ru.geekbrain.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}