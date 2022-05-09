package hu.bme.aut.android.lotrappandroid

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import hu.bme.aut.android.lotrappandroid.analytics.AnalyticsApplication

@HiltAndroidApp
class LotRApp :AnalyticsApplication()