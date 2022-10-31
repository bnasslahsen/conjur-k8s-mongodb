FROM index.docker.io/paketobuildpacks/run:tiny-cnb

COPY --from=busybox /bin/sh /bin/sh
COPY --from=busybox /bin/rm /bin/rm
COPY --from=busybox /bin/dirname /bin/dirname
