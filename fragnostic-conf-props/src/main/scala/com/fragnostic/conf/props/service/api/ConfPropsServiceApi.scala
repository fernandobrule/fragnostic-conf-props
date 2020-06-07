package com.fragnostic.conf.props.service.api

import java.util.Locale

import com.fragnostic.i18n.api.ResourceI18n

/**
 * Configuration from Cache -> Environment -> Properties -> DB
 */
trait ConfPropsServiceApi {

  def confPropsServiceApi: ConfPropsServiceApi

  trait ConfPropsServiceApi {

    def getString(locale: Locale, props: ResourceI18n, key: String): Either[String, Option[String]]

    def getString(props: ResourceI18n, key: String): Either[String, Option[String]]

    def getShort(props: ResourceI18n, key: String): Either[String, Option[Short]]

    def getInt(props: ResourceI18n, key: String): Either[String, Option[Int]]

    def getLong(props: ResourceI18n, key: String): Either[String, Option[Long]]

  }

}
