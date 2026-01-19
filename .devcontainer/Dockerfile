FROM mcr.microsoft.com/devcontainers/java:17

RUN echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | sudo tee /etc/apt/sources.list.d/sbt.list && \
    curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo gpg --dearmor -o /etc/apt/trusted.gpg.d/sbt.gpg && \
    sudo apt-get update && \
    sudo apt-get install -y sbt && \
    sudo rm -rf /var/lib/apt/lists/*
