package com.wcs.SprintRest.controller;

import com.wcs.SprintRest.libraryRepository.LibraryRepository;
import com.wcs.SprintRest.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class LibraryController {

    @Autowired
    LibraryRepository libraryRepository;

    @GetMapping("/libraries")
    public List<Library> index(){
        return libraryRepository.findAll();
    }

    @PostMapping("/libraries/search")
    public List<Library> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return libraryRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping("/libraries")
    public Library create(@RequestBody Library library){
        return libraryRepository.save(library);
    }

    @PutMapping("/libraries/{id}")
    public Library update(@PathVariable Long id, @RequestBody Library library){
        Library libraryToUpdate = libraryRepository.findById(id).get();
        libraryToUpdate.setTitle(library.getTitle());
        libraryToUpdate.setAuthor(library.getAuthor());
        libraryToUpdate.setDescription(library.getDescription());
        return libraryRepository.save(libraryToUpdate);
    }

    @DeleteMapping("libraries/{id}")
    public boolean delete(@PathVariable Long id){
        libraryRepository.deleteById(id);
        return true;
    }
}
