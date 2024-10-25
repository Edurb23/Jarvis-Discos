package com.example.discos_jarvis_app.modal;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "albums")
public class Album {

    @Id
    private String id;

    @NotBlank(message = "O nome do álbum é obrigatório.")
    private String nomeAlbum;

    @NotBlank(message = "A data de lançamento é obrigatória.")
    private String dataLancamento;

    @NotBlank(message = "O gênero é obrigatório.")
    private String genero;

    private Artista artista;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Artista {

        @NotBlank(message = "O nome do artista é obrigatório.")
        private String nomeArtista;
    }
}