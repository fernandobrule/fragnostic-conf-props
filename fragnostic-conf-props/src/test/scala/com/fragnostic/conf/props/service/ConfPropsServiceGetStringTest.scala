package com.fragnostic.conf.props.service

import com.fragnostic.conf.props.service.support.BaseConfTest
import com.fragnostic.conf.service.support.KeySupport

class ConfPropsServiceGetStringTest extends BaseConfTest with KeySupport {

  describe("Conf Props Service Get String Test") {

    it("Can Get Value As String") {

      val opt = CakeConfPropsService.confPropsServiceApi.getString(props = this, key = keyPropsString) fold (
        error => throw new IllegalStateException(error),
        opt => opt)

      opt should not be None
      opt.get should be(valuePropsPtBr)
    }

    it("Can Get Value As String es/CL") {

      val opt = CakeConfPropsService.confPropsServiceApi.getString(locale = Some(localeEsCl), props = this, key = keyPropsString) fold (
        error => throw new IllegalStateException(error),
        opt => opt)

      opt should not be None
      opt.get should be(valuePropsEsCl)
    }

    it("Can Get Value As String pt/BR") {

      val opt = CakeConfPropsService.confPropsServiceApi.getString(locale = Some(localePtBr), props = this, key = keyPropsString) fold (
        error => throw new IllegalStateException(error),
        opt => opt)

      opt should not be None
      opt.get should be(valuePropsPtBr)
    }

    it("Can Get Value As String en/US") {

      val opt = CakeConfPropsService.confPropsServiceApi.getString(locale = Some(localeEnUs), props = this, key = keyPropsString) fold (
        error => throw new IllegalStateException(error),
        opt => opt)

      opt should not be None
      opt.get should be(valuePropsEnUs)
    }

  }

}
