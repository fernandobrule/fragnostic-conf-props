package com.fragnostic.conf.props.service

import com.fragnostic.conf.props.service.support.BaseConfTest

class ConfPropsServiceGetLongTest extends BaseConfTest {

  describe("Conf Service Get Long Test") {

    it("Can Get Value As Long from Props") {

      val opt = CakeConfPropsService.confPropsServiceApi.getLong(props = this, key = keyPropsLong) fold (
        error => throw new IllegalStateException(error),
        opt => opt)

      opt should not be None
      opt.get should be(valuePropsLong)

    }

  }

}

