package com.example.backend

import akka.actor.AbstractActor
import akka.cluster.Cluster
import akka.event.Logging

class BackendGuardian : AbstractActor() {
    private val cluster = Cluster.get(context.system)
    private val log = Logging.getLogger(context.system, this)

    override fun preStart() {
        log.info("Hello world!")
        log.info("Backend node started with roles:${cluster.selfRoles()}")
    }

    override fun createReceive(): Receive = receiveBuilder().build()
}
