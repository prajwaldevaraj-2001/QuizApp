FROM ubuntu:20.04

# Install required packages
RUN apt-get update && apt-get install -y \
    openjdk-11-jdk \
    wget \
    unzip \
    git \
    curl

# Set environment variables
ENV JAVA_HOME="/usr/lib/jvm/java-11-openjdk-amd64"
ENV ANDROID_HOME="/root/android-sdk"
ENV PATH="$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools"

# Install Android SDK
RUN mkdir -p $ANDROID_HOME && \
    wget https://dl.google.com/android/repository/commandlinetools-linux-8512546_latest.zip -O sdk-tools.zip && \
    unzip sdk-tools.zip -d $ANDROID_HOME && \
    rm sdk-tools.zip && \
    yes | $ANDROID_HOME/tools/bin/sdkmanager --licenses && \
    $ANDROID_HOME/tools/bin/sdkmanager "platform-tools" "platforms;android-33" "build-tools;33.0.0"

# Install Gradle
RUN wget https://services.gradle.org/distributions/gradle-7.5.1-bin.zip -O gradle.zip && \
    unzip gradle.zip -d /opt && \
    ln -s /opt/gradle-7.5.1/bin/gradle /usr/bin/gradle && \
    rm gradle.zip

CMD ["bash"]
