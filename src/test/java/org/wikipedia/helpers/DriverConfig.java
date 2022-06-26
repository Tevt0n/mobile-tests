package org.wikipedia.helpers;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config.properties"})
public interface DriverConfig extends Config {
    @Key("user")
    String browserstackUser();
    @Key("key")
    String browserstackKey();
    @Key("url")
    String appURL();
    @Key("device")
    String device();
    @Key("os")
    String osVersion();
}
