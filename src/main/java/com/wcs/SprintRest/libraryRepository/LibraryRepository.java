package com.wcs.SprintRest.libraryRepository;

import com.wcs.SprintRest.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
    List<Library> findByTitleContainingOrContentContaining(String searchTerm, String searchTerm1);
}
