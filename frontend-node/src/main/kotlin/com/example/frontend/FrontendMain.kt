package com.example.frontend

import akka.actor.ActorSystem
import akka.actor.Props
import akka.management.javadsl.AkkaManagement
import akka.management.cluster.bootstrap.ClusterBootstrap
import com.typesafe.config.ConfigFactory

fun main() {
    val system = ActorSystem.create("MyClusterSystem", ConfigFactory.load())
    AkkaManagement.get(system).start()
    ClusterBootstrap.get(system).start()
    system.actorOf(Props.create(FrontendGuardian::class.java), "guardian")
}
