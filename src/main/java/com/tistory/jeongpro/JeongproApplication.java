package com.tistory.jeongpro;

import com.tistory.jeongpro.sort.BubbleSort;
import com.tistory.jeongpro.sort.InsertSort;
import com.tistory.jeongpro.sort.SelectionSort;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JeongproApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeongproApplication.class, args);
		BubbleSort.bubbleSort();
	}

}
