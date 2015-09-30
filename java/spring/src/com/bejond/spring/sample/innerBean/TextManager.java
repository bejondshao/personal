package com.bejond.spring.sample.innerBean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by bejond on 15-9-29.
 */
public class TextManager {
	private String _text;
	@Autowired
	private SpellChecker spellChecker;
public TextManager(){
	System.out.println("Inside TextManager Constructor.");
}
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
