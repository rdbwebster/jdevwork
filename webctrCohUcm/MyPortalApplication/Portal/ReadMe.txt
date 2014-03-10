This is a sample portal app that include UCM integration.
It can be deployed using Application->deploy
NOT project deploy, we need the ear config files and jars to deploy.
Deploy to WC_Spaces server

The key jsp page is oracle/webcenter/portalapp/pages/home.jspx
it contains a contentPresenter control

It also includes a debug version of the Cache-1.0.jar that implements coherence caching for webcenter contentComposer.
Note that the jar will not be available when checking out of git.
you need to build the jar in the WCPS_UtilApp   see readme note in that project.

Based on tutorial
http://docs.oracle.com/cd/E28280_01/webcenter.1111/e10273/toc.htm

Note that the content-coherence-ha-config.xml found in the support doc 1503040.1  worked and content is displayed.
But the content file content-coherence-cache.config.xml from the docs does not work.
When I refresh the page of the app I do not see the requested content on the home page.
 