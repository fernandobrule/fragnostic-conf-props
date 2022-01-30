package com.fragnostic.conf.props.service

import com.fragnostic.conf.props.service.support.BaseConfTest

class ConfPropsServiceGetLongTest extends BaseConfTest {

  describe("Conf Props Service Get Long Test") {

    it("Can Get Value As Long from Props") {

      val value = CakeConfPropsService.confServiceApi.getLong(key = keyPropsLong) fold (
        error => throw new IllegalStateException(error),
        value => value //
      )

      assertResult(valuePropsLong)(value)

    }

    it("Can Not Get Value As Long from Props") {

      val value = CakeConfPropsService.confServiceApi.getLong(key = keyThatDoesNotExists) fold (
        error => error,
        value => value //
      )

      assertResult(valueThatDoesNotExists)(value)

    }

  }

}

