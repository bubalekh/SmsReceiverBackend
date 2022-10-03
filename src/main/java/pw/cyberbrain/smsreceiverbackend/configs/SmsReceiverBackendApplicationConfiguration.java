package pw.cyberbrain.smsreceiverbackend.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("pw.cyberbrain.smsreceiverbackend")
@EnableWebMvc
public class SmsReceiverBackendApplicationConfiguration implements WebMvcConfigurer {
}
