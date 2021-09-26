package com.fragnostic.conf.props.service

import com.fragnostic.conf.base.service.api.ConfServiceApi
import com.fragnostic.conf.env.service.CakeConfEnvService
import com.fragnostic.conf.props.dao.impl.PropsDaoImpl
import com.fragnostic.conf.props.service.impl.ConfPropsServiceImpl
import com.fragnostic.support.FilesSupport

import java.util.Properties

object CakeConfPropsService extends FilesSupport {

  private lazy val cakeProperties: Properties =
    CakeConfEnvService.confEnvService.getString("FRAGNOSTIC_CONF_PROPS_FILE") fold (
      error => throw new IllegalStateException(s"cake.conf.props.service.error.$error"),
      opt => opt map (path =>
        loadProperties(path) fold (
          error => throw new IllegalStateException(s"cake.conf.props.service.error.$error"),
          properties => properties //
        ) //
      ) getOrElse { throw new IllegalStateException("cake.conf.props.service.error.FRAGNOSTIC_CONF_PROPS_FILE.does.not.exists") } //
    )

  lazy val confServiceApi = confServicePiece.confServiceApi

  lazy val confServicePiece: ConfServiceApi = new ConfPropsServiceImpl with PropsDaoImpl {
    override val properties: Properties = cakeProperties
  }

}
