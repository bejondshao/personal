package com.bejond.spring.sample.innerBean;

/**
 * Created by bejond on 15-9-29.
 */
public class TextManager {
	private String _text;
	private SpellChecker spellChecker;

	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println("Set spellChecker");
		this.spellChecker = spellChecker;
	}

	public void checkSpell() {
		spellChecker.checkSpelling();
	}
}
