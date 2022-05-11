plugins {
    id("java")
    id("eclipse")
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    mavenLocal()
    mavenCentral()

    maven {
        url = uri("https://libraries.minecraft.net/")
    }

    maven {
        url = uri("https://files.minecraftforge.net/maven/")
    }

    maven {
        url = uri("https://maven.fabricmc.net/")
    }

    maven {
        url = uri("https://repository.ow2.org/nexus/content/repositories/releases/")
    }

    maven {
        url = uri("https://maven.shedaniel.me/")
    }

    maven {
        url = uri("https://maven.blamejared.com/")
    }

    maven {
        url = uri("https://api.modrinth.com/maven/")
    }

    maven {
        url = uri("https://maven.tterrag.com/")
    }

    maven {
        url = uri("https://www.cursemaven.com/")
    }

    maven {
        url = uri("https://maven.jamieswhiteshirt.com/libs-release/")
    }

    maven {
        url = uri("https://maven.terraformersmc.com/")
    }

    maven {
        url = uri("https://maven.cafeteria.dev/")
    }
}

dependencies {
    implementation("net.fabricmc:fabric-loader:0.14.5")
    implementation("net.fabricmc.fabric-api:fabric-api:0.51.1+1.18.2")
    implementation("io.github.classgraph:classgraph:4.8.146")
    implementation("org.apache.logging.log4j:log4j-api:2.17.2")
    implementation("org.apache.logging.log4j:log4j-core:2.17.2")
}

group = "com.github.redstonewizard08.modloader"
version = "1.0.0"
description = "modloader"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
