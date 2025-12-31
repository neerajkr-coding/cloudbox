package com.application.cloudbox.Entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "user")
public class User {
    private String email;
    private List<File> files;
    private List<Folder> folders;
}
