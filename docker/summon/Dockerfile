# STAGE:
# Fetch summon
FROM ruby:2.5 as summon
#---install summon and summon-conjur---#
RUN curl -sSL https://raw.githubusercontent.com/cyberark/summon/main/install.sh \
      | env TMPDIR=$(mktemp -d) bash && \
    curl -sSL https://raw.githubusercontent.com/cyberark/summon-conjur/main/install.sh \
      | env TMPDIR=$(mktemp -d) bash

# STAGE:
# This base is used for the final image
# It extracts the packaged application from the previous stage
# and builds the final image
FROM openjdk:11-jre-slim
COPY --from=summon /usr/local/lib/summon /usr/local/lib/summon
COPY --from=summon /usr/local/bin/summon /usr/local/bin/summon
COPY target/conjur-k8s-mongodb-1.0.jar /app/target/conjur-k8s-mongodb-1.0.jar

EXPOSE 8080

#---override entrypoint to wrap command with summon---#
ENTRYPOINT ["summon", "--provider", "summon-conjur" ,"-f", "/etc/summon/secrets.yml", "java", "-jar", "/app/target/conjur-k8s-mongodb-1.0.jar" ]