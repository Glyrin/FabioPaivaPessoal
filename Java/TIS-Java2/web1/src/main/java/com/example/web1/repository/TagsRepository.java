package com.example.web1.repository;

import com.example.web1.model.Tag;
import com.example.web1.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagsRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByTutoriais(Tutorial tutorial);
}
