package com.fragnostic.conf.props.dao.api

trait PropsDaoApi {

  def propsCrud: PropsCrud

  trait PropsCrud {

    def getString(key: String): Either[String, String]

  }

}

