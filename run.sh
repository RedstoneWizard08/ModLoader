#!/bin/bash

set -e

./gradlew build shadowJar

java -cp build/libs/fabric-modloader-1.0.0-all.jar com.github.redstonewizard08.modloader.ModLoader
