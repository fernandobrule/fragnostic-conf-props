package com.fragnostic.conf.props.service

import com.fragnostic.conf.props.service.support.BaseConfTest

class ConfPropsServiceGetShortTest extends BaseConfTest {

  describe("Conf Props Service Get Short Test") {

    it("Can Get Value As Short from Props") {

      val opt = CakeConfPropsService.confServiceApi.getShort(keyPropsShort) fold (
        error => throw new IllegalStateException(error),
        opt => opt)

      opt should not be None
      opt.get should be(valuePropsShort)

    }

  }

}

