package org.example;

import freemarker.cache.ClassTemplateLoader;
import spark.template.freemarker.FreeMarkerEngine;
import freemarker.template.Configuration;

public class TemplateFactory {
  public static FreeMarkerEngine freeMarkerEngine() {
    Configuration freeMarkerConfiguration = new Configuration(Configuration.VERSION_2_3_0);
    FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(freeMarkerConfiguration);
    freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(Main.class, "/"));
    return freeMarkerEngine;
  }
}
