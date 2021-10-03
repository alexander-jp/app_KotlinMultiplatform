package com.mundet.app_multiplatform.data.repository

import com.mundet.app_multiplatform.data.local.Local
import com.mundet.app_multiplatform.data.remote.Remote

class CommonPoiRepository(
    private val local: Local,
    private val remote: Remote
) : PoiRepository {



}