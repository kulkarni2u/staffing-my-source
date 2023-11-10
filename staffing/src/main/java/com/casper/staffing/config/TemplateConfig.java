package com.casper.staffing.config;

import com.casper.staffing.model.Template;
import com.casper.staffing.repository.TemplateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.IntStream;

@Configuration
public class TemplateConfig {
    private static final int TOTAL = 100;
    @Bean
    CommandLineRunner templateRunner(final TemplateRepository repository) {
        return args -> {
            repository.deleteAll();

            final List<Template> templates = IntStream
                    .range(1, TOTAL)
                    .mapToObj(value -> {
                        Template template = new Template();
                        template.setName("Template-" + value);

                        return template;
                    })
                    .toList();

            templates.forEach(repository::save);
        };
    }
}
