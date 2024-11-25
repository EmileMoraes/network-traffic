package com.network.traffic.app.interfaces.rest;

import com.network.traffic.app.application.command.NetworkTrafficCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.network.traffic.app")
public class NetworkTrafficApplication implements CommandLineRunner {

	@Autowired
	private NetworkTrafficCommandHandler networkTrafficCommandHandler;

	public static void main(String[] args) {
		SpringApplication.run(NetworkTrafficApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		networkTrafficCommandHandler.handler();
	}
}
