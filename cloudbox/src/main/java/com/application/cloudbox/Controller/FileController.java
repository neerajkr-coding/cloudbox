package com.application.cloudbox.Controller;

import com.application.cloudbox.Client.R2Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.Bucket;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {

    private final R2Client r2Client;

    @Autowired
    public FileController(R2Client r2Client) {
        this.r2Client = r2Client;
    }

    @GetMapping(path = "test", produces = "application/json")
    private List<String> test() {

        List<Bucket> buckets= r2Client.get_instance().listBuckets().buckets();

        List<String> bucketNames = new ArrayList<>();

        for(Bucket b : buckets) {
            bucketNames.add(b.name());
        }

        return bucketNames;
    }

    @PostMapping("upload-file")
    public String uploadFile(
            @RequestParam("file") MultipartFile file
            ) {
        MultipartFile temp = file;
        return "done";
    }

}
