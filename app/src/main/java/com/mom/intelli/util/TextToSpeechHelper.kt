package com.mom.intelli.util
import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.*

class TextToSpeechHelper(context: Context) : TextToSpeech.OnInitListener {

    private val tts: TextToSpeech = TextToSpeech(context, this, "TextToSpeech.Engine.DEFAULT")

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            // TTS is successfully initialized
            val result = tts.setLanguage(Locale.ENGLISH)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Language data is missing or not supported
                // Handle this case if needed
            }
        } else {
            // TTS initialization failed
            // Handle this case if needed
        }
    }

    fun speak(text: String) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    fun shutdown() {
        tts.shutdown()
    }
}