package com.zane.bookadmin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookadminApplication.class)
public class HttpTest {
    @Autowired
    private PasswordEncoder encoder;
    @Test
    public void testEncode() {
        System.out.println(encoder.matches("123456", "$2a$10$7YmZ43ZBWXwadIGE64pTYO2JnCA6tp5qda/2x91dU3LX67sl/n69a"));

    }

    @Test
    public void testCal() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -3);
        for (int i = 0; i < 3; i++) {
            c.add(Calendar.MONTH, +1);
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
            System.out.println(format.format(c.getTime()));
        }
    }
}
