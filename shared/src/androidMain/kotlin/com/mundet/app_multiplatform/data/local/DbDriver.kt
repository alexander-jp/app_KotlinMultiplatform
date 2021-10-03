package com.mundet.app_multiplatform.data.local

import android.content.Context
import com.mundet.app_multiplatform.pois
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DbDriver (private val context : Context) {
    actual fun get(): SqlDriver = AndroidSqliteDriver(
        schema = pois.Schema,
        context = context,
        name = "db"
    )
}