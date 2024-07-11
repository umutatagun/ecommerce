package com.umut.user.configuration;

import org.modelmapper.Condition;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    @Qualifier("notNullMapper")
    public ModelMapper mapper() {
        ModelMapper modelMapper = new ModelMapper();

        Condition<?, ?> propertyCondition = Conditions.isNotNull();
        modelMapper.getConfiguration().setPropertyCondition(propertyCondition);

        return modelMapper;
    }
}
