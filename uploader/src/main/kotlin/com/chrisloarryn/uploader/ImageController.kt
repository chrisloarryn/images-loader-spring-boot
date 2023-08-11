package com.example.imageuploader

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class ImageController @Autowired constructor(private val imageService: ImageService) {

    @PostMapping("/upload")
    fun uploadImage(@RequestParam("file") file: MultipartFile): String {
        val bucketName = "your-gcs-bucket-name"
        return imageService.uploadImage(file, bucketName)
    }
}
