package cn.net.szwx.sell;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

@SpringBootApplication(
		exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@MapperScan("cn.net.szwx.sell.dao")
@EnableAsync
@EnableTransactionManagement
public class SellApplication {
	private final static Logger log = LoggerFactory.getLogger(SellApplication.class);

	@Bean
	public DefaultKaptcha captchaProducer() {
		DefaultKaptcha captchaProducer = new DefaultKaptcha();
		Properties properties = new Properties();
		// 是否有边框
		properties.setProperty(Constants.KAPTCHA_BORDER, "no");
		// 边框颜色
		properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, "red");
		// 验证码字体颜色
		properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "blue");
		// 验证码字体大小
		properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "38");
		// 验证码字体
		properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "宋体,楷体,微软雅黑");
		// 验证码个数
		properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
		// 生成验证码内容范围
		properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, "0123456789");
		// 验证码宽度
		properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, "130");
		// 验证码高度
		properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, "38");
		properties.setProperty(Constants.KAPTCHA_SESSION_CONFIG_KEY, "code");
		Config config = new Config(properties);
		captchaProducer.setConfig(config);
		return captchaProducer;
	}

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
