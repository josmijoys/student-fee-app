package com.cc.aasignment.studentfee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class StudentFeeApplication {

	public static void main(String[] args) throws UnknownHostException {

        final Logger log = LoggerFactory.getLogger(StudentFeeApplication.class);
        //SpringApplication.run(ImageUploadApplication.class, args);

        SpringApplication app = new SpringApplication(StudentFeeApplication.class);
        Environment env = app.run(args).getEnvironment();

        log.info("\n----------------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:{}\n\t" +
                "External: \thttp://{}:{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            env.getProperty("server.port"),
            InetAddress.getLocalHost().getHostAddress(),
            env.getProperty("server.port"));
	}

}
