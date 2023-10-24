# Use a Java 11 base image
FROM openjdk:11-jre-slim

# Install necessary dependencies
RUN apt-get update && apt-get install -y \
    wget \
    gnupg2 \
    software-properties-common

# Add the Chromium repository and key
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list

# Install Chromium
RUN apt-get update && apt-get install -y google-chrome-stable

# Other Java 11 specific configurations and application setup here
