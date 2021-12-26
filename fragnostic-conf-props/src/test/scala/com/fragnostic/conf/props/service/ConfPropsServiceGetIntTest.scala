package com.fragnostic.conf.props.service

import com.fragnostic.conf.props.service.support.BaseConfTest

class ConfPropsServiceGetIntTest extends BaseConfTest {

  describe("Conf Props Service Get Int Test") {

    it("Can Get Value As Int from Props") {

      val opt = CakeConfPropsService.confServiceApi.getInt(keyPropsInt) fold (
        error => throw new IllegalStateException(error),
        opt => opt //
      )

      assertResult(opt.get)(valuePropsInt)

    }

  }

}

