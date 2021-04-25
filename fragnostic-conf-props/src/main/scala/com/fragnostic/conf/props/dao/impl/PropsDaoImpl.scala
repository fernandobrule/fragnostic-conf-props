package com.fragnostic.conf.props.dao.impl

import com.fragnostic.conf.props.dao.api.PropsDaoApi

import java.util.Properties

trait PropsDaoImpl extends PropsDaoApi with PropertiesAgnostic {

  def propsCrud: PropsCrud = new PropsDaoImpl(properties)

  class PropsDaoImpl(val properties: Properties) extends PropsCrud {

    override def getString(key: String): String =
      properties.getProperty(key)

  }

}

