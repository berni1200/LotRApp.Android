package hu.bme.aut.android.lotrappandroid.analytics

import android.app.Application
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.Tracker
import hu.bme.aut.android.lotrappandroid.R


open class AnalyticsApplication : Application() {
    private var sAnalytics: GoogleAnalytics? = null
    private var sTracker: Tracker? = null

    override fun onCreate() {
        super.onCreate()
        sAnalytics = GoogleAnalytics.getInstance(this)
    }

    @Synchronized
    fun getDefaultTracker(): Tracker? {
        if (sTracker == null) {
            sTracker = sAnalytics?.newTracker(R.xml.global_tracker)
        }
        return sTracker
    }
}