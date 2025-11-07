package com.application.cloudbox.Service;

import com.application.cloudbox.Client.R2Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.Response;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.http.SdkHttpResponse;
import software.amazon.awssdk.services.s3.model.*;

import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@Service
public class FileService {

    private final R2Client r2Client;

    @Autowired
    public FileService(R2Client r2Client) {
        this.r2Client = r2Client;
    }

    public ResponseEntity<String> uploadFileToR2(MultipartFile file) {
        try {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket("test-bucket")
                    .key("img1")
                    .contentType(file.getContentType())
                    .build();

            PutObjectResponse putObjectResponse = r2Client.get_instance().putObject(putObjectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
            return ok("SUCCESS");
        } catch (Exception e) {
            return ok("FAILED : " + e.getMessage());
        }
    }

    public ResponseEntity<String> deleteFileFromR2() {
        try {
            DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                    .bucket("test-bucket")
                    .key("img1")
                    .build();

            DeleteObjectResponse deleteObjectResponse = r2Client.get_instance().deleteObject(deleteObjectRequest);
            return ok("SUCCESS");
        } catch (Exception e) {
            return ok("FAILED : " + e.getMessage());
        }
    }

    public ResponseEntity<String> getFileFromBucket() {
        try {
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket("test-bucket")
                    .key("img1")
                    .build();

            GetObjectResponse getObjectResponse = r2Client.get_instance().getObject(getObjectRequest).response();

            return ok(getObjectResponse.contentType());
        } catch (Exception e) {
            return ok("FAILED : " + e.getMessage());
        }
    }

}
