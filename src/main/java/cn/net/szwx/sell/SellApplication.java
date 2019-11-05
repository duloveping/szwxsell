package cn.net.szwx.sell;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication(
		exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@MapperScan("cn.net.szwx.sell.dao")
@EnableAsync
@EnableTransactionManagement
public class SellApplication {
	private final static Logger log = LoggerFactory.getLogger(SellApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext application = SpringApplication.run(SellApplication.class, args);

		Environment env = application.getEnvironment();
		String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.error(e.getMessage(), e);
		}
		String port = env.getProperty("server.port");
		String path = env.getProperty("server.servlet.context-path");
		log.info("服务器的IP地址：{}", ip);
		log.info("服务器的端口号：{}", port);
		log.info("服务器的上下文：{}", path);
	}

}
