package com.fragnostic.conf.props.service

import com.fragnostic.conf.props.service.support.BaseConfTest

class ConfPropsServiceGetShortTest extends BaseConfTest {

  describe("Conf Props Service Get Short Test") {

    it("Can Get Value As Short from Props") {

      val value = CakeConfPropsService.confServiceApi.getShort(keyPropsShort) fold (
        error => throw new IllegalStateException(error),
        value => value //
      )

      assertResult(valuePropsShort)(value)

    }

    it("Can Not Get Value As Short from Props") {

      val value = CakeConfPropsService.confServiceApi.getShort(keyThatDoesNotExists) fold (
        error => error,
        value => value //
      )

      assertResult(valueThatDoesNotExists)(value)

    }

  }

}

