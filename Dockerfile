FROM index.docker.io/paketobuildpacks/run:tiny-cnb as tinny

COPY --from=busybox /bin/sh /bin/sh
COPY --from=busybox /bin/rm /bin/rm
COPY --from=busybox /bin/dirname /bin/dirname
COPY --from=busybox /bin/ls /bin/ls
COPY --from=busybox /bin/id /bin/id
COPY --from=busybox /bin/whoami /bin/whoami
COPY --from=busybox /bin/mkdir /bin/mkdir
COPY --from=busybox /bin/chmod /bin/chmod
COPY --from=busybox /bin/cat /bin/cat
