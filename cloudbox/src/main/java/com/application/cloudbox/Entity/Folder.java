package com.application.cloudbox.Entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "folder")
public class Folder {
    private String folderId;
    private String folderName;
}
