
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/cirrusdi/AwsEc2AdminServer/conf/routes
// @DATE:Sat Nov 21 17:30:16 CST 2015

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseTest Test = new controllers.ReverseTest(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseQuery Query = new controllers.ReverseQuery(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseTest Test = new controllers.javascript.ReverseTest(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseQuery Query = new controllers.javascript.ReverseQuery(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
  }

}
