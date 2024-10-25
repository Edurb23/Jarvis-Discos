package com.example.discos_jarvis_app.controller;

import com.example.discos_jarvis_app.modal.Album;
import com.example.discos_jarvis_app.repository.AlbumRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;


    @GetMapping
    public String listAlbum(Model model){
        List<Album> albums = albumRepository.findAll();
        model.addAttribute("albums", albums);
        return "albums/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("album", new Album());
        return "albums/create";
    }


    @PostMapping("/create")
    public String saveAlbum(@Valid @ModelAttribute Album album, BindingResult result) {
        if (result.hasErrors()) {
            return "albums/create";
        }
        albumRepository.save(album);
        return "redirect:/albums";
    }



    @PostMapping("/edit/{id}")
    public String updateAlbum(@PathVariable("id") String id, @Valid @ModelAttribute Album album, BindingResult result) {
        if (result.hasErrors()) {
            return "albums/edit";
        }
        album.setId(id);
        albumRepository.save(album);
        return "redirect:/albums";
    }


    @GetMapping("/delete/{id}")
    public String deleteAlbum(@PathVariable("id") String id) {
        albumRepository.deleteById(id);
        return "redirect:/albums";
    }





}
