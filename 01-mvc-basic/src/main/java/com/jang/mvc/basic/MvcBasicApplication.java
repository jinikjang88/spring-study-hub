package com.jang.mvc.basic;

import com.jang.mvc.basic.repository.MemoryMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class MvcBasicApplication {

	public static void main(String[] args) {
		log.info("=== MVC Basic Application 시작 ===");
		log.info("Java Version: {}", System.getProperty("java.version"));
		log.info("Spring Boot Version: 4.0");
		log.info("Virtual Threads: {}", Thread.currentThread().isVirtual() ? "Enabled" : "Disabled");

		SpringApplication.run(MvcBasicApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(MemoryMemberRepository memberRepository) {
		return args -> {
			log.info("=== 초기 데이터 생성 시작 ===");
			memberRepository.initData();

			long count = memberRepository.findAll().size();
			log.info("=== 초기 데이터 생성 완료 ({}명) ===", count);

			// Virtual Thread 정보 출력
			Thread thread = Thread.currentThread();
			log.info("InitData 실행 Thread - Name: {}, IsVirtual: {}",
				thread.getName(), thread.isVirtual());
		};
	}

}
