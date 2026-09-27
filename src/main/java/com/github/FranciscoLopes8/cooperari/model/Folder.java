package com.github.FranciscoLopes8.cooperari.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Folder")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL)
    private List<Document> documents;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
