package cn.net.szwx.sell;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SellApplicationTests {

	@Test
	void contextLoads() {
		String sha1pwd = DigestUtils.sha1Hex("123456");
		System.out.println(sha1pwd);
	}

}
