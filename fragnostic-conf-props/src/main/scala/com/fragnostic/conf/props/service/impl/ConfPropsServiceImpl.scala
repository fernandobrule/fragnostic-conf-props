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

    override def getString(key: String): Either[String, String] =
      propsCrud.getString(key) fold (
        error => Left(error),
        value => Right(value) //
      )

    override def getString(locale: Locale, key: String): Either[String, String] = ???
    /*propsCrud.getString(key)fold(
        error => Left(error),
        value => Right(value)//
      )*/

    override def getShort(key: String): Either[String, Short] =
      propsCrud.getString(key) fold (
        error => Left(error),
        value => Right(value.toShort) //
      )

    override def getInt(key: String): Either[String, Int] =
      propsCrud.getString(key) fold (
        error => Left(error),
        value => Right(value.toInt) //
      )

    override def getLong(key: String): Either[String, Long] = {
      propsCrud.getString(key) fold (
        error => Left(error),
        value => Right(value.toLong) //
      )
    }

    override def getBigDecimal(key: String): Either[String, BigDecimal] = {
      propsCrud.getString(key) fold (
        error => Left(error),
        value => Right(BigDecimal(value)) //
      )
    }

    override def getBoolean(key: String): Either[String, Boolean] =
      propsCrud.getString(key) fold (
        error => Left(error),
        value => Right(value.toBoolean) //
      )

  }

}
