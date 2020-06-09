package com.fragnostic.conf.props.service

import com.fragnostic.conf.props.service.support.BaseConfTest

class ConfPropsServiceGetStringTest extends BaseConfTest {

  describe("Conf Props Service Get String Test") {

    it("Can Get Value As String from Props") {

      val opt = CakeConfPropsService.confServiceApi.getString(key = keyPropsString) fold (
        error => throw new IllegalStateException(error),
        opt => opt)

      opt should not be None
      opt.get should be("yep")
    }

  }

}
