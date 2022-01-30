package com.fragnostic.conf.props.service

import com.fragnostic.conf.props.service.support.BaseConfTest

class ConfPropsServiceGetIntTest extends BaseConfTest {

  describe("Conf Props Service Get Int Test") {

    it("Can Get Value As Int from Props") {

      val value = CakeConfPropsService.confServiceApi.getInt(keyPropsInt) fold (
        error => throw new IllegalStateException(error),
        value => value //
      )

      assertResult(valuePropsInt)(value)
    }

    it("Can Not Get Value As Int from Props") {

      val value = CakeConfPropsService.confServiceApi.getInt(keyThatDoesNotExists) fold (
        error => error,
        value => value //
      )

      assertResult(valueThatDoesNotExists)(value)
    }

  }

}

