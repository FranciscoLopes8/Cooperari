package com.github.FranciscoLopes8.cooperari.repository;

import com.github.FranciscoLopes8.cooperari.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    List<Folder> findByOwnerId(Long ownerId);
}
