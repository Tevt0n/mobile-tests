package org.wikipedia.configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:BrowserstackConfig.properties"})
public interface BrowserstackConfig extends Config {
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
