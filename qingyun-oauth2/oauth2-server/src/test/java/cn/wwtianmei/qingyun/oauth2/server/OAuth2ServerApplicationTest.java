package cn.wwtianmei.qingyun.oauth2.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class OAuth2ServerApplicationTest {

    public static void main(String[] args) {
        String secret = new BCryptPasswordEncoder().encode("admin888");
        System.out.println(secret);
    }
}