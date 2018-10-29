package com.rockonengin.configuration;

import cn.org.rapid_framework.freemarker.directive.BlockDirective;
import cn.org.rapid_framework.freemarker.directive.ExtendsDirective;
import cn.org.rapid_framework.freemarker.directive.OverrideDirective;
import cn.org.rapid_framework.freemarker.directive.SuperDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by tangfan on 2017/12/03.
 */
@Configuration
public class FreemarkerConfiguration {
	@Autowired
	freemarker.template.Configuration configuration;

	@PostConstruct
	public void setSharedVariable(){
		configuration.setSharedVariable("block", new BlockDirective());
		configuration.setSharedVariable("override", new OverrideDirective());
		configuration.setSharedVariable("extends", new ExtendsDirective());
		configuration.setSharedVariable("super", new SuperDirective());
	}
}
