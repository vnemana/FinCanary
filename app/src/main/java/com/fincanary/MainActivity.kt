package com.fincanary

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {
        // Do something in response to button
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun launchNewsArticles(view: View) {
        val intent = Intent(this, NewsArticleActivity::class.java).apply{}
        startActivity(intent)
    }

    fun mapButtonClickedHandler(view: View) {
        val locationText = findViewById<EditText>(R.id.locationText)
        val location = locationText.text.toString()
        location.replace(' ', '+', true)
        val uri = Uri.parse("geo:0,0?q=" + location)
        val mapIntent = Intent(Intent.ACTION_VIEW, uri)

        val activities = packageManager.queryIntentActivities(mapIntent, 0)
        if (activities.size > 0)
            startActivity(mapIntent)
    }
}
