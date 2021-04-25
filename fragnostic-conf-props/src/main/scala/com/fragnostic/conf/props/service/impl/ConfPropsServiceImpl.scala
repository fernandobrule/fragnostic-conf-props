package com.fragnostic.conf.props.service.impl

import com.fragnostic.conf.base.service.api.ConfServiceApi
import com.fragnostic.conf.base.service.support.TypesSupport
import com.fragnostic.conf.props.dao.api.PropsDaoApi
import org.slf4j.{ Logger, LoggerFactory }

import java.util.Locale

/**
 * Configuration from Properties
 */
trait ConfPropsServiceImpl extends ConfServiceApi {
  this: PropsDaoApi =>

  def confServiceApi = new DefaultConfPropsService

  class DefaultConfPropsService extends ConfServiceApi with TypesSupport {

    private[this] val logger: Logger = LoggerFactory.getLogger("ConfPropsServiceImpl")

    override def getString(key: String): Either[String, Option[String]] =
      Right(Some(propsCrud.getString(key)))

    override def getString(locale: Locale, key: String): Either[String, Option[String]] = {
      logger.warn(s"getString() - with Locale NOT YET!")
      Right(Some(propsCrud.getString(key)))
    }

    override def getShort(key: String): Either[String, Option[Short]] =
      toShort(Some(propsCrud.getString(key)))

    override def getInt(key: String): Either[String, Option[Int]] =
      toInt(Some(propsCrud.getString(key)))

    override def getLong(key: String): Either[String, Option[Long]] =
      toLong(Some(propsCrud.getString(key)))

    override def getBoolean(key: String): Either[String, Option[Boolean]] =
      toBoolean(Some(propsCrud.getString(key)))

  }

}
