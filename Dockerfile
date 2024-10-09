FROM ubuntu:latest
LABEL authors="Douglas Yugo"

ENTRYPOINT ["top", "-b"]