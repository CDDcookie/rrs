#FROM amazoncorretto:17
#
#WORKDIR /app
#
#COPY build/libs/review-0.0.1-SNAPSHOT.jar /app/review.jar
#COPY entrypoint.sh /app/entrypoint.sh
#RUN chmod +x /app/entrypoint.sh
#
#ENTRYPOINT ["/app/entrypoint.sh"]

FROM amazoncorretto:17

WORKDIR /app

COPY ./build/libs/review-0.0.1-SNAPSHOT.jar /app/review.jar
COPY ./entrypoint.sh /app/entry-point.sh
RUN chmod +x /app/entry-point.sh

ENTRYPOINT ["./entry-point.sh"]