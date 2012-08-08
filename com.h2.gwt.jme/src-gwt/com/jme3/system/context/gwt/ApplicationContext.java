package com.jme3.system.context.gwt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

public class ApplicationContext {

   private static final ApplicationContext INSTANCE =
      new ApplicationContext();
   
   ////
   
   private static final String CONTEXT_PATH = 
      GWT.getModuleBaseURL().replace(GWT.getModuleName() + "/", "");
   
   private AppContext _appProperties = GWT.create(AppContext.class);
   
   private static String _appApiRelativeUrl;
   
   private static String _appRelativeUrl;
   
   ////
   ////

   /**
    * @return the Instance
    */
   public static ApplicationContext getInstance() {
      return INSTANCE;
   }
   
   public static String getAppRelativeUrl() {
      if(_appRelativeUrl == null) {
         int index = CONTEXT_PATH.indexOf("://");
         index = CONTEXT_PATH.indexOf('/', index + 4);
         int stopIndex = CONTEXT_PATH.indexOf('/', index + 1);
         if(stopIndex < 0) {
            _appRelativeUrl = "";
         }
         else {
            _appRelativeUrl = CONTEXT_PATH.substring(index, stopIndex);
         }
      }
      return _appRelativeUrl;
   }
   
   public String getAppApiRelativeUrl() {
      if(_appApiRelativeUrl == null) {
         int index = CONTEXT_PATH.indexOf("://");
         index = CONTEXT_PATH.indexOf('/', index + 4);
         int stopIndex = CONTEXT_PATH.indexOf('/', index + 1);
         if(stopIndex < 0) {
            _appApiRelativeUrl = "" + getAppProperties().context();
         }
         else {
            _appApiRelativeUrl = CONTEXT_PATH.substring(index, stopIndex)
               + getAppProperties().context();
         }
      }
      return _appApiRelativeUrl;
   }
   
   public String getAppBaseUrl() {
       return CONTEXT_PATH;
   }
   
   public String getAppUrl() {
      String url = Window.Location.getHref().replace(
            Window.Location.getHash(), "");
      return url;
   }

   /**
    * @return the appProperties
    */
   public AppContext getAppProperties() {
      return _appProperties;
   }
   
   ////
   
}
