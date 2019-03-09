package com.zola.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ZolaApiInvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZolaApiInvoiceApplication.class, args);
	}

}
