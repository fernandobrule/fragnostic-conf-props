package com.fragnostic.conf.props.service.impl

import java.util.Locale

import com.fragnostic.conf.props.service.api.ConfPropsServiceApi
import com.fragnostic.conf.service.support.{ KeySupport, TypesSupport }
import com.fragnostic.i18n.api.ResourceI18n

/**
 * Configuration from Properties
 */
trait ConfPropsServiceImpl extends ConfPropsServiceApi {

  def confPropsServiceApi = new DefaultConfPropsService

  class DefaultConfPropsService extends ConfPropsServiceApi with TypesSupport with KeySupport {

    override def getString(localeOpt: Option[Locale] = None, props: ResourceI18n, key: String): Either[String, Option[String]] =
      localeOpt map (locale => Right(Some(props.getString(locale, key)))) getOrElse ({
        Right({
          Some(props.getString(locale = null, key))
        })
      })

    override def getShort(props: ResourceI18n, key: String): Either[String, Option[Short]] =
      getString(props = props, key = key) fold (
        error => Left(error),
        opt => toShort(opt))

    override def getInt(props: ResourceI18n, key: String): Either[String, Option[Int]] =
      getString(props = props, key = key) fold (
        error => Left(error),
        opt => toInt(opt))

    override def getLong(props: ResourceI18n, key: String): Either[String, Option[Long]] =
      getString(props = props, key = key) fold (
        error => Left(error),
        opt => toLong(opt))

  }

}
