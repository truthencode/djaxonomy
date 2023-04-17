#!/bin/env bash

touch .taxi/debug.log

dirs=./lib/src/generated/kotlin
# ideally should read / this from env or taxi.conf
if [[ -d ${dirs} ]] && files=("${dirs}"/*) && [[ -e ${files[0]} || -L ${files[0]} ]]; then
	echo "cleaning ${dirs}"
	rm -rf "${dirs}"
fi

mkdir -p "${dirs}"
# local build works, docker fails with permission
# taxi build

# local build sets file permissions to read-only
chmod -R -c o=rw "${dirs}"
# replace with specific version unavailable via sdkman
docker run -v "${PWD}":/taxi -e CLI_CMD="build" -u "999:998" taxilang/taxi-cli:1.32.5
