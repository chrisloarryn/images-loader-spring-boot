package com.example.imageuploader

import com.google.cloud.storage.BlobId
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.Storage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.IOException

@Service
class ImageService @Autowired constructor(private val storage: Storage) {
    fun uploadImage(file: MultipartFile, bucketName: String): String {
        val blobId = BlobId.of(bucketName, file.originalFilename)
        val blobInfo = BlobInfo.newBuilder(blobId).build()

        try {
            storage.create(blobInfo, file.inputStream.readBytes())
            return "Image uploaded successfully"
        } catch (e: IOException) {
            throw RuntimeException("Failed to upload image", e)
        }
    }
}
