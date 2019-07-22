package com.psqframework.core.util;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadPolicy;

@LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@Sources({
	"file:src/test/resources/config/project.${ENV_INSTANCE}.properties",
	"file:src/test/resources/config/project.properties"

})

public interface EnvConfig extends Config {

	String url();

	String userName();

	String userPassword();
	
	String region();
	
}