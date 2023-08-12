package com.example.imageuploader

import com.google.cloud.storage.Storage
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.springframework.web.multipart.MultipartFile
import java.io.InputStream

class ImageServiceTest {

    @Mock
    private lateinit var storage: Storage

    private lateinit var imageService: ImageService

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
        imageService = ImageService(storage)
    }

    @Test
    fun testUploadImage() {
        val fileMock = object : MultipartFile {
            override fun getName(): String = "test.jpg"
            override fun getOriginalFilename(): String = "test.jpg"
            override fun getContentType(): String? = "image/jpeg"
            override fun isEmpty(): Boolean = false
            override fun getSize(): Long = 123
            override fun getBytes(): ByteArray = byteArrayOf(1, 2, 3)
            override fun getInputStream(): InputStream = javaClass.classLoader.getResourceAsStream("test.jpg")
            override fun transferTo(dest: java.io.File) {}
        }

        val bucketName = "test-bucket"
        val blobId = BlobId.of(bucketName, "test.jpg")

        `when`(storage.create(any(), any<ByteArray>())).thenReturn(blobId)

        val result = imageService.uploadImage(fileMock, bucketName)

        assertEquals("Image uploaded successfully", result)
    }
}
