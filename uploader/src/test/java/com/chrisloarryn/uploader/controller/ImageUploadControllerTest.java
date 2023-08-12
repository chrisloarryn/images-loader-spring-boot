package com.chrisloarryn.uploader.controller;

// package com.example.demo.test;

import com.chrisloarryn.uploader.controller.ImageUploadController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ImageUploadController.class)
public class ImageUploadControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testImageUpload() throws Exception {
		MockMultipartFile image = new MockMultipartFile("image", "test.jpg", "image/jpeg", "test image".getBytes());
		mockMvc.perform(MockMvcRequestBuilders.multipart("/upload").file(image))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
