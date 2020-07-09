package com.fragnostic.conf.props.service

import java.util.Properties

import com.fragnostic.conf.env.service.CakeConfEnvService
import com.fragnostic.conf.props.dao.impl.PropsDaoImpl
import com.fragnostic.conf.props.service.impl.ConfPropsServiceImpl
import com.fragnostic.support.FilesSupport

object CakeConfPropsService extends FilesSupport {

  private lazy val cakePropertie: Properties =
    CakeConfEnvService.confServiceApi.getString("CONF_PROPS_PATH") fold (
      error => throw new IllegalStateException("cake.conf.props.error"),
      opt => opt map (path =>
        loadProperties(path) fold (
          error => throw new IllegalStateException("cake.conf.props.error"),
          properties => properties)) getOrElse { throw new IllegalStateException("cake.conf.props.error") })

  val confServiceApi = new ConfPropsServiceImpl with PropsDaoImpl {
    override val properties: Properties = cakePropertie
  }.confServiceApi

}
