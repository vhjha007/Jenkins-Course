# Use a Java 11 base image (Red Hat-based)
FROM adoptopenjdk:11-jre-hotspot

# Install Chromium dependencies using yum
RUN yum update -y && yum install -y \
    chromium \
    libXcomposite \
    libXcursor \
    libXdamage \
    libXext \
    libXi \
    libXtst \
    liberation-fonts

# Set the CHROME_BIN environment variable
ENV CHROME_BIN /usr/bin/chromium

# Other Java 11 specific configurations and application setup here
