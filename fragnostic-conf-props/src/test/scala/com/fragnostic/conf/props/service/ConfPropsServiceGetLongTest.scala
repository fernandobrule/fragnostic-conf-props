package com.fragnostic.conf.props.service

import com.fragnostic.conf.props.service.support.BaseConfTest

class ConfPropsServiceGetLongTest extends BaseConfTest {

  describe("Conf Props Service Get Long Test") {

    it("Can Get Value As Long from Props") {

      val opt = CakeConfPropsService.confServiceApi.getLong(key = keyPropsLong) fold (
        error => throw new IllegalStateException(error),
        opt => opt //
      )

      assertResult(opt.get)(valuePropsLong)

    }

  }

}

