package com.github.FranciscoLopes8.cooperari.model;

import jakarta.persistence.*;


@Entity
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doc_id")
    private Document document;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Permission permission;

    public Long getId() {
        return id;
    }

    public Document getDocument() {
        return document;
    }

    public User getUser() {
        return user;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
