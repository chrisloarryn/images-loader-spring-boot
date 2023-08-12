package com.chrisloarryn.uploader.controller;

// package com.example.demo.controller;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageUploadController {
	@Value("${gcp.bucket.name}")
	private String bucketName;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadImage(@RequestPart("image") MultipartFile image) {
		try {
			Storage storage = StorageOptions.getDefaultInstance().getService();
			BlobId blobId = BlobId.of(bucketName, image.getOriginalFilename());
			BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
			storage.create(blobInfo, image.getBytes());
			return ResponseEntity.ok("Image uploaded successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image upload failed.");
		}
	}
}
