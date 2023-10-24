# Use a Java 11 base image (Red Hat-based)
FROM adoptopenjdk:11-jre-hotspot

# Install necessary dependencies
RUN yum install -y wget

# Download and install Chromium
RUN wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_x86_64.rpm
RUN yum localinstall -y google-chrome-stable_current_x86_64.rpm

# Set the CHROME_BIN environment variable
ENV CHROME_BIN /usr/bin/google-chrome

# Cleanup downloaded files
RUN rm google-chrome-stable_current_x86_64.rpm

# Other Java 11 specific configurations and application setup here
