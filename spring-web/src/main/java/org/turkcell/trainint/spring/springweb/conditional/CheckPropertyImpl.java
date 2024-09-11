package org.turkcell.trainint.spring.springweb.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.List;

public class CheckPropertyImpl implements Condition {

    @Override
    public boolean matches(final ConditionContext context,
                           final AnnotatedTypeMetadata metadata) {
//        MergedAnnotations             annotationsLoc   = metadata.getAnnotations();
//        MergedAnnotation<CheckProperty> ma = annotationsLoc.get(CheckProperty.class);
        MultiValueMap<String, Object> checkPropertyLoc = metadata.getAllAnnotationAttributes("org.turkcell.trainint.spring.springweb.conditional.CheckProperty");
        if (checkPropertyLoc != null) {
            List<Object> keysLoc = checkPropertyLoc.get("key");
            String       keyLoc   = (String) keysLoc.get(0);

            List<Object> valsLoc = checkPropertyLoc.get("val");
            String       valLoc   = (String) valsLoc.get(0);

            String propertyLoc = context.getEnvironment()
                                        .getProperty(keyLoc);
            return propertyLoc != null && propertyLoc.equals(valLoc);
        }
        return false;
    }

}
