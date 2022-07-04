package org.wikipedia.configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config/LocalConfig.properties")
public interface LocalConfig extends Config {
    @DefaultValue("Android")
    @Key("platform_name")
    String platformName();

    @DefaultValue("Pixel 5 API 31")
    @Key("device_name")
    String deviceName();

    @DefaultValue("12.0")
    @Key("platform_version")
    String platformVersion();
}
