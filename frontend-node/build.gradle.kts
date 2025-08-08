
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

application {
    mainClass.set("com.example.frontend.FrontendMainKt")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.typesafe.akka:akka-actor_2.13:2.8.5")
    implementation("com.typesafe.akka:akka-cluster_2.13:2.8.5")
    implementation("com.typesafe.akka:akka-remote_2.13:2.8.5")
    implementation("com.typesafe.akka:akka-slf4j_2.13:2.8.5")
    implementation("com.lightbend.akka.management:akka-management_2.13:1.4.1")
    implementation("com.lightbend.akka.management:akka-management-cluster-http_2.13:1.4.1")
    implementation("com.lightbend.akka.management:akka-management-cluster-bootstrap_2.13:1.4.1")
    implementation("com.lightbend.akka.discovery:akka-discovery-kubernetes-api_2.13:1.4.1")
    implementation("ch.qos.logback:logback-classic:1.4.14")

}

tasks.withType<ShadowJar> {
    mergeServiceFiles()
    transform(com.github.jengelman.gradle.plugins.shadow.transformers.AppendingTransformer::class.java) {
        resource = "reference.conf"
    }
    transform(com.github.jengelman.gradle.plugins.shadow.transformers.AppendingTransformer::class.java) {
        resource = "application.conf"
    }
}

kotlin {
    jvmToolchain(17)
}

