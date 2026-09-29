package com.github.FranciscoLopes8.cooperari.repository;

import com.github.FranciscoLopes8.cooperari.model.Document;

import java.util.List;

public interface DocumentRepository {
    List<Document> findByFolderId(Long folderId);
}
