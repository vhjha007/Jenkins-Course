In CloudBees Jenkins, the proxy settings are typically configured in the Jenkins System Configuration. Follow these steps to locate and modify proxy settings:

1. Log in to your CloudBees Jenkins instance.

2. Navigate to the Jenkins dashboard.

3. Click on "Manage Jenkins" in the left-hand menu.

4. Select "Manage Plugins" from the options.

5. In the "Advanced" tab, you should see a section for proxy settings. If your CloudBees Jenkins instance is behind a proxy, the proxy settings might be configured here.

6. If you don't find the proxy settings in the "Manage Plugins" section, go back to the "Manage Jenkins" page.

7. Look for "Configure System" or "Configure Global Security" on the "Manage Jenkins" page.

8. Scroll through the configuration options. You may find proxy settings under a section related to "HTTP Proxy Configuration" or "Network Settings."

9. If you still can't find proxy settings, it's possible that your CloudBees Jenkins instance is not using a proxy directly within Jenkins. In that case, check if there are any environment variables set in your Jenkins environment that configure the proxy.

10. If all else fails, you may need to check the server or container where CloudBees Jenkins is running for global proxy settings.

Once you locate the proxy settings, you can update or unset them as needed, following the instructions from the previous responses. Remember to save your changes and restart Jenkins for the modifications to take effect.
