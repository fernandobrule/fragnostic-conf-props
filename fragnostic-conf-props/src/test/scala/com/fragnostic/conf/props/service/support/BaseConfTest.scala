package com.fragnostic.conf.props.service.support

import org.scalatest.funspec.AnyFunSpec

import java.util.Locale

trait BaseConfTest extends AnyFunSpec {

  protected val keyThatDoesNotExists: String = "KEY_THAT_DOES_NOT_EXISTS"
  protected val valueThatDoesNotExists = "props.dao.error.key__KEY_THAT_DOES_NOT_EXISTS__does.not.exists"

  protected val keyPropsString: String = "test.key.props"
  protected val valuePropsString = "yep"

  protected val keyPropsShort: String = "test.key.props.short"
  protected val valuePropsShort: Short = 123

  protected val keyPropsInt: String = "test.key.props.int"
  protected val valuePropsInt: Int = 456

  protected val keyPropsLong: String = "test.key.props.long"
  protected val valuePropsLong: Long = 789

  protected val keyPropsBoolean: String = "test.key.props.boolean"
  protected val valuePropsBoolean: Boolean = true

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
