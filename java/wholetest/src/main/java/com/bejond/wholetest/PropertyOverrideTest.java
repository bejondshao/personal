package com.bejond.wholetest;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.Test;

public class PropertyOverrideTest {

    @Test
    public void testOverride() {

        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName("file.properties"));
        Configuration config = null;
        try {
            config = builder.getConfiguration();
            config.setProperty("somekey", "somevalue");
            builder.save();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
}
