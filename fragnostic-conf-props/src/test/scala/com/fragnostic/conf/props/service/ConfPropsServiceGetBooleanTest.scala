package com.fragnostic.conf.props.service

import com.fragnostic.conf.props.service.support.BaseConfTest

class ConfPropsServiceGetBooleanTest extends BaseConfTest {

  describe("Conf Props Service Get Boolean Test") {

    it("Can Get Value As Boolean from Props") {
      val value = CakeConfPropsService.confServiceApi.getBoolean(keyPropsBoolean) fold (
        error => throw new IllegalStateException(error),
        value => value //
      )

      assertResult(valuePropsBoolean)(value)
    }

    it("Can Not Get Value As Boolean from Props") {
      val value = CakeConfPropsService.confServiceApi.getBoolean(keyThatDoesNotExists) fold (
        error => error,
        value => value //
      )

      assertResult(valueThatDoesNotExists)(value)
    }

  }

}

