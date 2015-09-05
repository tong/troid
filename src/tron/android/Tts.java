package tron.android;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.webkit.JavascriptInterface;
import java.util.Locale;

public class Tts implements TextToSpeech.OnInitListener {

	private TextToSpeech tts;
	//private boolean active;

	public Tts(Activity activity) {
		//active = false;
		tts = new TextToSpeech(activity, this);
	}

	public void onInit( int status ) {
		/*
		if( status == TextToSpeech.SUCCESS ) {
			int result = tts.setLanguage( Locale.ENGLISH );
			if( result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED ) {
				android.util.Log.e("TTS", "Language is not available.");
			} else {
				//active = true;
				android.util.Log.e("TTS", "TTS ACTIVE");
			}
		} else {
				android.util.Log.e("TTS", "TTS NOT ACTIVE");
			//active = false;
		}
		*/
	}

	@JavascriptInterface
	public boolean setLanguage( String lang ) {
		Locale locale = Locale.ENGLISH;
		if (lang == "ca")
			locale = Locale.CANADA;
		else if (lang == "ca_fr")
			locale = Locale.CANADA_FRENCH;
		else if (lang == "CHINA")
			locale = Locale.CHINA;
		else if (lang == "en")
			locale = Locale.ENGLISH;
		else if (lang == "fr")
			locale = Locale.FRANCE;
		else if (lang == "de")
			locale = Locale.GERMAN;
		else if (lang == "it")
			locale = Locale.ITALY;
		else if (lang == "jp")
			locale = Locale.JAPAN;
		else if (lang == "prc")
			locale = Locale.PRC;
		else if (lang == "ta")
			locale = Locale.TAIWAN;
		else if (lang == "uk")
			locale = Locale.UK;
		else if (lang == "us")
			locale = Locale.US;
		int result = tts.setLanguage(locale);
		if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
			return false;
		}
		return true;
	}

	@JavascriptInterface
	public void setPitch( float v ) {
		tts.setPitch(v);
	}

	@JavascriptInterface
	public void setSpeechRate( float v ) {
		tts.setSpeechRate(v);
	}

	@JavascriptInterface
	public void speak( String text ) {
		tts.speak( text, TextToSpeech.QUEUE_FLUSH, null );
	}

	@JavascriptInterface
	public void stop() {
		tts.stop();
	}

	@JavascriptInterface
	public void shutdown() {
		tts.stop();
		tts.shutdown();
	}

}
