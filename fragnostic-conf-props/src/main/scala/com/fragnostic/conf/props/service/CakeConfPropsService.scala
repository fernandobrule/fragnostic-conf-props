package com.fragnostic.conf.props.service

import com.fragnostic.conf.props.service.api.ConfPropsServiceApi
import com.fragnostic.conf.props.service.impl.ConfPropsServiceImpl

object CakeConfPropsService {

  lazy val confPropsServicePiece: ConfPropsServiceApi = new ConfPropsServiceImpl {
  }

  val confPropsServiceApi = confPropsServicePiece.confPropsServiceApi

}
