package com.fragnostic.conf.props.service.impl

import com.fragnostic.conf.base.service.api.ConfServiceApi
import com.fragnostic.conf.base.service.support.TypesSupport
import com.fragnostic.conf.props.dao.api.PropsDaoApi

/**
 * Configuration from Properties
 */
trait ConfPropsServiceImpl extends ConfServiceApi {
  this: PropsDaoApi =>

  def confServiceApi = new DefaultConfPropsService

  class DefaultConfPropsService extends ConfServiceApi with TypesSupport {

    override def getString(key: String): Either[String, Option[String]] =
      Right(Some(propsCrud.getString(key)))

    override def getShort(key: String): Either[String, Option[Short]] =
      toShort(Some(propsCrud.getString(key)))

    override def getInt(key: String): Either[String, Option[Int]] =
      toInt(Some(propsCrud.getString(key)))

    override def getLong(key: String): Either[String, Option[Long]] =
      toLong(Some(propsCrud.getString(key)))

  }

}
