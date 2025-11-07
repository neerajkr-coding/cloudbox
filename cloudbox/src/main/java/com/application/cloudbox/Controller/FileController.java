package com.application.cloudbox.Controller;

import com.application.cloudbox.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.Response;
import software.amazon.awssdk.http.SdkHttpResponse;

@RestController
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

//    @GetMapping(path = "test", produces = "application/json")
//    private List<String> test() {
//        List<Bucket> buckets= r2Client.get_instance().listBuckets().buckets();
//
//        System.out.println(UUID.randomUUID());
//
//        List<String> bucketNames = new ArrayList<>();
//        for(Bucket b : buckets) {
//            bucketNames.add(b.name());
//        }
//
//        return bucketNames;
//    }

    @PostMapping("upload-file")
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file
            ) {
        return fileService.uploadFileToR2(file);
    }

    @PostMapping("delete-file")
    public ResponseEntity<String> deleteFile(

    ) {
        return fileService.deleteFileFromR2();
    }

    @GetMapping("get-file")
    public ResponseEntity<String> geteFile(

    ) {
        return fileService.getFileFromBucket();
    }

}
