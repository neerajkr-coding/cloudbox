package com.application.cloudbox.Entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "file")
public class File {
    private String fileId;
    private String fileName;
    private String contentType;
}
