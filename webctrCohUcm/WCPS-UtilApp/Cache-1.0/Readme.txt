This project is a replacement for the Cache-1.0 jar used in WebCenter to implement Coherence Caching.
It contains extra debug at key points.

Right click on project name and choose deploy to jar.

Take jar file from deploy folder and place in 
MyPortalApplication project in the APP-INF/lib folder.
and redeploy. 
App has pref local classes enabled in weblogic-application.xml 
so these classes will replace default ones at runtime.
