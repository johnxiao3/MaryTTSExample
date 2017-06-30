package com.Marry;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;

import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.client.RemoteMaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;


public class Marry {
	Marry(){
		System.out.print("abc");
		MaryInterface marytts=null;
		AudioInputStream audio=null;
		try {
			marytts = new RemoteMaryInterface("mary.dfki.de",59125);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		marytts.setVoice("cmu-bdl-hsmm");
		try {
			 audio = marytts.generateAudio("Good morning.");
		} catch (SynthesisException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AudioPlayer player = new AudioPlayer(audio);
        player.start();
		System.out.print("abc");
		//MaryAudioUtils.writeWavFile(MaryAudioUtils.getSamplesAsDoubleArray(audio), "/tmp/thisIsMyText.wav", audio.getFormat());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Marry();
	}
}
