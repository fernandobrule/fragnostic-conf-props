package com.fragnostic.conf.props.service

import com.fragnostic.conf.base.service.api.ConfServiceApi
import com.fragnostic.conf.env.service.CakeConfEnvService
import com.fragnostic.conf.props.dao.impl.PropsDaoImpl
import com.fragnostic.conf.props.service.impl.ConfPropsServiceImpl
import com.fragnostic.support.FilesSupport

import java.util.Properties

object CakeConfPropsService extends FilesSupport {

  private val envKey: String = "FRAGNOSTIC_CONF_PROPS_FILE"

  private lazy val cakeProperties: Properties =
    CakeConfEnvService.confEnvService.getString(envKey) fold (
      error => throw new IllegalStateException(s"cake.conf.props.service.error.$error"),
      path => loadProperties(path) fold (
        error => throw new IllegalStateException(s"cake.conf.props.service.error.on.load.properties__$error"),
        properties => properties //
      ) //
    )

  lazy val confServiceApi = confServicePiece.confServiceApi

  lazy val confServicePiece: ConfServiceApi = new ConfPropsServiceImpl with PropsDaoImpl {
    override val properties: Properties = cakeProperties
  }

}
