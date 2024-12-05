FROM postgres:14
LABEL authors="kelena"

COPY init.sql /docker-entrypoint-initdb.d/
ENV POSTGRES_DB company
ENV POSTGRES_USER random
ENV POSTGRES_PASSWORD code