package com.fragnostic.conf.props.service

import com.fragnostic.conf.props.service.support.BaseConfTest

class ConfPropsServiceGetStringTest extends BaseConfTest {

  describe("Conf Props Service Get String Test") {

    it("Can Get Value As String from Props") {

      val value = CakeConfPropsService.confServiceApi.getString(key = keyPropsString) fold (
        error => throw new IllegalStateException(error),
        value => value //
      )

      assertResult("yep")(value)
    }

    it("Can Not Get Value As String from Props") {

      val value = CakeConfPropsService.confServiceApi.getString(key = keyThatDoesNotExists) fold (
        error => error,
        value => value //
      )

      assertResult(valueThatDoesNotExists)(value)
    }

  }

}
