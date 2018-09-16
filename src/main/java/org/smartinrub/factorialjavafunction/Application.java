package org.smartinrub.factorialjavafunction;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionScan;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@FunctionScan
@SpringBootApplication
public class Application {

    @Bean
    public Function<Long, String> factorial() {
        return value -> Long.toString(getFactorial(value));
    }

    private long getFactorial(long number) {
        if (number == 1) {
            return number;
        }
        return getFactorial(number - 1) * number;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}