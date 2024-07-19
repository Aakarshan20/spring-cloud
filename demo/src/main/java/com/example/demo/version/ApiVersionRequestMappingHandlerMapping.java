package com.example.demo.version;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

public class ApiVersionRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo mappingInfo = super.getMappingForMethod(method, handlerType);
        if (mappingInfo != null) {
            ApiVersion apiVersion = AnnotatedElementUtils.findMergedAnnotation(handlerType, ApiVersion.class);
            if (apiVersion != null) {
                String versionPrefix = "v" + apiVersion.value();
                PatternsRequestCondition patternsCondition = new PatternsRequestCondition(versionPrefix).combine(mappingInfo.getPatternsCondition());
                return new RequestMappingInfo(patternsCondition, mappingInfo.getMethodsCondition(), mappingInfo.getParamsCondition(),
                        mappingInfo.getHeadersCondition(), mappingInfo.getConsumesCondition(), mappingInfo.getProducesCondition(), mappingInfo.getCustomCondition());
            }
        }
        return mappingInfo;
    }
}