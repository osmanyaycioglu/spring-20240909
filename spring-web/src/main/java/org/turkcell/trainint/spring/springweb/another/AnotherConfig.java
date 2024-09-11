package org.turkcell.trainint.spring.springweb.another;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.turkcell.trainint.common.CommonBean;
import org.turkcell.trainint.common.CommonConfig;
import org.turkcell.trainint.spring.springweb.MyBean;

@Configuration
@Import(CommonConfig.class)
@PropertySource("classpath:my.properties")
public class AnotherConfig {

    @Bean
    public FullBean fullBean(final CommonBean commonBean,
                             final AnotherBean anotherBean) {
        return new FullBean(commonBean,
                            anotherBean);
    }

    @Bean
    public AnotherBean anotherBean(@Qualifier("myBean") final MyBean myBeanParam) {
        return new AnotherBean(myBeanParam);
    }

}
