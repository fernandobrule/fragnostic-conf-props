package com.fragnostic.conf.props.service.support

import java.util.Locale

import org.scalatest.{ FunSpec, Matchers }

trait BaseConfTest extends FunSpec with Matchers {

  protected val keyPropsString: String = "test.key.props"
  protected val keyPropsShort: String = "test.key.props.short"
  protected val keyPropsInt: String = "test.key.props.int"
  protected val keyPropsLong: String = "test.key.props.long"

  protected val valuePropsString = "yep"
  protected val valuePropsShort: Short = 123
  protected val valuePropsInt: Int = 456
  protected val valuePropsLong: Long = 789

  protected val valuePropsEsCl = "muchas gracias"
  protected val valuePropsEnUs = "many thanks"
  protected val valuePropsPtBr = "muito obrigado"

  //
  // es/CL
  //
  protected val localeEsCl: Locale = new Locale.Builder().setRegion("CL").setLanguage("es").build()
  //
  // pt/BR
  //
  protected val localePtBr: Locale = new Locale.Builder().setRegion("BR").setLanguage("pt").build()
  //
  // en/US
  //
  protected val localeEnUs: Locale = new Locale.Builder().setRegion("US").setLanguage("en").build()

}
