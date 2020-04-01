package com.tistory.jeongpro;

import com.tistory.jeongpro.sort.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JeongproApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeongproApplication.class, args);
		MergeSort.mergeSort();
	}

}
