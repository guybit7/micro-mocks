package com.msi.micromocks.configurations;

import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.msi.micromocks.dto.mapping.converter.ByteArrayToJsonConverter;
import com.msi.micromocks.dto.mapping.converter.MockItemControllerDTOToMockItem;
import com.msi.micromocks.dto.mapping.converter.MockItemToMockItemControllerDTO;

@Configuration
public class DozerConfig {

    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(List.of("classpath:dozerBeanMapping.xml"));
        dozerBeanMapper.setCustomConverters(
        		Arrays.asList(
        				new ByteArrayToJsonConverter(), 
        				new MockItemToMockItemControllerDTO(),
        				new MockItemControllerDTOToMockItem())
        		);
        return dozerBeanMapper;
    }
    
}
