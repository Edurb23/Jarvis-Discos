package com.example.discos_jarvis_app.repository;

import com.example.discos_jarvis_app.modal.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, String> {
}
