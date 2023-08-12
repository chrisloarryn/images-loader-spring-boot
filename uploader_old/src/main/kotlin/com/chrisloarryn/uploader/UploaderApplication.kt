package com.chrisloarryn.uploader

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UploaderApplication

fun main(args: Array<String>) {
	runApplication<UploaderApplication>(*args)
}
