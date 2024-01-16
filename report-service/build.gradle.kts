extra["springCloudVersion"] = "2022.0.4"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.5")
    implementation("com.opencsv:opencsv:5.5.1")
    implementation ("org.springframework.boot:spring-boot-starter-amqp")
    implementation ("org.springframework.cloud:spring-cloud-stream")
    implementation ("org.springframework.cloud:spring-cloud-stream-binder-rabbit")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}