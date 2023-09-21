FROM maven:3.9.4-eclipse-temurin-20
RUN apt-get update && \ 
    apt-get install -y xvfb libx11-6 libx11-xcb1 libxext6 libxrender1 libxtst6 libxi6 libfreetype6 libgtk-3-0 && \
    # Clean the packages and install script in /var/cache/apt/archives/
    apt-get clean && \
    # Remove the package lists (created by apt-get update)
    rm -rf /var/lib/apt/lists/*
#RUN curl -Ls https://sh.jbang.dev | bash -s - trust add https://repo1.maven.org/maven2/io/quarkus/quarkus-cli/
#RUN curl -Ls https://sh.jbang.dev | bash -s - app install --fresh --force quarkus@quarkusio
#RUN apk add --update mesa-gl\
#&& rm  -rf /tmp/* /var/cache/apk/*