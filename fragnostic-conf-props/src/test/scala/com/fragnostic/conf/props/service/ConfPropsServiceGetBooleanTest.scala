package com.fragnostic.conf.props.service

import com.fragnostic.conf.props.service.support.BaseConfTest

class ConfPropsServiceGetBooleanTest extends BaseConfTest {

  describe("Conf Props Service Get Boolean Test") {

    it("Can Get Value As Boolean from Props") {

      val opt = CakeConfPropsService.confServiceApi.getBoolean(keyPropsBoolean) fold (
        error => throw new IllegalStateException(error),
        opt => opt //
      )

      assertResult(opt.get)(valuePropsBoolean)

    }

  }

}

